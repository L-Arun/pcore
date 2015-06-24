package com.lehecai.core.lottery.fetcher.football.impl;

import java.util.List;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.football.AbstractFootballScheduleFetchWorker;
import com.lehecai.core.lottery.fetcher.football.FootballScheduleItem;
import com.lehecai.core.lottery.fetcher.football.impl.worker.FootballScheduleFetch10Worker500Wan;
import com.lehecai.core.lottery.fetcher.football.impl.worker.FootballScheduleFetch10Worker500WanWeb;
import com.lehecai.core.lottery.fetcher.football.impl.worker.FootballScheduleFetch10WorkerClient;
import com.lehecai.core.lottery.fetcher.football.impl.worker.FootballScheduleFetch10WorkerOfficial;
import com.lehecai.core.lottery.fetcher.football.impl.worker.FootballScheduleFetch10WorkerOkooo;
import com.lehecai.core.lottery.fetcher.football.impl.worker.FootballScheduleFetch10WorkerPlotRemote;

/**
 * 6场半全场 足球赛程抓取 实现类
 * @author leiming
 *
 */
public class FootballScheduleFetcher10 extends BaseFootballScheduleFetcher{
	public FootballScheduleFetcher10(){
		this.setLotteryType(LotteryType.BQC);
	}
	@Override
	public List<FootballScheduleItem> fetch500Wan(String phase) {
		AbstractFootballScheduleFetchWorker worker = new FootballScheduleFetch10Worker500Wan();
		worker.setLotteryType(this.getLotteryType());
		List<FootballScheduleItem> list = worker.fetchFootballSchedule(phase);
		return list;
	}
	public List<FootballScheduleItem> fetchClient(String phase) {
		AbstractFootballScheduleFetchWorker worker = new FootballScheduleFetch10WorkerClient();
		worker.setLotteryType(this.getLotteryType());
		List<FootballScheduleItem> list = worker.fetchFootballSchedule(phase);
		return list;
	}
	public List<FootballScheduleItem> fetchPlotRemote(String phase) {
		AbstractFootballScheduleFetchWorker worker = new FootballScheduleFetch10WorkerPlotRemote();
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
		FootballScheduleFetch10WorkerOkooo worker = new FootballScheduleFetch10WorkerOkooo();
		worker.setLotteryType(this.getLotteryType());
		List<FootballScheduleItem> list = worker.fetchFootballSchedule(phase);
		return list;
	}
	//实现赛程的500WanWeb抓取
	public List<FootballScheduleItem> fetch500WanWeb(String phase) {
		AbstractFootballScheduleFetchWorker worker = new FootballScheduleFetch10Worker500WanWeb();
		worker.setLotteryType(this.getLotteryType());
		List<FootballScheduleItem> list = worker.fetchFootballSchedule(phase);
		return list;
	}
	//实现赛程的Official抓取
	public List<FootballScheduleItem> fetchOfficial(String phase) {
		AbstractFootballScheduleFetchWorker worker = new FootballScheduleFetch10WorkerOfficial();
		worker.setLotteryType(this.getLotteryType());
		List<FootballScheduleItem> list = worker.fetchFootballSchedule(phase);
		return list;
	}
	
}
