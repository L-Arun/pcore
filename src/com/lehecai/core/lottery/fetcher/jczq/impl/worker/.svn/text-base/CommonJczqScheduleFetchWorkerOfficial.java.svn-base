package com.lehecai.core.lottery.fetcher.jczq.impl.worker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.CssSelectorNodeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.FetchFailedException;
import com.lehecai.core.lottery.JczqDynamicSaleStatus;
import com.lehecai.core.lottery.JczqRaceStatus;
import com.lehecai.core.lottery.JczqStaticSaleStatus;
import com.lehecai.core.lottery.LotteryConstant;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jczq.AbstractJczqScheduleFetchWorker;
import com.lehecai.core.lottery.fetcher.jczq.JczqScheduleItem;
import com.lehecai.core.util.CoreDateUtils;
import com.lehecai.core.util.CoreFetcherUtils;
import com.lehecai.core.util.lottery.JczqUtil;

/**
 * 通用竞彩足球赛程抓取实现类
 * @author qatang
 *
 */
public class CommonJczqScheduleFetchWorkerOfficial extends AbstractJczqScheduleFetchWorker{
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	protected static final String SCHEDULE_URL = "http://info.sporttery.cn/football/match_list.php";
	
	private static final Map<String, Integer> weekDay = new HashMap<String, Integer>();
	
	static {
		weekDay.put("周日", 1);
		weekDay.put("周一", 2);
		weekDay.put("周二", 3);
		weekDay.put("周三", 4);
		weekDay.put("周四", 5);
		weekDay.put("周五", 6);
		weekDay.put("周六", 7);
	}
 	
	@Override
	public List<JczqScheduleItem> fetchJczqSchedule(String officialDate) throws FetchFailedException {
		Map<String, String> headerParams = new HashMap<String, String>();
		headerParams.put("Referer", "http://info.sporttery.cn");
		headerParams.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_3) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.168 Safari/535.19");
		List<JczqScheduleItem> jczqScheduleItemList = new ArrayList<JczqScheduleItem>();

		String encoding = "gbk";
		JczqScheduleItem jczqScheduleItem = null;
		String siteName = "中国竞彩网网[竞彩足球赛程]";
		String logHeader = siteName+SCHEDULE_URL;
		
