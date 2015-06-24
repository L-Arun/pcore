/**
 * 
 */
package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.htmlparser.NodeFilter;
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
 * 全国开奖页面500万通用抓取实现类
 * @author Sunshow
 *
 */
public class CountryLotteryDrawFetchWorker500Wan extends AbstractLotteryDrawFetchWorker {
	
	private static Map<LotteryType, String> defaultUrlMap = new HashMap<LotteryType, String>();
	private static Map<LotteryType, String> historyUrlMap = new HashMap<LotteryType, String>();
	
	static {
		//"31选7", 542
		defaultUrlMap.put(LotteryType.A_31x7, "http://kaijiang.500wan.com/syxq.shtml");
		historyUrlMap.put(LotteryType.A_31x7, "http://kaijiang.500wan.com/shtml/syxq/%s.shtml");
		//七星彩
		defaultUrlMap.put(LotteryType.QXC, "http://kaijiang.500wan.com/qxc.shtml");
		historyUrlMap.put(LotteryType.QXC, "http://kaijiang.500wan.com/shtml/qxc/%s.shtml");
		//七乐彩
		defaultUrlMap.put(LotteryType.QLC, "http://kaijiang.500wan.com/qlc.shtml");
		historyUrlMap.put(LotteryType.QLC, "http://kaijiang.500wan.com/shtml/qlc/%s.shtml");
		//福彩3D
		defaultUrlMap.put(LotteryType.FC3D, "http://kaijiang.500wan.com/sd.shtml");
		historyUrlMap.put(LotteryType.FC3D, "http://kaijiang.500wan.com/shtml/sd/%s.shtml");
		//超级大乐透
		defaultUrlMap.put(LotteryType.DLT, "http://kaijiang.500wan.com/dlt.shtml");
		historyUrlMap.put(LotteryType.DLT, "http://kaijiang.500wan.com/shtml/dlt/%s.shtml");
		//15选5
		defaultUrlMap.put(LotteryType.HD15X5, "http://kaijiang.500wan.com/hdswxw.shtml");
		historyUrlMap.put(LotteryType.HD15X5, "http://kaijiang.500wan.com/shtml/hdswxw/%s.shtml");
		//东方6+1
		defaultUrlMap.put(LotteryType.DF6J1, "http://kaijiang.500wan.com/df6j1.shtml");
		historyUrlMap.put(LotteryType.DF6J1, "http://kaijiang.500wan.com/shtml/df6j1/%s.shtml");
		//双色球
		defaultUrlMap.put(LotteryType.SSQ, "http://kaijiang.500wan.com/shtml/ssq/");
		historyUrlMap.put(LotteryType.SSQ, "http://kaijiang.500wan.com/shtml/ssq/%s.shtml");
		//排列5
		defaultUrlMap.put(LotteryType.PL5, "http://kaijiang.500wan.com/plw.shtml");
		historyUrlMap.put(LotteryType.PL5, "http://kaijiang.500wan.com/shtml/plw/%s.shtml");
		//排列3
		defaultUrlMap.put(LotteryType.PL3, "http://kaijiang.500wan.com/pls.shtml");
		historyUrlMap.put(LotteryType.PL3, "http://kaijiang.500wan.com/shtml/pls/%s.shtml");
		//胜负彩
		defaultUrlMap.put(LotteryType.SFC, "http://kaijiang.500wan.com/sfc.shtml");
		historyUrlMap.put(LotteryType.SFC, "http://kaijiang.500wan.com/shtml/sfc/%s.shtml");
		//胜负任九
		defaultUrlMap.put(LotteryType.SFR9, "http://kaijiang.500wan.com/sfc.shtml");
		historyUrlMap.put(LotteryType.SFR9, "http://kaijiang.500wan.com/shtml/sfc/%s.shtml");
		//4场进球
		defaultUrlMap.put(LotteryType.JQC, "http://kaijiang.500wan.com/jq4.shtml");
		historyUrlMap.put(LotteryType.JQC, "http://kaijiang.500wan.com/shtml/jq4/%s.shtml");
		//6场半全场
		defaultUrlMap.put(LotteryType.BQC, "http://kaijiang.500wan.com/zc6.shtml");
		historyUrlMap.put(LotteryType.BQC, "http://kaijiang.500wan.com/shtml/zc6/%s.shtml");
		//22选5
		defaultUrlMap.put(LotteryType.TC22X5, "http://kaijiang.500wan.com/shtml/eexw/");
		historyUrlMap.put(LotteryType.TC22X5, "http://kaijiang.500wan.com/shtml/eexw/%s.shtml");
	}
	
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
	protected String lotteryScope = "全国开奖";
	protected String volumeOfSalesName = "本期销量：";
	protected String jackpotName = "奖池滚存：";
	protected String lotteryMiddleKeyValue = "";//特殊情况用以区分页面同名不同的彩种,如胜负彩任九
	//开奖结果所在行号 0为第一行
	protected int resultRowNumber = 1;
	protected int volumeOfSalesRowNumber = 2;
	
	private static final String BASE_URL = "http://kaijiang.500wan.com/";
	private static final String RESULT_URL = "http://kaijiang.500wan.com/";
	
	public CountryLotteryDrawFetchWorker500Wan(LotteryType lotteryType) {
		super(lotteryType);
	}
	
