/**
 * 
 */
package com.lehecai.core.lottery.ticket.util;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.lehecai.core.lottery.ticket.TicketContentConstant;
import com.lehecai.core.lottery.ticket.TicketContentLine;

/**
 * @author sunshow
 *
 */
public class TicketContentPacker {

	public static String pack(List<TicketContentLine> list) {
		return StringUtils.join(list, TicketContentConstant.LINE);
	}
	
	public static String pack(TicketContentLine line) {
		return line.toString();
	}
	
	public static String packWithoutPlayType(List<TicketContentLine> list) {
		String[] withoutPlayTypeArray = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			withoutPlayTypeArray[i] = packWithoutPlayType(list.get(i));
		}
		return StringUtils.join(withoutPlayTypeArray, TicketContentConstant.LINE);
	}
	
	public static String packWithoutPlayType(TicketContentLine line) {
		return StringUtils.join(line.getGroups(), TicketContentConstant.GROUP);
	}
}
