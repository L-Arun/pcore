package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDrawPrizeItem;
import com.lehecai.core.util.CoreFetcherUtils;
/**
 * 广东体彩网 开奖结果抓取
 * 主要抓广东体彩36选7  <br/>
 * 历史地址: http://www.gdlottery.cn/kjgg_new.jsp?gameId=P006&qh=11025<br/>
 * @author 
 *
 */
public class LotteryDrawFetch57WorkerOfficial extends AbstractLotteryDrawFetchWorker{

	protected String siteName = "广东体彩网";
	protected String lotteryScope = "36选7";
	
	public LotteryDrawFetch57WorkerOfficial() {
		super(LotteryType.T36x7);
	}
	
	@Override
	public LotteryDraw fetchResult(String phase) {
		LotteryType lotteryType = this.getLotteryType();
		
		String url="http://www.gdlottery.cn/";
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
		Parser parser= Parser.createParser(data,  encoding);
		String filterName = "div";
		TagNameFilter tableFilter = new TagNameFilter(filterName);
		try {
			NodeList nodeList = parser.extractAllNodesThatMatch(tableFilter);
			//解析彩期
			String strPhase = nodeList.elementAt(17).getChildren().elementAt(1)
				.getChildren().elementAt(23).getChildren().elementAt(3).toPlainTextString().trim();
			//解析开奖结果
			String strResult = nodeList.elementAt(17).getChildren().elementAt(1)
				.getChildren().elementAt(23).getChildren().elementAt(5).toPlainTextString().trim();
			strResult = strResult.substring(0,2) + "," + strResult.substring(2,4) + "," + strResult.substring(4,6)
				+ "," + strResult.substring(6,8) + "," + strResult.substring(8,10) + "," + strResult.substring(10,12)
				+ "," + strResult.substring(13,15);
			//解析奖池余额
			String strJackpot = nodeList.elementAt(17).getChildren().elementAt(1)
				.getChildren().elementAt(23).getChildren().elementAt(11).toPlainTextString().trim().replace("万元", "")+"0000";		
			LotteryDraw lotteryDraw = new LotteryDraw();
			lotteryDraw.setResult(strResult);
			lotteryDraw.setJackpot(strJackpot);
			lotteryDraw.setPhase(strPhase);
			lotteryDraw.setLotteryType(lotteryType);
			
			logger.info(logHeader+lotteryDraw.getLotteryOpenResultLogMsg());
			
			return lotteryDraw;
			} catch (ParserException e2){
				logger.error("数据解析错误=="+e2.getMessage(), e2);
				return null;
			}
	}

