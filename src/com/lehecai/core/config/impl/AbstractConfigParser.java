package com.lehecai.core.config.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.config.IConfigItem;
import com.lehecai.core.config.IConfigParser;

public abstract class AbstractConfigParser implements IConfigParser {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public String getGlobalItemKey() {
		return "global";
	} 

	@Override
	public String getDefaultItemKey() {
		return "default";
	}

	@Override
	public boolean hasDefaultItem() {
		return false;
	}

	@Override
	public boolean hasGlobalItem() {
		return false;
	}

	/**
	 * 添加自定义的item
	 * @param itemList
	 */
	protected List<String> getExtraItemList() {
		return null;
	}

	protected List<String> getSupportedItemList() {
		return null;
	}
	
	@Override
	public List<String> getItemList() {
		List<String> itemList = new ArrayList<String>();

		// 加入默认支持的item
		if (this.hasGlobalItem()) {
			itemList.add(this.getGlobalItemKey());
		}
		if (this.hasDefaultItem()) {
			itemList.add(this.getDefaultItemKey());
		}
		
		// 加入实现支持的item
		List<String> supportedItemList = this.getSupportedItemList();
		if (supportedItemList != null && !supportedItemList.isEmpty()) {
			itemList.addAll(supportedItemList);
		}
		
		// 最后加入额外需要实现支持的item
		List<String> extraItemList = this.getExtraItemList();
		if (extraItemList != null && !extraItemList.isEmpty()) {
			itemList.addAll(extraItemList);
		}
		return itemList;
	}
	
	@Override
	public IConfigItem parseItem(String value) {
		// TODO 先实现一个空方法，回头删除
		return null;
	}

	@Override
	public String formatConfigItem(IConfigItem configItem) {
		// TODO 先实现一个空方法，回头删除
		return null;
	}
	
}
