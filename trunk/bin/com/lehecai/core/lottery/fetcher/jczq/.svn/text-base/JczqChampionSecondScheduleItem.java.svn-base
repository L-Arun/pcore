/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jczq;

import com.lehecai.core.lottery.JczqRaceStatus;

/**
 * @author qatang
 *
 */
public class JczqChampionSecondScheduleItem {
	private String phase;          //彩期
	private String matchNum;        //赛事编码
	private String officialNum;    //官方编码
	private JczqRaceStatus status;  //赛程状态
	private String homeTeam;		//冠军队
	private String awayTeam;		//亚军队
	
	public String getJczqScheduleInfo(){
		StringBuffer sb = new StringBuffer();
		sb.append("[竞彩足球猜冠亚军赛程]");
		sb.append("彩期:").append(this.getPhase());
		sb.append(",赛事编码:").append(this.getMatchNum());
		sb.append(",官方编码:").append(this.getOfficialNum());
		sb.append(",赛程状态:").append(this.getStatus().getName());
		sb.append(",冠亚军队:").append(this.getHomeTeam()).append("VS").append(this.getAwayTeam());
		return sb.toString();
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
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

	public JczqRaceStatus getStatus() {
		return status;
	}

	public void setStatus(JczqRaceStatus status) {
		this.status = status;
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
}
