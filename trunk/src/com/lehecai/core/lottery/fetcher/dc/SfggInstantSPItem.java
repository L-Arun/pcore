package com.lehecai.core.lottery.fetcher.dc;

import java.util.Map;

import com.lehecai.core.lottery.SfggSPType;

public class SfggInstantSPItem {
	private String phase;			//期号
	
	private int matchIndex;			//场次顺序
	
	private String league;			//联赛或赛事名称
	
	private String homeTeam;		//主队
	
	private String awayTeam;		//客队
	
	private String matchDesc;       //比赛描述
	
	private Map<SfggSPType, String> spmap;
	
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

	public Map<SfggSPType, String> getSpmap() {
		return spmap;
	}

	public void setSpmap(Map<SfggSPType, String> spmap) {
		this.spmap = spmap;
	}

	public String getMatchDesc() {
		return matchDesc;
	}

	public void setMatchDesc(String matchDesc) {
		this.matchDesc = matchDesc;
	}
}
