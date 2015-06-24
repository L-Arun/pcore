package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasChildFilter;
import org.htmlparser.filters.NotFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.nodes.TagNode;
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
 * 江苏体彩7位数抓取实现类
 * @author yanweijie
 *
 */
public class LotteryDrawFetch533WorkerOfficial extends AbstractLotteryDrawFetchWorker{

	protected static final String BASE_URL = "http://www.js-lottery.com";
	protected static final String RESULT_URL = "http://www.js-lottery.com/7ws/index.html";
	
	protected String siteName = "江苏体彩7位数";
	protected String lotteryScope = "地方开奖";
	
	
	public LotteryDrawFetch533WorkerOfficial(){
		super(LotteryType.A_JS7);
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
		
		String encoding = CharsetConstant.CHARSET_GBK;
		
		String pageInfo = "详细页面" + url;
		String logHeader = pageInfo + "==抓取==" + getLotteryType().getName() + "==";

		logger.info(logHeader + "开始==");
		
		LotteryDraw lotteryDraw = null;
		String data = "";
		Parser parser=null;
		Node resultNode = null;
		TableTag resultDetailTag = null;
		TableTag jackpotTag = null;
		NodeFilter tableFilter = null;
		NodeList nodeList = null;
		
		Map<String, String> headerParams = new HashMap<String, String>();
		headerParams.put("Referer", "http://www.js-lottery.com");
		headerParams.put("user-agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.8) Gecko/20100722 Firefox/3.6.8");
		
		data = CoreFetcherUtils.URLGetWithHeaderParams(url, headerParams, null, encoding);
		
		if (data == null || data.indexOf("404 Not Found") > 0 || data.isEmpty()) {
			logger.error(logHeader + "data is null or 404 Not Found");
			return null;
		}
		
		NodeFilter[] arrFilter = new NodeFilter[2];
		arrFilter[0] = new TagNameFilter("table");
		arrFilter[1] = new NotFilter(new HasChildFilter(new TagNameFilter("form")));
		tableFilter = new AndFilter(arrFilter);

		try {
			parser= Parser.createParser(data,  encoding);
			nodeList = parser.extractAllNodesThatMatch(tableFilter);

			if (nodeList == null || nodeList.size() == 0 ) {
				logger.info("没有匹配的节点");
				return null;
			}
			
			if (nodeList.size() < 3) {
				logger.info("匹配的节点有误");
				return null;
			}
			
			resultNode = nodeList.elementAt(0);
			jackpotTag = (TableTag)nodeList.elementAt(1);
			resultDetailTag = (TableTag)nodeList.elementAt(2);
			if (resultNode != null) {
				lotteryDraw = parseResult(phase, resultNode, lotteryDraw);//解析期号、开奖结果、销售量、开奖时间
				
				if (lotteryDraw == null) {
					logger.info(logHeader+"解析期号、开奖结果、销售量、开奖时间错误");
					return null;
				}
			} else {
				logger.info(logHeader+"没有期号、开奖结果、销售量、开奖时间节点");
			}
			if (jackpotTag != null) {
				lotteryDraw = parseJackpot(jackpotTag, lotteryDraw);//解析奖池
				if (lotteryDraw == null) {
					logger.info(logHeader+"解析奖池错误");
					return null;
				}
			} else {
				logger.info(logHeader+"没有奖池节点");
			}
			
			if (resultDetailTag != null) {
				lotteryDraw = parseResultDetail(resultDetailTag, lotteryDraw);//解析奖项
				if (lotteryDraw == null) {
					logger.info(logHeader+"解析开奖详情错误");
					return null;
				}
			} else {
				logger.info(logHeader+"没有开奖详情节点");
			}
			
		} catch (ParserException e) {
			logger.info(logHeader+"解析不含有form子标签的table异常");
		}
		
		return lotteryDraw;
	}

