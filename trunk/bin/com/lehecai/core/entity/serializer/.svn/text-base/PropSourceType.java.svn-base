package com.lehecai.core.entity.serializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * 数据来源属性
 * @author sunshow
 *
 */
public class PropSourceType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = -5323565792970462627L;

	private static final Logger logger = LoggerFactory.getLogger(PropSourceType.class.getName());

	protected PropSourceType(String name, int value) {
		super(PropSourceType.class.getName(), name, value);
	}
	
	public static PropSourceType getItem(int value){
		try {
			return (PropSourceType)PropSourceType.getResult(PropSourceType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	public final static PropSourceType DEFAULT = new PropSourceType("默认", 0);
	public final static PropSourceType JAVA_PROPERTY = new PropSourceType("Java对象属性", 1);
	public final static PropSourceType JSON_PROPERTY = new PropSourceType("JSON对象属性", 2);
	public final static PropSourceType DATABASE_COLUMN = new PropSourceType("数据库列名", 3);
}

