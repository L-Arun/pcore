package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.tags.BulletList;
import org.htmlparser.tags.ParagraphTag;
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
import com.lehecai.core.util.CoreFetcherUtils;
/**
 * 龙江风采网 开奖结果抓取
 * 抓取黑龙江36选7  <br/>
 * 历史地址:http://kaijiang.zhcw.com/heilongjiang/static/html/36x7/index.html  <br/>
 * @author liurd
 *
 */
public class LotteryDrawFetch527WorkerOfficial extends AbstractLotteryDrawFetchWorker {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	protected static final String RESULT_LOCALITY_URL = "http://kaijiang.zhcw.com/heilongjiang/static/html/36x7/index.html";
	protected static final String RESULT_DETAIL_LOCALITY_URL = "http://kaijiang.zhcw.com/heilongjiang/static/html/36x7/detail/detail_36x7_";

	protected String siteName = "龙江风采网";
	protected String lotteryScope = "黑龙江36选7";
	
	public LotteryDrawFetch527WorkerOfficial(){
		super(LotteryType.A_HLJ36);
	}
	@Override
	public LotteryDraw fetchResult(String phase) {
		String url = this.getResultUrl(phase);
		String data = null;
		String pageInfo = "结果页面" + url;
		String encoding = "UTF-8";
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
		
		NodeFilter filter = new HasAttributeFilter("class", "column");		
		NodeList nodeList = null;
		String strPhase = "", strSale = "", strDate = "", strJackpot = "", strResult = "";
		List<LotteryDrawPrizeItem> resultDetail = new ArrayList<LotteryDrawPrizeItem>();
		
		NumberFormat myformat = NumberFormat.getInstance();
		myformat.setGroupingUsed(false);
		myformat.setMaximumFractionDigits(0);	//设置最多小数位数
		myformat.setMinimumFractionDigits(0);	//设置最少小数位数
		
		try {
			nodeList = parser.extractAllNodesThatMatch(filter);	
			
			//解析彩期
			ParagraphTag phaseTag = (ParagraphTag) nodeList.elementAt(0).getChildren().elementAt(3).getChildren().elementAt(1).getChildren().elementAt(1).getChildren().elementAt(1);
			strPhase = phaseTag.getChildren().elementAt(1).getChildren().elementAt(1).getChildren().elementAt(1).toPlainTextString().trim();
			if (phase != null) {
				if (!phase.equals(strPhase)) {
					return null;
				}
			}
			//解析开奖时间
			ParagraphTag dateTag = (ParagraphTag) nodeList.elementAt(0).getChildren().elementAt(3).getChildren().elementAt(1).getChildren().elementAt(1).getChildren().elementAt(3);
			strDate = dateTag.getChildren().elementAt(2).toPlainTextString().trim();
			
			//解析销量
			ParagraphTag saleTag = (ParagraphTag) nodeList.elementAt(0).getChildren().elementAt(3).getChildren().elementAt(1).getChildren().elementAt(5).getChildren().elementAt(1);
			strSale = saleTag.getChildren().elementAt(2).toPlainTextString().trim();
			
			//解析奖池
			ParagraphTag jackTag = (ParagraphTag) nodeList.elementAt(0).getChildren().elementAt(3).getChildren().elementAt(1).getChildren().elementAt(5).getChildren().elementAt(3);
			strJackpot = jackTag.getChildren().elementAt(2).toPlainTextString().trim();
			
			//解析开奖结果
			BulletList resultTag = (BulletList) nodeList.elementAt(0).getChildren().elementAt(3).getChildren().elementAt(1).getChildren().elementAt(3).getChildren().elementAt(3);
			for (int i=1;i<14;i = i+2) {
				strResult = strResult + resultTag.getChildren().elementAt(i).toPlainTextString().trim() + ",";
			}
			strResult = strResult + resultTag.getChildren().elementAt(15).toPlainTextString().trim();
			
			//解析中奖详情
			TableTag resultDetailTag = (TableTag) nodeList.elementAt(0).getChildren().elementAt(3).getChildren().elementAt(1).getChildren().elementAt(7).getChildren().elementAt(3);
			TableRow[] tableRows = resultDetailTag.getRows();
			for (int i = 1; i < tableRows.length; i++) {
				LotteryDrawPrizeItem lotteryDrawPrizeItem = new LotteryDrawPrizeItem();
				TableColumn[] tableColumns = tableRows[i].getColumns();
				lotteryDrawPrizeItem.setName(tableColumns[0].toPlainTextString().trim());
				lotteryDrawPrizeItem.setWinningCount(tableColumns[1].toPlainTextString().trim());
				lotteryDrawPrizeItem.setPrizeAmount(myformat.format(Double.parseDouble(tableColumns[2].toPlainTextString().trim())));
				resultDetail.add(lotteryDrawPrizeItem);
			}
		} catch (ParserException e) {
			logger.error("数据解析错误==" + e.getMessage(), e );
			return null;
		}
		
		if (strPhase != null) {
			//设置彩期
			lotteryDraw.setPhase(strPhase);
			//设置奖池
			Double jackpotTmp = Double.parseDouble(strJackpot.replace("元", ""));
			strJackpot = myformat.format(jackpotTmp);	//格式化
			lotteryDraw.setJackpot(strJackpot);
			//设置彩种
			lotteryDraw.setLotteryType(this.getLotteryType());
			//设置开奖结果
			lotteryDraw.setResult(strResult);
			//设置销量
			Double saleTmp = Double.parseDouble(strSale.replace("元", ""));
			strSale = myformat.format(saleTmp);	//格式化
			lotteryDraw.setVolumeOfSales(strSale);
			//是指开奖时间
			lotteryDraw.setTimeDraw(strDate + " 00:00:00");
			//设置中奖详情
			lotteryDraw.setResultDetail(resultDetail);
			
			logger.info(logHeader+lotteryDraw.getLotteryOpenResultLogMsg());
		}
		return lotteryDraw;
	}

