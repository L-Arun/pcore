/**
 * 
 */
package com.lehecai.core.test.lottery.plan;

import com.lehecai.core.lottery.plan.PlanContent;
import com.lehecai.core.lottery.plan.util.PlanContentPacker;
import com.lehecai.core.lottery.plan.util.PlanContentUnpacker;

/**
 * @author sunshow
 *
 */
public class PlanContentUnpackerTest {

	public static void main(String[] args) throws Exception {
		String content = "3001:3002,3003%60(3;1),66(1;0)#30(3),27(1;3)|33(1;3)^3000%60(3;1),66(1;0)#30(3),27(1;3)!20";
		PlanContent planContent = PlanContentUnpacker.unpack(content);
		String packed = PlanContentPacker.pack(planContent);
		System.out.println(packed);
	}
	
}
