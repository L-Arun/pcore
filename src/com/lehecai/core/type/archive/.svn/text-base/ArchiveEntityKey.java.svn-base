package com.lehecai.core.type.archive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

public class ArchiveEntityKey extends IntegerBeanLabelItem {
	
	private static final long serialVersionUID = 4064263286280291925L;
	
	private static final Logger logger = LoggerFactory.getLogger(ArchiveEntityKey.class.getName());

	private static List<ArchiveEntityKey> _items = new ArrayList<ArchiveEntityKey>();
	
	private static List<ArchiveEntityKey> items;
	
	private static Map<String, ArchiveEntityKey> nameMap = new HashMap<String, ArchiveEntityKey>();

	protected ArchiveEntityKey(String name, int value) {
		super(ArchiveEntityKey.class.getName(), name, value);
		_items.add(this);
		
		nameMap.put(name, this);
	}
	
	public static ArchiveEntityKey getItem(int value){
		try {
			return (ArchiveEntityKey)ArchiveEntityKey.getResult(ArchiveEntityKey.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static ArchiveEntityKey getItemByName(String name) {
		if (nameMap.containsKey(name)) {
			return nameMap.get(name);
		}
		return null;
	}
	
	public static List<ArchiveEntityKey> getItems() {
		return items;
	}
	
	public final static String QUERY_KEY = "key";
	
	public final static String SET_VALUE = "val";
	
	public final static ArchiveEntityKey TICKET = new ArchiveEntityKey("ticket", 1);
	
	public final static ArchiveEntityKey PLAN = new ArchiveEntityKey("plan", 2);
	
	public final static ArchiveEntityKey SMS_LOG = new ArchiveEntityKey("sms_log", 3);
	
	public final static ArchiveEntityKey TICKET_BATCH = new ArchiveEntityKey("ticket_batch", 4);
	
	public final static ArchiveEntityKey RECORD_RECHARGE = new ArchiveEntityKey("record_recharge", 5);
	
	public final static ArchiveEntityKey TMP_PLANTOCONSUME = new ArchiveEntityKey("tmp_plantoconsume", 6);
	
	public final static ArchiveEntityKey LOG_USER_OPERATION = new ArchiveEntityKey("log_user_operation", 7);
	
	public final static ArchiveEntityKey ADMIN_LOG = new ArchiveEntityKey("admin_log", 8);
	
	public final static ArchiveEntityKey WALLET_LOGS = new ArchiveEntityKey("wallet_logs", 9);
	
	public final static ArchiveEntityKey WALLET_FROZEN = new ArchiveEntityKey("wallet_frozen", 10);
	
	static {
		synchronized (_items) {
			items = Collections.unmodifiableList(_items);
		}
	}
}

