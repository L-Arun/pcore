/**
 * 
 */
package com.lehecai.core.lottery.play.impl;

import com.lehecai.core.lottery.PlayType;
import com.lehecai.core.lottery.play.BaseGroup;
import com.lehecai.core.lottery.play.GroupDefinition;

/**
 * 体彩22选5格式定义
 * @author qatang
 *
 */
public class TC22X5Group {
	
	static {
		BaseGroup.add(PlayType.TC22X5_DS, new GroupDefinition[] {
				new GroupDefinition(5, 0, 0, 5, 5)
				}, 3);

		BaseGroup.add(PlayType.TC22X5_FS, new GroupDefinition[] {
				new GroupDefinition(5, 0, 0, 22, 5)
				}, 1);
		
		BaseGroup.add(PlayType.TC22X5_DT, new GroupDefinition[] {
				new GroupDefinition(5, 4, 1, 21, 1)
				}, 0);
	}
	
	public static void init() {
		
	}

}
