package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.util.ArrayList;
import java.util.List;

import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDrawPrizeItem;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreFetcherUtils;
/**
 * 海南体彩网 开奖结果抓取
 * 主要抓取海南4+1  <br/>
 * 历史地址:  http://www.tc.hainan.net/zq.asp?tctype=1   <br/>
 * @author 
 *
 */
public class LotteryDrawFetch549WorkerOfficial extends AbstractLotteryDrawFetchWorker{

	public LotteryDrawFetch549WorkerOfficial() {
		super(LotteryType.A_HN4);
	}

	protected String siteName = "海南体彩网";
	protected String lotteryScope = "海南4+1";
	
	@Override
	public LotteryDraw fetchResult(String phase) {
		return null;
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
		Parser parser= null;
		try {
			parser = Parser.createParser(data,  encoding);
		} catch (Exception e) {
			logger.error("解析html页面失败" + e.getMessage());
			return null;
		}
		String filterName = "body";
		TagNameFilter tableFilter = new TagNameFilter(filterName);
		NodeList nodeList = null;
		
		try {
			nodeList = parser.extractAllNodesThatMatch(tableFilter);
			String strTmp = nodeList.elementAt(0).toPlainTextString().replaceAll("&nbsp;","");
			//彩期
			String strPhase = strTmp.substring(strTmp.indexOf("海南4+1第")+6, strTmp.indexOf("期")).trim();
			//结果
			String strResult = strTmp.substring(strTmp.indexOf("开奖结果：")+5, strTmp.indexOf("总")).replace("+", ",").trim();
			//开奖日期
			String strTime = strTmp.substring(strTmp.indexOf("开奖日：")+4,strTmp.indexOf("，止兑日")).trim();
			//销售额
			String strSales = strTmp.substring(strTmp.indexOf("总销售额：")+5, strTmp.indexOf("元")).trim();
			
			//解析中奖详情
			strTmp = strTmp.substring(strTmp.indexOf("奖级中奖注数每注奖金应派奖金"), strTmp.indexOf("var"));
			String [] strResultDetail = {"","","","","","","","","","","","","",""}; 
			strResultDetail[0] = strTmp.substring(strTmp.indexOf("4+1"), strTmp.indexOf("定位4"));
			strResultDetail[1] = strTmp.substring(strTmp.indexOf("定位4"), strTmp.indexOf("定位3"));
			strResultDetail[2] = strTmp.substring(strTmp.indexOf("定位3"), strTmp.indexOf("定位2"));
			strResultDetail[3] = strTmp.substring(strTmp.indexOf("定位2"), strTmp.indexOf("定位1"));
			strResultDetail[4] = strTmp.substring(strTmp.indexOf("定位1"), strTmp.indexOf("任选4（3重）"));
			strResultDetail[5] = strTmp.substring(strTmp.indexOf("任选4（3重）"), strTmp.indexOf("任选4（2双重）"));
			strResultDetail[6] = strTmp.substring(strTmp.indexOf("任选4（2双重）"), strTmp.indexOf("任选4（1双重）"));
			strResultDetail[7] = strTmp.substring(strTmp.indexOf("任选4（1双重）"), strTmp.indexOf("任选4（单号）"));
			strResultDetail[8] = strTmp.substring(strTmp.indexOf("任选4（单号）"), strTmp.indexOf("任选3（3重）"));
			strResultDetail[9] = strTmp.substring(strTmp.indexOf("任选3（3重）"), strTmp.indexOf("任选3（双重）"));
			strResultDetail[10] = strTmp.substring(strTmp.indexOf("任选3（双重）"), strTmp.indexOf("任选3（单号）"));
			strResultDetail[11] = strTmp.substring(strTmp.indexOf("任选3（单号）"), strTmp.indexOf("任选2（双重）"));
			strResultDetail[12] = strTmp.substring(strTmp.indexOf("任选2（双重）"), strTmp.indexOf("任选2（单号）"));
			strResultDetail[13] = strTmp.substring(strTmp.indexOf("任选2（单号）"));
			
			List<LotteryDrawPrizeItem> resultDetail = new ArrayList<LotteryDrawPrizeItem>();
			//4+1
			LotteryDrawPrizeItem lotteryDrawPrizeItemSiJiayi = new LotteryDrawPrizeItem();
			lotteryDrawPrizeItemSiJiayi.setName(strResultDetail[0].substring(0, 3).trim());
			lotteryDrawPrizeItemSiJiayi.setPrizeAmount(strResultDetail[0].substring(strResultDetail[0].indexOf("注")+1, strResultDetail[0].indexOf("元")).trim());
			lotteryDrawPrizeItemSiJiayi.setWinningCount(strResultDetail[0].substring(3, strResultDetail[0].indexOf("注")).trim());
			resultDetail.add(lotteryDrawPrizeItemSiJiayi);
			//定位
			for(int i=1;i<5;i++){
				LotteryDrawPrizeItem lotteryDrawPrizeItemDingWei = new LotteryDrawPrizeItem();
				lotteryDrawPrizeItemDingWei.setName(strResultDetail[i].substring(0, strResultDetail[i].indexOf("位")+2).trim());
				lotteryDrawPrizeItemDingWei.setPrizeAmount(strResultDetail[i].substring(strResultDetail[i].indexOf("注")+1, strResultDetail[i].indexOf("元")).trim());
				lotteryDrawPrizeItemDingWei.setWinningCount(strResultDetail[i].substring(strResultDetail[i].indexOf("位")+2, strResultDetail[i].indexOf("注")).trim());
				resultDetail.add(lotteryDrawPrizeItemDingWei);
			}
			//任选
			for(int i=5;i<14;i++){
				LotteryDrawPrizeItem lotteryDrawPrizeItemRenXuan = new LotteryDrawPrizeItem();
				lotteryDrawPrizeItemRenXuan.setName(strResultDetail[i].substring(0, strResultDetail[i].indexOf("）")+1).trim());
				lotteryDrawPrizeItemRenXuan.setPrizeAmount(strResultDetail[i].substring(strResultDetail[i].indexOf("注")+1, strResultDetail[i].indexOf("元")).trim());
				lotteryDrawPrizeItemRenXuan.setWinningCount(strResultDetail[i].substring(strResultDetail[i].indexOf("）")+1, strResultDetail[i].indexOf("注")).trim());
				resultDetail.add(lotteryDrawPrizeItemRenXuan);
			}
			
			//set lotteryDraw
			lotteryDraw.setResultDetail(resultDetail);
			//判断彩期是否一致
			if (phase != null && !"".equals(phase)){
				if (strPhase.equals(phase)){
					lotteryDraw.setPhase(strPhase);
				} else{
					logger.error("要抓取的数据与指定彩期不匹配, fetchedPhase={}, phase={}", strPhase, phase);
					return null;
				}
			} else{
				lotteryDraw.setPhase(strPhase);
			}
			lotteryDraw.setLotteryType(lotteryType);
			lotteryDraw.setResult(strResult);
			lotteryDraw.setTimeDraw(strTime + " 00:00:00");
			lotteryDraw.setVolumeOfSales(strSales);
			
			logger.info(logHeader+lotteryDraw.getLotteryOpenResultLogMsg());
			
		} catch (ParserException e){
			logger.error("数据解析错误==" + e.getMessage(), e);
			return null;
		}
		return lotteryDraw;
	}

