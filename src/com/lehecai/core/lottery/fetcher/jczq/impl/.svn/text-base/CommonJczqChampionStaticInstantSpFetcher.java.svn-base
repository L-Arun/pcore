/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jczq.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jczq.AbstractJczqChampionStaticInstantSpFetchWorker;
import com.lehecai.core.lottery.fetcher.jczq.JczqChampionStaticInstantSpItem;
import com.lehecai.core.lottery.fetcher.jczq.impl.worker.CommonJczqChampionStaticInstantSpFetchWorkerPengineAPI;

/**
 * 通用竞彩足球sp抓取
 *
 */
public class CommonJczqChampionStaticInstantSpFetcher extends BaseJczqChampionStaticInstantSpFetcher {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * 获取默认抓取类型
	 * @return
	 */
	protected FetcherType getDefaultFetcherType(){
		return FetcherType.T_PENGINEAPI;
	}
	
	/**
	 * 从engineAPI抓取竞彩足球sp
	 * @param phase
	 * @return
	 */
	protected List<JczqChampionStaticInstantSpItem> fetchPengineAPI(String phase, LotteryType lotteryType){
		AbstractJczqChampionStaticInstantSpFetchWorker worker = new CommonJczqChampionStaticInstantSpFetchWorkerPengineAPI();
		return worker.fetchJczqSp(phase, lotteryType);
	}
}
