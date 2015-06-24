/**
 * 
 */
package com.lehecai.core.api.event;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;

/**
 * 欧洲杯比赛信息
 * @author chirowong
 *
 */
public class EuroCupMatch extends AbstractApiResultBean {
	public static final String QUERY_MATCH_NUM = "match_num";
	
	public static final String SET_MATCH_NUM = "match_name";
	public static final String SET_MATCH_DATE = "match_date";
	public static final String SET_ROUND = "round";
	public static final String SET_HOME_TEAM = "home_team";
	public static final String SET_HOME_TEAM_ID = "home_team_id";
	public static final String SET_AWAY_TEAM = "away_team";
	public static final String SET_AWAY_TEAM_ID = "away_team_id";
	public static final String SET_HANDICAP = "handicap";
	public static final String SET_FINAL_SCORE = "final_score";
	public static final String SET_STATUS = "status";
	public static final String SET_SP_SPF = "sp_spf";
	public static final String SET_SP_BF = "sp_bf";
	public static final String SET_DC_PHASE = "dc_phase";
	public static final String SET_DC_MATCH_NUM = "dc_match_num";
	public static final String SET_ADMIN_ID = "admin_id";
	public static final String SET_VIDEO_URL = "video_url";
	public static final String SET_TEXT_URL = "text_url";
	public static final String SET_FX_ID = "fx_id";
	public static final String SET_CHATROOM_STATUS = "chatroom_status";
	public static final String SET_JC_MATCH_NUM = "jc_match_num";
	public static final String SET_JC_HANDICAP = "jc_handicap";
	public static final String SET_JC_FX_ID = "jc_fx_id";
	
	private Integer matchNum;//赛程ID
	private String matchName;//赛程名称
	private String matchDate;//比赛时间
	private Integer round;//比赛轮次【1,第一轮小组赛；2，第二轮小组赛；3，第三轮小组赛；4，决赛阶段】
	private String homeTeam;//主队名
	private Integer homeTeamId;//主队编码
	private String awayTeam;//客队名
	private Integer awayTeamId;//客队编码
	private Integer handicap;//让球数
	private String finalScore;//比分
	private Integer status;//销售状态 【0，关闭；1，开启】
	private String spSpf;//胜负平SP值
	private String spBf;//比分SP值
	private String dcPhase;//北京单场彩期
	private String dcMatchNum;//北京单场场次
	private Long userId;
	private String videoUrl;//视频直播地址
	private String textUrl;//文字直播地址
	private Integer fxId;//分析编码
	private Integer chatroomStatus;//聊天室状态【0，关闭；1，开启】
	private String jcMatchNum;//竞彩场次
	private String jcHandicap;//竞彩让球
	private Integer jcFxId;//竞彩分析编码
	
	public static EuroCupMatch convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		EuroCupMatch euroCupMatch = new EuroCupMatch();
		euroCupMatch.setMatchNum(getInt(object, "match_num"));
		euroCupMatch.setMatchName(getString(object, "match_name"));
		euroCupMatch.setMatchDate(getString(object, "match_date"));
		euroCupMatch.setRound(getInt(object, "round"));
		euroCupMatch.setHomeTeam(getString(object,"home_team"));
		euroCupMatch.setHomeTeamId(getInt(object,"home_team_id"));
		euroCupMatch.setAwayTeam(getString(object, "away_team"));
		euroCupMatch.setAwayTeamId(getInt(object,"away_team_id"));
		euroCupMatch.setHandicap(getInt(object,"handicap"));
		euroCupMatch.setFinalScore(getString(object, "final_score"));
		euroCupMatch.setStatus(getInt(object,"status"));
		euroCupMatch.setSpSpf(getString(object,"sp_spf"));
		euroCupMatch.setSpBf(getString(object,"sp_bf"));
		euroCupMatch.setDcPhase(getString(object,"dc_phase"));
		euroCupMatch.setDcMatchNum(getString(object,"dc_match_num"));
		euroCupMatch.setVideoUrl(getString(object,"video_url"));
		euroCupMatch.setTextUrl(getString(object,"text_url"));
		euroCupMatch.setFxId(getInt(object,"fx_id"));
		euroCupMatch.setChatroomStatus(getInt(object,"chatroom_status"));
		euroCupMatch.setJcMatchNum(getString(object,"jc_match_num"));
		euroCupMatch.setJcHandicap(getString(object,"jc_handicap"));
		euroCupMatch.setJcFxId(getInt(object,"jc_fx_id"));
		return euroCupMatch;
	}
	
	public static List<EuroCupMatch> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<EuroCupMatch> list = new ArrayList<EuroCupMatch>();
		for (Iterator<?> iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public Integer getMatchNum() {
		return matchNum;
	}

	public void setMatchNum(Integer matchNum) {
		this.matchNum = matchNum;
	}

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	public String getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public Integer getRound() {
		return round;
	}

	public void setRound(Integer round) {
		this.round = round;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Integer getHomeTeamId() {
		return homeTeamId;
	}

	public void setHomeTeamId(Integer homeTeamId) {
		this.homeTeamId = homeTeamId;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public Integer getAwayTeamId() {
		return awayTeamId;
	}

	public void setAwayTeamId(Integer awayTeamId) {
		this.awayTeamId = awayTeamId;
	}

	public Integer getHandicap() {
		return handicap;
	}

	public void setHandicap(Integer handicap) {
		this.handicap = handicap;
	}

	public String getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(String finalScore) {
		this.finalScore = finalScore;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getSpSpf() {
		return spSpf;
	}

	public void setSpSpf(String spSpf) {
		this.spSpf = spSpf;
	}

	public String getSpBf() {
		return spBf;
	}

	public void setSpBf(String spBf) {
		this.spBf = spBf;
	}

	public String getDcPhase() {
		return dcPhase;
	}

	public void setDcPhase(String dcPhase) {
		this.dcPhase = dcPhase;
	}

	public String getDcMatchNum() {
		return dcMatchNum;
	}

	public void setDcMatchNum(String dcMatchNum) {
		this.dcMatchNum = dcMatchNum;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getTextUrl() {
		return textUrl;
	}

	public void setTextUrl(String textUrl) {
		this.textUrl = textUrl;
	}

	public Integer getFxId() {
		return fxId;
	}

	public void setFxId(Integer fxId) {
		this.fxId = fxId;
	}

	public Integer getChatroomStatus() {
		return chatroomStatus;
	}

	public void setChatroomStatus(Integer chatroomStatus) {
		this.chatroomStatus = chatroomStatus;
	}

	public String getJcMatchNum() {
		return jcMatchNum;
	}

	public void setJcMatchNum(String jcMatchNum) {
		this.jcMatchNum = jcMatchNum;
	}

	public String getJcHandicap() {
		return jcHandicap;
	}

	public void setJcHandicap(String jcHandicap) {
		this.jcHandicap = jcHandicap;
	}

	public Integer getJcFxId() {
		return jcFxId;
	}

	public void setJcFxId(Integer jcFxId) {
		this.jcFxId = jcFxId;
	}
}
