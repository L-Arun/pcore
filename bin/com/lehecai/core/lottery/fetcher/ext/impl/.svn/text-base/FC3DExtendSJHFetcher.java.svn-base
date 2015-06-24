package com.lehecai.core.lottery.fetcher.ext.impl;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.ext.LotteryExtendItem;
import com.lehecai.core.lottery.fetcher.ext.worker.AbstractFC3DExtendSJHFetcherWorker;
import com.lehecai.core.lottery.fetcher.ext.worker.impl.FC3DExtendSJHFetcherWorkerZHCW;
import com.lehecai.core.lottery.fetcher.ext.worker.impl.FC3DExtendSJHFetcherWorkerZJOL;

public class FC3DExtendSJHFetcher extends BaseLotteryExtendFetcher {

	@Override
	protected FetcherType getDefaultFetcherType() {
		return FetcherType.T_ZJOL;
	}

	protected LotteryExtendItem fetchZJOL(String phase) {
		AbstractFC3DExtendSJHFetcherWorker worker = new FC3DExtendSJHFetcherWorkerZJOL();
		return worker.fetch(phase);
	}
	
	protected LotteryExtendItem fetchZHCW(String phase) {
		AbstractFC3DExtendSJHFetcherWorker worker = new FC3DExtendSJHFetcherWorkerZHCW();
		return worker.fetch(phase);
	}

}
