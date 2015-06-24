package com.lehecai.core.util.lottery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.LotteryConstant;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.util.CoreDateUtils;
import com.lehecai.core.util.CoreXmlUtils;
/**
 * @author qatang
 */
public class JczqUtil {
	private static final Logger logger = LoggerFactory.getLogger(JczqUtil.class);
	/**
	 * 抓取的比赛名称映射
	 * key:fetcherType.getName() + "_" + lotteryType.getValue()
	 * value:Map<String, String>   key:抓取网站的比赛名称  value:本站中文比赛简称
	 */
	private static Map<String, Map<String, String>> fetcherMatchNameMappings = new HashMap<String, Map<String,String>>();
	
	static {
		fetcherMatchNameMappings = CoreXmlUtils.createFetcherMatchNameMapping();
	}
	/**
	 * 转换奖项名称 外网 至 内网
	 * 将从网站抓取的比赛名称转换为本站对应的比赛简称
	 * 找不到自定义的默认不做转换
	 * @param name
	 * @param lotteryType
	 * @param fetcherType
	 * @return
	 */
	public static String convertMatchName(String name, LotteryType lotteryType, FetcherType fetcherType) {
		Map<String, String> lotteryMappings = fetcherMatchNameMappings.get(fetcherType.getName() + "_" + lotteryType.getValue());
		if (lotteryMappings != null) {
			String convertedName = lotteryMappings.get(name);
			if (convertedName != null) {
				return convertedName;
			} else{
				logger.warn("未找到可转换奖项名称,原样返回.从["+fetcherType.getName()+"]抓取["+lotteryType.getName()+"]的比赛名称name("+name+")与系统配置的比赛名称名称没有匹配项,请检查系统比赛名称配置文件jclqMatchNameConfig.xml;");
			}
		}else{
			logger.warn("未配置彩种["+lotteryType.getName()+"]可转换比赛名称名称,原样返回.从["+fetcherType.getName()+"]抓取["+lotteryType.getName()+"]的比赛名称name("+name+")与系统配置的比赛名称名称没有匹配项,系统中没有配置该彩种["+lotteryType.getName()+"]的奖项名称对应模板,请检查系统比赛名称配置文件jclqMatchNameConfig.xml;");
		}
		return name;
	}
	/**
	 * 根据比赛时间得到官方销售截止时间
	 * 竞彩足球截止时间：周一、二、三、四、五 09:00～24:00  周六至周日 09:00～次日01:00
	 * @param matchDate
	 * @return Date
	 */
	
    static public final String DAYSINWEEK = "日一二三四五六";

    /**
     * 欧洲杯期间的停售时间处理
     * 规则：在欧洲杯比赛日(2012)6月8日-7月1日期间（除6月20、25、26、29、30日外）共19天，竞彩销售时间延长至次日02：45停售
     * 由于这里的入参是比赛时间，所以都拿官方比赛日次日做判断
     * @param matchDate
     * @return
     */
    private static Date europeCup2012StartDate = CoreDateUtils.parseLongDate("2012-06-09 00:00:00");
    private static Date europeCup2012EndDate = CoreDateUtils.parseLongDate("2012-07-02 02:45:00");
    private static Map<String, Boolean> europeCup2012NoMatchDateMap = new HashMap<String, Boolean>();
    static {
    	europeCup2012NoMatchDateMap.put("2012-06-21", true);
    	europeCup2012NoMatchDateMap.put("2012-06-26", true);
    	europeCup2012NoMatchDateMap.put("2012-06-27", true);
    	europeCup2012NoMatchDateMap.put("2012-06-30", true);
    	europeCup2012NoMatchDateMap.put("2012-07-01", true);
    }
    public static boolean isDuringEuropeCup(Date date) {
    	if (date == null) {
    		return false;
    	}
    	// 不在欧洲杯期间，不做处理
    	if (date.before(europeCup2012StartDate) || date.after(europeCup2012EndDate)) {
    		return false;
    	}
    	
    	String matchDateStr = CoreDateUtils.formatDate(date);
    	if (europeCup2012NoMatchDateMap.containsKey(matchDateStr) && europeCup2012NoMatchDateMap.get(matchDateStr)) {
    		// 没有比赛的日期，不做特殊处理
    		return false;
    	}
    	
    	return true;
    }
    public static Date getOfficialEndSaleTimeByMatchDateDuringEuropeCup(Date matchDate) {
    	if (matchDate == null) {
			return null;
		}

    	if (!isDuringEuropeCup(matchDate)) {
    		// 不在欧洲杯期间，不做处理
    		return null;
    	}

    	Calendar cd = Calendar.getInstance();
    	cd.setTime(matchDate);
    	
		int hourOfDay = cd.get(Calendar.HOUR_OF_DAY);
		int minute = cd.get(Calendar.MINUTE);

		Calendar endSaleCalendar = Calendar.getInstance();
		endSaleCalendar.setTime(matchDate);

		endSaleCalendar.set(Calendar.MILLISECOND, 0);

		// 不管周几都卖到02:45，02:45-09:00都设置成02:45
		if ((hourOfDay > 2 && hourOfDay < 9) || (hourOfDay == 9 && minute == 0) || (hourOfDay == 2 && minute > 45)) {
			endSaleCalendar.set(Calendar.HOUR_OF_DAY, 2);
			endSaleCalendar.set(Calendar.MINUTE, 45);
			endSaleCalendar.set(Calendar.SECOND, 0);
		}
		return endSaleCalendar.getTime();
    }
    
