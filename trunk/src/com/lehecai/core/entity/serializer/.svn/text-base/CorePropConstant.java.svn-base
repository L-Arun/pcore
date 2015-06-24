/**
 * 
 */
package com.lehecai.core.entity.serializer;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.PropDeserializeException;

/**
 * @author qatang
 *
 */
public abstract class CorePropConstant<T> {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private List<String> keyList = new ArrayList<String>(64);

	private Map<String, String> sourceTypeKeyToAliasMap = new HashMap<String, String>(256);
	
	private Map<String, String> aliasToKeyMap = new HashMap<String, String>(256);
	private Map<String, Class<?>> keyToClassMap = new HashMap<String, Class<?>>(256);
	
	private Map<String, IPropDeserializer<?>> customKeyToDeserializerMap = new HashMap<String, IPropDeserializer<?>>(256);

	protected String generateSourceTypeKey(String key, PropSourceType sourceType) {
		return key + "_" + sourceType.getValue();
	}

	protected void register(String key, String alias) {
		aliasToKeyMap.put(alias, key);
	}

	protected void register(String key, PropSourceType sourceType, String alias) {
		String sourceTypeKey = generateSourceTypeKey(key, sourceType);
		sourceTypeKeyToAliasMap.put(sourceTypeKey, alias);
	}
	
	protected void register(String key, Class<?> clazz) {
		keyToClassMap.put(key, clazz);
	}
	
	protected void register(String key, IPropDeserializer<?> deserializer) {
		if (deserializer != null) {
			customKeyToDeserializerMap.put(key, deserializer);
		}
	}
	
	/**
	 * 将key本身注册成默认别名
	 * @param key
	 */
	protected void register(String key) {
		register(key, key);
		register(key, PropSourceType.DEFAULT, key);
		
		keyList.add(key);
	}
	
	protected void register(String key, PropSourceType sourceType, String alias, Class<?> clazz) {
		register(key, sourceType, alias, clazz, null);
	}
	
	protected void register(String key, PropSourceType sourceType, String alias, Class<?> clazz, IPropDeserializer<?> deserializer) {
		register(key, sourceType, alias);

		register(key, alias);
		
		register(key);

		register(key, clazz);
		
		register(key, deserializer);
	}

	protected void register(String key, PropSourceType[] sourceTypes, String alias, Class<?> clazz) {
		register(key, sourceTypes, alias, clazz, null);
	}
	
	protected void register(String key, PropSourceType[] sourceTypes, String[] alias, Class<?> clazz) {
		register(key, sourceTypes, alias, clazz, null);
	}

	
	protected void register(String key, PropSourceType[] sourceTypes, String alias, Class<?> clazz, IPropDeserializer<?> deserializer) {
		for (int i = 0, imax = sourceTypes.length; i < imax; i++) {
			register(key, sourceTypes[i], alias);
		}

		register(key, alias);
		
		register(key);

		register(key, clazz);
		
		register(key, deserializer);
	}
	
	protected void register(String key, PropSourceType[] sourceTypes, String[] alias, Class<?> clazz, IPropDeserializer<?> deserializer) {
		for (int i = 0, imax = sourceTypes.length; i < imax; i++) {
			register(key, sourceTypes[i], alias[i]);
			register(key, alias[i]);
		}
		
		register(key);
		
		register(key, clazz);
		
		register(key, deserializer);
	}

	public String getPropKey(String alias) {
		return aliasToKeyMap.get(alias);
	}

	public String getPropByAlias(String alias, PropSourceType sourceType) {
		String key = this.getPropKey(alias);
		if (key == null) {
			logger.warn("未找到别名对应的key, alias={}", alias);
			return null;
		}
		return this.getProp(key, sourceType);
	}
	
	public String getProp(String key, PropSourceType sourceType) {
		String sourceTypeKey = this.generateSourceTypeKey(key, sourceType);
		return sourceTypeKeyToAliasMap.get(sourceTypeKey);
	}

