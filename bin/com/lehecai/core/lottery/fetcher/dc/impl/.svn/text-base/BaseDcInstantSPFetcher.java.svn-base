package com.lehecai.core.lottery.fetcher.dc.impl;

import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.dc.DcInstantSPItem;
import com.lehecai.core.lottery.fetcher.dc.IDcInstantSPFetcher;
import com.lehecai.core.util.CoreObjectUtils;

public abstract class BaseDcInstantSPFetcher implements IDcInstantSPFetcher {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Override
	public List<DcInstantSPItem> fetch(String phase,LotteryType lotteryType) {
		return this.fetch(phase, this.getDefaultFetcherType(), lotteryType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DcInstantSPItem> fetch(String phase, FetcherType fetcherType ,LotteryType lotteryType) {
		if (fetcherType.getValue() == FetcherType.T_DEFAULT.getValue()) {
			return fetch(phase, getDefaultFetcherType(),lotteryType);
		}
		Method m;
		try {
			m = CoreObjectUtils.getMethod(getClass(), "fetch" + fetcherType.getName(), new Class[]{String.class,LotteryType.class});
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
		Object[] o = new Object[]{phase,lotteryType};
		try {
			return (List<DcInstantSPItem>) m.invoke(this, o);
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
