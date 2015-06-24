package com.lehecai.core.lottery.fetcher.dc;

import java.util.List;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;

/**
 * 
 * @author 唐容
 *
 */
public interface IDcInstantSPFetcher {

	/**
	 * 抓取指定彩期号的即时SP值
	 * @param phase 彩期号
	 * @param lotteryType 彩种类型
	 * @return List<DcInstantSPItem>
	 */
	public List<DcInstantSPItem> fetch(String phase, LotteryType lotteryType)throws UnsupportedFetcherTypeException;
	
	/**
	 * 指定抓取方式、指定彩期号，抓取即时SP值
	 * @param phase 彩期号
	 * @param fetcherType 抓取方式
	 * @param lotteryType 彩种类型
	 * @return List<DcInstantSPItem>
	 */
	public List<DcInstantSPItem> fetch(String phase,FetcherType fetcherType, LotteryType lotteryType)throws UnsupportedFetcherTypeException;
}
