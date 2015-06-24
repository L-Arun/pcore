/**
 * 
 */
package com.lehecai.core.test.lottery.ticket;

import java.util.List;

import com.lehecai.core.lottery.ticket.TicketContentLine;
import com.lehecai.core.lottery.ticket.util.TicketContentPacker;
import com.lehecai.core.lottery.ticket.util.TicketContentUnpacker;

/**
 * @author sunshow
 *
 */
public class TicketContentUnpackerTest {

	public static void main(String[] args) throws Exception {
		String content = "30(3),27(1;3)|33(1;3)^60(3;1),66(1;0)^01,02,03,04,05,06,07,08|01,02,03";
		List<TicketContentLine> list = TicketContentUnpacker.unpack(content);
		
		String packed = TicketContentPacker.packWithoutPlayType(list);
		System.out.println(packed);
	}
	
}
