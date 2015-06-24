package com.lehecai.core.lottery.fetcher.football;

import java.util.List;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;

public interface IFootballAverageSPFetcher {
	
	/**
	 * 根据彩期号抓取足彩的平均SP指数
	 * @param phase 彩期号
	 * @return List<FootballAverageSPItem>
	 * @throws UnsupportedFetcherTypeException
	 */
	public List<FootballAverageSPItem> fetch(String phase) throws UnsupportedFetcherTypeException;
	
	/**
	 * 根据彩期号、抓取类型抓取足彩的平均SP指数
	 * @param phase 彩期号
	 * @param fetcherType List<FootballAverageSPItem>
	 * @return
	 * @throws UnsupportedFetcherTypeException
	 */
	public List<FootballAverageSPItem> fetch(String phase, FetcherType fetcherType) throws UnsupportedFetcherTypeException;
}
