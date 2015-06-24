package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.Span;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDrawPrizeItem;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreFetcherUtils;
import com.lehecai.core.util.CoreStringUtils;

/**
 * 黑龙江p62数据抓取实现类
 * @author yanweijie
 *
 */
public class LotteryDrawFetch529WorkerOfficial extends AbstractLotteryDrawFetchWorker{

	protected static final String BASE_URL = "http://kaijiang.zhcw.com/";
	protected static final String RESULT_URL = "http://kaijiang.zhcw.com/heilongjiang/static/html/p62/list/list_p62_1.html";
	
	protected String siteName = "黑龙江P62";
	protected String lotteryScope = "地方开奖";
	
	
	public LotteryDrawFetch529WorkerOfficial(){
		super(LotteryType.A_HLJP62);
	}
	
	@Override
	public LotteryDraw fetchResult(String phase) {
		return null;
	}
	
	@Override
	public LotteryDraw fetchResultDetail(String phase) {
		String url = this.getResultDetailUrl(phase);	//获取详情地址
		if (url == null) {
			logger.error("无法解析到详情地址");
			return null;
		}
		
		String encoding = CharsetConstant.CHARSET_UTF8;
		
		String pageInfo = "详细页面" + url;
		String logHeader = pageInfo + "==抓取==" + getLotteryType().getName() + "==";

		logger.info(logHeader + "开始==");
		
		
		Map<String, String> headerParams = new HashMap<String, String>();
		headerParams.put("Referer", "http://www.lottost.cn/index.html");
		headerParams.put("user-agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.8) Gecko/20100722 Firefox/3.6.8");
		
		String data = "";
		data = CoreFetcherUtils.URLGetWithHeaderParams(url, headerParams, null, encoding);
		
		if (data == null || data.indexOf("404 Not Found") > 0 || data.isEmpty()) {
			logger.error(logHeader + "data is null or 404 Not Found");
			return null;
		}

		Parser parser = null;
		NodeList nodeList = null;
		String getPhase = "";							//彩期
		String timeDraw = "";							//开奖日期
		String volumeOfSales = "";						//销售量
		String jackPot = "";							//奖池
		String result = "";								//开奖结果
		List<LotteryDrawPrizeItem> resultDetail = null;	//开奖详情
		NodeFilter tableFilter = new TagNameFilter("table");
		try {
			parser= Parser.createParser(data,  encoding);
			nodeList = parser.extractAllNodesThatMatch(tableFilter);

			if (nodeList == null || nodeList.size() == 0) {
				logger.error("没有对应的table节点");
			} else {
				if (!(nodeList.elementAt(0) instanceof TableTag)) {
					logger.error("第一个节点不是table节点");
				} else {
					TableTag tableTag = (TableTag)nodeList.elementAt(0);
					TableRow[] tableRows = tableTag.getRows();
					if (tableRows == null || tableRows.length == 0) {
						logger.error("没有对应的tr节点");
					} else {
						if (tableRows[0] == null) {//第一行存有彩期和开奖日期
							logger.error("没有彩期和开奖日期对应的行");
						} else {
							TableColumn[] phaseAndLotteryDrawColumn = tableRows[0].getColumns();
							if (phaseAndLotteryDrawColumn == null || phaseAndLotteryDrawColumn.length == 0) {
								logger.error("彩期和开奖日期对应的列不存在");
							} else {
								if (phaseAndLotteryDrawColumn[0] == null) {
									logger.error("彩期对应的列不存在");
								} else {
									String phaseText = phaseAndLotteryDrawColumn[0].getStringText();		//第一列存有彩期
									if (phaseText == null || phaseText.equals("")) {
										logger.error("期号为空");
									} else {
										getPhase = CoreStringUtils.substringBetween(phaseText, "第","期").trim();			//期号
									}
								}
								if (phaseAndLotteryDrawColumn[1] == null) {
									logger.error("开奖日期对应的列不存在");
								} else {
									String timeDrawText = phaseAndLotteryDrawColumn[1].getStringText();	//第二列存有开奖日期
									if (timeDrawText == null || timeDrawText.equals("")) {
										logger.error("开奖日期为空");
									} else {
										timeDraw = timeDrawText.replace("开奖日期:", "").trim();
									}
								}
							}
						}//结束第一行
						if (tableRows[1] == null) {//第二行存有销售量和奖池
							logger.error("没有销量和奖池对应的行");
						} else {
							TableColumn[] volumeOfSalesAndJackPotColumn = tableRows[1].getColumns();
							if (volumeOfSalesAndJackPotColumn == null || volumeOfSalesAndJackPotColumn.length == 0) {
								logger.error("销量和奖池对应的列不存在");
							} else {
								if (volumeOfSalesAndJackPotColumn[0] == null) {
									logger.error("销量对应的列不存在");
								} else {
									String volumeOfSalesText = volumeOfSalesAndJackPotColumn[0].getStringText();		//第一列存有销售量
									if (volumeOfSalesText == null || volumeOfSalesText.equals("")) {
										logger.error("销售量为空");
									} else {
										volumeOfSales = parseVolumeOfSales(volumeOfSalesText);		//销售量
									}
								}
								if (volumeOfSalesAndJackPotColumn[1] == null ) {
									logger.error("奖池对应的列不存在");
								} else {
									String jackpotText = volumeOfSalesAndJackPotColumn[1].getStringText();	//第二列存有奖池
									if (jackpotText == null || jackpotText.equals("")) {
										logger.error("奖池为空");
									} else {
										jackPot = parseJackpot(jackpotText);						//奖池
									}
								}
							}
						}//结束第二行
						if (tableRows[2] == null) {//第三行存有开奖结果
							logger.error("开奖结果对应的行不存在");
						} else {
							TableColumn[] resultColumn = tableRows[2].getColumns();
							if (resultColumn == null || resultColumn.length == 0) {
								logger.error("开奖结果对应的列不存在");
							} else {
								NodeList columnChildrenList = resultColumn[0].getChildren();		//存有开奖结果
								if (columnChildrenList == null || columnChildrenList.size() == 0) {
									logger.error("开奖结果对应的span不存在");
								} else {
									String basieResultText = "";
									if (columnChildrenList.elementAt(1) == null) {
										logger.error("基本号对应的节点不存在");
									} else {
										if (!(columnChildrenList.elementAt(1) instanceof Span)) {
											logger.error("基本号对应的节点不是span标记");
										} else {
											Span basieResultSpan = (Span)columnChildrenList.elementAt(1);
											basieResultText = basieResultSpan.getStringText().replace("基本号", "");
											basieResultText = parseBasicResult(basieResultText);
										}
									}
									String specialResultText = "";
									if (columnChildrenList.elementAt(3) == null) {
										logger.error("特别号对应的节点不存在");
									} else {
										if (!(columnChildrenList.elementAt(3) instanceof Span)) {
											logger.error("特别号对应的节点不是span标记");
										} else {
											Span specialResultSpan = (Span)columnChildrenList.elementAt(3);
											specialResultText = specialResultSpan.getStringText().replace("&nbsp;&nbsp;&nbsp;特别号", "").trim();
										}
									}
									if ((basieResultText != null && !basieResultText.equals("")) 
											&& (specialResultText != null && !specialResultText.equals(""))) {
										result = basieResultText + "," + specialResultText;				//开奖结果
									}
								}
							}
						}//结束第三行
						resultDetail = new ArrayList<LotteryDrawPrizeItem>();
						String name = "";			//奖级名称
						String winningCount = "";	//中奖注数
						String prizeAmount = "";	//中奖金额
						for (int i = 5;i < tableRows.length;i++) {//第五行到第十行为中将详情
							LotteryDrawPrizeItem item = new LotteryDrawPrizeItem();
							if (tableRows[i] == null) {
								logger.error("中奖详情对应的行不存在");
							} else {
								TableColumn[] itemColumn = tableRows[i].getColumns();
								if (itemColumn == null || itemColumn.length == 0) {
									logger.error("中奖详情对应的列不存在");
								} else {
	 								if (itemColumn[0] == null) {
										logger.error("奖级名称对应的列不存在");
									} else {
										name = itemColumn[0].getStringText();		//第一列为奖级名称
									}
									if (itemColumn[2] == null) {
										logger.error("中奖注数对应的列不存在");
									} else {
										winningCount = itemColumn[2].getStringText();	//第二列为中将注数
									}
									if (itemColumn[3] == null) {
										logger.error("中奖金额对应的列不存在");
									} else {
										String prizeAmountText = itemColumn[3].getStringText();
										prizeAmountText = prizeAmountText.replace("/注", "");
										if (prizeAmountText == null || prizeAmountText.equals("")) {
											logger.error("中奖金额为空");
										} else {
											prizeAmount = this.dealPrize(prizeAmountText);	//第三列为中奖金额
										}
									}
								}
							}
							item.setName(name);
							item.setWinningCount(winningCount);
							item.setPrizeAmount(prizeAmount);
							
							resultDetail.add(item);
						}
					}
				}
			}
		} catch (ParserException e) {
			logger.info(logHeader+"解析开奖详情异常");
		}
		
		if (phase != null && !phase.equals("")) {
			if (!getPhase.equals(phase)) {
				logger.error("抓取到的彩期与指定的彩期不一致");
				return null;
			}
		}
		
		LotteryDraw lotteryDraw = new LotteryDraw();
		lotteryDraw.setPhase(getPhase);
		lotteryDraw.setResult(result);
		lotteryDraw.setResultDetail(resultDetail);
		lotteryDraw.setVolumeOfSales(volumeOfSales);
		lotteryDraw.setJackpot(jackPot);
		lotteryDraw.setTimeDraw(timeDraw);
		
		return lotteryDraw;
		
	}

