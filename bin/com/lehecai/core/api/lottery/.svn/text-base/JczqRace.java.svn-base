package com.lehecai.core.api.lottery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.JczqDynamicDrawStatus;
import com.lehecai.core.lottery.JczqDynamicSaleStatus;
import com.lehecai.core.lottery.JczqRaceStatus;
import com.lehecai.core.lottery.JczqStaticDrawStatus;
import com.lehecai.core.lottery.JczqStaticSaleStatus;
import com.lehecai.core.util.CoreDateUtils;
/**
 * 
 * @author qatang
 *
 */
public class JczqRace extends AbstractApiResultBean implements Serializable{

	private static final long serialVersionUID = 1L;
	public static Map<Integer, String> WEEKSTR = new HashMap<Integer, String>();
	
	static {
		WEEKSTR.put(1, "周日");
		WEEKSTR.put(2, "周一");
		WEEKSTR.put(3, "周二");
		WEEKSTR.put(4, "周三");
		WEEKSTR.put(5, "周四");
		WEEKSTR.put(6, "周五");
		WEEKSTR.put(7, "周六");
	}
	
	public static final String QUERY_MATCH_NUM = "match_num";
	public static final String QUERY_PHASE = "phase";
	public static final String QUERY_STATUS = "status";
	public static final String QUERY_OFFICIAL_DATE = "official_date";
	public static final String QUERY_STATIC_DRAW_STATUS = "static_draw_status";
	public static final String QUERY_DYNAMIC_DRAW_STATUS = "dynamic_draw_status";
	public static final String QUERY_MATCH_DATE = "match_date";
	public static final String QUERY_END_SALE_DATE = "time_endsale";
	
	public static final String SET_MATCH_NUM = "match_num";
	public static final String SET_PHASE = "phase";
	public static final String SET_OFFICIAL_DATE = "official_date";
	public static final String SET_OFFICIAL_NUM = "official_num"; 
	public static final String SET_END_SALE_DATE = "time_endsale";
	public static final String SET_MATCH_NAME = "match_name";
	public static final String SET_MATCH_DATE = "match_date";
	public static final String SET_HOME_TEAM = "home_team";
	public static final String SET_AWAY_TEAM = "away_team";
	public static final String SET_HANDICAP = "handicap";
	public static final String SET_FIRST_HALF = "first_half";
	public static final String SET_SECOND_HALF = "second_half";
	public static final String SET_FINAL_SCORE = "final_score";
	public static final String SET_STATUS = "status";
	public static final String SET_STATIC_DRAW_STATUS = "static_draw_status";
	public static final String SET_DYNAMIC_DRAW_STATUS = "dynamic_draw_status";
	public static final String SET_STATIC_SALE_STATUS_SPF = "static_sale_status_spf";
	public static final String SET_DYNAMIC_SALE_STATUS_SPF = "dynamic_sale_status_spf";
	public static final String SET_STATIC_SALE_STATUS_BF = "static_sale_status_bf";
	public static final String SET_DYNAMIC_SALE_STATUS_BF = "dynamic_sale_status_bf";
	public static final String SET_STATIC_SALE_STATUS_JQS = "static_sale_status_jqs";
	public static final String SET_DYNAMIC_SALE_STATUS_JQS = "dynamic_sale_status_jqs";
	public static final String SET_STATIC_SALE_STATUS_BQC = "static_sale_status_bqc";
	public static final String SET_DYNAMIC_SALE_STATUS_BQC = "dynamic_sale_status_bqc";
	public static final String SET_PRIZE_SPF = "prize_spf";
	public static final String SET_PRIZE_BF = "prize_bf";
	public static final String SET_PRIZE_JQS = "prize_jqs";
	public static final String SET_PRIZE_BQC = "prize_bqc";
	public static final String SET_PRIORITY = "priority";
	public static final String SET_FX_ID = "fx_id";
	public static final String SET_EXT = "ext";
	
	public static final String ORDER_MATCH_NUM = "match_num";
	public static final String ORDER_CREATE_AT = "create_at";
	public static final String ORDER_MATCH_DATE = "match_date";
	public static final String ORDER_OFFICIAL_DATE = "official_date";
	public static final String ORDER_OFFICIAL_NUM = "official_num";
	public static final String ORDER_END_SALE_DATE = "time_endsale";

