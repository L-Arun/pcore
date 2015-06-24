/**
 * 
 */
package com.lehecai.core.test.api;

import net.sf.json.JSONObject;

import com.lehecai.core.api.ApiConfig;
import com.lehecai.core.api.ApiRequestService;
import com.lehecai.core.exception.ApiRemoteCallFailedException;
import com.lehecai.core.service.impl.setting.ApiSettingServiceImpl;

/**
 * @author Sunshow
 *
 */
public class ApiSettingTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ApiRemoteCallFailedException {
		ApiConfig config = new ApiConfig();
		config.setBaseUrl("http://a.dev.lehecai.cn");
		
		ApiRequestService service = new ApiRequestService();
		service.setApiConfig(config);
		
		ApiSettingServiceImpl settingService = new ApiSettingServiceImpl();
		settingService.setApiRequestService(service);
		
		String group = "test";
		String item = "setting";

		settingService.add(group, item);
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("name", "sunshow");
		
		settingService.update(group, item, jsonObject.toString());
		
		String value = settingService.get(group, item);
		
		System.out.println("value=" + value);
		
		String noExist = settingService.get("aa", "bb");
		
		System.out.println("noExist=" + noExist);
		
		settingService.update("aa", "bb", jsonObject.toString());
		
		noExist = settingService.get("aa", "bb");
		
		System.out.println("update noExist=" + noExist);
	}

}
