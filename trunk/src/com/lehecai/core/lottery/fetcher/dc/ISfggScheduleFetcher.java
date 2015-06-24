/**
 * 
 */
package com.lehecai.core.lottery.fetcher.dc;

import java.util.List;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;

/**
 * @author qatang
 *
 */
public interface ISfggScheduleFetcher {
	/**
	 * 抓取指定彩期号的胜负过关赛程
	 * @param phase 彩期号
	 * @return List<SfggScheduleItem>
	 */
	public List<SfggScheduleItem> fetch(String phase) throws UnsupportedFetcherTypeException;
	
	/**
	 * 指定方式抓取指定彩期号的胜负过关赛程
	 * @param phase 彩期号
	 * @param fetcherType 抓取方式
	 * @return List<SfggScheduleItem>
	 */
	public List<SfggScheduleItem> fetch(String phase, FetcherType fetcherType) throws UnsupportedFetcherTypeException;

}
