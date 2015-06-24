/**
 * 
 */
package com.lehecai.core.test.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.lehecai.core.memcached.IMemcachedObject;
import com.lehecai.core.memcached.MemcachedConfig;
import com.lehecai.core.service.impl.memcached.SpyMemcachedPoolServiceImpl;

/**
 * @author sunshow
 *
 */
public class MemcachedTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		MemcachedConfig memcachedConfig = new MemcachedConfig();
		memcachedConfig.setHostname("172.16.1.136");
		memcachedConfig.setPort(11212);
		memcachedConfig.setTimeout(5);
		
		SpyMemcachedPoolServiceImpl memcachedService = new SpyMemcachedPoolServiceImpl();
		memcachedService.setMemcachedConfig(memcachedConfig);
		
		MemTestObj obj1 = new MemTestObj("obj1");
		MemTestObj obj2 = new MemTestObj("obj2");
		
		memcachedService.set("key1", obj1, 0);
		memcachedService.set("key2", obj2, 0);
		
		List<String> keyList = new ArrayList<String>();
		keyList.add("key1");
		keyList.add("key2");
		keyList.add("key3");
		
		Map<String, IMemcachedObject> result = memcachedService.mget(keyList, 5);
		for (Iterator<String> iterator = result.keySet().iterator(); iterator.hasNext();) {
			String key = iterator.next();
			MemTestObj obj = (MemTestObj) result.get(key);
			if (obj != null) {
				System.out.println(obj.getTest());
			}
		}
		
		//memcachedService.destroy();
	}

}

class MemTestObj implements IMemcachedObject {
	private static final long serialVersionUID = -2485367377172948438L;
	private String test;
	
	public MemTestObj(String s) {
		this.setTest(s);
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
}
