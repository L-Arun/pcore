package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.util.HashMap;
import java.util.Map;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
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
import com.lehecai.core.util.CoreFetcherUtils;

/**
 * 地方开奖页面星彩网通用抓取结果
 * @author leiming
 *
 */
public class LocalityLotteryDrawFetchWorkerSTARLOTT extends AbstractLotteryDrawFetchWorker{
	
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

	
	public LocalityLotteryDrawFetchWorkerSTARLOTT(LotteryType lotteryType) {
		super(lotteryType);
	}

	protected String siteName = "星彩网";
	protected String lotteryScope = "地方开奖";
	protected String lotteryMiddleKeyValue = "";//特殊情况用以区分页面同名不同的彩种,如胜负彩任九
	
	private static final String BASE_URL = "http://kj.starlott.com";
	protected static final String RESULT_LOCALITY_URL = "http://kj.starlott.com/df/index.html";
	
	@Override
	public LotteryDraw fetchResult(String phase) {
		LotteryType lotteryType = this.getLotteryType();
		
		String url = RESULT_LOCALITY_URL;
		String pageInfo = "列表页面"+url;
		String logHeader = "=="+lotteryScope+"=="+siteName+"=="+pageInfo+"==抓取=="+getLotteryType().getName()+"==";
		logger.info(logHeader+"开始==");
		LotteryDraw lotteryDraw = null;
		String encoding = "utf-8";
		
		String data = null;
		Parser parser = null;

		
		data = CoreFetcherUtils.URLGet(url, null, encoding);
		
		if (data == null || data.indexOf("404 Not Found") > 0) {
			logger.error(logHeader+"data is null or 404 Not Found");
			return null;
		}
		parser = Parser.createParser(data, encoding);
		
		String filterStr = "table";
		NodeFilter filter = new TagNameFilter(filterStr);
		NodeList nodeList = null;

		try {
			nodeList = parser.extractAllNodesThatMatch(filter);
		} catch (ParserException e2) {
			logger.error(logHeader+"数据解析错误=="+e2.getMessage(), e2);
			return null;
		}
		try{
			TableTag tableTag = (TableTag)nodeList.elementAt(0);
			TableRow[] tableRows=tableTag.getRows();
			TableColumn[] tableRowColumns = null;
			String tmpNameHeader = "";
			String detailLink = null;
			String lotteryName = null;
			String lotteryPhase = null;//页面抓取的彩期号
			int startIndex = 0;
			for(int i=1;i<tableRows.length;i++){
				tableRowColumns=tableRows[i].getColumns();
				if(tableRowColumns.length==4){
					tmpNameHeader = tableRowColumns[0].getStringText().trim();
					startIndex = 1;
					/*
					detailLink=tableRowColumns[startIndex].getStringText().split("href=\"")[1].split("\"")[0];
					lotteryName=tableRowColumns[startIndex].getStringText().split(">")[1].split("<")[0].trim();
					*/
				}else if(tableRowColumns.length==3){
					startIndex = 0;
					/*
					detailLink=tableRowColumns[startIndex].getStringText().split("href=\"")[1].split("\"")[0];
					lotteryName=tableRowColumns[startIndex].getStringText().split(">")[1].split("<")[0].trim();
					*/
				}
				//获取含有链接td的对应href和text
				NodeList childList = tableRowColumns[startIndex].getChildren();
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
				if(getLotteryType().getValue()==FetcherLotteryTypeMap.getLotteryValueByKey(FetcherType.T_STARLOTT.getName()+lotteryMiddleKeyValue+tmpNameHeader+lotteryName)){
					lotteryPhase=tableRowColumns[startIndex+1].toPlainTextString().trim();
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
					String timeDraw = "";//地方列表页面无时间
					String columnTmp = tableRowColumns[startIndex+2].toHtml();
					String[] resultArray = CoreFetcherUtils.getLiDataByHtml(columnTmp, encoding);
					
					String result = CoreFetcherUtils.mergeStringArray(resultArray, ",");
					logger.info(logHeader+"解析开奖结果为:"+result);
					String jackpot = null;//地方列表页面无奖池
					
					lotteryDraw = new LotteryDraw();
					lotteryDraw.setPhase(lotteryPhase);
					lotteryDraw.setResult(result);
					//格式化时间串
					lotteryDraw.setTimeDraw(CoreFetcherUtils.formatTimeDraw(timeDraw));
					lotteryDraw.setJackpot(jackpot);
					lotteryDraw.setLotteryType(getLotteryType());
					
					logger.info(logHeader+lotteryDraw.getLotteryOpenResultLogMsg());
					break;
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
		String logHeader = "=="+lotteryScope+"=="+siteName+"=="+pageInfo+"==抓取=="+getLotteryType().getName()+"==";
		LotteryDraw lotteryDraw=null;
		String encoding = "utf-8";
		String data = null;
		Parser parser = null;
		
		logger.info(logHeader+"开始==");
		data = CoreFetcherUtils.URLGet(url, null, encoding);
		parser = Parser.createParser(data, encoding);
		
		String filterStr = "table";
		NodeFilter filter = new TagNameFilter(filterStr);
		NodeList nodeList = null;
		try {
			nodeList = parser.extractAllNodesThatMatch(filter);
		} catch (ParserException e2) {
			logger.error(logHeader+"数据解析错误=="+e2.getMessage(), e2);
		}
		try{
			TableTag tableTag = (TableTag)nodeList.elementAt(0);
			lotteryDraw = CoreFetcherUtils.getLotteryDrawByStarLottHistoryTable(tableTag, logHeader, encoding, getLotteryType());
			logger.info(logHeader+lotteryDraw.getLotteryOpenResultLogMsg());
		}catch(Exception e1){
			logger.error(logHeader+"页面错误=="+e1.getMessage(),e1);
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
