package com.lehecai.core.lottery.plan;

import org.apache.commons.lang.StringUtils;

/**
 * 方案内容元素组内单个元素定义
 * @author sunshow
 *
 */
public class PlanContentElement {

	/**
	 * 元素主体
	 */
	private String element;
	
	/**
	 * 元素的属性，例如北单、足彩等的投注内容
	 */
	private String[] attributes;

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public String[] getAttributes() {
		return attributes;
	}

	public void setAttributes(String[] attributes) {
		this.attributes = attributes;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		// 输出元素主体
		sb.append(element);
		
		// 如果存在元素属性
		if (attributes != null && attributes.length > 0) {
			sb.append("(");
			sb.append(StringUtils.join(attributes, PlanContentConstant.ATTRIBUTE));
			sb.append(")");
		}
		
		return sb.toString();
	}
}
