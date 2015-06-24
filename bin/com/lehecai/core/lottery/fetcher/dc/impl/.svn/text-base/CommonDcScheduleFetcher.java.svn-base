/**
 * 
 */
package com.lehecai.core.lottery.fetcher.dc.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.dc.AbstractDcScheduleFetchWorker;
import com.lehecai.core.lottery.fetcher.dc.DcScheduleItem;
import com.lehecai.core.lottery.fetcher.dc.impl.worker.CommonDcScheduleFetchWorker500Wan;
import com.lehecai.core.lottery.fetcher.dc.impl.worker.CommonDcScheduleFetchWorkerAIBO;

/**
 * 通用北单赛程抓取
 *
 */
public class CommonDcScheduleFetcher extends BaseDcScheduleFetcher {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * 获取默认抓取类型
	 * @return
	 */
	protected FetcherType getDefaultFetcherType(){
		return FetcherType.T_AIBO;
	}
	/**
	 * 从爱波抓取北单赛程
	 * @param phase
	 * @return
	 */
	protected List<DcScheduleItem> fetchAIBO(String phase){
		AbstractDcScheduleFetchWorker worker = new CommonDcScheduleFetchWorkerAIBO();
		return worker.fetchDcSchedule(phase);
	}

	/**
	 * 从500万种抓取北单赛程
	 * @param phase
	 * @return
	 */
	protected List<DcScheduleItem> fetch500Wan(String phase){
		AbstractDcScheduleFetchWorker worker = new CommonDcScheduleFetchWorker500Wan();
		return worker.fetchDcSchedule(phase);
	}
}
