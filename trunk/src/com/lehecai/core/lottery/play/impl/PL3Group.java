/**
 * 
 */
package com.lehecai.core.lottery.play.impl;

import com.lehecai.core.lottery.PlayType;
import com.lehecai.core.lottery.play.BaseGroup;
import com.lehecai.core.lottery.play.GroupDefinition;

/**
 * 排列三格式定义
 * @author sunshow
 *
 */
public class PL3Group {
	
	static {
		
		BaseGroup.add(PlayType.PL3_ZXDS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1),
				new GroupDefinition(1, 0, 0, 1, 1),
				new GroupDefinition(1, 0, 0, 1, 1)
				}, 4);

		BaseGroup.add(PlayType.PL3_FS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 10, 1),
				new GroupDefinition(1, 0, 0, 10, 1),
				new GroupDefinition(1, 0, 0, 10, 1)
				}, 1);
		
		BaseGroup.add(PlayType.PL3_Z3DS, new GroupDefinition[] {
				new GroupDefinition(3, 0, 0, 3, 3),
				}, 4); // 组选单式，因为是无序的，认为是一组号码
		
		BaseGroup.add(PlayType.PL3_Z6DS, new GroupDefinition[] {
				new GroupDefinition(3, 0, 0, 3, 3),
				}, 4); // 组选单式，因为是无序的，认为是一组号码
		
		BaseGroup.add(PlayType.PL3_Z6DT, new GroupDefinition[] {
				new GroupDefinition(3, 2, 1, 9, 1),
				}, 0);
		
		BaseGroup.add(PlayType.PL3_Z6BH, new GroupDefinition[] {
				new GroupDefinition(3, 0, 0, 10, 3),
				}, 0);
		
		BaseGroup.add(PlayType.PL3_Z6HZ, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1),
				}, 0);	// 和值的方案只有一个号码（即和值）
		
		BaseGroup.add(PlayType.PL3_Z3BH, new GroupDefinition[] {
				new GroupDefinition(2, 0, 0, 10, 2),
				}, 0);	// 组三包号基本玩法是选2个号，以 2A+B 或者 A+2B做组合
		
		BaseGroup.add(PlayType.PL3_Z3HZ, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1),
				}, 0);	// 和值的方案只有一个号码（即和值）
		
	}
	
	public static void init() {
		
	}

}
