package com.lehecai.core.lottery.fetcher.jczq.impl.worker;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.LotteryConstant;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jczq.AbstractJczqSpFetchWorker;
import com.lehecai.core.lottery.fetcher.jczq.JczqSpItem;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreDateUtils;
import com.lehecai.core.util.CoreHttpUtils;
import com.lehecai.core.util.CoreStringUtils;

/**
 * 通用竞彩篮球sp抓取实现类
 * @author qatang
 *
 */
public class CommonJczqSpFetchWorker500Wan extends AbstractJczqSpFetchWorker{
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private static final String URL_500WAN_JCLQ = "http://zx.500wan.com/jczq/kaijiang.php";
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
	
	public List<JczqSpItem> fetchJczqSp(String officialDate){
		if (officialDate == null || "".equals(officialDate)) {
			logger.error("竞彩足球抓取开奖sp时，officialDate为空");
			return null;
		}
		String dateStr = officialDate;
		
		List<JczqSpItem> list = new ArrayList<JczqSpItem>();
		
		//由于我站抓取时间设定为官方比赛编号时间“周n”，而500wan页面抓取时间是比赛时间，
		//这里将抓取传进的官方比赛编号后几天得数据来获得比赛编号为传入的时间的比赛
		//如果抓取到的比赛编号中包含的星期数为要抓取日期的星期数的后一天或者后两天，表示已经抓取到结尾 完成抓取
		boolean flag = true;
		try {
			flag = fetchJczqSpOnce(officialDate, dateStr, list);
		} catch (Exception e) {
			logger.error("抓取竞彩足球sp出错");
			return null;
		}
		Date date = CoreDateUtils.parseDate(officialDate, "yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int days = 0;//最多抓7天
		while (flag && days < 7) {
			days ++;
			cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
			try {
				flag = fetchJczqSpOnce(CoreDateUtils.formatDate(cal.getTime(), "yyyyMMdd"), dateStr, list);
			} catch (Exception e) {
				logger.error("抓取竞彩足球sp出错");
				return null;
			}
		}
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}
	
	
	
	protected boolean fetchJczqSpOnce(String officialDate, String dateStr, List<JczqSpItem> list) throws Exception{
		if (officialDate == null || "".equals(officialDate)) {
			logger.error("竞彩足球抓取开奖sp时，officialDate为空");
			return false;
		}
		
		String fetchDate = CoreDateUtils.formatDate(CoreDateUtils.parseDate(officialDate, "yyyyMMdd"), CoreDateUtils.DATE);
		String encoding = CharsetConstant.CHARSET_GBK;
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("playid", "0");
		params.put("d", fetchDate);
		
		List<String> data = null;
		try {
			data = CoreHttpUtils.postUrl(URL_500WAN_JCLQ, params, encoding, 10000);
		} catch (IOException e) {
			logger.error("抓取到竞彩足球开奖SP出错," + FetcherType.T_500WAN.getName());
			throw e;
		}
		
		if (data == null || data.size() == 0) {
			logger.error("未抓取到竞彩足球开奖SP," + FetcherType.T_500WAN.getName());
			return false;
		}
		
		String postData = data.toString();
		
		if (postData == null || postData.indexOf("404 Not Found") > 0 || postData.isEmpty()) {
			logger.error("未抓取到竞彩足球开奖SP," + FetcherType.T_500WAN.getName());
			return false;
		}	
		
		Parser parser = null;
		
		try {
			parser = Parser.createParser(postData,  encoding);
		} catch (Exception e) {
			logger.error("解析html页面失败" + e.getMessage());
			throw e;
		}		
		
		NodeFilter filter = new HasAttributeFilter("class", "ld_table");		
		NodeList nodeList = null;
		
		if(list == null) {
			list = new ArrayList<JczqSpItem>();
		}
		
		boolean flag = true;
		
		try {
			nodeList = parser.extractAllNodesThatMatch(filter);
			if (nodeList == null || nodeList.size() == 0) {
				logger.error("未能找到相应的HTML节点");
				return false;
			}
			TableTag table = (TableTag) nodeList.elementAt(0);
			TableRow[] rows = table.getRows();
			
			Calendar cd = Calendar.getInstance();
			cd.setTime(CoreDateUtils.parseDate(dateStr, "yyyyMMdd"));
			int weekNum = cd.get(Calendar.DAY_OF_WEEK);
			
			DecimalFormat df = new DecimalFormat("0.000000");
			
			for (int i = 1; i < rows.length; i++) {
				TableRow row = rows[i];
				TableColumn[] columns = row.getColumns();
				JczqSpItem item = new JczqSpItem();
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(CoreDateUtils.parseDate(officialDate, "yyyyMMdd"));
				Calendar matchDateCalendar = Calendar.getInstance();
				matchDateCalendar.setTime(CoreDateUtils.parseDate("" + cal.get(Calendar.YEAR) + "-" + columns[2].toPlainTextString() + ":00", CoreDateUtils.DATETIME));
				item.setMatchDate(matchDateCalendar.getTime());
				
				String officialNum = columns[0].toPlainTextString();
				int fetchWeekDay = weekDay.get(officialNum.substring(0, 2));
				
				//取得要抓的日期的下一天的星期数
				int nextWeekNum = weekNum + 1;
				if (nextWeekNum > 7) {
					nextWeekNum = nextWeekNum % 7;
				}
				
				//取得要抓的日期的下两天的星期数
				int next2WeekNum = weekNum + 2;
				if (next2WeekNum > 7) {
					next2WeekNum = next2WeekNum % 7;
				}
				
				if (fetchWeekDay != weekNum) {
					if (fetchWeekDay == nextWeekNum || fetchWeekDay == next2WeekNum) {
						flag = false;
					} 
					continue;
				}
				
				item.setMatchNum(dateStr + LotteryConstant.JCZQ_MATCH_NUM_CODE_DEFAULT + officialNum.substring(2));
				item.setOfficialDate(CoreDateUtils.parseDate(CoreDateUtils.formatDate(cd.getTime())));
				String oNum = null;
				try {
					oNum = officialNum.substring(2);
				} catch (Exception e) {
					logger.error("截取官方编码时，截取错误", e);
				}
				item.setOfficialNum(oNum);
				
				item.setMatchName(CoreStringUtils.trimAll(columns[1].toPlainTextString()));
				
				item.setHomeTeam(CoreStringUtils.trimAll(columns[3].toPlainTextString()));
				item.setAwayTeam(CoreStringUtils.trimAll(columns[5].toPlainTextString()));
				try {
					double spf = Double.parseDouble(CoreStringUtils.trimAll(columns[9].toPlainTextString()));
					if(spf >= 2) {
						item.setPrizeSpf(df.format(spf));
					} else {
						item.setPrizeSpf("0.000000");
					}
				} catch (Exception e) {
					item.setPrizeSpf("0.000000");
				}
				
				try {
					double jqs = Double.parseDouble(CoreStringUtils.trimAll(columns[12].toPlainTextString()));
					if(jqs >= 2) {
						item.setPrizeJqs(df.format(jqs));
					} else {
						item.setPrizeJqs("0.000000");
					}
				} catch (Exception e) {
					item.setPrizeJqs("0.000000");
				}
				
				try {
					double bf = Double.parseDouble(CoreStringUtils.trimAll(columns[15].toPlainTextString()));
					if(bf >= 2) {
						item.setPrizeBf(df.format(bf));
					} else {
						item.setPrizeBf("0.000000");
					}
				} catch (Exception e) {
					item.setPrizeBf("0.000000");
				}
				
				try {
					double bqc = Double.parseDouble(CoreStringUtils.trimAll(columns[18].toPlainTextString()));
					if(bqc >= 2) {
						item.setPrizeBqc(df.format(bqc));
					} else {
						item.setPrizeBqc("0.000000");
					}
				} catch (Exception e) {
					item.setPrizeBqc("0.000000");
				}

				if(CoreStringUtils.trimAll(columns[6].toPlainTextString()) != null) {
					int position = CoreStringUtils.trimAll(columns[6].toPlainTextString()).indexOf(")");
					if (position != -1) {
						item.setFirstHalf(CoreStringUtils.trimAll(columns[6].toPlainTextString()).substring(1, position));
						item.setSecondHalf("");
						item.setFinalScore(CoreStringUtils.trimAll(columns[6].toPlainTextString()).substring(position + 1));
					}
				}
				list.add(item);				
			}
			System.out.println();
		} catch (ParserException e) {
			logger.error("解析HTML出错");
			throw e;
		}
		return flag;
	}

}
