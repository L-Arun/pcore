package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.util.ArrayList;
import java.util.List;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.DefinitionListBullet;
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
 * 湖北福彩网 开奖结果抓取
 * 抓取湖北楚天风采22选5  <br/>
 * 历史地址:http://hbfc.cnhubei.com/22x5/index.shtml  <br/>
 * @author liurd
 *
 */
public class LotteryDrawFetch511WorkerOfficial extends AbstractLotteryDrawFetchWorker {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	protected static final String RESULT_LOCALITY_URL = "http://stats.hbfcw.gov.cn/index.php/Index/t22x5";
	protected static final String RESULT_MORE_LOCALITY_URL = "http://3dkb.cnhubei.com/kaijiang/default.aspx?type=225&qi=";
	
	protected String siteName = "湖北福彩网";
	protected String lotteryScope = "湖北楚天风采22选5";
	
	public LotteryDrawFetch511WorkerOfficial() {
		super(LotteryType.A_CTFC22);
	}
	
	@Override
	public LotteryDraw fetchResultDetail(String phase) {
		LotteryDraw lotteryDraw = null;
		lotteryDraw = nowPhaseResult();
		
		if (phase == null || "".equals(phase) || lotteryDraw.getPhase().equals(phase)) {
			return lotteryDraw;
		} else {
			lotteryDraw = null;
		}
		
		String url = RESULT_MORE_LOCALITY_URL + phase;
		
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
		
		NodeFilter filter = new TagNameFilter("table");		
		NodeList nodeList = null;
		
		try {
			nodeList = parser.extractAllNodesThatMatch(filter);
			TableTag tableTag = (TableTag) nodeList.elementAt(0);
			TableRow[] tableRows = tableTag.getRows();
			lotteryDraw = new LotteryDraw();
			//彩期
			TableTag table = (TableTag) tableRows[1].getChildren().elementAt(1).getChildren().elementAt(1);
			String strPhase = table.getRows()[0].getColumns()[0].toPlainTextString().replace("22选5第", "").replace("期", "").trim();
			if (strPhase != null && !"".equals(strPhase) && phase.equals(strPhase)) {
				lotteryDraw.setPhase(strPhase);
			} else {
				logger.error("==输入彩期与抓取到的彩期不匹配==");
				return null;
			}
			//开奖号码
			lotteryDraw.setResult(table.getRows()[0].getColumns()[1].toPlainTextString().replace("开奖号码：", "").trim().replace(" ", ","));
			//开奖日期
			String strDate = table.getRows()[0].getColumns()[4].toPlainTextString().replace("开奖日：", "").trim();
			lotteryDraw.setTimeDraw(CoreDateUtils.formatDate(CoreDateUtils.parseDate(strDate, CoreDateUtils.DATETIME), CoreDateUtils.DATETIME));
			//销量
			lotteryDraw.setVolumeOfSales(tableRows[3].toPlainTextString().replace("本期投注额为：", "").replace("元", "").trim());
			//彩种
			lotteryDraw.setLotteryType(getLotteryType());
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
		String encoding = "utf-8";
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
		
		NodeFilter filter = new HasAttributeFilter("class", "C_2");		
		NodeList nodeList = null;
		
		try {
			nodeList = parser.extractAllNodesThatMatch(filter);
			lotteryDraw = new LotteryDraw();
			//开奖时间
			String strDate = nodeList.elementAt(0).getChildren().elementAt(1).getChildren().elementAt(3).toPlainTextString();
			strDate = CoreDateUtils.formatDate(CoreDateUtils.parseDate(strDate + " 00:00:00", CoreDateUtils.DATETIME), CoreDateUtils.DATETIME);
			lotteryDraw.setTimeDraw(strDate);
			//彩期
			lotteryDraw.setPhase(nodeList.elementAt(0).getChildren().elementAt(3).getChildren().elementAt(1).toPlainTextString().replace("第", "").replace("期", ""));
			//开奖结果
			char[] charArrayTmp = nodeList.elementAt(0).getChildren().elementAt(3).getChildren().elementAt(4).toPlainTextString().toCharArray();
			char[] charArray = new char[10];
			for (int i = 12, j = 0; i < 22; i++, j++) {
				charArray[j] = charArrayTmp[i];
			}
			String strResult = "" + charArray[0] + charArray[1] + ","
							+ charArray[2] + charArray[3] + ","
							+ charArray[4] + charArray[5] + ","
							+ charArray[6] + charArray[7] + ","
							+ charArray[8] + charArray[9];
			lotteryDraw.setResult(strResult);
			//中奖详情
			List<LotteryDrawPrizeItem> lotteryDrawPrizeItemList = new ArrayList<LotteryDrawPrizeItem>();
			for (int i = 3; i < 18; i = i +2) {
				LotteryDrawPrizeItem lotteryDrawPrizeItem = new LotteryDrawPrizeItem();
				DefinitionListBullet dlb = (DefinitionListBullet) nodeList.elementAt(0).getChildren().elementAt(5).getChildren().elementAt(i);
				lotteryDrawPrizeItem.setName(dlb.getChildren().elementAt(1).toPlainTextString());
				lotteryDrawPrizeItem.setWinningCount(dlb.getChildren().elementAt(3).toPlainTextString());
				lotteryDrawPrizeItem.setPrizeAmount(dlb.getChildren().elementAt(5).toPlainTextString());
				lotteryDrawPrizeItemList.add(lotteryDrawPrizeItem);
			}
			lotteryDraw.setResultDetail(lotteryDrawPrizeItemList);
			//奖池 和 销量
			String [] poolAndSale = null;
			if (nodeList.elementAt(0).getChildren().elementAt(7).toPlainTextString().indexOf("&nbsp;") != -1) {
				poolAndSale = nodeList.elementAt(0).getChildren().elementAt(7).toPlainTextString().split("&nbsp;");
			} else {
				poolAndSale = nodeList.elementAt(0).getChildren().elementAt(7).toPlainTextString().split(" ");
			}
			lotteryDraw.setVolumeOfSales(poolAndSale[0].replace("湖北投注额：", "").replace("元", "").trim());
			lotteryDraw.setJackpot(poolAndSale[poolAndSale.length-1].replace("累积奖池金额：", "").replace("元", "").trim());
			//彩种
			lotteryDraw.setLotteryType(getLotteryType());
		} catch (ParserException e) {
			logger.error("数据解析错误==" + e.getMessage(), e);
			return null;
		}
		return lotteryDraw;
	}

	@Override
	public LotteryDraw fetchResult(String phase) {
		return null;
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
