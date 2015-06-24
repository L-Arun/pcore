/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jczq.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.FetchFailedException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jczq.AbstractJczqChampionScheduleFetchWorker;
import com.lehecai.core.lottery.fetcher.jczq.JczqChampionScheduleItem;
import com.lehecai.core.lottery.fetcher.jczq.impl.worker.CommonJczqChampionScheduleFetchWorkerOfficial;
import com.lehecai.core.lottery.fetcher.jczq.impl.worker.CommonJczqChampionScheduleFetchWorkerPengineAPI;

/**
 * 通用竞彩足球猜冠军赛程抓取
 *
 */
public class CommonJczqChampionScheduleFetcher extends BaseJczqChampionScheduleFetcher {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * 获取默认抓取类型
	 * @return
	 */
	protected FetcherType getDefaultFetcherType(){
		return FetcherType.T_PENGINEAPI;
	}
	/**
	 * 从官方网页抓取竞彩足球猜冠军赛程
	 * @return
	 */
	protected List<JczqChampionScheduleItem> fetchOfficial(String phase) throws FetchFailedException {
		AbstractJczqChampionScheduleFetchWorker worker = new CommonJczqChampionScheduleFetchWorkerOfficial();
		return worker.fetchJczqChampionSchedule(phase);
	}
	/**
	 * 从engineAPI抓取竞彩足球猜冠军赛程
	 * @return
	 */
	protected List<JczqChampionScheduleItem> fetchPengineAPI(String phase) throws FetchFailedException {
		AbstractJczqChampionScheduleFetchWorker worker = new CommonJczqChampionScheduleFetchWorkerPengineAPI();
		return worker.fetchJczqChampionSchedule(phase);
	}
}
