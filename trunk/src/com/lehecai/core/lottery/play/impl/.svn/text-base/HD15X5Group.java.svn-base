/**
 * 
 */
package com.lehecai.core.lottery.play.impl;

import com.lehecai.core.lottery.PlayType;
import com.lehecai.core.lottery.play.BaseGroup;
import com.lehecai.core.lottery.play.GroupDefinition;

/**
 * 华东15选5格式定义
 * @author sunshow
 *
 */
public class HD15X5Group {
	
	static {
		
		BaseGroup.add(PlayType.HD15X5_DS, new GroupDefinition[] {
				new GroupDefinition(5, 0, 0, 5, 5)
				}, 5);

		BaseGroup.add(PlayType.HD15X5_FS, new GroupDefinition[] {
				new GroupDefinition(5, 0, 0, 13, 5)
				}, 1);
		
		BaseGroup.add(PlayType.HD15X5_DT, new GroupDefinition[] {
				new GroupDefinition(5, 4, 1, 14, 1)
				}, 0);
	}
	
	public static void init() {
		
	}

}
