/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jczq.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jczq.AbstractJczqSpFetchWorker;
import com.lehecai.core.lottery.fetcher.jczq.JczqSpItem;
import com.lehecai.core.lottery.fetcher.jczq.impl.worker.CommonJczqSpFetchWorker500Wan;
import com.lehecai.core.lottery.fetcher.jczq.impl.worker.CommonJczqSpFetchWorkerPengineAPI;

/**
 * 通用竞彩足球sp抓取
 *
 */
public class CommonJczqSpFetcher extends BaseJczqSpFetcher {
	
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
	 * @param officialDate
	 * @return
	 */
	protected List<JczqSpItem> fetchPengineAPI(String officialDate){
		AbstractJczqSpFetchWorker worker = new CommonJczqSpFetchWorkerPengineAPI();
		return worker.fetchJczqSp(officialDate);
	}
	
	/**
	 * 从500wan抓取竞彩足球sp
	 * @param officialDate
	 * @return
	 */
	protected List<JczqSpItem> fetch500Wan(String officialDate){
		AbstractJczqSpFetchWorker worker = new CommonJczqSpFetchWorker500Wan();
		return worker.fetchJczqSp(officialDate);
	}
}
