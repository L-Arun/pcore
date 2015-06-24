/**
 * 
 */
package com.lehecai.core.lottery.fetcher.dc.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.dc.AbstractSfggLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.dc.SfggLotteryDrawItem;
import com.lehecai.core.lottery.fetcher.dc.impl.worker.CommonSfggLotteryDrawFetchWorkerPengineAPI;

/**
 * 通用胜负过关赛程开奖结果抓取
 *
 */
public class CommonSfggLotteryDrawFetcher extends BaseSfggLotteryDrawFetcher {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * 获取默认抓取类型
	 * @return
	 */
	protected FetcherType getDefaultFetcherType(){
		return FetcherType.T_PENGINEAPI;
	}
	
	/**
	 * 从PEngine的API获取胜负过关开奖结果和SP值
	 * @param phase
	 * @return
	 */
	protected List<SfggLotteryDrawItem> fetchPengineAPI(String phase){
		AbstractSfggLotteryDrawFetchWorker worker = new CommonSfggLotteryDrawFetchWorkerPengineAPI();
		return worker.fetchSfggLotteryDraw(phase);
	}
}
