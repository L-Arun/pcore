package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.util.ArrayList;
import java.util.List;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDrawPrizeItem;
import com.lehecai.core.util.CoreDateUtils;
import com.lehecai.core.util.CoreFetcherUtils;
/**
 * 河南福彩网 开奖结果抓取
 * 抓取中原风采22选5  <br/>
 * 历史地址:http://www.m12580.cn/Lishi.Aspx?id=11  <br/>
 * @author liurd
 *
 */
public class LotteryDrawFetch512WorkerOfficial extends AbstractLotteryDrawFetchWorker {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	protected static final String RESULT_LOCALITY_URL = "http://www.henanfucai.com/Wanfa.Aspx?id=11";
	protected static final String RESULT_HISTORY_LOCALITY_URL = "http://www.henanfucai.com/Lishi.Aspx?id=11";
	
	protected String siteName = "河南福彩网";
	protected String lotteryScope = "中原风采22选5";
	
	public LotteryDrawFetch512WorkerOfficial(){
		super(LotteryType.A_ZYFC22);
	}
	@Override
	public LotteryDraw fetchResult(String phase) {
		if (phase == null || "".equals(phase)) {
			logger.error("==错误信息==彩期为空,退出fetchResult方法==");
			return null;
		}
		String url = RESULT_HISTORY_LOCALITY_URL;
		String data = null;
		String pageInfo = "结果页面" + url;
		String encoding = "GBK";
		String logHeader = "==" + lotteryScope + "==" + siteName + "=="
				+ pageInfo + "==抓取==" + getLotteryType().getName() + "==";
		
		LotteryDraw lotteryDraw = new LotteryDraw();
		
		try {
			data = CoreFetcherUtils.URLGet(url, null, encoding);
		} catch (Exception e) {
			logger.error("获取html数据失败" + e.getMessage());
			return null;
		}
		
		if (data == null || data.indexOf("404 Not Found") > 0 || data.isEmpty()) {
			logger.error(logHeader + "data is null or 404 Not Found");
			return null;
		}	
		Parser parser = null;
		
		try {
			parser = Parser.createParser(data,  encoding);
		} catch (Exception e) {
			logger.error("解析html页面失败" + e.getMessage());
			return null;
		}
		
		NodeFilter filter = new HasAttributeFilter("class", "tablemain");		
		NodeList nodeList = null;
		String strDate = "", strResult = "";
		
		try {
			nodeList = parser.extractAllNodesThatMatch(filter);	
			TableTag tableTag = (TableTag) nodeList.elementAt(0);
			TableRow[] tableRows = tableTag.getRows();
			for (int i = 2; i < tableRows.length; i++) {
				TableColumn[] tableColumns = tableRows[i].getColumns();
				if (phase.equals(tableColumns[0].toPlainTextString().trim())) {
					lotteryDraw.setLotteryType(this.getLotteryType());
					
					String strTmp = "";
					for(int j = 1; j < 5; j++) {
						strTmp = strTmp + tableColumns[j].toPlainTextString().trim() + ",";
					}
					strTmp = strTmp + tableColumns[5].toPlainTextString().trim();
					strResult = strTmp;
					lotteryDraw.setResult(strResult);
					
					lotteryDraw.setVolumeOfSales(tableColumns[6].toPlainTextString().trim());
					lotteryDraw.setJackpot(null);
					lotteryDraw.setPhase(phase);
					lotteryDraw.setResultDetail(null);
					strDate = tableColumns[8].toPlainTextString().trim();
				}
				
			}
		} catch (ParserException e) {
			logger.error("数据解析错误==" + e.getMessage(), e);
			return null;
		}
		
		lotteryDraw.setTimeDraw(CoreDateUtils.formatDate(CoreDateUtils.parseDate(strDate + " 08:00:00", CoreDateUtils.DATETIME), CoreDateUtils.DATETIME));
		
		logger.info(logHeader+lotteryDraw.getLotteryOpenResultLogMsg());
		
		return lotteryDraw;
	}

