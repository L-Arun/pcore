/**
 * 
 */
package com.lehecai.core.config.impl.lottery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.config.impl.AbstractConfigItem;

/**
 * 彩种配置实体类
 * @author qatang
 *
 */
public class LotterySettingConfigItem extends AbstractConfigItem {

	private static final long serialVersionUID = 6683114474487844041L;

	protected static final Logger logger = LoggerFactory.getLogger(LotterySettingConfigItem.class);
	
	public static final String KEY_RESULT_CONFIG_LIST = "resultConfigList";
	public static final String KEY_PRIZE_ITEM_LIST = "prizeItemList";
	public static final String KEY_EXTRA_PRIZE_ITEM = "extraPrizeItem";
	
	private List<LotteryResultItem> lotteryResultItemList;
	private List<LotteryPrizeItem> lotteryPrizeItemList;
	private LotteryExtraPrizeItem lotteryExtraPrizeItem;
	
	public JSONObject toJSONObject() {
		JSONObject object = new JSONObject();

		//转换默认配置
		JSONArray resultJsonArray = new JSONArray();
		if (this.getLotteryResultItemList() != null && !this.getLotteryResultItemList().isEmpty()) {
			for (LotteryResultItem item : this.getLotteryResultItemList()) {
				resultJsonArray.add(LotteryResultItem.toJSONObject(item));
			}
		}
		object.put(LotterySettingConfigItem.KEY_RESULT_CONFIG_LIST, resultJsonArray);
		
		JSONArray prizeJsonArray = new JSONArray();
		if (this.getLotteryPrizeItemList() != null && !this.getLotteryPrizeItemList().isEmpty()) {
			for (LotteryPrizeItem item : this.getLotteryPrizeItemList()) {
				prizeJsonArray.add(LotteryPrizeItem.toJSONObject(item));
			}
		}
		object.put(LotterySettingConfigItem.KEY_PRIZE_ITEM_LIST, prizeJsonArray);
		object.put(LotterySettingConfigItem.KEY_EXTRA_PRIZE_ITEM, this.getLotteryExtraPrizeItem().toJSONObject());
		return object;
	}
	
	public static LotterySettingConfigItem convertFromJSONObject(JSONObject obj) {
		if (obj == null || obj.isNullObject()) {
			return null;
		}
		LotterySettingConfigItem lotterySettingItem = new LotterySettingConfigItem();
		if (obj.containsKey(LotterySettingConfigItem.KEY_RESULT_CONFIG_LIST)) {
			List<LotteryResultItem> list = new ArrayList<LotteryResultItem>();
			
			JSONArray array = null;
			try {
				array = obj.getJSONArray(LotterySettingConfigItem.KEY_RESULT_CONFIG_LIST);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			if (array != null && array.size() > 0) {
				for (Iterator<?> iterator = array.iterator(); iterator.hasNext();) {
					JSONObject tmpObj = (JSONObject) iterator.next();
					list.add(LotteryResultItem.convertFromJSONObject(tmpObj));
				}
			}
			lotterySettingItem.setLotteryResultItemList(list);
		}
		if (obj.containsKey(LotterySettingConfigItem.KEY_PRIZE_ITEM_LIST)) {
			List<LotteryPrizeItem> list = new ArrayList<LotteryPrizeItem>();
			
			JSONArray array = null;
			try {
				array = obj.getJSONArray(LotterySettingConfigItem.KEY_PRIZE_ITEM_LIST);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			if (array != null && array.size() > 0) {
				for (Iterator<?> iterator = array.iterator(); iterator.hasNext();) {
					JSONObject tmpObj = (JSONObject) iterator.next();
					list.add(LotteryPrizeItem.convertFromJSONObject(tmpObj));
				}
			}
			lotterySettingItem.setLotteryPrizeItemList(list);
		}
		
		if (obj.containsKey(LotterySettingConfigItem.KEY_EXTRA_PRIZE_ITEM)) {
			JSONObject object = null;
			try {
				object = obj.getJSONObject(LotterySettingConfigItem.KEY_EXTRA_PRIZE_ITEM);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			lotterySettingItem.setLotteryExtraPrizeItem(LotteryExtraPrizeItem.convertFromJSONObject(object));
		}
		
		return lotterySettingItem;
	}
	public List<LotteryResultItem> getLotteryResultItemList() {
		return lotteryResultItemList;
	}
	public void setLotteryResultItemList(
			List<LotteryResultItem> lotteryResultItemList) {
		this.lotteryResultItemList = lotteryResultItemList;
	}
	public List<LotteryPrizeItem> getLotteryPrizeItemList() {
		return lotteryPrizeItemList;
	}
	public void setLotteryPrizeItemList(List<LotteryPrizeItem> lotteryPrizeItemList) {
		this.lotteryPrizeItemList = lotteryPrizeItemList;
	}

	public LotteryExtraPrizeItem getLotteryExtraPrizeItem() {
		return lotteryExtraPrizeItem;
	}

	public void setLotteryExtraPrizeItem(LotteryExtraPrizeItem lotteryExtraPrizeItem) {
		this.lotteryExtraPrizeItem = lotteryExtraPrizeItem;
	}
	
}
