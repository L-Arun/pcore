package com.lehecai.core.lottery.fetcher.dc.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.dc.DcInstantSPItem;
import com.lehecai.core.lottery.fetcher.dc.impl.worker.CommonDcInstantSPFetchWorkerPengineAPI;
import com.lehecai.core.lottery.fetcher.dc.impl.worker.CommonDcInstantSPFetcherWorker500Wan;

public class CommonDcInstantSPFetcher extends BaseDcInstantSPFetcher {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private FetcherType defaultFetcherType = FetcherType.T_500WAN;
	
	public CommonDcInstantSPFetcher() {
		
	}
	
	public CommonDcInstantSPFetcher(FetcherType fetcherType) {
		if (fetcherType != null) {
			this.defaultFetcherType = fetcherType;
		}
	}
	
	public CommonDcInstantSPFetcher(Integer fetcherTypeId) {
		FetcherType fetcherType = FetcherType.getItem(fetcherTypeId);
		if (fetcherType != null) {
			this.defaultFetcherType = fetcherType;
		}
	}
	
	protected List<DcInstantSPItem> fetch500Wan(String phase,LotteryType lotteryType) {
		CommonDcInstantSPFetcherWorker500Wan fetcher = new CommonDcInstantSPFetcherWorker500Wan();
		return fetcher.fetchDcInstantSP(phase, lotteryType);
	}
	
	/**
	 * 从engineAPI抓取北京单场即时sp
	 * @param phase
	 * @param lotteryType
	 * @return
	 */
	protected List<DcInstantSPItem> fetchPengineAPI(String phase,LotteryType lotteryType){
		CommonDcInstantSPFetchWorkerPengineAPI fetcher = new CommonDcInstantSPFetchWorkerPengineAPI();
		return fetcher.fetchDcInstantSP(phase, lotteryType);
	}

	@Override
	protected FetcherType getDefaultFetcherType() {
		return defaultFetcherType;
	}

}
