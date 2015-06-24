/**
 * 
 */
package com.lehecai.core.entity.serializer.impl;

import com.lehecai.core.exception.PropDeserializeException;


/**
 * @author qatang
 *
 */
public class DoublePropDeserializer extends AbstractPropDeserializer<Double> {

	@Override
	public Double deserialize(String value) throws PropDeserializeException {
		try {
			return Double.valueOf(value);
		} catch (NumberFormatException e) {
			logger.error("转换double数据出错, value={}", value);
			throw new PropDeserializeException("转换double数据出错");
		}
	}

}
