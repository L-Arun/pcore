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
import com.lehecai.core.lottery.JclqDynamicDrawStatus;
import com.lehecai.core.lottery.JclqDynamicSaleStatus;
import com.lehecai.core.lottery.JclqRaceStatus;
import com.lehecai.core.lottery.JclqStaticDrawStatus;
import com.lehecai.core.lottery.JclqStaticSaleStatus;
import com.lehecai.core.util.CoreDateUtils;
/**
 * 
 * @author qatang
 *
 */
public class JclqRace extends AbstractApiResultBean implements Serializable{

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
	public static final String SET_DYNAMIC_HANDICAP = "dynamic_handicap";
	public static final String SET_STATIC_HANDICAP = "static_handicap";
	public static final String SET_DYNAMIC_PRESET_SCORE = "dynamic_preset_score";
	public static final String SET_STATIC_PRESET_SCORE = "static_preset_score";
	public static final String SET_FIRST_QUARTER = "first_quarter";
	public static final String SET_SECOND_QUARTER = "second_quarter";
	public static final String SET_THIRD_QUARTER = "third_quarter";
	public static final String SET_FOURTH_QUARTER = "fourth_quarter";
	public static final String SET_FINAL_SCORE = "final_score";
	public static final String SET_STATUS = "status";
	public static final String SET_STATIC_DRAW_STATUS = "static_draw_status";
	public static final String SET_DYNAMIC_DRAW_STATUS = "dynamic_draw_status";
	public static final String SET_STATIC_SALE_STATUS_SF = "static_sale_status_sf";
	public static final String SET_DYNAMIC_SALE_STATUS_SF = "dynamic_sale_status_sf";
	public static final String SET_STATIC_SALE_STATUS_RFSF = "static_sale_status_rfsf";
	public static final String SET_DYNAMIC_SALE_STATUS_RFSF = "dynamic_sale_status_rfsf";
	public static final String SET_STATIC_SALE_STATUS_SFC = "static_sale_status_sfc";
	public static final String SET_DYNAMIC_SALE_STATUS_SFC = "dynamic_sale_status_sfc";
	public static final String SET_STATIC_SALE_STATUS_DXF = "static_sale_status_dxf";
	public static final String SET_DYNAMIC_SALE_STATUS_DXF = "dynamic_sale_status_dxf";
	public static final String SET_PRIZE_SF = "prize_sf";
	public static final String SET_PRIZE_RFSF = "prize_rfsf";
	public static final String SET_PRIZE_SFC = "prize_sfc";
	public static final String SET_PRIZE_DXF = "prize_dxf";
	public static final String SET_PRIORITY = "priority";
	public static final String SET_FX_ID = "fx_id";
	public static final String SET_EXT = "ext";
	
	public static final String ORDER_MATCH_NUM = "match_num";
	public static final String ORDER_CREATE_AT = "create_at";
	public static final String ORDER_MATCH_DATE = "match_date";
	public static final String ORDER_OFFICIAL_DATE = "official_date";
	public static final String ORDER_OFFICIAL_NUM = "official_num";
	public static final String ORDER_END_SALE_DATE = "time_endsale";

