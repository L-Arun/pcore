package com.lehecai.core.api.bean.query.type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

public class QueryDataSourceType extends IntegerBeanLabelItem {
	
	private static final long serialVersionUID = -4510087642814842880L;

	private static final Logger logger = LoggerFactory.getLogger(QueryDataSourceType.class.getName());

	private static List<QueryDataSourceType> _items = new ArrayList<QueryDataSourceType>();
	
	private static List<QueryDataSourceType> items;
	
	protected QueryDataSourceType(String name, int value) {
		super(QueryDataSourceType.class.getName(), name, value);
		_items.add(this);
	}
	
	public static QueryDataSourceType getItem(int value){
		try {
			return (QueryDataSourceType)QueryDataSourceType.getResult(QueryDataSourceType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<QueryDataSourceType> getItems() {
		return items;
	}
	
	public final static QueryDataSourceType AUTO = new QueryDataSourceType("自动选择", 0);
	public final static QueryDataSourceType ACTIVE = new QueryDataSourceType("活跃数据", 1);
	public final static QueryDataSourceType ACHIVED = new QueryDataSourceType("归档数据", 2);
	public final static QueryDataSourceType SEARCH = new QueryDataSourceType("索引数据", 3);
	
	static {
		synchronized (_items) {
			items = Collections.unmodifiableList(_items);
		}
	}
}

