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
public class OpenAPIAppStatus extends IntegerBeanLabelItem {
	private static final Logger logger = LoggerFactory.getLogger(OpenAPIAppStatus.class.getName());
	private static final long serialVersionUID = -2655180046354667807L;
	
	private static List<OpenAPIAppStatus> items = new ArrayList<OpenAPIAppStatus>();
	
	protected OpenAPIAppStatus(String name, int value) {
		super(OpenAPIAppStatus.class.getName(), name, value);
		items.add(this);
	}
	
	public static OpenAPIAppStatus getItem(int value){
		try {
			return (OpenAPIAppStatus)OpenAPIAppStatus.getResult(OpenAPIAppStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<OpenAPIAppStatus> getItems() {
		return items;
	}

	public static final OpenAPIAppStatus ALL = new OpenAPIAppStatus("全部", -1);
	public static final OpenAPIAppStatus DISABLED = new OpenAPIAppStatus("未启用", 0);
	public static final OpenAPIAppStatus ENABLED = new OpenAPIAppStatus("已启用", 1);
	public static final OpenAPIAppStatus DELETED = new OpenAPIAppStatus("已删除", 2);
}
