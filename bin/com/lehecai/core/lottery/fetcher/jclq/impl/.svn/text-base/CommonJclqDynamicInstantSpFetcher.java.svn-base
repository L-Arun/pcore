/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jclq.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jclq.AbstractJclqDynamicInstantSpFetchWorker;
import com.lehecai.core.lottery.fetcher.jclq.JclqDynamicInstantSpItem;
import com.lehecai.core.lottery.fetcher.jclq.impl.worker.CommonJclqDynamicInstantSpFetchWorkerPengineAPI;

/**
 * 通用竞彩篮球sp抓取
 *
 */
public class CommonJclqDynamicInstantSpFetcher extends BaseJclqDynamicInstantSpFetcher {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * 获取默认抓取类型
	 * @return
	 */
	protected FetcherType getDefaultFetcherType(){
		return FetcherType.T_PENGINEAPI;
	}
	
	/**
	 * 从engineAPI抓取竞彩篮球sp
	 * @param phase
	 * @return
	 */
	protected List<JclqDynamicInstantSpItem> fetchPengineAPI(String officialDate, LotteryType lotteryType){
		AbstractJclqDynamicInstantSpFetchWorker worker = new CommonJclqDynamicInstantSpFetchWorkerPengineAPI();
		return worker.fetchJclqSp(officialDate, lotteryType);
	}
}