	private String matchNum;              //比赛编码,年月日+01+官方赛事编码（01为预留位）2011031401001
	private String phase;             	//彩期号,目前使用同一彩期
	private Date officialDate;        	//官方公布比赛场次的日期
	private String officialNum;        //官方赛事编码,001
	private String officialWeekDay;     //官方赛事星期数，for view
	private Date createAt;        		//创建时间
	private Date endSaleTime;        	//停止销售时间
	private String matchName;           //赛事
	private Date matchDate;        		//比赛日期
	private String homeTeam;        	//主队
	private String awayTeam;        	//客队
	private String handicap;     //浮动奖金投注让球
	private String firstHalf;           //上半场比分
	private String secondHalf;          //下半场比分
	private String finalScore;          //最终比分
	private JczqRaceStatus status;		//比赛状态
	private JczqStaticDrawStatus staticDrawStatus;		//固定奖金开奖状态
	private JczqDynamicDrawStatus dynamicDrawStatus;	//浮动奖金开奖状态
	private JczqStaticSaleStatus staticSaleSpfStatus;	//固定奖金胜平负玩法销售状态
	private JczqDynamicSaleStatus dynamicSaleSpfStatus;	//浮动奖金胜平负玩法销售状态
	private JczqStaticSaleStatus staticSaleBfStatus;	//固定奖金全场比分玩法销售状态
	private JczqDynamicSaleStatus dynamicSaleBfStatus;  //浮动奖金全场比分玩法销售状态
	private JczqStaticSaleStatus staticSaleJqsStatus;	//固定奖金进球总数玩法销售状态
	private JczqDynamicSaleStatus dynamicSaleJqsStatus;	//浮动奖金进球总数玩法销售状态
	private JczqStaticSaleStatus staticSaleBqcStatus;	//固定奖金半全场胜平负玩法销售状态
	private JczqDynamicSaleStatus dynamicSaleBqcStatus;	//浮动奖金半全场胜平负玩法销售状态
	private String prizeSpf;				//胜平负奖金值,浮动奖金投注的开奖奖金
	private String prizeBf;				    //全场比分奖金值,浮动奖金投注的开奖奖金
	private String prizeJqs;				//进球总数奖金值,浮动奖金投注的开奖奖金
	private String prizeBqc;				//半全场胜平负奖金值,浮动奖金投注的开奖奖金
	private int fxId;					//分析id
	private int priority;				//优先级
	private String ext;               	//扩展信息
	
	public static JczqRace convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		JczqRace jczqRace = new JczqRace();
		
		jczqRace.setMatchNum(getString(object, "match_num"));
		jczqRace.setPhase(getString(object, "phase"));
		jczqRace.setOfficialDate(CoreDateUtils.parseDate(getString(object, "official_date"), CoreDateUtils.DATETIME));
		jczqRace.setOfficialNum(getString(object, "official_num"));
		
		if (jczqRace.getOfficialDate() != null) {
			Calendar cd = Calendar.getInstance();
			cd.setTime(jczqRace.getOfficialDate());
			jczqRace.setOfficialWeekDay(WEEKSTR.get(cd.get(Calendar.DAY_OF_WEEK)));
		}
		
