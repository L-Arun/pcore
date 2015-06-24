/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jclq.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jclq.AbstractJclqStaticInstantSpFetchWorker;
import com.lehecai.core.lottery.fetcher.jclq.JclqStaticInstantSpItem;
import com.lehecai.core.lottery.fetcher.jclq.impl.worker.CommonJclqStaticInstantSpFetchWorkerPengineAPI;

/**
 * 通用竞彩篮球sp抓取
 *
 */
public class CommonJclqStaticInstantSpFetcher extends BaseJclqStaticInstantSpFetcher {
	
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
	protected List<JclqStaticInstantSpItem> fetchPengineAPI(String officialDate, LotteryType lotteryType){
		AbstractJclqStaticInstantSpFetchWorker worker = new CommonJclqStaticInstantSpFetchWorkerPengineAPI();
		return worker.fetchJclqSp(officialDate, lotteryType);
	}
}
