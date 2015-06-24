/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jczq;

import java.util.List;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;

/**
 * @author qatang
 *
 */
public interface IJczqChampionStaticInstantSpFetcher {
	/**
	 * @param phase
	 * @param lotteryType
	 * @return
	 * @throws UnsupportedFetcherTypeException
	 */
	public List<JczqChampionStaticInstantSpItem> fetch(String phase, LotteryType lotteryType) throws UnsupportedFetcherTypeException;
	
	/**
	 * @param phase
	 * @param fetcherType
	 * @param lotteryType
	 * @return
	 * @throws UnsupportedFetcherTypeException
	 */
	public List<JczqChampionStaticInstantSpItem> fetch(String phase, FetcherType fetcherType, LotteryType lotteryType) throws UnsupportedFetcherTypeException;

}