		jczqRace.setCreateAt(CoreDateUtils.parseDate(getString(object, "create_at"), CoreDateUtils.DATETIME));
		jczqRace.setEndSaleTime(CoreDateUtils.parseDate(getString(object, "time_endsale"), CoreDateUtils.DATETIME));
		jczqRace.setMatchName(getString(object, "match_name"));
		jczqRace.setMatchDate(CoreDateUtils.parseDate(getString(object, "match_date"), CoreDateUtils.DATETIME));
		jczqRace.setHomeTeam(getString(object, "home_team"));
		jczqRace.setAwayTeam(getString(object, "away_team"));
		jczqRace.setHandicap(getString(object, "handicap"));
		jczqRace.setFirstHalf(getString(object, "first_half"));
		jczqRace.setSecondHalf(getString(object, "second_half"));
		jczqRace.setFinalScore(getString(object, "final_score"));
		jczqRace.setStatus(JczqRaceStatus.getItem(getInt(object, "status")));
		jczqRace.setStaticDrawStatus(JczqStaticDrawStatus.getItem(getInt(object, "static_draw_status")));
		jczqRace.setDynamicDrawStatus(JczqDynamicDrawStatus.getItem(getInt(object, "dynamic_draw_status")));
		jczqRace.setStaticSaleSpfStatus(JczqStaticSaleStatus.getItem(getInt(object, "static_sale_status_spf")));
		jczqRace.setDynamicSaleSpfStatus(JczqDynamicSaleStatus.getItem(getInt(object, "dynamic_sale_status_spf")));
		jczqRace.setStaticSaleBfStatus(JczqStaticSaleStatus.getItem(getInt(object, "static_sale_status_bf")));
		jczqRace.setDynamicSaleBfStatus(JczqDynamicSaleStatus.getItem(getInt(object, "dynamic_sale_status_bf")));
		jczqRace.setStaticSaleJqsStatus(JczqStaticSaleStatus.getItem(getInt(object, "static_sale_status_jqs")));
		jczqRace.setDynamicSaleJqsStatus(JczqDynamicSaleStatus.getItem(getInt(object, "dynamic_sale_status_jqs")));
		jczqRace.setStaticSaleBqcStatus(JczqStaticSaleStatus.getItem(getInt(object, "static_sale_status_bqc")));
		jczqRace.setDynamicSaleBqcStatus(JczqDynamicSaleStatus.getItem(getInt(object, "dynamic_sale_status_bqc")));
		jczqRace.setPrizeSpf(getString(object, "prize_spf"));
		jczqRace.setPrizeBf(getString(object, "prize_bf"));
		jczqRace.setPrizeJqs(getString(object, "prize_jqs"));
		jczqRace.setPrizeBqc(getString(object, "prize_bqc"));
		jczqRace.setFxId(getInt(object, "fx_id"));
		jczqRace.setPriority(getInt(object, "priority"));
		jczqRace.setExt(getString(object, "ext"));
		
