/**
 * 
 */
package com.lehecai.core.entity.serializer.impl;

import com.lehecai.core.exception.PropDeserializeException;
import com.lehecai.core.lottery.PlayType;

/**
 * @author qatang
 *
 */
public class PlayTypePropDeserializer extends AbstractPropDeserializer<PlayType> {

	@Override
	public PlayType deserialize(String value) throws PropDeserializeException {
		try {
			return PlayType.getItem(Integer.valueOf(value));
		} catch (NumberFormatException e) {
			logger.error("转换整型数据出错, value={}", value);
			throw new PropDeserializeException("转换整型数据出错");
		}
	}

}
