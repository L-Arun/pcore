/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jczq.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.FetchFailedException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jczq.AbstractJczqChampionSecondScheduleFetchWorker;
import com.lehecai.core.lottery.fetcher.jczq.JczqChampionSecondScheduleItem;
import com.lehecai.core.lottery.fetcher.jczq.impl.worker.CommonJczqChampionSecondScheduleFetchWorkerOfficial;
import com.lehecai.core.lottery.fetcher.jczq.impl.worker.CommonJczqChampionSecondScheduleFetchWorkerPengineAPI;

/**
 * 通用竞彩足球猜冠亚军赛程抓取
 *
 */
public class CommonJczqChampionSecondScheduleFetcher extends BaseJczqChampionSecondScheduleFetcher {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * 获取默认抓取类型
	 * @return
	 */
	protected FetcherType getDefaultFetcherType(){
		return FetcherType.T_PENGINEAPI;
	}
	/**
	 * 从官方网页抓取竞彩足球猜冠亚军赛程
	 * @return
	 */
	protected List<JczqChampionSecondScheduleItem> fetchOfficial(String phase) throws FetchFailedException {
		AbstractJczqChampionSecondScheduleFetchWorker worker = new CommonJczqChampionSecondScheduleFetchWorkerOfficial();
		return worker.fetchJczqChampionSecondSchedule(phase);
	}
	/**
	 * 从engineAPI抓取竞彩足球猜冠亚军赛程
	 * @return
	 */
	protected List<JczqChampionSecondScheduleItem> fetchPengineAPI(String phase) throws FetchFailedException {
		AbstractJczqChampionSecondScheduleFetchWorker worker = new CommonJczqChampionSecondScheduleFetchWorkerPengineAPI();
		return worker.fetchJczqChampionSecondSchedule(phase);
	}
}
