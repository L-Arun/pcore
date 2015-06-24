/**
 * 
 */
package com.lehecai.core.lottery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * @author qatang
 * 竞彩篮球即时SP值
 */
public class JclqSPType extends IntegerBeanLabelItem {


	private static final long serialVersionUID = 2465840431256917709L;

	private static final Logger logger = LoggerFactory.getLogger(JclqSPType.class.getName());
	
	private static List<JclqSPType> items = new ArrayList<JclqSPType>();
	
	private static Map<LotteryType, List<JclqSPType>> lotteryItemsMap = new HashMap<LotteryType, List<JclqSPType>>();
	
	protected JclqSPType(String name, int value) {
		this(name, value, null);
	}
	
	protected JclqSPType(String name, int value, LotteryType lotteryType) {
		super(JclqSPType.class.getName(), name, value);
		items.add(this);
		
		if (lotteryType != null) {
			synchronized(this) {
				List<JclqSPType> lotteryItems = lotteryItemsMap.get(lotteryType);
				if (lotteryItems == null) {
					lotteryItems = new ArrayList<JclqSPType>();
					lotteryItemsMap.put(lotteryType, lotteryItems);
				}
				lotteryItems.add(this);
			}
		}
	}
	
	public static JclqSPType getItem(int value){
		try {
			return (JclqSPType)JclqSPType.getResult(JclqSPType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<JclqSPType> getItems() {
		return items;
	}
	
	public static List<JclqSPType> getItems(LotteryType lotteryType) {
		return lotteryItemsMap.get(lotteryType);
	}
	
	private static Map<JclqSPType, String> lotteryConstantMap = new HashMap<JclqSPType, String>();
	
	public static String getLotteryConstant(JclqSPType spType) {
		return lotteryConstantMap.get(spType);
	}
	
	
	//胜负
	public static final JclqSPType SF_S = new JclqSPType("胜负-主队胜", 1, LotteryType.JCLQ_SF);
	public static final JclqSPType SF_F = new JclqSPType("胜负-主队负", 2, LotteryType.JCLQ_SF);
	
	//让分胜负
	public static final JclqSPType RFSF_S = new JclqSPType("让分胜负-主队胜", 3, LotteryType.JCLQ_RFSF);
	public static final JclqSPType RFSF_F = new JclqSPType("让分胜负-主队负", 4, LotteryType.JCLQ_RFSF);
	public static final JclqSPType RFSF_RF = new JclqSPType("让分胜负-主队让分数", 5, LotteryType.JCLQ_RFSF);
	
	//胜分差
	public static final JclqSPType SFC_KS_1_5 = new JclqSPType("胜分差-客胜-1-5",6, LotteryType.JCLQ_SFC);
	public static final JclqSPType SFC_ZS_1_5 = new JclqSPType("胜分差-主胜-1-5",7, LotteryType.JCLQ_SFC);
	public static final JclqSPType SFC_KS_6_10 = new JclqSPType("胜分差-客胜-6-10",8, LotteryType.JCLQ_SFC);
	public static final JclqSPType SFC_ZS_6_10 = new JclqSPType("胜分差-主胜-6-10",9, LotteryType.JCLQ_SFC);
	public static final JclqSPType SFC_KS_11_15 = new JclqSPType("胜分差-客胜-11-15",10, LotteryType.JCLQ_SFC);
	public static final JclqSPType SFC_ZS_11_15 = new JclqSPType("胜分差-主胜-11-15",11, LotteryType.JCLQ_SFC);
	public static final JclqSPType SFC_KS_16_20 = new JclqSPType("胜分差-客胜-16-20",12, LotteryType.JCLQ_SFC);
	public static final JclqSPType SFC_ZS_16_20 = new JclqSPType("胜分差-主胜-16-20",13, LotteryType.JCLQ_SFC);
	public static final JclqSPType SFC_KS_21_25 = new JclqSPType("胜分差-客胜-21-25",14, LotteryType.JCLQ_SFC);
	public static final JclqSPType SFC_ZS_21_25 = new JclqSPType("胜分差-主胜-21-25",15, LotteryType.JCLQ_SFC);
	public static final JclqSPType SFC_KS_26 = new JclqSPType("胜分差-客胜-26+",16, LotteryType.JCLQ_SFC);
	public static final JclqSPType SFC_ZS_26 = new JclqSPType("胜分差-主胜-26+",17, LotteryType.JCLQ_SFC);
	
	//让分胜负
	public static final JclqSPType DXF_S = new JclqSPType("大小分-大分", 18, LotteryType.JCLQ_DXF);
	public static final JclqSPType DXF_F = new JclqSPType("大小分-小分", 19, LotteryType.JCLQ_DXF);
	public static final JclqSPType DXF_YS = new JclqSPType("大小分-预设总分", 20, LotteryType.JCLQ_DXF);
	
	@Override
	public String toString() {
		return this.name;
	}

	static {
		lotteryConstantMap.put(JclqSPType.SF_S, LotteryConstant.JCLQ_SF_S_VALUE);
		lotteryConstantMap.put(JclqSPType.SF_F, LotteryConstant.JCLQ_SF_F_VALUE);
		
		lotteryConstantMap.put(JclqSPType.RFSF_S, LotteryConstant.JCLQ_RFSF_S_VALUE);
		lotteryConstantMap.put(JclqSPType.RFSF_F, LotteryConstant.JCLQ_RFSF_F_VALUE);
		lotteryConstantMap.put(JclqSPType.RFSF_RF, LotteryConstant.JCLQ_RFSF_HANDICAP);
		
		lotteryConstantMap.put(JclqSPType.SFC_KS_1_5, LotteryConstant.JCLQ_SFC_A_1_5_VALUE);
		lotteryConstantMap.put(JclqSPType.SFC_ZS_1_5, LotteryConstant.JCLQ_SFC_H_1_5_VALUE);
		lotteryConstantMap.put(JclqSPType.SFC_KS_6_10, LotteryConstant.JCLQ_SFC_A_6_10_VALUE);
		lotteryConstantMap.put(JclqSPType.SFC_ZS_6_10, LotteryConstant.JCLQ_SFC_H_6_10_VALUE);
		lotteryConstantMap.put(JclqSPType.SFC_KS_11_15, LotteryConstant.JCLQ_SFC_A_11_15_VALUE);
		lotteryConstantMap.put(JclqSPType.SFC_ZS_11_15, LotteryConstant.JCLQ_SFC_H_11_15_VALUE);
		lotteryConstantMap.put(JclqSPType.SFC_KS_16_20, LotteryConstant.JCLQ_SFC_A_16_20_VALUE);
		lotteryConstantMap.put(JclqSPType.SFC_ZS_16_20, LotteryConstant.JCLQ_SFC_H_16_20_VALUE);
		lotteryConstantMap.put(JclqSPType.SFC_KS_21_25, LotteryConstant.JCLQ_SFC_A_21_25_VALUE);
		lotteryConstantMap.put(JclqSPType.SFC_ZS_21_25, LotteryConstant.JCLQ_SFC_H_21_25_VALUE);
		lotteryConstantMap.put(JclqSPType.SFC_KS_26, LotteryConstant.JCLQ_SFC_A_26_PLUS_VALUE);
		lotteryConstantMap.put(JclqSPType.SFC_ZS_26, LotteryConstant.JCLQ_SFC_H_26_PLUS_VALUE);
		
		lotteryConstantMap.put(JclqSPType.DXF_S, LotteryConstant.JCLQ_DXF_LARGE);
		lotteryConstantMap.put(JclqSPType.DXF_F, LotteryConstant.JCLQ_DXF_SMALL);
		lotteryConstantMap.put(JclqSPType.DXF_YS, LotteryConstant.JCLQ_DXF_PRESETSCORE);
	}
	
}