		return jczqRace;
	}
	@SuppressWarnings("unchecked")
	public static List<JczqRace> convertFromJSONArray(JSONArray array) {
		logger.info(array.toString());
		if (array == null) {
			return null;
		}
		List<JczqRace> list = new ArrayList<JczqRace>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}
	
	public static JSONObject toJSON(JczqRace dcRace) {
		JSONObject object = JSONObject.fromObject(dcRace);
		return object;
	}
	
	public static JSONArray toJSONArray(List<JczqRace> dcRaces) {
		JSONArray ja = new JSONArray();
		JSONObject jsonObject = null;
		if(dcRaces != null && dcRaces.size() > 0){
			for(JczqRace dcRace:dcRaces){
				jsonObject = JczqRace.toJSON(dcRace);
				ja.add(jsonObject);
			}
		}
		return ja;
	}
	public String getMatchNum() {
		return matchNum;
	}
	public void setMatchNum(String matchNum) {
		this.matchNum = matchNum;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public Date getOfficialDate() {
		return officialDate;
	}
	public void setOfficialDate(Date officialDate) {
		this.officialDate = officialDate;
	}
	public String getOfficialNum() {
		return officialNum;
	}
	public void setOfficialNum(String officialNum) {
		this.officialNum = officialNum;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getEndSaleTime() {
		return endSaleTime;
	}
	public void setEndSaleTime(Date endSaleTime) {
		this.endSaleTime = endSaleTime;
	}
	public String getMatchName() {
		return matchName;
	}
	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}
	public Date getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}
	public String getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	public String getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}
	public String getHandicap() {
		return handicap;
	}
	public void setHandicap(String handicap) {
		this.handicap = handicap;
	}
	public String getFinalScore() {
		return finalScore;
	}
	public void setFinalScore(String finalScore) {
		this.finalScore = finalScore;
	}
	public int getFxId() {
		return fxId;
	}
	public void setFxId(int fxId) {
		this.fxId = fxId;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public String getOfficialWeekDay() {
		return officialWeekDay;
	}
	public void setOfficialWeekDay(String officialWeekDay) {
		this.officialWeekDay = officialWeekDay;
	}
	
	public String getFirstHalf() {
		return firstHalf;
	}
	public void setFirstHalf(String firstHalf) {
		this.firstHalf = firstHalf;
	}
	public String getSecondHalf() {
		return secondHalf;
	}
	public void setSecondHalf(String secondHalf) {
		this.secondHalf = secondHalf;
	}
	public JczqRaceStatus getStatus() {
		return status;
	}
	public void setStatus(JczqRaceStatus status) {
		this.status = status;
	}
	public JczqStaticDrawStatus getStaticDrawStatus() {
		return staticDrawStatus;
	}
	public void setStaticDrawStatus(JczqStaticDrawStatus staticDrawStatus) {
		this.staticDrawStatus = staticDrawStatus;
	}
	public JczqDynamicDrawStatus getDynamicDrawStatus() {
		return dynamicDrawStatus;
	}
	public void setDynamicDrawStatus(JczqDynamicDrawStatus dynamicDrawStatus) {
		this.dynamicDrawStatus = dynamicDrawStatus;
	}
	public JczqStaticSaleStatus getStaticSaleSpfStatus() {
		return staticSaleSpfStatus;
	}
	public void setStaticSaleSpfStatus(JczqStaticSaleStatus staticSaleSpfStatus) {
		this.staticSaleSpfStatus = staticSaleSpfStatus;
	}
	public JczqDynamicSaleStatus getDynamicSaleSpfStatus() {
		return dynamicSaleSpfStatus;
	}
	public void setDynamicSaleSpfStatus(JczqDynamicSaleStatus dynamicSaleSpfStatus) {
		this.dynamicSaleSpfStatus = dynamicSaleSpfStatus;
	}
	public JczqStaticSaleStatus getStaticSaleBfStatus() {
		return staticSaleBfStatus;
	}
	public void setStaticSaleBfStatus(JczqStaticSaleStatus staticSaleBfStatus) {
		this.staticSaleBfStatus = staticSaleBfStatus;
	}
	public JczqDynamicSaleStatus getDynamicSaleBfStatus() {
		return dynamicSaleBfStatus;
	}
	public void setDynamicSaleBfStatus(JczqDynamicSaleStatus dynamicSaleBfStatus) {
		this.dynamicSaleBfStatus = dynamicSaleBfStatus;
	}
	public JczqStaticSaleStatus getStaticSaleJqsStatus() {
		return staticSaleJqsStatus;
	}
	public void setStaticSaleJqsStatus(JczqStaticSaleStatus staticSaleJqsStatus) {
		this.staticSaleJqsStatus = staticSaleJqsStatus;
	}
	public JczqDynamicSaleStatus getDynamicSaleJqsStatus() {
		return dynamicSaleJqsStatus;
	}
	public void setDynamicSaleJqsStatus(JczqDynamicSaleStatus dynamicSaleJqsStatus) {
		this.dynamicSaleJqsStatus = dynamicSaleJqsStatus;
	}
	public JczqStaticSaleStatus getStaticSaleBqcStatus() {
		return staticSaleBqcStatus;
	}
	public void setStaticSaleBqcStatus(JczqStaticSaleStatus staticSaleBqcStatus) {
		this.staticSaleBqcStatus = staticSaleBqcStatus;
	}
	public JczqDynamicSaleStatus getDynamicSaleBqcStatus() {
		return dynamicSaleBqcStatus;
	}
	public void setDynamicSaleBqcStatus(JczqDynamicSaleStatus dynamicSaleBqcStatus) {
		this.dynamicSaleBqcStatus = dynamicSaleBqcStatus;
	}
	public String getPrizeSpf() {
		return prizeSpf;
	}
	public void setPrizeSpf(String prizeSpf) {
		this.prizeSpf = prizeSpf;
	}
	public String getPrizeBf() {
		return prizeBf;
	}
	public void setPrizeBf(String prizeBf) {
		this.prizeBf = prizeBf;
	}
	public String getPrizeJqs() {
		return prizeJqs;
	}
	public void setPrizeJqs(String prizeJqs) {
		this.prizeJqs = prizeJqs;
	}
	public String getPrizeBqc() {
		return prizeBqc;
	}
	public void setPrizeBqc(String prizeBqc) {
		this.prizeBqc = prizeBqc;
	}
	/**
	 * 获取对阵基本信息
	 * @return
	 */
	public String getJczqRaceInfo(){
		StringBuffer sb = new StringBuffer();
		sb.append("[").append(this.getMatchName()).append("]");
		sb.append("(主队)").append(this.getHomeTeam());
		sb.append(" vs ");
		sb.append("(客队)").append(this.getAwayTeam());
		sb.append(" at ");
		sb.append(CoreDateUtils.formatDateTime(getMatchDate()));
		return sb.toString();
	}
}
