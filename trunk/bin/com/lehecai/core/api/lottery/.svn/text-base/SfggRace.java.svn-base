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
/**
 * 奥运胜负过关
 * @author qatang
 *
 */
public class SfggRace extends AbstractApiResultBean implements Serializable{
	
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
	public static final String SET_MATCH_DESC = "match_desc";
	public static final String SET_HANDICAP = "handicap";
	public static final String SET_FINAL_SCORE = "final_score";
	public static final String SET_STATUS = "status";
	public static final String SET_EXT = "ext";
	public static final String SET_SP_SF = "sp_sf";
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
	private String matchDesc;           //比赛描述
	private String handicap;        	//让球
	private String finalScore;        	//全场比分
	private String matchName;           //赛事
	private DcRaceStatus status;		//状态
	private String ext;               	//扩展信息
	private String spSf;				//胜负sp值
	private int priority;				//优先级
	private int catchId;				//数据抓取id，目前的值等同fx_id
	private int fxId;					//分析id(soccer的vid)
	
	public static SfggRace convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		SfggRace dcRace = new SfggRace();
		
		dcRace.setId(getString(object, "id"));
		dcRace.setPhase(getString(object, "phase"));
		dcRace.setCreateAt(getDate(object, "create_at", CoreDateUtils.DATETIME));
		dcRace.setMatchNum(getInt(object, "match_num"));
		dcRace.setMatchDate(getDate(object, "match_date", CoreDateUtils.DATETIME));
		dcRace.setEndSaleTime(getDate(object, "time_endsale", CoreDateUtils.DATETIME));
		dcRace.setHomeTeam(getString(object, "home_team"));
		dcRace.setAwayTeam(getString(object, "away_team"));
		dcRace.setMatchDesc(getString(object, "match_desc"));
		dcRace.setHandicap(getString(object, "handicap"));
		dcRace.setFinalScore(getString(object, "final_score"));
		dcRace.setMatchName(getString(object, "match_name"));
		dcRace.setStatus(DcRaceStatus.getItem(getInt(object, "status")));
		dcRace.setExt(getString(object, "ext"));
		dcRace.setSpSf(getString(object, "sp_sf"));
		dcRace.setPriority(getInt(object, "priority"));
		dcRace.setCatchId(getInt(object, "catch_id"));
		dcRace.setFxId(getInt(object, "fx_id"));
		
		return dcRace;
	}
	@SuppressWarnings("unchecked")
	public static List<SfggRace> convertFromJSONArray(JSONArray array) {
		logger.info(array.toString());
		if (array == null) {
			return null;
		}
		List<SfggRace> list = new ArrayList<SfggRace>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}
	
	public static JSONObject toJSON(SfggRace dcRace) {
		JSONObject object = JSONObject.fromObject(dcRace);
		return object;
	}
	
	public static JSONArray toJSONArray(List<SfggRace> dcRaces) {
		JSONArray ja = new JSONArray();
		JSONObject jsonObject = null;
		if(dcRaces != null && dcRaces.size() > 0){
			for(SfggRace dcRace:dcRaces){
				jsonObject = SfggRace.toJSON(dcRace);
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
	public String getFinalScore() {
		return finalScore;
	}
	public void setFinalScore(String finalScore) {
		this.finalScore = finalScore;
	}
	public String getSpSf() {
		return spSf;
	}
	public void setSpSf(String spSf) {
		this.spSf = spSf;
	}
	public String getMatchDesc() {
		return matchDesc;
	}
	public void setMatchDesc(String matchDesc) {
		this.matchDesc = matchDesc;
	}

}
