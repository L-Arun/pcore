/**
 * 
 */
package com.lehecai.core.lottery.cache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.lehecai.core.lottery.LotteryType;

/**
 * @author Sunshow
 *
 */
public class OnSaleLotteryList {

	private static List<LotteryType> _list = new ArrayList<LotteryType>();
	private static List<LotteryType> list;
	
	// 常规彩种列表
	private static List<LotteryType> _generalList = new ArrayList<LotteryType>();
	private static List<LotteryType> generalList;
	
	private static List<LotteryType> _listWithinAll = new ArrayList<LotteryType>();
	private static List<LotteryType> listWithinAll;
	
	
	static {
		_generalList.add(LotteryType.DLT);
		_generalList.add(LotteryType.QXC);
		_generalList.add(LotteryType.PL3);
		_generalList.add(LotteryType.PL5);
		_generalList.add(LotteryType.TC22X5);
		_generalList.add(LotteryType.SFC);
		_generalList.add(LotteryType.SFR9);
		_generalList.add(LotteryType.JQC);
		_generalList.add(LotteryType.BQC);
		
		_generalList.add(LotteryType.SSQ);
		_generalList.add(LotteryType.QLC);
		_generalList.add(LotteryType.FC3D);
		_generalList.add(LotteryType.DF6J1);
		_generalList.add(LotteryType.HD15X5);
		
		_generalList.add(LotteryType.BJTC33X7);
		
		generalList = Collections.unmodifiableList(_generalList);
		
		_list.addAll(_generalList);
		
		_list.add(LotteryType.DC_SFP);
		_list.add(LotteryType.DC_SXDS);
		_list.add(LotteryType.DC_JQS);
		_list.add(LotteryType.DC_BF);
		_list.add(LotteryType.DC_BCSFP);
		_list.add(LotteryType.DC_SFGG);
		
		_list.add(LotteryType.JCLQ_SF);
		_list.add(LotteryType.JCLQ_RFSF);
		_list.add(LotteryType.JCLQ_SFC);
		_list.add(LotteryType.JCLQ_DXF);
		
		_list.add(LotteryType.JCZQ_SPF);
		_list.add(LotteryType.JCZQ_BF);
		_list.add(LotteryType.JCZQ_JQS);
		_list.add(LotteryType.JCZQ_BQC);
		_list.add(LotteryType.JCZQ_GJ);
		_list.add(LotteryType.JCZQ_GYJ);
		
		_list.add(LotteryType.SD11X5);
		_list.add(LotteryType.GD11X5);
		_list.add(LotteryType.GDKL10);
		_list.add(LotteryType.JX11X5);
		_list.add(LotteryType.CQSSC);
		_list.add(LotteryType.SHSSL);
		_list.add(LotteryType.JXSSC);
		_list.add(LotteryType.BJKL8);
		_list.add(LotteryType.SDQYH);
		_list.add(LotteryType.GXKL10);
		_list.add(LotteryType.HNKL10);
		_list.add(LotteryType.PK10);
		_list.add(LotteryType.CQ11X5);
		
		list = Collections.unmodifiableList(_list);
		
		_listWithinAll.add(LotteryType.ALL);
		_listWithinAll.addAll(_list);
		
		listWithinAll = Collections.unmodifiableList(_listWithinAll);
	}
	
	/** 
	 * 返回网站在售彩种列表
	 */
	public static List<LotteryType> get() {
		return list;
	}
	
	/**
	 * 返回网站在售的常规彩种列表
	 * @return
	 */
	public static List<LotteryType> getGeneral() {
		return generalList;
	}
	
	public static List<LotteryType> getForQuery() {
		return listWithinAll;
	}
}
