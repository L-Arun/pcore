/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jclq.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jclq.AbstractJclqSpFetchWorker;
import com.lehecai.core.lottery.fetcher.jclq.JclqSpItem;
import com.lehecai.core.lottery.fetcher.jclq.impl.worker.CommonJclqSpFetchWorker500Wan;
import com.lehecai.core.lottery.fetcher.jclq.impl.worker.CommonJclqSpFetchWorkerPengineAPI;

/**
 * 通用竞彩篮球sp抓取
 *
 */
public class CommonJclqSpFetcher extends BaseJclqSpFetcher {
	
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
	 * @param officialDate
	 * @return
	 */
	protected List<JclqSpItem> fetchPengineAPI(String officialDate){
		AbstractJclqSpFetchWorker worker = new CommonJclqSpFetchWorkerPengineAPI();
		return worker.fetchJclqSp(officialDate);
	}
	
	/**
	 * 从500wan抓取竞彩篮球sp
	 * @param officialDate
	 * @return
	 */
	protected List<JclqSpItem> fetch500Wan(String officialDate){
		AbstractJclqSpFetchWorker worker = new CommonJclqSpFetchWorker500Wan();
		return worker.fetchJclqSp(officialDate);
	}
}
