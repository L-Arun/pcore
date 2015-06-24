package com.lehecai.core.lottery.fetcher.dc;

import java.util.List;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;

public interface IDcAverageSPFetcher {

	/**
	 * 按彩期号抓取、默认抓取策略抓取平均欧赔
	 * @param phase 彩期号
	 * @return List<DcAverageSPItem> 平均欧赔项列表
	 * @throws UnsupportedFetcherTypeException
	 */
	public List<DcAverageSPItem> fetch(String phase) throws UnsupportedFetcherTypeException;
	
	/**
	 * 按彩期号抓取、抓取策略抓取平均欧赔
	 * @param phase 彩期号
	 * @param fetcherType 抓取策略
	 * @return List<DcAverageSPItem> 平均欧赔项列表
	 * @throws UnsupportedFetcherTypeException
	 */
	public List<DcAverageSPItem> fetch(String phase, FetcherType fetcherType) throws UnsupportedFetcherTypeException;
}
