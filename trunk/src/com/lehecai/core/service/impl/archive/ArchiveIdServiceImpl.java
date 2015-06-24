/**
 * 
 */
package com.lehecai.core.service.impl.archive;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.api.ApiConstant;
import com.lehecai.core.api.ApiRequest;
import com.lehecai.core.api.ApiRequestService;
import com.lehecai.core.api.ApiResponse;
import com.lehecai.core.api.SearchApiUrlConstant;
import com.lehecai.core.exception.ApiRemoteCallFailedException;
import com.lehecai.core.exception.CacheException;
import com.lehecai.core.service.archive.ArchiveIdService;
import com.lehecai.core.service.cache.CacheService;
import com.lehecai.core.type.archive.ArchiveEntityKey;

/**
 * @author sunshow
 *
 */
public class ArchiveIdServiceImpl implements ArchiveIdService {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private ApiRequestService searchApiRequestService;
	
	private CacheService cacheService;

	private String cacheName;
	
	protected String generateCacheKey(ArchiveEntityKey entityKey) {
		return entityKey.getName();
	}
	
	protected String getArchiveIdFromCacheOnly(ArchiveEntityKey entityKey) {
		String id = null;
		try {
			id = this.getCacheService().getObject(String.class, this.getCacheName(), this.generateCacheKey(entityKey));
		} catch (CacheException e) {
			logger.error("从缓存中读取归档id出错, key={}", this.generateCacheKey(entityKey));
			logger.error(e.getMessage(), e);
		}
		// 从缓存中取到值，直接返回
		return id;
	}
	
	@Override
	public String getArchiveIdFromCache(ArchiveEntityKey entityKey)
			throws ApiRemoteCallFailedException {
		String id = this.getArchiveIdFromCacheOnly(entityKey);
		if (id != null) {
			// 从缓存中取到值，直接返回
			return id;
		}
		
		// 如果未从缓存中取到值
		synchronized (this) {
			// 加锁后先再取一次，保证只被set一次
			id = this.getArchiveIdFromCacheOnly(entityKey);
			if (id != null) {
				// 从缓存中取到值，直接返回
				return id;
			}
			// 如果还未取到值，获取原始数据
			id = this.getArchiveId(entityKey);
			if (id != null) {
				try {
					this.getCacheService().setObject(this.getCacheName(), this.generateCacheKey(entityKey), id);
				} catch (CacheException e) {
					logger.error("设置缓存出错, key={}", this.generateCacheKey(entityKey));
					logger.error(e.getMessage(), e);
				}
				return id;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lehecai.core.service.archive.ArchiveIdService#getArchiveId(com.lehecai.core.common.archive.ArchiveEntityKey)
	 */
	@Override
	public String getArchiveId(ArchiveEntityKey entityKey)
			throws ApiRemoteCallFailedException {
		if (entityKey == null) {
			logger.error("未指定要读取的key");
			return null;
		}
		ApiRequest request = new ApiRequest();
		request.setUrl(SearchApiUrlConstant.SEARCHAPI_ID_GET);
		request.setParameter(ArchiveEntityKey.QUERY_KEY, entityKey.getName());
		
		logger.info("Request Query String: {}", request.toQueryString());
		
		ApiResponse response = this.getSearchApiRequestService().request(request, ApiConstant.API_REQUEST_TIME_OUT_DEFAULT);
		if (response == null) {
			logger.error("API获取归档id失败, key={}", entityKey.getName());
			throw new ApiRemoteCallFailedException("API获取归档id失败");
		}
		if (response.getCode() != ApiConstant.RC_SUCCESS) {
			logger.error("API获取归档id请求出错, rc={}, message={}", response.getCode(), response.getMessage());
			throw new ApiRemoteCallFailedException("API获取归档id请求出错");
		}
		if (response.getData() == null || response.getData().isEmpty()) {
			logger.error("API获取归档id数据为空, message={}", response.getMessage());
			return null;
		}
		
		try {
			JSONObject result = response.getData().getJSONObject(0);

			if (JSONUtils.isNull(result.get(entityKey.getName()))) {
				logger.error("API获取归档id数据返回空, response data={}", response.getData().toString());
				throw new ApiRemoteCallFailedException("API获取归档id数据返回空");
			}

			return result.getString(entityKey.getName());
		} catch (Exception e) {
			logger.error("API获取归档id数据格式不正确, response data={}", response.getData().toString());
			throw new ApiRemoteCallFailedException("API获取归档id数据格式不正确");
		}
	}

	/* (non-Javadoc)
	 * @see com.lehecai.core.service.archive.ArchiveIdService#updateArchiveId(com.lehecai.core.common.archive.ArchiveEntityKey, java.lang.String)
	 */
	@Override
	public void updateArchiveId(ArchiveEntityKey entityKey, String id)
			throws ApiRemoteCallFailedException {
		ApiRequest request = new ApiRequest();
		request.setUrl(SearchApiUrlConstant.SEARCHAPI_ID_SET);
		request.setParameter(ArchiveEntityKey.QUERY_KEY, entityKey.getName());
		request.setParameterForUpdate(ArchiveEntityKey.SET_VALUE, id);
		
		logger.info("Request Query String: {}", request.toQueryString());
		
		ApiResponse response = this.getSearchApiRequestService().request(request, ApiConstant.API_REQUEST_TIME_OUT_DEFAULT);
		
		if (response == null) {
			logger.error("更新归档id失败");
			throw new ApiRemoteCallFailedException("更新归档id失败");
		}
		
		if (response.getCode() != ApiConstant.RC_SUCCESS) {
			logger.error("更新归档id失败,rc={}, message={}", response.getCode(), response.getMessage());
			throw new ApiRemoteCallFailedException("更新归档id失败");
		}
		
		if (response.getData() == null || response.getData().isEmpty()) {
			logger.error("API更新归档id返回结果为空, message={}", response.getMessage());
			throw new ApiRemoteCallFailedException("更新归档id返回结果异常");
		}
		
		if (!JSONUtils.isBoolean(response.getData().get(0)) || !response.getData().getBoolean(0)) {
			logger.error("API更新归档id返回结果失败, message={}", response.getMessage());
			throw new ApiRemoteCallFailedException("更新归档id返回结果失败");
		}
	}

	public ApiRequestService getSearchApiRequestService() {
		return searchApiRequestService;
	}

	public void setSearchApiRequestService(ApiRequestService searchApiRequestService) {
		this.searchApiRequestService = searchApiRequestService;
	}

	public CacheService getCacheService() {
		return cacheService;
	}

	public void setCacheService(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	public String getCacheName() {
		return cacheName;
	}

	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

}
