/**
 * 
 */
package com.lehecai.core.entity.serializer.impl;

import com.lehecai.core.exception.PropDeserializeException;


/**
 * @author qatang
 *
 */
public class LongPropDeserializer extends AbstractPropDeserializer<Long> {

	@Override
	public Long deserialize(String value) throws PropDeserializeException {
		try {
			return Long.valueOf(value);
		} catch (NumberFormatException e) {
			logger.error("转换长整型数据出错, value={}", value);
			throw new PropDeserializeException("转换长整型数据出错");
		}
	}

}
