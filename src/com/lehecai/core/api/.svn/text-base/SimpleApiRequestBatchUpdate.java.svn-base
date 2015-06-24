/**
 * 
 */
package com.lehecai.core.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.util.CharsetConstant;

/**
 * @author sunshow
 *
 */
public class SimpleApiRequestBatchUpdate extends BaseApiRequest {
	
	private JSONObject _request = new JSONObject();
	
	private Map<String, ApiRequestWhere> paramsWhere;
	
	/**
	 * 全局where条件，暂时只支持等于
	 * @param key
	 * @param value
	 */
	public void setParameter(String key, String value) {
		this.setParameter(key, value, ApiConstant.API_OP_EQUAL);
	}
	
	protected void setParameter(String key, String value, String op) {
		synchronized (this) {
			if (paramsWhere == null) {
				paramsWhere = new HashMap<String, ApiRequestWhere>();
			}
		}
		ApiRequestWhere parameter = new ApiRequestWhere(key, value, op);
		paramsWhere.put(key, parameter);
	}
	
	public void add(IApiBatchUpdateItem item) {
		_request.put(item.getKey(), item.getValues());
	}
	
	public boolean isEmpty() {
		return _request.keySet().size() == 0;
	}
	
	/* (non-Javadoc)
	 * @see com.lehecai.core.api.BaseApiRequest#toQueryString()
	 */
	@Override
	public String toQueryString() {
		StringBuffer sb = new StringBuffer(ApiConstant.API_REQUEST_PARAMETER_NAME);
		
		
		JSONObject json = new JSONObject();
		json.put(ApiConstant.API_REQUEST_MSET_NAME, _request);

		if (paramsWhere != null) {
			JSONArray whereArray = new JSONArray();
			for (Iterator<String> iterator = paramsWhere.keySet().iterator(); iterator.hasNext();) {
				String key = iterator.next();
				whereArray.add(paramsWhere.get(key).toJSONObject());
			}
			json.put(ApiConstant.API_REQUEST_WHERE_NAME, whereArray);
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