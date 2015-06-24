/**
 * 
 */
package com.lehecai.core.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.util.CharsetConstant;

/**
 * @author yanweijie
 *
 */
public class SimpleApiRequestBatchQuery extends BaseApiRequest {
	
	private List<IApiBatchQueryItem> _request;

	public void add(IApiBatchQueryItem item) {
		synchronized (this) {
			if (_request == null) {
				_request = new ArrayList<IApiBatchQueryItem>();
			}
		}
		_request.add(item);
	}

	@Override
	public String toQueryString() {
		StringBuffer sb = new StringBuffer(ApiConstant.API_REQUEST_PARAMETER_NAME);
		
		JSONObject json = new JSONObject();
		
		if (_request != null) {
			JSONArray mgetArray = new JSONArray();
			for (IApiBatchQueryItem iApiBatchQueryItem : _request) {
				List<ApiRequestWhere> groupItemList = iApiBatchQueryItem.getValues();
				JSONArray lotteryArray = new JSONArray();
				for (ApiRequestWhere apiRequestWhere : groupItemList) {
					lotteryArray.add(apiRequestWhere.toJSONObject());
				}
				mgetArray.add(lotteryArray);
			}
			json.put(ApiConstant.API_REQUEST_MGET_NAME, mgetArray);
		}
		
		try {
			sb.append("=").append(URLEncoder.encode(json.toString(), CharsetConstant.CHARSET_UTF8));
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
			return null;
		}
		
		return sb.toString();
	}
}
