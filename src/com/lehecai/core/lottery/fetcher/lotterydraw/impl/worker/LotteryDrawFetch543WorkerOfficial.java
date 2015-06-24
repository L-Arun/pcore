package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.Div;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.tags.Span;
import org.htmlparser.util.NodeList;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreFetcherUtils;
import com.lehecai.core.util.CoreStringUtils;

/**
 * 北京快乐8数据抓取工具
 * @author yanweijie
 *
 */
public class LotteryDrawFetch543WorkerOfficial extends AbstractLotteryDrawFetchWorker {
	
	public LotteryDrawFetch543WorkerOfficial (LotteryType lotterytype) {
		super(lotterytype);
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
		} else {
			logger.info("解析到的详情地址：{}",url);
		}
		
		String encoding = CharsetConstant.CHARSET_GB2312;
		
		String pageInfo = "详细页面" + url;
		String logHeader = pageInfo + "==抓取==" + getLotteryType().getName() + "==";

		logger.info(logHeader + "开始==");
		
		String data = "";
		
		Map<String, String> headerParams = new HashMap<String, String>();
		headerParams.put("Referer", "http://www.bjfcdt.gov.cn");
		headerParams.put("user-agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.8) Gecko/20100722 Firefox/3.6.8");
		
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
		
		String fetchPhase = "";						//期号
		String result = "";							//开奖号码+飞盘倍数
		String jackpot = "";						//奖池
		
		TagNameFilter divFilter = new TagNameFilter("div");
		AndFilter andFilter = new AndFilter(divFilter, new HasAttributeFilter("class", "awardInfo"));
		try {
			parser = Parser.createParser(data, encoding);
			NodeList nodeList = parser.extractAllNodesThatMatch(andFilter);
			if (nodeList != null && nodeList.size() != 0) {
				String frisBee = "";
				Div div = (Div)nodeList.elementAt(0);//取得期号、飞盘、开奖号码、奖池的div
				if (div != null && div.getChildCount() > 0) {
					Node phaseNode = div.getChild(1);
					if (phaseNode != null && phaseNode.getChildren().size() > 0) {
						for (int i = 0; i < phaseNode.getChildren().size();i ++) {
							if (phaseNode.getChildren().elementAt(i) instanceof Span) {
								Span phaseSpan = (Span)phaseNode.getChildren().elementAt(i);
								fetchPhase = phaseSpan.getStringText();
								logger.info("抓取到的彩期：{}", fetchPhase);
							}
						}
					} else {
						logger.error("下标为1的第二个期号节点为空");
					}
					
					Node frisBeeNode = div.getChild(3);
					if (frisBeeNode != null && frisBeeNode.getChildren().size() > 0) {
						for (int i = 0; i < frisBeeNode.getChildren().size();i ++) {
							if (frisBeeNode.getChildren().elementAt(i) instanceof ImageTag) {
								ImageTag frisBeeImageTag = (ImageTag)frisBeeNode.getChildren().elementAt(i);
								frisBee = frisBeeImageTag.getAttribute("alt");
								logger.info("抓取到的飞盘号码：{}", frisBee);
							}
						}
					} else {
						logger.error("下标为3的第四个飞盘节点为空");
					}
					Node resultNode = div.getChild(7);
					if (resultNode != null && resultNode.getChildren().size() > 0) {
						for (int i = 0; i < resultNode.getChildren().size();i ++) {
							String resultHtml = resultNode.getChildren().elementAt(i).toHtml();
							if (CoreStringUtils.substringBetween(resultHtml, "<li>", "</li>") != null 
									&& !CoreStringUtils.substringBetween(resultHtml, "<li>", "</li>").equals("")) {
								result += trimAll(CoreStringUtils.substringBetween(resultHtml, "<li>", "</li>")) + ",";
							}
						}
						
						if (result != null && !result.equals("")) {
							logger.info("抓取到的开奖号码：{}", result);
							result += frisBee;
						}
					} else {
						logger.error("下标为7的第八个开奖结果节点为空");
					}
					Node jackpotNode = div.getChild(9);
					if (jackpotNode != null) {
						if (CoreStringUtils.substringBetween(jackpotNode.toHtml(), "<em>", "</em>") != null 
								&& !CoreStringUtils.substringBetween(jackpotNode.toHtml(), "<em>", "</em>").equals("")) {
							jackpot = trimAll(CoreStringUtils.substringBetween(jackpotNode.toHtml(), "<em>", "</em>").replace("元", ""));
							logger.info("抓取到的奖池：{}", jackpot);
						}
					} else {
						logger.error("下标为9的第十个奖池节点为空");
					}
				}
			} else {
				logger.error("详情页面没有class为awardInfo的div标签");
			}
		} catch (Exception e) {
			logger.error("解析详情页面异常",e);
		}
		

		if (phase != null && !"".equals(phase)) {//如果有指定彩期
			if (!fetchPhase.equals(phase)) {//如果抓取到的彩期和指定的彩期不一致
				logger.error("抓取到的彩期和指定彩期不一致");
				return null;
			}
		} else {//如果没有指定彩期
			phase = fetchPhase;
		}
		
		LotteryDraw lotteryDraw = new LotteryDraw();
		lotteryDraw.setPhase(phase);					//期号
		lotteryDraw.setResult(result);					//开奖结果
		lotteryDraw.setLotteryType(getLotteryType());	//彩种
		lotteryDraw.setJackpot(jackpot);				//奖池
		return lotteryDraw;
	}

	/**
	 * 获取详情地址
	 * 如果没有指定彩期，首先抓取最新彩期，然后拼接详情地址
	 * 如果有指定彩期，直接拼接详情地址
	 */
	@Override
	protected String getResultDetailUrl(String phase) {
		
		if (phase == null || phase.equals("")) { //没有指定彩期
			Calendar cal = Calendar.getInstance();
			String date = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE);
			String url = "http://www.bjfcdt.gov.cn/LtrAPI/Happy8/v1/getAwardNumber.aspx?date=" + date;
			
			Map<String, String> headerParams = new HashMap<String, String>();
			headerParams.put("Referer", "http://www.bjfcdt.gov.cn");
			headerParams.put("user-agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.8) Gecko/20100722 Firefox/3.6.8");
			String encoding = CharsetConstant.CHARSET_GB2312;
			
			String data = "";
			try {
				data = CoreFetcherUtils.URLGetWithHeaderParams(url, headerParams, null, encoding);
			} catch (Exception e) {
				logger.error("get方式请求异常",e);
			}
			
			String pageInfo = "当天列表页面" + url;
			String logHeader = pageInfo + "==抓取==" + getLotteryType().getName() + "的最新期==";

			logger.info(logHeader + "开始==");
			
			if (data == null || data.indexOf("404 Not Found") > 0 || data.isEmpty()) {
				logger.error(logHeader + "data is null or 404 Not Found");
				return null;
			}
			
			Parser parser = null;
			try {
				TagNameFilter spanFilter = new TagNameFilter("span");
				parser = Parser.createParser(data, encoding);
				NodeList nodeList = parser.extractAllNodesThatMatch(spanFilter);
				if (nodeList != null && nodeList.size() != 0) {
					Span spanTag = (Span)nodeList.elementAt(0);
					phase = trimAll(spanTag.getStringText());		//最新期号
				} else {
					logger.error("没有span子节点");
				}
			} catch (Exception e) {
				logger.error("解析最新期期号异常");
				return null;
			}
		}
		
		return "http://www.bjfcdt.gov.cn/Happy8/V1/ImageAward.aspx?periodnum=" + phase;
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
