package com.lehecai.core.lottery.fetcher.dc.impl;

import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.dc.ISfggInstantSPFetcher;
import com.lehecai.core.lottery.fetcher.dc.SfggInstantSPItem;
import com.lehecai.core.util.CoreObjectUtils;

public abstract class BaseSfggInstantSPFetcher implements ISfggInstantSPFetcher {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Override
	public List<SfggInstantSPItem> fetch(String phase) {
		return this.fetch(phase, this.getDefaultFetcherType());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SfggInstantSPItem> fetch(String phase, FetcherType fetcherType) {
		if (fetcherType.getValue() == FetcherType.T_DEFAULT.getValue()) {
			return fetch(phase, getDefaultFetcherType());
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
		}
		if (m == null) {
			return null;
		}
		Object[] o = new Object[]{phase};
		try {
			return (List<SfggInstantSPItem>) m.invoke(this, o);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * 获取默认抓取类型
	 * @return
	 */
	abstract protected FetcherType getDefaultFetcherType();
	
}
