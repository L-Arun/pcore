package com.lehecai.core.lottery.fetcher.football;

import java.util.List;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;

/**
 * 足球赛程抓取接口
 * @author leiming
 *
 */
public interface IFootballScheduleFetcher {
	/**
	 * 抓取指定彩期号的足球赛程
	 * @param phase 彩期号
	 * @return List<FootballScheduleItem>
	 */
	public List<FootballScheduleItem> fetch(String phase) throws UnsupportedFetcherTypeException;
	
	/**
	 * 指定方式抓取指定彩期号的足球赛程
	 * @param phase 彩期号
	 * @param fetcherType 抓取方式
	 * @return List<FootballScheduleItem>
	 */
	public List<FootballScheduleItem> fetch(String phase, FetcherType fetcherType) throws UnsupportedFetcherTypeException;
}
