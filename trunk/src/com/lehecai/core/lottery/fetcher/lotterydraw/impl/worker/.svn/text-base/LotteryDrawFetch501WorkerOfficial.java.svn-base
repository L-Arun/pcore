package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.util.ArrayList;
import java.util.List;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDrawPrizeItem;
import com.lehecai.core.util.CoreFetcherUtils;

/**
 * 北京福彩网 开奖结果抓取
 * 北京两步彩  <br/>
 * 历史地址:http://www.bwlc.net/bulletin/index.jsp?id=6  <br/>
 * @author liurd
 *
 */
public class LotteryDrawFetch501WorkerOfficial extends AbstractLotteryDrawFetchWorker {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	protected static final String RESULT_LOCALITY_URL = "http://www.bwlc.net/bulletin/index.jsp?id=6";
	protected static final String RESULT_MORE_LOCALITY_URL = "http://www.bwlc.net/bulletin/search.jsp?id=6&period=";
	protected static final String RESULT_HOST = "http://www.bwlc.net/bulletin/";
	
	protected String siteName = "北京福彩网";
	protected String lotteryScope = "北京两步彩";
	
	private String strDate;
	
	public LotteryDrawFetch501WorkerOfficial() {
		super(LotteryType.A_BJLB);
	}
	
	@Override
	public LotteryDraw fetchResultDetail(String phase) {
		
		LotteryDraw lotteryDraw = null;
		lotteryDraw = nowPhaseResult();
		String url = "";
		
		if ("".equals(phase) || phase == null) {
			phase = lotteryDraw.getPhase();
		} else {
			lotteryDraw = null;
		}
		if (!"".equals(phase) && phase != null) {
			url = getResultDetailUrl(phase);
		}
		
		if (url == null || "".equals(url)) {
			logger.error("==url获取失败==");
			return null;
		}
		
		lotteryDraw = fetchDetail(url);
		return lotteryDraw;
	}

	private LotteryDraw nowPhaseResult() {
		return fetchDetail(RESULT_LOCALITY_URL);
	}
	