    /**
     * 传入一个比赛时间，得到竞彩官方规则针对这个比赛时间的截止销售时间
     * @param matchDate
     * @return
     */
    public static Date getOfficialEndSaleTimeByMatchDate(Date matchDate) {
    	if (matchDate == null) {
			return null;
		}

    	// 如果在欧洲杯期间，做一下预处理
    	Date endSaleDate = getOfficialEndSaleTimeByMatchDateDuringEuropeCup(matchDate);
    	if (endSaleDate != null) {
    		return endSaleDate;
    	}
    	
    	Calendar cd = Calendar.getInstance();
    	cd.setTime(matchDate);
    	
    	int matchWeekday = cd.get(Calendar.DAY_OF_WEEK);
		int hourOfDay = cd.get(Calendar.HOUR_OF_DAY);
		int minute = cd.get(Calendar.MINUTE);

		Calendar endSaleCalendar = Calendar.getInstance();
		endSaleCalendar.setTime(matchDate);

		endSaleCalendar.set(Calendar.MILLISECOND, 0);
		
		if (matchWeekday == Calendar.MONDAY) {
			if (hourOfDay >= 1 && (hourOfDay < 9 || (hourOfDay == 9 && minute == 0))) {
				endSaleCalendar.set(Calendar.HOUR_OF_DAY, 1);
				endSaleCalendar.set(Calendar.MINUTE, 0);
				endSaleCalendar.set(Calendar.SECOND, 0);
			}
		} else if (matchWeekday == Calendar.TUESDAY || matchWeekday == Calendar.FRIDAY || matchWeekday == Calendar.WEDNESDAY || matchWeekday == Calendar.THURSDAY) {
			if (hourOfDay < 9 || (hourOfDay == 9 && minute == 0)) {
				endSaleCalendar.set(Calendar.HOUR_OF_DAY, 0);
				endSaleCalendar.set(Calendar.MINUTE, 0);
				endSaleCalendar.set(Calendar.SECOND, 0);
			}
		} else if (matchWeekday == Calendar.SATURDAY) {
			if (hourOfDay < 9 || (hourOfDay == 9 && minute == 0)) {
				endSaleCalendar.set(Calendar.HOUR_OF_DAY, 0);
				endSaleCalendar.set(Calendar.MINUTE, 0);
				endSaleCalendar.set(Calendar.SECOND, 0);
			}
		} else {
			if (hourOfDay >= 1 && (hourOfDay < 9 || (hourOfDay == 9 && minute == 0))) {
				endSaleCalendar.set(Calendar.HOUR_OF_DAY, 1);
				endSaleCalendar.set(Calendar.MINUTE, 0);
				endSaleCalendar.set(Calendar.SECOND, 0);
			}
		}
		return endSaleCalendar.getTime();
    }
    
	/**
	 * 注意：返回的是不减去提前量的时间，提前量只用来做判断
	 * @param matchDate
	 * @param endSaleForward（提前销售截止时间，毫秒）
	 * @return
	 */
	public static Date getEndSaleTimeByMatchDate(Date matchDate, long endSaleForward) {
		if (matchDate == null) {
			return null;
		}
		
		// 不带提前量得到本场比赛在官方的截止时间
		Date officialEndSaleTime = getOfficialEndSaleTimeByMatchDate(matchDate);
		
		// 加上提前量
		Calendar cd = Calendar.getInstance();
		cd.setTimeInMillis(officialEndSaleTime.getTime() - endSaleForward);
		
		// 带提前量以后的比赛时间在官方的截止时间
		Date endSaleTime = getOfficialEndSaleTimeByMatchDate(cd.getTime());
		
		if (endSaleTime.before(cd.getTime())) {
			// 如果带上提前量后的官方截止时间发生了变化,说明应该使用第二次计算的截止时间
			return endSaleTime;
		}
		
		return officialEndSaleTime;
	}
	
	//根据竞彩足球的官方赛程发布时间和比赛场次编号生成我们系统的赛程场次编号
	public static String getMatchNum(String officialDate,String officialNum){
		return officialDate + LotteryConstant.JCZQ_MATCH_NUM_CODE_DEFAULT + officialNum.substring(officialNum.length()-3, officialNum.length());
	}
    
    //根据我们系统的赛程场次编号生成官方赛程场次编号
	public static String getOfficialNum(String matchNum){
        Date matchDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //我们系统场次编码的前8位为官方发布比赛时间的日期
        try {
			matchDate = sdf.parse(matchNum.substring(0, 8));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(matchDate);
		String dayofweek =String.valueOf(DAYSINWEEK.charAt(cal.get(Calendar.DAY_OF_WEEK)-1));
		String matchNoString = matchNum.substring(matchNum.length()-3, matchNum.length());
		return "周" + dayofweek + matchNoString;
	}
}
