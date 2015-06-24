package com.lehecai.core.api.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;

public class City extends AbstractApiResultBean {
	
	private int cityId; //省ID
	private String cityName; //省name
	
	
	@SuppressWarnings("unchecked")
	public static List<City> convertFromJSONObjectMap(JSONObject objectMap) {
		if (objectMap == null) {
			return null;
		}
		List<City> list = new ArrayList<City>();
		for (Iterator iterator = objectMap.keys(); iterator.hasNext();) {
			String key = (String)iterator.next();
			int id = 0;
			try {
				char [] temp = key.toCharArray();
				id = Integer.parseInt("" + temp[2] + temp[3]);
			} catch (NumberFormatException e) {
				logger.error("invalid city value: {}", key);
				continue;
			}
			String name = (String) objectMap.get(key);
			City city = new City();
			
			city.cityId = id;
			city.cityName = name;
			list.add(city);
		}
		return list;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
