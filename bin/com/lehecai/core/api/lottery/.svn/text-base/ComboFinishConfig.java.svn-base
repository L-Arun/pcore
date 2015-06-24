/**
 * 
 */
package com.lehecai.core.api.lottery;

import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.FinishComboType;

/**
 * 套餐结束配置
 * @author liurd
 *
 */
public class ComboFinishConfig extends AbstractApiResultBean {
	
	private FinishComboType type;
	private double minPrize;
	
	public static ComboFinishConfig convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		ComboFinishConfig cfc = new ComboFinishConfig();
		int typeValue = getInt(object, "type");
		cfc.type = FinishComboType.getItem(typeValue);
		cfc.minPrize = getDouble(object, "min_prize");
		return cfc;
	}
	
	public static JSONObject toJSONObject(ComboFinishConfig cfc) {
		if (cfc == null) {
			return null;
		}
		JSONObject json = new JSONObject();
		json.put("type", cfc.getType().getValue());
		json.put("min_prize", cfc.getMinPrize());
		return json;
	}

	public FinishComboType getType() {
		return type;
	}

	public void setType(FinishComboType type) {
		this.type = type;
	}

	public double getMinPrize() {
		return minPrize;
	}

	public void setMinPrize(double minPrize) {
		this.minPrize = minPrize;
	}

}
