package com.lehecai.core.lottery.fetcher.football.impl;

import java.util.List;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.football.AbstractFootballAverageSPFetchWorker;
import com.lehecai.core.lottery.fetcher.football.FootballAverageSPItem;
import com.lehecai.core.lottery.fetcher.football.impl.worker.FootballAverageSPFetch9Worker500Wan;
/**
 * 4场进球 
 * @author 唐容
 *
 */
public class FootballAverageSPFetcher9 extends BaseFootballAverageSPFetcher {

	@Override
	protected List<FootballAverageSPItem> fetch500Wan(String phase) {
		AbstractFootballAverageSPFetchWorker worker = new FootballAverageSPFetch9Worker500Wan();
		return worker.fetch(phase);
	}

	@Override
	protected FetcherType getDefaultFetcherType() {
		return FetcherType.T_500WAN;
	}

}
