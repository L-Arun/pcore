package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
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
import com.lehecai.core.util.CoreNumberUtil;
import com.lehecai.core.util.CoreStringUtils;

/**
 * 北京体彩33选7抓取器
 * @author yanweijie
 *
 */
public class LotteryDrawFetch552WorkerOfficial extends AbstractLotteryDrawFetchWorker{

	protected static final String BASE_URL = "http://www.bjlot.com";							//北京体彩33选7的基地址
	protected static final String RESULT_URL = "http://www.bjlot.com/select7of33/index.shtml";	//北京体彩33选7最新开奖地址
	
	public LotteryDrawFetch552WorkerOfficial(){
		super(LotteryType.BJTC33X7);
	}
	
	@Override
	public LotteryDraw fetchResult(String phase) {
		return null;
	}
	
	/**
	 * 解析北京体彩33选7指定彩期或者最新期开奖信息
	 */
	@Override
	public LotteryDraw fetchResultDetail(String phase) {
		String url = this.getResultDetailUrl(phase);	//获取详情地址
		
		if (url == null) {
			logger.error("无法解析到详情地址");
			return null;
		} else {
			logger.info("解析到的详情地址：{}",url);
		}
		
		String encoding = CharsetConstant.CHARSET_UTF8;
		
		String pageInfo = "详细页面" + url;
		String logHeader = pageInfo + "==抓取==" + getLotteryType().getName() + "==";

		logger.info(logHeader + "开始==");
		
		String data = "";
		
		Map<String, String> headerParams = new HashMap<String, String>();
		headerParams.put("Referer", "http://www.bjlot.com");
		headerParams.put("user-agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.8) Gecko/20100722 Firefox/3.6.8");
		
		try {
			data = CoreFetcherUtils.URLGetWithHeaderParams(url, headerParams, null, encoding);
		} catch (Exception e) {
			logger.error("get方式请求异常", e);
		}
		
		if (data == null || data.indexOf("404 Not Found") > 0 || data.isEmpty()) {
			logger.error(logHeader + "data is null or 404 Not Found");
			return null;
		} else {
			logger.info(data);//jsonString={}
		}
		if (data.indexOf("jsonString=") > -1) {
			data = data.substring(data.indexOf("{"));//去除jsonString=部分
		} else {
			logger.error("读取到的json数据不正确");
			return null;
		}
		if (data == null || "".equals(data)) {
			logger.error("转换的数据为空");
			return null;
		}
		JSONObject jsonObject = null;
		try {
			jsonObject = JSONObject.fromObject(data);
		} catch (Exception e) {
			logger.error(data+"转换成JSONObject异常",e);
			return null;
		}
		
		if (jsonObject == null) {
			logger.info("转换后的JSONObject为空");
			return null;
		}
		
		Object volumeOfSalesObj = jsonObject.get("amt");						//销售量
		Object phaseObj = jsonObject.get("drawno");								//期号
		Object timeDrawObj = jsonObject.get("drawtime");						//开奖时间
		Object jackpotObj = jsonObject.get("pool");								//奖池
		Object resultObj = jsonObject.get("result");							//开奖结果
		Object resultDetailObject = jsonObject.get("info");						//开奖详情
		
		String volumeOfSales = "";				//销售量
		if (volumeOfSalesObj == null) {
			logger.warn("销售量为空");
		} else {
			double volumeOfSalesDou = 0.00D;
			String tempVolumeOfSales = trimAll(volumeOfSalesObj.toString());//替换字符串的各种特殊符号
			if ("".equals(tempVolumeOfSales)) {
				logger.warn("替换各种特殊符号后销售量为空");
			} else {
				try {
					volumeOfSalesDou = Double.parseDouble(tempVolumeOfSales);//转换成double类型
					tempVolumeOfSales = CoreNumberUtil.formatNumBy0Digits(volumeOfSalesDou);//格式化销售量，不保留小数
					if (tempVolumeOfSales == null) {
						logger.error("格式化销售量异常");
					} else {
						volumeOfSales = tempVolumeOfSales;
					}
				} catch (Exception e) {
					logger.error("销售量转换成double类型异常",e);
				}
			}
		}
		logger.info("销售量=="+volumeOfSales);
		String fetchPhase = "";
		if (phaseObj == null) {
			logger.warn("期号为空");
		} else {
			fetchPhase = phaseObj.toString();
			fetchPhase = trimAll(fetchPhase);//替换期号字符串的各种特殊符号
			if ("".equals(fetchPhase)) {
				logger.warn("期号为空");
			}
		}
		logger.info("期号=="+fetchPhase);
		String timeDraw = "";
		if (timeDrawObj == null) {
			logger.warn("开奖时间为空");
		} else {
			Date tempTimeDrawDate = null;
			try {
				String timeDrawStr = timeDrawObj.toString();
				if (timeDrawStr.substring(0, timeDrawStr.indexOf("-")).length() == 2) {
					timeDrawStr = "20" + timeDrawStr;
				}
				tempTimeDrawDate = CoreDateUtils.parseDate(timeDrawStr);
				if (tempTimeDrawDate != null) {
					try {
						timeDraw = CoreDateUtils.formatDate(tempTimeDrawDate);//格式化
					} catch (Exception e) {
						logger.error("格式化开奖时间异常");
					}
				}
			} catch (Exception e) {
				logger.error("开奖时间转换成Date类型异常");
			}
		}
		logger.info("开奖时间=="+timeDraw);
		String jackpot = "";
		if (jackpotObj == null) {
			logger.warn("奖池为空");
		} else {
			String tempJackpot = trimAll(jackpotObj.toString());//替换字符串的各种特殊符号
			if ("".equals(tempJackpot)) {
				logger.warn("替换特殊符号后的奖池为空");
			} else {
				double jackpotDou = 0.00D;
				try {
					jackpotDou = Double.parseDouble(tempJackpot);
					tempJackpot = CoreNumberUtil.formatNumBy0Digits(jackpotDou);
					if (tempJackpot == null) {
						logger.error("格式化奖池异常");
					} else {
						jackpot = tempJackpot;
					}
				} catch (Exception e) {
					logger.error("奖池转换成double类型异常");
				}
			}
		}
		logger.info("奖池=="+jackpot);
		String result = "";
		StringBuffer resultSb = new StringBuffer("");
		if (resultObj == null) {
			logger.warn("开奖结果为空");
		} else {
			String tempResult = resultObj.toString();
			String[] results = tempResult.split(" ");//以空格拆分开奖号码
			for (String str : results) {
				resultSb.append(str).append(",");//以','连接开奖号码
			}
			if(resultSb.lastIndexOf(",") != -1){						
				resultSb.deleteCharAt(resultSb.lastIndexOf(","));//去除最后一个','
			}
			result = resultSb.toString();
		}
		logger.info("开奖结果=="+result);
		JSONArray resultDetailJSONArray = null;
		List<LotteryDrawPrizeItem> resultDetail = null;
		if (resultDetailObject == null) {
			logger.warn("开奖详情为空");
		} else {
			if (resultDetailObject instanceof JSONArray) {
				resultDetailJSONArray = (JSONArray)jsonObject.get("info");
			}
			if (resultDetailJSONArray == null || resultDetailJSONArray.size() == 0) {
				logger.warn("开奖详情为空");
			} else {
				resultDetail = new ArrayList<LotteryDrawPrizeItem>();
				for (int k = 0;k < resultDetailJSONArray.size();k++) {
					LotteryDrawPrizeItem item  = new LotteryDrawPrizeItem();
					JSONObject resultDetailJSONObject = (JSONObject)resultDetailJSONArray.get(k);
					String winningCount = "";
					Object winningCountObj = resultDetailJSONObject.get("num");//中奖注数
					if (winningCountObj == null) {
						logger.warn("中奖注数为空");
					} else {
						winningCount = trimAll(winningCountObj.toString()); //去除特殊符号
						if ("".equals(winningCount)) {
							logger.warn("去除特殊符号的中奖注数为空");
						}
					}
					logger.info("中奖注数=="+winningCount);
					String name = "";
					Object nameObj = resultDetailJSONObject.get("prizelevel");//奖级名称
					if (nameObj == null) {
						logger.warn("奖级名称为空");
					} else {
						name = trimAll(nameObj.toString());			//去除特殊符号
						if ("".equals(name)) {
							logger.warn("去除特殊符号的奖级名称为空");
						}
					}
					logger.info("奖级名称=="+name);
					String prizeAmount = "";
					Object prizeAmountObj = resultDetailJSONObject.get("stake");//奖金金额
					if (prizeAmountObj == null) {
						logger.warn("奖金金额为空");
					} else {
						String tempPrizeAmount = trimAll(prizeAmountObj.toString());//去除特殊符号
						if(tempPrizeAmount != null){
							tempPrizeAmount = tempPrizeAmount.replaceAll("-", "");
						}
						if ("".equals(tempPrizeAmount)) {
							logger.warn("去除特殊符号的奖金金额为空");
						} else {
							try {
								double prizeAmountDou = Double.parseDouble(tempPrizeAmount);
								tempPrizeAmount = CoreNumberUtil.formatNumBy0Digits(prizeAmountDou);
								if (tempPrizeAmount == null) {
									logger.error("格式化奖金金额异常");
								} else {
									prizeAmount = tempPrizeAmount;
								}
							} catch (Exception e) {
								prizeAmount = "0";
								logger.error("奖金金额转换成double类型异常",e);
							}
						}
					}
					logger.info("奖金金额=="+prizeAmount);
					if (name != null && !"".equals(name)) {
						item.setName(name);
					}
					if (winningCount != null && !"".equals(winningCount)) {
						item.setWinningCount(winningCount);
					}
					if (prizeAmount != null && !"".equals(prizeAmount)) {
						item.setPrizeAmount(prizeAmount);
					}
					
					resultDetail.add(item);
				}//end for
			}
		}
		
		if (phase != null && !"".equals(phase)) { //有指定彩期
			if (!fetchPhase.equals(phase)) { //抓取的彩期和指定的彩期不一致
				logger.error("抓取到的彩期和指定的彩期不一致");
				return null;
			}
		} else { //没有指定彩期
			phase = fetchPhase;
		}
		LotteryDraw lotteryDraw = new LotteryDraw();
		lotteryDraw.setLotteryType(this.getLotteryType());
		if (phase != null && !"".equals(phase)) {
			lotteryDraw.setPhase(phase);//设置期号
		}
		if (timeDraw != null && !"".equals(timeDraw)) {
			lotteryDraw.setTimeDraw(timeDraw);//设置开奖时间
		}
		if (volumeOfSales != null && !"".equals(volumeOfSales)) {
			lotteryDraw.setVolumeOfSales(volumeOfSales);//设置销售量
		}
		if (jackpot != null && !"".equals(jackpot)) {
			lotteryDraw.setJackpot(jackpot);//设置奖池
		}
		if (result != null && !"".equals(result)) {
			lotteryDraw.setResult(result);//设置开奖结果
		}
		if (resultDetail != null && resultDetail.size() > 0) {
			lotteryDraw.setResultDetail(resultDetail);//设置详情
		}
		return lotteryDraw;
	}

