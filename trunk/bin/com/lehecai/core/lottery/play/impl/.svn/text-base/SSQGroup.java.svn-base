/**
 * 
 */
package com.lehecai.core.lottery.play.impl;

import com.lehecai.core.lottery.PlayType;
import com.lehecai.core.lottery.play.BaseGroup;
import com.lehecai.core.lottery.play.GroupDefinition;

/**
 * 双色球格式定义
 * @author sunshow
 *
 */
public class SSQGroup {
	
	static {
		
		BaseGroup.add(PlayType.SSQ_DS, new GroupDefinition[] {
				new GroupDefinition(6, 0, 0, 6, 6),
				new GroupDefinition(1, 0, 0, 1, 1)
				}, 5);

		BaseGroup.add(PlayType.SSQ_FS, new GroupDefinition[] {
				new GroupDefinition(6, 0, 0, 20, 6),
				new GroupDefinition(1, 0, 0, 16, 1)
				}, 1);
		
		BaseGroup.add(PlayType.SSQ_DT, new GroupDefinition[] {
				new GroupDefinition(6, 5, 1, 19, 1),
				new GroupDefinition(1, 0, 0, 16, 1)
				}, 0);	// 关于第三个参数的说明：因为双色球胆拖玩法会拆成单式和复式，所以票里不存在胆拖的玩法
	}
	
	public static void init() {
		
	}

}
