package com.lehecai.core.lottery.fetcher.dc.impl;

import java.util.List;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.dc.AbstractDcAverageSPFetcherWorker;
import com.lehecai.core.lottery.fetcher.dc.DcAverageSPItem;
import com.lehecai.core.lottery.fetcher.dc.impl.worker.CommonDcAverageSPFetcher500Wan;

public class CommonDcAverageSPFetcher extends BaseDcAverageSPFetcher {

	@Override
	protected List<DcAverageSPItem> fetch500Wan(String phase) {
		AbstractDcAverageSPFetcherWorker fetcher500Wan = new CommonDcAverageSPFetcher500Wan();
		return fetcher500Wan.fetchDcAverageSP(phase);
	}

	@Override
	protected FetcherType getDefaultFetcherType() {
		return FetcherType.T_500WAN;
	}

}
