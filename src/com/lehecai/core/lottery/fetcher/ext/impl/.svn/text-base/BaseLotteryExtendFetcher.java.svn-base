package com.lehecai.core.lottery.fetcher.ext.impl;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.ext.ILotteryExtendFetcher;
import com.lehecai.core.lottery.fetcher.ext.LotteryExtendItem;
import com.lehecai.core.util.CoreObjectUtils;

/**
 * 抓取扩展信息的几类
 * @author 唐容
 *
 */
public abstract class BaseLotteryExtendFetcher implements ILotteryExtendFetcher {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Override
	public LotteryExtendItem fetch(String phase) throws UnsupportedFetcherTypeException {
		return this.fetch(phase, FetcherType.T_ZJOL);
	}

	@Override
	public LotteryExtendItem fetch(String phase, FetcherType fetcherType)
			throws UnsupportedFetcherTypeException {
		Method m;
		try {
			m = CoreObjectUtils.getMethod(this.getClass(), "fetch" + fetcherType.getName(), new Class[]{String.class});
		} catch (SecurityException e) {
			m = null;
			logger.error(e.getMessage(),e);
		} catch (NoSuchMethodException e) {
			m = null;
			logger.error(e.getMessage(),e);
		}
		try {
			return (LotteryExtendItem) m.invoke(this, new Object[]{phase});
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return null;
		} 
	}
	
	/**
	 * 获取默认的抓取类型
	 * @return
	 */
	abstract protected FetcherType getDefaultFetcherType();

}
