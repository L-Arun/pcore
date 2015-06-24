/**
 * 
 */
package com.lehecai.core.lottery.fetcher.dc;



/**
 * @author qatang
 *
 */
public class SfggLotteryDrawItem {
	
	private String phase;			//期号
	
	private int matchIndex;			//场次顺序
	private String league;			//联赛或赛事名称
	
	private String homeTeam;		//主队
	private String awayTeam;		//客队
	
	private String matchDesc;       //比赛描述
	
	private String fullTimeResult;	//全场比分
	
	private String spSF;			//单场胜负平的SP值
	
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
	
	public String getFullTimeResult() {
		return fullTimeResult;
	}
	public void setFullTimeResult(String fullTimeResult) {
		this.fullTimeResult = fullTimeResult;
	}
	
	public String getSpSF() {
		return spSF;
	}
	public void setSpSF(String spSF) {
		this.spSF = spSF;
	}
	public String getMatchDesc() {
		return matchDesc;
	}
	public void setMatchDesc(String matchDesc) {
		this.matchDesc = matchDesc;
	}
	public String getLogInfo(){
		StringBuffer sb = new StringBuffer();
		sb.append("[单场开奖结果]第").append(phase).append("期");
		sb.append(",序号:").append(this.getMatchIndex());
		sb.append(",赛事:").append(this.getLeague());
		sb.append(",主队:").append(this.getHomeTeam());
		sb.append(",客队:").append(this.getAwayTeam());
		sb.append(",描述:").append(this.getMatchDesc());
		sb.append(",全场比分:").append(this.getFullTimeResult());
		
		sb.append(",胜负的SP值:").append(this.getSpSF());
		return sb.toString();
	}
}
