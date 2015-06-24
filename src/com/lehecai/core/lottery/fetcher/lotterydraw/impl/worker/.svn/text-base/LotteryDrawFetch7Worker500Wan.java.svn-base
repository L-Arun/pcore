package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.util.List;

import org.htmlparser.Parser;
import org.htmlparser.filters.CssSelectorNodeFilter;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDrawPrizeItem;
import com.lehecai.core.util.CoreFetcherUtils;

public class LotteryDrawFetch7Worker500Wan extends CountryLotteryDrawFetchWorker500Wan{
	//protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	protected LotteryDrawFetch7Worker500Wan(LotteryType lotteryType) {
		super(lotteryType);
	}
	
	public LotteryDrawFetch7Worker500Wan(){
		super(LotteryType.SFC);
		this.volumeOfSalesName = "本期胜负彩销量：";
		this.jackpotName = "奖池滚存：";
		this.lotteryMiddleKeyValue=LotteryType.SFC.getName();
		this.resultRowNumber = 2;
		this.volumeOfSalesRowNumber = 3;
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
					//彩期，彩票名称
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
				//第三行 开奖结果
				if(i==resultRowNumber){
					StringBuffer resultSb = new StringBuffer("");
					for(int k=0;k<titleTableColumns.length;k++){
						resultSb.append(titleTableColumns[k].toPlainTextString().trim());
						if(k<(titleTableColumns.length-1)){
							resultSb.append(",");
						}
					}
					result = resultSb.toString();
					logger.info(logHeader+"解析开奖结果为:"+result);
				}
				//第四行 销量 奖池
				if(i==volumeOfSalesRowNumber){
					tableColumnData = titleTableColumns[0].toPlainTextString();
					if (-1 != data.indexOf(volumeOfSalesName)) {
						volumeOfSales = data.split(volumeOfSalesName)[1].split("元")[0].split(">")[1];
						volumeOfSales = volumeOfSales.replaceAll(",", "");
					} else {
						volumeOfSales=null;
					}
					if (-1 != data.indexOf(jackpotName)) {
						jackpot = data.split(jackpotName)[1].split("元")[0].split(">")[1];
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
		}
		if(lotteryDraw==null){
			logger.info(logHeader+"未抓取到相关开奖结果信息,返回null==");
		}
		logger.info(logHeader+"结束==");
		return lotteryDraw;
	}
}