	/**
	 * 取得详情地址
	 */
	@Override
	protected String getResultDetailUrl(String phase) {
		String detailUrl = "";
		String encoding = CharsetConstant.CHARSET_UTF8;
		String data = null;
		Parser parser = null;
		int pageCount = 1;
		if (phase != null && !phase.equals("")) {//如果有指定彩期
			try {
				data = CoreFetcherUtils.URLGet(RESULT_URL, null, encoding);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			if (data == null || data.indexOf("404 Not Found") > 0) {
				logger.error("抓取列表页面内容出错");
				return null;
			}
			try {
				parser = Parser.createParser(data, encoding);
			} catch (Exception e) {
				logger.error("解析html出错, data={}", data);
				return null;
			}
			try {
				TagNameFilter tableTagFilter = new TagNameFilter("table");
				NodeList tableNodeList = parser.extractAllNodesThatMatch(tableTagFilter);
				
				if (tableNodeList == null || tableNodeList.size() == 0) {
					logger.error("没有对应的table节点");
				} else {
					if (!(tableNodeList.elementAt(0) instanceof TableTag)) {
						logger.error("第一个元素不是table节点");
					} else {
						TableTag  tableTag = (TableTag)tableNodeList.elementAt(0);
						TableRow[] pageRows = tableTag.getRows();
						
						if (pageRows == null || pageRows.length == 0) {
							logger.error("没有对应的tr节点");
						} else {
							TableRow pageRow = pageRows[pageRows.length - 1];
							TableColumn[] pageColumns = pageRow.getColumns();
							if (pageColumns == null || pageColumns.length == 0) {
								logger.error("没有对应的td节点");
							} else {
								String pageText = pageColumns[0].getStringText();
								pageText = CoreStringUtils.substringBetween(pageText, "共","页").trim();
								if (pageText != null && !pageText.equals("")) {
									pageCount = Integer.parseInt(pageText);	//取总页数
								}
							}
						}
					}
				}
			} catch (Exception e) {
				logger.error("解析最新彩期异常");
			}
		}
		
		for (int i = 1; i <= pageCount ;i ++) {
			String resultUrl = "http://kaijiang.zhcw.com/heilongjiang/static/html/p62/list/list_p62_" + i + ".html";
			try {
				data = CoreFetcherUtils.URLGet(resultUrl, null, encoding);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			if (data == null || data.indexOf("404 Not Found") > 0) {
				logger.error("抓取列表页面内容出错");
				return null;
			}
			try {
				parser = Parser.createParser(data, encoding);
			} catch (Exception e) {
				logger.error("解析html出错, data={}", data);
				return null;
			}
			try {
				TagNameFilter tableTagFilter = new TagNameFilter("table");
				NodeList tableNodeList = parser.extractAllNodesThatMatch(tableTagFilter);
				
				if (tableNodeList == null || tableNodeList.size() == 0) {
					logger.error("没有对应的table节点");
				} else {
					if (!(tableNodeList.elementAt(0) instanceof TableTag)) {
						logger.error("第一个元素不是table节点");
					} else {
						TableTag  tableTag = (TableTag)tableNodeList.elementAt(0);
						TableRow[] rows = tableTag.getRows();
						
						if (rows == null || rows.length == 0) {
							logger.error("没有对应的tr节点");
						} else {
							for (int j = 1;j<rows.length;j++) {
								TableColumn[] columns = rows[j].getColumns();
								String getPhase = columns[0].getStringText();		//第一列存有彩期
								NodeList linkNodeList = columns[3].getChildren();	//第四列存有详情地址
								if (linkNodeList == null || linkNodeList.size() == 0) {
									logger.error("td节点没有对应的子节点");
								} else {
									if (!(linkNodeList.elementAt(0) instanceof LinkTag)) {
										logger.error("对应的子节点不是a节点");
									} else {
										LinkTag detailUrlTag = (LinkTag)linkNodeList.elementAt(0);
										detailUrl = detailUrlTag.getLink();	//详情地址
									}
								}
								
								if (phase == null || phase.equals("")) {//没有指定彩期
									if (i == 1 && j == 1) {//取得第一页的第一行的详情地址
										return BASE_URL + detailUrl;
									}
								} else {//有指定彩期
									if (getPhase.equals(phase)) {//指定彩期和抓取到的彩期一直
										return BASE_URL + detailUrl;
									}
								}
							}
						}
					}
				}
			} catch (Exception e) {
				logger.error("解析详情地址异常");
			}
		}
		return null;
	}

	@Override
	protected String getResultUrl(String phase) {
		return null;
	}
	
	/**
	 * 解析奖池
	 * @param jackPot
	 * @return
	 */
	protected String parseJackpot(String jackPot) {
		if (jackPot == null || jackPot.equals("")) {
			return null;
		}
		jackPot = jackPot.replaceAll("滚入下期:", "");
		jackPot = trimAll(jackPot);
		if (jackPot == null || jackPot.equals("")) {
			return null;
		}
		return this.dealPrize(jackPot);
	}
	
	/**
	 * 解析销售总额
	 * @param volumeOfSales
	 * @return
	 */
	protected String parseVolumeOfSales(String volumeOfSales) {
		if (volumeOfSales == null || volumeOfSales.equals("")) {
			return null;
		}
		volumeOfSales = volumeOfSales.replaceAll("投注总额:", "");
		volumeOfSales = trimAll(volumeOfSales);
		if (volumeOfSales == null || volumeOfSales.equals("")) {
			return null;
		}
		
		return this.dealPrize(volumeOfSales);
	}
	
	/**
	 * 解析中奖号码
	 * @param result
	 * @return
	 */
	protected String parseBasicResult(String resultText) {
		if (resultText == null || resultText.equals("")) {
			return null;
		}
		resultText = resultText.replaceAll("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;", ",");
		resultText = resultText.trim();
		
		return resultText;
	}
	
	/**
	 * 处理金额
	 * @param prize
	 * @return
	 */
	private String dealPrize(String prize) {
		if (prize == null || "".equals(prize)) {
			return null;
		}
		
		Double doublePrize = 0.00D;
		
		prize = prize.replaceAll("元", "");
		prize = trimAll(prize);//去除","
		
		if (prize == null || "".equals(prize)) {
			return null;
		}
		boolean endsWan = false;
		if (prize.endsWith("万")) {
			endsWan = true;
			prize = prize.substring(0, prize.length() - 1);//去掉万
		}
		if (prize == null || "".equals(prize)) {
			logger.info("金额为空");
			return null;
		}
		try {
			doublePrize = Double.parseDouble(prize);//转成Double类型是为了格式化
		} catch (Exception e) {
			logger.error("奖池数据转换成Double类型失败");
			return null;
		}
		
		if (endsWan) {
			doublePrize = doublePrize * 10000;//如果是以万结尾，则乘以10000
		}
		
		NumberFormat myformat = NumberFormat.getInstance();
		myformat.setGroupingUsed(false);		//设成false，不以","隔开
		myformat.setMaximumFractionDigits(0);	//设置最多小数位数
		myformat.setMinimumFractionDigits(0);	//设置最少小数位数
		prize = myformat.format(doublePrize);	//格式化
		
		return prize;
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