	/**
	 * 取得详情页面地址
	 */
	@Override
	protected String getResultDetailUrl(String phase) {
		String url = null;
		if (phase != null && phase.trim().length() > 0) {//如果有指定彩期，通过彩期拼接详情地址
			url = "/7ws/7wslssj/" + (Integer.parseInt(phase) - 9147) +".html";
		} else {//如果没有指定彩期，则取得历史数据下拉框中第一项的value
			logger.info("未指定彩期，从首页获取最新开奖详情地址");
			// 获取最新期
			String encoding = CharsetConstant.CHARSET_GBK;
			String data = null;
			
			try {
				data = CoreFetcherUtils.URLGet(RESULT_URL, null, encoding);
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
			
			try {
				TagNameFilter selectTagFileter = new TagNameFilter("select");
				NodeList selectNodeList = parser.extractAllNodesThatMatch(selectTagFileter);
				
				if (selectNodeList.size() > 0) {
					parser.setInputHTML(selectNodeList.elementAt(0).toHtml());
					TagNameFilter optionTagFileter = new TagNameFilter("option");
					NodeList optionNodeList = parser.extractAllNodesThatMatch(optionTagFileter);
					if (optionNodeList.size() > 1) {
						TagNode tagNode = new TagNode();
						tagNode.setText(optionNodeList.elementAt(1).toHtml());
						url = tagNode.getAttribute("value");
					}
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		if (url != null) {
			return BASE_URL + url;
		}
		return null;
	}

	@Override
	protected String getResultUrl(String phase) {
		return null;
	}
	
	/**
	 * 解析期号、开奖结果、销售量、开奖时间
	 * @param phase
	 * @param resultNode
	 * @param lotteryDraw
	 * @return
	 */
	protected LotteryDraw parseResult(String phase,
					Node resultNode,LotteryDraw lotteryDraw) {
		
		if (resultNode == null ) {
			logger.warn("没有期号、开奖结果、销售量、开奖时间父节点");
			return null;
		} 
		
		String timeDraw = "";
		String volumeOfSales = "";
		String result = "";
		String lotteryPhase = "";
		NodeList resultChildrenNodeList = null;
		
		resultChildrenNodeList = resultNode.getChildren();
		
		if (resultChildrenNodeList == null || resultChildrenNodeList.size() == 0) {
			logger.warn("没有期号、开奖结果、销售量、开奖时间节点");
			return null;
		} else if (resultChildrenNodeList.size() < 4) {
			logger.warn("没有期号、开奖时间或者开奖结果或者销售量节点");
			return null;
		}
		
		TableRow firstRow = (TableRow)resultChildrenNodeList.elementAt(1);
		TableColumn firstColumn = null;
		if (firstRow != null && firstRow.getColumnCount() != 0) {
			firstColumn = firstRow.getColumns()[0];
		} else {
			logger.info("期号、开奖时间对应的行不存在");
		}
		
		TableRow secondRow = (TableRow)resultChildrenNodeList.elementAt(2);
		TableColumn secondColumn = null;
		if (secondRow != null && secondRow.getColumnCount() != 0) {
			secondColumn = secondRow.getColumns()[0];
		} else {
			logger.info("销售量对应的行不存在");
		}
		
		TableRow thirdRow = (TableRow)resultChildrenNodeList.elementAt(3);
		TableColumn thirdColumn = null;
		if (thirdRow != null && thirdRow.getColumnCount() != 0) {
			thirdColumn = thirdRow.getColumns()[0];
		} else {
			logger.info("开奖结果对应的行不存在");
		}
		String firstText = "";
		if (firstColumn != null) {
			firstText = firstColumn.getStringText();
		} else {
			logger.info("期号、开奖时间对应的列不存在");
		}
		String volumeOfSalesText = "";
		if (secondColumn != null) {
			volumeOfSalesText = secondColumn.getStringText();
		} else {
			logger.info("销售量对应的列不存在");
		}
		String resultText = "";
		if (thirdColumn != null) {
			resultText = thirdColumn.getStringText();
		} else {
			logger.info("开奖结果对应的列不存在");
		}
		
		if (firstText != null && !"".equals(firstText)) {
			lotteryPhase = CoreStringUtils.substringBetween(firstText, "第","期");					//期号
			String timeDrawStr = parseJiangSu7TimeDraw(firstText);
			if (timeDrawStr != null && !"".equals(timeDrawStr)) {
				timeDraw = CoreFetcherUtils.formatTimeDraw(timeDrawStr);					//开奖时间
			} else {
				logger.info("开奖时间为空");
			}
		} else {
			logger.info("期号、开奖时间文本为空");
		}
		if (volumeOfSalesText != null && !"".equals(volumeOfSalesText)) {
			volumeOfSales = parseJiangSu7VolumeOfSales(volumeOfSalesText);					//销售量
			if (volumeOfSales == null || "".equals(volumeOfSales)) {
				logger.info("销售量为空");
			}
		} else {
			logger.info("销售量文本为空");
		}
		if (resultText != null && !"".equals(resultText)) {
			result = parseJiangSu7Result(resultText);										//开奖结果
			if (result == null || "".equals(result)) {
				logger.info("开奖结果为空");
			}
		} else {
			logger.info("开奖结果文本为空");
		}
		
		
		if (phase == null || phase.equals("")) {
			phase = lotteryPhase;
		}
		lotteryDraw = new LotteryDraw();
		
		if (lotteryPhase.equals(phase)) {
			lotteryDraw.setPhase(phase);
			lotteryDraw.setTimeDraw(timeDraw);
			lotteryDraw.setVolumeOfSales(volumeOfSales);
			lotteryDraw.setResult(result);
			lotteryDraw.setLotteryType(this.getLotteryType());
		} else {
			logger.warn("抓取的结果{}与给定的彩期{}不匹配",lotteryPhase,phase);
			return null;
		}
		return lotteryDraw;
	}
	
	/**
	 * 解析奖池
	 * @param phase
	 * @param resultNode
	 * @param lotteryDraw
	 * @return
	 */
	protected LotteryDraw parseJackpot(Node resultNode,LotteryDraw lotteryDraw) {
		
		if (resultNode == null) {
			logger.info("奖池对应的父节点不存在");
			return null;
		}
		
		String jackpot = "";
		NodeList resultChildrenNodeList = null;
		
		resultChildrenNodeList = resultNode.getChildren();
		
		if (resultChildrenNodeList == null || resultChildrenNodeList.size() == 0) {
			logger.info("奖池对应的子节点不存在");
			return null;
		}
		Node jackpotNode = resultChildrenNodeList.elementAt(2);
		if (jackpotNode == null) {
			logger.info("奖池对应的节点不存在");
			return null;
		}
		jackpot = jackpotNode.toPlainTextString();
		if (jackpot == null || "".equals(jackpot)) {
			logger.info("奖池文本为空");
			return null;
		}
		jackpot = CoreStringUtils.substringBetween(jackpot, "金额为", "元");
		if (jackpot == null || "".equals(jackpot)) {
			logger.info("奖池数据为空");
			return null;
		}
		jackpot = this.parsePrize(jackpot);
		
		if (lotteryDraw != null && jackpot != null) {
			lotteryDraw.setJackpot(jackpot);
		}
		
		return lotteryDraw;
	}
	
	/**
	 * 解析开奖详情
	 * @param phase
	 * @param resultNode
	 * @param lotteryDraw
	 * @return
	 */
	protected LotteryDraw parseResultDetail(TableTag resultDetailTag,LotteryDraw lotteryDraw) {
		if (resultDetailTag == null) {
			logger.info("奖项对应的table不存在");
			return null;
		}
		
		List<LotteryDrawPrizeItem> resultDetail = new ArrayList<LotteryDrawPrizeItem>();
		TableRow row = null;
		TableColumn[] columns = null;
		LotteryDrawPrizeItem item = null;
		String name;
		String winningCount;
		String prizeAmount;
		TableRow[] rows = resultDetailTag.getRows();
		
		if (rows.length == 0) {
			logger.info("奖项对应的行不存在");
			return null;
		}
		
		for(int i = 0 ;i<rows.length;i++) {
			if (i != 0) {
				row = rows[i];
				columns = row.getColumns();
				
				if (columns.length > 4) {
					
					item = new LotteryDrawPrizeItem();
					
					name = columns[0].getStringText().trim();
					if (name == null || "".equals(name)) {
						logger.info("奖项名称为空");
					}
					winningCount = columns[1].getStringText();
					if (winningCount == null || "".equals(winningCount)) {
						logger.info("中奖注数为空");
					} else {
						winningCount = winningCount.replaceAll("注", "");
						winningCount = trimAll(winningCount);
					}
					prizeAmount = columns[3].getStringText();
					if (prizeAmount == null || "".equals(prizeAmount)) {
						logger.info("奖金为空");
					} else {
						prizeAmount = this.parsePrize(prizeAmount);
					}
					
					item.setName(name);
					item.setWinningCount(winningCount);
					item.setPrizeAmount(prizeAmount);
					
					resultDetail.add(item);
				}
			}
		}
		
		if (resultDetail != null && resultDetail.size() > 0) {
			if (null != lotteryDraw) {
				lotteryDraw.setResultDetail(resultDetail);
			}
		}
		
		return lotteryDraw;
	}
	
	/**
	 * 解析开奖公布日期
	 * @param timeDraw
	 * @return
	 */
	protected String parseJiangSu7TimeDraw(String timeDraw) {
		
		if (timeDraw != null && !"".equals(timeDraw)) {
			
			int yearIndex = timeDraw.indexOf("年");
			int dateIndex = timeDraw.indexOf("日");
			
			if (yearIndex > -1 && dateIndex > -1) {
				timeDraw = timeDraw.substring(yearIndex-4, dateIndex+1);
			} else {
				return null;
			}
		} else {
			return null;
		}
		
		return timeDraw;
	}
	
	/**
	 * 解析销售总额
	 * @param volumeOfSales
	 * @return
	 */
	protected String parseJiangSu7VolumeOfSales(String volumeOfSales) {
		
		if (volumeOfSales != null && !"".equals(volumeOfSales)) {
			volumeOfSales = trimAll(volumeOfSales);			
			volumeOfSales = volumeOfSales.replaceAll("本期销售总额为", "");
			if (volumeOfSales != null && !"".equals(volumeOfSales)) {
				volumeOfSales = this.parsePrize(volumeOfSales);
			} else {
				return null;
			}
		} else {
			return null;
		}
		
		return volumeOfSales;
	}
	
	/**
	 * 解析中奖号码
	 * @param result
	 * @return
	 */
	protected String parseJiangSu7Result(String resultText) {
		
		String result = "";
		
		if (resultText != null && !resultText.equals("")) {
			
			resultText = resultText.replaceAll("开出中奖号码如下：", "");
			
			if (resultText == null || "".equals(resultText)) {
				return null;
			}
			
			String[] nums = resultText.split("&nbsp;");
			
			if (nums.length == 0) {
				return null;
			}
			
			for(int i = 0;i<nums.length;i++) {
				result +=nums[i]+",";
			}
			
			if (result.endsWith(",")) {
				result = result.substring(0, result.length()-1);
			} else {
				return null;
			}
			
		} else {
			return null;
		}
		
		return result;
	}
	
	/**
	 * 处理金额
	 * @param prize
	 * @return
	 */
	private String parsePrize(String prize) {
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