	@Override
	protected String getResultDetailUrl(String phase) {
		String toFetchPhase = phase;
		if (toFetchPhase == null || toFetchPhase.trim().length() == 0) {
			logger.info("未指定彩期，从首页获取最新开奖详情地址");
			// 获取最新期
			String encoding = CharsetConstant.CHARSET_GBK;
			String data = null;
			
			try {
				data = CoreFetcherUtils.URLGet("http://www.tc.hainan.net/zq.asp?tctype=1", null, encoding);
			} catch (Exception e) {
				logger.error("获取html数据失败" + e.getMessage(), e);
			}
			if (data == null || data.indexOf("404 Not Found") > 0) {
				logger.error("抓取列表页面内容出错");
				return null;
			}
			
			Parser parser = null;
			try {
				parser = Parser.createParser(data, encoding);
			} catch (Exception e) {
				logger.error("解析html出错, data={}", data);
				return null;
			}
			
			try {
				TagNameFilter selectTagFileter = new TagNameFilter("select");
				NodeList selectNodeList = parser.extractAllNodesThatMatch(selectTagFileter);
				
				if (selectNodeList.size() > 0) {
					parser.setInputHTML(selectNodeList.elementAt(0).toHtml());
					TagNameFilter optionTagFileter = new TagNameFilter("option");
					NodeList optionNodeList = parser.extractAllNodesThatMatch(optionTagFileter);
					if (optionNodeList.size() > 0) {
						TagNode tagNode = new TagNode();
						tagNode.setText(optionNodeList.elementAt(0).toHtml());
						toFetchPhase = tagNode.getAttribute("value");
					}
				}
			} catch (Exception e) {
				logger.error("解析html出错" + e.getMessage(), e);
			}
		}
		if (toFetchPhase != null) {
			return "http://www.tc.hainan.net/gg.asp?type=1&qh=" + toFetchPhase;
		}
		return null;
	}

	@Override
	protected String getResultUrl(String phase) {
		return null;
	}

}
