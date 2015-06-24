package com.lehecai.core.lottery.fetcher.ext;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;

public interface ILotteryExtendFetcher {

	/**
	 * 按默认方式抓取扩展信息
	 * @param phase
	 * @return
	 * @throws UnsupportedFetcherTypeException
	 */
	public LotteryExtendItem fetch(String phase) throws UnsupportedFetcherTypeException;
	
	/**
	 * 按指定抓取方式抓取扩展信息
	 * @param phase
	 * @param fetcherType
	 * @return
	 * @throws UnsupportedFetcherTypeException
	 */
	public LotteryExtendItem fetch(String phase, FetcherType fetcherType)throws UnsupportedFetcherTypeException;
}
