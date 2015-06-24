package com.lehecai.core.api.openapi;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * @author yanweijie
 *
 */
public class OpenAPIAppType extends IntegerBeanLabelItem {
	private static final Logger logger = LoggerFactory.getLogger(OpenAPIAppType.class.getName());
	private static final long serialVersionUID = -2655180046354667807L;
	
	private static List<OpenAPIAppType> items = new ArrayList<OpenAPIAppType>();
	
	protected OpenAPIAppType(String name, int value) {
		super(OpenAPIAppType.class.getName(), name, value);
		items.add(this);
	}
	
	public static OpenAPIAppType getItem(int value){
		try {
			return (OpenAPIAppType)OpenAPIAppType.getResult(OpenAPIAppType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<OpenAPIAppType> getItems() {
		return items;
	}

	public static final OpenAPIAppType ALL = new OpenAPIAppType("全部", -1);
	public static final OpenAPIAppType OPENAPI_APP_TYPE_DEFAULT = new OpenAPIAppType("默认", 1);
	public static final OpenAPIAppType OPENAPI_APP_TYPE_STD_IOS = new OpenAPIAppType("官方iOS标准版", 2);
	public static final OpenAPIAppType OPENAPI_APP_TYPE_STD_ANDROID = new OpenAPIAppType("官方Android标准版", 3);
	public static final OpenAPIAppType OPENAPI_APP_TYPE_LITE_IOS = new OpenAPIAppType("官方iOS简版", 4);
	public static final OpenAPIAppType OPENAPI_APP_TYPE_LITE_ANDROID = new OpenAPIAppType("官方Android简版", 5);
	public static final OpenAPIAppType OPENAPI_APP_TYPE_NON_OFFICIAL = new OpenAPIAppType("非官方", 30);
}
