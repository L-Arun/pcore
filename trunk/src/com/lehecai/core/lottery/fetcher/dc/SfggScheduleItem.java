/**
 * 
 */
package com.lehecai.core.lottery.fetcher.dc;

import java.util.Date;

import com.lehecai.core.util.CoreDateUtils;

/**
 * @author qatang
 *
 */
public class SfggScheduleItem {
	
	private String phase;			//期号
	
	private int matchIndex;			//场次顺序
	private String league;			//联赛或赛事名称
	private Date matchTime;			//比赛时间
	
	private String homeTeam;		//主队
	private String awayTeam;		//客队
	private String handicap;		//让球
	private String matchDesc;       //比赛描述
	
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
	public String getHandicap() {
		return handicap;
	}
	public void setHandicap(String handicap) {
		this.handicap = handicap;
	}
	public String getMatchDesc() {
		return matchDesc;
	}
	public void setMatchDesc(String matchDesc) {
		this.matchDesc = matchDesc;
	}
	public String getSfggScheduleInfo(){
		StringBuffer sb = new StringBuffer();
		sb.append("[单场赛程]第").append(phase).append("期");
		sb.append(",序号:").append(this.getMatchIndex());
		sb.append(",赛事:").append(this.getLeague());
		sb.append(",开赛时间:").append(CoreDateUtils.formatDateTime(this.getMatchTime()));
		sb.append(",主队:").append(this.getHomeTeam());
		sb.append(",让球:").append(this.getHandicap());
		sb.append(",客队:").append(this.getAwayTeam());
		sb.append(",描述:").append(this.getMatchDesc());
		return sb.toString();
	}
}
