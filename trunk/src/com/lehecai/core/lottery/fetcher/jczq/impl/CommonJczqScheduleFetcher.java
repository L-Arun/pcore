/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jczq.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.FetchFailedException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jczq.AbstractJczqScheduleFetchWorker;
import com.lehecai.core.lottery.fetcher.jczq.JczqScheduleItem;
import com.lehecai.core.lottery.fetcher.jczq.impl.worker.CommonJczqScheduleFetchWorkerOfficial;
import com.lehecai.core.lottery.fetcher.jczq.impl.worker.CommonJczqScheduleFetchWorkerPengineAPI;

/**
 * 通用竞彩足球赛程抓取
 *
 */
public class CommonJczqScheduleFetcher extends BaseJczqScheduleFetcher {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * 获取默认抓取类型
	 * @return
	 */
	protected FetcherType getDefaultFetcherType(){
		return FetcherType.T_PENGINEAPI;
	}
	/**
	 * 从官方网页抓取竞彩足球赛程
	 * @param officialDate
	 * @return
	 */
	protected List<JczqScheduleItem> fetchOfficial(String officialDate) throws FetchFailedException {
		AbstractJczqScheduleFetchWorker worker = new CommonJczqScheduleFetchWorkerOfficial();
		return worker.fetchJczqSchedule(officialDate);
	}
	/**
	 * 从engineAPI抓取竞彩足球赛程
	 * @param officialDate
	 * @return
	 */
	protected List<JczqScheduleItem> fetchPengineAPI(String officialDate) throws FetchFailedException {
		AbstractJczqScheduleFetchWorker worker = new CommonJczqScheduleFetchWorkerPengineAPI();
		return worker.fetchJczqSchedule(officialDate);
	}
}
