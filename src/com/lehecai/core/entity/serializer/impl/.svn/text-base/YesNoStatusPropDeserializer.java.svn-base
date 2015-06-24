/**
 * 
 */
package com.lehecai.core.entity.serializer.impl;

import com.lehecai.core.YesNoStatus;
import com.lehecai.core.exception.PropDeserializeException;

/**
 * @author qatang
 *
 */
public class YesNoStatusPropDeserializer extends AbstractPropDeserializer<YesNoStatus> {

	@Override
	public YesNoStatus deserialize(String value) throws PropDeserializeException {
		try {
			return YesNoStatus.getItem(Integer.valueOf(value));
		} catch (NumberFormatException e) {
			logger.error("转换整型数据出错, value={}", value);
			throw new PropDeserializeException("转换整型数据出错");
		}
	}

}
