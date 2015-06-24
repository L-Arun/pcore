/**
 * 
 */
package com.lehecai.core.lottery.fetcher.dc;



/**
 * @author Sunshow
 *
 */
public class DcLotteryDrawItem {
	
	private String phase;			//期号
	
	private int matchIndex;			//场次顺序
	private String league;			//联赛或赛事名称
	
	private String homeTeam;		//主队
	private String awayTeam;		//客队
	
	private String halfTimeResult;	//半场比分
	private String fullTimeResult;	//全场比分
	
	private String spSFP;			//单场胜负平的SP值
	private String spSXDS;			//单场上下单双的SP值
	private String spJQS;			//单场进球数的SP值
	private String spBF;			//单场比分的SP值
	private String spBCSFP;			//单场半场胜负平的SP值
	
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
	public String getHalfTimeResult() {
		return halfTimeResult;
	}
	public void setHalfTimeResult(String halfTimeResult) {
		this.halfTimeResult = halfTimeResult;
	}
	public String getFullTimeResult() {
		return fullTimeResult;
	}
	public void setFullTimeResult(String fullTimeResult) {
		this.fullTimeResult = fullTimeResult;
	}
	public String getSpSFP() {
		return spSFP;
	}
	public void setSpSFP(String spSFP) {
		this.spSFP = spSFP;
	}
	public String getSpSXDS() {
		return spSXDS;
	}
	public void setSpSXDS(String spSXDS) {
		this.spSXDS = spSXDS;
	}
	public String getSpJQS() {
		return spJQS;
	}
	public void setSpJQS(String spJQS) {
		this.spJQS = spJQS;
	}
	public String getSpBF() {
		return spBF;
	}
	public void setSpBF(String spBF) {
		this.spBF = spBF;
	}
	public String getSpBCSFP() {
		return spBCSFP;
	}
	public void setSpBCSFP(String spBCSFP) {
		this.spBCSFP = spBCSFP;
	}
	public String getLogInfo(){
		StringBuffer sb = new StringBuffer();
		sb.append("[单场开奖结果]第").append(phase).append("期");
		sb.append(",序号:").append(this.getMatchIndex());
		sb.append(",赛事:").append(this.getLeague());
		sb.append(",主队:").append(this.getHomeTeam());
		sb.append(",客队:").append(this.getAwayTeam());
		sb.append(",半场比分:").append(this.getHalfTimeResult());
		sb.append(",全场比分:").append(this.getFullTimeResult());
		
		sb.append(",单场胜负平的SP值:").append(this.getSpSFP());
		sb.append(",单场上下单双的SP值:").append(this.getSpSXDS());
		sb.append(",单场进球数的SP值:").append(this.getSpJQS());
		sb.append(",单场比分的SP值:").append(this.getSpBF());
		sb.append(",单场半场胜负平的SP值:").append(this.getSpBCSFP());
		return sb.toString();
	}
}
