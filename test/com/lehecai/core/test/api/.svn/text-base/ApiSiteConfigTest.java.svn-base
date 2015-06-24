/**
 * 
 */
package com.lehecai.core.test.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.api.ApiConfig;
import com.lehecai.core.api.ApiConstant;
import com.lehecai.core.api.ApiRequest;
import com.lehecai.core.api.ApiRequestService;
import com.lehecai.core.api.ApiResponse;
import com.lehecai.core.api.base.SiteConfig;
import com.lehecai.core.exception.ApiRemoteCallFailedException;

/**
 * @author Sunshow
 *
 */
public class ApiSiteConfigTest {

	private static final Logger logger = LoggerFactory.getLogger(ApiSiteConfigTest.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws ApiRemoteCallFailedException {
		// 初始化config
		ApiConfig config = new ApiConfig();
		config.setBaseUrl("http://internal.a.dev.lehecai.com/");
		
		ApiRequest request = new ApiRequest();
		request.setUrl(ApiConstant.API_URL_BASE_SITE_CONFIG);
		logger.info("Request Query String: {}", request.toQueryString());
		
		ApiRequestService service = new ApiRequestService();
		service.setApiConfig(config);
		
		ApiResponse response = service.request(request, ApiConstant.API_REQUEST_TIME_OUT_DEFAULT);
		List<SiteConfig> list = SiteConfig.convertFromJSONArray(response.getData());
		SiteConfig siteConfig = list.get(0);
		System.out.println(siteConfig.getRootCSS());
	}

}
