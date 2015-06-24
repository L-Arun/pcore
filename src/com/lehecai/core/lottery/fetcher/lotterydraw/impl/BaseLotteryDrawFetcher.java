/**
 * 
 */
package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.util.CoreObjectUtils;

/**
 * 基础开奖结果抓取，抽象，待具体实现
 * @author Sunshow
 *
 */
public abstract class BaseLotteryDrawFetcher implements ILotteryDrawFetcher {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Override
	public LotteryDraw fetch(String phase, FetcherType fetcherType) throws UnsupportedFetcherTypeException {
		if (fetcherType == null) {
			logger.error("抓取器类型不能为空");
			throw new UnsupportedFetcherTypeException("抓取器类型不能为空");
		}
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
			return (LotteryDraw) m.invoke(this, o);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public LotteryDraw fetch(String phase) throws UnsupportedFetcherTypeException {
		return fetch(phase, getDefaultFetcherType());
	}

	/**
	 * 获取默认抓取类型
	 * @return
	 */
	abstract protected FetcherType getDefaultFetcherType();

}
