/**
 * 
 */
package com.lehecai.core.lottery.ticket;

import org.apache.commons.lang.StringUtils;

import com.lehecai.core.lottery.PlayType;


/**
 * 单注票内容
 * @author sunshow
 *
 */
public class TicketContentLine {
	
	public TicketContentLine() {
		
	}
	
	public TicketContentLine(TicketContentGroup[] groupArray, PlayType playType) {
		this.setGroups(groupArray);
		this.setPlayType(playType);
	}
	
	private PlayType playType;

	/**
	 * 元素组
	 */
	private TicketContentGroup[] groups;

	public TicketContentGroup[] getGroups() {
		return groups;
	}

	public void setGroups(TicketContentGroup[] groups) {
		this.groups = groups;
	}
	
	public PlayType getPlayType() {
		return playType;
	}

	public void setPlayType(PlayType playType) {
		this.playType = playType;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		if (playType != null) {
			sb.append(playType.getValue()).append(TicketContentConstant.PLAY);
		}
		sb.append(StringUtils.join(groups, TicketContentConstant.GROUP));
		return sb.toString();
	}
}
