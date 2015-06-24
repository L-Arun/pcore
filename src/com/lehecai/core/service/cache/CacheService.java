package com.lehecai.core.service.cache;

import java.io.Serializable;

import com.lehecai.core.exception.CacheException;

public interface CacheService {
	
	/**
	 * 删除缓存
	 * @param cacheName
	 * @param key
	 * @throws CacheException
	 */
	public void remove(String cacheName, String key) throws CacheException;

	/**
	 * 设置可序列化的对象
	 * @param cacheName
	 * @param key
	 * @param serializableObject
	 * @throws CacheException
	 */
	public void setSerializable(String cacheName, String key, Serializable serializableObject) throws CacheException;
	
	/**
	 * 以序列化方式读取缓存对象
	 * @param <T>
	 * @param clazz
	 * @param cacheName
	 * @param key
	 * @return
	 * @throws CacheException
	 */
	public <T extends Serializable> T getSerializable(Class<T> clazz, String cacheName, String key) throws CacheException;
	
	/**
	 * 缓存不支持序列化的对象
	 * @param cacheName
	 * @param key
	 * @param object
	 * @throws CacheException
	 */
	public void setObject(String cacheName, String key, Object object) throws CacheException;
	
	/**
	 * 读取不支持序列化的缓存对象
	 * @param <T>
	 * @param clazz
	 * @param cacheName
	 * @param key
	 * @return
	 * @throws CacheException
	 */
	public <T> T getObject(Class<T> clazz, String cacheName, String key) throws CacheException;
}
