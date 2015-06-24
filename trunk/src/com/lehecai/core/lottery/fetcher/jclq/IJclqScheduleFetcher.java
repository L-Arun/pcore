/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jclq;

import java.util.List;

import com.lehecai.core.exception.FetchFailedException;
import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;

/**
 * @author qatang
 *
 */
public interface IJclqScheduleFetcher {
	/**
	 * 抓取指定彩期号的北单赛程
	 * @param officialDate 彩期号
	 * @return List<JclqScheduleItem>
	 */
	public List<JclqScheduleItem> fetch(String officialDate) throws UnsupportedFetcherTypeException, FetchFailedException ;
	
	/**
	 * 指定方式抓取指定彩期号的北单赛程
	 * @param officialDate 彩期号
	 * @param fetcherType 抓取方式
	 * @return List<JclqScheduleItem>
	 */
	public List<JclqScheduleItem> fetch(String officialDate, FetcherType fetcherType) throws UnsupportedFetcherTypeException, FetchFailedException ;

}