	@Override
	public LotteryDraw fetchResultDetail(String phase) {
		String url = RESULT_LOCALITY_URL;
		String data = null;
		String pageInfo = "详情页面" + url;
		String encoding = "GBK";
		String logHeader = "==" + lotteryScope + "==" + siteName + "=="
				+ pageInfo + "==抓取==" + getLotteryType().getName() + "==";
		
		LotteryDraw lotteryDraw = new LotteryDraw();
		
		try {
			data = CoreFetcherUtils.URLGet(url, null, encoding);
		} catch (Exception e) {
			logger.error("获取html数据失败" + e.getMessage());
			return null;
		}
		
		if (data == null || data.indexOf("404 Not Found") > 0 || data.isEmpty()) {
			logger.error(logHeader + "data is null or 404 Not Found");
			return null;
		}	
		Parser parser = null;
		
		try {
			parser = Parser.createParser(data,  encoding);
		} catch (Exception e) {
			logger.error("解析html页面失败" + e.getMessage());
			return null;
		}
		
		NodeFilter filter = new HasAttributeFilter("class", "haoma_3");		
		NodeList nodeList = null;
		String strPhase = "", strSale = "", strDate = "", strJackpot = "", strResult = "";
		List<LotteryDrawPrizeItem> resultDetail = new ArrayList<LotteryDrawPrizeItem>();
		
		try {
			nodeList = parser.extractAllNodesThatMatch(filter);	
			TableTag resultTable = (TableTag) nodeList.elementAt(0).getChildren().elementAt(0).getChildren().elementAt(0);
			TableRow[] resultRows = resultTable.getRows();
			//解析彩期
			strPhase = resultRows[0].toPlainTextString().replace("22选5 第", "").replace("期", "").trim();
			//解析开奖时间
			strDate = resultRows[1].toPlainTextString().replace("开奖时间：", "").trim();
			//解析销量
			strSale = resultRows[2].getChildren().elementAt(0).getChildren().elementAt(1).toPlainTextString().trim();
			//解析奖池
			strJackpot = resultRows[3].getChildren().elementAt(0).getChildren().elementAt(1).toPlainTextString().trim();
			//解析开奖结果
			String strTmp = "";
			for (int i = 1; i < 5; i++) {
				strTmp = strTmp + resultRows[5].getChildren().elementAt(0).getChildren().elementAt(i).toPlainTextString() + ",";
			}
			strTmp = strTmp + resultRows[5].getChildren().elementAt(0).getChildren().elementAt(5).toPlainTextString();
			strResult = strTmp;
			//解析中奖详情
			TableTag resultDetailTable = (TableTag) nodeList.elementAt(0).getChildren().elementAt(1).getChildren().elementAt(0);
			TableRow[] resultDetailRows = resultDetailTable.getRows();
			for (int i = 1; i < resultDetailRows.length; i++) {
				LotteryDrawPrizeItem lotteryDrawPrizeItem = new LotteryDrawPrizeItem();
				TableColumn[] tableColumns = resultDetailRows[i].getColumns();
				lotteryDrawPrizeItem.setName(tableColumns[0].toPlainTextString().trim());
				lotteryDrawPrizeItem.setWinningCount(tableColumns[1].toPlainTextString().trim());
				lotteryDrawPrizeItem.setPrizeAmount(tableColumns[2].toPlainTextString());
				resultDetail.add(lotteryDrawPrizeItem);
			}
		} catch (ParserException e) {
			logger.error("数据解析错误==" + e.getMessage(), e);
			return null;
		}
		if (phase != null) {
			if (strPhase == null || !phase.equals(strPhase)) {
				return null;
			}
		}
		
		if (strPhase != null) {
			//设置彩期
			lotteryDraw.setPhase(strPhase);
			//设置奖池
			lotteryDraw.setJackpot(strJackpot);
			//设置彩种
			lotteryDraw.setLotteryType(this.getLotteryType());
			//设置开奖结果
			lotteryDraw.setResult(strResult);
			//设置销量
			lotteryDraw.setVolumeOfSales(strSale);
			//设置开奖时间
			lotteryDraw.setTimeDraw(CoreDateUtils.formatDate(CoreDateUtils.parseDate(strDate + " 08:00:00", CoreDateUtils.DATETIME), CoreDateUtils.DATETIME));
			//设置中奖详情
			lotteryDraw.setResultDetail(resultDetail);
			
			logger.info(logHeader+lotteryDraw.getLotteryOpenResultLogMsg());
		}
		return lotteryDraw;
	}

	@Override
	protected String getResultDetailUrl(String phase) {
		return null;
	}

	@Override
	protected String getResultUrl(String phase) {
		return null;
	}

}
