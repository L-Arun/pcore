package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.util.CoreFetcherUtils;
/**
 * 超级大乐透 星彩网 抓取worker
 * @author leiming
 *
 */
public class LotteryDrawFetch1WorkerSTARLOTT extends CountryLotteryDrawFetchWorkerSTARLOTT{
	
	public LotteryDrawFetch1WorkerSTARLOTT(){
		super(LotteryType.DLT);
		this.lotteryMiddleKeyValue = "";
	}
	
	//超级大乐透详细页面采用特殊抓取方式,与星彩地方抓取详细页面方式相同
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
			return null;
		}
		try{
			TableTag tableTag = (TableTag)nodeList.elementAt(0);
			lotteryDraw = CoreFetcherUtils.getLotteryDrawByStarLottHistoryTable(tableTag, logHeader, encoding, getLotteryType());
			logger.info(logHeader+lotteryDraw.getLotteryOpenResultLogMsg());
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
	protected String getResultDetailUrl(String phase) {
		if (phase == null || phase.trim().length() == 0) {
			return "http://kj.starlott.com/kj/detail.do?code=SHTCDLT";
		}
		return null;
	}
}
