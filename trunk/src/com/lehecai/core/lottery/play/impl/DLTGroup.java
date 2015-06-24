/**
 * 
 */
package com.lehecai.core.lottery.play.impl;

import com.lehecai.core.lottery.PlayType;
import com.lehecai.core.lottery.play.BaseGroup;
import com.lehecai.core.lottery.play.GroupDefinition;

/**
 * 大乐透格式定义
 * @author sunshow
 *
 */
public class DLTGroup {
	
	static {
		
		BaseGroup.add(PlayType.DLT_DS, new GroupDefinition[] {
				new GroupDefinition(5, 0, 0, 5, 5),
				new GroupDefinition(2, 0, 0, 2, 2)
				}, 5);

		BaseGroup.add(PlayType.DLT_FS, new GroupDefinition[] {
				new GroupDefinition(5, 0, 0, 18, 5),
				new GroupDefinition(2, 0, 0, 12, 2)
				}, 1);
		
		BaseGroup.add(PlayType.DLT_DT, new GroupDefinition[] {
				new GroupDefinition(5, 4, 1, 34, 1),
				new GroupDefinition(2, 1, 1, 12, 1)
				}, 1);	// 胆拖是大乐透官方玩法，而且支持前后区胆拖
		
		BaseGroup.add(PlayType.DLT_XYC_DS, new GroupDefinition[] {
				new GroupDefinition(2, 0, 0, 2, 2)
				}, 5);
		
		BaseGroup.add(PlayType.DLT_XYC_FS, new GroupDefinition[] {
				new GroupDefinition(2, 0, 0, 12, 2)
				}, 1);
		
		BaseGroup.add(PlayType.DLT_XYC_DT, new GroupDefinition[] {
				new GroupDefinition(2, 1, 1, 11, 2)
				}, 1);
	}
	
	public static void init() {
		
	}

}
