/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jclq;

import java.util.List;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;

/**
 * @author qatang
 *
 */
public interface IJclqDynamicInstantSpFetcher {
	/**
	 * 抓取指定彩期号的sp
	 * @param officialDate 官方赛程日期
	 * @return List<JclqSpItem>
	 */
	public List<JclqDynamicInstantSpItem> fetch(String officialDate, LotteryType lotteryType) throws UnsupportedFetcherTypeException;
	
	/**
	 * 指定方式抓取指定彩期号的sp
	 * @param officialDate 官方赛程日期
	 * @param fetcherType 抓取方式
	 * @return List<JclqSpItem>
	 */
	public List<JclqDynamicInstantSpItem> fetch(String officialDate, FetcherType fetcherType, LotteryType lotteryType) throws UnsupportedFetcherTypeException;

}
