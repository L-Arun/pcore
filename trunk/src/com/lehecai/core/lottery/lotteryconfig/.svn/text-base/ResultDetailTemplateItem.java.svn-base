/**
 * 
 */
package com.lehecai.core.lottery.lotteryconfig;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.EnabledStatus;
import com.lehecai.core.YesNoStatus;
import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.api.lottery.LotteryConfig;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDrawPrizeItem;

/**
 * 开奖结果详情模板项  key 不可重复   name不可重复
 * json format: {"key":"prize1","name":"一等奖","default_prize":"10000"}
 * @author leiming
 *
 */
public class ResultDetailTemplateItem extends AbstractApiResultBean {
	private String key;					//奖级定义    如 prize1   注意:同彩票下不可重复
	private String name;				//奖级名称    如一等奖
	
	private Double defaultPrizeAmount;	//默认奖金金额   如10000   
	private EnabledStatus usable;				//奖级是否可用  1可用,0不可用,默认值为可用
	private YesNoStatus staticPrize;//是否为固定奖金
	private YesNoStatus notify;//是否需要作为大奖通知
	
	private final static String JSON_KEYNAME_KEY = "key";
	private final static String JSON_KEYNAME_NAME = "name";
	private final static String JSON_KEYNAME_DEFAULTPRIZEAMOUNT = "default_prize";
	private final static String JSON_KEYNAME_USABLE = "usable";
	private static final String JSON_KEYNAME_STATIC_PRIZE = "static_prize";
	private static final String JSON_KEYNAME_NOTIFY = "notify";

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDefaultPrizeAmount() {
		return defaultPrizeAmount;
	}

	public void setDefaultPrizeAmount(Double defaultPrizeAmount) {
		this.defaultPrizeAmount = defaultPrizeAmount;
	}
	
	public EnabledStatus getUsable() {
		return usable;
	}

	public void setUsable(EnabledStatus usable) {
		this.usable = usable;
	}

	public YesNoStatus getStaticPrize() {
		return staticPrize;
	}

	public void setStaticPrize(YesNoStatus staticPrize) {
		this.staticPrize = staticPrize;
	}

	public YesNoStatus getNotify() {
		return notify;
	}

	public void setNotify(YesNoStatus notify) {
		this.notify = notify;
	}

	public String toJSONString() {
		return toJSON().toString();
	}
	public JSONObject toJSON() {
		JSONObject object = new JSONObject();
		object.put(JSON_KEYNAME_KEY, key);
		object.put(JSON_KEYNAME_NAME, name);
		
		if (defaultPrizeAmount != null && defaultPrizeAmount != 0) {
			object.put(JSON_KEYNAME_DEFAULTPRIZEAMOUNT, defaultPrizeAmount);
		}
		if(usable == null){
			object.put(JSON_KEYNAME_USABLE, EnabledStatus.ENABLED.getValue());
		}else{
			object.put(JSON_KEYNAME_USABLE, usable.getValue());
		}
		if(staticPrize == null){
			object.put(JSON_KEYNAME_STATIC_PRIZE, YesNoStatus.NO.getValue());
		}else{
			object.put(JSON_KEYNAME_STATIC_PRIZE, staticPrize.getValue());
		}
		if(notify == null){
			object.put(JSON_KEYNAME_NOTIFY, YesNoStatus.NO.getValue());
		}else{
			object.put(JSON_KEYNAME_NOTIFY, notify.getValue());
		}
		return object;
	}
	
	public static ResultDetailTemplateItem convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		ResultDetailTemplateItem item = new ResultDetailTemplateItem();
		item.key = getString(object, JSON_KEYNAME_KEY);
		item.name = getString(object, JSON_KEYNAME_NAME);
		
