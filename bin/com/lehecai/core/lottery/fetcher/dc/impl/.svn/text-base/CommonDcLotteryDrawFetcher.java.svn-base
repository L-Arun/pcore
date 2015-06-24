/**
 * 
 */
package com.lehecai.core.lottery.fetcher.dc.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.dc.AbstractDcLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.dc.DcLotteryDrawItem;
import com.lehecai.core.lottery.fetcher.dc.impl.worker.CommonDcLotteryDrawFetchWorker500Wan;
import com.lehecai.core.lottery.fetcher.dc.impl.worker.CommonDcLotteryDrawFetchWorker8788;
import com.lehecai.core.lottery.fetcher.dc.impl.worker.CommonDcLotteryDrawFetchWorkerAIBO;
import com.lehecai.core.lottery.fetcher.dc.impl.worker.CommonDcLotteryDrawFetchWorkerOKOOO;
import com.lehecai.core.lottery.fetcher.dc.impl.worker.CommonDcLotteryDrawFetchWorkerPengineAPI;

/**
 * 通用北单赛程开奖结果抓取
 *
 */
public class CommonDcLotteryDrawFetcher extends BaseDcLotteryDrawFetcher {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * 获取默认抓取类型
	 * @return
	 */
	protected FetcherType getDefaultFetcherType(){
		return FetcherType.T_PENGINEAPI;
	}
	/**
	 * 从爱波抓取北单赛程开奖结果
	 * @param phase
	 * @return
	 */
	protected List<DcLotteryDrawItem> fetchAIBO(String phase){
		AbstractDcLotteryDrawFetchWorker worker = new CommonDcLotteryDrawFetchWorkerAIBO();
		return worker.fetchDcLotteryDraw(phase);
	}
	
	protected List<DcLotteryDrawItem> fetch500Wan(String phase) {
		AbstractDcLotteryDrawFetchWorker worker = new CommonDcLotteryDrawFetchWorker500Wan();
		return worker.fetchDcLotteryDraw(phase);
	}
	
	protected List<DcLotteryDrawItem> fetchOkooo(String phase){
		AbstractDcLotteryDrawFetchWorker worker = new CommonDcLotteryDrawFetchWorkerOKOOO();
		return worker.fetchDcLotteryDraw(phase);
	}
	
	/**
	 * 从PEngine的API获取北单开奖结果和SP值
	 * @param phase
	 * @return
	 */
	protected List<DcLotteryDrawItem> fetchPengineAPI(String phase){
		AbstractDcLotteryDrawFetchWorker worker = new CommonDcLotteryDrawFetchWorkerPengineAPI();
		return worker.fetchDcLotteryDraw(phase);
	}
	
	/**
	 * 从菠菜娃娃获取北单开奖结果和SP值
	 * @param phase
	 * @return
	 */
	protected List<DcLotteryDrawItem> fetch8788(String phase){
		AbstractDcLotteryDrawFetchWorker worker = new CommonDcLotteryDrawFetchWorker8788();
		return worker.fetchDcLotteryDraw(phase);
	}
}
