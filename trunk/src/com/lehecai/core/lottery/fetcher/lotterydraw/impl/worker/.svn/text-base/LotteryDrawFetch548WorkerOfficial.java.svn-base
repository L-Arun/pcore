package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.util.HashMap;
import java.util.Map;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreFetcherUtils;
import com.lehecai.core.util.CoreStringUtils;

/**
 * 四川扑克彩十分乐数据抓取工具
 * @author yanweijie
 *
 */
public class LotteryDrawFetch548WorkerOfficial extends AbstractLotteryDrawFetchWorker {

	protected static final String RESULT_URL = "http://www.sclottery.gov.cn/files/Sctc/search.jsp";
	
	public LotteryDrawFetch548WorkerOfficial (LotteryType lotterytype) {
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
		
		String encoding = CharsetConstant.CHARSET_UTF8;
		
		String pageInfo = "详细页面" + url;
		String logHeader = pageInfo + "==抓取==" + getLotteryType().getName() + "==";

		logger.info(logHeader + "开始==");
		
		String data = "";
		
		Map<String, String> headerParams = new HashMap<String, String>();
		headerParams.put("Referer", "http://www.sclottery.gov.cn");
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
		
		String fetchPhase = "";	
		StringBuffer resultBuffer = new StringBuffer();
		String result = "";
		TagNameFilter tableFilter = new TagNameFilter("table");
		try {
			parser = Parser.createParser(data, encoding);
			NodeList nodeList = parser.extractAllNodesThatMatch(tableFilter);
			if (nodeList == null || nodeList.size() == 0) {
				logger.error("详情页面没有table节点");
			} else {
				TableTag tableTag = (TableTag)nodeList.elementAt(6);//取得期号和中奖号码的table
				if (tableTag != null) {
					if (tableTag.getRowCount() < 7) {
						logger.error("期号和中奖号码的table没有7行");
					} else {
						Node phaseNode = nodeList.elementAt(3);//期号节点
						if (phaseNode != null) {
							 fetchPhase = CoreStringUtils.substringBetween(phaseNode.toHtml(), "第", "期");//取得中奖号码html文本中'第'和'期'之间的内容
						}
						Node resultNode = nodeList.elementAt(6);//中奖号码节点
						if (resultNode != null) {
							String resultStr = CoreStringUtils.substringBetween(resultNode.toHtml(), "class=\"number\">", "<");//取得中奖号码html文本中'class=\"number\">'和'<'之间的内容
							String[] resultArr = resultStr.split(" ");//以空格拆分中奖号码字符串
							for (int i = 0;i < resultArr.length;i++) {
								if (resultArr[i] != null && !"".equals(resultArr[i]))
									resultBuffer.append(resultArr[i]).append(",");//以','链接中奖号码
							}
							if (resultBuffer.lastIndexOf(",") != -1) {
								result = resultBuffer.deleteCharAt(resultBuffer.lastIndexOf(",")).toString();
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error("解析详情页面异常",e);
		}
		
		LotteryDraw lotteryDraw = null;
		if (phase != null && !"".equals(phase)) {//如果有指定彩期
			if (!fetchPhase.equals(phase)) {//如果抓取到的彩期和指定的彩期不一致
				logger.error("抓取到的彩期和指定彩期不一致");
				return null;
			}
		} else {//如果没有指定彩期
			phase = fetchPhase;
		}
		
		lotteryDraw = new LotteryDraw();
		lotteryDraw.setPhase(phase);
		lotteryDraw.setResult(result);
		lotteryDraw.setLotteryType(getLotteryType());
		return lotteryDraw;
	}

	/**
	 * 获取详情地址
	 * 如果没有指定彩期，首先抓取最新彩期，然后拼接详情地址
	 * 如果有指定彩期，直接拼接详情地址
	 */
	@Override
	protected String getResultDetailUrl(String phase) {
		if (phase == null || "".equals(phase)) { //没有指定彩期
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
			TagNameFilter filter = new TagNameFilter("table");
			try {
				NodeList nodeList = parser.extractAllNodesThatMatch(filter);
				if (nodeList == null || nodeList.size() == 0) {
					logger.error("解析的列表页面没有table标签");
				} else {
					Node node = nodeList.elementAt(8);
					if (node == null) {
						logger.error("没有最新期开奖结果的table");
					} else {
						TableTag tagbleTag = (TableTag)node;
						if (tagbleTag.getRowCount() > 3) {
							TableRow tableRow = tagbleTag.getRows()[2];//取得四川扑克彩十分乐所在行
							if (tableRow != null) {
								if (tableRow.getColumnCount() > 2) {
									TableColumn tableColumn = tableRow.getColumns()[1];//取得彩期列
									if (tableColumn != null) {
										phase = tableColumn.getStringText().trim();
									}
								} else {
									logger.error("最新期开奖结果的table第3行少于2列");
								}
							}
						} else {
							logger.error("最新期开奖结果的table少于3行");
						}
					}
				}
			} catch (ParserException e) {
				logger.error("解析table标签异常",e);
			}
		}
		
		return "http://www.sclottery.gov.cn/files/Sctc/search_detail.jsp?game_id=2&draw_value="+phase;
	}
	
	@Override
	protected String getResultUrl(String phase) {
		return null;
	}

}
