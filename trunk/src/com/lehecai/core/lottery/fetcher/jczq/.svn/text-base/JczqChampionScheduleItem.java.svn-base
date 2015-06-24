/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jczq;

import com.lehecai.core.lottery.JczqRaceStatus;

/**
 * @author qatang
 *
 */
public class JczqChampionScheduleItem {
	private String phase;          //彩期
	private String matchNum;        //赛事编码
	private String officialNum;    //官方编码
	private JczqRaceStatus status;  //赛程状态
	private String team;		//冠军队
	
	public String getJczqScheduleInfo(){
		StringBuffer sb = new StringBuffer();
		sb.append("[竞彩足球猜冠军赛程]");
		sb.append("彩期:").append(this.getPhase());
		sb.append(",赛事编码:").append(this.getMatchNum());
		sb.append(",官方编码:").append(this.getOfficialNum());
		sb.append(",赛程状态:").append(this.getStatus().getName());
		sb.append(",冠军队:").append(this.getTeam());
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

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
}
