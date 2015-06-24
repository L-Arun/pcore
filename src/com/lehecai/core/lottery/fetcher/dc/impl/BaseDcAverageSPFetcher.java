package com.lehecai.core.lottery.fetcher.dc.impl;

import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.dc.DcAverageSPItem;
import com.lehecai.core.lottery.fetcher.dc.IDcAverageSPFetcher;
import com.lehecai.core.util.CoreObjectUtils;

public abstract class BaseDcAverageSPFetcher implements IDcAverageSPFetcher {

	protected Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Override
	public List<DcAverageSPItem> fetch(String phase)
			throws UnsupportedFetcherTypeException {
		return this.fetch(phase,FetcherType.T_DEFAULT);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DcAverageSPItem> fetch(String phase, FetcherType fetcherType)
			throws UnsupportedFetcherTypeException {
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
			return (List<DcAverageSPItem>) m.invoke(this, o);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	/**
	 * 获取默认抓取类型
	 * @return FetcherType 默认的抓取类型
	 */
	abstract protected FetcherType getDefaultFetcherType();
	
	/**
	 * 从500万网站中抓取北单的平均欧赔
	 * @param phase 彩期号
	 * @return List<DcAverageSPItem> 平均欧赔项列表                          
	 */
	abstract protected List<DcAverageSPItem> fetch500Wan(String phase);

}
