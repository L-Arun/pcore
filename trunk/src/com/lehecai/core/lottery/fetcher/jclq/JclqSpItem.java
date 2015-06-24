/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jclq;

import java.util.Date;

import com.lehecai.core.util.CoreDateUtils;


/**
 * @author qatang
 *
 */
public class JclqSpItem {
	
	private String matchNum;        //赛事编码
	private Integer officialNum;    //官方编码
	private Date officialDate;      //官方公布比赛场次的日期
	private Date matchDate;		    //比赛日期
	private String matchName;		//联赛或赛事名称
	private String homeTeam;		//主队
	private String awayTeam;		//客队
	private String prizeSf;			//胜负奖金,浮动奖金投注的开奖奖金
	private String prizeRfsf;		//让分胜负奖金,浮动奖金投注的开奖奖金
	private String prizeSfc;		//胜分差奖金,浮动奖金投注的开奖奖金
	private String prizeDxf;		//大小分奖金,浮动奖金投注的开奖奖金
	private String firstQuarter;    //第一节
	private String secondQuarter;   //第二节
	private String thirdQuarter;    //第三节
	private String fourthQuarter;   //第四节
	private String finalScore;      //最终比分
	
	public String getJclqScheduleInfo(){
		StringBuffer sb = new StringBuffer();
		sb.append("[竞彩篮球赛程]");
		sb.append(",赛事编码:").append(this.getMatchNum());
		sb.append(",官方编码:").append(this.getOfficialNum());
		sb.append(",官方公布比赛场次的日期:").append(CoreDateUtils.formatDate(this.getOfficialDate()));
		sb.append(",比赛日期:").append(CoreDateUtils.formatDate(this.getMatchDate()));
		sb.append(",赛事:").append(this.getMatchName());
		sb.append(",主队:").append(this.getHomeTeam());
		sb.append(",客队:").append(this.getAwayTeam());
		sb.append(",浮动奖金胜负奖金:").append(this.getPrizeSf());
		sb.append(",浮动奖金让分胜负奖金:").append(this.getPrizeRfsf());
		sb.append(",浮动奖金胜分差奖金:").append(this.getPrizeSfc());
		sb.append(",浮动奖金大小分奖金:").append(this.getPrizeDxf());
		sb.append(",第一节:").append(this.getFirstQuarter());
		sb.append(",第二节:").append(this.getSecondQuarter());
		sb.append(",第三节:").append(this.getThirdQuarter());
		sb.append(",第四节:").append(this.getFourthQuarter());
		sb.append(",最终比分:").append(this.getFinalScore());
		return sb.toString();
	}

	public String getMatchNum() {
		return matchNum;
	}

	public void setMatchNum(String matchNum) {
		this.matchNum = matchNum;
	}

	public Integer getOfficialNum() {
		return officialNum;
	}

	public void setOfficialNum(Integer officialNum) {
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

	public String getPrizeSf() {
		return prizeSf;
	}

	public void setPrizeSf(String prizeSf) {
		this.prizeSf = prizeSf;
	}

	public String getPrizeRfsf() {
		return prizeRfsf;
	}

	public void setPrizeRfsf(String prizeRfsf) {
		this.prizeRfsf = prizeRfsf;
	}

	public String getPrizeSfc() {
		return prizeSfc;
	}

	public void setPrizeSfc(String prizeSfc) {
		this.prizeSfc = prizeSfc;
	}

	public String getPrizeDxf() {
		return prizeDxf;
	}

	public void setPrizeDxf(String prizeDxf) {
		this.prizeDxf = prizeDxf;
	}

	public String getFirstQuarter() {
		return firstQuarter;
	}

	public void setFirstQuarter(String firstQuarter) {
		this.firstQuarter = firstQuarter;
	}

	public String getSecondQuarter() {
		return secondQuarter;
	}

	public void setSecondQuarter(String secondQuarter) {
		this.secondQuarter = secondQuarter;
	}

	public String getThirdQuarter() {
		return thirdQuarter;
	}

	public void setThirdQuarter(String thirdQuarter) {
		this.thirdQuarter = thirdQuarter;
	}

	public String getFourthQuarter() {
		return fourthQuarter;
	}

	public void setFourthQuarter(String fourthQuarter) {
		this.fourthQuarter = fourthQuarter;
	}

	public String getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(String finalScore) {
		this.finalScore = finalScore;
	}
}
