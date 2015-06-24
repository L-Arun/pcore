/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jczq;

import java.util.List;

import com.lehecai.core.exception.FetchFailedException;
import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;

/**
 * @author qatang
 *
 */
public interface IJczqScheduleFetcher {
	/**
	 * 抓取指定官方比赛时间的竞彩足球赛程
	 * @param officialDate 彩期号
	 * @return List<JczqScheduleItem>
	 */
	public List<JczqScheduleItem> fetch(String officialDate) throws UnsupportedFetcherTypeException, FetchFailedException;
	
	/**
	 * 指定方式抓取指定官方比赛时间的竞彩足球赛程
	 * @param officialDate 彩期号
	 * @param fetcherType 抓取方式
	 * @return List<JczqScheduleItem>
	 */
	public List<JczqScheduleItem> fetch(String officialDate, FetcherType fetcherType) throws UnsupportedFetcherTypeException, FetchFailedException;

}
