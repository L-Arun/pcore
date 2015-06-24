package com.lehecai.core.api.bean.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

public class QueryOperator extends IntegerBeanLabelItem {
	
	private static final long serialVersionUID = -7481457796550099979L;

	private static final Logger logger = LoggerFactory.getLogger(QueryOperator.class.getName());

	private static List<QueryOperator> _items = new ArrayList<QueryOperator>();
	
	private static List<QueryOperator> items;
	
	protected QueryOperator(String name, int value) {
		super(QueryOperator.class.getName(), name, value);
		_items.add(this);
	}
	
	public static QueryOperator getItem(int value){
		try {
			return (QueryOperator)QueryOperator.getResult(QueryOperator.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<QueryOperator> getItems() {
		return items;
	}
	
	public final static QueryOperator EQUAL = new QueryOperator("=", 1);
	public final static QueryOperator IN = new QueryOperator("IN", 2);
	public final static QueryOperator LIKE = new QueryOperator("LIKE", 3);
	public final static QueryOperator BETWEEN = new QueryOperator("BETWEEN", 4);
	public final static QueryOperator LESS = new QueryOperator("<", 5);
	public final static QueryOperator GREATER = new QueryOperator(">", 6);
	public final static QueryOperator NULL = new QueryOperator("NULL", 7);
	public final static QueryOperator NOT_NULL = new QueryOperator("NOT_NULL", 8);
	
	static {
		synchronized (_items) {
			items = Collections.unmodifiableList(_items);
		}
	}
}

