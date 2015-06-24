/**
 * 
 */
package com.lehecai.core.lottery.lotteryconfig;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.lehecai.core.EnabledStatus;
import com.lehecai.core.YesNoStatus;
import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.ResultRegionType;

/**
 * 开奖结果模板项
 * json format: {"key":"red","name":"红球","result_count":"6"}
 * @author leiming
 */
public class ResultTemplateItem extends AbstractApiResultBean {
	private String key;					//结果定义 如red 注意:同彩票下key值不可重复
	private String name;				//结果名称 如红球
	private Integer resultCount;		//结果个数 如6 
	private EnabledStatus usable;		//结果是否可用  1可用,0不可用,默认值为可用
	private YesNoStatus allowDuplicated;     //结果是否可重复
	private ResultRegionType resultRegionType;
	private Integer minDigit;//针对数字区间类型
	private Integer maxDigit;//针对数字区间类型
	private Integer digitCapacity;//针对数字区间类型，0为不限制，其他值根据情况做长度判断或补0操作
	private String designatedSection;//针对指定号码范围类型，存储为JSON字符串数组，录入时可以简易为英文逗号隔开的字符串，保存时做格式校验 
	//以上三个组合,代表某种彩票的 红球个数有6个
	private final static String JSON_KEYNAME_KEY = "key";
	private final static String JSON_KEYNAME_NAME = "name";
	private final static String JSON_KEYNAME_RESULTCOUNT = "result_count";
	private final static String JSON_KEYNAME_USABLE = "usable";
	private final static String JSON_KEYNAME_ALLOW_DUPLICATED = "allow_duplicated";
	private final static String JSON_KEYNAME_RESULT_REGION_TYPE = "result_region_type";
	private final static String JSON_KEYNAME_MIN_DIGIT = "min_digit";
	private final static String JSON_KEYNAME_MAX_DIGIT = "max_digit";
	private final static String JSON_KEYNAME_DIGIT_CAPACITY = "digit_capacity";
	private final static String JSON_KEYNAME_DESIGNATED_SECTION = "designated_section";
	
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

	public Integer getResultCount() {
		return resultCount;
	}

	public void setResultCount(Integer resultCount) {
		this.resultCount = resultCount;
	}
	
	public EnabledStatus getUsable() {
		return usable;
	}

	public void setUsable(EnabledStatus usable) {
		this.usable = usable;
	}

	public YesNoStatus getAllowDuplicated() {
		return allowDuplicated;
	}

	public void setAllowDuplicated(YesNoStatus allowDuplicated) {
		this.allowDuplicated = allowDuplicated;
	}

	public ResultRegionType getResultRegionType() {
		return resultRegionType;
	}

	public void setResultRegionType(ResultRegionType resultRegionType) {
		this.resultRegionType = resultRegionType;
	}

	public Integer getMinDigit() {
		return minDigit;
	}

	public void setMinDigit(Integer minDigit) {
		this.minDigit = minDigit;
	}

	public Integer getMaxDigit() {
		return maxDigit;
	}

	public void setMaxDigit(Integer maxDigit) {
		this.maxDigit = maxDigit;
	}

	public Integer getDigitCapacity() {
		return digitCapacity;
	}

	public void setDigitCapacity(Integer digitCapacity) {
		this.digitCapacity = digitCapacity;
	}

	public String getDesignatedSection() {
		return designatedSection;
	}

	public void setDesignatedSection(String designatedSection) {
		this.designatedSection = designatedSection;
	}

	public String toJSONString() {
		return toJSON().toString();
	}
	
	public JSONObject toJSON() {
		JSONObject object = new JSONObject();
		object.put(JSON_KEYNAME_KEY, key);
		object.put(JSON_KEYNAME_NAME, name);
		
		if (resultCount != null && resultCount != 0) {
			object.put(JSON_KEYNAME_RESULTCOUNT, resultCount);
		}
		if (usable == null) {
			object.put(JSON_KEYNAME_USABLE, EnabledStatus.ENABLED.getValue());
		} else {
			object.put(JSON_KEYNAME_USABLE, usable.getValue());
		}
		if (allowDuplicated == null) {
			object.put(JSON_KEYNAME_ALLOW_DUPLICATED, YesNoStatus.YES.getValue());
		} else {
			object.put(JSON_KEYNAME_ALLOW_DUPLICATED, allowDuplicated.getValue());
		}
		if (resultRegionType == null) {
			object.put(JSON_KEYNAME_RESULT_REGION_TYPE, ResultRegionType.DIGITAL_SECTION.getValue());
		} else {
			object.put(JSON_KEYNAME_RESULT_REGION_TYPE, resultRegionType.getValue());
		}
		if (minDigit != null) {
			object.put(JSON_KEYNAME_MIN_DIGIT, minDigit);
		}
		if (maxDigit != null) {
			object.put(JSON_KEYNAME_MAX_DIGIT, maxDigit);
		}
		if (digitCapacity != null) {
			object.put(JSON_KEYNAME_DIGIT_CAPACITY, digitCapacity);
		}
		if (!StringUtils.isEmpty(designatedSection)) {
			String[] designatedSectionArray = StringUtils.split(designatedSection, ",");
			JSONArray jsonArray = new JSONArray();
			for (String s : designatedSectionArray) {
				jsonArray.add(s);
			}
			object.put(JSON_KEYNAME_DESIGNATED_SECTION, jsonArray);
		}
		return object;
	}
	
