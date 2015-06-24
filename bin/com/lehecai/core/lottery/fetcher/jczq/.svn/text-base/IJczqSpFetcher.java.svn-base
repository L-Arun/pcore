/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jczq;

import java.util.List;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;

/**
 * @author qatang
 *
 */
public interface IJczqSpFetcher {
	/**
	 * 抓取指定彩期号的sp
	 * @param officialDate 彩期号
	 * @return List<JczqSpItem>
	 */
	public List<JczqSpItem> fetch(String officialDate) throws UnsupportedFetcherTypeException;
	
	/**
	 * 指定方式抓取指定彩期号的sp
	 * @param officialDate 彩期号
	 * @param fetcherType 抓取方式
	 * @return List<JczqSpItem>
	 */
	public List<JczqSpItem> fetch(String officialDate, FetcherType fetcherType) throws UnsupportedFetcherTypeException;

}
