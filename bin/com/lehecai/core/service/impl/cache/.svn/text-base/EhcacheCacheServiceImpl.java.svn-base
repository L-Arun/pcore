/**
 * 
 */
package com.lehecai.core.service.impl.cache;

import java.io.Serializable;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.CacheException;
import com.lehecai.core.service.cache.CacheService;

/**
 * @author sunshow
 *
 */
public class EhcacheCacheServiceImpl implements CacheService {
	
	protected transient final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private CacheManager cacheManager;
	
	protected Cache getCache(String cacheName) throws CacheException {
		if (cacheManager == null) {
			logger.error("缓存管理器为空");
			throw new CacheException("缓存管理器为空");
		}
		if (!cacheManager.getStatus().equals(Status.STATUS_ALIVE)) {
			logger.error("缓存管理器不在存活状态");
			throw new CacheException("缓存管理器不在存活状态");
		}
		Cache cache = cacheManager.getCache(cacheName);
		if (cache == null) {
			logger.error("未定义的缓存区域");
			throw new CacheException("未定义的缓存区域");
		}
		return cache;
	}

	@Override
	public void remove(String cacheName, String key) throws CacheException {
		Cache cache = this.getCache(cacheName);
		try {
			cache.removeQuiet(key);
		} catch (Exception e) {
			logger.error("删除缓存失败, cache={}, key={}", new Object[] {cacheName, key});
			throw new CacheException("删除缓存失败");
		}
	}

	/* (non-Javadoc)
	 * @see com.lehecai.core.service.cache.CacheService#getObject(java.lang.Class, java.lang.String, java.lang.String)
	 */
	@Override
	public <T> T getObject(Class<T> clazz, String cacheName, String key)
			throws CacheException {
		Cache cache = this.getCache(cacheName);
		try {
			Element element = cache.getQuiet(key);
			if (element == null) {
				logger.warn("未读取到缓存, key={}", key);
				return null;
			}
			T result = clazz.cast(element.getObjectValue());
			return result;
		} catch (ClassCastException e) {
			logger.error("读取到缓存后转换类型失败, cache={}, key={}, clazz={}", new Object[] {cacheName, key, clazz});
			throw new CacheException("读取到缓存后转换类型失败");
		} catch (Exception e) {
			logger.error("读取缓存失败, cache={}, key={}, clazz={}", new Object[] {cacheName, key, clazz});
			throw new CacheException("读取缓存失败");
		}
	}

	/* (non-Javadoc)
	 * @see com.lehecai.core.service.cache.CacheService#getSerializable(java.lang.Class, java.lang.String, java.lang.String)
	 */
	@Override
	public <T extends Serializable> T getSerializable(Class<T> clazz,
			String cacheName, String key) throws CacheException {
		Cache cache = this.getCache(cacheName);
		try {
			Element element = cache.getQuiet(key);
			if (element == null) {
				logger.warn("未读取到缓存, key={}", key);
				return null;
			}
			T result = clazz.cast(element.getValue());
			return result;
		} catch (ClassCastException e) {
			logger.error("读取到缓存后转换类型失败, cache={}, key={}, clazz={}", new Object[] {cacheName, key, clazz});
			throw new CacheException("读取到缓存后转换类型失败");
		} catch (Exception e) {
			logger.error("读取缓存失败, cache={}, key={}, clazz={}", new Object[] {cacheName, key, clazz});
			throw new CacheException("读取缓存失败");
		}
	}

	/* (non-Javadoc)
	 * @see com.lehecai.core.service.cache.CacheService#setObject(java.lang.String, java.lang.String, java.lang.Object)
	 */
	@Override
	public void setObject(String cacheName, String key, Object object)
			throws CacheException {
		Cache cache = this.getCache(cacheName);
		Element element = new Element(key, object);
		try {
			cache.putQuiet(element);
		} catch (Exception e) {
			logger.error("放入缓存失败, cache={}, key={}, obj={}", new Object[] {cacheName, key, object});
			throw new CacheException("放入缓存失败");
		}
	}

	/* (non-Javadoc)
	 * @see com.lehecai.core.service.cache.CacheService#setSerializable(java.lang.String, java.lang.String, java.io.Serializable)
	 */
	@Override
	public void setSerializable(String cacheName, String key,
			Serializable serializableObject) throws CacheException {
		this.setObject(cacheName, key, serializableObject);
	}

	public CacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

}