		try {
			String webInfo = CoreFetcherUtils.URLGetWithHeaderParams(SCHEDULE_URL,headerParams,null,encoding);
			if (webInfo == null || webInfo.indexOf("404 Not Found") > 0) {
				logger.error(logHeader+",data is null or 404 Not Found");
				throw new FetchFailedException("404 Not Found");
			}
			
			Parser parser = Parser.createParser(webInfo, encoding);
			
			NodeList nodeList = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("div[class='tableCounter']"));
			if (null != nodeList && nodeList.size() > 0) {
				NodeFilter tableFilter = new TagNameFilter("table");
				Parser parser2 = Parser.createParser(nodeList.toHtml(), encoding);
				NodeList tableNodeList = parser2.extractAllNodesThatMatch(tableFilter);
				if (tableNodeList != null && tableNodeList.size() > 0) {
					TableTag catchTableTag = new TableTag();
					catchTableTag = (TableTag) tableNodeList.elementAt(1);
					if (catchTableTag != null) {
						TableRow[] catchRows = catchTableTag.getRows();
						TableColumn[] catchColumns = null;
						for (int i = 3; i < catchRows.length; i++) {
							catchColumns = catchRows[i].getColumns();
							if (catchColumns != null
									&& catchColumns.length >= 6) {
								jczqScheduleItem = new JczqScheduleItem();
								
								String officialNum = catchColumns[0].toPlainTextString().trim();
								if (officialNum.length() < 5) {
									continue;
								}
								
								// 先解析比赛时间
								String matchDateStr = catchColumns[3].toPlainTextString().trim();
								String[] yearStr = matchDateStr.split("-");
								if (yearStr[0].length() <= 2) {
									matchDateStr = "20" + matchDateStr + ":00";
								} else {
									matchDateStr = matchDateStr + ":00";
								}
								Date matchDate = CoreDateUtils.parseDate(matchDateStr, CoreDateUtils.DATETIME);
								Calendar matchDateCalendar = Calendar.getInstance();
								matchDateCalendar.setTime(matchDate);
								matchDateCalendar.add(Calendar.MINUTE, 1);
								jczqScheduleItem.setMatchDate(matchDateCalendar.getTime());
								
								// 根据周几、当前时间和比赛时间计算官方发布的日期
								Calendar cd = Calendar.getInstance();
								// 将时分秒等区域清零
								cd.set(Calendar.HOUR_OF_DAY, 0);
								cd.set(Calendar.MINUTE, 0);
								cd.set(Calendar.SECOND, 0);
								cd.set(Calendar.MILLISECOND, 0);
								
								int nowWeekDay = cd.get(Calendar.DAY_OF_WEEK);
								int fetchWeekDay = weekDay.get(officialNum.substring(0, 2));
								
								if (nowWeekDay != fetchWeekDay) {
									int m = fetchWeekDay - nowWeekDay;
									if (m < -1) {
										cd.add(Calendar.DATE, m + 7);
									} else {
										cd.add(Calendar.DATE, m);
									}
								}
								
								// 如果计算出来的日期超过了比赛时间，减去一周
								if (cd.after(matchDateCalendar)) {
									cd.add(Calendar.DATE, -7);
								}
								
								// 如果计算出来的日期距离比赛时间相隔超过一周，加上一周的倍数
								// 一周的毫秒数
								long weekTimeInMillis = 3600 * 1000 * 24 * 7;
								long diffTimeInMillis = matchDateCalendar.getTimeInMillis() - cd.getTimeInMillis();
								if (diffTimeInMillis > weekTimeInMillis) {
									// 计算相差几周
									int diffWeekCount = (int)(diffTimeInMillis / weekTimeInMillis);
									cd.add(Calendar.DATE, 7 * diffWeekCount);
								}
								
								
								jczqScheduleItem.setMatchNum(CoreDateUtils.formatDate(cd.getTime(), "yyyyMMdd") + LotteryConstant.JCZQ_MATCH_NUM_CODE_DEFAULT + officialNum.substring(2));
								jczqScheduleItem.setOfficialDate(CoreDateUtils.parseDate(CoreDateUtils.formatDate(cd.getTime())));
								String oNum = null;
								try {
									oNum = officialNum.substring(2);
								} catch (Exception e) {
									logger.error("截取官方编码时，截取错误", e);
								}
								jczqScheduleItem.setOfficialNum(oNum);
								jczqScheduleItem.setMatchName(JczqUtil.convertMatchName(catchColumns[1].toPlainTextString().trim(), LotteryType.JCZQ_SPF, FetcherType.T_PENGINEAPI));
								
								String team = catchColumns[2].toPlainTextString().trim();
								String[] teamStr = team.split("VS");
								jczqScheduleItem.setAwayTeam(teamStr[1].trim());
								jczqScheduleItem.setHomeTeam(teamStr[0].trim());
								
								jczqScheduleItem.setStatus(JczqRaceStatus.UNOPEN);
								
								if (catchColumns[5].toPlainTextString().trim().indexOf("胜平负单关") > 0) {
									jczqScheduleItem.setDynamicSaleSpfStatus(JczqDynamicSaleStatus.SALE_UNOPEN);
								} else {
									jczqScheduleItem.setDynamicSaleSpfStatus(JczqDynamicSaleStatus.SALE_OPEN);
								}
								if (catchColumns[5].toPlainTextString().trim().indexOf("胜平负过关") > 0) {
									jczqScheduleItem.setStaticSaleSpfStatus(JczqStaticSaleStatus.SALE_UNOPEN);
								} else {
									jczqScheduleItem.setStaticSaleSpfStatus(JczqStaticSaleStatus.SALE_OPEN);
								}
								if (catchColumns[5].toPlainTextString().trim().indexOf("全场比分单关") > 0) {
									jczqScheduleItem.setDynamicSaleBfStatus(JczqDynamicSaleStatus.SALE_UNOPEN);
								} else {
									jczqScheduleItem.setDynamicSaleBfStatus(JczqDynamicSaleStatus.SALE_OPEN);
								}
								if (catchColumns[5].toPlainTextString().trim().indexOf("全场比分过关") > 0) {
									jczqScheduleItem.setStaticSaleBfStatus(JczqStaticSaleStatus.SALE_UNOPEN);
								} else {
									jczqScheduleItem.setStaticSaleBfStatus(JczqStaticSaleStatus.SALE_OPEN);
								}
								if (catchColumns[5].toPlainTextString().trim().indexOf("进球总数单关") > 0) {
									jczqScheduleItem.setDynamicSaleJqsStatus(JczqDynamicSaleStatus.SALE_UNOPEN);
								} else {
									jczqScheduleItem.setDynamicSaleJqsStatus(JczqDynamicSaleStatus.SALE_OPEN);
								}
								if (catchColumns[5].toPlainTextString().trim().indexOf("进球总数过关") > 0) {
									jczqScheduleItem.setStaticSaleJqsStatus(JczqStaticSaleStatus.SALE_UNOPEN);
								} else {
									jczqScheduleItem.setStaticSaleJqsStatus(JczqStaticSaleStatus.SALE_OPEN);
								}
								if (catchColumns[5].toPlainTextString().trim().indexOf("半全场胜平负单关") > 0) {
									jczqScheduleItem.setDynamicSaleBqcStatus(JczqDynamicSaleStatus.SALE_UNOPEN);
								} else {
									jczqScheduleItem.setDynamicSaleBqcStatus(JczqDynamicSaleStatus.SALE_OPEN);
								}
								if (catchColumns[5].toPlainTextString().trim().indexOf("半全场胜平负过关") > 0) {
									jczqScheduleItem.setStaticSaleBqcStatus(JczqStaticSaleStatus.SALE_UNOPEN);
								} else {
									jczqScheduleItem.setStaticSaleBqcStatus(JczqStaticSaleStatus.SALE_OPEN);
								}
								jczqScheduleItemList.add(jczqScheduleItem);
							}
						}//end for catchRows
					}//end if catchTableTag!=null
				}//end if(tableNodeList!=null&&tableNodeList.size()>0)
			}else{
				logger.error(logHeader+"竞彩足球赛程数据表格不存在，返回null");
				throw new FetchFailedException("竞彩足球赛程数据表格不存在");
			}
		} catch (Exception e) {
			logger.error(logHeader+"竞彩足球赛程错误"+e.getMessage(),e);
			throw new FetchFailedException(e.getMessage());
		}
		return jczqScheduleItemList;
	}
}
