/**
 * 
 */
package com.lehecai.core.lottery.play.impl;

import com.lehecai.core.lottery.PlayType;
import com.lehecai.core.lottery.play.BaseGroup;
import com.lehecai.core.lottery.play.GroupDefinition;

/**
 * 七乐彩格式定义
 * @author sunshow
 *
 */
public class QLCGroup {
	
	static {
		
		BaseGroup.add(PlayType.QLC_DS, new GroupDefinition[] {
				new GroupDefinition(7, 0, 0, 7, 7)
				}, 5);

		BaseGroup.add(PlayType.QLC_FS, new GroupDefinition[] {
				new GroupDefinition(7, 0, 0, 16, 7)
				}, 1);
		
		BaseGroup.add(PlayType.QLC_DT, new GroupDefinition[] {
				new GroupDefinition(7, 6, 1, 29, 1)
				}, 0);
	}
	
	public static void init() {
		
	}

}
