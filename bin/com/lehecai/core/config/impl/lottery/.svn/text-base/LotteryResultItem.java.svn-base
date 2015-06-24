/**
 * 
 */
package com.lehecai.core.config.impl.lottery;

import java.io.Serializable;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.EnabledStatus;
import com.lehecai.core.YesNoStatus;
import com.lehecai.core.lottery.ResultRegionType;

/**
 * 彩种奖级开奖号码配置实体类
 * @author qatang
 *
 */
public class LotteryResultItem implements Serializable {
	protected static final Logger logger = LoggerFactory.getLogger(LotteryResultItem.class);
	private static final long serialVersionUID = 6683114474487844041L;
	
	public static final String KEY_KEY = "key";
	public static final String KEY_NAME = "name";
	public static final String KEY_RESULT_COUNT = "result_count";
	public static final String KEY_USABLE = "usable";
	public static final String KEY_ALLOW_DUPLICATED = "allow_duplicated";
	public static final String KEY_RESULT_REGION_TYPE = "result_region_type";
	public static final String KEY_MIN_DIGIT = "min_digit";
	public static final String KEY_MAX_DIGIT = "max_digit";
	public static final String KEY_DIGIT_CAPACITY = "digit_capacity";
	public static final String KEY_DESIGNATED_SECTION = "designated_section";
	
	private String key;
	private String name;
	private int resultCount;
	private EnabledStatus usable;
	private YesNoStatus allowDuplicated;     //结果是否可重复
	private ResultRegionType resultRegionType;
	private Integer minDigit;//针对数字区间类型
	private Integer maxDigit;//针对数字区间类型
	private Integer digitCapacity;//针对数字区间类型，0为不限制，其他值根据情况做长度判断或补0操作
	private String designatedSection;//针对指定号码范围类型，存储为JSON字符串数组，录入时可以简易为英文逗号隔开的字符串，保存时做格式校验 
	
	public static JSONObject toJSONObject(LotteryResultItem lotteryResultItem) {
		JSONObject object = new JSONObject();
		if (lotteryResultItem != null) {
			//转换默认配置
			object.put(LotteryResultItem.KEY_KEY, lotteryResultItem.getKey());
			object.put(LotteryResultItem.KEY_NAME, lotteryResultItem.getName());
			object.put(LotteryResultItem.KEY_RESULT_COUNT, lotteryResultItem.getResultCount());
			object.put(LotteryResultItem.KEY_USABLE, lotteryResultItem.getUsable() == null ? EnabledStatus.ENABLED.getValue() : lotteryResultItem.getUsable().getValue());
			object.put(LotteryResultItem.KEY_ALLOW_DUPLICATED, lotteryResultItem.getAllowDuplicated() == null ? YesNoStatus.YES.getValue() : lotteryResultItem.getAllowDuplicated().getValue());
			object.put(LotteryResultItem.KEY_RESULT_REGION_TYPE, lotteryResultItem.getResultRegionType() == null ? ResultRegionType.DIGITAL_SECTION.getValue() : lotteryResultItem.getResultRegionType().getValue());
			if (lotteryResultItem.getMinDigit() != null) {
				object.put(LotteryResultItem.KEY_MIN_DIGIT, lotteryResultItem.getMinDigit());
			}
			if (lotteryResultItem.getMaxDigit() != null) {
				object.put(LotteryResultItem.KEY_MAX_DIGIT, lotteryResultItem.getMaxDigit());
			}
			if (lotteryResultItem.getDigitCapacity() != null) {
				object.put(LotteryResultItem.KEY_DIGIT_CAPACITY, lotteryResultItem.getDigitCapacity());
			}
			if (lotteryResultItem.getDesignatedSection() != null) {
				String[] designatedSectionArray = StringUtils.split(lotteryResultItem.getDesignatedSection(), ",");
				JSONArray jsonArray = new JSONArray();
				for (String designatedSection : designatedSectionArray) {
					jsonArray.add(designatedSection);
				}
				object.put(LotteryResultItem.KEY_DESIGNATED_SECTION, jsonArray);
			}
		}
		return object;
	}
	
