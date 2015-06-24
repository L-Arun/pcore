package com.lehecai.core.api.lottery;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.PhaseType;
import com.lehecai.core.util.CoreDateUtils;

public class Fb46Match extends AbstractApiResultBean {
	
	public static final String QUERY_PHASE = "phase";
	public static final String QUERY_TYPE = "lottery_type";
	
	public static final String SET_ID = "id";
	public static final String SET_PHASE = "phase";
	public static final String SET_MATCH_NUM = "match_num";
	public static final String SET_MATCH_ID = "match_id";
	public static final String SET_MATCH_DATE = "match_date";
	public static final String SET_TYPE = "lottery_type";
	public static final String SET_HOME_TEAM = "home_team";
	public static final String SET_GUEST_TEAM = "away_team";
	public static final String SET_MATCH = "match_name";
	public static final String SET_FINAL_SCORE = "final_score";
	public static final String SET_HALF_SCORE = "half_score";
	public static final String SET_AVERAGE_INDEX = "average_index";
	public static final String SET_EXT = "ext";
	
	
	public static final String ORDER_ID = "id";
	public static final String ORDER_MATCH_NUM = "match_num";
	public static final String ORDER_PHASE = "phase";
	public static final String ORDER_CREATE_AT = "create_at";
	public static final String ORDER_MATCH_DATE = "match_date";
	public static final String ORDER_TYPE = "lottery_type";

	private String id;               	//流水号
	private String phase;             	//彩期号
	private Date createAt;        		//创建时间
	private int matchNum;         		//场次
	private int matchId;          		//对阵id(与联赛库对应,暂不使用)
	private Date matchDate;        		//比赛日期
	private PhaseType type;				//彩期类型
	private String homeTeam;        	//主队
	private String guestTeam;        	//客队
	private String match;             	//赛事
	private String finalScore;        	//全场比分
	private String halfScore;  			//半场比分
	private String averageIndex;     	//平均欧指
	private String ext;               	//扩展信息

	public static Fb46Match convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		Fb46Match fb46Match = new Fb46Match();
		
		fb46Match.setId(getString(object, "id"));
		fb46Match.setPhase(getString(object, "phase"));
		fb46Match.setCreateAt(CoreDateUtils.parseDate(getString(object, "create_at"), CoreDateUtils.DATETIME));
		fb46Match.setMatchNum(getInt(object, "match_num"));
		fb46Match.setMatchId(getInt(object, "match_id"));
		fb46Match.setMatchDate(CoreDateUtils.parseDate(getString(object, "match_date"), CoreDateUtils.DATETIME));
		fb46Match.setType(PhaseType.getItem(getInt(object, "lottery_type")));
		fb46Match.setHomeTeam(getString(object, "home_team"));
		fb46Match.setGuestTeam(getString(object, "away_team"));
		fb46Match.setMatch(getString(object, "match_name"));
		fb46Match.setFinalScore(getString(object, "final_score"));
		fb46Match.setHalfScore(getString(object, "half_score"));
		fb46Match.setAverageIndex(getString(object, "average_index"));
		fb46Match.setExt(getString(object, "ext"));
		
		return fb46Match;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Fb46Match> convertFromJSONArray(JSONArray array) {
		logger.info(array.toString());
		if (array == null) {
			return null;
		}
		List<Fb46Match> list = new ArrayList<Fb46Match>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}
	
	public static JSONObject toJSON(Fb46Match fb46Match) {
		JSONObject object = JSONObject.fromObject(fb46Match);
		return object;
	}
	
	public static JSONArray toJSONArray(List<Fb46Match> fb46Matchs) {
		JSONArray ja = new JSONArray();
		JSONObject jsonObject = null;
		if(fb46Matchs != null && fb46Matchs.size() > 0){
			for(Fb46Match fb46Match:fb46Matchs){
				jsonObject = Fb46Match.toJSON(fb46Match);
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

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
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

	public String getGuestTeam() {
		return guestTeam;
	}

	public void setGuestTeam(String guestTeam) {
		this.guestTeam = guestTeam;
	}

	public String getMatch() {
		return match;
	}

	public void setMatch(String match) {
		this.match = match;
	}

	public String getAverageIndex() {
		return averageIndex;
	}

	public void setAverageIndex(String averageIndex) {
		this.averageIndex = averageIndex;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public PhaseType getType() {
		return type;
	}

	public void setType(PhaseType type) {
		this.type = type;
	}

	public String getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(String finalScore) {
		this.finalScore = finalScore;
	}

	public String getHalfScore() {
		return halfScore;
	}

	public void setHalfScore(String halfScore) {
		this.halfScore = halfScore;
	}

}
