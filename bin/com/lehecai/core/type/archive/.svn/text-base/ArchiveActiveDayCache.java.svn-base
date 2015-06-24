/**
 * 
 */
package com.lehecai.core.type.archive;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qatang
 *
 */
public class ArchiveActiveDayCache {
	private static final Logger logger = LoggerFactory.getLogger(ArchiveActiveDayCache.class.getName());
	
	private static Map<ArchiveEntityKey, Integer> activeDayMap = new HashMap<ArchiveEntityKey, Integer>();
	private static final int defaultActiveDay = 14;
	
	public static int getActiveDay(ArchiveEntityKey archiveEntityKey) {
		int time = defaultActiveDay;
		try {
			time = activeDayMap.get(archiveEntityKey);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return time;
	}
	
	static {
		activeDayMap.put(ArchiveEntityKey.TICKET, 14);
	}
}
