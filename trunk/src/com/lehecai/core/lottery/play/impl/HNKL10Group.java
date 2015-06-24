/**
 * 
 */
package com.lehecai.core.lottery.play.impl;

import com.lehecai.core.lottery.PlayType;
import com.lehecai.core.lottery.play.BaseGroup;
import com.lehecai.core.lottery.play.GroupDefinition;

/**
 * 湖南快乐十分格式定义
 * @author qatang
 *
 */
public class HNKL10Group {
	
	static {
		BaseGroup.add(PlayType.HNKL10_X1_ST_DS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1)
				}, 5);
		
		BaseGroup.add(PlayType.HNKL10_X1_ST_FS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 18, 1)
				}, 1);
		
		BaseGroup.add(PlayType.HNKL10_X1_HT_DS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1)
				}, 5);
		
		BaseGroup.add(PlayType.HNKL10_X1_HT_FS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 2, 1)
				}, 1);
		
		BaseGroup.add(PlayType.HNKL10_R2_DS, new GroupDefinition[] {
				new GroupDefinition(2, 0, 0, 2, 2)
				}, 5);
		
		BaseGroup.add(PlayType.HNKL10_R2_FS, new GroupDefinition[] {
				new GroupDefinition(2, 0, 0, 20, 2)
				}, 1);
		
		BaseGroup.add(PlayType.HNKL10_R2_DT, new GroupDefinition[] {
				new GroupDefinition(2, 1, 1, 19, 1)
				}, 1);
		
		BaseGroup.add(PlayType.HNKL10_X2_LZU_DS, new GroupDefinition[] {
				new GroupDefinition(2, 0, 0, 2, 2)
				}, 5);
		
		BaseGroup.add(PlayType.HNKL10_X2_LZU_FS, new GroupDefinition[] {
				new GroupDefinition(2, 0, 0, 20, 2)
				}, 1);
		
		BaseGroup.add(PlayType.HNKL10_X2_LZU_DT, new GroupDefinition[] {
				new GroupDefinition(2, 1, 1, 19, 1)
				}, 1);
		
		BaseGroup.add(PlayType.HNKL10_X2_LZHI_DS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1),
				new GroupDefinition(1, 0, 0, 1, 1)
				}, 5);
		
		BaseGroup.add(PlayType.HNKL10_X2_LZHI_FS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 20, 1),
				new GroupDefinition(1, 0, 0, 20, 1)
				}, 1);
		
		BaseGroup.add(PlayType.HNKL10_R3_DS, new GroupDefinition[] {
				new GroupDefinition(3, 0, 0, 3, 3)
				}, 5);
		
		BaseGroup.add(PlayType.HNKL10_R3_FS, new GroupDefinition[] {
				new GroupDefinition(3, 0, 0, 20, 3)
				}, 1);
		
		BaseGroup.add(PlayType.HNKL10_R3_DT, new GroupDefinition[] {
				new GroupDefinition(3, 2, 1, 19, 1)
				}, 1);
		
		BaseGroup.add(PlayType.HNKL10_X3_QZU_DS, new GroupDefinition[] {
				new GroupDefinition(3, 0, 0, 3, 3)
				}, 5);
		
		BaseGroup.add(PlayType.HNKL10_X3_QZU_FS, new GroupDefinition[] {
				new GroupDefinition(3, 0, 0, 20, 3)
				}, 1);
		
		BaseGroup.add(PlayType.HNKL10_X3_QZU_DT, new GroupDefinition[] {
				new GroupDefinition(3, 2, 1, 19, 1)
				}, 1);
		
		BaseGroup.add(PlayType.HNKL10_X3_QZHI_DS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1),
				new GroupDefinition(1, 0, 0, 1, 1),
				new GroupDefinition(1, 0, 0, 1, 1)
				}, 5);
		
		BaseGroup.add(PlayType.HNKL10_X3_QZHI_FS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 20, 1),
				new GroupDefinition(1, 0, 0, 20, 1),
				new GroupDefinition(1, 0, 0, 20, 1)
				}, 1);
		
		BaseGroup.add(PlayType.HNKL10_R4_DS, new GroupDefinition[] {
				new GroupDefinition(4, 0, 0, 4, 4)
				}, 5);
		
		BaseGroup.add(PlayType.HNKL10_R4_FS, new GroupDefinition[] {
				new GroupDefinition(4, 0, 0, 20, 4)
				}, 1);
		
		BaseGroup.add(PlayType.HNKL10_R4_DT, new GroupDefinition[] {
				new GroupDefinition(4, 3, 1, 19, 1)
				}, 1);
		
		BaseGroup.add(PlayType.HNKL10_R5_DS, new GroupDefinition[] {
				new GroupDefinition(5, 0, 0, 5, 5)
				}, 5);
		
		BaseGroup.add(PlayType.HNKL10_R5_FS, new GroupDefinition[] {
				new GroupDefinition(5, 0, 0, 20, 5)
				}, 1);
		
		BaseGroup.add(PlayType.HNKL10_R5_DT, new GroupDefinition[] {
				new GroupDefinition(5, 4, 1, 19, 1)
				}, 1);
	}
	
	public static void init() {
		
	}

}
