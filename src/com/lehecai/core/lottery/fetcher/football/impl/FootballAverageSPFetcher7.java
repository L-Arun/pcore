package com.lehecai.core.lottery.fetcher.football.impl;

import java.util.List;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.football.AbstractFootballAverageSPFetchWorker;
import com.lehecai.core.lottery.fetcher.football.FootballAverageSPItem;
import com.lehecai.core.lottery.fetcher.football.impl.worker.FootballAverageSPFetch7Worker500Wan;

/**
 * 从500wan里抓取胜负彩的平均SP值
 * @author 唐容
 *
 */
	
public class FootballAverageSPFetcher7 extends BaseFootballAverageSPFetcher {
	@Override
	protected List<FootballAverageSPItem> fetch500Wan(String phase) {
		AbstractFootballAverageSPFetchWorker worker = new FootballAverageSPFetch7Worker500Wan();
		return worker.fetch(phase);
	}

	@Override
	protected FetcherType getDefaultFetcherType() {
		return FetcherType.T_500WAN;
	}

}
