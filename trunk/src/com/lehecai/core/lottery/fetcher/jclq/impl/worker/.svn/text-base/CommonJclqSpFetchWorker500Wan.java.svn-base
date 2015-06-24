package com.lehecai.core.lottery.fetcher.jclq.impl.worker;

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
import com.lehecai.core.lottery.fetcher.jclq.AbstractJclqSpFetchWorker;
import com.lehecai.core.lottery.fetcher.jclq.JclqSpItem;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreDateUtils;
import com.lehecai.core.util.CoreHttpUtils;
import com.lehecai.core.util.CoreStringUtils;

/**
 * 通用竞彩篮球sp抓取实现类
 * @author qatang
 *
 */
public class CommonJclqSpFetchWorker500Wan extends AbstractJclqSpFetchWorker{
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private static final String URL_500WAN_JCLQ = "http://zx.500wan.com/jclq/kaijiang.php";

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
	
	public List<JclqSpItem> fetchJclqSp(String officialDate){
		if (officialDate == null || "".equals(officialDate)) {
			logger.error("竞彩足球抓取开奖sp时，officialDate为空");
			return null;
		}
		String dateStr = officialDate;
		
		List<JclqSpItem> list = new ArrayList<JclqSpItem>();
		
		//由于我站抓取时间设定为官方比赛编号时间“周n”，而500wan页面抓取时间是比赛时间，
		//这里将抓取传进的官方比赛编号后几天得数据来获得比赛编号为传入的时间的比赛
		//如果抓取到的比赛编号中包含的星期数为要抓取日期的星期数的后一天或者后两天，表示已经抓取到结尾 完成抓取
		boolean flag = true;
		try {
			flag = fetchJclqSpOnce(officialDate, dateStr, list);
		} catch (Exception e) {
			logger.error("抓取竞彩篮球开奖sp出错");
			return null;
		}
		Date date = CoreDateUtils.parseDate(officialDate, "yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int days = 0;//最多抓7天
		while (flag && days < 7) {
			days++;
			cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
			try {
				flag = fetchJclqSpOnce(CoreDateUtils.formatDate(cal.getTime(), "yyyyMMdd"), dateStr, list);
			} catch (Exception e) {
				logger.error("抓取竞彩篮球开奖sp出错");
				return null;
			}
		}
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}
	
	protected boolean fetchJclqSpOnce(String officialDate, String dateStr, List<JclqSpItem> list) throws Exception{
		if (officialDate == null || "".equals(officialDate)) {
			logger.error("竞彩篮球抓取开奖sp时，officialDate为空");
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
			logger.error("抓取到竞彩篮球开奖SP出错," + FetcherType.T_500WAN.getName());
			throw e;
		}
		
		if (data == null || data.size() == 0) {
			logger.error("未抓取到竞彩篮球开奖SP," + FetcherType.T_500WAN.getName());
			return false;
		}
		
		String postData = data.toString();
		
		if (postData == null || postData.indexOf("404 Not Found") > 0 || postData.isEmpty()) {
			logger.error("未抓取到竞彩篮球开奖SP," + FetcherType.T_500WAN.getName());
			return false;
		}	
		
		Parser parser = null;
		
		try {
			parser = Parser.createParser(postData,  encoding);
		} catch (Exception e) {
			logger.error("解析html页面失败" + e.getMessage());
			throw e;
		}		
		
		NodeFilter filter = new HasAttributeFilter("id", "dg1");		
		NodeList nodeList = null;
		
		if(list == null) {
			list = new ArrayList<JclqSpItem>();
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
			
			DecimalFormat df = new DecimalFormat("0.00");
			
			for (int i = 1; i < rows.length; i++) {
				TableRow row = rows[i];
				TableColumn[] columns = row.getColumns();
				JclqSpItem item = new JclqSpItem();
				
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
				
				item.setMatchNum(dateStr + LotteryConstant.JCLQ_MATCH_NUM_CODE_DEFAULT + officialNum.substring(2));
				item.setOfficialDate(CoreDateUtils.parseDate(CoreDateUtils.formatDate(cd.getTime())));
				Integer oNum = null;
				try {
					oNum = Integer.valueOf(officialNum.substring(2));
				} catch (Exception e) {
					logger.error("截取官方编码时，转换为Integer错误", e);
				}
				item.setOfficialNum(oNum);
				
				item.setHomeTeam(CoreStringUtils.trimAll(columns[5].toPlainTextString()));
				item.setAwayTeam(CoreStringUtils.trimAll(columns[3].toPlainTextString()));
				item.setFirstQuarter("");
				item.setSecondQuarter("");
				item.setThirdQuarter("");
				item.setFourthQuarter("");
				item.setFinalScore(CoreStringUtils.trimAll(columns[6].toPlainTextString()));
				String sf = CoreStringUtils.trimAll(columns[7].toPlainTextString());
				if(sf != null && !sf.equals("")) {
					try {
						item.setPrizeSf(df.format(Double.parseDouble(CoreStringUtils.trimAll(columns[8].toPlainTextString()))));
					} catch (Exception e) {
						item.setPrizeSf("0.00");
					}
				} else {
					item.setPrizeSf("0.00");
				}
				String rfsf = CoreStringUtils.trimAll(columns[11].toPlainTextString());
				if(rfsf != null && !rfsf.equals("")) {
					try {
						item.setPrizeRfsf(df.format(Double.parseDouble(CoreStringUtils.trimAll(columns[12].toPlainTextString()))));
					} catch (Exception e) {
						item.setPrizeRfsf("0.00");
					}
				} else {
					item.setPrizeRfsf("0.00");
				}
				String sfc = CoreStringUtils.trimAll(columns[13].toPlainTextString());
				if(sfc != null && !sfc.equals("")) {
					try{
						item.setPrizeSfc(df.format(Double.parseDouble(CoreStringUtils.trimAll(columns[14].toPlainTextString()))));
					} catch (Exception e) {
						item.setPrizeSfc("0.00");
					}
				} else {
					item.setPrizeSfc("0.00");
				}
				String dxf = CoreStringUtils.trimAll(columns[18].toPlainTextString());
				if(dxf != null && !dxf.equals("")) {
					try{
						item.setPrizeDxf(df.format(Double.parseDouble(CoreStringUtils.trimAll(columns[19].toPlainTextString()))));
					} catch (Exception e) {
						item.setPrizeDxf("0.00");
					}
				} else {
					item.setPrizeDxf("0.00");
				}
				item.setMatchName(CoreStringUtils.trimAll(columns[1].toPlainTextString()));
				list.add(item);
			}
		} catch (ParserException e) {
			logger.error("解析HTML出错");
			throw e;
		}
		return flag;
	}
}
