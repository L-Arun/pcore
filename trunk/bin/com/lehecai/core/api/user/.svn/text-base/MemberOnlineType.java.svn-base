/**
 * 
 */
package com.lehecai.core.api.user;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * @author yanweijie
 */
public class MemberOnlineType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = -8013814461233302001L;

	private static final Logger logger = LoggerFactory.getLogger(MemberOnlineType.class.getName());
	
	private static List<MemberOnlineType> items = new ArrayList<MemberOnlineType>();
	
	protected MemberOnlineType(String name, int value) {
		super(MemberOnlineType.class.getName(), name, value);
		
		items.add(this);
	}
	
	public static MemberOnlineType getItem(int value){
		try {
			return (MemberOnlineType)MemberOnlineType.getResult(MemberOnlineType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<MemberOnlineType> getItems() {
		return items;
	}

	public static final MemberOnlineType WEB_WAP = new MemberOnlineType("标准session", 1);
	public static final MemberOnlineType MOBILE_CLIENT = new MemberOnlineType("手机客户端session", 2);

}