	/**
	 * 取得详情页面地址
	 */
	@Override
	protected String getResultDetailUrl(String phase) {
		if (phase == null || "".equals(phase.trim())) {//如果没有指定彩期，则取得彩期下拉框中第一项的value
			logger.info("未指定彩期，从首页获取最新开奖详情地址");
			// 获取最新期
			String encoding = CharsetConstant.CHARSET_UTF8;
			String data = null;
			
			try {
				data = CoreFetcherUtils.URLGet(RESULT_URL, null, encoding);
			} catch (Exception e) {
				logger.error("get方式请求异常", e);
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
				TagNameFilter divTagFileter = new TagNameFilter("div");									//过滤select标签
				AndFilter divAndFilter = new AndFilter(divTagFileter, new HasAttributeFilter("class", "sideblue"));	//过滤class为"sideblue"的div标签
				NodeList sideblueDivNodeList = parser.extractAllNodesThatMatch(divAndFilter);
				
				if (sideblueDivNodeList.size() > 1) {
					Node sideblueDivNode = sideblueDivNodeList.elementAt(1);//取得下标为1的第2个div标签
					if (sideblueDivNode != null) {
						NodeList nodeList = sideblueDivNode.getChildren();
						if (nodeList.size() > 0) {
							for (int i = 0 ;i < nodeList.size();i++) {
								if (nodeList.elementAt(i) instanceof TableTag) {
									TableTag tableTag = (TableTag)nodeList.elementAt(i);//取得下标为0的第一个table标签
									logger.info(tableTag.toHtml());
									if (tableTag.getRowCount() > 1) {
										TableRow tableRow = tableTag.getRow(1);//取得下标为1的第二行
										logger.info(tableRow.toHtml());
										if (tableRow != null) {
											if (tableRow.getColumnCount() > 1) {
												TableColumn column = tableRow.getColumns()[1];//取得下标为1的第二列
												String columnHtml = column.toHtml();//取得第二列html
												phase = trimAll(CoreStringUtils.substringBetween(columnHtml, 
														">", "<"));//获取'>'和'<'之间的内容，并替换特殊符号
											} else {
												logger.error("class为'sideblue'的div节点的table子节点每行少于2列");
												return null;
											}
										}
									} else {
										logger.error("class为'sideblue'的div节点的table子节点少于2行");
										return null;
									}
								}
							}
						} else {
							logger.error("class为'sideblue'的第二个div标签没有子标签");
							return null;
						}
					} else {
						logger.error("不存在class为'sideblue'的第二个div标签");
						return null;
					}
				} else {
					logger.error("class为'sideblue'的div节点少于2个");
					return null;
				}
			} catch (Exception e) {
				logger.error("解析最新期异常", e);
				return null;
			}
		}

		if (phase != null && !"".equals(phase)) {
			return BASE_URL + "/data/24/draw/20"+phase.substring(0,2)+"/"+phase+".js";
		}
		
		return null;
	}

	@Override
	protected String getResultUrl(String phase) {
		return null;
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
