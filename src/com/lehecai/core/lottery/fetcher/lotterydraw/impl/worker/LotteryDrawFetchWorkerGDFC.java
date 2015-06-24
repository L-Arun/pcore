package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.Span;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDrawPrizeItem;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreFetcherUtils;
import com.lehecai.core.util.CoreStringUtils;

/**
 * 南粤风采官网抓取
 * @author yanweijie
 *
 */
public class LotteryDrawFetchWorkerGDFC extends AbstractLotteryDrawFetchWorker{
	
	protected static final String BASE_URL = "http://www.gdfc.org.cn";
	
	private static Map<LotteryType, String> lotteryIndexUrlMap = new HashMap<LotteryType, String>();//对应彩种的列表页，用于未指定彩期时，抓取最新期
	private static Map<LotteryType, String> lotteryResultPrefixMap = new HashMap<LotteryType, String>();//对应彩种对应页数的列表页，用于指定彩期时，查找对应的彩期
	
	static {
		lotteryIndexUrlMap.put(LotteryType.A_NYFC26, "http://www.gdfc.org.cn/play_list_game_2.html");//南粤风采26选5
		lotteryIndexUrlMap.put(LotteryType.A_NYFC36, "http://www.gdfc.org.cn/play_list_game_1.html");//南粤风采36选7
		lotteryIndexUrlMap.put(LotteryType.A_NYFCHC1, "http://www.gdfc.org.cn/play_list_game_8.html");//南粤风采好彩1
		
		lotteryResultPrefixMap.put(LotteryType.A_NYFC26, "265");//南粤风采26选5
		lotteryResultPrefixMap.put(LotteryType.A_NYFC36, "367");//南粤风采36选7
		lotteryResultPrefixMap.put(LotteryType.A_NYFCHC1, "haocai");//南粤风采好彩1
	}
	
	/**
	 * 是否是支持抓取的彩种
	 * @param lotteryType
	 * @return
	 */
	protected boolean isSupportedLotteryType(LotteryType lotteryType) {
		return lotteryIndexUrlMap.containsKey(lotteryType)&lotteryResultPrefixMap.containsKey(lotteryType);
	}
	
	public LotteryDrawFetchWorkerGDFC(LotteryType lotteryType){
		super(lotteryType);
	}
	
	@Override
	public LotteryDraw fetchResult(String phase) {
		return null;
	}

