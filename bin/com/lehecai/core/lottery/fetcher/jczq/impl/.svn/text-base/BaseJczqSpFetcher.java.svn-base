/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jczq.impl;

import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jczq.IJczqSpFetcher;
import com.lehecai.core.lottery.fetcher.jczq.JczqSpItem;
import com.lehecai.core.util.CoreObjectUtils;

/**
 * 基础竞彩足球sp抓取，抽象，待具体实现
 *
 */
public abstract class BaseJczqSpFetcher implements IJczqSpFetcher {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@SuppressWarnings("unchecked")
	@Override
	public List<JczqSpItem> fetch(String officialDate, FetcherType fetcherType) throws UnsupportedFetcherTypeException{
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
			return (List<JczqSpItem>) m.invoke(this, o);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public List<JczqSpItem> fetch(String officialDate) throws UnsupportedFetcherTypeException{
		return fetch(officialDate, getDefaultFetcherType());
	}
	
	/**
	 * 获取默认抓取类型
	 * @return
	 */
	abstract protected FetcherType getDefaultFetcherType();

}
