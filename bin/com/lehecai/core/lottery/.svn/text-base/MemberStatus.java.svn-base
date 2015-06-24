/**
 * 
 */
package com.lehecai.core.lottery;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * @author Sunshow
 * 会员状态
 */
public class MemberStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = -1454860113372053263L;

	private static final Logger logger = LoggerFactory.getLogger(MemberStatus.class.getName());
	
	private static List<MemberStatus> items = new ArrayList<MemberStatus>();
	
	protected MemberStatus(String name, int value) {
		super(MemberStatus.class.getName(), name, value);
		items.add(this);
	}
	
	public static MemberStatus getItem(int value){
		try {
			return (MemberStatus)MemberStatus.getResult(MemberStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<MemberStatus> getItems() {
		return items;
	}
	
	public static final MemberStatus ALL = new MemberStatus("全部", -1);
	public static final MemberStatus DEFAULT = new MemberStatus("默认", 0);
	
	public static final MemberStatus NORMAL = new MemberStatus("正常", 1);
	public static final MemberStatus LOCKED = new MemberStatus("锁定", 2);
	public static final MemberStatus DISABLED = new MemberStatus("禁用", 3);
	public static final MemberStatus SYSTEM = new MemberStatus("后台用户", 4);
	public static final MemberStatus DELETED = new MemberStatus("注销", 5);

}
