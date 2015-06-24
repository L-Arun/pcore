/**
 * 
 */
package com.lehecai.core.lottery.play;

import java.util.HashMap;
import java.util.Map;

import com.lehecai.core.lottery.PlayType;
import com.lehecai.core.lottery.play.impl.BJKL8Group;
import com.lehecai.core.lottery.play.impl.BJTC33X7Group;
import com.lehecai.core.lottery.play.impl.BQCGroup;
import com.lehecai.core.lottery.play.impl.CQ11X5Group;
import com.lehecai.core.lottery.play.impl.CQSSCGroup;
import com.lehecai.core.lottery.play.impl.DF6J1Group;
import com.lehecai.core.lottery.play.impl.DLTGroup;
import com.lehecai.core.lottery.play.impl.FC3DGroup;
import com.lehecai.core.lottery.play.impl.GD11X5Group;
import com.lehecai.core.lottery.play.impl.GDKL10Group;
import com.lehecai.core.lottery.play.impl.GXKL10Group;
import com.lehecai.core.lottery.play.impl.HD15X5Group;
import com.lehecai.core.lottery.play.impl.HNKL10Group;
import com.lehecai.core.lottery.play.impl.JCZQGJGroup;
import com.lehecai.core.lottery.play.impl.JCZQGYJGroup;
import com.lehecai.core.lottery.play.impl.JQCGroup;
import com.lehecai.core.lottery.play.impl.JX11X5Group;
import com.lehecai.core.lottery.play.impl.JXSSCGroup;
import com.lehecai.core.lottery.play.impl.PK10Group;
import com.lehecai.core.lottery.play.impl.PL3Group;
import com.lehecai.core.lottery.play.impl.PL5Group;
import com.lehecai.core.lottery.play.impl.QLCGroup;
import com.lehecai.core.lottery.play.impl.QXCGroup;
import com.lehecai.core.lottery.play.impl.SD11X5Group;
import com.lehecai.core.lottery.play.impl.SDQYHGroup;
import com.lehecai.core.lottery.play.impl.SFCGroup;
import com.lehecai.core.lottery.play.impl.SFR9Group;
import com.lehecai.core.lottery.play.impl.SHSSLGroup;
import com.lehecai.core.lottery.play.impl.SSQGroup;
import com.lehecai.core.lottery.play.impl.TC22X5Group;

/**
 * @author sunshow
 *
 */
public class BaseGroup {
	/**
	 * 指定玩法元素组个数和组内元素个数的定义
	 */
	private static Map<PlayType, GroupDefinition[]> groupDefMap = new HashMap<PlayType, GroupDefinition[]>();
	/**
	 * 指定玩法一张票包含多少注的定义
	 */
	private static Map<PlayType, Integer> numberDefMap = new HashMap<PlayType, Integer>();
	/**
	 * 所有元素组中累计有非占位符元素的组的个数的定义
	 */
	private static Map<PlayType, Integer> validGroupRequiredDefMap = new HashMap<PlayType, Integer>();
	
	public static int getNumber(PlayType playType) {
		Integer val = numberDefMap.get(playType);
		if (val == null) {
			return 0;
		}
		return val.intValue();
	}
	
	public static int getValidGroupRequired(PlayType playType) {
		Integer val = validGroupRequiredDefMap.get(playType);
		if (val == null) {
			return 0;
		}
		return val.intValue();
	}
	
	public static GroupDefinition[] getDefinitions(PlayType playType) {
		return groupDefMap.get(playType);
	}
	
	public static void add(PlayType playType, GroupDefinition[] defs, int batchCount) {
		add(playType, defs, 0, batchCount);
	}
	
	public static void add(PlayType playType, GroupDefinition[] defs, int totalRequired, int batchCount) {
		groupDefMap.put(playType, defs);
		
		validGroupRequiredDefMap.put(playType, totalRequired);
		
		numberDefMap.put(playType, batchCount);
	}

	static {
		
		// 加载双色球玩法组定义
		SSQGroup.init();
		// 加载七乐彩玩法组定义
		QLCGroup.init();
		// 加载东方6+1玩法组定义
		DF6J1Group.init();
		// 加载华东15选5玩法组定义
		HD15X5Group.init();
		// 加载七星彩玩法组定义
		QXCGroup.init();
		// 加载排列五玩法组定义
		PL5Group.init();
		// 加载22选5玩法组定义
		TC22X5Group.init();
		// 加载福彩3D玩法组定义
		FC3DGroup.init();
		// 加载大乐透玩法组定义
		DLTGroup.init();
		// 加载排列三玩法组定义
		PL3Group.init();
		// 加载胜负彩玩法组定义
		SFCGroup.init();
		// 加载任选9场玩法组定义
		SFR9Group.init();
		// 加载进球彩玩法组定义
		JQCGroup.init();
		// 加载半全场玩法组定义
		BQCGroup.init();
		// 加载十一运夺金玩法组定义
		SD11X5Group.init();
		// 加载11选5玩法组定义
		JX11X5Group.init();
		// 加载重庆时时彩玩法组定义
		CQSSCGroup.init();
		// 加载江西时时彩玩法组定义
		JXSSCGroup.init();
		// 加载上海时时乐玩法组定义
		SHSSLGroup.init();
		// 加载广东11选5玩法组定义		
		GD11X5Group.init();
		// 加载广东快乐十分玩法组定义		
		GDKL10Group.init();
		// 加载北京快乐8玩法组定义
		BJKL8Group.init();
		// 加载山东群英会玩法组定义
		SDQYHGroup.init();
		// 加载广西快乐十分玩法组定义
		GXKL10Group.init();
		// 加载湖南快乐十分玩法组定义
		HNKL10Group.init();
		// 加载北京体彩33选7玩法组定义
		BJTC33X7Group.init();
		// 加载PK拾玩法组定义
		PK10Group.init();
		// 加载竞彩足球冠军玩法组定义
		JCZQGJGroup.init();
		// 加载竞彩足球冠亚军玩法组定义
		JCZQGYJGroup.init();
		// 加载重庆11选5玩法组定义
		CQ11X5Group.init();
	}
}