	private LotteryDraw fetchDetail(String url) {
		LotteryDraw lotteryDraw = null;
		String data = null;
		Parser parser = null;
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
		try {
			parser = Parser.createParser(data,  encoding);
		} catch (Exception e) {
			logger.error("解析html页面失败" + e.getMessage());
			return null;
		}
		List<LotteryDrawPrizeItem> lotteryDrawPrizeItemList = null;
		
		NodeFilter filter = new HasAttributeFilter("id", "gameListItem-4");
		NodeList nodeList = null;
		
		try {
			nodeList = parser.extractAllNodesThatMatch(filter);
			lotteryDraw = new LotteryDraw();
			//彩期
			String strPhase = nodeList.elementAt(0).getChildren().elementAt(0).toPlainTextString().replace("期", "").trim();
			lotteryDraw.setPhase(strPhase);
			//彩种
			lotteryDraw.setLotteryType(getLotteryType());
			//开奖结果
			TableTag tableTag = (TableTag) nodeList.elementAt(0).getChildren().elementAt(1);
			String strResult = tableTag.getRows()[0].getColumns()[1].toPlainTextString().replace("&nbsp;", "").replace(" ", "");
			char[] strResultArray = strResult.toCharArray();
			strResult = strResultArray[0] + ","
						+ strResultArray[1] + ","
						+ strResultArray[2] + ","
						+ strResultArray[3] + ","
						+ strResultArray[5] + strResultArray[6];
			lotteryDraw.setResult(strResult);
			//销量
			int tmp = 4;
			for (; tmp < nodeList.elementAt(0).getChildren().size(); tmp++) {
				if (nodeList.elementAt(0).getChildren().elementAt(tmp) instanceof TextNode) {
					if (nodeList.elementAt(0).getChildren().elementAt(tmp).toPlainTextString().indexOf("本期投注总额为") != -1) {
						String strSale = nodeList.elementAt(0).getChildren().elementAt(tmp).toPlainTextString();
						strSale = strSale.substring(8, strSale.indexOf("元"));
						lotteryDraw.setVolumeOfSales(strSale);
						break;
					}
				}
			}
			//奖池
			for (; tmp < nodeList.elementAt(0).getChildren().size(); tmp++) {
				if (nodeList.elementAt(0).getChildren().elementAt(tmp) instanceof TextNode) {
					if (nodeList.elementAt(0).getChildren().elementAt(tmp).toPlainTextString().indexOf("全彩一等奖奖池金额为") != -1) {
						String strPool = nodeList.elementAt(0).getChildren().elementAt(tmp).toPlainTextString();
						strPool = strPool.substring(11, strPool.indexOf("元"));
						lotteryDraw.setJackpot(strPool);
						break;
					}
					
				}
			}
			//开奖日期
			if (strDate != null && !"".equals(strDate)) {
				lotteryDraw.setTimeDraw(strDate + " 00:00:00");
			}
			//开奖详情
			for (int k = nodeList.elementAt(0).getChildren().size(); k >= 0; k--) {
				if (nodeList.elementAt(0).getChildren().elementAt(k) != null && nodeList.elementAt(0).getChildren().elementAt(k) instanceof TableTag) {
					tableTag = (TableTag) nodeList.elementAt(0).getChildren().elementAt(k);
					lotteryDrawPrizeItemList = new ArrayList<LotteryDrawPrizeItem>();
					TableRow[] tableRows = tableTag.getRows();
					String name1 = "", name2 = "", name3 = "";
					int i = 2;
					for (; i < 6; i++) {
						LotteryDrawPrizeItem lotteryDrawPrizeItem = new LotteryDrawPrizeItem();
						int j = 0;
						TableColumn[] tableColumns = tableRows[i].getColumns();
						if (tableColumns.length == 4) {
							name1 = tableColumns[j].toPlainTextString();
							j++;
						}
						name2 = tableColumns[j].toPlainTextString();
						j++;
						lotteryDrawPrizeItem.setName(name1 + name2);
						lotteryDrawPrizeItem.setWinningCount(tableColumns[j].toPlainTextString());
						j++;
						lotteryDrawPrizeItem.setPrizeAmount(tableColumns[j].toPlainTextString());
						lotteryDrawPrizeItemList.add(lotteryDrawPrizeItem);
					}
					name1 = "";
					name2 = "";
					name3 = "";
					for (; i < 31; i++) {
						LotteryDrawPrizeItem lotteryDrawPrizeItem = new LotteryDrawPrizeItem();
						int j = 0;
						TableColumn[] tableColumns = tableRows[i].getColumns();
						if (tableColumns.length == 5) {
							name1 = tableColumns[j].toPlainTextString();
							j++;
							name2 = tableColumns[j].toPlainTextString();
							j++;
						}
						if (tableColumns.length == 4) {
							name2 = tableColumns[j].toPlainTextString();
							j++;
						}
						name3 = tableColumns[j].toPlainTextString();
						j++;
						lotteryDrawPrizeItem.setName(name1 + name2 + name3);
						lotteryDrawPrizeItem.setWinningCount(tableColumns[j].toPlainTextString());
						j++;
						lotteryDrawPrizeItem.setPrizeAmount(tableColumns[j].toPlainTextString());
						lotteryDrawPrizeItemList.add(lotteryDrawPrizeItem);
					}
					TableColumn[] tableColumns = tableRows[i].getColumns();
					LotteryDrawPrizeItem lotteryDrawPrizeItem = new LotteryDrawPrizeItem();
					lotteryDrawPrizeItem.setName(tableColumns[0].toPlainTextString());
					lotteryDrawPrizeItem.setWinningCount(tableColumns[2].toPlainTextString());
					lotteryDrawPrizeItem.setPrizeAmount(tableColumns[3].toPlainTextString());
					lotteryDrawPrizeItemList.add(lotteryDrawPrizeItem);
					break;
				}
			}
			lotteryDraw.setResultDetail(lotteryDrawPrizeItemList);
		} catch (Exception e) {
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
		String url = RESULT_MORE_LOCALITY_URL + phase;
		Parser parser = null;
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
		
		try {
			parser = Parser.createParser(data,  encoding);
		} catch (Exception e) {
			logger.error("解析html页面失败" + e.getMessage());
			return null;
		}
		
		NodeFilter filter = new HasAttributeFilter("class", "tableBack");
		NodeList nodeList = null;
		
		try {
			nodeList = parser.extractAllNodesThatMatch(filter);
			TableTag tableTag = (TableTag) nodeList.elementAt(4);
			LinkTag linkTag = (LinkTag) tableTag.getRows()[1].getColumns()[0].getChildren().elementAt(0);
			strDate = tableTag.getRows()[1].getColumns()[1].toPlainTextString();
			return  RESULT_HOST+ linkTag.extractLink();
		} catch (Exception e) {
			logger.error("数据解析错误==" + e.getMessage(), e);
			return null;
		} 
	}

	@Override
	protected String getResultUrl(String phase) {
		return null;
	}
}