	@Override
	public LotteryDraw fetchResultDetail(String phase) {
		if (phase == null) {
			logger.info("==错误信息==彩期为空,退出fetchResultDetail方法==");
			return null;
		}
		String url = this.getResultDetailUrl(phase);
		String data = null;
		String pageInfo = "详情页面" + url;
		String encoding = "UTF-8";
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
		
		NodeFilter filter = new HasAttributeFilter("class", "column");		
		NodeList nodeList = null;
		String strPhase = "", strSale = "", strDate = "", strJackpot = "", strResult = "";
		List<LotteryDrawPrizeItem> resultDetail = new ArrayList<LotteryDrawPrizeItem>();
		
		NumberFormat myformat = NumberFormat.getInstance();
		myformat.setGroupingUsed(false);
		myformat.setMaximumFractionDigits(0);	//设置最多小数位数
		myformat.setMinimumFractionDigits(0);	//设置最少小数位数
		
		try {
			nodeList = parser.extractAllNodesThatMatch(filter);	
			
			TableTag tableTag = (TableTag) nodeList.elementAt(0).getChildren().elementAt(3).getChildren().elementAt(1).getChildren().elementAt(1).getChildren().elementAt(1);
			TableRow[] tableRows = tableTag.getRows();
			//解析彩期
			strPhase = tableRows[0].getChildren().elementAt(1).toPlainTextString().replace("第", "").replace("期", "").trim();
			//解析开奖时间
			strDate = tableRows[0].getChildren().elementAt(3).toPlainTextString().replace("开奖日期:", "").trim();
			//解析销量
			strSale = tableRows[1].getChildren().elementAt(1).toPlainTextString().replace("投注总额:", "").replace("元", "").trim();
			//解析奖池
			strJackpot = tableRows[1].getChildren().elementAt(3).toPlainTextString().replace("滚入下期:", "").replace("元", "").trim();
			//解析开奖结果
			strResult = tableRows[2].getChildren().elementAt(1).getChildren().elementAt(1).toPlainTextString().replace("基本号", "").trim()
				+ tableRows[2].getChildren().elementAt(1).getChildren().elementAt(3).toPlainTextString().replace("特别号", "").trim();
			strResult = strResult.replace("&nbsp;", "").replace(" ", "");
			char[] charTmp = strResult.toCharArray();
			String strTmp = "";
			for (int i = 0; i < charTmp.length-2; i = i + 2){
				strTmp = strTmp + charTmp[i] + charTmp[i+1] + ",";
			}
			strTmp = strTmp + charTmp[charTmp.length-2] + charTmp[charTmp.length-1];
			strResult = strTmp;
			//解析中奖详情
			for (int i = 5; i <= 12; i++) {
				LotteryDrawPrizeItem lotteryDrawPrizeItem = new LotteryDrawPrizeItem();
				TableColumn[] tableColumns = tableRows[i].getColumns();
				lotteryDrawPrizeItem.setName(tableColumns[0].toPlainTextString().trim());
				lotteryDrawPrizeItem.setWinningCount(tableColumns[2].toPlainTextString().trim());
				lotteryDrawPrizeItem.setPrizeAmount(tableColumns[3].toPlainTextString().trim().replace("元/注", ""));
				resultDetail.add(lotteryDrawPrizeItem);
				
			}
		} catch (ParserException e) {
			logger.error("数据解析错误==" + e.getMessage(), e);
			return null;
		}
		if(phase != null){
			if(strPhase == null || !phase.equals(strPhase)){
				return null;
			}
		}
		
		if(strPhase != null){
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
			//是指开奖时间
			lotteryDraw.setTimeDraw(strDate + " 00:00:00");
			//设置中奖详情
			lotteryDraw.setResultDetail(resultDetail);
			
			logger.info(logHeader+lotteryDraw.getLotteryOpenResultLogMsg());
		}
		return lotteryDraw;
	}
	@Override
	protected String getResultDetailUrl(String phase) {
		return RESULT_DETAIL_LOCALITY_URL + phase + ".html";
	}
	@Override
	protected String getResultUrl(String phase) {
		return RESULT_LOCALITY_URL;
	}

}
