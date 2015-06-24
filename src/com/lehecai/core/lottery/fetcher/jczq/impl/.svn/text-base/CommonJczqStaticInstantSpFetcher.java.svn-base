/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jczq.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jczq.AbstractJczqStaticInstantSpFetchWorker;
import com.lehecai.core.lottery.fetcher.jczq.JczqStaticInstantSpItem;
import com.lehecai.core.lottery.fetcher.jczq.impl.worker.CommonJczqStaticInstantSpFetchWorkerPengineAPI;

/**
 * 通用竞彩足球sp抓取
 *
 */
public class CommonJczqStaticInstantSpFetcher extends BaseJczqStaticInstantSpFetcher {
	
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
	protected List<JczqStaticInstantSpItem> fetchPengineAPI(String officialDate, LotteryType lotteryType){
		AbstractJczqStaticInstantSpFetchWorker worker = new CommonJczqStaticInstantSpFetchWorkerPengineAPI();
		return worker.fetchJczqSp(officialDate, lotteryType);
	}
}
