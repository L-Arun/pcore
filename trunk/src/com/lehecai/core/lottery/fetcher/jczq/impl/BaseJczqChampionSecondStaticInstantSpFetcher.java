/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jczq.impl;

import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jczq.IJczqChampionSecondStaticInstantSpFetcher;
import com.lehecai.core.lottery.fetcher.jczq.JczqChampionSecondStaticInstantSpItem;
import com.lehecai.core.util.CoreObjectUtils;

/**
 * 竞彩足球猜冠亚军sp抓取
 *
 */
public abstract class BaseJczqChampionSecondStaticInstantSpFetcher implements IJczqChampionSecondStaticInstantSpFetcher {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@SuppressWarnings("unchecked")
	@Override
	public List<JczqChampionSecondStaticInstantSpItem> fetch(String phase, FetcherType fetcherType, LotteryType lotteryType) throws UnsupportedFetcherTypeException{
		if (fetcherType.getValue() == FetcherType.T_DEFAULT.getValue()) {
			return fetch(phase, getDefaultFetcherType(), lotteryType);
		}
		Method m;
		try {
			m = CoreObjectUtils.getMethod(getClass(), "fetch" + fetcherType.getName(), new Class[]{String.class, LotteryType.class});
		} catch (SecurityException e) {
			m = null;
			logger.error(e.getMessage(), e);
		} catch (NoSuchMethodException e) {
			m = null;
			logger.error("未找到({})的抓取器", fetcherType.getName());
			throw new UnsupportedFetcherTypeException("未找到抓取器");
		}
		if (m == null) {
			return null;
		}
		Object[] o = new Object[]{phase, lotteryType};
		try {
			return (List<JczqChampionSecondStaticInstantSpItem>) m.invoke(this, o);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public List<JczqChampionSecondStaticInstantSpItem> fetch(String phase, LotteryType lotteryType) throws UnsupportedFetcherTypeException{
		return fetch(phase, getDefaultFetcherType(), lotteryType);
	}
	
	/**
	 * 获取默认抓取类型
	 * @return
	 */
	abstract protected FetcherType getDefaultFetcherType();

}
