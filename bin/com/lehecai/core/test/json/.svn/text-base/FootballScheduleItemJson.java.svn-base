package com.lehecai.core.test.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lehecai.core.lottery.fetcher.football.FootballScheduleItem;

public class FootballScheduleItemJson {
	public static void main(String[] args){
		List<FootballScheduleItem> footballScheduleItems = new ArrayList<FootballScheduleItem>();
		Date nowTime = new Date();
		FootballScheduleItem fs1 = new FootballScheduleItem();
		fs1.setPhase("2011013");
		fs1.setMatchTime(nowTime);
		fs1.setLeague("英超");
		fs1.setHomeTeam("曼联");
		fs1.setAwayTeam("曼城");
		fs1.setMatchIndex(1);
		
		FootballScheduleItem fs2 = new FootballScheduleItem();
		fs2.setPhase("2011013");
		fs2.setMatchTime(nowTime);
		fs2.setLeague("英超");
		fs2.setHomeTeam("曼联");
		fs2.setAwayTeam("曼城");
		fs2.setMatchIndex(2);
		
		footballScheduleItems.add(fs1);
		footballScheduleItems.add(fs2);
		
		System.out.println(FootballScheduleItem.toJSONArray(footballScheduleItems).toString());
	}
}
