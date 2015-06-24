/**
 * 
 */
package com.lehecai.core.lottery.play.impl;

import com.lehecai.core.lottery.PlayType;
import com.lehecai.core.lottery.play.BaseGroup;
import com.lehecai.core.lottery.play.GroupDefinition;

/**
 * 北京快乐8格式定义
 * @author qatang
 *
 */
public class BJKL8Group {
	
	static {
		BaseGroup.add(PlayType.BJKL8_R1_DS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1)
				}, 2);
		
		BaseGroup.add(PlayType.BJKL8_R1_FS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 80, 1)
				}, 0);
		BaseGroup.add(PlayType.BJKL8_R2_DS, new GroupDefinition[] {
				new GroupDefinition(2, 0, 0, 2, 2)
		}, 2);
		
		BaseGroup.add(PlayType.BJKL8_R2_FS, new GroupDefinition[] {
				new GroupDefinition(2, 0, 0, 80, 2)
		}, 0);
		BaseGroup.add(PlayType.BJKL8_R3_DS, new GroupDefinition[] {
				new GroupDefinition(3, 0, 0, 3, 3)
		}, 2);
		
		BaseGroup.add(PlayType.BJKL8_R3_FS, new GroupDefinition[] {
				new GroupDefinition(3, 0, 0, 80, 3)
		}, 0);
		BaseGroup.add(PlayType.BJKL8_R4_DS, new GroupDefinition[] {
				new GroupDefinition(4, 0, 0, 4, 4)
		}, 2);
		
		BaseGroup.add(PlayType.BJKL8_R4_FS, new GroupDefinition[] {
				new GroupDefinition(4, 0, 0, 80, 4)
		}, 0);
		BaseGroup.add(PlayType.BJKL8_R5_DS, new GroupDefinition[] {
				new GroupDefinition(5, 0, 0, 5, 5)
		}, 2);
		
		BaseGroup.add(PlayType.BJKL8_R5_FS, new GroupDefinition[] {
				new GroupDefinition(5, 0, 0, 80, 5)
		}, 0);
		BaseGroup.add(PlayType.BJKL8_R6_DS, new GroupDefinition[] {
				new GroupDefinition(6, 0, 0, 6, 6)
		}, 2);
		
		BaseGroup.add(PlayType.BJKL8_R6_FS, new GroupDefinition[] {
				new GroupDefinition(6, 0, 0, 80, 6)
		}, 0);
		BaseGroup.add(PlayType.BJKL8_R7_DS, new GroupDefinition[] {
				new GroupDefinition(7, 0, 0, 7, 7)
		}, 2);
		
		BaseGroup.add(PlayType.BJKL8_R7_FS, new GroupDefinition[] {
				new GroupDefinition(7, 0, 0, 80, 7)
		}, 0);
		BaseGroup.add(PlayType.BJKL8_R8_DS, new GroupDefinition[] {
				new GroupDefinition(8, 0, 0, 8, 8)
		}, 2);
		
		BaseGroup.add(PlayType.BJKL8_R8_FS, new GroupDefinition[] {
				new GroupDefinition(8, 0, 0, 80, 8)
		}, 0);
		BaseGroup.add(PlayType.BJKL8_R9_DS, new GroupDefinition[] {
				new GroupDefinition(9, 0, 0, 9, 9)
		}, 2);
		
		BaseGroup.add(PlayType.BJKL8_R9_FS, new GroupDefinition[] {
				new GroupDefinition(9, 0, 0, 80, 9)
		}, 0);
		BaseGroup.add(PlayType.BJKL8_R10_DS, new GroupDefinition[] {
				new GroupDefinition(10, 0, 0, 10, 10)
		}, 2);
		
		BaseGroup.add(PlayType.BJKL8_R10_FS, new GroupDefinition[] {
				new GroupDefinition(10, 0, 0, 80, 10)
		}, 0);
	}
	
	public static void init() {
		
	}

}
