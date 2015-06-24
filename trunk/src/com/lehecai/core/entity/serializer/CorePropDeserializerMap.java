/**
 * 
 */
package com.lehecai.core.entity.serializer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.lehecai.core.YesNoStatus;
import com.lehecai.core.entity.serializer.impl.DateTimePropDeserializer;
import com.lehecai.core.entity.serializer.impl.DoublePropDeserializer;
import com.lehecai.core.entity.serializer.impl.IntegerPropDeserializer;
import com.lehecai.core.entity.serializer.impl.LongPropDeserializer;
import com.lehecai.core.entity.serializer.impl.LotteryTypePropDeserializer;
import com.lehecai.core.entity.serializer.impl.PlayTypePropDeserializer;
import com.lehecai.core.entity.serializer.impl.StringPropDeserializer;
import com.lehecai.core.entity.serializer.impl.YesNoStatusPropDeserializer;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.PlayType;

/**
 * @author sunshow
 *
 */
public abstract class CorePropDeserializerMap {

	private static Map<Class<?>, IPropDeserializer<?>> coreDeserializerMap = new HashMap<Class<?>, IPropDeserializer<?>>(256);
	
	private Map<Class<?>, IPropDeserializer<?>> customDeserializerMap = new HashMap<Class<?>, IPropDeserializer<?>>(256);
	
	static {
		coreDeserializerMap.put(String.class, new StringPropDeserializer());
		coreDeserializerMap.put(Integer.class, new IntegerPropDeserializer());
		coreDeserializerMap.put(Long.class, new LongPropDeserializer());
		coreDeserializerMap.put(Double.class, new DoublePropDeserializer());
		coreDeserializerMap.put(Date.class, new DateTimePropDeserializer());
		
		coreDeserializerMap.put(YesNoStatus.class, new YesNoStatusPropDeserializer());
		coreDeserializerMap.put(LotteryType.class, new LotteryTypePropDeserializer());
		coreDeserializerMap.put(PlayType.class, new PlayTypePropDeserializer());
	}
	
	public void register(Class<?> clazz, IPropDeserializer<?> deserializer) {
		if (deserializer != null) {
			customDeserializerMap.put(clazz, deserializer);
		}
	}

	public static IPropDeserializer<?> getDefaultDeserializer(Class<?> clazz) {
		return coreDeserializerMap.get(clazz);
	}
	
	public IPropDeserializer<?> getDeserializer(Class<?> clazz) {
		if (customDeserializerMap.containsKey(clazz)) {
			return customDeserializerMap.get(clazz);
		}
		return getDefaultDeserializer(clazz);
	}
}
