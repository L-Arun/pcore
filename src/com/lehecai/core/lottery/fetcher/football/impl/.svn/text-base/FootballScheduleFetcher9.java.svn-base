package com.lehecai.core.lottery.fetcher.football.impl;

import java.util.List;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.football.AbstractFootballScheduleFetchWorker;
import com.lehecai.core.lottery.fetcher.football.FootballScheduleItem;
import com.lehecai.core.lottery.fetcher.football.impl.worker.FootballScheduleFetch9Worker500Wan;
import com.lehecai.core.lottery.fetcher.football.impl.worker.FootballScheduleFetch9Worker500WanWeb;
import com.lehecai.core.lottery.fetcher.football.impl.worker.FootballScheduleFetch9WorkerClient;
import com.lehecai.core.lottery.fetcher.football.impl.worker.FootballScheduleFetch9WorkerOfficial;
import com.lehecai.core.lottery.fetcher.football.impl.worker.FootballScheduleFetch9WorkerOkooo;
import com.lehecai.core.lottery.fetcher.football.impl.worker.FootballScheduleFetch9WorkerPlotRemote;

/**
 * 4场进球 足球赛程抓取 实现类
 * @author leiming
 *
 */
public class FootballScheduleFetcher9 extends BaseFootballScheduleFetcher{
	public FootballScheduleFetcher9(){
		this.setLotteryType(LotteryType.JQC);
	}
	@Override
	public List<FootballScheduleItem> fetch500Wan(String phase) {
		AbstractFootballScheduleFetchWorker worker = new FootballScheduleFetch9Worker500Wan();
		worker.setLotteryType(this.getLotteryType());
		List<FootballScheduleItem> list = worker.fetchFootballSchedule(phase);
		return list;
	}
	public List<FootballScheduleItem> fetchClient(String phase) {
		AbstractFootballScheduleFetchWorker worker = new FootballScheduleFetch9WorkerClient();
		worker.setLotteryType(this.getLotteryType());
		List<FootballScheduleItem> list = worker.fetchFootballSchedule(phase);
		return list;
	}
	public List<FootballScheduleItem> fetchPlotRemote(String phase) {
		AbstractFootballScheduleFetchWorker worker = new FootballScheduleFetch9WorkerPlotRemote();
		worker.setLotteryType(this.getLotteryType());
		List<FootballScheduleItem> list = worker.fetchFootballSchedule(phase);
		return list;
	}
	protected FetcherType getDefaultFetcherType() {
		// 默认使用500wan抓取
		return FetcherType.T_500WAN;
	}
	@Override
	//实现赛程的Okooo抓取2011-3-30
	public List<FootballScheduleItem> fetchOkooo(String phase) {
		AbstractFootballScheduleFetchWorker worker = new FootballScheduleFetch9WorkerOkooo();
		worker.setLotteryType(this.getLotteryType());
		List<FootballScheduleItem> list = worker.fetchFootballSchedule(phase);
		return list;
	}
	
	//实现赛程的500WanWeb抓取
	public List<FootballScheduleItem> fetch500WanWeb(String phase) {
		AbstractFootballScheduleFetchWorker worker = new FootballScheduleFetch9Worker500WanWeb();
		worker.setLotteryType(this.getLotteryType());
		List<FootballScheduleItem> list = worker.fetchFootballSchedule(phase);
		return list;
	}
	
	//实现赛程的官方抓取
	public List<FootballScheduleItem> fetchOfficial(String phase) {
		AbstractFootballScheduleFetchWorker worker = new FootballScheduleFetch9WorkerOfficial();
		worker.setLotteryType(this.getLotteryType());
		List<FootballScheduleItem> list = worker.fetchFootballSchedule(phase);
		return list;
	}
}
