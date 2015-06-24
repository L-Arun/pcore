package com.lehecai.core.api.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;

public class Province extends AbstractApiResultBean {
	
	public static final String SET_PROVINCE_ID = "province";
	
	private int provinceId; //省ID
	private String provinceName; //省name
	List<City> cities;//该省包含的市 
	
	@SuppressWarnings("unchecked")
	public static List<Province> convertFromJSONObjectMap(JSONObject objectMap) {
		if (objectMap == null) {
			return null;
		}
		List<Province> list = new ArrayList<Province>();
		for (Iterator iterator = objectMap.keys(); iterator.hasNext();) {
			String key = (String)iterator.next();
			int id = 0;
			try {
				id = Integer.parseInt(key);
			} catch (NumberFormatException e) {
				logger.error("invalid province value: {}", key);
				continue;
			}
			String name = (String) objectMap.get(key);
			Province province = new Province();
			province.provinceId = id;
			province.provinceName = name;
			list.add(province);
		}
		return list;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}


}
