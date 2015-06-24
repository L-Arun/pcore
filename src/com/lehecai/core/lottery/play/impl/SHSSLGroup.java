/**
 * 
 */
package com.lehecai.core.lottery.play.impl;

import com.lehecai.core.lottery.PlayType;
import com.lehecai.core.lottery.play.BaseGroup;
import com.lehecai.core.lottery.play.GroupDefinition;

/**
 * 上海时时乐格式定义
 * @author sunshow
 *
 */
public class SHSSLGroup {
	
	static {
		
		BaseGroup.add(PlayType.SHSSL_ZXDS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1),
				new GroupDefinition(1, 0, 0, 1, 1),
				new GroupDefinition(1, 0, 0, 1, 1)
				}, 5);
		
		BaseGroup.add(PlayType.SHSSL_ZXFS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 10, 1),
				new GroupDefinition(1, 0, 0, 10, 1),
				new GroupDefinition(1, 0, 0, 10, 1)
				}, 0);
		
		BaseGroup.add(PlayType.SHSSL_ZXBHDS1, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 10, 1)
				}, 0);
		
		BaseGroup.add(PlayType.SHSSL_ZXBHDS2, new GroupDefinition[] {
				new GroupDefinition(2, 0, 0, 10, 1)
				}, 0);
		
		BaseGroup.add(PlayType.SHSSL_ZXBHDS3, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 10, 1)
				}, 0);
		
		BaseGroup.add(PlayType.SHSSL_ZXBHDS4, new GroupDefinition[] {
				new GroupDefinition(3, 0, 0, 10, 1)
				}, 0);
		
		BaseGroup.add(PlayType.SHSSL_ZXHZ, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1)
				}, 0);
		
		BaseGroup.add(PlayType.SHSSL_ZXDT, new GroupDefinition[] {
				new GroupDefinition(2, 2, 1, 10, 1)
				}, 0);
		
		BaseGroup.add(PlayType.SHSSL_Z3DS, new GroupDefinition[] {
				new GroupDefinition(3, 0, 0, 3, 3)
				}, 5);
		
		BaseGroup.add(PlayType.SHSSL_Z3BH, new GroupDefinition[] {
				new GroupDefinition(2, 0, 0, 10, 2)
				}, 0);
		
		BaseGroup.add(PlayType.SHSSL_Z3HZ, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1)
				}, 0);
		
		BaseGroup.add(PlayType.SHSSL_Z6DS, new GroupDefinition[] {
				new GroupDefinition(3, 0, 0, 3, 3)
				}, 5);
		
		BaseGroup.add(PlayType.SHSSL_Z6DT, new GroupDefinition[] {
				new GroupDefinition(3, 2, 1, 9, 1),
				}, 0);
		
		BaseGroup.add(PlayType.SHSSL_Z6BH, new GroupDefinition[] {
				new GroupDefinition(3, 0, 0, 10, 3),
				}, 0);
		
		BaseGroup.add(PlayType.SHSSL_Z6HZ, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1),
				}, 0);	// 和值的方案只有一个号码（即和值）
		
		BaseGroup.add(PlayType.SHSSL_Q2DS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1),
				new GroupDefinition(1, 0, 0, 1, 1)
				}, 5);
		
		BaseGroup.add(PlayType.SHSSL_Q2FS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 10, 1),
				new GroupDefinition(1, 0, 0, 10, 1)
				}, 1);
		
		BaseGroup.add(PlayType.SHSSL_H2DS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1),
				new GroupDefinition(1, 0, 0, 1, 1)
				}, 5);
		
		BaseGroup.add(PlayType.SHSSL_H2FS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 10, 1),
				new GroupDefinition(1, 0, 0, 10, 1)
				}, 1);
		
		BaseGroup.add(PlayType.SHSSL_Q1DS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1)
				}, 5);
		
		BaseGroup.add(PlayType.SHSSL_Q1FS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 10, 1)
				}, 1);
		
		BaseGroup.add(PlayType.SHSSL_H1DS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 1, 1)
				}, 5);
		
		BaseGroup.add(PlayType.SHSSL_H1FS, new GroupDefinition[] {
				new GroupDefinition(1, 0, 0, 10, 1)
				}, 1);
		
	}
	
	/*
	public static final PlayType SHSSL_Z3FS = new PlayType("时时乐组三复式", 20110, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_Z3DT = new PlayType("时时乐组三胆拖", 20113, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_Z6FS = new PlayType("时时乐组六复式", 20115, LotteryType.SHSSL);
	
	*/
	
	public static void init() {
		
	}

}
