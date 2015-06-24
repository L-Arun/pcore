package com.lehecai.core.lottery.ticket;

import org.apache.commons.lang.StringUtils;

/**
 * 票内容元素组定义
 * @author sunshow
 *
 */
public class TicketContentGroup {

	/**
	 * 胆码区域，长度可以为空
	 */
	private TicketContentElement[] dan;
	
	/**
	 * 拖码区域，长度必须>0
	 */
	private TicketContentElement[] tuo;

	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		// 如果有胆码
		if (dan != null && dan.length > 0) {
			sb.append(StringUtils.join(dan, TicketContentConstant.ELEMENT));
			sb.append(TicketContentConstant.DANTUO);
		}
		
		// 添加拖码
		sb.append(StringUtils.join(tuo, TicketContentConstant.ELEMENT));
		
		return sb.toString();
	}

	public TicketContentElement[] getDan() {
		return dan;
	}

	public void setDan(TicketContentElement[] dan) {
		this.dan = dan;
	}

	public TicketContentElement[] getTuo() {
		return tuo;
	}

	public void setTuo(TicketContentElement[] tuo) {
		this.tuo = tuo;
	}
	
}
