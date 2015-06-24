/**
 * 
 */
package com.lehecai.core.warning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * @author Sunshow
 * 警告类型
 */
public class WarningMethod extends IntegerBeanLabelItem {

	private static final long serialVersionUID = -4738646145844329579L;
	private static final Logger logger = LoggerFactory.getLogger(WarningMethod.class.getName());
	
	protected WarningMethod(String name, int value) {
		super(WarningMethod.class.getName(), name, value);
	}
	
	public static WarningMethod getItem(int value){
		try {
			return (WarningMethod)WarningMethod.getResult(WarningMethod.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static final WarningMethod MAIL = new WarningMethod("邮件", 1);
	public static final WarningMethod SMS = new WarningMethod("短信", 2);
	
}
