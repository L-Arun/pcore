/**
 * 
 */
package com.lehecai.core.lottery.lotteryconfig;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;

/**
 * 彩票配置封装对象
 * json format: {"resultConfigList":resultArray,"prizeItemList":resultDetailArray}
 * @author leiming
 */
public class LotteryConfigTemplateObject extends AbstractApiResultBean {
	private String resultArray;//数据库中json数组格式的字符串
	private String resultDetailArray;//数据库中json数组格式的字符串
	private List<ResultTemplateItem> resultItemList;
	private List<ResultDetailTemplateItem> resultDetailItemList;
	
	//json string key name
	public static final String JSON_KEYNAME_RESULT = "resultConfigList";
	public static final String JSON_KEYNAME_RESULTDETAIL = "prizeItemList";
	
	
	public String toJSONString() {
		JSONObject object = new JSONObject();
		object.put(JSON_KEYNAME_RESULT, resultArray);
		object.put(JSON_KEYNAME_RESULTDETAIL, resultDetailArray);
		
		return object.toString();
	}
	public JSONObject toJSON() {
		JSONObject object = new JSONObject();
		object.put(JSON_KEYNAME_RESULT, resultArray);
		object.put(JSON_KEYNAME_RESULTDETAIL, resultDetailArray);
		return object;
	}
	
	public static LotteryConfigTemplateObject convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		LotteryConfigTemplateObject item = new LotteryConfigTemplateObject();
		item.resultArray = getString(object, JSON_KEYNAME_RESULT);
		item.resultDetailArray = getString(object, JSON_KEYNAME_RESULTDETAIL);
		//解析开奖结果数组
		JSONArray resultJsonArray = getArray(object, JSON_KEYNAME_RESULT);
		item.resultItemList = ResultTemplateItem.convertFromJSONArray(resultJsonArray);
		//解析开奖详情数组
		JSONArray resultDetailJsonArray = getArray(object, JSON_KEYNAME_RESULTDETAIL);
		item.resultDetailItemList = ResultDetailTemplateItem.convertFromJSONArray(resultDetailJsonArray);
		
		return item;
	}
	@SuppressWarnings("unchecked")
	public static List<LotteryConfigTemplateObject> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		logger.info(array.toString());
		List<LotteryConfigTemplateObject> list = new ArrayList<LotteryConfigTemplateObject>();
		LotteryConfigTemplateObject lotteryConfigTemplateObject = null;
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			lotteryConfigTemplateObject = convertFromJSONObject(object);
			if(lotteryConfigTemplateObject!=null){
				list.add(lotteryConfigTemplateObject);
			}
		}
		return list;
	}
	
	public String getResultArray() {
		return resultArray;
	}
	public void setResultArray(String resultArray) {
		this.resultArray = resultArray;
	}
	public String getResultDetailArray() {
		return resultDetailArray;
	}
	public void setResultDetailArray(String resultDetailArray) {
		this.resultDetailArray = resultDetailArray;
	}
	public List<ResultTemplateItem> getResultItemList() {
		return resultItemList;
	}
	public void setResultItemList(List<ResultTemplateItem> resultItemList) {
		this.resultItemList = resultItemList;
	}
	public List<ResultDetailTemplateItem> getResultDetailItemList() {
		return resultDetailItemList;
	}
	public void setResultDetailItemList(
			List<ResultDetailTemplateItem> resultDetailItemList) {
		this.resultDetailItemList = resultDetailItemList;
	}
}
