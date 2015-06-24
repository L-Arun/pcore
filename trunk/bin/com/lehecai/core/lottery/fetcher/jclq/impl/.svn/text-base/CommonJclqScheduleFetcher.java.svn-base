/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jclq.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.FetchFailedException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jclq.AbstractJclqScheduleFetchWorker;
import com.lehecai.core.lottery.fetcher.jclq.JclqScheduleItem;
import com.lehecai.core.lottery.fetcher.jclq.impl.worker.CommonJclqScheduleFetchWorkerOfficial;
import com.lehecai.core.lottery.fetcher.jclq.impl.worker.CommonJclqScheduleFetchWorkerPengineAPI;

/**
 * 通用竞彩篮球赛程抓取
 *
 */
public class CommonJclqScheduleFetcher extends BaseJclqScheduleFetcher {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * 获取默认抓取类型
	 * @return
	 */
	protected FetcherType getDefaultFetcherType(){
		return FetcherType.T_PENGINEAPI;
	}
	/**
	 * 从官方网页抓取竞彩篮球赛程
	 * @param officialDate
	 * @return
	 */
	protected List<JclqScheduleItem> fetchOfficial(String officialDate) throws FetchFailedException {
		AbstractJclqScheduleFetchWorker worker = new CommonJclqScheduleFetchWorkerOfficial();
		return worker.fetchJclqSchedule(officialDate);
	}
	/**
	 * 从engineAPI抓取竞彩篮球赛程
	 * @param officialDate
	 * @return
	 */
	protected List<JclqScheduleItem> fetchPengineAPI(String officialDate) throws FetchFailedException {
		AbstractJclqScheduleFetchWorker worker = new CommonJclqScheduleFetchWorkerPengineAPI();
		return worker.fetchJclqSchedule(officialDate);
	}
}
