package com.lehecai.core.service.archive;

import com.lehecai.core.exception.ApiRemoteCallFailedException;
import com.lehecai.core.type.archive.ArchiveEntityKey;

public interface ArchiveIdService {

	/**
	 * 更新指定id到搜索服务器
	 * @param id
	 * @return
	 */
	public void updateArchiveId(ArchiveEntityKey entityKey, String id) throws ApiRemoteCallFailedException;

	/**
	 * 从搜索服务器获取最新归档id
	 * @param entityKey
	 * @return
	 * @throws ApiRemoteCallFailedException
	 */
	public String getArchiveId(ArchiveEntityKey entityKey) throws ApiRemoteCallFailedException;
	
	/**
	 * 从缓存中获取最新归档id，如果缓存不存在，自动建立缓存
	 * @param entityKey
	 * @return
	 * @throws ApiRemoteCallFailedException
	 */
	public String getArchiveIdFromCache(ArchiveEntityKey entityKey) throws ApiRemoteCallFailedException;
}