		String defaultPrizeAmountStr = getString(object, JSON_KEYNAME_DEFAULTPRIZEAMOUNT);
		try {
			if(defaultPrizeAmountStr!=null&&(!defaultPrizeAmountStr.isEmpty())){
				item.defaultPrizeAmount = Double.valueOf(defaultPrizeAmountStr);
			}else{
				item.defaultPrizeAmount = 0d;
			}
		} catch (NumberFormatException e) {
			item.defaultPrizeAmount = 0d;
			logger.error("数字转换默认开奖金额发生错误"+e.getMessage(), e);
		}
		try{
			if(object.containsKey(JSON_KEYNAME_USABLE)){
				String usableStr = object.getString(JSON_KEYNAME_USABLE);
				if(usableStr != null && !usableStr.isEmpty()){
					item.setUsable(EnabledStatus.getItem(object.getInt(JSON_KEYNAME_USABLE)));
				}else{
					item.setUsable(EnabledStatus.ENABLED);
				}
			}else{
				item.setUsable(EnabledStatus.ENABLED);
			}
		}catch(Exception e){
			item.setUsable(EnabledStatus.ENABLED);
			logger.error("转换是否可用发生错误"+e.getMessage(), e);
		}
		try{
			if(object.containsKey(JSON_KEYNAME_STATIC_PRIZE)){
				String staticPrizeStr = object.getString(JSON_KEYNAME_STATIC_PRIZE);
				if(staticPrizeStr != null && !staticPrizeStr.isEmpty()){
					item.setStaticPrize(YesNoStatus.getItem(object.getInt(JSON_KEYNAME_STATIC_PRIZE)));
				}else{
					item.setStaticPrize(YesNoStatus.NO);
				}
			}else{
				item.setStaticPrize(YesNoStatus.NO);
			}
		}catch(Exception e){
			item.setStaticPrize(YesNoStatus.NO);
			logger.error("转换是否可用发生错误"+e.getMessage(), e);
		}
		try{
			if(object.containsKey(JSON_KEYNAME_NOTIFY)){
				String notifyStr = object.getString(JSON_KEYNAME_NOTIFY);
				if(notifyStr != null && !notifyStr.isEmpty()){
					item.setNotify(YesNoStatus.getItem(object.getInt(JSON_KEYNAME_NOTIFY)));
				}else{
					item.setNotify(YesNoStatus.NO);
				}
			}else{
				item.setNotify(YesNoStatus.NO);
			}
		}catch(Exception e){
			item.setNotify(YesNoStatus.NO);
			logger.error("转换是否可用发生错误"+e.getMessage(), e);
		}
		return item;
	}
	@SuppressWarnings("unchecked")
	public static List<ResultDetailTemplateItem> convertFromJSONArray(JSONArray array) {
		logger.info(array.toString());
		if (array == null) {
			return null;
		}
		List<ResultDetailTemplateItem> list = new ArrayList<ResultDetailTemplateItem>();
		ResultDetailTemplateItem resultDetailTemplateItem = null;
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			resultDetailTemplateItem = convertFromJSONObject(object);
			if(resultDetailTemplateItem!=null){
				list.add(resultDetailTemplateItem);
			}
		}
		return list;
	}
	public static String toJSONArrayString(List<ResultDetailTemplateItem> resultDetailTemplateItems) {
		JSONArray ja = new JSONArray();
		JSONObject jsonObject = null;
		if(resultDetailTemplateItems!=null&&resultDetailTemplateItems.size()>0){
			for(ResultDetailTemplateItem resultDetailTemplateItem:resultDetailTemplateItems){
				jsonObject = resultDetailTemplateItem.toJSON();
				ja.add(jsonObject);
			}
		}
		return ja.toString();
	}
	/**
	 * 转换成默认的开奖详情奖项列表的json字符串   
	 * format {"resultDetail":[{"key":"prize1","bet":"0","prize":"100000"},{"key":"prize2","bet":"0","prize":"50000"}]}
	 * @param resultDetailTemplateItems
	 * @return
	 */
	public static String toJSONString4DefaultPrizeItem(List<ResultDetailTemplateItem> resultDetailTemplateItems) {
		if(resultDetailTemplateItems==null){
			return null;
		}
		JSONArray ja = new JSONArray();
		JSONObject jsonObject = null;
		if(resultDetailTemplateItems!=null&&resultDetailTemplateItems.size()>0){
			for(ResultDetailTemplateItem resultDetailTemplateItem:resultDetailTemplateItems){
				// 不可用奖项不做装换 add by lm 2011-03-09 添加奖项不可用属性
				if(resultDetailTemplateItem.getUsable()!=null && resultDetailTemplateItem.getUsable().getValue() == EnabledStatus.DISABLED.getValue()){
					continue;
				}
				jsonObject = new JSONObject();
				jsonObject.put(LotteryDrawPrizeItem.JSON_KEYNAME_KEY, resultDetailTemplateItem.getKey());
				jsonObject.put(LotteryDrawPrizeItem.JSON_KEYNAME_BET, "0");
				jsonObject.put(LotteryDrawPrizeItem.JSON_KEYNAME_PRIZE, resultDetailTemplateItem.getDefaultPrizeAmount()==null?"0":resultDetailTemplateItem.getDefaultPrizeAmount());
				ja.add(jsonObject);
			}
		}
		JSONObject rs = new JSONObject();
		rs.put(LotteryConfig.JSON_KEYNAME_RESULTDETAIL, ja);
		return rs.toString();
	}
}
