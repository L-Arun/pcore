/**
 * 
 */
package com.lehecai.core.lottery.play.impl;

import com.lehecai.core.lottery.PlayType;
import com.lehecai.core.lottery.play.BaseGroup;
import com.lehecai.core.lottery.play.GroupDefinition;

/**
 * 山东群英会格式定义
 * @author qatang
 *
 */
public class SDQYHGroup {
	
	static {
		BaseGroup.add(PlayType.SDQYH_R1_DS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1)
				}, 5);
		
		BaseGroup.add(PlayType.SDQYH_R1_FS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 23, 1)
				}, 1);
		BaseGroup.add(PlayType.SDQYH_R2_DS, new GroupDefinition[] {
				new GroupDefinition(2, 0, 0, 2, 2)
		}, 5);
		
		BaseGroup.add(PlayType.SDQYH_R2_FS, new GroupDefinition[] {
				new GroupDefinition(2, 0, 0, 23, 2)
		}, 1);
		BaseGroup.add(PlayType.SDQYH_R3_DS, new GroupDefinition[] {
				new GroupDefinition(3, 0, 0, 3, 3)
		}, 5);
		
		BaseGroup.add(PlayType.SDQYH_R3_FS, new GroupDefinition[] {
				new GroupDefinition(3, 0, 0, 23, 3)
		}, 1);
		BaseGroup.add(PlayType.SDQYH_R4_DS, new GroupDefinition[] {
				new GroupDefinition(4, 0, 0, 4, 4)
		}, 5);
		
		BaseGroup.add(PlayType.SDQYH_R4_FS, new GroupDefinition[] {
				new GroupDefinition(4, 0, 0, 23, 4)
		}, 1);
		BaseGroup.add(PlayType.SDQYH_R5_DS, new GroupDefinition[] {
				new GroupDefinition(5, 0, 0, 5, 5)
		}, 5);
		
		BaseGroup.add(PlayType.SDQYH_R5_FS, new GroupDefinition[] {
				new GroupDefinition(5, 0, 0, 23, 5)
		}, 1);
		BaseGroup.add(PlayType.SDQYH_R6_DS, new GroupDefinition[] {
				new GroupDefinition(6, 0, 0, 6, 6)
		}, 5);
		
		BaseGroup.add(PlayType.SDQYH_R6_FS, new GroupDefinition[] {
				new GroupDefinition(6, 0, 0, 23, 6)
		}, 1);
		BaseGroup.add(PlayType.SDQYH_R7_DS, new GroupDefinition[] {
				new GroupDefinition(7, 0, 0, 7, 7)
		}, 1);
		
		BaseGroup.add(PlayType.SDQYH_R7_FS, new GroupDefinition[] {
				new GroupDefinition(7, 0, 0, 23, 7)
		}, 1);
		BaseGroup.add(PlayType.SDQYH_R8_DS, new GroupDefinition[] {
				new GroupDefinition(8, 0, 0, 8, 8)
		}, 1);
		
		BaseGroup.add(PlayType.SDQYH_R8_FS, new GroupDefinition[] {
				new GroupDefinition(8, 0, 0, 23, 8)
		}, 1);
		BaseGroup.add(PlayType.SDQYH_R9_DS, new GroupDefinition[] {
				new GroupDefinition(9, 0, 0, 9, 9)
		}, 1);
		
		BaseGroup.add(PlayType.SDQYH_R9_FS, new GroupDefinition[] {
				new GroupDefinition(9, 0, 0, 23, 9)
		}, 1);
		BaseGroup.add(PlayType.SDQYH_R10_DS, new GroupDefinition[] {
				new GroupDefinition(10, 0, 0, 10, 10)
		}, 1);
		
		BaseGroup.add(PlayType.SDQYH_R10_FS, new GroupDefinition[] {
				new GroupDefinition(10, 0, 0, 23, 10)
		}, 1);
		BaseGroup.add(PlayType.SDQYH_R2_DT, new GroupDefinition[] {
				new GroupDefinition(2, 1, 1, 22, 1)
				}, 0);
		BaseGroup.add(PlayType.SDQYH_R3_DT, new GroupDefinition[] {
				new GroupDefinition(3, 2, 1, 22, 1)
		}, 0);
		BaseGroup.add(PlayType.SDQYH_R4_DT, new GroupDefinition[] {
				new GroupDefinition(4, 3, 1, 22, 1)
		}, 0);
		BaseGroup.add(PlayType.SDQYH_R5_DT, new GroupDefinition[] {
				new GroupDefinition(5, 4, 1, 22, 1)
		}, 0);
		BaseGroup.add(PlayType.SDQYH_R6_DT, new GroupDefinition[] {
				new GroupDefinition(6, 5, 1, 22, 1)
		}, 0);
		BaseGroup.add(PlayType.SDQYH_R7_DT, new GroupDefinition[] {
				new GroupDefinition(7, 6, 1, 22, 1)
		}, 0);
		BaseGroup.add(PlayType.SDQYH_R8_DT, new GroupDefinition[] {
				new GroupDefinition(8, 7, 1, 22, 1)
		}, 0);
		BaseGroup.add(PlayType.SDQYH_R9_DT, new GroupDefinition[] {
				new GroupDefinition(9, 8, 1, 22, 1)
		}, 0);
		BaseGroup.add(PlayType.SDQYH_R10_DT, new GroupDefinition[] {
				new GroupDefinition(10, 9, 1, 22, 1)
		}, 0);
		
		BaseGroup.add(PlayType.SDQYH_W2_DS, new GroupDefinition[] {
				new GroupDefinition(2, 0, 0, 2, 2)
		}, 5);
		BaseGroup.add(PlayType.SDQYH_W2_FS, new GroupDefinition[] {
				new GroupDefinition(2, 0, 0, 23, 2)
		}, 1);
		BaseGroup.add(PlayType.SDQYH_W2_DT, new GroupDefinition[] {
				new GroupDefinition(2, 1, 1, 22, 1)
		}, 0);
		BaseGroup.add(PlayType.SDQYH_W3_DS, new GroupDefinition[] {
				new GroupDefinition(3, 0, 0, 3, 3)
		}, 5);
		BaseGroup.add(PlayType.SDQYH_W3_FS, new GroupDefinition[] {
				new GroupDefinition(3, 0, 0, 23, 3)
		}, 1);
		BaseGroup.add(PlayType.SDQYH_W3_DT, new GroupDefinition[] {
				new GroupDefinition(3, 2, 1, 22, 1)
		}, 0);
		BaseGroup.add(PlayType.SDQYH_W4_DS, new GroupDefinition[] {
				new GroupDefinition(4, 0, 0, 4, 4)
		}, 5);
		BaseGroup.add(PlayType.SDQYH_W4_FS, new GroupDefinition[] {
				new GroupDefinition(4, 0, 0, 23, 4)
		}, 1);
		BaseGroup.add(PlayType.SDQYH_W4_DT, new GroupDefinition[] {
				new GroupDefinition(4, 3, 1, 22, 1)
		}, 0);
		BaseGroup.add(PlayType.SDQYH_S1_DS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1)
		}, 5);
		BaseGroup.add(PlayType.SDQYH_S1_FS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 23, 1)
		}, 1);
		BaseGroup.add(PlayType.SDQYH_S2_DS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1),
				new GroupDefinition(1, 0, 0, 1, 1)
		}, 5);
		BaseGroup.add(PlayType.SDQYH_S2_FS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 23, 1),
				new GroupDefinition(1, 0, 0, 23, 1)
		}, 1);
		BaseGroup.add(PlayType.SDQYH_S3_DS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1),
				new GroupDefinition(1, 0, 0, 1, 1),
				new GroupDefinition(1, 0, 0, 1, 1)
		}, 5);
		BaseGroup.add(PlayType.SDQYH_S3_FS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 23, 1),
				new GroupDefinition(1, 0, 0, 23, 1),
				new GroupDefinition(1, 0, 0, 23, 1)
		}, 1);
	}
	
	public static void init() {
		
	}

}
