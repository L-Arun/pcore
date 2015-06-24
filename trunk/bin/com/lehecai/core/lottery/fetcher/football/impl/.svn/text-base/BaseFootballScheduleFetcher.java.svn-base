package com.lehecai.core.lottery.fetcher.football.impl;

import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.football.FootballScheduleItem;
import com.lehecai.core.lottery.fetcher.football.IFootballScheduleFetcher;
import com.lehecai.core.util.CoreObjectUtils;

/**
 * 基础足球赛程抓取 抽象类
 * @author leiming
 *
 */
public abstract class BaseFootballScheduleFetcher implements IFootballScheduleFetcher{
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	protected LotteryType lotteryType;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FootballScheduleItem> fetch(String phase, FetcherType fetcherType) throws UnsupportedFetcherTypeException{
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
			return (List<FootballScheduleItem>) m.invoke(this, o);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public List<FootballScheduleItem> fetch(String phase) throws UnsupportedFetcherTypeException{
		return fetch(phase, getDefaultFetcherType());
	}
	
	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}
	public LotteryType getLotteryType() {
		return lotteryType;
	}
	
	/**
	 * 获取默认抓取类型
	 * @return
	 */
	abstract protected FetcherType getDefaultFetcherType();
	/**
	 * 从500Wan抓取足球赛程结果数据
	 * @param phase
	 * @return
	 */
	abstract protected List<FootballScheduleItem> fetch500Wan(String phase);
	/**
	 * 从官方抓取彩票结果数据
	 * @param phase
	 * @return
	 * @2011-3-30
	 */
	abstract protected List<FootballScheduleItem> fetchOkooo(String phase);
}
