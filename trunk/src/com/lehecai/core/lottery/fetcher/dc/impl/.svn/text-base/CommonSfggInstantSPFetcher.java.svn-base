package com.lehecai.core.lottery.fetcher.dc.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.dc.AbstractSfggInstantSPFetcherWorker;
import com.lehecai.core.lottery.fetcher.dc.SfggInstantSPItem;
import com.lehecai.core.lottery.fetcher.dc.impl.worker.CommonSfggInstantSPFetchWorkerPengineAPI;

public class CommonSfggInstantSPFetcher extends BaseDcInstantSPFetcher {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	/**
	 * 获取默认抓取类型
	 * @return
	 */
	protected FetcherType getDefaultFetcherType(){
		return FetcherType.T_PENGINEAPI;
	}

	protected List<SfggInstantSPItem> fetchPengineAPI(String phase){
		AbstractSfggInstantSPFetcherWorker worker = new CommonSfggInstantSPFetchWorkerPengineAPI();
		return worker.fetchSfggInstantSP(phase);
	}

}
