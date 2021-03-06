package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.htmlparser.Parser;
import org.htmlparser.filters.CssSelectorNodeFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherLotteryTypeMap;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDrawPrizeItem;
import com.lehecai.core.util.CoreFetcherUtils;

/**
 * 地方开奖页面500Wan通用抓取结果
 * @author leiming
 *
 */
public class LocalityLotteryDrawFetchWorker500Wan extends AbstractLotteryDrawFetchWorker{
	
	private static Map<LotteryType, String> lotteryDetailUrlMap = new HashMap<LotteryType, String>();
	
	protected void setLotteryDetailUrl(LotteryType lotteryType, String url) {
		synchronized (this) {
			lotteryDetailUrlMap.put(lotteryType, url);
		}
	}
	
	protected String getLotteryDetailUrl(LotteryType lotteryType) {
		synchronized (this) {
			return lotteryDetailUrlMap.get(lotteryType);
		}
	}

	protected String siteName = "500wan";
	protected String lotteryScope = "地方开奖";
	protected String lotteryMiddleKeyValue = "";//特殊情况用以区分页面同名不同的彩种,如胜负彩任九
	//开奖结果所在行号  0为第一行
	protected int resultRowNumber = 1;
	protected int volumeOfSalesRowNumber = 2;
	
	private static final String BASE_URL = "http://kaijiang.500wan.com/";
	private static final String RESULT_LOCALITY_URL = "http://kaijiang.500wan.com/index2.shtml";
	
	public LocalityLotteryDrawFetchWorker500Wan(LotteryType lotteryType){
		super(lotteryType);
	}
	
