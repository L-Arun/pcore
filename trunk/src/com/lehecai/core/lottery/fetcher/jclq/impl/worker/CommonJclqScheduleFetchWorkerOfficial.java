package com.lehecai.core.lottery.fetcher.jclq.impl.worker;

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
import com.lehecai.core.lottery.JclqDynamicSaleStatus;
import com.lehecai.core.lottery.JclqRaceStatus;
import com.lehecai.core.lottery.JclqStaticSaleStatus;
import com.lehecai.core.lottery.LotteryConstant;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jclq.AbstractJclqScheduleFetchWorker;
import com.lehecai.core.lottery.fetcher.jclq.JclqScheduleItem;
import com.lehecai.core.util.CoreDateUtils;
import com.lehecai.core.util.CoreFetcherUtils;
import com.lehecai.core.util.lottery.JclqUtil;

/**
 * 通用竞彩篮球赛程抓取实现类
 * @author qatang
 *
 */
public class CommonJclqScheduleFetchWorkerOfficial extends AbstractJclqScheduleFetchWorker{
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	protected static final String SCHEDULE_URL = "http://info.sporttery.cn/basketball/match_list.php";
	
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
	public List<JclqScheduleItem> fetchJclqSchedule(String officialDate) throws FetchFailedException {
		Map<String, String> headerParams = new HashMap<String, String>();
		headerParams.put("Referer", "http://info.sporttery.cn");
		headerParams.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_3) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.168 Safari/535.19");
		List<JclqScheduleItem> jclqScheduleItemList = new ArrayList<JclqScheduleItem>();

		String encoding = "gbk";
		JclqScheduleItem jclqScheduleItem = null;
		String siteName = "中国竞彩网网[竞彩篮球赛程]";
		String logHeader = siteName+SCHEDULE_URL;
		