	public static LotteryResultItem convertFromJSONObject(JSONObject obj) {
		if (obj == null || obj.isNullObject()) {
			return null;
		}
		LotteryResultItem lotteryResultItem = new LotteryResultItem();
		if (obj.containsKey(LotteryResultItem.KEY_KEY)) {
			String key = null;
			try {
				key = obj.getString(LotteryResultItem.KEY_KEY);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj);
				logger.error(e.getMessage(), e);
			}
			lotteryResultItem.setKey(key);
		}
		if (obj.containsKey(LotteryResultItem.KEY_NAME)) {
			String name = null;
			try {
				name = obj.getString(LotteryResultItem.KEY_NAME);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj);
				logger.error(e.getMessage(), e);
			}
			lotteryResultItem.setName(name);
		}
		if (obj.containsKey(LotteryResultItem.KEY_RESULT_COUNT)) {
			int resultCount = 0;
			try {
				resultCount = obj.getInt(LotteryResultItem.KEY_RESULT_COUNT);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj);
				logger.error(e.getMessage(), e);
			}
			lotteryResultItem.setResultCount(resultCount);
		}
		if (obj.containsKey(LotteryResultItem.KEY_USABLE)) {
			EnabledStatus usable = EnabledStatus.DISABLED;
			try {
				usable = EnabledStatus.getItem(obj.getInt(LotteryResultItem.KEY_USABLE));
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj);
				logger.error(e.getMessage(), e);
			}
			lotteryResultItem.setUsable(usable);
		}
		if (obj.containsKey(LotteryResultItem.KEY_ALLOW_DUPLICATED)) {
			YesNoStatus allowDuplicated = YesNoStatus.YES;
			try {
				allowDuplicated = YesNoStatus.getItem(obj.getInt(LotteryResultItem.KEY_ALLOW_DUPLICATED));
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj);
				logger.error(e.getMessage(), e);
			}
			lotteryResultItem.setAllowDuplicated(allowDuplicated);
		}
		if (obj.containsKey(LotteryResultItem.KEY_RESULT_REGION_TYPE)) {
			ResultRegionType resultRegionType = ResultRegionType.DIGITAL_SECTION;
			try {
				resultRegionType = ResultRegionType.getItem(obj.getInt(LotteryResultItem.KEY_RESULT_REGION_TYPE));
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj);
				logger.error(e.getMessage(), e);
			}
			lotteryResultItem.setResultRegionType(resultRegionType);
		}
		if (obj.containsKey(LotteryResultItem.KEY_MIN_DIGIT)) {
			int minDigit = 0;
			try {
				minDigit = obj.getInt(LotteryResultItem.KEY_MIN_DIGIT);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj);
				logger.error(e.getMessage(), e);
			}
			lotteryResultItem.setMinDigit(minDigit);
		}
		if (obj.containsKey(LotteryResultItem.KEY_MAX_DIGIT)) {
			int maxDigit = 0;
			try {
				maxDigit = obj.getInt(LotteryResultItem.KEY_MAX_DIGIT);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj);
				logger.error(e.getMessage(), e);
			}
			lotteryResultItem.setMaxDigit(maxDigit);
		}
		if (obj.containsKey(LotteryResultItem.KEY_DIGIT_CAPACITY)) {
			int digitCapacity = 0;
			try {
				digitCapacity = obj.getInt(LotteryResultItem.KEY_DIGIT_CAPACITY);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj);
				logger.error(e.getMessage(), e);
			}
			lotteryResultItem.setDigitCapacity(digitCapacity);
		}
		if (obj.containsKey(LotteryResultItem.KEY_DESIGNATED_SECTION)) {
			String designatedSection = null;
			try {
				JSONArray designatedSectionArray = obj.getJSONArray(LotteryResultItem.KEY_DESIGNATED_SECTION);
				designatedSection = StringUtils.join(designatedSectionArray.iterator(), ",");
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj);
				logger.error(e.getMessage(), e);
			}
			lotteryResultItem.setDesignatedSection(designatedSection);
		}
		
		return lotteryResultItem;
	}
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
	public int getResultCount() {
		return resultCount;
	}
	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}

	public EnabledStatus getUsable() {
		return usable;
	}

	public void setUsable(EnabledStatus usable) {
		this.usable = usable;
	}

	public int getUsableValue() {
		if (usable != null) {
			return usable.getValue();
		}
		return EnabledStatus.DISABLED.getValue();
	}

	public void setUsableValue(int usableValue) {
		usable = EnabledStatus.getItem(usableValue);
		if (usable == null) {
			usable = EnabledStatus.DISABLED;
		}
	}

	public YesNoStatus getAllowDuplicated() {
		return allowDuplicated;
	}

	public void setAllowDuplicated(YesNoStatus allowDuplicated) {
		this.allowDuplicated = allowDuplicated;
	}
	
	public int getAllowDuplicatedValue() {
		if (allowDuplicated != null) {
			return allowDuplicated.getValue();
		}
		return YesNoStatus.YES.getValue();
	}
	
	public void setAllowDuplicatedValue(int allowDuplicatedValue) {
		allowDuplicated = YesNoStatus.getItem(allowDuplicatedValue);
		if (allowDuplicated == null) {
			allowDuplicated = YesNoStatus.YES;
		}
	}

	public ResultRegionType getResultRegionType() {
		return resultRegionType;
	}

	public void setResultRegionType(ResultRegionType resultRegionType) {
		this.resultRegionType = resultRegionType;
	}
	
	public int getResultRegionTypeValue() {
		if (resultRegionType != null) {
			return resultRegionType.getValue();
		}
		return ResultRegionType.DIGITAL_SECTION.getValue();
	}
	
	public void setResultRegionTypeValue(int resultRegionTypeValue) {
		resultRegionType = ResultRegionType.getItem(resultRegionTypeValue);
		if (resultRegionType == null) {
			resultRegionType = ResultRegionType.DIGITAL_SECTION;
		}
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
}