	@Override
	public LotteryDraw fetchResult(String phase) {
		LotteryType lotteryType = this.getLotteryType();
		
		String url = RESULT_LOCALITY_URL;
		String pageInfo = "列表页面"+url;
		String encoding = "GBK";
		String logHeader = "=="+lotteryScope+"=="+siteName+"=="+pageInfo+"==抓取=="+lotteryType.getName()+"==";
		logger.info(logHeader+"开始==");
		
		LotteryDraw lotteryDraw=null;
		String data=null;
		Parser parser=null;
		
		data = CoreFetcherUtils.URLGet(url, null, encoding);
		if (data == null || data.indexOf("404 Not Found") > 0) {
			logger.error(logHeader+"data is null or 404 Not Found");
			return null;
		}
		parser= Parser.createParser(data,  encoding);
		
		NodeList nodeList = null;
		try {
			nodeList = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("table[class='kj_tablelist01'] tr"));
		} catch (ParserException e2) {
			logger.error(logHeader+ "连接错误==",e2);
			return null;
		}
		try {
			String tmpNameHeader = "";
			for (int i = 1; i < nodeList.size(); i++) {
				TableRow noderTable = (TableRow) nodeList.elementAt(i);
				TableColumn[] columnsNoderTable = noderTable.getColumns();
				String detailLink = null;
				String lotteryName = null;
				String lotteryPhase = null;//页面抓取的彩期号
				int startIndex = 0;
				if (8 == columnsNoderTable.length) {
					tmpNameHeader = columnsNoderTable[0].getStringText().trim();
					startIndex = 1;
				}else if(7 == columnsNoderTable.length){
					startIndex = 0;
				}
				//获取含有链接td的对应href和text
				NodeList childList = columnsNoderTable[startIndex].getChildren();
				LinkTag linkNode = null;
				if(childList!=null&&childList.size()>0){
					for(int m = 0;m<childList.size();m++){
						if(childList.elementAt(m) instanceof LinkTag){
							linkNode = (LinkTag)childList.elementAt(m);
							detailLink = linkNode.getLink().trim();
							lotteryName = linkNode.getLinkText().trim();
						}
					}
				}
				/*old method delete by lm 2010-10-11
				lotteryName = columnsNoderTable[startIndex].getStringText().split(">")[1].split("<")[0].trim();
				*/
				if (getLotteryType().getValue()==FetcherLotteryTypeMap.getLotteryValueByKey(FetcherType.T_500WAN.getName()+lotteryMiddleKeyValue+tmpNameHeader+lotteryName)) {
					//href开头
					if (-1 != columnsNoderTable[startIndex].getStringText().indexOf("href=")) {
						/* old method
						detailLink = columnsNoderTable[startIndex].getStringText().split("href=")[1].split("\\.")[0];
						detailLink = detailLink.substring(1, detailLink.length());
						*/
						lotteryPhase = columnsNoderTable[startIndex+1].getStringText().trim().split("期")[0];
						if(lotteryPhase==null){
							logger.error(logHeader+"页面抓取的彩期号({})不存在,返回null==",lotteryPhase);
							return null;
						}
						//处理列表页面抓取的彩期
						//指定彩期为null，抓取列表页面的彩期数据
						if(phase==null||phase.isEmpty()){
							phase = lotteryPhase;
							//当前期可写入详细url，以便抓取对应的详细信息
							this.setLotteryDetailUrl(lotteryType, BASE_URL + detailLink);
						}else{
							if(lotteryPhase.equals(phase)){
								phase = lotteryPhase;
							}else{
								logger.error(logHeader+"指定抓取的彩期号({})与页面抓取的彩期号({})不一致,返回null==",phase,lotteryPhase);
								return null;
							}
						}
						String timeDraw = columnsNoderTable[startIndex+2].getStringText();
						
						String result = null;
						if(columnsNoderTable[startIndex+3].getStringText().trim().indexOf("','")!=-1&&columnsNoderTable[startIndex+3].getStringText().trim().split("\\'\\,\\'")[1].indexOf("')")!=-1){
							result=columnsNoderTable[startIndex+3].getStringText().trim().split("\\'\\,\\'")[1].split("\\'\\)")[0];
						}
						if(result==null){
							logger.error(logHeader+"页面开奖结果(html内容:"+columnsNoderTable[startIndex+3].toHtml()+")信息不存在或有错误,返回null");
							return null;
						}
						String jackpot = null;
						if(columnsNoderTable[startIndex+4].getStringText().trim().indexOf("','")!=-1&&columnsNoderTable[startIndex+4].getStringText().trim().split("\\'\\,\\'")[1].indexOf("')")!=-1){
							jackpot=columnsNoderTable[startIndex+4].getStringText().trim().split("\\'\\,\\'")[1].split("\\'\\)")[0];
						}
						if(result!=null&&(-1!=result.indexOf("|"))){
							result=result.replace("|", ",");
						}
						if(result!=null&&result.trim().length()>0&&(result.length()-1==result.lastIndexOf(","))){
							result=result.substring(0,result.length()-1);
						}
						/* delete by lm 防止空指针
						String result = columnsNoderTable[startIndex+3].getStringText().trim().split("\\'\\,\\'")[1].split("\\'\\)")[0];
						String jackpot = columnsNoderTable[startIndex+4].getStringText().trim().split("\\'\\,\\'")[1].split("\\'\\)")[0];
						
						if (-1 != result.indexOf("|")) {
							result = result.replace("|", ",");
						}
						if (result.length() - 1 == result.lastIndexOf(",")) {
							result = result.substring(0,result.length() - 1);
						}*/
						
						lotteryDraw = new LotteryDraw();
						lotteryDraw.setPhase(phase);
						lotteryDraw.setResult(result);
						//格式化时间串
						lotteryDraw.setTimeDraw(CoreFetcherUtils.formatTimeDraw(timeDraw));
						lotteryDraw.setJackpot(jackpot);
						lotteryDraw.setLotteryType(getLotteryType());
						
						logger.info(logHeader+lotteryDraw.getLotteryOpenResultLogMsg());
						break;
					}
				}
			}//end for
		} catch (Exception e1) {
			logger.error(logHeader+"页面错误=="+e1.getMessage(),e1);
			return null;
		}
		if(lotteryDraw==null){
			logger.info(logHeader+"未抓取到相关开奖结果信息,返回null==");
		}
		logger.info(logHeader+"结束==");
		return lotteryDraw;
	}

	@Override
	public LotteryDraw fetchResultDetail(String phase) {
		String url = this.getResultDetailUrl(phase);
		if(url==null||url.isEmpty()){
			logger.error("=="+lotteryScope+"=="+siteName+"==详细页面==抓取=="+getLotteryType().getName()+"==期号："+phase+"==详细地址不存在，返回null");
			return null;
		}
		String pageInfo = "详细页面"+url;
		String encoding = "GBK";
		String logHeader = "=="+lotteryScope+"=="+siteName+"=="+pageInfo+"==抓取=="+getLotteryType().getName()+"==";
		
		logger.info(logHeader+"开始==");
		LotteryDraw lotteryDraw=null;
		
		String data=null;
		Parser parser=null;
		
		data = CoreFetcherUtils.URLGet(url, null, encoding);
		if (data == null || data.indexOf("404 Not Found") > 0) {
			logger.error(logHeader+"data is null or 404 Not Found");
			return null;
		}
		parser= Parser.createParser(data, encoding);
		
	    NodeList nodeListf = null;
		try {
			nodeListf = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("table[class='kj_tablelist02']"));
		} catch (Exception e2) {
			logger.error(logHeader+"数据解析错误=="+e2.getMessage(), e2);
			return null;
		}
		//抓期数,彩票名称,开奖时间,开奖结果,销量,奖池
		//String lotteryName = null;
		String lotteryPhase = null;
		String timeDraw = null;
		String result = null;
		String volumeOfSales=null;
		String jackpot=null;
		String tableColumnData = null;
		TableTag titleTableTag = new TableTag();
		titleTableTag = (TableTag) nodeListf.elementAt(0);
		if(titleTableTag!=null){
			TableRow[] titleTableRows=titleTableTag.getRows();
			TableColumn[] titleTableColumns = null;
			for(int i=0;i<titleTableRows.length;i++){
				titleTableColumns=titleTableRows[i].getColumns();
				//第一行 彩期，彩票名称，开奖时间
				if(i==0){
					//彩期，彩票名称,开奖时间
					tableColumnData = titleTableColumns[0].toPlainTextString();
					String[] parserInfo = CoreFetcherUtils.parser500WanDrawInfo(tableColumnData, logHeader, phase);
					if(parserInfo==null){
						logger.error(logHeader+"解析彩票基本信息(名称,期号,开奖时间)不存在，返回null==");
						return null;
					}else{
						//lotteryName = parserInfo[0];
						lotteryPhase = parserInfo[1];
						timeDraw = parserInfo[2];
					}
				}
				//第二行 开奖结果
				if(i==resultRowNumber){
					tableColumnData = titleTableColumns[0].toHtml();
					String[] subColumns = CoreFetcherUtils.getContentFromTableRow(tableColumnData, 0, 0, encoding,0);
					if(subColumns!=null&&subColumns.length>1){
						result = subColumns[1];
						String[] resultArray = CoreFetcherUtils.getLiDataByHtml(result,encoding);
						result = CoreFetcherUtils.mergeStringArray(resultArray, ",");
						if(result==null){
							logger.error(logHeader+"解析开奖结果不存在，未取到开奖结果==");
							return null;
						}else{
							logger.info(logHeader+"解析开奖结果为:"+result);
						}
					}else{
						logger.error(logHeader+"解析开奖结果发生错误，未取到开奖结果==");
						return null;
					}
				}
				//第三行 销量 奖池
				if(i==volumeOfSalesRowNumber){
					tableColumnData = titleTableColumns[0].toPlainTextString();
					if (-1 != data.indexOf("本期销量：")) {
						volumeOfSales = data.split("本期销量：")[1].split("元")[0].split(">")[1];
						volumeOfSales = volumeOfSales.replaceAll(",", "");
					} else {
						volumeOfSales=null;
					}
					if (-1 != data.indexOf("奖池滚存：")) {
						jackpot = data.split("奖池滚存：")[1].split("元")[0].split(">")[1];
						jackpot = jackpot.replaceAll(",", "");
					} else {
						jackpot=null;
					}
				}
			}
		}
		
		//抓取开奖详情
		TableTag tableTag=new TableTag();
		tableTag=(TableTag) nodeListf.elementAt(1);
		if (null != tableTag) {
			List<LotteryDrawPrizeItem> resultDetail = null;
			resultDetail = CoreFetcherUtils.get500WanResultDetailByTable(tableTag, 2);
			logger.info(logHeader+"解析开奖详情:"+LotteryDrawPrizeItem.listDataInfo(resultDetail));
			
			lotteryDraw = new LotteryDraw();
			lotteryDraw.setPhase(lotteryPhase);
			lotteryDraw.setResult(result);
			lotteryDraw.setTimeDraw(CoreFetcherUtils.formatTimeDraw(timeDraw));
			lotteryDraw.setJackpot(jackpot);
			lotteryDraw.setVolumeOfSales(volumeOfSales);
			lotteryDraw.setLotteryType(getLotteryType());
			lotteryDraw.setResultDetail(resultDetail);
			
			logger.info(logHeader+lotteryDraw.getLotteryOpenResultLogMsg());
		}else{
			logger.error(logHeader+"页面开奖详情数据不存在");
		}
		if(lotteryDraw==null){
			logger.info(logHeader+"未抓取到相关开奖结果信息,返回null==");
		}
		logger.info(logHeader+"结束==");
		return lotteryDraw;
	}

	@Override
	protected String getResultDetailUrl(String phase) {
		if (phase != null && phase.trim().length() > 0) {
			// TODO
			return null;
		}
		return this.getLotteryDetailUrl(this.getLotteryType());
	}

	@Override
	protected String getResultUrl(String phase) {
		return null;
	}
}
