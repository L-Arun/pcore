/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jczq;

import java.util.Date;

import com.lehecai.core.util.CoreDateUtils;


/**
 * @author qatang
 *
 */
public class JczqSpItem {
	
	private String matchNum;        //赛事编码
	private String officialNum;    //官方编码
	private Date officialDate;      //官方公布比赛场次的日期
	private Date matchDate;		    //比赛日期
	private String matchName;		//联赛或赛事名称
	private String homeTeam;		//主队
	private String awayTeam;		//客队
	private String prizeSpf;	    //胜平负奖金,浮动奖金投注的开奖奖金
	private String prizeBf;		    //全场比分奖金,浮动奖金投注的开奖奖金
	private String prizeJqs;		//进球总数奖金,浮动奖金投注的开奖奖金
	private String prizeBqc;		//半全场胜平负奖金,浮动奖金投注的开奖奖金
	private String firstHalf;       //上半场比分
	private String secondHalf;      //下半场比分
	private String finalScore;      //最终比分

	public String getJczqScheduleInfo(){
		StringBuffer sb = new StringBuffer();
		sb.append("[竞彩足球赛程]");
		sb.append(",赛事编码:").append(this.getMatchNum());
		sb.append(",官方编码:").append(this.getOfficialNum());
		sb.append(",官方公布比赛场次的日期:").append(CoreDateUtils.formatDate(this.getOfficialDate()));
		sb.append(",比赛日期:").append(CoreDateUtils.formatDate(this.getMatchDate()));
		sb.append(",赛事:").append(this.getMatchName());
		sb.append(",主队:").append(this.getHomeTeam());
		sb.append(",客队:").append(this.getAwayTeam());
		sb.append(",浮动奖金胜平负奖金:").append(this.getPrizeSpf());
		sb.append(",浮动奖金全场比分奖金:").append(this.getPrizeBf());
		sb.append(",浮动奖金进球总数奖金:").append(this.getPrizeJqs());
		sb.append(",浮动奖金半全场胜平负奖金:").append(this.getPrizeBqc());
		sb.append(",上半场:").append(this.getFirstHalf());
		sb.append(",下半场:").append(this.getSecondHalf());
		sb.append(",最终比分:").append(this.getFinalScore());
		return sb.toString();
	}

	public String getMatchNum() {
		return matchNum;
	}

	public void setMatchNum(String matchNum) {
		this.matchNum = matchNum;
	}

	public String getOfficialNum() {
		return officialNum;
	}

	public void setOfficialNum(String officialNum) {
		this.officialNum = officialNum;
	}

	public Date getOfficialDate() {
		return officialDate;
	}

	public void setOfficialDate(Date officialDate) {
		this.officialDate = officialDate;
	}

	public Date getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
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

	public String getPrizeSpf() {
		return prizeSpf;
	}

	public void setPrizeSpf(String prizeSpf) {
		this.prizeSpf = prizeSpf;
	}

	public String getPrizeBf() {
		return prizeBf;
	}

	public void setPrizeBf(String prizeBf) {
		this.prizeBf = prizeBf;
	}

	public String getPrizeJqs() {
		return prizeJqs;
	}

	public void setPrizeJqs(String prizeJqs) {
		this.prizeJqs = prizeJqs;
	}

	public String getPrizeBqc() {
		return prizeBqc;
	}

	public void setPrizeBqc(String prizeBqc) {
		this.prizeBqc = prizeBqc;
	}

	public String getFirstHalf() {
		return firstHalf;
	}

	public void setFirstHalf(String firstHalf) {
		this.firstHalf = firstHalf;
	}

	public String getSecondHalf() {
		return secondHalf;
	}

	public void setSecondHalf(String secondHalf) {
		this.secondHalf = secondHalf;
	}

	public String getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(String finalScore) {
		this.finalScore = finalScore;
	}
}
