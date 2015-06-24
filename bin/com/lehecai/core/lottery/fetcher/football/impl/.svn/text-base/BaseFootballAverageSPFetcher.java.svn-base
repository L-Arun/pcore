package com.lehecai.core.lottery.fetcher.football.impl;

import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.football.FootballAverageSPItem;
import com.lehecai.core.lottery.fetcher.football.IFootballAverageSPFetcher;
import com.lehecai.core.util.CoreObjectUtils;

public abstract class BaseFootballAverageSPFetcher implements IFootballAverageSPFetcher {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Override
	public List<FootballAverageSPItem> fetch(String phase)
			throws UnsupportedFetcherTypeException {
		return this.fetch(phase, this.getDefaultFetcherType());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FootballAverageSPItem> fetch(String phase,
			FetcherType fetcherType) throws UnsupportedFetcherTypeException {
		if(fetcherType.getName() == FetcherType.T_DEFAULT.getName()){
			return this.fetch(phase, this.getDefaultFetcherType());
		}
		Method method = null;
		try {
			method = CoreObjectUtils.getMethod(this.getClass(), "fetch"+fetcherType.getName(), new Class[]{String.class});
		} catch (SecurityException e) {
			method = null;
			logger.error(e.getMessage(),e);
		} catch (NoSuchMethodException e) {
			method = null;
			logger.error("未找到({})的抓取器", fetcherType.getName());
			throw new UnsupportedFetcherTypeException("未找到抓取器");
		}
		
		if( method != null){
			try {
				return (List<FootballAverageSPItem>) method.invoke(this, new Object[]{phase});
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				return null;
			} 
		}
		
		return null;
	}
	
	/**
	 * 获取默认抓取类型
	 * @return FetcherType
	 */
	abstract protected FetcherType getDefaultFetcherType();

	/**
	 * 从500Wan中抓取足彩平均欧赔
	 * @param phase
	 * @return
	 */
	abstract protected List<FootballAverageSPItem> fetch500Wan(String phase);
}
