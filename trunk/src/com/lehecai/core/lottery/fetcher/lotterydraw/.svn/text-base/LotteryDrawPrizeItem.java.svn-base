/**
 * 
 */
package com.lehecai.core.lottery.fetcher.lotterydraw;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.api.lottery.LotteryConfig;

/**
 * 奖级定义条目
 * @author Sunshow
 *
 */
public class LotteryDrawPrizeItem extends AbstractApiResultBean implements Serializable {
	private static final long serialVersionUID = 5614235754543942516L;

	private String name;				//奖级名称 抓取网站奖项名称
	
	private String winningCount;		//中奖注数
	private String prizeAmount;			//奖金金额
	
	public final static String JSON_KEYNAME_KEY = "key";
	public final static String JSON_KEYNAME_BET = "bet";
	public final static String JSON_KEYNAME_PRIZE = "prize";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWinningCount() {
		return winningCount;
	}
	public void setWinningCount(String winningCount) {
		this.winningCount = winningCount;
	}
	public String getPrizeAmount() {
		return prizeAmount;
	}
	public void setPrizeAmount(String prizeAmount) {
		this.prizeAmount = prizeAmount;
	}
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("奖级名称:").append(name);
		sb.append(",中奖注数:").append(winningCount);
		sb.append(",奖金金额:").append(prizeAmount);
		return sb.toString();
	}
	public String toJSONString() {
		JSONObject object = new JSONObject();
		object.put(JSON_KEYNAME_KEY, name);
		object.put(JSON_KEYNAME_BET, winningCount);
		object.put(JSON_KEYNAME_PRIZE, prizeAmount);
		return object.toString();
	}
	/**
	 * 奖项列表数据信息
	 * @param list
	 * @return
	 */
	public static String listDataInfo(List<LotteryDrawPrizeItem> list){
		StringBuffer sb = new StringBuffer();
		if(list!=null){
			int i = 0;
			for(LotteryDrawPrizeItem lotteryDrawPrizeItem:list){
				sb.append(lotteryDrawPrizeItem.toString());
				if(i<(list.size()-1)){
					sb.append(";");
				}
				i++;
			}
		}
		return sb.toString();
	}
	public JSONObject toJSON() {
		JSONObject object = new JSONObject();
		object.put(JSON_KEYNAME_KEY, name);
		object.put(JSON_KEYNAME_BET, winningCount);
		object.put(JSON_KEYNAME_PRIZE, prizeAmount);
		
		return object;
	}
	public static LotteryDrawPrizeItem convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		LotteryDrawPrizeItem item = new LotteryDrawPrizeItem();
		item.name = getString(object, JSON_KEYNAME_KEY);
		item.winningCount = getString(object, JSON_KEYNAME_BET);
		item.prizeAmount = getString(object, JSON_KEYNAME_PRIZE);
		return item;
	}
	/**
	 * 奖开奖结果列表转换为JSONArrayString
	 * @param lotteryDrawPrizeItems
	 * @return
	 */
	public static String toJSONArrayString(List<LotteryDrawPrizeItem> lotteryDrawPrizeItems) {
		JSONArray ja = new JSONArray();
		JSONObject jsonObject = null;
		if(lotteryDrawPrizeItems!=null&&lotteryDrawPrizeItems.size()>0){
			for(LotteryDrawPrizeItem lotteryDrawPrizeItem:lotteryDrawPrizeItems){
				jsonObject = lotteryDrawPrizeItem.toJSON();
				ja.add(jsonObject);
			}
		}
		return ja.toString();
	}
	@SuppressWarnings("unchecked")
	public static List<LotteryDrawPrizeItem> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<LotteryDrawPrizeItem> list = new ArrayList<LotteryDrawPrizeItem>();
		LotteryDrawPrizeItem lotteryDrawPrizeItem = null;
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			lotteryDrawPrizeItem = convertFromJSONObject(object);
			if(lotteryDrawPrizeItem!=null){
				list.add(lotteryDrawPrizeItem);
			}
		}
		return list;
	}
	/**
	 * 将数据库DB中开奖详情的json对象字符串转换为对应的List<LotteryDrawPrizeItem>
	 * @param jsonObjectString
	 * @return
	 */
	public static List<LotteryDrawPrizeItem> convertFromJsonObjectString(String jsonObjectString){
		if(jsonObjectString==null){
			return null;
		}
		try{
			JSONObject jsonObject = JSONObject.fromObject(jsonObjectString);
			JSONArray jsonArray = jsonObject.getJSONArray(LotteryConfig.JSON_KEYNAME_RESULTDETAIL);
			return convertFromJSONArray(jsonArray);
		}catch(Exception e){
			logger.error("转换数据库开奖详情的Json字符串发生错误,字符串内容为:"+jsonObjectString+","+e.getMessage());
			return null;
		}
	}
	/**
	 * 将抓取的开奖详情列表转换为数据存储的json字符串格式   
	 * 注意:list在转DB的json串前必须将奖项名称的name转为key
	 * @param list
	 * @return
	 */
	public static String convertListToDBJsonString(List<LotteryDrawPrizeItem> list){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(LotteryConfig.JSON_KEYNAME_RESULTDETAIL, toJSONArrayString(list));
		return jsonObject.toString();
	}
}