	@Override
	public LotteryDraw fetchResult(String phase) {
		LotteryType lotteryType = this.getLotteryType();
		String url = RESULT_URL;
		String pageInfo = "列表页面"+url;
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
		parser= Parser.createParser(data,  encoding);
		
		//String filterName = "table";
		//NodeFilter tableFilter = new TagNameFilter(filterName);
		NodeFilter cssFilter = new CssSelectorNodeFilter("table[class='kj_tablelist01']");
		NodeList nodeList = null;
		try {
			nodeList = parser.extractAllNodesThatMatch(cssFilter);
		} catch (ParserException e2){
			logger.error(logHeader+"数据解析错误=="+e2.getMessage(), e2);
			return null;
		}
		try{
			TableTag tableTag = (TableTag)nodeList.elementAt(0);
			TableRow[] rowsPhase=tableTag.getRows();
			TableColumn[] columnPhase = null;
			for(int i=1;i<rowsPhase.length;i++){
				columnPhase=rowsPhase[i].getColumns();
				if(columnPhase.length>4){
					String detailLink = null;
					String lotteryName = null;
					/*old method delete by lm 2010-10-11
					detailLink=columnPhase[0].getStringText().split("href=")[1].split("\\.")[0];
					detailLink=detailLink.substring(1,detailLink.length());
					lotteryName=columnPhase[0].getStringText().split(">")[1].split("<")[0];
					*/
					//获取含有链接td的对应href和text
					NodeList childList = columnPhase[0].getChildren();
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
					//判断是否是所抓类型
					if(getLotteryType().getValue() == FetcherLotteryTypeMap.getLotteryValueByKey(FetcherType.T_500WAN.getName()+lotteryMiddleKeyValue+lotteryName)){
						String lotteryPhase=columnPhase[1].getStringText().trim().split("期")[0];
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
						String timeDraw = columnPhase[2].getStringText();
						String result = null;
						//note by lm indexOf和split对获取子串有区别
						if(columnPhase[3].getStringText().trim().indexOf("','")!=-1&&columnPhase[3].getStringText().trim().split("\\'\\,\\'")[1].indexOf("')")!=-1){
							result=columnPhase[3].getStringText().trim().split("\\'\\,\\'")[1].split("\\'\\)")[0];
						}
						if(result==null){
							logger.error(logHeader+"页面开奖结果(html内容:"+columnPhase[3].toHtml()+")信息不存在或有错误,返回null");
							return null;
						}
						String jackpot = null;
						if(columnPhase[4].getStringText().trim().indexOf("','")!=-1&&columnPhase[4].getStringText().trim().split("\\'\\,\\'")[1].indexOf("')")!=-1){
							jackpot=columnPhase[4].getStringText().trim().split("\\'\\,\\'")[1].split("\\'\\)")[0];
						}
						if(result!=null&&(-1!=result.indexOf("|"))){
							result=result.replace("|", ",");
						}
						if(result!=null&&result.trim().length()>0&&(result.length()-1==result.lastIndexOf(","))){
							result=result.substring(0,result.length()-1);
						}
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
		}catch(Exception e1){
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
						if(resultArray!=null){
							StringBuffer resultSb = new StringBuffer();
							for(int k=0;k<resultArray.length;k++){
								resultSb.append(resultArray[k].trim());
								if(k<(resultArray.length-1)){
									resultSb.append(",");
								}
							}
							result = resultSb.toString();
							logger.info(logHeader+"解析开奖结果为:"+result);
						}else{
							logger.error(logHeader+"解析开奖结果不存在，未取到开奖结果==");
							return null;
						}
					}else{
						logger.error(logHeader+"解析开奖结果发生错误，未取到开奖结果==");
						return null;
					}
				}
				//第三行 销量 奖池
				if(i==volumeOfSalesRowNumber){
					tableColumnData = titleTableColumns[0].toPlainTextString();
					if (-1 != data.indexOf(volumeOfSalesName)) {
						volumeOfSales = data.split(volumeOfSalesName)[1].split("元")[0].split(">")[1];
						volumeOfSales = volumeOfSales.replaceAll(",", "");
					} else {
						volumeOfSales="0";
					}
					if (-1 != data.indexOf(jackpotName)) {
						jackpot = data.split(jackpotName)[1].split("元")[0].split(">")[1];
						jackpot = jackpot.replaceAll(",", "");
					} else {
						jackpot="0";
					}
				}
			}
		}
		
		//抓取开奖详情
		TableTag tableTag=new TableTag();
		tableTag=(TableTag) nodeListf.elementAt(1);
		if (null != tableTag) {
			List<LotteryDrawPrizeItem> resultDetail = null;;
			resultDetail = CoreFetcherUtils.get500WanResultDetailByTable(tableTag, 3);
			logger.info(logHeader+"解析开奖详情:"+resultDetail);
			
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
		String url = this.getLotteryDetailUrl(this.getLotteryType());
		if (url != null) {
			return url;
		}
		if (phase != null && phase.trim().length() > 0) {
			return String.format(historyUrlMap.get(this.getLotteryType()), phase);
		}
		return defaultUrlMap.get(this.getLotteryType());
	}

	@Override
	protected String getResultUrl(String phase) {
		return null;
	}
}
