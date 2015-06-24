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
import com.lehecai.core.lottery.ComboSaleStatus;

/**
 * 套餐
 * @author leiming
 *
 */
public class Combo extends AbstractApiResultBean {
	public static final String QUERY_ID = "combo_id";
	public static final String QUERY_PLAN_ID = "plan_id";
	public static final String QUERY_NAME = "combo_name";
	public static final String QUERY_COMBOREV_ID = "comborev_id";
	public static final String QUERY_COMBO_STATUS = "combo_status";
	
	
	public static final String ORDER_ID = "combo_id";
	public static final String ORDER_AMOUNT = "combo_amount";
	public static final String ORDER_COMBO_ID = "combo_id";
	public static final String ORDER_COMBOREV_ID = "comborev_id";
	public static final String ORDER_LOTTERYTYPE = "combo_lotterytype";
	
	public static final String SET_NAME = "combo_name";
	public static final String SET_DESCRIPTION = "combo_description";
	public static final String SET_TOTAL_PHASE = "combo_total_phase";
	public static final String SET_SELECT_TYPE = "combo_selecttype";
	public static final String SET_DURATION = "combo_duration";
	public static final String SET_AMOUNT = "combo_amount";
	public static final String SET_STATUS = "combo_status";
	public static final String SET_CONFIG = "combo_config";
	public static final String SET_COMBO_LOTTERYTYPE = "combo_lotterytype";
	
	private String comboId;				//套餐编号

	private String name;
	private String description;
	private String totalPhase;
	private String selectType;
	private String comboLotteryType;
	private String duration;
	private int amount;
	private String config;
	private int comborevId;
	private ComboSaleStatus status; // 套餐销售状态
	private List<ComboConfig> comboConfigList;
	
	public static Combo convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		Combo combo = new Combo();
		
		combo.comboId = getString(object, "combo_id");
		combo.name = getString(object, "combo_name");
		combo.description = getString(object, "combo_description");
		combo.totalPhase = getString(object, "combo_total_phase");
		combo.duration = getString(object, "combo_duration");
		combo.selectType = getString(object, "combo_selecttype");
		combo.amount = getInt(object, "combo_amount");
		combo.config = getString(object, "combo_config");
		combo.comborevId = getInt(object, "comborev_id");
		combo.comboLotteryType = getString(object, "combo_lotterytype");
		combo.comboConfigList = ComboConfig.convertFromJSONObjectMap(getObject(object, "combo_config"));
		combo.setStatus(ComboSaleStatus.getItem(getInt(object, "combo_status")));
		
		return combo;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Combo> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<Combo> list = new ArrayList<Combo>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTotalPhase() {
		return totalPhase;
	}

	public void setTotalPhase(String totalPhase) {
		this.totalPhase = totalPhase;
	}

	public String getSelectType() {
		return selectType;
	}

	public void setSelectType(String selectType) {
		this.selectType = selectType;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public int getComborevId() {
		return comborevId;
	}

	public void setComborevId(int comborevId) {
		this.comborevId = comborevId;
	}

	public ComboSaleStatus getStatus() {
		return status;
	}

	public void setStatus(ComboSaleStatus status) {
		this.status = status;
	}

	public String getComboId() {
		return comboId;
	}

	public void setComboId(String comboId) {
		this.comboId = comboId;
	}

	public List<ComboConfig> getComboConfigList() {
		return comboConfigList;
	}

	public void setComboConfigList(List<ComboConfig> comboConfigList) {
		this.comboConfigList = comboConfigList;
	}

	public String getComboLotteryType() {
		return comboLotteryType;
	}

	public void setComboLotteryType(String comboLotteryType) {
		this.comboLotteryType = comboLotteryType;
	}

}
