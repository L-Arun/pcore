package com.lehecai.core.api.openapi;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * @author yanweijie
 * 更新策略
 *
 */
public class OpenAPIAppUpdatePolicyStatus extends IntegerBeanLabelItem {
	private static final Logger logger = LoggerFactory.getLogger(OpenAPIAppUpdatePolicyStatus.class.getName());
	private static final long serialVersionUID = -2655180046354667807L;
	
	private static List<OpenAPIAppUpdatePolicyStatus> items = new ArrayList<OpenAPIAppUpdatePolicyStatus>();
	
	protected OpenAPIAppUpdatePolicyStatus(String name, int value) {
		super(OpenAPIAppUpdatePolicyStatus.class.getName(), name, value);
		items.add(this);
	}
	
	public static OpenAPIAppUpdatePolicyStatus getItem(int value){
		try {
			return (OpenAPIAppUpdatePolicyStatus)OpenAPIAppUpdatePolicyStatus.getResult(OpenAPIAppUpdatePolicyStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<OpenAPIAppUpdatePolicyStatus> getItems() {
		return items;
	}

	public static final OpenAPIAppUpdatePolicyStatus ALL = new OpenAPIAppUpdatePolicyStatus("全部", -1);
	public static final OpenAPIAppUpdatePolicyStatus NO_UPDATE = new OpenAPIAppUpdatePolicyStatus("不用更新", 1);
	public static final OpenAPIAppUpdatePolicyStatus ADVISE_UPDATE = new OpenAPIAppUpdatePolicyStatus("建议更新", 2);
	public static final OpenAPIAppUpdatePolicyStatus FORCE_UPDATE = new OpenAPIAppUpdatePolicyStatus("强制更新", 3);
}
