/**
 * 
 */
package com.lehecai.core.lottery;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * @author Sunshow
 * 单场即时SP值
 */
public class DcSPType extends IntegerBeanLabelItem {


	private static final long serialVersionUID = 2465840431256917709L;

	private static final Logger logger = LoggerFactory.getLogger(DcSPType.class.getName());
	
	private static List<DcSPType> items = new ArrayList<DcSPType>();
	
	protected DcSPType(String name, int value) {
		super(DcSPType.class.getName(), name, value);
		items.add(this);
	}
	
	public static DcSPType getItem(int value){
		try {
			return (DcSPType)DcSPType.getResult(DcSPType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<DcSPType> getItems() {
		return items;
	}
	
	
	//单场胜负平
	public static final DcSPType SFP_S = new DcSPType("胜平负-胜", 1);
	public static final DcSPType SFP_F = new DcSPType("胜负平-负",2);
	public static final DcSPType SFP_P = new DcSPType("胜负平-平",3);
	
	//单场上下单双
	public static final DcSPType SXDS_SD = new DcSPType("上下单双-上单",4);
	public static final DcSPType SXDS_SS = new DcSPType("上下单双-上双",5);
	public static final DcSPType SXDS_XD = new DcSPType("上下单双-下单",6);
	public static final DcSPType SXDS_XS = new DcSPType("上下单双-下双",7);
	
	//单场进球数
	public static final DcSPType JQS_0 = new DcSPType("进球数-0",8);
	public static final DcSPType JQS_1 = new DcSPType("进球数-1",9);
	public static final DcSPType JQS_2 = new DcSPType("进球数-2",10);
	public static final DcSPType JQS_3 = new DcSPType("进球数-3",11);
	public static final DcSPType JQS_4 = new DcSPType("进球数-4",12);
	public static final DcSPType JQS_5 = new DcSPType("进球数-5",13);
	public static final DcSPType JQS_6 = new DcSPType("进球数-6",14);
	public static final DcSPType JQS_7 = new DcSPType("进球数-7",15);
	
	//单场比分-胜
	public static final DcSPType BF_S_10 = new DcSPType("比分-胜-10",16);
	public static final DcSPType BF_S_20 = new DcSPType("比分-胜-20",17);
	public static final DcSPType BF_S_21 = new DcSPType("比分-胜-21",18);
	public static final DcSPType BF_S_30 = new DcSPType("比分-胜-30",19);
	public static final DcSPType BF_S_31 = new DcSPType("比分-胜-31",20);
	public static final DcSPType BF_S_32 = new DcSPType("比分-胜-32",21);
	public static final DcSPType BF_S_40 = new DcSPType("比分-胜-40",22);
	public static final DcSPType BF_S_41 = new DcSPType("比分-胜-41",23);
	public static final DcSPType BF_S_42 = new DcSPType("比分-胜-42",24);
	public static final DcSPType BF_S_Other = new DcSPType("比分-胜-其他",25);
	
	//单场比分-平
	public static final DcSPType BF_P_0 = new DcSPType("比分-平-0",26);
	public static final DcSPType BF_P_1 = new DcSPType("比分-平-1",27);
	public static final DcSPType BF_P_2 = new DcSPType("比分-平-2",28);
	public static final DcSPType BF_P_3 = new DcSPType("比分-平-3",29);
	public static final DcSPType BF_P_Other = new DcSPType("比分-平-其他",30);
	
	//单场比分-负
	public static final DcSPType BF_F_01 = new DcSPType("比分-负-01",31);
	public static final DcSPType BF_F_02 = new DcSPType("比分-负-02",32);
	public static final DcSPType BF_F_12 = new DcSPType("比分-负-12",33);
	public static final DcSPType BF_F_03 = new DcSPType("比分-负-03",34);
	public static final DcSPType BF_F_13 = new DcSPType("比分-负-13",35);
	public static final DcSPType BF_F_23 = new DcSPType("比分-负-23",36);
	public static final DcSPType BF_F_04 = new DcSPType("比分-负-04",37);
	public static final DcSPType BF_F_14 = new DcSPType("比分-负-14",38);
	public static final DcSPType BF_F_24 = new DcSPType("比分-负-24",39);
	public static final DcSPType BF_F_Other = new DcSPType("比分-负-其他",40);
	
	//单场半场胜负平
	public static final DcSPType BCSFP_SS = new DcSPType("半场胜负平-胜-胜",41);
	public static final DcSPType BCSFP_SP = new DcSPType("半场胜负平-胜-平",42);
	public static final DcSPType BCSFP_SF = new DcSPType("半场胜负平-胜-负",43);
	public static final DcSPType BCSFP_PS = new DcSPType("半场胜负平-平-胜",44);
	public static final DcSPType BCSFP_PP = new DcSPType("半场胜负平-平-平",45);
	public static final DcSPType BCSFP_PF = new DcSPType("半场胜负平-平-负",46);
	public static final DcSPType BCSFP_FS = new DcSPType("半场胜负平-负-胜",47);
	public static final DcSPType BCSFP_FP = new DcSPType("半场胜负平-负-平",48);
	public static final DcSPType BCSFP_FF = new DcSPType("半场胜负平-负-负",49);

	@Override
	public String toString() {
		return this.name;
	}

}
