package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDrawPrizeItem;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreDateUtils;
import com.lehecai.core.util.CoreFetcherUtils;
import com.lehecai.core.util.CoreStringUtils;

/**
 * 浙江体彩官网抓取
 * @author Sunshow
 *
 */
public class LotteryDrawFetchWorkerZJTC extends AbstractLotteryDrawFetchWorker{

	protected static final String BASE_URL = "http://www.zjlottery.com/";
	
	private static Map<LotteryType, String> lotteryValueMap = new HashMap<LotteryType, String>();
	
	static {
		lotteryValueMap.put(LotteryType.A_ZJ20, "6");
		lotteryValueMap.put(LotteryType.A_ZJ6, "1");
	}
	
	
	public LotteryDrawFetchWorkerZJTC(LotteryType lotteryType){
		super(lotteryType);
	}
	
	@Override
	public LotteryDraw fetchResult(String phase) {
		return null;
	}

	@Override
	public LotteryDraw fetchResultDetail(String phase) {
		LotteryType lotteryType = this.getLotteryType();
		
		String encoding = CharsetConstant.CHARSET_GB2312;
		
		String toFetchPhase = phase;
		if (toFetchPhase == null || toFetchPhase.equals("")) {			//未指定彩期，获取最新期
			String data = null;
			
			try {
				data = CoreFetcherUtils.URLGet(BASE_URL, null, encoding);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
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
			
			NodeFilter issueFileter = new HasAttributeFilter("name", "issue" + lotteryValueMap.get(lotteryType));
			NodeList titleNodeList;
			try {
				titleNodeList = parser.extractAllNodesThatMatch(issueFileter);
				if (titleNodeList.size() == 1) {
					TagNode tagNode = new TagNode();
					tagNode.setText(titleNodeList.elementAt(0).toHtml());
					toFetchPhase = tagNode.getAttribute("value");
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			
			if (toFetchPhase == null) {
				logger.error("未解析到要抓取的彩期号, lotteryType={}", lotteryType.getName());
				return null;
			}
		}
		
		logger.info("要抓取的彩期号={}, lotteryType={}", toFetchPhase, lotteryType.getName());
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("Eissue", toFetchPhase);
		params.put("Sissue", toFetchPhase);
		
		String resultDetailUrl = getResultDetailUrl(toFetchPhase);
		if (resultDetailUrl == null || resultDetailUrl.equals("")) {
			logger.error("无法解析到详情地址");
			return null;
		}
		logger.info("详情地址：{}", resultDetailUrl);
		
		
		String data = null;
		
		try {
			data = CoreFetcherUtils.URLGet(resultDetailUrl, null, encoding);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
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
		
		LotteryDraw lotteryDraw = new LotteryDraw();
		lotteryDraw.setLotteryType(lotteryType);
		
		try {
			NodeFilter tableFilter = new TagNameFilter("table");
			NodeList tableNodeList = parser.extractAllNodesThatMatch(tableFilter);
			if (tableNodeList != null && tableNodeList.size() != 0) {
				TableTag tableTag = (TableTag)tableNodeList.elementAt(1);				//第一个table为彩期和销售额table
				
				TableColumn phaseColumn = tableTag.getRow(0).getColumns()[0];			//第一列为彩期
				String phaseStr = phaseColumn.getStringText();
				lotteryDraw.setPhase(getPhase(phaseStr));
				
				if (!toFetchPhase.equals(lotteryDraw.getPhase())) {
					logger.error("要抓取的数据与指定彩期不匹配, fetchedPhase={}, phase={}", lotteryDraw.getPhase(), toFetchPhase);
					return null;
				}
				
				TableColumn volumeOfSalesColumn = tableTag.getRow(0).getColumns()[1];			//第二列为销售额
				String volumnOfSalesStr = volumeOfSalesColumn.getStringText();
				volumnOfSalesStr = trimAll(volumnOfSalesStr.replace("总投注额", "").replace("</b>", ""));
				lotteryDraw.setVolumeOfSales(getVolumeOfSales(volumnOfSalesStr));
				
				TableTag resultTableTag = (TableTag)tableNodeList.elementAt(2);			//第三个table为开奖号码的table
				String result = "";
				for (int i = 0;i < resultTableTag.getRow(0).getColumnCount();i++) {
					TableColumn resultNumColumn = resultTableTag.getRow(0).getColumns()[i];
					if (resultNumColumn.getAttribute("background") != null) {
						result += trimAll(resultNumColumn.getStringText()) + ",";
					}
				}
				if (result == null || result.equals("None")) {
					logger.error("不正确的开奖号码, result={}", result);
					return null;
				}
				result = result.substring(0, result.lastIndexOf(","));
				result = CoreStringUtils.replaceAll(result, new String[][] {
						{" ", ","},
						{"+", ""}
				});
				lotteryDraw.setResult(result);
				
				
				TableTag jackpotTag = (TableTag)tableNodeList.elementAt(6);				//第七个table为奖池和开奖时间的table
				
				TableColumn timeDrawColumn = null;
				if (jackpotTag.getRowCount() > 2) {
					TableColumn jackpotColumn = jackpotTag.getRow(1).getColumns()[0];
					timeDrawColumn = jackpotTag.getRow(2).getColumns()[1];
					String jackText = jackpotColumn.getStringText();
					lotteryDraw.setJackpot(getVolumeOfSales(CoreStringUtils.substringBetween(jackText, "总额", "全额")));
				} else {
					timeDrawColumn = jackpotTag.getRow(1).getColumns()[1];
				}
				
				String timeDrawStr = trimAll(timeDrawColumn.getStringText());
				lotteryDraw.setTimeDraw(getTimeDraw(timeDrawStr));
				
				TableTag resultDetailTag = (TableTag)tableNodeList.elementAt(5);		//第六个为开奖详情的table
				List<LotteryDrawPrizeItem> itemList = new ArrayList<LotteryDrawPrizeItem>();
				
				if (this.getLotteryType() == LotteryType.A_ZJ6) {
					for (int i = 0; i < resultDetailTag.getRowCount(); i++) {
						TableColumn prizeNameColumn = resultDetailTag.getRow(i).getColumns()[0];
						String prizeName = prizeNameColumn.getStringText();
						
						TableColumn winningCountColumn = resultDetailTag.getRow(i).getColumns()[2];
						String winningCountText = winningCountColumn.getStringText();
						String winningCount = "";
						if (winningCountText.indexOf("<b>") > -1) {
							winningCount = trimAll(CoreStringUtils.substringBetween(winningCountText, "<b>", "</b>"));
						} else {
							winningCount = trimAll(winningCountText.substring(0, winningCountText.lastIndexOf("<")));
						}
						String winningAmount = "";
						if (i < 3) {
							TableColumn winningAmountMoneyColumn = resultDetailTag.getRow(i).getColumns()[4];
							TableColumn winningAmountColumn = resultDetailTag.getRow(i).getColumns()[5];
							String winningAmountMoneyStr = CoreStringUtils.substringBetween(winningAmountMoneyColumn.getStringText(),"<b>","</b>");
							winningAmount = winningAmountMoneyStr + winningAmountColumn.getStringText();
						} else {
							TableColumn winningAmountColumn = resultDetailTag.getRow(i).getColumns()[4];
							String tempWinningAmountStr = winningAmountColumn.getStringText();
							winningAmount = CoreStringUtils.substringBetween(tempWinningAmountStr, "<b>","</b>") + CoreStringUtils.substringBetween(tempWinningAmountStr, "&nbsp;", "&nbsp;");
						}
						winningAmount = getVolumeOfSales(winningAmount);
						
						LotteryDrawPrizeItem item = new LotteryDrawPrizeItem();
						item.setName(prizeName);
						item.setWinningCount(winningCount);
						item.setPrizeAmount(winningAmount);
						
						itemList.add(item);
					}
				} else {
					for (int i = 0; i < resultDetailTag.getRowCount(); i++) {
						TableColumn prizeNameColumn = resultDetailTag.getRow(i).getColumns()[0];
						String prizeName = prizeNameColumn.getStringText();
						
						TableColumn winningCountColumn = resultDetailTag.getRow(i).getColumns()[1];
						String winningCount = winningCountColumn.getStringText();
						
						String winningAmount = "";
						TableColumn winningAmountColumn = resultDetailTag.getRow(i).getColumns()[2];
						winningAmount = getVolumeOfSales(winningAmountColumn.getStringText());
						
						LotteryDrawPrizeItem item = new LotteryDrawPrizeItem();
						item.setName(prizeName);
						item.setWinningCount(winningCount);
						item.setPrizeAmount(winningAmount);
						
						itemList.add(item);
					}
				}
				lotteryDraw.setResultDetail(itemList);
			}
			
			return lotteryDraw;
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	

	@Override
	protected String getResultDetailUrl(String phase) {
		String resultUrl = getResultUrl(phase);
		
		String encoding = CharsetConstant.CHARSET_GB2312;
		
		String data = null;
		try {
			data = CoreFetcherUtils.URLGet(resultUrl, null, encoding);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
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
		
		NodeFilter tableFilter = new HasAttributeFilter("class", "hezhi_list");
		
		NodeList tableNodeList = null;
		try {
			tableNodeList = parser.extractAllNodesThatMatch(tableFilter);
			if (tableNodeList != null && tableNodeList.size() > 0) {
					TableTag tableTag = (TableTag)tableNodeList.elementAt(0);
					
					String detailLink = "";
					for (int i = 0;i < tableTag.getRowCount();i++) {
						TableRow everyRow = tableTag.getRow(i);
						for (int j = 0;j < everyRow.getColumnCount();j++) {
							TableColumn firstColumn = everyRow.getColumns()[0];
							NodeList columnChildren = firstColumn.getChildren();
							for (int k = 0;k < columnChildren.size();k++) {
								if (columnChildren.elementAt(k) instanceof LinkTag) {
									LinkTag linkTag = (LinkTag)columnChildren.elementAt(k);
									detailLink = linkTag.getLink();
									String fetchPhase = linkTag.getLinkText();
									
									if (phase != null && !phase.equals("")) {
										if (fetchPhase.equals(phase)) {
											j = everyRow.getColumnCount();
											i = tableTag.getRowCount();
											break;
										}
									}
								}
							}
						}
					}
					
					return BASE_URL + detailLink;
			} else {
				logger.error("未找到class为hezhi_list61的table");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return null;
	}

	@Override
	protected String getResultUrl(String phase) {
		return BASE_URL + "zsfx/catchdata/folder/getdata.asp?flag=" + lotteryValueMap.get(this.getLotteryType()) + "&topnums=200&charttype=%C0%FA%CA%B7%BA%C5%C2%EB%CD%BC";
	}
	
	private String getPhase (String phaseStr) {
		if (phaseStr == null || phaseStr.equals("")) {
			return null;
		}
		return trimAll(CoreStringUtils.substringBetween(phaseStr, "第", "期"));
	}
	
	private String getTimeDraw (String timeDrawStr) {
		if (timeDrawStr == null || timeDrawStr.equals("")) {
			return null;
		}
		
		String timeDraw = trimAll(timeDrawStr);
		timeDraw = timeDraw.replace("年", "-").replace("月", "-").replace("日", "");
		try {
			timeDraw = CoreDateUtils.formatDate(CoreDateUtils.parseDate(timeDraw));
			return timeDraw;
		} catch (Exception e) {
			logger.error("格式化开奖日期异常，{}", e);
			return null;
		}
	}
	
	private String getVolumeOfSales (String volumnOfSalesStr) {
		if (volumnOfSalesStr == null || volumnOfSalesStr.equals("")) {
			return null;
		}
		
		volumnOfSalesStr = volumnOfSalesStr.replace("元", "");
		
		Double voulmnOfSales = 0.0D;
		try {
			if (volumnOfSalesStr.endsWith("万")) {
				volumnOfSalesStr = volumnOfSalesStr.substring(0, volumnOfSalesStr.length() - 1);
				volumnOfSalesStr = trimAll(volumnOfSalesStr);
				voulmnOfSales = Double.parseDouble(volumnOfSalesStr) * 10000;
			} else {
				volumnOfSalesStr = trimAll(volumnOfSalesStr);
				voulmnOfSales = Double.parseDouble(volumnOfSalesStr);
			}
			NumberFormat nf = NumberFormat.getInstance();
			nf.setGroupingUsed(false);
			nf.setMaximumFractionDigits(0);
			nf.setMinimumFractionDigits(0);
			
			return nf.format(voulmnOfSales);
		} catch (Exception e) {
			logger.error("格式化销售额异常，{}" , e);
			return null;
		}
	}
	
	/**
	 * 替换字符串的各种特殊符号
	 * @param str
	 * @return
	 */
	public static String trimAll(String str){
		
		if(str != null && !str.equals("")){
	    	str = str.replaceAll(" ", "");
	    	str = str.replaceAll("　", "");
	    	str = str.replaceAll("&nbsp;", "");
	    	str = str.replaceAll("。", "");
	    	str = str.replaceAll("：", "");
	    	str = str.replaceAll(":", "");
	    	str = str.replaceAll(",", "");
		}
    	return str;
	}
	
}