	public Class<?> getPropClassByAlias(String alias) {
		String key = aliasToKeyMap.get(alias);
		if (key == null) {
			logger.error("未找到别名对应的key, alias={}", alias);
			return null;
		}
		return keyToClassMap.get(key);
	}

	public List<Object> convertPropByAlias(String alias, String[] values) throws PropDeserializeException {
		IPropDeserializer<?> deserializer = this.getPropDeserializer(alias);
		if (deserializer == null) {
			logger.error("未找到别名对应的转换器, alias={}", alias);
			return null;
		}
		List<Object> objectList = new ArrayList<Object>();
		for (String value : values) {
			Object object = deserializer.deserialize(value);
			objectList.add(object);
		}
		return objectList;
	}

	public IPropDeserializer<?> getPropDeserializer(String alias) {
		Class<?> clazz = this.getPropClassByAlias(alias);
		if (clazz == null) {
			logger.error("未找到别名对应的class, alias={}", alias);
			return null;
		}
		return this.getPropDeserializerMap().getDeserializer(clazz);
	}
	
	public Object convertPropByAlias(String alias, String value) throws PropDeserializeException {
		IPropDeserializer<?> deserializer = this.getPropDeserializer(alias);
		if (deserializer == null) {
			logger.error("未找到别名对应的转换器, alias={}", alias);
			return null;
		}
		return deserializer.deserialize(value);
	}
	
	abstract protected CorePropDeserializerMap getPropDeserializerMap();
	
	@SuppressWarnings("unchecked")
	protected Class<T> getObjectActualType() {
		ParameterizedType paramType = (ParameterizedType)this.getClass().getGenericSuperclass();
		
		Class<T> clazz = (Class<T>)paramType.getActualTypeArguments()[0];
		
		return clazz;
	}

	protected T createObjectInstance() {
		try {
			return this.getObjectActualType().newInstance();
		} catch (Exception e) {
			logger.error("实例化对象出错", e);
		}
		return null;
	}

	public T convertFromObject(Object srcObject, PropSourceType srcType, PropSourceType desType) {
		if (srcObject == null) {
			return null;
		}

		T object= this.createObjectInstance();
		if (object == null) {
			return null;
		}

		for (String key : this.keyList) {
			String srcAlias = this.getProp(key, srcType);
			String desAlias = this.getProp(key, desType);
			
			if (srcAlias == null || desAlias == null) {
				logger.warn("来源数据字段别名或目标数据字段别名未找到, 调过, src={}, des={}", srcAlias, desAlias);
				continue;
			}
			
			try {
				if (PropertyUtils.isReadable(srcObject, srcAlias)) {
					Object srcValue = PropertyUtils.getProperty(srcObject, srcAlias);
					if (PropertyUtils.isWriteable(object, desAlias)) {
						PropertyUtils.setProperty(object, desAlias, srcValue);
					}
				}
			} catch (Exception e) {
				logger.error("转换原始数据出错", e);
				return null;
			}
		}
		
		return object;
	}
	
	public T convertFromJSONObject(JSONObject jsonObject) {
		if (jsonObject == null) {
			return null;
		}

		T object= this.createObjectInstance();
		if (object == null) {
			return null;
		}

		for (Object obj : jsonObject.keySet()) {
			String alias = (String) obj;
			String value = jsonObject.getString(alias);
			
			String name = this.getPropByAlias(alias, PropSourceType.JAVA_PROPERTY);
			if (StringUtils.isEmpty(name)) {
				logger.warn("查询别名转换错误，未找到别名[{}]对应的java属性", alias);
				continue;
			}
			Object valueObj = null;
			try {
				valueObj = this.convertPropByAlias(alias, value);
			} catch (PropDeserializeException e) {
				logger.error("转换结果对象出错, alias={}, value={}", alias, value);
				logger.error(e.getMessage(), e);
			}
			
			if (valueObj == null) {
				continue;
			}
			
			try {
				BeanUtils.setProperty(object, name, valueObj);
			} catch (Exception e) {
				logger.error("往实例中设置属性失败, name={}, value={}", name, value);
			}
		}
		
		return object;
	}
}
