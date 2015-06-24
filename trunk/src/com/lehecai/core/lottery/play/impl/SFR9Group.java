/**
 * 
 */
package com.lehecai.core.lottery.play.impl;

import com.lehecai.core.lottery.PlayType;
import com.lehecai.core.lottery.play.BaseGroup;
import com.lehecai.core.lottery.play.GroupDefinition;

/**
 * 胜负彩格式定义
 * @author sunshow
 *
 */
public class SFR9Group {
	
	static {
		
		BaseGroup.add(PlayType.SFR9_DS, new GroupDefinition[] {
				new GroupDefinition(9, 0, 0, 9, 9)
				}, 3);

		BaseGroup.add(PlayType.SFR9_FS, new GroupDefinition[] {
				new GroupDefinition(9, 0, 0, 14, 9)
				}, 1);
		
		BaseGroup.add(PlayType.SFR9_DT, new GroupDefinition[] {
				new GroupDefinition(9, 8, 1, 13, 1)
				}, 1);
		
	}
	
	public static void init() {
		
	}

}
