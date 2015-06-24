package com.lehecai.core.lottery.plan;

import org.apache.commons.lang.StringUtils;

/**
 * 方案内容元素组定义
 * @author sunshow
 *
 */
public class PlanContentGroup {

	/**
	 * 胆码区域，长度可以为空
	 */
	private PlanContentElement[] dan;
	
	/**
	 * 拖码区域，长度必须>0
	 */
	private PlanContentElement[] tuo;

	public PlanContentElement[] getDan() {
		return dan;
	}

	public void setDan(PlanContentElement[] dan) {
		this.dan = dan;
	}

	public PlanContentElement[] getTuo() {
		return tuo;
	}

	public void setTuo(PlanContentElement[] tuo) {
		this.tuo = tuo;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		// 如果有胆码
		if (dan != null && dan.length > 0) {
			sb.append(StringUtils.join(dan, PlanContentConstant.ELEMENT));
			sb.append(PlanContentConstant.DANTUO);
		}
		
		// 添加拖码
		sb.append(StringUtils.join(tuo, PlanContentConstant.ELEMENT));
		
		return sb.toString();
	}
	
}
