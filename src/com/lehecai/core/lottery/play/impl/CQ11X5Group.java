/**
 * 
 */
package com.lehecai.core.lottery.play.impl;

import com.lehecai.core.lottery.PlayType;
import com.lehecai.core.lottery.play.BaseGroup;
import com.lehecai.core.lottery.play.GroupDefinition;

/**
 * 重庆11选5格式定义
 * @author qatang
 *
 */
public class CQ11X5Group {
	
	static {
		BaseGroup.add(PlayType.CQ11X5_R1_BZ_DS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1)
				}, 1);
		
		BaseGroup.add(PlayType.CQ11X5_R1_BZ_FS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 11, 1)
				}, 0);
		
		BaseGroup.add(PlayType.CQ11X5_R2_BZ_DS, new GroupDefinition[] {
				new GroupDefinition(2, 0, 0, 2, 2)
				}, 5);
		
		BaseGroup.add(PlayType.CQ11X5_R2_BZ_FS, new GroupDefinition[] {
				new GroupDefinition(2, 0, 0, 11, 2)
				}, 1);
		
		BaseGroup.add(PlayType.CQ11X5_R3_BZ_DS, new GroupDefinition[] {
				new GroupDefinition(3, 0, 0, 3, 3)
				}, 5);
		
		BaseGroup.add(PlayType.CQ11X5_R3_BZ_FS, new GroupDefinition[] {
				new GroupDefinition(3, 0, 0, 11, 3)
				}, 1);
		
		BaseGroup.add(PlayType.CQ11X5_R4_BZ_DS, new GroupDefinition[] {
				new GroupDefinition(4, 0, 0, 4, 4)
				}, 5);
		
		BaseGroup.add(PlayType.CQ11X5_R4_BZ_FS, new GroupDefinition[] {
				new GroupDefinition(4, 0, 0, 11, 4)
				}, 1);
		
		BaseGroup.add(PlayType.CQ11X5_R5_BZ_DS, new GroupDefinition[] {
				new GroupDefinition(5, 0, 0, 5, 5)
				}, 5);
		
		BaseGroup.add(PlayType.CQ11X5_R5_BZ_FS, new GroupDefinition[] {
				new GroupDefinition(5, 0, 0, 11, 5)
				}, 1);
		
		BaseGroup.add(PlayType.CQ11X5_R6_BZ_DS, new GroupDefinition[] {
				new GroupDefinition(6, 0, 0, 6, 6)
				}, 5);
		
		BaseGroup.add(PlayType.CQ11X5_R6_BZ_FS, new GroupDefinition[] {
				new GroupDefinition(6, 0, 0, 11, 6)
				}, 1);
		
		BaseGroup.add(PlayType.CQ11X5_R7_BZ_DS, new GroupDefinition[] {
				new GroupDefinition(7, 0, 0, 7, 7)
				}, 5);
		
		BaseGroup.add(PlayType.CQ11X5_R7_BZ_FS, new GroupDefinition[] {
				new GroupDefinition(7, 0, 0, 11, 7)
				}, 1);
		
		BaseGroup.add(PlayType.CQ11X5_R8_BZ_DS, new GroupDefinition[] {
				new GroupDefinition(8, 0, 0, 8, 8)
				}, 5);
		
		BaseGroup.add(PlayType.CQ11X5_R8_BZ_FS, new GroupDefinition[] {
				new GroupDefinition(8, 0, 0, 11, 8)
				}, 1);
		
		BaseGroup.add(PlayType.CQ11X5_R2_DT, new GroupDefinition[] {
				new GroupDefinition(2, 1, 1, 10, 1)
				}, 1);
		
		BaseGroup.add(PlayType.CQ11X5_R3_DT, new GroupDefinition[] {
				new GroupDefinition(3, 2, 1, 10, 1)
				}, 1);
		
		BaseGroup.add(PlayType.CQ11X5_R4_DT, new GroupDefinition[] {
				new GroupDefinition(4, 3, 1, 10, 1)
				}, 1);
		
		BaseGroup.add(PlayType.CQ11X5_R5_DT, new GroupDefinition[] {
				new GroupDefinition(5, 4, 1, 10, 1)
				}, 1);
		
		BaseGroup.add(PlayType.CQ11X5_R6_DT, new GroupDefinition[] {
				new GroupDefinition(6, 5, 1, 10, 1)
				}, 1);
		
		BaseGroup.add(PlayType.CQ11X5_R7_DT, new GroupDefinition[] {
				new GroupDefinition(7, 6, 1, 10, 1)
				}, 1);
		
		BaseGroup.add(PlayType.CQ11X5_R8_DT, new GroupDefinition[] {
				new GroupDefinition(8, 7, 1, 10, 1)
				}, 1);
		
		BaseGroup.add(PlayType.CQ11X5_Q2_DS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1),
				new GroupDefinition(1, 0, 0, 1, 1)
				}, 5);
		
		BaseGroup.add(PlayType.CQ11X5_Q2_FS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 10, 1),
				new GroupDefinition(1, 0, 0, 10, 1)
				}, 1);
		
		BaseGroup.add(PlayType.CQ11X5_Q3_DS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1),
				new GroupDefinition(1, 0, 0, 1, 1),
				new GroupDefinition(1, 0, 0, 1, 1)
				}, 5);
		
		BaseGroup.add(PlayType.CQ11X5_Q3_FS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 9, 1),
				new GroupDefinition(1, 0, 0, 9, 1),
				new GroupDefinition(1, 0, 0, 9, 1)
				}, 1);
		
		BaseGroup.add(PlayType.CQ11X5_Q2ZX_DS, new GroupDefinition[] {
				new GroupDefinition(2, 0, 0, 2, 2)
				}, 5);
		
		BaseGroup.add(PlayType.CQ11X5_Q2ZX_FS, new GroupDefinition[] {
				new GroupDefinition(2, 0, 0, 11, 2)
				}, 1);
		
		BaseGroup.add(PlayType.CQ11X5_Q3ZX_DS, new GroupDefinition[] {
				new GroupDefinition(3, 0, 0, 3, 3)
				}, 5);
		
		BaseGroup.add(PlayType.CQ11X5_Q3ZX_FS, new GroupDefinition[] {
				new GroupDefinition(3, 0, 0, 11, 3)
				}, 1);

	}
	
	public static void init() {
		
	}

}
