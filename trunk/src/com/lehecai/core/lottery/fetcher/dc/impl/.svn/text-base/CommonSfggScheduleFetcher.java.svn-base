/**
 * 
 */
package com.lehecai.core.lottery.fetcher.dc.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.dc.AbstractSfggScheduleFetchWorker;
import com.lehecai.core.lottery.fetcher.dc.SfggScheduleItem;
import com.lehecai.core.lottery.fetcher.dc.impl.worker.CommonSfggScheduleFetchWorkerPengineAPI;

/**
 * 通用胜负过关赛程抓取
 *
 */
public class CommonSfggScheduleFetcher extends BaseSfggScheduleFetcher {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * 获取默认抓取类型
	 * @return
	 */
	protected FetcherType getDefaultFetcherType(){
		return FetcherType.T_PENGINEAPI;
	}
	/**
	 * 从engine抓取胜负过关赛程
	 * @param phase
	 * @return
	 */
	protected List<SfggScheduleItem> fetchPengineAPI(String phase){
		AbstractSfggScheduleFetchWorker worker = new CommonSfggScheduleFetchWorkerPengineAPI();
		return worker.fetchSfggSchedule(phase);
	}

}
