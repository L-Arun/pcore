package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDrawPrizeItem;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreDateUtils;
import com.lehecai.core.util.CoreStringUtils;

/**
 * 福建体彩网 开奖结果抓取
 * 主要抓取福建体彩22选5  <br/>
 * 历史地址:  http://www.fjtc.com.cn/tckjpage/kj2205.html<br/>
 * @author 
 *
 */
public class LotteryDrawFetch508WorkerOfficial extends LotteryDrawFetchWorkerFJTC{

	public LotteryDrawFetch508WorkerOfficial() {
		super(LotteryType.A_FJ22);
	}

	@Override
	protected LotteryDraw parseLotteryDrawResult(String html) {
		LotteryType lotteryType = this.getLotteryType();
		Parser parser = null;
		try {
			parser = Parser.createParser(html, CharsetConstant.CHARSET_UTF8);
		} catch (Exception e) {
			logger.error("解析html内容出错: {}", html, e);
			return null;
		}
		
		LotteryDraw lotteryDraw = new LotteryDraw();
		lotteryDraw.setLotteryType(lotteryType);
		
		// 解析基本信息
		try {
			NodeFilter tInfoFilter = new HasAttributeFilter("class", "tInfo");
			NodeList tInfoNodeList = parser.extractAllNodesThatMatch(tInfoFilter);
			if (tInfoNodeList.size() == 0) {
				return null;
			}
			parser.setInputHTML(tInfoNodeList.elementAt(0).toHtml());
			// 取四个红色部分，依次为彩期、销售总额、开奖日期、开奖号码
			NodeFilter redFilter = new HasAttributeFilter("class", "fc-red");
			NodeList redNodeList = parser.extractAllNodesThatMatch(redFilter);
			if (redNodeList.size() < 4) {
				logger.error("解析的内容不符合要求: {}", tInfoNodeList.elementAt(0).toHtml());
				return null;
			}
			lotteryDraw.setPhase(redNodeList.elementAt(0).toPlainTextString().trim());
			lotteryDraw.setVolumeOfSales(StringUtils.replace(redNodeList.elementAt(1).toPlainTextString().trim(), ",", ""));
			Date drawDate = CoreDateUtils.parseDate(redNodeList.elementAt(2).toPlainTextString().trim(), "yyyy年MM月dd日");
			if (drawDate != null) {
				lotteryDraw.setTimeDraw(CoreDateUtils.formatDateTime(drawDate));
			}
			lotteryDraw.setResult(StringUtils.replace(redNodeList.elementAt(3).toPlainTextString().trim(), " ", ","));
		} catch (ParserException e) {
			logger.error(e.getMessage(), e);
			return null;
		}
		
		// 解析详情信息
		try {
			parser.setInputHTML(html);
			NodeFilter dInfoFilter = new HasAttributeFilter("class", "dInfo");
			NodeList dInfoNodeList = parser.extractAllNodesThatMatch(dInfoFilter);
			if (dInfoNodeList.size() == 0) {
				return null;
			}
			parser.setInputHTML(dInfoNodeList.elementAt(0).toHtml());
			NodeFilter prizeFilter = new TagNameFilter("p");
			NodeList prizeNodeList = parser.extractAllNodesThatMatch(prizeFilter);
			if (prizeNodeList.size() == 0) {
				return null;
			}
			String[] splitted = prizeNodeList.elementAt(0).toPlainTextString().split("--------------------------------------------------");
			if (splitted.length < 2) {
				logger.error("未解析到{}开奖详情: {}", lotteryType.getName());
				return lotteryDraw;
			}
			splitted = StringUtils.split(splitted[1].trim(), "&nbsp;");
			
			List<LotteryDrawPrizeItem> resultDetail = new ArrayList<LotteryDrawPrizeItem>();
			int index = -1;
			LotteryDrawPrizeItem prizeItem = null;
			for (int i = 0; i < splitted.length; i++) {
				String s = splitted[i].trim();
				if (s.length() == 0) {
					continue;
				}
				index ++;
				if (index % 4 == 0) {
					// 一行有4列
					index = 0;
					prizeItem = new LotteryDrawPrizeItem();
					resultDetail.add(prizeItem);
				}
				switch (index) {
				case 0:
					prizeItem.setName(s);
					break;
				case 1:
					prizeItem.setWinningCount(StringUtils.replace(s, "注", ""));
					break;
				case 2:
					prizeItem.setPrizeAmount(CoreStringUtils.replaceAll(s, new String[][] {
							{"元", ""},
							{",", ""}
					}));
					break;
				default:
					break;
				}
			}
			lotteryDraw.setResultDetail(resultDetail);
		} catch (ParserException e) {
			logger.error(e.getMessage(), e);
		}
		
		return lotteryDraw;
	}
	
	public static void main(String[] args) {
		LotteryDrawFetch508WorkerOfficial worker = new LotteryDrawFetch508WorkerOfficial();
		worker.fetchResultDetail(null);
	}
}
