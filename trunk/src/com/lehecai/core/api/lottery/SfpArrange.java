package com.lehecai.core.api.lottery;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.util.CoreDateUtils;

public class SfpArrange extends AbstractApiResultBean {
	
	public static final String QUERY_PHASE = "phase";
	
	public static final String SET_ID = "id";
	public static final String SET_PHASE = "phase";
	public static final String SET_MATCH_NUM = "match_num";
	public static final String SET_MATCH_ID = "match_id";
	public static final String SET_MATCH_DATE = "match_date";
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

	private String id;               	//流水号
	private String phase;             	//彩期号
	private Date createAt;        		//创建时间
	private int matchNum;         		//场次
	private int matchId;          		//对阵id(与联赛库对应,暂不使用)
	private Date matchDate;        		//比赛日期
	private String homeTeam;        	//主队
	private String guestTeam;        	//客队
	private String match;             	//赛事
	private String finalScore;        	//全场比分
	private String halfScore;  			//半场比分
	private String averageIndex;     	//平均欧指
	private String ext;               	//扩展信息

	public static SfpArrange convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		SfpArrange sfpArrange = new SfpArrange();
		
		sfpArrange.setId(getString(object, "id"));
		sfpArrange.setPhase(getString(object, "phase"));
		sfpArrange.setCreateAt(CoreDateUtils.parseDate(getString(object, "create_at"), CoreDateUtils.DATETIME));
		sfpArrange.setMatchNum(getInt(object, "match_num"));
		sfpArrange.setMatchId(getInt(object, "match_id"));
		sfpArrange.setMatchDate(CoreDateUtils.parseDate(getString(object, "match_date"), CoreDateUtils.DATETIME));
		sfpArrange.setHomeTeam(getString(object, "home_team"));
		sfpArrange.setGuestTeam(getString(object, "away_team"));
		sfpArrange.setMatch(getString(object, "match_name"));
		sfpArrange.setFinalScore(getString(object, "final_score"));
		sfpArrange.setHalfScore(getString(object, "half_score"));
		sfpArrange.setAverageIndex(getString(object, "average_index"));
		sfpArrange.setExt(getString(object, "ext"));
		
		return sfpArrange;
	}
	
	@SuppressWarnings("unchecked")
	public static List<SfpArrange> convertFromJSONArray(JSONArray array) {
		logger.info(array.toString());
		if (array == null) {
			return null;
		}
		List<SfpArrange> list = new ArrayList<SfpArrange>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}
	
	public static JSONObject toJSON(SfpArrange sfpArrange) {
		JSONObject object = JSONObject.fromObject(sfpArrange);
		return object;
	}
	
	public static JSONArray toJSONArray(List<SfpArrange> sfpArranges) {
		JSONArray ja = new JSONArray();
		JSONObject jsonObject = null;
		if(sfpArranges != null && sfpArranges.size() > 0){
			for(SfpArrange sfpArrange:sfpArranges){
				jsonObject = SfpArrange.toJSON(sfpArrange);
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
