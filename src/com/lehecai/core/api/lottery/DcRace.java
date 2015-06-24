package com.lehecai.core.api.lottery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.DcRaceStatus;
import com.lehecai.core.util.CoreDateUtils;

public class DcRace extends AbstractApiResultBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public static final String QUERY_PHASE = "phase";
	public static final String QUERY_MATCH_NUM = "match_num";
	public static final String QUERY_MATCH_DATE = "match_date";
	public static final String QUERY_STATUS = "status";
	public static final String QUERY_ID = "id";
	
	public static final String SET_ID = "id";
	public static final String SET_PHASE = "phase";
	public static final String SET_MATCH_NUM = "match_num";
	public static final String SET_MATCH_NAME = "match_name"; 
	public static final String SET_MATCH_DATE = "match_date";
	public static final String SET_END_SALE_DATE = "time_endsale";
	public static final String SET_HOME_TEAM = "home_team";
	public static final String SET_AWAY_TEAM = "away_team";
	public static final String SET_HANDICAP = "handicap";
	public static final String SET_WHOLE_SCORE = "final_score";
	public static final String SET_HALF_SCORE = "half_score";
	public static final String SET_STATUS = "status";
	public static final String SET_EXT = "ext";
	public static final String SET_SP_SFP = "sp_sfp";
	public static final String SET_SP_SXDS = "sp_sxds";
	public static final String SET_SP_JQS = "sp_jqs";
	public static final String SET_SP_BF = "sp_bf";
	public static final String SET_SP_BCSFP = "sp_bcsfp";
	public static final String SET_PRIORITY = "priority";
	public static final String SET_CATCH_ID = "catch_id";
	public static final String SET_FX_ID = "fx_id";
	
	public static final String ORDER_ID = "id";
	public static final String ORDER_PHASE = "phase";
	public static final String ORDER_CREATE_AT = "create_at";
	public static final String ORDER_MATCH_DATE = "match_date";
	public static final String ORDER_MATCH_NUM = "match_num";

	private String id;               	//流水号
	private String phase;             	//彩期号
	private Date createAt;        		//创建时间
	private int matchNum;         		//场次
	private Date endSaleTime;        	//停止销售时间
	private Date matchDate;        		//比赛日期
	private String homeTeam;        	//主队
	private String awayTeam;        	//客队
	private String handicap;        	//让球
	private String wholeScore;        	//全场比分
	private String halfScore;           //半场比分
	private String matchName;           //赛事
	private DcRaceStatus status;		//状态
	private String ext;               	//扩展信息
	private String spSfp;				//胜负平sp值
	private String spSxds;				//上下单双sp值
	private String spJqs;				//进球数sp值
	private String spBf;				//单场比分sp值
	private String spBcsfp;				//半场胜负平sp值
	private int priority;				//优先级
	private int catchId;				//数据抓取id，目前的值等同fx_id
	private int fxId;					//分析id(soccer的vid)
	
	public static DcRace convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		DcRace dcRace = new DcRace();
		
		dcRace.setId(getString(object, "id"));
		dcRace.setPhase(getString(object, "phase"));
		dcRace.setCreateAt(getDate(object, "create_at", CoreDateUtils.DATETIME));
		dcRace.setMatchNum(getInt(object, "match_num"));
		dcRace.setMatchDate(getDate(object, "match_date", CoreDateUtils.DATETIME));
		dcRace.setEndSaleTime(getDate(object, "time_endsale", CoreDateUtils.DATETIME));
		dcRace.setHomeTeam(getString(object, "home_team"));
		dcRace.setAwayTeam(getString(object, "away_team"));
		dcRace.setHandicap(getString(object, "handicap"));
		dcRace.setWholeScore(getString(object, "final_score"));
		dcRace.setHalfScore(getString(object, "half_score"));
		dcRace.setMatchName(getString(object, "match_name"));
		dcRace.setStatus(DcRaceStatus.getItem(getInt(object, "status")));
		dcRace.setExt(getString(object, "ext"));
		dcRace.setSpSfp(getString(object, "sp_sfp"));
		dcRace.setSpSxds(getString(object, "sp_sxds"));
		dcRace.setSpJqs(getString(object, "sp_jqs"));
		dcRace.setSpBf(getString(object, "sp_bf"));
		dcRace.setSpBcsfp(getString(object, "sp_bcsfp"));
		dcRace.setPriority(getInt(object, "priority"));
		dcRace.setCatchId(getInt(object, "catch_id"));
		dcRace.setFxId(getInt(object, "fx_id"));
		
		return dcRace;
	}
	@SuppressWarnings("unchecked")
	public static List<DcRace> convertFromJSONArray(JSONArray array) {
		logger.info(array.toString());
		if (array == null) {
			return null;
		}
		List<DcRace> list = new ArrayList<DcRace>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}
	
	public static JSONObject toJSON(DcRace dcRace) {
		JSONObject object = JSONObject.fromObject(dcRace);
		return object;
	}
	
	public static JSONArray toJSONArray(List<DcRace> dcRaces) {
		JSONArray ja = new JSONArray();
		JSONObject jsonObject = null;
		if(dcRaces != null && dcRaces.size() > 0){
			for(DcRace dcRace:dcRaces){
				jsonObject = DcRace.toJSON(dcRace);
				ja.add(jsonObject);
			}
		}
		return ja;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public int getMatchNum() {
		return matchNum;
	}

	public void setMatchNum(int matchNum) {
		this.matchNum = matchNum;
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

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	public DcRaceStatus getStatus() {
		return status;
	}

	public void setStatus(DcRaceStatus status) {
		this.status = status;
	}
	
	public void setStatus(int status) {
		this.status = DcRaceStatus.getItem(status);
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getSpSfp() {
		return spSfp;
	}

	public void setSpSfp(String spSfp) {
		this.spSfp = spSfp;
	}

	public String getSpSxds() {
		return spSxds;
	}

	public void setSpSxds(String spSxds) {
		this.spSxds = spSxds;
	}

	public String getSpJqs() {
		return spJqs;
	}

	public void setSpJqs(String spJqs) {
		this.spJqs = spJqs;
	}

	public String getSpBf() {
		return spBf;
	}

	public void setSpBf(String spBf) {
		this.spBf = spBf;
	}

	public String getSpBcsfp() {
		return spBcsfp;
	}

	public void setSpBcsfp(String spBcsfp) {
		this.spBcsfp = spBcsfp;
	}

	public int getCatchId() {
		return catchId;
	}

	public void setCatchId(int catchId) {
		this.catchId = catchId;
	}

	public int getFxId() {
		return fxId;
	}

	public void setFxId(int fxId) {
		this.fxId = fxId;
	}

	public String getHandicap() {
		return handicap;
	}

	public void setHandicap(String handicap) {
		this.handicap = handicap;
	}

	public String getWholeScore() {
		return wholeScore;
	}

	public void setWholeScore(String wholeScore) {
		this.wholeScore = wholeScore;
	}

	public String getHalfScore() {
		return halfScore;
	}

	public void setHalfScore(String halfScore) {
		this.halfScore = halfScore;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Date getEndSaleTime() {
		return endSaleTime;
	}
	public void setEndSaleTime(Date endSaleTime) {
		this.endSaleTime = endSaleTime;
	}

}
