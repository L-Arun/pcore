/**
 * 
 */
package com.lehecai.core.entity.serializer.impl;

import com.lehecai.core.exception.PropDeserializeException;
import com.lehecai.core.lottery.LotteryType;

/**
 * @author qatang
 *
 */
public class LotteryTypePropDeserializer extends AbstractPropDeserializer<LotteryType> {

	@Override
	public LotteryType deserialize(String value) throws PropDeserializeException {
		try {
			return LotteryType.getItem(Integer.valueOf(value));
		} catch (NumberFormatException e) {
			logger.error("转换整型数据出错, value={}", value);
			throw new PropDeserializeException("转换整型数据出错");
		}
	}

}