	private String matchNum;              //比赛编码,年月日+00+官方赛事编码（00为预留位）2011031400301
	private String phase;             	//彩期号,目前使用同一彩期
	private Date officialDate;        	//官方公布比赛场次的日期
	private Integer officialNum;        //官方赛事编码,301
	private String officialWeekDay;     //官方赛事星期数，for view
	private Date createAt;        		//创建时间
	private Date endSaleTime;        	//停止销售时间
	private String matchName;           //赛事
	private Date matchDate;        		//比赛日期
	private String homeTeam;        	//主队
	private String awayTeam;        	//客队
	private String dynamicHandicap;     //浮动奖金投注让分
	private String staticHandicap;      //固定奖金投注当前让分
	private String dynamicPresetScore;  //浮动奖金投注预设总分
	private String staticPresetScore;   //固定奖金投注当前预设总分
	private String firstQuarter;        //第一节比分
	private String secondQuarter;       //第二节比分
	private String thirdQuarter;        //第三节比分
	private String fourthQuarter;       //第四节比分
	private String finalScore;          //最终比分
	private JclqRaceStatus status;		//比赛状态
	private JclqStaticDrawStatus staticDrawStatus;		//固定奖金开奖状态
	private JclqDynamicDrawStatus dynamicDrawStatus;	//浮动奖金开奖状态
	private JclqStaticSaleStatus staticSaleSfStatus;	//固定奖金胜负玩法销售状态
	private JclqDynamicSaleStatus dynamicSaleSfStatus;	//浮动奖金胜负玩法销售状态
	private JclqStaticSaleStatus staticSaleRfsfStatus;	//固定奖金让分胜负玩法销售状态
	private JclqDynamicSaleStatus dynamicSaleRfsfStatus;//浮动奖金让分胜负玩法销售状态
	private JclqStaticSaleStatus staticSaleSfcStatus;	//固定奖金胜分差玩法销售状态
	private JclqDynamicSaleStatus dynamicSaleSfcStatus;	//浮动奖金胜分差玩法销售状态
	private JclqStaticSaleStatus staticSaleDxfStatus;	//固定奖金大小分玩法销售状态
	private JclqDynamicSaleStatus dynamicSaleDxfStatus;	//浮动奖金大小分玩法销售状态
	private String prizeSf;				//胜负奖金值,浮动奖金投注的开奖奖金
	private String prizeRfsf;				//让分胜负奖金值,浮动奖金投注的开奖奖金
	private String prizeSfc;				//胜分差奖金值,浮动奖金投注的开奖奖金
	private String prizeDxf;				//大小分奖金值,浮动奖金投注的开奖奖金
	private int fxId;					//分析id
	private int priority;				//优先级
	private String ext;               	//扩展信息
	
	public static JclqRace convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		JclqRace jclqRace = new JclqRace();
		
		jclqRace.setMatchNum(getString(object, "match_num"));
		jclqRace.setPhase(getString(object, "phase"));
		jclqRace.setOfficialDate(CoreDateUtils.parseDate(getString(object, "official_date"), CoreDateUtils.DATETIME));
		jclqRace.setOfficialNum(getInt(object, "official_num"));
		
		if (jclqRace.getOfficialDate() != null) {
			Calendar cd = Calendar.getInstance();
			cd.setTime(jclqRace.getOfficialDate());
			jclqRace.setOfficialWeekDay(WEEKSTR.get(cd.get(Calendar.DAY_OF_WEEK)));
		}
		
		jclqRace.setCreateAt(CoreDateUtils.parseDate(getString(object, "create_at"), CoreDateUtils.DATETIME));
		jclqRace.setEndSaleTime(CoreDateUtils.parseDate(getString(object, "time_endsale"), CoreDateUtils.DATETIME));
		jclqRace.setMatchName(getString(object, "match_name"));
		jclqRace.setMatchDate(CoreDateUtils.parseDate(getString(object, "match_date"), CoreDateUtils.DATETIME));
		jclqRace.setHomeTeam(getString(object, "home_team"));
		jclqRace.setAwayTeam(getString(object, "away_team"));
		jclqRace.setDynamicHandicap(getString(object, "dynamic_handicap"));
		jclqRace.setStaticHandicap(getString(object, "static_handicap"));
		jclqRace.setDynamicPresetScore(getString(object, "dynamic_preset_score"));
		jclqRace.setStaticPresetScore(getString(object, "static_preset_score"));
		jclqRace.setFirstQuarter(getString(object, "first_quarter"));
		jclqRace.setSecondQuarter(getString(object, "second_quarter"));
		jclqRace.setThirdQuarter(getString(object, "third_quarter"));
		jclqRace.setFourthQuarter(getString(object, "fourth_quarter"));
		jclqRace.setFinalScore(getString(object, "final_score"));
		jclqRace.setStatus(JclqRaceStatus.getItem(getInt(object, "status")));
		jclqRace.setStaticDrawStatus(JclqStaticDrawStatus.getItem(getInt(object, "static_draw_status")));
		jclqRace.setDynamicDrawStatus(JclqDynamicDrawStatus.getItem(getInt(object, "dynamic_draw_status")));
		jclqRace.setStaticSaleSfStatus(JclqStaticSaleStatus.getItem(getInt(object, "static_sale_status_sf")));
		jclqRace.setDynamicSaleSfStatus(JclqDynamicSaleStatus.getItem(getInt(object, "dynamic_sale_status_sf")));
		jclqRace.setStaticSaleRfsfStatus(JclqStaticSaleStatus.getItem(getInt(object, "static_sale_status_rfsf")));
		jclqRace.setDynamicSaleRfsfStatus(JclqDynamicSaleStatus.getItem(getInt(object, "dynamic_sale_status_rfsf")));
		jclqRace.setStaticSaleSfcStatus(JclqStaticSaleStatus.getItem(getInt(object, "static_sale_status_sfc")));
		jclqRace.setDynamicSaleSfcStatus(JclqDynamicSaleStatus.getItem(getInt(object, "dynamic_sale_status_sfc")));
		jclqRace.setStaticSaleDxfStatus(JclqStaticSaleStatus.getItem(getInt(object, "static_sale_status_dxf")));
		jclqRace.setDynamicSaleDxfStatus(JclqDynamicSaleStatus.getItem(getInt(object, "dynamic_sale_status_dxf")));
		jclqRace.setPrizeSf(getString(object, "prize_sf"));
		jclqRace.setPrizeRfsf(getString(object, "prize_rfsf"));
		jclqRace.setPrizeSfc(getString(object, "prize_sfc"));
		jclqRace.setPrizeDxf(getString(object, "prize_dxf"));
		jclqRace.setFxId(getInt(object, "fx_id"));
		jclqRace.setPriority(getInt(object, "priority"));
		jclqRace.setExt(getString(object, "ext"));
		
