/**
 * 
 */
package com.lehecai.core.lottery.fetcher.dc.impl;

import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.dc.DcScheduleItem;
import com.lehecai.core.lottery.fetcher.dc.IDcScheduleFetcher;
import com.lehecai.core.util.CoreObjectUtils;

/**
 * 基础北单赛程抓取，抽象，待具体实现
 *
 */
public abstract class BaseDcScheduleFetcher implements IDcScheduleFetcher {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@SuppressWarnings("unchecked")
	@Override
	public List<DcScheduleItem> fetch(String phase, FetcherType fetcherType) throws UnsupportedFetcherTypeException{
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
			throw new UnsupportedFetcherTypeException("未找到抓取器");
		}
		if (m == null) {
			return null;
		}
		Object[] o = new Object[]{phase};
		try {
			return (List<DcScheduleItem>) m.invoke(this, o);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public List<DcScheduleItem> fetch(String phase) throws UnsupportedFetcherTypeException{
		return fetch(phase, getDefaultFetcherType());
	}
	
	/**
	 * 获取默认抓取类型
	 * @return
	 */
	abstract protected FetcherType getDefaultFetcherType();
	/**
	 * 从爱波抓取北单赛程
	 * @param phase
	 * @return
	 */
	abstract protected List<DcScheduleItem> fetchAIBO(String phase);
	
	/**
	 * 从500万种抓取北单赛程
	 * @param phase
	 * @return
	 */
	abstract protected List<DcScheduleItem> fetch500Wan(String phase);

}