	@Override
	public LotteryDraw fetchResultDetail(String phase) {
		
		LotteryType lotteryType = this.getLotteryType();
		
		if (!isSupportedLotteryType(lotteryType)) {
			logger.error("不支持的彩种抓取, lotteryType={}", lotteryType.getName());
			return null;
		}
		
		String url = this.getResultDetailUrl(phase);	//获取详情地址
		
		if (url == null) {
			logger.error("无法解析到详情地址");
			return null;
		}
		
		String encoding = CharsetConstant.CHARSET_GBK;
		
		String pageInfo = "详细页面" + url;
		String logHeader = pageInfo + "==抓取==" + getLotteryType().getName() + "==";

		logger.info(logHeader + "开始==");
		
		Map<String, String> headerParams = new HashMap<String, String>();
		headerParams.put("Referer", "http://www.gdfc.org.cn");
		headerParams.put("user-agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.8) Gecko/20100722 Firefox/3.6.8");
		String data = null;
		try {
			data = CoreFetcherUtils.URLGetWithHeaderParams(url, headerParams, null, encoding);
		} catch (Exception e) {
			logger.error("get方式请求异常",e);
		}
		
		if (data == null || data.indexOf("404 Not Found") > 0 || data.isEmpty()) {
			logger.error(logHeader + "data is null or 404 Not Found");
			return null;
		}
		
		Parser parser = null;
		String fetchPhase = "";
		String timeDraw = "";
		try {
			parser= Parser.createParser(data, encoding);
			AndFilter phaseAndTimeDrawFilter = new AndFilter(new TagNameFilter("div"), 
					new HasAttributeFilter("class","play_R_tbox"));//过滤'class'为'play_R_tbox'的div标签
			NodeList phaseAndTimeDrawNodeList = parser.extractAllNodesThatMatch(phaseAndTimeDrawFilter);
			if (phaseAndTimeDrawNodeList == null || phaseAndTimeDrawNodeList.size() == 0) {
				logger.error("没有class为play_R的div标签");
			} else {
				Node phaseAndTimeDrawNode = phaseAndTimeDrawNodeList.elementAt(0);//取得下标为0的第一个节点
				if (phaseAndTimeDrawNode == null) {
					logger.info("彩种和开奖日期对应的节点不存在");
				} else {
					String phaseAndTimeStr = CoreStringUtils.substringBetween(phaseAndTimeDrawNode.toHtml(), 
							">", "<").trim();//以'>'开始，以'<'结束提取<div></div>之间的文本
					if (phaseAndTimeStr == null || "".equals(phaseAndTimeStr)) {
						logger.info("没有彩期和开奖日期");
					} else {
						timeDraw = phaseAndTimeStr.split("第")[0].trim();
						logger.info("开奖日期=============="+timeDraw);
						fetchPhase = CoreFetcherUtils.formatLotteryTerm(phaseAndTimeStr.split("第")[1]).trim();
						logger.info("彩期=============="+fetchPhase);
					}
				}
			}
		} catch (Exception e) {
			logger.error("解析彩种和开奖日期异常",e);
			return null;
		}
		String volumeOfSales = "";		//销售量
		String jackpot = "";			//奖池
		try {
			parser= Parser.createParser(data, encoding);
			AndFilter volumeOfSalesFilter = new AndFilter(new TagNameFilter("span"), 
					new HasAttributeFilter("class","red14BD"));	//过滤'class'为'red14BD'的span标签
			NodeList volumeOfSalesNodeList = parser.extractAllNodesThatMatch(volumeOfSalesFilter);
			if (volumeOfSalesNodeList == null || volumeOfSalesNodeList.size() == 0) {
				logger.error("不存在'class'为'red14BD'的span标签");
			} else {
				Span volumeOfSalesSpan = (Span)volumeOfSalesNodeList.elementAt(0);//取得下标为0的第一个节点
				String volumeOfSalesStr = volumeOfSalesSpan.getStringText();
				if (volumeOfSalesStr == null || "".equals(volumeOfSalesStr)) {
					logger.info("节点内容为空，没有投注额");
				} else {
					volumeOfSales = CoreFetcherUtils.formatMoneyString(volumeOfSalesStr);//格式化金钱字符串
					logger.info("销售量==="+volumeOfSales);
				}
				Span jackPotSpan = (Span)volumeOfSalesNodeList.elementAt(1);//取得下标为1的第二个节点
				String jackPotStr = jackPotSpan.getStringText();
				if (jackPotStr == null || "".equals(jackPotStr)) {
					logger.info("节点内容为空，没有奖池资金累计金额");
				} else {
					jackpot = CoreFetcherUtils.formatMoneyString(jackPotStr);
					logger.info("奖池："+jackpot);
				}
			}
		} catch (Exception e) {
			logger.error("解析销售量异常",e);
		}

		String result = "";
		List<LotteryDrawPrizeItem> itemList = new ArrayList<LotteryDrawPrizeItem>();//奖项列表
		try {
			parser = Parser.createParser(data, encoding);
			TagNameFilter tableFilter = new TagNameFilter("table");//过滤table标签
			NodeList tableNodeList = parser.extractAllNodesThatMatch(tableFilter);
			if (tableNodeList == null || tableNodeList.size() == 0) {
				logger.error("没有table标签");
			} else {
				TableTag resultTag = (TableTag)tableNodeList.elementAt(0);//取得中奖号码的table
				TableRow resultRow = resultTag.getRows()[1];//取得第二行
				Node resultNode = resultRow.getChildren().elementAt(1);//取得第二行的第二个子元素
				String resultStr = resultNode.toHtml();
				if (resultStr == null || "".equals(resultStr)) {
					logger.error("节点内容为空，没有中奖号码");
				} else {
					String tempResult = "";
					if (this.getLotteryType() == LotteryType.A_NYFCHC1) {
						tempResult = CoreStringUtils.substringBetween(resultStr, 
								"getTwoColorBallLuckyNo(\"", " ");//取得resultStr中指定开始和指定结束之间的文本
					} else if (this.getLotteryType() == LotteryType.A_NYFC36 
							|| this.getLotteryType() == LotteryType.A_NYFC26) {
						tempResult = CoreStringUtils.substringBetween(resultStr, 
								"getTwoColorBallLuckyNo(\"", "\"");//取得resultStr中指定开始和指定结束之间的文本
					}
					if ("".equals(tempResult)) {	
						logger.error("没有取得中奖号码字符串");
					} else {
						char[] resultArr = tempResult.toCharArray();//把字符串转换成char型数组，每2位以','号连接
						for (int i = 0;i < resultArr.length;i++) {
							if (i != 0 && i % 2 == 0) {
								result +=",";
							}
							result += resultArr[i];
						}
						logger.info("开奖号码===="+result);
					}
				}
				LotteryDrawPrizeItem item = null;//奖项
				int count = 0;
				for (int j = 1;j < tableNodeList.size();j++) {
					count ++;
					TableTag resultDetail1Tag = (TableTag)tableNodeList.elementAt(j);//取得中奖结果的table
					if (resultDetail1Tag.getRowCount() == 0) {
						logger.error("中奖结果的table没有行");
					} else {
						int index = 0;
						if (j == 1) {
							index = 2;//如果是第一个table，从第三行开始是中奖结果
						} else if (j == 2) {
							index = 1;//如果是第二个table，从第二行开始时中奖结果
						}
						
						for (int k = index;k < resultDetail1Tag.getRowCount();k++) {
							TableRow resultDetail2Row = resultDetail1Tag.getRows()[k];//取得中奖结果的行
							if (resultDetail2Row == null) {
								logger.error("中奖结果table的第三行不存在");
							} else {
								item = new LotteryDrawPrizeItem();
								TableColumn nameColumn = resultDetail2Row.getColumns()[0];//取得奖级名称的列
								if (nameColumn == null) {
									logger.error("奖级名称的第一列不存在");
								} else {
									String name = nameColumn.getStringText();//奖级名称
									if (name == null || "".equals(name)) {
										logger.error("奖级名称为空");
									} else {
										logger.info("奖级名称=="+name);
										item.setName(name);
									}
								}
								TableColumn winningCountColumn = resultDetail2Row.getColumns()[1];//取得中奖注数的列
								if (winningCountColumn == null) {
									logger.error("中奖注数的第二列不存在");
								} else {
									String winningCount = winningCountColumn.getStringText();//中奖注数
									if (winningCount == null || "".equals(winningCount)) {
										logger.error("中奖注数为空");
									} else {
										logger.info("中奖注数=="+winningCount);
										item.setWinningCount(winningCount);
									}
								}
								TableColumn prizeAmountColumn = resultDetail2Row.getColumns()[2];//取得奖金金额的列
								if (prizeAmountColumn == null) {
									logger.error("奖金金额的第三列不存在");
								} else {
									String prizeAmount = prizeAmountColumn.getStringText();
									if (prizeAmount == null || "".equals(prizeAmount)) {
										logger.error("奖金金额为空");
									} else {
										prizeAmount = CoreFetcherUtils.formatMoneyString(prizeAmount);
										logger.info("奖金金额=="+prizeAmount);
										item.setPrizeAmount(prizeAmount);
									}
								}
								itemList.add(item);
							}
						}
					}
					if (count == 2) {//前两个table的数据为中奖情况
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.error("解析开奖结果、开奖详情异常",e);
		}
		
		if (phase != null && !"".equals(phase)) { //如果有指定彩期
			if (!fetchPhase.equals(phase)) {
				logger.error("抓取的彩期和指定的彩期不一致");
				return null;
			}
		} else { //如果没有指定彩期
			phase = fetchPhase;
		}
		LotteryDraw lotteryDraw = new LotteryDraw();
		lotteryDraw.setPhase(phase);
		lotteryDraw.setTimeDraw(timeDraw);
		lotteryDraw.setVolumeOfSales(volumeOfSales);
		lotteryDraw.setJackpot(jackpot);
		lotteryDraw.setResult(result);
		lotteryDraw.setResultDetail(itemList);
		lotteryDraw.setLotteryType(getLotteryType());
		
		return lotteryDraw;
	}

	/**
	 * 获取详情地址
	 * 如果没有指定彩期，则获取第一行详情地址
	 * 如果指定的是期号，获取对应期号的详情地址
	 * 如果指定的是期，则直接拼接详情地址
	 */
	@Override
	protected String getResultDetailUrl(String phase) {
		String url = "";
		
		if (phase == null || "".equals(phase)) {//如果没有指定彩期，则获取第一行详情地址
			logger.info("未指定彩期，从首页获取最新开奖详情地址");
			String encoding = CharsetConstant.CHARSET_GBK;
			String data = null;
			try {
				data = CoreFetcherUtils.URLGet(lotteryIndexUrlMap.get(this.getLotteryType()), null, encoding);
			} catch (Exception e) {
				logger.error("get方式请求异常", e);
			}
			if (data == null || data.indexOf("404 Not Found") > 0) {
				logger.error("抓取列表页面内容异常");
				return null;
			}
			
			Parser parser = null;
			try {
				parser = Parser.createParser(data, encoding);
			} catch (Exception e) {
				logger.error("解析html异常, data={}", data);
				return null;
			}
			
			try {
				TagNameFilter tableTagFilter = new TagNameFilter("table");
				NodeList tableNodeList = parser.extractAllNodesThatMatch(tableTagFilter);
				if (tableNodeList != null && tableNodeList.size() > 0) {
					Node tableNode = tableNodeList.elementAt(0);				//取得下标为0的第一个table标签
					if (tableNode != null) {
						NodeList trNodeList = tableNode.getChildren();
						if (trNodeList != null && trNodeList.size() > 1) {
							TableRow tableRow = (TableRow)trNodeList.elementAt(3);//取得下标为3的第四个tr标签
							if (tableRow != null) {
								if (tableRow.getColumnCount() > 2) {
									TableColumn tableColumn = null;
									if (this.getLotteryType() == LotteryType.A_NYFC36) {
										tableColumn = tableRow.getColumns()[3];//取得下标为3的第四个td标签
									} else if (this.getLotteryType() == LotteryType.A_NYFC26 
											|| this.getLotteryType() == LotteryType.A_NYFCHC1) {
										tableColumn = tableRow.getColumns()[2];//取得下标为2的第三个td标签
									}
									NodeList aNodeList = tableColumn.getChildren();
									if (aNodeList != null && aNodeList.size() > 0) {
										LinkTag linkTag = null;
										for (int i = 0;i < aNodeList.size();i++) {
											if (aNodeList.elementAt(i) instanceof LinkTag) {
												linkTag = (LinkTag)aNodeList.elementAt(i);//取得下标为0的第一个a标签
											}
										}
										if (linkTag != null) {
											url = linkTag.getAttribute("href");//取得a标签的href属性
										} else {
											logger.error("table标签的第二个tr标签的第三列没有link子标签");
											return null;
										}
									} else {
										logger.error("table标签的第二个tr标签的第三列没有子标签");
										return null;
									}
								} else {
									logger.error("table标签的第二个tr标签没有列");
									return null;
								}
							} else {
								logger.error("table标签的第二个tr标签为空");
								return null;
							}
						} else {
							logger.error("table标签没有子标签");
							return null;
						}
					}
				} else {
					logger.error("解析列表页面没有table标签");
					return null;
				}
			} catch (Exception e) {
				logger.error("解析最新期详细情况地址异常",e);
				return null;
			}
		} else {//指定期号，查找对应期号的详情地址
			boolean exists = false;
			String encoding = CharsetConstant.CHARSET_GBK;
			String data = null;
			try {
				data = CoreFetcherUtils.URLGet(lotteryIndexUrlMap.get(this.getLotteryType()), null, encoding);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			if (data == null || data.indexOf("404 Not Found") > 0) {
				logger.error("抓取列表页面内容异常");
				return null;
			}
			
			Parser parser = null;
			try {
				parser = Parser.createParser(data, encoding);
			} catch (Exception e) {
				logger.error("解析html异常, data={}", data);
				return null;
			}
			
			try {
				int totalPage = 0; 
				HasAttributeFilter hasAttributeFilter = new HasAttributeFilter("id","label-totalpage");
				NodeList nodeList = parser.extractAllNodesThatMatch(hasAttributeFilter);
				if (nodeList == null || nodeList.size() == 0) {
					logger.error("没有id为label-totalpage的标签");
				} else {
					String totalPageStr = CoreStringUtils.substringBetween(nodeList.elementAt(0).toHtml(), ">", "<");
					if (totalPageStr == null || "".equals(totalPageStr)) {
						logger.error("总页数为空");
						return null;
					} else {
						try {
							totalPage = Integer.parseInt(totalPageStr);
						} catch (Exception e) {
							logger.error("总页数转换成int类型异常",e);
							return null;
						}
						for (int i = 1;i <= totalPage;i++) {	//循环读取每一页，查找指定彩期所在行
							String pageUrl = "http://www.gdfc.org.cn/datas/history/"+lotteryResultPrefixMap.get(this.getLotteryType())+"/history_"+i+".html";
							String tempEncoding = CharsetConstant.CHARSET_GBK;
							String tempData = null;
							try {
								tempData = CoreFetcherUtils.URLGet(pageUrl, null, tempEncoding);
							} catch (Exception e) {
								logger.error(e.getMessage(), e);
							}
							if (data == null || data.indexOf("404 Not Found") > 0) {
								logger.error("抓取列表页面内容异常");
								return null;
							}
							
							Parser tempParser = null;
							try {
								tempParser = Parser.createParser(tempData, tempEncoding);
							} catch (Exception e) {
								logger.error("解析html异常, data={}", data);
								return null;
							}
							try {
								TagNameFilter tableTagFilter = new TagNameFilter("table");
								NodeList tableNodeList = tempParser.extractAllNodesThatMatch(tableTagFilter);
								if (tableNodeList != null && tableNodeList.size() > 0) {
									TableTag tableTag = (TableTag)tableNodeList.elementAt(0);				//取得下标为0的第一个table标签
									if (tableTag != null) {
										if (tableTag.getRowCount() > 0) {
											for(int j = 0 ;j < tableTag.getRowCount();j++) {
												TableRow tableRow = tableTag.getRows()[j];
												if (tableRow != null) {
													if (tableRow.getColumnCount() > 2) {
														TableColumn firstColumn = tableRow.getColumns()[0];//取得下标为0的第一个td标签
														String currentPhase = CoreStringUtils.trimAll(CoreStringUtils.substringBetween(firstColumn.toHtml(), ">", "<"));
														if (currentPhase.equals(phase)) {//如果找到对应的彩期
															TableColumn thirdColumn = null;
															if (this.getLotteryType() == LotteryType.A_NYFC26 
																	|| this.getLotteryType() == LotteryType.A_NYFCHC1) {
																thirdColumn = tableRow.getColumns()[2];//取得下标为2的第三个td标签
															} else if (this.getLotteryType() == LotteryType.A_NYFC36) {
																thirdColumn = tableRow.getColumns()[3];//取得下标为2的第三个td标签
															}
															NodeList aNodeList = thirdColumn.getChildren();
															LinkTag linkTag = null;
															if (aNodeList != null && aNodeList.size() > 0) {
																for (int k = 0;k < aNodeList.size();k++) {
																	if (aNodeList.elementAt(k) instanceof LinkTag) {
																		linkTag = (LinkTag)aNodeList.elementAt(k);
																	}
																}
																if (linkTag != null) {
																	url = linkTag.getAttribute("href");//取得a标签的href属性
																} else {
																	logger.error("table标签的第二个tr标签的第三列的子标签不是link标签");
																	return null;
																}
															} else {
																logger.error("table标签的第二个tr标签的第三列没有子标签");
																return null;
															}
															exists = true;
															break;
														}
													} else {
														logger.error("table标签的第二个tr标签没有列");
														return null;
													}
												} else {
													logger.error("table标签的第二个tr标签为空");
													return null;
												}
											}
										} else {
											logger.error("table标签没有行");
											return null;
										}
									}
								} else {
									logger.error("解析列表页面没有table标签");
									return null;
								}
							} catch (Exception e) {
								logger.error("解析最新期详细情况地址异常",e);
								return null;
							}
							if (exists) {
								break;
							}
						}
					}
				}
			} catch (Exception e) {
				logger.error("解析总页数异常",e);
				return null;
			}
			if (!exists) {//指定期，拼接详情地址
				url = "/datas/drawinfo/"+lotteryResultPrefixMap.get(this.getLotteryType())+"/draw_"+phase+".html";
			}
		}
		return BASE_URL+url;
	}

	@Override
	protected String getResultUrl(String phase) {
		return null;
	}
	
}