	@Override
	public LotteryDraw fetchResultDetail(String phase) {
		LotteryType lotteryType = this.getLotteryType();
		
		String url = this.getResultDetailUrl(phase);
		
		if (url == null || url.isEmpty()) {
			logger.error("==" + lotteryScope + "==" + siteName + "==详细页面==抓取=="
					+ getLotteryType().getName() + "==期号：" + phase
					+ "==详细地址不存在，返回null");
			return null;
		}
		String pageInfo = "详细页面" + url;
		String encoding = "GBK";
		String logHeader = "==" + lotteryScope + "==" + siteName + "=="
				+ pageInfo + "==抓取==" + getLotteryType().getName() + "==";
		logger.info(logHeader + "开始==");
		LotteryDraw lotteryDraw = new LotteryDraw();

		String data = null;
		
		data = CoreFetcherUtils.URLGet(url, null, encoding);
		
		if (data == null || data.indexOf("404 Not Found") > 0 || data.isEmpty()) {
			logger.error(logHeader + "data is null or 404 Not Found");
			return null;
		}	
		Parser parser= Parser.createParser(data,  encoding);
		
		String filterName = "table";
		TagNameFilter tableFilter = new TagNameFilter(filterName);
		NodeList nodeList = null;
		
		try {
			nodeList = parser.extractAllNodesThatMatch(tableFilter);
			TableTag tableTag = (TableTag) nodeList.elementAt(0);
			TableRow[] tableRows=tableTag.getRows();
			//解析彩期和开奖时间
			String phaseAndTime = tableRows[1].toPlainTextString().replace("&nbsp;", "").trim().substring(
					tableRows[1].toPlainTextString().replace("&nbsp;", "").trim().indexOf(")")+1
					, tableRows[1].toPlainTextString().replace("&nbsp;", "").trim().indexOf("日"));
			//解析销量
			String volumeOfSales = tableRows[16].toPlainTextString().replace("&nbsp;", "").trim();
			//解析开奖结果
			String result = tableRows[4].toPlainTextString().trim().replace("  ", ",");
			//得到开奖详情
			List<LotteryDrawPrizeItem> resultDetail = new ArrayList<LotteryDrawPrizeItem>();
			for(int i=7;i<13;i++){
				LotteryDrawPrizeItem lotteryDrawPrizeItem = new LotteryDrawPrizeItem();
				lotteryDrawPrizeItem.setName(tableRows[i].getChildren().elementAt(3).toPlainTextString().trim());
				lotteryDrawPrizeItem.setWinningCount(tableRows[i].getChildren().elementAt(7).toPlainTextString().replace(",", "").trim());
				try{
					Integer.parseInt(tableRows[i].getChildren().elementAt(9).toPlainTextString().replace(",", "").trim());
					lotteryDrawPrizeItem.setPrizeAmount(tableRows[i].getChildren().elementAt(9).toPlainTextString().replace(",", "").trim());
				}catch(Exception e3){
					lotteryDrawPrizeItem.setPrizeAmount("0");
				}
				resultDetail.add(lotteryDrawPrizeItem);
			}
			//set lotteryDraw
			lotteryDraw = new LotteryDraw();
			lotteryDraw.setLotteryType(lotteryType);
			String fetchedPhase = phaseAndTime.substring(phaseAndTime.indexOf("第")+1,phaseAndTime.indexOf("期"));
			//判断彩期是否一致
			if (phase != null && !"".equals(phase)){
				if (phaseAndTime.substring(phaseAndTime.indexOf("第")+1,phaseAndTime.indexOf("期")).equals(phase)){
					lotteryDraw.setPhase(phase);
				}
				else{
					logger.error("抓取到的彩期不匹配, fetched={}, phase={}", fetchedPhase, phase);
					return null;
				}
			}else{
				lotteryDraw.setPhase(fetchedPhase);
				
			}
			try {
				lotteryDraw.setTimeDraw(new SimpleDateFormat("yyyy-mm-dd").format(new SimpleDateFormat("yyyy-mm-dd").parse(phaseAndTime.replace(phaseAndTime.substring(phaseAndTime.indexOf("第"),phaseAndTime.indexOf("期")+1), "")
							.replace("年", "-").replace("月", "-"))) + " 00:00:00");
			} catch (ParseException e) {
				logger.error("==时间格式转换错误，返回null" + e.getMessage(), e);
				return null;
			}
			
			lotteryDraw.setResult(result);
			lotteryDraw.setVolumeOfSales(volumeOfSales.substring(volumeOfSales.indexOf("：")+1,volumeOfSales.indexOf("元")).replace(",", ""));
			lotteryDraw.setResultDetail(resultDetail);
			
			logger.info(logHeader+lotteryDraw.getLotteryOpenResultLogMsg());			
		}catch(ParserException e2){
			logger.error("数据解析错误=="+e2.getMessage(), e2);
			return null;
		}
		
		return lotteryDraw;
	}

	@Override
	protected String getResultDetailUrl(String phase) {
		if (phase != null && phase.trim().length() > 0) {
			return "http://www.gdlottery.cn/kjggHtml/P006_" + phase + ".html";
		}

		String url="http://www.gdlottery.cn/";
		String data = null;
		String pageInfo = "详细页面" + url;
		String encoding = "GBK";
		String logHeader = "==" + lotteryScope + "==" + siteName + "=="
				+ pageInfo + "==抓取==" + getLotteryType().toString() + "==";
		
		data = CoreFetcherUtils.URLGet(url, null, encoding);
		
		if (data == null || data.indexOf("404 Not Found") > 0 || data.isEmpty()) {
			logger.error(logHeader + "data is null or 404 Not Found");
			return null;
		}	
		Parser parser= Parser.createParser(data,  encoding);
		String filterName = "a";
		TagNameFilter tableFilter = new TagNameFilter(filterName);
		NodeList nodeList = null;
		try {
			nodeList = parser.extractAllNodesThatMatch(tableFilter);
			LinkTag linkTag = (LinkTag) nodeList.elementAt(39);
			String link = linkTag.extractLink().trim();
			return "http://www.gdlottery.cn/kjggHtml/P006_"
					+ link.substring(link.length() - 5, link.length())
					+ ".html";
		} catch (ParserException e) {
			logger.error("数据解析错误", e);
			return null;
		}
	}

	@Override
	protected String getResultUrl(String phase) {
		return null;
	}
	
	
}
