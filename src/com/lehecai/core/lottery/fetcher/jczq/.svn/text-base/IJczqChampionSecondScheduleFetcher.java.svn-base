/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jczq;

import java.util.List;

import com.lehecai.core.exception.FetchFailedException;
import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;

/**
 * 抓取竞彩足球猜冠亚军赛程
 * @author qatang
 *
 */
public interface IJczqChampionSecondScheduleFetcher {
	/**
	 * 抓取竞彩足球猜冠军赛程
	 * @param officialDate 彩期号
	 * @return List<JczqChampionSecondScheduleItem>
	 */
	public List<JczqChampionSecondScheduleItem> fetch(String phase) throws UnsupportedFetcherTypeException, FetchFailedException;
	
	/**
	 * 指定方式抓取竞彩足球猜冠军赛程
	 * @param fetcherType 抓取方式
	 * @return List<JczqChampionSecondScheduleItem>
	 */
	public List<JczqChampionSecondScheduleItem> fetch(String phase, FetcherType fetcherType) throws UnsupportedFetcherTypeException, FetchFailedException;

}
