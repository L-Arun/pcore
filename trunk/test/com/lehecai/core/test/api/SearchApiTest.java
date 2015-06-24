/**
 * 
 */
package com.lehecai.core.test.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.api.ApiConfig;
import com.lehecai.core.api.ApiRequestService;
import com.lehecai.core.exception.ApiRemoteCallFailedException;
import com.lehecai.core.service.impl.archive.ArchiveIdServiceImpl;
import com.lehecai.core.type.archive.ArchiveEntityKey;

/**
 * @author Sunshow
 *
 */
public class SearchApiTest {

	protected static final Logger logger = LoggerFactory.getLogger(SearchApiTest.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws ApiRemoteCallFailedException {
		// 初始化config
		ApiConfig config = new ApiConfig();
		config.setBaseUrl("http://search.kemeng.dev.lehecai.com");
		
		ApiRequestService service = new ApiRequestService();
		service.setApiConfig(config);
		
		ArchiveIdServiceImpl archiveIdService = new ArchiveIdServiceImpl();
		archiveIdService.setSearchApiRequestService(service);
		
		//archiveIdService.updateArchiveId(ArchiveEntityKey.TICKET, "481565");
		
		String id = archiveIdService.getArchiveId(ArchiveEntityKey.TICKET);
		
		System.out.println(id);
	}

}
