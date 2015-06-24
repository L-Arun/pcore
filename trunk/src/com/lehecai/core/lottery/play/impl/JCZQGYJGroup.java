/**
 * 
 */
package com.lehecai.core.lottery.play.impl;

import com.lehecai.core.lottery.PlayType;
import com.lehecai.core.lottery.play.BaseGroup;
import com.lehecai.core.lottery.play.GroupDefinition;

/**
 * 竞彩足球冠亚军格式定义
 * @author zhangzhiqiang
 *
 */
public class JCZQGYJGroup {
	
	static {
		
		BaseGroup.add(PlayType.JCZQ_GYJ_DS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1)
				}, 1);

		BaseGroup.add(PlayType.JCZQ_GYJ_FS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 50, 1)
				}, 1);
		
	}
	
	public static void init() {
		
	}

}
