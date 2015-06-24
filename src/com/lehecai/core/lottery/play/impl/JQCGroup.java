/**
 * 
 */
package com.lehecai.core.lottery.play.impl;

import com.lehecai.core.lottery.PlayType;
import com.lehecai.core.lottery.play.BaseGroup;
import com.lehecai.core.lottery.play.GroupDefinition;

/**
 * 进球彩格式定义
 * @author sunshow
 *
 */
public class JQCGroup {
	
	static {
		
		BaseGroup.add(PlayType.JQC_DS, new GroupDefinition[] {
				new GroupDefinition(8, 0, 0, 8, 8)
				}, 3);

		BaseGroup.add(PlayType.JQC_FS, new GroupDefinition[] {
				new GroupDefinition(8, 0, 0, 8, 8)
				}, 1);
		
	}
	
	public static void init() {
		
	}

}
