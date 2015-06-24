package com.lehecai.core.lottery.fetcher.football;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.util.CoreDateUtils;

/**
 * 足球 赛程信息
 * @author leiming
 *
 */
public class FootballScheduleItem implements java.io.Serializable{
	private static final long serialVersionUID = 4855276479176764839L;

	private String phase; // 期号
	
	private int matchIndex; // 场次顺序
	private String league; // 联赛或赛事名称
	private Date matchTime; // 比赛时间
	
	private String homeTeam; // 主队
	private String awayTeam; // 客队
	
	
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public int getMatchIndex() {
		return matchIndex;
	}
	public void setMatchIndex(int matchIndex) {
		this.matchIndex = matchIndex;
	}
	public String getLeague() {
		return league;
	}
	public void setLeague(String league) {
		this.league = league;
	}
	public Date getMatchTime() {
		return matchTime;
	}
	public void setMatchTime(Date matchTime) {
		this.matchTime = matchTime;
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
	public String getLogInfo(){
		StringBuffer sb = new StringBuffer();
		sb.append("[足球赛程]第").append(phase).append("期");
		sb.append(",序号:").append(this.getMatchIndex());
		sb.append(",赛事:").append(this.getLeague());
		if(this.getMatchTime() != null && !"".equals(this.getMatchTime())){
			sb.append(",比赛赛时间:").append(CoreDateUtils.formatDateTime(this.getMatchTime()));
		}else{
			sb.append(",比赛赛时间:").append("");
		}
		sb.append(",主队:").append(this.getHomeTeam());
		sb.append(",客队:").append(this.getAwayTeam());
		return sb.toString();
	}
	
	public static JSONObject toJSON(FootballScheduleItem footballScheduleItem) {
		JSONObject object = new JSONObject();
		if(footballScheduleItem != null){
			object.put("phase", footballScheduleItem.getPhase()==null?"":footballScheduleItem.getPhase());
			object.put("matchIndex",footballScheduleItem.getMatchIndex());
			object.put("league", footballScheduleItem.getLeague()==null?"":footballScheduleItem.getLeague());
			object.put("matchTime", footballScheduleItem.getMatchTime()==null?"":CoreDateUtils.formatDateTime(footballScheduleItem.getMatchTime()));
			object.put("homeTeam", footballScheduleItem.getHomeTeam()==null?"":footballScheduleItem.getHomeTeam());
			object.put("awayTeam", footballScheduleItem.getAwayTeam()==null?"":footballScheduleItem.getAwayTeam());
		}
		return object;
	}
	public static JSONArray toJSONArray(List<FootballScheduleItem> footballScheduleItems){
		JSONArray ja = new JSONArray();
		JSONObject jsonObject = null;
		if(footballScheduleItems!=null&&footballScheduleItems.size()>0){
			for(FootballScheduleItem footballScheduleItem : footballScheduleItems){
				jsonObject = FootballScheduleItem.toJSON(footballScheduleItem);
				ja.add(jsonObject);
			}
		}
		return ja;
	}
	
}
