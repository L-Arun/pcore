/**
 * 
 */
package com.lehecai.core.lottery.play.impl;

import com.lehecai.core.lottery.PlayType;
import com.lehecai.core.lottery.play.BaseGroup;
import com.lehecai.core.lottery.play.GroupDefinition;

/**
 * 排列5格式定义
 * @author sunshow
 *
 */
public class PL5Group {
	
	static {
		
		BaseGroup.add(PlayType.PL5_DS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1),
				new GroupDefinition(1, 0, 0, 1, 1),
				new GroupDefinition(1, 0, 0, 1, 1),
				new GroupDefinition(1, 0, 0, 1, 1),
				new GroupDefinition(1, 0, 0, 1, 1)
				}, 4);

		BaseGroup.add(PlayType.PL5_FS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 10, 1),
				new GroupDefinition(1, 0, 0, 10, 1),
				new GroupDefinition(1, 0, 0, 10, 1),
				new GroupDefinition(1, 0, 0, 10, 1),
				new GroupDefinition(1, 0, 0, 10, 1)
				}, 1);
		
	}
	
	public static void init() {
		
	}

}