		try {
			String webInfo = CoreFetcherUtils.URLGetWithHeaderParams(SCHEDULE_URL,headerParams,null,encoding);
			if (webInfo == null || webInfo.indexOf("404 Not Found") > 0) {
				logger.error(logHeader+",data is null or 404 Not Found");
				throw new FetchFailedException("404 Not Found");
			}
			
			Parser parser = Parser.createParser(webInfo, encoding);
			
			NodeList nodeList = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("div[class='box-tbl']"));
			if(null != nodeList && nodeList.size() > 0){
				NodeFilter tableFilter = new TagNameFilter("table");
				Parser parser2 = Parser.createParser(nodeList.toHtml(), encoding);
				NodeList tableNodeList = parser2.extractAllNodesThatMatch(tableFilter);
				if(tableNodeList!=null&&tableNodeList.size()>0){
					TableTag catchTableTag=new TableTag();
					catchTableTag = (TableTag)tableNodeList.elementAt(0);
					if(catchTableTag!=null){
						TableRow[] catchRows = catchTableTag.getRows();
						TableColumn[] catchColumns = null;
						for(int i=2;i<catchRows.length;i ++){
							catchColumns = catchRows[i].getColumns();
							if(catchColumns!=null&&catchColumns.length>=6){
								jclqScheduleItem = new JclqScheduleItem();
								
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
								jclqScheduleItem.setMatchDate(matchDateCalendar.getTime());
								
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
								
								jclqScheduleItem.setMatchNum(CoreDateUtils.formatDate(cd.getTime(), "yyyyMMdd") + LotteryConstant.JCLQ_MATCH_NUM_CODE_DEFAULT + officialNum.substring(2));
								jclqScheduleItem.setOfficialDate(CoreDateUtils.parseDate(CoreDateUtils.formatDate(cd.getTime())));
								Integer oNum = null;
								try {
									oNum = Integer.valueOf(officialNum.substring(2));
								} catch (Exception e) {
									logger.error("截取官方编码时，转换为Integer错误", e);
								}
								jclqScheduleItem.setOfficialNum(oNum);
								jclqScheduleItem.setMatchName(JclqUtil.convertMatchName(catchColumns[1].toPlainTextString().trim(), LotteryType.JCLQ_SF, FetcherType.T_PENGINEAPI));
								
								String team = catchColumns[2].toPlainTextString().trim();
								String[] teamStr = team.split("VS");
								jclqScheduleItem.setAwayTeam(teamStr[0].trim());
								jclqScheduleItem.setHomeTeam(teamStr[1].trim());
								
								if ("已开售".equals(catchColumns[4].toPlainTextString().trim())) {
									jclqScheduleItem.setStatus(JclqRaceStatus.OPEN);
								} else {
									jclqScheduleItem.setStatus(JclqRaceStatus.UNOPEN);
								}
								if (catchColumns[5].toPlainTextString().trim().indexOf("胜负单关") > 0) {
									jclqScheduleItem.setDynamicSaleSfStatus(JclqDynamicSaleStatus.SALE_UNOPEN);
								} else {
									jclqScheduleItem.setDynamicSaleSfStatus(JclqDynamicSaleStatus.SALE_OPEN);
								}
								if (catchColumns[5].toPlainTextString().trim().indexOf("胜负过关") > 0) {
									jclqScheduleItem.setStaticSaleSfStatus(JclqStaticSaleStatus.SALE_UNOPEN);
								} else {
									jclqScheduleItem.setStaticSaleSfStatus(JclqStaticSaleStatus.SALE_OPEN);
								}
								if (catchColumns[5].toPlainTextString().trim().indexOf("让分胜负单关") > 0) {
									jclqScheduleItem.setDynamicSaleRfsfStatus(JclqDynamicSaleStatus.SALE_UNOPEN);
								} else {
									jclqScheduleItem.setDynamicSaleRfsfStatus(JclqDynamicSaleStatus.SALE_OPEN);
								}
								if (catchColumns[5].toPlainTextString().trim().indexOf("让分胜负过关") > 0) {
									jclqScheduleItem.setStaticSaleRfsfStatus(JclqStaticSaleStatus.SALE_UNOPEN);
								} else {
									jclqScheduleItem.setStaticSaleRfsfStatus(JclqStaticSaleStatus.SALE_OPEN);
								}
								if (catchColumns[5].toPlainTextString().trim().indexOf("胜分差单关") > 0) {
									jclqScheduleItem.setDynamicSaleSfcStatus(JclqDynamicSaleStatus.SALE_UNOPEN);
								} else {
									jclqScheduleItem.setDynamicSaleSfcStatus(JclqDynamicSaleStatus.SALE_OPEN);
								}
								if (catchColumns[5].toPlainTextString().trim().indexOf("胜分差过关") > 0) {
									jclqScheduleItem.setStaticSaleSfcStatus(JclqStaticSaleStatus.SALE_UNOPEN);
								} else {
									jclqScheduleItem.setStaticSaleSfcStatus(JclqStaticSaleStatus.SALE_OPEN);
								}
								if (catchColumns[5].toPlainTextString().trim().indexOf("大小分单关") > 0) {
									jclqScheduleItem.setDynamicSaleDxfStatus(JclqDynamicSaleStatus.SALE_UNOPEN);
								} else {
									jclqScheduleItem.setDynamicSaleDxfStatus(JclqDynamicSaleStatus.SALE_OPEN);
								}
								if (catchColumns[5].toPlainTextString().trim().indexOf("大小分过关") > 0) {
									jclqScheduleItem.setStaticSaleDxfStatus(JclqStaticSaleStatus.SALE_UNOPEN);
								} else {
									jclqScheduleItem.setStaticSaleDxfStatus(JclqStaticSaleStatus.SALE_OPEN);
								}
								jclqScheduleItemList.add(jclqScheduleItem);
							}
						}//end for catchRows
					}//end if catchTableTag!=null
				}//end if(tableNodeList!=null&&tableNodeList.size()>0)
			}else{
				logger.error(logHeader+"竞彩篮球赛程数据表格不存在，返回null");
				throw new FetchFailedException("竞彩篮球赛程数据表格不存在");
			}
		} catch (Exception e) {
			logger.error(logHeader+"竞彩篮球赛程错误"+e.getMessage(),e);
			throw new FetchFailedException(e.getMessage());
		}
		return jclqScheduleItemList;
	}
}
