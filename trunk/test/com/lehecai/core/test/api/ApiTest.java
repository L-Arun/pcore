/**
 * 
 */
package com.lehecai.core.test.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.api.ApiConfig;
import com.lehecai.core.api.ApiConstant;
import com.lehecai.core.api.ApiRequest;
import com.lehecai.core.api.ApiRequestService;
import com.lehecai.core.api.ApiResponse;
import com.lehecai.core.api.user.Member;
import com.lehecai.core.api.user.Wallet;
import com.lehecai.core.exception.ApiRemoteCallFailedException;

/**
 * @author Sunshow
 *
 */
public class ApiTest {

	private static final Logger logger = LoggerFactory.getLogger(ApiTest.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws ApiRemoteCallFailedException {
		// 初始化config
		ApiConfig config = new ApiConfig();
		config.setBaseUrl("http://a.dev.lehecai.cn/control/admin");
		
		// 生成请求任务
		List<String> uids = new ArrayList<String>();
		uids.add("1");
		
		ApiRequest request = new ApiRequest();
		request.setUrl(ApiConstant.API_URL_MEMBER_QUERY);
		//request.setParameterIn(Member.QUERY_UID, uids);
		//request.setParameter(Member.QUERY_USERNAME, "sskaje");
		request.setParameterLike(Member.QUERY_USERNAME, "s" + ApiConstant.API_WILDCARD_MATCH_ANY);
		request.addOrder(Member.ORDER_UID, ApiConstant.API_REQUEST_ORDER_DESC);
		request.setPage(1);
		request.setPagesize(ApiConstant.API_REQUEST_PAGESIZE_DEFAULT);
		logger.info("Request Query String: {}", request.toQueryString());
		
		ApiRequestService service = new ApiRequestService();
		service.setApiConfig(config);
		
		ApiResponse response = service.request(request, ApiConstant.API_REQUEST_TIME_OUT_DEFAULT);
		List<Member> list = Member.convertFromJSONArray(response.getData());
		for (Iterator<Member> iterator = list.iterator(); iterator.hasNext();) {
			Member member = iterator.next();
			logger.info("Member id={},username={}", member.getUid(), member.getUsername());
			logger.info("Source id={}, name={}", member.getSourceId(), member.getSource());
			for (Iterator<Wallet> iterator2 = member.getWalletList().iterator(); iterator2.hasNext();) {
				Wallet wallet = iterator2.next();
				logger.info("==== Wallety type={},name={}", wallet.getType().getValue(), wallet.getType().getName());
			}
		}
	}

}
