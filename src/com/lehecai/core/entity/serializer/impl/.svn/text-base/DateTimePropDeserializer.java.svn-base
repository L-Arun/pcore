/**
 * 
 */
package com.lehecai.core.entity.serializer.impl;

import java.util.Date;

import com.lehecai.core.exception.PropDeserializeException;
import com.lehecai.core.util.CoreDateUtils;

/**
 * @author qatang
 *
 */
public class DateTimePropDeserializer extends AbstractPropDeserializer<Date> {

	@Override
	public Date deserialize(String value) throws PropDeserializeException {
		try {
			return CoreDateUtils.parseLongDate(value);
		} catch (Exception e) {
			logger.error("转换日期类型出错, value={}", value);
			throw new PropDeserializeException("转换日期类型出错");
		}
	}

}
