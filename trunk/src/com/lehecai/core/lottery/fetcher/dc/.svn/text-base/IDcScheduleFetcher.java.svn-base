/**
 * 
 */
package com.lehecai.core.lottery.fetcher.dc;

import java.util.List;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;

/**
 * @author Sunshow
 *
 */
public interface IDcScheduleFetcher {
	/**
	 * 抓取指定彩期号的北单赛程
	 * @param phase 彩期号
	 * @return List<DcScheduleItem>
	 */
	public List<DcScheduleItem> fetch(String phase) throws UnsupportedFetcherTypeException;
	
	/**
	 * 指定方式抓取指定彩期号的北单赛程
	 * @param phase 彩期号
	 * @param fetcherType 抓取方式
	 * @return List<DcScheduleItem>
	 */
	public List<DcScheduleItem> fetch(String phase, FetcherType fetcherType) throws UnsupportedFetcherTypeException;

}