	public static ResultTemplateItem convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		ResultTemplateItem item = new ResultTemplateItem();
		item.key = getString(object, JSON_KEYNAME_KEY);
		item.name = getString(object, JSON_KEYNAME_NAME);
		
		String resultCountStr = getString(object, JSON_KEYNAME_RESULTCOUNT);
		try {
			if(resultCountStr!=null&&(!resultCountStr.isEmpty())){
				item.resultCount = Integer.valueOf(resultCountStr);
			}else{
				item.resultCount = 0;
			}
		} catch (NumberFormatException e) {
			item.resultCount = 0;
			logger.error("数字转换结果数量发生错误"+e.getMessage(), e);
		}
		
		try {
			if (object.containsKey(JSON_KEYNAME_USABLE)) {
				String usableStr = object.getString(JSON_KEYNAME_USABLE);
				if (usableStr != null && !usableStr.isEmpty()) {
					item.setUsable(EnabledStatus.getItem(object.getInt(JSON_KEYNAME_USABLE)));
				} else {
					item.setUsable(EnabledStatus.ENABLED);
				}
			} else {
				item.setUsable(EnabledStatus.ENABLED);
			}
		} catch(Exception e) {
			item.setUsable(EnabledStatus.ENABLED);
			logger.error("转换是否可用发生错误");
			logger.error(e.getMessage(), e);
		}
		
		try {
			if (object.containsKey(JSON_KEYNAME_ALLOW_DUPLICATED)) {
				int allowDuplicatedValue = object.getInt(JSON_KEYNAME_ALLOW_DUPLICATED);
				item.setAllowDuplicated(YesNoStatus.getItem(allowDuplicatedValue) == null ? YesNoStatus.YES : YesNoStatus.getItem(allowDuplicatedValue));
			} else {
				item.setAllowDuplicated(YesNoStatus.YES);
			}
		} catch(Exception e) {
			item.setAllowDuplicated(YesNoStatus.YES);
			logger.error("转换是否允许重复发生错误");
			logger.error(e.getMessage(), e);
		}
		
		try {
			if (object.containsKey(JSON_KEYNAME_RESULT_REGION_TYPE)) {
				int resultRegionTypeValue = object.getInt(JSON_KEYNAME_RESULT_REGION_TYPE);
				item.setResultRegionType(ResultRegionType.getItem(resultRegionTypeValue) == null ? ResultRegionType.DIGITAL_SECTION : ResultRegionType.getItem(resultRegionTypeValue));
			} else {
				item.setResultRegionType(ResultRegionType.DIGITAL_SECTION);
			}
		} catch(Exception e) {
			item.setResultRegionType(ResultRegionType.DIGITAL_SECTION);
			logger.error("转换结果范围类型发生错误");
			logger.error(e.getMessage(), e);
		}
		try {
			if (object.containsKey(JSON_KEYNAME_MIN_DIGIT)) {
				item.setMinDigit(object.getInt(JSON_KEYNAME_MIN_DIGIT));
			}
		} catch(Exception e) {
			logger.error("转换数字范围类型最小值发生错误");
			logger.error(e.getMessage(), e);
		}
		try {
			if (object.containsKey(JSON_KEYNAME_MAX_DIGIT)) {
				item.setMaxDigit(object.getInt(JSON_KEYNAME_MAX_DIGIT));
			}
		} catch(Exception e) {
			logger.error("转换数字范围类型最大值发生错误");
			logger.error(e.getMessage(), e);
		}
		try {
			if (object.containsKey(JSON_KEYNAME_DIGIT_CAPACITY)) {
				item.setDigitCapacity(object.getInt(JSON_KEYNAME_DIGIT_CAPACITY));
			}
		} catch(Exception e) {
			logger.error("转换数字范围类型数字位数发生错误");
			logger.error(e.getMessage(), e);
		}
		try {
			if (object.containsKey(JSON_KEYNAME_DESIGNATED_SECTION)) {
				JSONArray designatedSectionArray = object.getJSONArray(JSON_KEYNAME_DESIGNATED_SECTION);
				item.setDesignatedSection(StringUtils.join(designatedSectionArray.iterator(), ","));
			}
		} catch(Exception e) {
			logger.error("转换指定范围类型JSON字符串数组发生错误");
			logger.error(e.getMessage(), e);
		}
		
		return item;
	}
	@SuppressWarnings("unchecked")
	public static List<ResultTemplateItem> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<ResultTemplateItem> list = new ArrayList<ResultTemplateItem>();
		ResultTemplateItem resultTemplateItem = null;
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			resultTemplateItem = convertFromJSONObject(object);
			if(resultTemplateItem!=null){
				list.add(resultTemplateItem);
			}
		}
		return list;
	}
	public static String toJSONArrayString(List<ResultTemplateItem> resultTemplateItems) {
		JSONArray ja = new JSONArray();
		JSONObject jsonObject = null;
		if(resultTemplateItems!=null&&resultTemplateItems.size()>0){
			for(ResultTemplateItem resultTemplateItem:resultTemplateItems){
				jsonObject = resultTemplateItem.toJSON();
				ja.add(jsonObject);
			}
		}
		return ja.toString();
	}
}
