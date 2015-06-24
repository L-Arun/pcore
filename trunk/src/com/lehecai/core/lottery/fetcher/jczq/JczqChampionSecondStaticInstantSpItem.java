/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jczq;

import java.util.Map;

import com.lehecai.core.lottery.JczqSPType;

/**
 * @author qatang
 * 猜冠亚军固定奖金即时sp
 */
public class JczqChampionSecondStaticInstantSpItem {
	private String phase;
	private String matchNum;        //赛事编码
	private String homeTeam;		//冠亚军队1
	private String awayTeam;		//冠亚军队2
	private Map<JczqSPType, String> spmap; //即时sp
	
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
	public Map<JczqSPType, String> getSpmap() {
		return spmap;
	}
	public void setSpmap(Map<JczqSPType, String> spmap) {
		this.spmap = spmap;
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
