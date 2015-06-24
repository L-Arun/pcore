/**
 * 
 */
package com.lehecai.core.service.impl.lottery;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.api.lottery.LotteryConfig;
import com.lehecai.core.exception.CacheException;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.lotteryconfig.LotteryConfigCacheBuilder;
import com.lehecai.core.service.cache.CacheService;
import com.lehecai.core.service.lottery.LotteryCommonService;

/**
 * @author sunshow
 *
 */
public class LotteryCommonServiceImpl implements LotteryCommonService {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private CacheService cacheService;

	private String lotteryConfigCacheName;
	
	private LotteryConfigCacheBuilder lotteryConfigCacheBuilder;
	
	protected String generateLotteryConfigCacheKey(LotteryType lotteryType) {
		return String.valueOf(lotteryType.getValue());
	}
	
	protected LotteryConfig getLotteryConfigFromCacheOnly(LotteryType lotteryType) {
		LotteryConfig lotteryConfig = null;
		try {
			lotteryConfig = this.getCacheService().getObject(LotteryConfig.class, this.getLotteryConfigCacheName(), this.generateLotteryConfigCacheKey(lotteryType));
		} catch (CacheException e) {
			logger.error("从缓存中读取彩种配置出错, key={}", this.generateLotteryConfigCacheKey(lotteryType));
			logger.error(e.getMessage(), e);
		}
		// 从缓存中取到值，直接返回
		return lotteryConfig;
	}
	
	/* (non-Javadoc)
	 * @see com.lehecai.core.service.lottery.LotteryCommonService#getLotteryConfig(com.lehecai.core.lottery.LotteryType)
	 */
	@Override
	public LotteryConfig getLotteryConfig(LotteryType lotteryType) {
		return this.getLotteryConfigCacheBuilder().build(lotteryType);
	}

	@Override
	public void removeAllLotteryConfigCache() {
		List<LotteryType> lotteryTypeList = LotteryType.getItems();
		for (LotteryType lotteryType : lotteryTypeList) {
			try {
				this.getCacheService().remove(this.getLotteryConfigCacheName(), this.generateLotteryConfigCacheKey(lotteryType));
			} catch (CacheException e) {
				logger.error("删除缓存出错, key={}", this.generateLotteryConfigCacheKey(lotteryType));
				logger.error(e.getMessage(), e);
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.lehecai.core.service.lottery.LotteryCommonService#getLotteryConfigFromCache(com.lehecai.core.lottery.LotteryType)
	 */
	@Override
	public LotteryConfig getLotteryConfigFromCache(LotteryType lotteryType) {
		LotteryConfig lotteryConfig = this.getLotteryConfigFromCacheOnly(lotteryType);
		if (lotteryConfig != null) {
			// 从缓存中取到值，直接返回
			return lotteryConfig;
		}
		
		// 如果未从缓存中取到值
		synchronized (this) {
			// 加锁后先再取一次，保证只被set一次
			lotteryConfig = this.getLotteryConfigFromCacheOnly(lotteryType);
			if (lotteryConfig != null) {
				// 从缓存中取到值，直接返回
				return lotteryConfig;
			}

			// 如果还未取到值，获取原始数据
			lotteryConfig = this.getLotteryConfig(lotteryType);
			if (lotteryConfig != null) {
				try {
					this.getCacheService().setObject(this.getLotteryConfigCacheName(), this.generateLotteryConfigCacheKey(lotteryType), lotteryConfig);
				} catch (CacheException e) {
					logger.error("设置缓存出错, key={}", this.generateLotteryConfigCacheKey(lotteryType));
					logger.error(e.getMessage(), e);
				}
			}
			
			return lotteryConfig;
		}
	}

	public CacheService getCacheService() {
		return cacheService;
	}

	public void setCacheService(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	public String getLotteryConfigCacheName() {
		return lotteryConfigCacheName;
	}

	public void setLotteryConfigCacheName(String lotteryConfigCacheName) {
		this.lotteryConfigCacheName = lotteryConfigCacheName;
	}

	public LotteryConfigCacheBuilder getLotteryConfigCacheBuilder() {
		return lotteryConfigCacheBuilder;
	}

	public void setLotteryConfigCacheBuilder(
			LotteryConfigCacheBuilder lotteryConfigCacheBuilder) {
		this.lotteryConfigCacheBuilder = lotteryConfigCacheBuilder;
	}

}
