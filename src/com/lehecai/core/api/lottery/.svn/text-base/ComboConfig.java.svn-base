/**
 * 
 */
package com.lehecai.core.api.lottery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.AdditionType;
import com.lehecai.core.lottery.ComboType;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.PlayType;

/**
 * 套餐配置
 * @author leiming
 *
 */
public class ComboConfig extends AbstractApiResultBean {
	
	private int configId;
	private LotteryType lotteryType;
	private int phase;
	private int tickets;
	private int multiple;
	private double amount;
	private PlayType playType;
	private List<ComboType> comboTypes;
	private int lotteryTypeValue;
	private int playTypeValue;
	private List<PlayType> playTypeList;
	private List<Integer> comboTypeValues;
	private AdditionType additionType;
	private int additionTypeValue;
	
	@SuppressWarnings("unchecked")
	public static List<ComboConfig> convertFromJSONObjectMap(JSONObject objectMap) {
		if (objectMap == null) {
			return null;
		}
		List<ComboConfig> list = new ArrayList<ComboConfig>();
		for (Iterator iterator = objectMap.keys(); iterator.hasNext();) {
			String key = (String)iterator.next();
			int id = 0;
			try {
				id = Integer.parseInt(key);
			} catch (NumberFormatException e) {
				logger.error("invalid province value: {}", key);
				continue;
			}
			JSONObject object = JSONObject.fromObject(objectMap.get(key));
			ComboConfig comboConfig = new ComboConfig();
			
			comboConfig.configId = id;
			comboConfig.additionType = AdditionType.getItem(getInt(object, "addition"));
			comboConfig.lotteryTypeValue = getInt(object, "lottery_type");
			comboConfig.lotteryType = LotteryType.getItem(comboConfig.lotteryTypeValue);
			comboConfig.phase = getInt(object, "phase");
			try {
				comboConfig.tickets = getInt(object, "tickets");
			} catch (Exception e) {
				comboConfig.tickets = 0;
			}
			try {
				comboConfig.multiple = getInt(object, "multiple");
			} catch (Exception e) {
				comboConfig.multiple = 0;
			}
			comboConfig.amount = getDouble(object, "amount");
			comboConfig.playTypeValue = getInt(object, "play_type");
			comboConfig.playType = PlayType.getItem(comboConfig.playTypeValue);
			JSONArray jsonArray = getArray(object, "type");
			comboConfig.comboTypes = new ArrayList<ComboType>();
			comboConfig.comboTypeValues = new ArrayList<Integer>();
			comboConfig.playTypeList = PlayType.getItemsByLotteryType(comboConfig.lotteryType);
			for (int i = 0; i < jsonArray.size(); i++) {
				comboConfig.comboTypes.add(ComboType.getItem(jsonArray.getInt(i)));
				comboConfig.comboTypeValues.add(jsonArray.getInt(i));
			}
			
			list.add(comboConfig);
		}
		return list;
	}
	
	public static JSONObject toJSONObject(List<ComboConfig> comboConfigList) {
		if (comboConfigList == null || comboConfigList.size() == 0) {
			return null;
		}
		JSONObject json = new JSONObject();
		for (ComboConfig c : comboConfigList) {
			JSONObject j = new JSONObject();
			j.put("lottery_type", c.getLotteryType().getValue());
			j.put("type", c.getComboTypeValues());
			j.put("phase", c.getPhase());
			j.put("tickets", c.getTickets());
			j.put("multiple", c.getMultiple());
			j.put("amount", c.getAmount());
			j.put("play_type", c.getPlayType().getValue());
			j.put("addition", c.additionTypeValue);
			json.put(c.getLotteryType().getValue(), j.toString());
		}
		return json;
	}
	
	public LotteryType getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public int getPhase() {
		return phase;
	}

	public void setPhase(int phase) {
		this.phase = phase;
	}

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public PlayType getPlayType() {
		return playType;
	}

	public void setPlayType(PlayType playType) {
		this.playType = playType;
	}

	public int getConfigId() {
		return configId;
	}

	public void setConfigId(int configId) {
		this.configId = configId;
	}

	public int getMultiple() {
		return multiple;
	}

	public void setMultiple(int multiple) {
		this.multiple = multiple;
	}

	public List<ComboType> getComboTypes() {
		return comboTypes;
	}

	public void setComboTypes(List<ComboType> comboTypes) {
		this.comboTypes = comboTypes;
	}

	public int getLotteryTypeValue() {
		return lotteryTypeValue;
	}

	public void setLotteryTypeValue(int lotteryTypeValue) {
		this.lotteryTypeValue = lotteryTypeValue;
	}

	public int getPlayTypeValue() {
		return playTypeValue;
	}

	public void setPlayTypeValue(int playTypeValue) {
		this.playTypeValue = playTypeValue;
	}

	public List<Integer> getComboTypeValues() {
		return comboTypeValues;
	}

	public void setComboTypeValues(List<Integer> comboTypeValues) {
		this.comboTypeValues = comboTypeValues;
	}

	public List<PlayType> getPlayTypeList() {
		return playTypeList;
	}

	public void setPlayTypeList(List<PlayType> playTypeList) {
		this.playTypeList = playTypeList;
	}

	public AdditionType getAdditionType() {
		return additionType;
	}

	public void setAdditionType(AdditionType additionType) {
		this.additionType = additionType;
	}

	public int getAdditionTypeValue() {
		return additionTypeValue;
	}

	public void setAdditionTypeValue(int additionTypeValue) {
		this.additionTypeValue = additionTypeValue;
	}

}
