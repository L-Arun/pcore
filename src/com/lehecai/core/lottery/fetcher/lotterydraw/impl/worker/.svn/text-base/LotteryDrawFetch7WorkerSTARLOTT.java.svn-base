package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.CssSelectorNodeFilter;
import org.htmlparser.filters.TagNameFilter;
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

public class LotteryDrawFetch7WorkerSTARLOTT extends CountryLotteryDrawFetchWorkerSTARLOTT{
	
	protected LotteryDrawFetch7WorkerSTARLOTT(LotteryType lotteryType) {
		super(lotteryType);
	}
	
	public LotteryDrawFetch7WorkerSTARLOTT(){
		super(LotteryType.SFC);
		this.lotteryMiddleKeyValue=LotteryType.SFC.getName();
	}
	//开奖结果解析不一致,需override
	@Override
	public LotteryDraw fetchResult(String phase) {
		LotteryType lotteryType = this.getLotteryType();
		
		String url = RESULT_URL;
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
			for(int i=1;i<tableRows.length;i++){
				tableRowColumns=tableRows[i].getColumns();
				if(tableRowColumns.length>2){
					String detailLink=tableRowColumns[0].getStringText().split("href=\"")[1].split("/\"")[0];
					String lotteryName=tableRowColumns[0].getStringText().split(">")[1].split("<")[0].trim();
					String lotteryPhase = null;//页面抓取的彩期号
					//判断是否是所抓类型
					if(getLotteryType().getValue() == FetcherLotteryTypeMap.getLotteryValueByKey(FetcherType.T_STARLOTT.getName()+lotteryMiddleKeyValue+lotteryName)){
						lotteryPhase=tableRowColumns[1].getStringText().trim().split("期")[0];
						if(lotteryPhase==null){
							logger.error(logHeader+"页面抓取的彩期号({})不存在,返回null==",lotteryPhase);
							return null;
						}
						//处理列表页面抓取的彩期
						//指定彩期为null，抓取列表页面的彩期数据
						if(phase==null||phase.isEmpty()){
							phase = lotteryPhase;
							//当前期可写入详细url，以便抓取对应的详细信息
							this.setLotteryDetailUrl(lotteryType, detailLink);
						}else{
							if(lotteryPhase.equals(phase)){
								phase = lotteryPhase;
							}else{
								logger.error(logHeader+"指定抓取的彩期号({})与页面抓取的彩期号({})不一致,返回null==",phase,lotteryPhase);
								return null;
							}
						}
						String timeDraw = tableRowColumns[2].getStringText();
						//开奖结果
						String columnTmp = tableRowColumns[3].getStringText().trim();
						NodeFilter subFilter = new CssSelectorNodeFilter("div[class='zckjnum']");
						NodeList subNodeList = null;
						Parser subParser = null;
						StringBuffer openPrizeCodeSb = new StringBuffer();
						String result = null;
						try {
							subParser = Parser.createParser(columnTmp, "utf-8");
							subNodeList = subParser.extractAllNodesThatMatch(subFilter);
							Node[] subNode = subNodeList.toNodeArray();
							if(subNode!=null&&subNode.length>0){
								openPrizeCodeSb.append(subNode[0].toPlainTextString().trim());
							}
							result = openPrizeCodeSb.toString();
							result = result.replaceAll(" ", ",");
							if(result.isEmpty()){
								logger.error(logHeader+"解析开奖结果为空,返回null==");
								return null;
							}
							logger.info(logHeader+"解析开奖结果:"+result);
						} catch (ParserException e3){
							logger.error(e3.getMessage(), e3);
						}
						//奖池有可能不存在
						String jackpot = null;
						if(tableRowColumns!=null&&tableRowColumns.length>=5){
							jackpot = tableRowColumns[4].toPlainTextString().trim();
							if(jackpot.indexOf("元")>0&&jackpot.indexOf("奖池:")>0){
								jackpot = tableRowColumns[3].toPlainTextString().trim().split("元")[0].split("奖池:")[1].replaceAll(",", "");
							}else{
								jackpot=null;
							}
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
}
