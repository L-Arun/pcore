/**
 * 
 */
package com.lehecai.core.lottery.fetcher.lotterydraw;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;

/**
 * @author Sunshow
 *
 */
public interface ILotteryDrawFetcher {
	/**
	 * 抓取指定彩期号的开奖结果
	 * @param phase 彩期号
	 * @return LotteryOpenResult
	 */
	public LotteryDraw fetch(String phase) throws UnsupportedFetcherTypeException;
	/**
	 * 指定方式抓取指定彩期号的开奖结果
	 * @param phase 彩期号
	 * @param fetcherType 抓取方式
	 * @return LotteryOpenResult
	 */
	public LotteryDraw fetch(String phase, FetcherType fetcherType) throws UnsupportedFetcherTypeException;

}
