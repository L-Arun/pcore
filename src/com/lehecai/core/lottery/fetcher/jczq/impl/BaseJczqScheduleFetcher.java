/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jczq.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.FetchFailedException;
import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jczq.IJczqScheduleFetcher;
import com.lehecai.core.lottery.fetcher.jczq.JczqScheduleItem;
import com.lehecai.core.util.CoreObjectUtils;

/**
 * 基础竞彩足球赛程抓取，抽象，待具体实现
 *
 */
public abstract class BaseJczqScheduleFetcher implements IJczqScheduleFetcher {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@SuppressWarnings("unchecked")
	@Override
	public List<JczqScheduleItem> fetch(String officialDate, FetcherType fetcherType) throws UnsupportedFetcherTypeException, FetchFailedException {
		if (fetcherType.getValue() == FetcherType.T_DEFAULT.getValue()) {
			return fetch(officialDate, getDefaultFetcherType());
		}
		Method m;
		try {
			m = CoreObjectUtils.getMethod(getClass(), "fetch" + fetcherType.getName(), new Class[]{String.class});
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
		Object[] o = new Object[]{officialDate};
		try {
			return (List<JczqScheduleItem>) m.invoke(this, o);
		} catch (InvocationTargetException e) {
			Throwable targetException = e.getTargetException();
			if (targetException instanceof FetchFailedException) {
				throw (FetchFailedException)targetException;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public List<JczqScheduleItem> fetch(String officialDate) throws UnsupportedFetcherTypeException, FetchFailedException {
		return fetch(officialDate, getDefaultFetcherType());
	}
	
	/**
	 * 获取默认抓取类型
	 * @return
	 */
	abstract protected FetcherType getDefaultFetcherType();
}
