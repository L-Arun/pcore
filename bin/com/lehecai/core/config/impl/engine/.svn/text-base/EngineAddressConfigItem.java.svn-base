/**
 * 
 */
package com.lehecai.core.config.impl.engine;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.config.impl.AbstractDefaultSupportedConfigItem;

/**
 * engine调用地址实体类
 * @author yanweijie
 *
 */
public class EngineAddressConfigItem extends AbstractDefaultSupportedConfigItem {

	private static final long serialVersionUID = -4765749951624634087L;

	protected static final Logger logger = LoggerFactory.getLogger(EngineAddressConfigItem.class);
	
	public static final String KEY_ENGINE_ADDRESS = "engine_address";
	public static final String KEY_USE_DEFAULT = "use_default";
	
	private String address;//engine调用地址

	public JSONObject toJSONObject() {
		JSONObject object = new JSONObject();

		//转换默认配置
		object.put(KEY_ENGINE_ADDRESS, this.getAddress());
		object.put(KEY_USE_DEFAULT, this.isUseDefault());

		return object;
	}
	
	public static EngineAddressConfigItem convertFromJSONObject(JSONObject obj) {
		if (obj == null || obj.isNullObject()) {
			return null;
		}
		EngineAddressConfigItem engineAddress = new EngineAddressConfigItem();
		if (obj.containsKey(KEY_ENGINE_ADDRESS)) {
			try {
				engineAddress.setAddress(obj.getString(KEY_ENGINE_ADDRESS));
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
		}
		if (obj.containsKey(KEY_USE_DEFAULT)) {
			try {
				engineAddress.setUseDefault(obj.getBoolean(EngineAddressConfigItem.KEY_USE_DEFAULT));
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
		}
		return engineAddress;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
