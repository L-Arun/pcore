/**
 * 
 */
package com.lehecai.core.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.util.CharsetConstant;

/**
 * @author Sunshow
 *
 */
public class ApiRequest extends BaseApiRequest {
	
	private Map<String, ApiRequestWhere> paramsWhere;
	private Map<String, ApiRequestSet> paramsSet;
	private List<ApiRequestOrder> orders;
	private ApiRequestRange range;
	private ApiRequestSelect select;
	
	private int page;
	private int pagesize;
	
	public void setParameterForUpdate(String key, String value) {
		if (paramsSet == null) {
			synchronized (this) {
				if (paramsSet == null) {
					paramsSet = new HashMap<String, ApiRequestSet>();
				}
			}
		}
		ApiRequestSet parameter = new ApiRequestSet(key, value);
		paramsSet.put(key, parameter);
	}
	
	public void setParameter(String key, String value) {
		this.setParameter(key, value, ApiConstant.API_OP_EQUAL);
	}
	
	public void setParameter(String key, String value, String op) {
		ApiRequestWhere where = new ApiRequestWhere(key, value, op);
		this.setParameter(key, where);
	}
	
	public void setParameterIn(String key, List<String> values) {
		ApiRequestWhere where = new ApiRequestWhere(key, values);
		this.setParameter(key, where);
	}
	
	public void setParameter(String key, ApiRequestWhere where) {
		if (paramsWhere == null) {
			synchronized (this) {
				if (paramsWhere == null) {
					paramsWhere = new HashMap<String, ApiRequestWhere>();
				}
			}
		}
		paramsWhere.put(key, where);
	}
	
	public void setParameterLike(String key, String value) {
		this.setParameter(key, value, ApiConstant.API_OP_LIKE);
	}
	
	public void setParameterLess(String key, String value) {
		if (value != null) {
			setParameter(key + ApiConstant.API_OP_BETWEEN_END, value, ApiConstant.API_OP_LESS);
		}
	}
	
	public void setParameterGreater(String key, String value) {
		if (value != null) {
			setParameter(key + ApiConstant.API_OP_BETWEEN_START, value, ApiConstant.API_OP_GREATER);
		}
	}
	
	public void setParameterBetween(String key, String lowVal, String highVal) {
		if (lowVal != null) {
			setParameter(key + ApiConstant.API_OP_BETWEEN_START, lowVal);
		}
		if (highVal != null) {
			setParameter(key + ApiConstant.API_OP_BETWEEN_END, highVal);
		}
	}
	
	public void addOrder(String field) {
		this.addOrder(field, ApiConstant.API_REQUEST_ORDER_ASC);
	}
	
	public void addOrder(String field, String orderIndex) {
		ApiRequestOrder order = new ApiRequestOrder(field, orderIndex);
		this.addOrder(order);
	}
	
	public void addOrder(ApiRequestOrder order) {
		if (orders == null) {
			synchronized (this) {
				if (orders == null) {
					orders = new ArrayList<ApiRequestOrder>();
				}
			}
		}
		orders.add(order);
	}
	
	public void addOrder(List<ApiRequestOrder> orderList) {
		orders = orderList;
	}
	
	public ApiRequestRange getRange() {
		return range;
	}

	public void setRange(ApiRequestRange range) {
		this.range = range;
	}

	public ApiRequestSelect getSelect() {
		return select;
	}

	public void setSelect(ApiRequestSelect select) {
		this.select = select;
	}

	@Override
	public String toQueryString() {
		StringBuffer sb = new StringBuffer(ApiConstant.API_REQUEST_PARAMETER_NAME);
		
		JSONObject json = new JSONObject();
		json.put(ApiConstant.API_REQUEST_PAGE_NAME, page == 0 ? 1 : page);
		json.put(ApiConstant.API_REQUEST_PAGESIZE_NAME, pagesize == 0 ? ApiConstant.API_REQUEST_PAGESIZE_DEFAULT : pagesize);
		
		if (paramsWhere != null) {
			JSONArray whereArray = new JSONArray();
			for (Iterator<String> iterator = paramsWhere.keySet().iterator(); iterator.hasNext();) {
				String key = iterator.next();
				whereArray.add(paramsWhere.get(key).toJSONObject());
			}
			json.put(ApiConstant.API_REQUEST_WHERE_NAME, whereArray);
		}
		
		if (paramsSet != null) {
			JSONArray setArray = new JSONArray();
			for (Iterator<String> iterator = paramsSet.keySet().iterator(); iterator.hasNext();) {
				String key = iterator.next();
				setArray.add(paramsSet.get(key).toJSONObject());
			}
			json.put(ApiConstant.API_REQUEST_SET_NAME, setArray);
		}
		
		if (orders != null) {
			JSONArray orderArray = new JSONArray();
			for (Iterator<ApiRequestOrder> iterator = orders.iterator(); iterator.hasNext();) {
				ApiRequestOrder order = iterator.next();
				orderArray.add(order.toJSONObject());
			}
			json.put(ApiConstant.API_REQUEST_ORDER_NAME, orderArray);
		}
		
		if (range != null) {
			json.put(ApiConstant.API_REQUEST_RANGE_NAME, range.toJSONObject().toString());
		}
		
		if (select != null) {
			json.put(ApiConstant.API_REQUEST_SELECT_NAME, select.toString());
		}
		
		try {
			sb.append("=").append(URLEncoder.encode(json.toString(), CharsetConstant.CHARSET_UTF8));
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
			return null;
		}
		
		return sb.toString();
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
}