		return jclqRace;
	}
	@SuppressWarnings("unchecked")
	public static List<JclqRace> convertFromJSONArray(JSONArray array) {
		logger.info(array.toString());
		if (array == null) {
			return null;
		}
		List<JclqRace> list = new ArrayList<JclqRace>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}
	
	public static JSONObject toJSON(JclqRace dcRace) {
		JSONObject object = JSONObject.fromObject(dcRace);
		return object;
	}
	
	public static JSONArray toJSONArray(List<JclqRace> dcRaces) {
		JSONArray ja = new JSONArray();
		JSONObject jsonObject = null;
		if(dcRaces != null && dcRaces.size() > 0){
			for(JclqRace dcRace:dcRaces){
				jsonObject = JclqRace.toJSON(dcRace);
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
	public Integer getOfficialNum() {
		return officialNum;
	}
	public void setOfficialNum(Integer officialNum) {
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
	public String getDynamicHandicap() {
		return dynamicHandicap;
	}
	public void setDynamicHandicap(String dynamicHandicap) {
		this.dynamicHandicap = dynamicHandicap;
	}
	public String getStaticHandicap() {
		return staticHandicap;
	}
	public void setStaticHandicap(String staticHandicap) {
		this.staticHandicap = staticHandicap;
	}
	public String getDynamicPresetScore() {
		return dynamicPresetScore;
	}
	public void setDynamicPresetScore(String dynamicPresetScore) {
		this.dynamicPresetScore = dynamicPresetScore;
	}
	public String getStaticPresetScore() {
		return staticPresetScore;
	}
	public void setStaticPresetScore(String staticPresetScore) {
		this.staticPresetScore = staticPresetScore;
	}
	public String getFirstQuarter() {
		return firstQuarter;
	}
	public void setFirstQuarter(String firstQuarter) {
		this.firstQuarter = firstQuarter;
	}
	public String getSecondQuarter() {
		return secondQuarter;
	}
	public void setSecondQuarter(String secondQuarter) {
		this.secondQuarter = secondQuarter;
	}
	public String getThirdQuarter() {
		return thirdQuarter;
	}
	public void setThirdQuarter(String thirdQuarter) {
		this.thirdQuarter = thirdQuarter;
	}
	public String getFourthQuarter() {
		return fourthQuarter;
	}
	public void setFourthQuarter(String fourthQuarter) {
		this.fourthQuarter = fourthQuarter;
	}
	public String getFinalScore() {
		return finalScore;
	}
	public void setFinalScore(String finalScore) {
		this.finalScore = finalScore;
	}
	public JclqRaceStatus getStatus() {
		return status;
	}
	public void setStatus(JclqRaceStatus status) {
		this.status = status;
	}
	public JclqStaticDrawStatus getStaticDrawStatus() {
		return staticDrawStatus;
	}
	public void setStaticDrawStatus(JclqStaticDrawStatus staticDrawStatus) {
		this.staticDrawStatus = staticDrawStatus;
	}
	public JclqDynamicDrawStatus getDynamicDrawStatus() {
		return dynamicDrawStatus;
	}
	public void setDynamicDrawStatus(JclqDynamicDrawStatus dynamicDrawStatus) {
		this.dynamicDrawStatus = dynamicDrawStatus;
	}
	public JclqStaticSaleStatus getStaticSaleSfStatus() {
		return staticSaleSfStatus;
	}
	public void setStaticSaleSfStatus(JclqStaticSaleStatus staticSaleSfStatus) {
		this.staticSaleSfStatus = staticSaleSfStatus;
	}
	public JclqDynamicSaleStatus getDynamicSaleSfStatus() {
		return dynamicSaleSfStatus;
	}
	public void setDynamicSaleSfStatus(JclqDynamicSaleStatus dynamicSaleSfStatus) {
		this.dynamicSaleSfStatus = dynamicSaleSfStatus;
	}
	public JclqStaticSaleStatus getStaticSaleRfsfStatus() {
		return staticSaleRfsfStatus;
	}
	public void setStaticSaleRfsfStatus(JclqStaticSaleStatus staticSaleRfsfStatus) {
		this.staticSaleRfsfStatus = staticSaleRfsfStatus;
	}
	public JclqDynamicSaleStatus getDynamicSaleRfsfStatus() {
		return dynamicSaleRfsfStatus;
	}
	public void setDynamicSaleRfsfStatus(JclqDynamicSaleStatus dynamicSaleRfsfStatus) {
		this.dynamicSaleRfsfStatus = dynamicSaleRfsfStatus;
	}
	public JclqStaticSaleStatus getStaticSaleSfcStatus() {
		return staticSaleSfcStatus;
	}
	public void setStaticSaleSfcStatus(JclqStaticSaleStatus staticSaleSfcStatus) {
		this.staticSaleSfcStatus = staticSaleSfcStatus;
	}
	public JclqDynamicSaleStatus getDynamicSaleSfcStatus() {
		return dynamicSaleSfcStatus;
	}
	public void setDynamicSaleSfcStatus(JclqDynamicSaleStatus dynamicSaleSfcStatus) {
		this.dynamicSaleSfcStatus = dynamicSaleSfcStatus;
	}
	public JclqStaticSaleStatus getStaticSaleDxfStatus() {
		return staticSaleDxfStatus;
	}
	public void setStaticSaleDxfStatus(JclqStaticSaleStatus staticSaleDxfStatus) {
		this.staticSaleDxfStatus = staticSaleDxfStatus;
	}
	public JclqDynamicSaleStatus getDynamicSaleDxfStatus() {
		return dynamicSaleDxfStatus;
	}
	public void setDynamicSaleDxfStatus(JclqDynamicSaleStatus dynamicSaleDxfStatus) {
		this.dynamicSaleDxfStatus = dynamicSaleDxfStatus;
	}
	public String getPrizeSf() {
		return prizeSf;
	}
	public void setPrizeSf(String prizeSf) {
		this.prizeSf = prizeSf;
	}
	public String getPrizeRfsf() {
		return prizeRfsf;
	}
	public void setPrizeRfsf(String prizeRfsf) {
		this.prizeRfsf = prizeRfsf;
	}
	public String getPrizeSfc() {
		return prizeSfc;
	}
	public void setPrizeSfc(String prizeSfc) {
		this.prizeSfc = prizeSfc;
	}
	public String getPrizeDxf() {
		return prizeDxf;
	}
	public void setPrizeDxf(String prizeDxf) {
		this.prizeDxf = prizeDxf;
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
	
	/**
	 * 获取对阵基本信息
	 * @return
	 */
	public String getJclqRaceInfo(){
		StringBuffer sb = new StringBuffer();
		sb.append("[").append(this.getMatchName()).append("]");
		sb.append("(客队)").append(this.getAwayTeam());
		sb.append(" vs ");
		sb.append("(主队)").append(this.getHomeTeam());
		sb.append(" at ");
		sb.append(CoreDateUtils.formatDateTime(getMatchDate()));
		return sb.toString();
	}
}
