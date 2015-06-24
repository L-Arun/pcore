/**
 * 
 */
package com.lehecai.core.entity.serializer.impl;

import com.lehecai.core.exception.PropDeserializeException;


/**
 * @author qatang
 *
 */
public class IntegerPropDeserializer extends AbstractPropDeserializer<Integer> {

	@Override
	public Integer deserialize(String value) throws PropDeserializeException {
		try {
			return Integer.valueOf(value);
		} catch (NumberFormatException e) {
			logger.error("转换整型数据出错, value={}", value);
			throw new PropDeserializeException("转换整型数据出错");
		}
	}

}
