package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

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
import com.lehecai.core.util.CoreDateUtils;
import com.lehecai.core.util.CoreFetcherUtils;

/**
 * 山西体彩网 开奖结果抓取
 * 抓取泳坛夺金  <br/>
 * 历史地址:http://www.sxlottery.net/ytdj/  <br/>
 * @author liurd
 *
 */
public class LotteryDrawFetch547WorkerOfficial extends AbstractLotteryDrawFetchWorker {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	protected static final String RESULT_LOCALITY_URL = "http://www.sxlottery.net/ytdj/";
	protected static final String RESULT_MORE_LOCALITY_URL = "http://www.sxlottery.net/front/ytdj.do?";
	
	protected String siteName = "山西体彩网";
	protected String lotteryScope = "泳坛夺金";
	
	public LotteryDrawFetch547WorkerOfficial() {
		super(LotteryType.A_YTDJ);
	}
	
	@Override
	public LotteryDraw fetchResult(String phase) {
		LotteryDraw lotteryDraw = null;
		lotteryDraw = nowPhaseResult();
		if (lotteryDraw.getPhase().equals(phase)  || phase == null || "".equals(phase)) {
			return lotteryDraw;
		} else {
			lotteryDraw = null;
		}
		
		String url = getResultUrl(phase);
		
		if (url == null || "".equals(url)) {
			logger.error("==抓取失败，获取url地址为空==");
			return null;
		}
		
		String data = null;
		String pageInfo = "结果页面" + url;
		String encoding = "GBK";
		String logHeader = "==" + lotteryScope + "==" + siteName + "=="
				+ pageInfo + "==抓取==" + getLotteryType().getName() + "==";

		data = CoreFetcherUtils.URLGet(url, null, encoding);
		
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
		
		NodeFilter filter = new HasAttributeFilter("class", "tr03");		
		NodeList nodeList = null;
		
		try {
			nodeList = parser.extractAllNodesThatMatch(filter);
			TableRow[] tableRows = new TableRow[nodeList.size()];
			for (int i = 0; i < nodeList.size(); i++) {
				tableRows[i] = (TableRow) nodeList.elementAt(i);
			}
			for (int i = 0; i < tableRows.length; i++ ) {
				TableColumn[] tableColumns = tableRows[i].getColumns();
				String phaseTmp = tableColumns[1].toPlainTextString().replace("期", "").trim();
				if (phaseTmp != null && !"".equals(phaseTmp) && phase.equals(phaseTmp)) {
					lotteryDraw = new LotteryDraw();
					//开奖日期
					lotteryDraw.setTimeDraw(tableColumns[0].toPlainTextString() + " 00:00:00");
					//彩期
					lotteryDraw.setPhase(phaseTmp);
					//开奖结果
					String strResult = "";
					for (int j = 2; j < 5; j++) {
						strResult = strResult + tableColumns[j].toPlainTextString() + ",";
					}
					strResult = strResult + tableColumns[5].toPlainTextString() + ",";
					lotteryDraw.setResult(strResult);
					//彩种
					lotteryDraw.setLotteryType(super.getLotteryType());
					break;
				}
			}
		} catch (ParserException e) {
			logger.error("数据解析错误==" + e.getMessage(), e);
			return null;
		}
		return lotteryDraw;
	}

	private LotteryDraw nowPhaseResult() {
		String url = RESULT_LOCALITY_URL;
		
		LotteryDraw lotteryDraw = null;
		String data = null;
		String pageInfo = "结果页面" + url;
		String encoding = "GBK";
		String logHeader = "==" + lotteryScope + "==" + siteName + "=="
				+ pageInfo + "==抓取==" + getLotteryType().getName() + "==";

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
		
		NodeFilter filter = new HasAttributeFilter("class", "list");		
		NodeList nodeList = null;
		
		try {
			nodeList = parser.extractAllNodesThatMatch(filter);
			TableTag tableTag = (TableTag) nodeList.elementAt(0).getChildren().elementAt(1);
			TableRow[] tableRows = tableTag.getRows();
			lotteryDraw = new LotteryDraw();
			TableColumn[] tableColumns = tableRows[2].getColumns();
			//彩期
			lotteryDraw.setPhase(tableColumns[1].toPlainTextString().replace("期", "").trim());
			//彩种
			lotteryDraw.setLotteryType(getLotteryType());
			//开奖日期
			lotteryDraw.setTimeDraw(tableColumns[0].toPlainTextString().trim() + " 00:00:00");
			//开奖结果
			String strResult = "";
			for (int j = 2; j < 5; j++) {
				strResult = strResult + tableColumns[j].toPlainTextString() + ",";
			}
			strResult = strResult + tableColumns[5].toPlainTextString() + ",";	
			lotteryDraw.setResult(strResult);
		} catch (ParserException e) {
			logger.error("数据解析错误==" + e.getMessage(), e);
			return null;
		}
		return lotteryDraw;
	}

	@Override
	public LotteryDraw fetchResultDetail(String phase) {
		return null;
	}

	@Override
	protected String getResultDetailUrl(String phase) {
		return null;
	}

	@Override
	protected String getResultUrl(String phase) {
		if (phase == null || "".equals(phase)) {
			logger.error("==抓取失败，获取url地址为空==");
			return null;
		}
		
		Integer pageCode = 1;
		String url = RESULT_MORE_LOCALITY_URL + "curPage=" + pageCode + "&moreList=";
		String data = null;
		String pageInfo = "结果页面" + url;
		String encoding = "GBK";
		String logHeader = "==" + lotteryScope + "==" + siteName + "=="
				+ pageInfo + "==抓取==" + getLotteryType().getName() + "==";

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
		Parser parser = Parser.createParser(data,  encoding);
		
		NodeFilter filter = new HasAttributeFilter("class", "tr03");		
		NodeList nodeList = null;
		
		try {
			nodeList = parser.extractAllNodesThatMatch(filter);
			TableRow tableRow = (TableRow) nodeList.elementAt(0);
			String phaseTmp = tableRow.getChildren().elementAt(3).toPlainTextString().replace("期", "").trim();
			if (Integer.parseInt(phase) > Integer.parseInt(phaseTmp)) {
				logger.error("==彩期输入错误==");
				return null;
			}
			char[] phaseTmpArray = phaseTmp.toCharArray();
			char[] phaseArray = phase.toCharArray();
			Long dayCount = CoreDateUtils.diffDays(CoreDateUtils.parseDate("20" + phaseTmpArray[0] + phaseTmpArray[1] + "-" + phaseTmpArray[2] + phaseTmpArray[3] + "-" + phaseTmpArray[4] + phaseTmpArray[5]), 
					CoreDateUtils.parseDate("20" + phaseArray[0] + phaseArray[1] + "-" + phaseArray[2] + phaseArray[3] + "-" + phaseArray[4] + phaseArray[5]));
			int tmpCount = (Integer.parseInt("" + phaseTmpArray[6] + phaseTmpArray[7]) - Integer.parseInt("" + phaseArray[6] + phaseArray[7]));
			tmpCount = (dayCount.intValue() * 79 + tmpCount) / 30;
			pageCode = pageCode + tmpCount;
			return RESULT_MORE_LOCALITY_URL + "curPage=" + pageCode + "&moreList=";
		} catch (ParserException e) {
			logger.error("数据解析错误==" + e.getMessage(), e);
			return null;
		}
	}
}
