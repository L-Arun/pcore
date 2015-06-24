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

/**
 * @author sunshow
 *
 */
public class LotteryConstant {
	
	private static final Logger logger = LoggerFactory.getLogger(LotteryConstant.class.getName());

	/**
	 * 大小单双投注中的小
	 */
	public static String SMALL = "1";
	/**
	 * 大小单双投注中的大
	 */
	public static String LARGE = "2";
	/**
	 * 大小单双投注中的单
	 */
	public static String ODD = "5";
	/**
	 * 大小单双投注中的双
	 */
	public static String EVEN = "4";
	/**
	 * 足球比赛特殊字符,如单场则为比赛取消
	 */
	public static String MATCH_SPECIAL_CHARACTER = "*";
	
	//单场胜负平
	public static final String DC_SFP_S_VALUE = "3";
	public static final String DC_SFP_F_VALUE = "0";
	public static final String DC_SFP_P_VALUE = "1";
	
	//单场上下盘单双
	public static final String DC_SXDS_SD_VALUE = "1"; 
	public static final String DC_SXDS_SS_VALUE = "2"; 
	public static final String DC_SXDS_XD_VALUE = "3"; 
	public static final String DC_SXDS_XS_VALUE = "4"; 
	
	//单场总进球数
	public static final String DC_JQX_0_VALUE = "1"; 
	public static final String DC_JQX_1_VALUE = "2"; 
	public static final String DC_JQX_2_VALUE = "3"; 
	public static final String DC_JQX_3_VALUE = "4"; 
	public static final String DC_JQX_4_VALUE = "5"; 
	public static final String DC_JQX_5_VALUE = "6"; 
	public static final String DC_JQX_6_VALUE = "7"; 
	public static final String DC_JQX_7_VALUE = "8"; 
	
	//单场比分
	public static final String DC_BF_S_Ohter_VALUE = "1"; //胜其它
	public static final String DC_BF_S_10_VALUE = "2"; //1:0
	public static final String DC_BF_S_20_VALUE = "3"; //2:0
	public static final String DC_BF_S_21_VALUE = "4"; //2:1
	public static final String DC_BF_S_30_VALUE = "5"; //3:0
	public static final String DC_BF_S_31_VALUE = "6"; //3:1
	public static final String DC_BF_S_32_VALUE = "7"; //3:2
	public static final String DC_BF_S_40_VALUE = "8"; //4:0
	public static final String DC_BF_S_41_VALUE = "9"; //4;1
	public static final String DC_BF_S_42_VALUE = "10"; //4:2

	public static final String DC_BF_P_Other_VALUE = "11"; //平其它
	public static final String DC_BF_P_0_VALUE = "12"; //0:0
	public static final String DC_BF_P_1_VALUE = "13"; //1:1
	public static final String DC_BF_P_2_VALUE = "14"; //2:2
	public static final String DC_BF_P_3_VALUE = "15"; //3:3
	
	public static final String DC_BF_F_Other_VALUE = "16"; //负其它
	public static final String DC_BF_F_01_VALUE = "17"; //0:1
	public static final String DC_BF_F_02_VALUE = "18"; //0:2
	public static final String DC_BF_F_12_VALUE = "19"; //1:2
	public static final String DC_BF_F_03_VALUE = "20"; //0:3
	public static final String DC_BF_F_13_VALUE = "21"; //1:3
	public static final String DC_BF_F_23_VALUE = "22"; //2:3
	public static final String DC_BF_F_04_VALUE = "23"; //0:4
	public static final String DC_BF_F_14_VALUE = "24"; //1:4
	public static final String DC_BF_F_24_VALUE = "25"; //2:4
	
	
	//单场半场胜负平
	public static final String DC_BCSFP_SS_VALUE = "1"; 
	public static final String DC_BCSFP_SP_VALUE = "2"; 
	public static final String DC_BCSFP_SF_VALUE = "3"; 
	public static final String DC_BCSFP_PS_VALUE = "4"; 
	public static final String DC_BCSFP_PP_VALUE = "5"; 
	public static final String DC_BCSFP_PF_VALUE = "6"; 
	public static final String DC_BCSFP_FS_VALUE = "7"; 
	public static final String DC_BCSFP_FP_VALUE = "8"; 
	public static final String DC_BCSFP_FF_VALUE = "9"; 
	
	//单场奥运竞猜胜负过关
	public static final String DC_SFGG_S_VALUE = "3";
	public static final String DC_SFGG_F_VALUE = "0";
	
	// 竞彩篮球胜负
	public static final String JCLQ_SF_S_VALUE = "3";	// 主胜
	public static final String JCLQ_SF_F_VALUE = "0";	// 主负
	public static final String JCLQ_SF_S_NAME = "主胜";	// 主胜
	public static final String JCLQ_SF_F_NAME = "主负";	// 主负
	
	// 竞彩篮球让分胜负
	public static final String JCLQ_RFSF_S_VALUE = "3";	// 主胜
	public static final String JCLQ_RFSF_F_VALUE = "0";	// 主负
	public static final String JCLQ_RFSF_S_NAME = "主胜";	// 主胜
	public static final String JCLQ_RFSF_F_NAME = "主负";	// 主负
	public static final String JCLQ_RFSF_HANDICAP = "handicap";	// 让分
	
	// 竞彩篮球胜分差
	public static final String JCLQ_SFC_H_1_5_VALUE = "1";	// 主胜1-5分
	public static final String JCLQ_SFC_H_6_10_VALUE = "2";	// 主胜6-10分
	public static final String JCLQ_SFC_H_11_15_VALUE = "3";	// 主胜11-15分
	public static final String JCLQ_SFC_H_16_20_VALUE = "4";	// 主胜16-20分
	public static final String JCLQ_SFC_H_21_25_VALUE = "5";	// 主胜21-25分
	public static final String JCLQ_SFC_H_26_PLUS_VALUE = "6";	// 主胜26+分
	public static final String JCLQ_SFC_A_1_5_VALUE = "7";	// 客胜1-5分
	public static final String JCLQ_SFC_A_6_10_VALUE = "8";	// 客胜6-10分
	public static final String JCLQ_SFC_A_11_15_VALUE = "9";	// 客胜11-15分
	public static final String JCLQ_SFC_A_16_20_VALUE = "10";	// 客胜16-20分
	public static final String JCLQ_SFC_A_21_25_VALUE = "11";	// 客胜21-25分
	public static final String JCLQ_SFC_A_26_PLUS_VALUE = "12";	// 客胜26+分
	public static final String JCLQ_SFC_H_1_5_NAME = "主胜1-5分";	// 主胜1-5分
	public static final String JCLQ_SFC_H_6_10_NAME = "主胜6-10分";	// 主胜6-10分
	public static final String JCLQ_SFC_H_11_15_NAME = "主胜11-15分";	// 主胜11-15分
	public static final String JCLQ_SFC_H_16_20_NAME = "主胜16-20分";	// 主胜16-20分
	public static final String JCLQ_SFC_H_21_25_NAME = "主胜21-25分";	// 主胜21-25分
	public static final String JCLQ_SFC_H_26_PLUS_NAME = "主胜26+分";	// 主胜26+分
	public static final String JCLQ_SFC_A_1_5_NAME = "客胜1-5分";	// 客胜1-5分
	public static final String JCLQ_SFC_A_6_10_NAME = "客胜6-10分";	// 客胜6-10分
	public static final String JCLQ_SFC_A_11_15_NAME = "客胜11-15分";	// 客胜11-15分
	public static final String JCLQ_SFC_A_16_20_NAME = "客胜16-20分";	// 客胜16-20分
	public static final String JCLQ_SFC_A_21_25_NAME = "客胜21-25分";	// 客胜21-25分
	public static final String JCLQ_SFC_A_26_PLUS_NAME = "客胜26+分";	// 客胜26+分
	
	// 竞彩篮球大小分
	public static final String JCLQ_DXF_SMALL = "1";		// 小分
	public static final String JCLQ_DXF_LARGE = "2";		// 大分
	public static final String JCLQ_DXF_SMALL_NAME = "小分";	// 小分
	public static final String JCLQ_DXF_LARGE_NAME = "大分";	// 大分
	public static final String JCLQ_DXF_PRESETSCORE = "preset_score";		// 预设总分
	
	//竞彩足球让球胜平负
	public static final String JCZQ_SPF_S_VALUE = "3";//让球胜平负-主队胜
	public static final String JCZQ_SPF_P_VALUE = "1";//让球胜平负-主队平
	public static final String JCZQ_SPF_F_VALUE = "0";//让球胜平负-主队负"
	public static final String JCZQ_SPF_S_NAME = "让球胜平负-主队胜";//让球胜平负-主队胜
	public static final String JCZQ_SPF_P_NAME = "让球胜平负-主队平";//让球胜平负-主队平
	public static final String JCZQ_SPF_F_NAME = "让球胜平负-主队负";//让球胜平负-主队负"
	//public static final String JCZQ_SPF_RQ_VALUE = "handicap";//让球胜平负-主队让球数
	
	//竞彩足球全场比分
	public static final String JCZQ_BF_ZS_1_0_VALUE = "1";//全场比分-主胜-1:0
	public static final String JCZQ_BF_ZS_2_0_VALUE = "2";//全场比分-主胜-2:0
	public static final String JCZQ_BF_ZS_2_1_VALUE = "3";//全场比分-主胜-2:1
	public static final String JCZQ_BF_ZS_3_0_VALUE = "4";//全场比分-主胜-3:0
	public static final String JCZQ_BF_ZS_3_1_VALUE = "5";//全场比分-主胜-3:1
	public static final String JCZQ_BF_ZS_3_2_VALUE = "6";//全场比分-主胜-3:2
	public static final String JCZQ_BF_ZS_4_0_VALUE = "7";//全场比分-主胜-4:0
	public static final String JCZQ_BF_ZS_4_1_VALUE = "8";//全场比分-主胜-4:1
	public static final String JCZQ_BF_ZS_4_2_VALUE = "9";//全场比分-主胜-4:2
	public static final String JCZQ_BF_ZS_5_0_VALUE = "10";//全场比分-主胜-5:0
	public static final String JCZQ_BF_ZS_5_1_VALUE = "11";//全场比分-主胜-5:1
	public static final String JCZQ_BF_ZS_5_2_VALUE = "12";//全场比分-主胜-5:2
	public static final String JCZQ_BF_ZS_QT_VALUE = "13";//全场比分-主胜-胜其他
	public static final String JCZQ_BF_ZS_1_0_NAME = "全场比分-主胜-1:0";//全场比分-主胜-1:0
	public static final String JCZQ_BF_ZS_2_0_NAME = "全场比分-主胜-2:0";//全场比分-主胜-2:0
	public static final String JCZQ_BF_ZS_2_1_NAME = "全场比分-主胜-2:1";//全场比分-主胜-2:1
	public static final String JCZQ_BF_ZS_3_0_NAME = "全场比分-主胜-3:0";//全场比分-主胜-3:0
	public static final String JCZQ_BF_ZS_3_1_NAME = "全场比分-主胜-3:1";//全场比分-主胜-3:1
	public static final String JCZQ_BF_ZS_3_2_NAME = "全场比分-主胜-3:2";//全场比分-主胜-3:2
	public static final String JCZQ_BF_ZS_4_0_NAME = "全场比分-主胜-4:0";//全场比分-主胜-4:0
	public static final String JCZQ_BF_ZS_4_1_NAME = "全场比分-主胜-4:1";//全场比分-主胜-4:1
	public static final String JCZQ_BF_ZS_4_2_NAME = "全场比分-主胜-4:2";//全场比分-主胜-4:2
	public static final String JCZQ_BF_ZS_5_0_NAME = "全场比分-主胜-5:0";//全场比分-主胜-5:0
	public static final String JCZQ_BF_ZS_5_1_NAME = "全场比分-主胜-5:1";//全场比分-主胜-5:1
	public static final String JCZQ_BF_ZS_5_2_NAME = "全场比分-主胜-5:2";//全场比分-主胜-5:2
	public static final String JCZQ_BF_ZS_QT_NAME = "全场比分-主胜-胜其他";//全场比分-主胜-胜其他
	
	public static final String JCZQ_BF_ZP_0_0_VALUE = "14";//全场比分-主平-0:0
	public static final String JCZQ_BF_ZP_1_1_VALUE = "15";//全场比分-主平-1:1
	public static final String JCZQ_BF_ZP_2_2_VALUE = "16";//全场比分-主平-2:2
	public static final String JCZQ_BF_ZP_3_3_VALUE = "17";//全场比分-主平-3:3
	public static final String JCZQ_BF_ZP_QT_VALUE = "18";//全场比分-主平-平其他
	public static final String JCZQ_BF_ZP_0_0_NAME = "全场比分-主平-0:0";//全场比分-主平-0:0
	public static final String JCZQ_BF_ZP_1_1_NAME = "全场比分-主平-1:1";//全场比分-主平-1:1
	public static final String JCZQ_BF_ZP_2_2_NAME = "全场比分-主平-2:2";//全场比分-主平-2:2
	public static final String JCZQ_BF_ZP_3_3_NAME = "全场比分-主平-3:3";//全场比分-主平-3:3
	public static final String JCZQ_BF_ZP_QT_NAME = "全场比分-主平-平其他";//全场比分-主平-平其他
	
	public static final String JCZQ_BF_ZF_0_1_VALUE = "19";//全场比分-主负-0:1
	public static final String JCZQ_BF_ZF_0_2_VALUE = "20";//全场比分-主负-0:2
	public static final String JCZQ_BF_ZF_1_2_VALUE = "21";//全场比分-主负-1:2
	public static final String JCZQ_BF_ZF_0_3_VALUE = "22";//全场比分-主负-0:3
	public static final String JCZQ_BF_ZF_1_3_VALUE = "23";//全场比分-主负-1:3
	public static final String JCZQ_BF_ZF_2_3_VALUE = "24";//全场比分-主负-2:3
	public static final String JCZQ_BF_ZF_0_4_VALUE = "25";//全场比分-主负-0:4
	public static final String JCZQ_BF_ZF_1_4_VALUE = "26";//全场比分-主负-1:4
	public static final String JCZQ_BF_ZF_2_4_VALUE = "27";//全场比分-主负-2:4
	public static final String JCZQ_BF_ZF_0_5_VALUE = "28";//全场比分-主负-0:5
	public static final String JCZQ_BF_ZF_1_5_VALUE = "29";//全场比分-主负-1:5
	public static final String JCZQ_BF_ZF_2_5_VALUE = "30";//全场比分-主负-2:5
	public static final String JCZQ_BF_ZF_QT_VALUE = "31";//全场比分-主负-负其他
	public static final String JCZQ_BF_ZF_0_1_NAME = "全场比分-主负-0:1";//全场比分-主负-0:1
	public static final String JCZQ_BF_ZF_0_2_NAME = "全场比分-主负-0:2";//全场比分-主负-0:2
	public static final String JCZQ_BF_ZF_1_2_NAME = "全场比分-主负-1:2";//全场比分-主负-1:2
	public static final String JCZQ_BF_ZF_0_3_NAME = "全场比分-主负-0:3";//全场比分-主负-0:3
	public static final String JCZQ_BF_ZF_1_3_NAME = "全场比分-主负-1:3";//全场比分-主负-1:3
	public static final String JCZQ_BF_ZF_2_3_NAME = "全场比分-主负-2:3";//全场比分-主负-2:3
	public static final String JCZQ_BF_ZF_0_4_NAME = "全场比分-主负-0:4";//全场比分-主负-0:4
	public static final String JCZQ_BF_ZF_1_4_NAME = "全场比分-主负-1:4";//全场比分-主负-1:4
	public static final String JCZQ_BF_ZF_2_4_NAME = "全场比分-主负-2:4";//全场比分-主负-2:4
	public static final String JCZQ_BF_ZF_0_5_NAME = "全场比分-主负-0:5";//全场比分-主负-0:5
	public static final String JCZQ_BF_ZF_1_5_NAME = "全场比分-主负-1:5";//全场比分-主负-1:5
	public static final String JCZQ_BF_ZF_2_5_NAME = "全场比分-主负-2:5";//全场比分-主负-2:5
	public static final String JCZQ_BF_ZF_QT_NAME = "全场比分-主负-负其他";//全场比分-主负-负其他
	
	//竞彩足球总进球数
	public static final String JCZQ_JQS_0_VALUE = "1";//总进球数-0
	public static final String JCZQ_JQS_1_VALUE = "2";//总进球数-1
	public static final String JCZQ_JQS_2_VALUE = "3";//总进球数-2
	public static final String JCZQ_JQS_3_VALUE = "4";//总进球数-3
	public static final String JCZQ_JQS_4_VALUE = "5";//总进球数-4
	public static final String JCZQ_JQS_5_VALUE = "6";//总进球数-5
	public static final String JCZQ_JQS_6_VALUE = "7";//总进球数-6
	public static final String JCZQ_JQS_7_VALUE = "8";//总进球数-7+
	public static final String JCZQ_JQS_0_NAME = "总进球数-0";//总进球数-0
	public static final String JCZQ_JQS_1_NAME = "总进球数-1";//总进球数-1
	public static final String JCZQ_JQS_2_NAME = "总进球数-2";//总进球数-2
	public static final String JCZQ_JQS_3_NAME = "总进球数-3";//总进球数-3
	public static final String JCZQ_JQS_4_NAME = "总进球数-4";//总进球数-4
	public static final String JCZQ_JQS_5_NAME = "总进球数-5";//总进球数-5
	public static final String JCZQ_JQS_6_NAME = "总进球数-6";//总进球数-6
	public static final String JCZQ_JQS_7_NAME = "总进球数-7+";//总进球数-7+
	
	//竞彩足球半场胜平负
	public static final String JCZQ_BQC_SS_VALUE = "1";//半全场胜平负-胜胜
	public static final String JCZQ_BQC_SP_VALUE = "2";//半全场胜平负-胜平
	public static final String JCZQ_BQC_SF_VALUE = "3";//半全场胜平负-胜负
	public static final String JCZQ_BQC_PS_VALUE = "4";//半全场胜平负-平胜
	public static final String JCZQ_BQC_PP_VALUE = "5";//半全场胜平负-平平
	public static final String JCZQ_BQC_PF_VALUE = "6";//半全场胜平负-平负
	public static final String JCZQ_BQC_FS_VALUE = "7";//半全场胜平负-负胜
	public static final String JCZQ_BQC_FP_VALUE = "8";//半全场胜平负-负平
	public static final String JCZQ_BQC_FF_VALUE = "9";//半全场胜平负-负负
	public static final String JCZQ_BQC_SS_NAME = "半全场胜平负-胜胜";//半全场胜平负-胜胜
	public static final String JCZQ_BQC_SP_NAME = "半全场胜平负-胜平";//半全场胜平负-胜平
	public static final String JCZQ_BQC_SF_NAME = "半全场胜平负-胜负";//半全场胜平负-胜负
	public static final String JCZQ_BQC_PS_NAME = "半全场胜平负-平胜";//半全场胜平负-平胜
	public static final String JCZQ_BQC_PP_NAME = "半全场胜平负-平平";//半全场胜平负-平平
	public static final String JCZQ_BQC_PF_NAME = "半全场胜平负-平负";//半全场胜平负-平负
	public static final String JCZQ_BQC_FS_NAME = "半全场胜平负-负胜";//半全场胜平负-负胜
	public static final String JCZQ_BQC_FP_NAME = "半全场胜平负-负平";//半全场胜平负-负平
	public static final String JCZQ_BQC_FF_NAME = "半全场胜平负-负负";//半全场胜平负-负负
	
	//竞彩足球冠军
	public static final String JCZQ_GJ_VALUE = "1";
	public static final String JCZQ_GJ_NAME = "猜冠军";
	//竞彩足球冠亚军
	public static final String JCZQ_GYJ_VALUE = "1";
	public static final String JCZQ_GYJ_NAME = "猜冠亚军";
	
	public static final String JCLQ_MATCH_NUM_CODE_DEFAULT = "00";  //比赛编码中间预留
	public static final String JCZQ_MATCH_NUM_CODE_DEFAULT = "01";  //比赛编码中间预留

	// 数字彩通用号码定义
	// 乐世胜豪需要转换投注码
	public static final Integer NUMERIC_LOTTERY_1 = 1;
	public static final Integer NUMERIC_LOTTERY_2 = 2;
	public static final Integer NUMERIC_LOTTERY_3 = 3;
	public static final Integer NUMERIC_LOTTERY_4 = 4;
	public static final Integer NUMERIC_LOTTERY_5 = 5;
	public static final Integer NUMERIC_LOTTERY_6 = 6;
	public static final Integer NUMERIC_LOTTERY_7 = 7;
	public static final Integer NUMERIC_LOTTERY_8 = 8;
	public static final Integer NUMERIC_LOTTERY_9 = 9;
	public static final Integer NUMERIC_LOTTERY_10 = 10;
	public static final Integer NUMERIC_LOTTERY_11 = 11;
	public static final Integer NUMERIC_LOTTERY_12 = 12;
	public static final Integer NUMERIC_LOTTERY_13 = 13;
	public static final Integer NUMERIC_LOTTERY_14 = 14;
	public static final Integer NUMERIC_LOTTERY_15 = 15;
	public static final Integer NUMERIC_LOTTERY_16 = 16;
	public static final Integer NUMERIC_LOTTERY_17 = 17;
	public static final Integer NUMERIC_LOTTERY_18 = 18;
	public static final Integer NUMERIC_LOTTERY_19 = 19;
	public static final Integer NUMERIC_LOTTERY_20 = 20;
	public static final Integer NUMERIC_LOTTERY_21 = 21;
	public static final Integer NUMERIC_LOTTERY_22 = 22;
	public static final Integer NUMERIC_LOTTERY_23 = 23;
	public static final Integer NUMERIC_LOTTERY_24 = 24;
	public static final Integer NUMERIC_LOTTERY_25 = 25;
	public static final Integer NUMERIC_LOTTERY_26 = 26;
	public static final Integer NUMERIC_LOTTERY_27 = 27;
	public static final Integer NUMERIC_LOTTERY_28 = 28;
	public static final Integer NUMERIC_LOTTERY_29 = 29;
	public static final Integer NUMERIC_LOTTERY_30 = 30;
	public static final Integer NUMERIC_LOTTERY_31 = 31;
	public static final Integer NUMERIC_LOTTERY_32 = 32;
	public static final Integer NUMERIC_LOTTERY_33 = 33;
	public static final Integer NUMERIC_LOTTERY_34 = 34;
	public static final Integer NUMERIC_LOTTERY_35 = 35;

	private final static Map<LotteryType, Map<String, String>> lotteryConstantNameMap = new HashMap<LotteryType, Map<String, String>>();
	
	static {
		Map<String, String> _70Map = new HashMap<String, String>();
		_70Map.put(JCLQ_SF_S_VALUE, JCLQ_SF_S_NAME);
		_70Map.put(JCLQ_SF_F_VALUE, JCLQ_SF_F_NAME);
		lotteryConstantNameMap.put(LotteryType.JCLQ_SF, _70Map);
		
		Map<String, String> _71Map = new HashMap<String, String>();
		_71Map.put(JCLQ_RFSF_S_VALUE, JCLQ_RFSF_S_NAME);
		_71Map.put(JCLQ_RFSF_F_VALUE, JCLQ_RFSF_F_NAME);
		lotteryConstantNameMap.put(LotteryType.JCLQ_RFSF, _71Map);
		
		Map<String, String> _72Map = new HashMap<String, String>();
		_72Map.put(JCLQ_SFC_H_1_5_VALUE, JCLQ_SFC_H_1_5_NAME);
		_72Map.put(JCLQ_SFC_H_6_10_VALUE, JCLQ_SFC_H_6_10_NAME);
		_72Map.put(JCLQ_SFC_H_11_15_VALUE, JCLQ_SFC_H_11_15_NAME);
		_72Map.put(JCLQ_SFC_H_16_20_VALUE, JCLQ_SFC_H_16_20_NAME);
		_72Map.put(JCLQ_SFC_H_21_25_VALUE, JCLQ_SFC_H_21_25_NAME);
		_72Map.put(JCLQ_SFC_H_26_PLUS_VALUE, JCLQ_SFC_H_26_PLUS_NAME);
		_72Map.put(JCLQ_SFC_A_1_5_VALUE, JCLQ_SFC_A_1_5_NAME);
		_72Map.put(JCLQ_SFC_A_6_10_VALUE, JCLQ_SFC_A_6_10_NAME);
		_72Map.put(JCLQ_SFC_A_11_15_VALUE, JCLQ_SFC_A_11_15_NAME);
		_72Map.put(JCLQ_SFC_A_16_20_VALUE, JCLQ_SFC_A_16_20_NAME);
		_72Map.put(JCLQ_SFC_A_21_25_VALUE, JCLQ_SFC_A_21_25_NAME);
		_72Map.put(JCLQ_SFC_A_26_PLUS_VALUE, JCLQ_SFC_A_26_PLUS_NAME);
		lotteryConstantNameMap.put(LotteryType.JCLQ_SFC, _72Map);
		
		Map<String, String> _73Map = new HashMap<String, String>();
		_73Map.put(JCLQ_DXF_SMALL, JCLQ_DXF_SMALL_NAME);
		_73Map.put(JCLQ_DXF_LARGE, JCLQ_DXF_LARGE_NAME);
		lotteryConstantNameMap.put(LotteryType.JCLQ_DXF, _73Map);
		
		Map<String, String> _80Map = new HashMap<String, String>();
		_80Map.put(JCZQ_SPF_S_VALUE, JCZQ_SPF_S_NAME);
		_80Map.put(JCZQ_SPF_P_VALUE, JCZQ_SPF_P_NAME);
		_80Map.put(JCZQ_SPF_F_VALUE, JCZQ_SPF_F_NAME);
		lotteryConstantNameMap.put(LotteryType.JCZQ_SPF, _80Map);
		
		
		Map<String, String> _81Map = new HashMap<String, String>();
		_81Map.put(JCZQ_BF_ZS_1_0_VALUE, JCZQ_BF_ZS_1_0_NAME);
		_81Map.put(JCZQ_BF_ZS_2_0_VALUE, JCZQ_BF_ZS_2_0_NAME);
		_81Map.put(JCZQ_BF_ZS_2_1_VALUE, JCZQ_BF_ZS_2_1_NAME);
		_81Map.put(JCZQ_BF_ZS_3_0_VALUE, JCZQ_BF_ZS_3_0_NAME);
		_81Map.put(JCZQ_BF_ZS_3_1_VALUE, JCZQ_BF_ZS_3_1_NAME);
		_81Map.put(JCZQ_BF_ZS_3_2_VALUE, JCZQ_BF_ZS_3_2_NAME);
		_81Map.put(JCZQ_BF_ZS_4_0_VALUE, JCZQ_BF_ZS_4_0_NAME);
		_81Map.put(JCZQ_BF_ZS_4_1_VALUE, JCZQ_BF_ZS_4_1_NAME);
		_81Map.put(JCZQ_BF_ZS_4_2_VALUE, JCZQ_BF_ZS_4_2_NAME);
		_81Map.put(JCZQ_BF_ZS_5_0_VALUE, JCZQ_BF_ZS_5_0_NAME);
		_81Map.put(JCZQ_BF_ZS_5_1_VALUE, JCZQ_BF_ZS_5_1_NAME);
		_81Map.put(JCZQ_BF_ZS_5_2_VALUE, JCZQ_BF_ZS_5_2_NAME);
		_81Map.put(JCZQ_BF_ZS_QT_VALUE, JCZQ_BF_ZS_QT_VALUE);
		
		_81Map.put(JCZQ_BF_ZP_0_0_VALUE, JCZQ_BF_ZP_0_0_NAME);
		_81Map.put(JCZQ_BF_ZP_1_1_VALUE, JCZQ_BF_ZP_1_1_NAME);
		_81Map.put(JCZQ_BF_ZP_2_2_VALUE, JCZQ_BF_ZP_2_2_NAME);
		_81Map.put(JCZQ_BF_ZP_3_3_VALUE, JCZQ_BF_ZP_3_3_NAME);
		_81Map.put(JCZQ_BF_ZP_QT_VALUE, JCZQ_BF_ZP_QT_NAME);
		
		_81Map.put(JCZQ_BF_ZF_0_1_VALUE, JCZQ_BF_ZF_0_1_NAME);
		_81Map.put(JCZQ_BF_ZF_0_2_VALUE, JCZQ_BF_ZF_0_2_NAME);
		_81Map.put(JCZQ_BF_ZF_1_2_VALUE, JCZQ_BF_ZF_1_2_NAME);
		_81Map.put(JCZQ_BF_ZF_0_3_VALUE, JCZQ_BF_ZF_0_3_NAME);
		_81Map.put(JCZQ_BF_ZF_1_3_VALUE, JCZQ_BF_ZF_1_3_NAME);
		_81Map.put(JCZQ_BF_ZF_2_3_VALUE, JCZQ_BF_ZF_2_3_NAME);
		_81Map.put(JCZQ_BF_ZF_0_4_VALUE, JCZQ_BF_ZF_0_4_NAME);
		_81Map.put(JCZQ_BF_ZF_1_4_VALUE, JCZQ_BF_ZF_1_4_NAME);
		_81Map.put(JCZQ_BF_ZF_2_4_VALUE, JCZQ_BF_ZF_2_4_NAME);
		_81Map.put(JCZQ_BF_ZF_0_5_VALUE, JCZQ_BF_ZF_0_5_NAME);
		_81Map.put(JCZQ_BF_ZF_1_5_VALUE, JCZQ_BF_ZF_1_5_NAME);
		_81Map.put(JCZQ_BF_ZF_2_5_VALUE, JCZQ_BF_ZF_2_5_NAME);
		_81Map.put(JCZQ_BF_ZF_QT_VALUE, JCZQ_BF_ZF_QT_NAME);
		lotteryConstantNameMap.put(LotteryType.JCZQ_BF, _81Map);
		
		Map<String, String> _82Map = new HashMap<String, String>();
		_82Map.put(JCZQ_JQS_0_VALUE, JCZQ_JQS_0_NAME);
		_82Map.put(JCZQ_JQS_1_VALUE, JCZQ_JQS_1_NAME);
		_82Map.put(JCZQ_JQS_2_VALUE, JCZQ_JQS_2_NAME);
		_82Map.put(JCZQ_JQS_3_VALUE, JCZQ_JQS_3_NAME);
		_82Map.put(JCZQ_JQS_4_VALUE, JCZQ_JQS_4_NAME);
		_82Map.put(JCZQ_JQS_5_VALUE, JCZQ_JQS_5_NAME);
		_82Map.put(JCZQ_JQS_6_VALUE, JCZQ_JQS_6_NAME);
		_82Map.put(JCZQ_JQS_7_VALUE, JCZQ_JQS_7_NAME);
		lotteryConstantNameMap.put(LotteryType.JCZQ_JQS, _82Map);
		
		Map<String, String> _83Map = new HashMap<String, String>();
		_83Map.put(JCZQ_BQC_SS_VALUE, JCZQ_BQC_SS_NAME);
		_83Map.put(JCZQ_BQC_SP_VALUE, JCZQ_BQC_SP_NAME);
		_83Map.put(JCZQ_BQC_SF_VALUE, JCZQ_BQC_SF_NAME);
		_83Map.put(JCZQ_BQC_PS_VALUE, JCZQ_BQC_PS_NAME);
		_83Map.put(JCZQ_BQC_PP_VALUE, JCZQ_BQC_PP_NAME);
		_83Map.put(JCZQ_BQC_PF_VALUE, JCZQ_BQC_PF_NAME);
		_83Map.put(JCZQ_BQC_FS_VALUE, JCZQ_BQC_FS_NAME);
		_83Map.put(JCZQ_BQC_FP_VALUE, JCZQ_BQC_FP_NAME);
		_83Map.put(JCZQ_BQC_FF_VALUE, JCZQ_BQC_FF_NAME);
		lotteryConstantNameMap.put(LotteryType.JCZQ_BQC, _83Map);
		
		Map<String, String> _90Map = new HashMap<String, String>();
		_90Map.put(JCZQ_GJ_VALUE, JCZQ_GJ_NAME);
		lotteryConstantNameMap.put(LotteryType.JCZQ_GJ, _90Map);
		
		Map<String, String> _91Map = new HashMap<String, String>();
		_91Map.put(JCZQ_GYJ_VALUE, JCZQ_GYJ_NAME);
		lotteryConstantNameMap.put(LotteryType.JCZQ_GYJ, _91Map);
	}
	
	public static String getLotteryConstantName(LotteryType lotteryType, String key) {
		if (lotteryConstantNameMap == null || !lotteryConstantNameMap.containsKey(lotteryType)) {
			logger.error("未找到彩种({})的投注项名称定义", lotteryType.getName());
			return null;
		}
		
		Map<String, String> lotteryMap = lotteryConstantNameMap.get(lotteryType);
		if (lotteryMap != null && lotteryMap.containsKey(key)) {
			return lotteryMap.get(key);
		}
		
		return null;
	}
	
	private final static Map<LotteryType, List<String>> lotteryConstantMap = new HashMap<LotteryType, List<String>>();
	
	static {
		List<String> _70List = new ArrayList<String>();
		_70List.add(JCLQ_SF_S_VALUE);
		_70List.add(JCLQ_SF_F_VALUE);
		lotteryConstantMap.put(LotteryType.JCLQ_SF, _70List);
		
		List<String> _71List = new ArrayList<String>();
		_71List.add(JCLQ_RFSF_S_VALUE);
		_71List.add(JCLQ_RFSF_F_VALUE);
		_71List.add(JCLQ_RFSF_HANDICAP);
		lotteryConstantMap.put(LotteryType.JCLQ_RFSF, _71List);
		
		List<String> _72List = new ArrayList<String>();
		_72List.add(JCLQ_SFC_H_1_5_VALUE);
		_72List.add(JCLQ_SFC_H_6_10_VALUE);
		_72List.add(JCLQ_SFC_H_11_15_VALUE);
		_72List.add(JCLQ_SFC_H_16_20_VALUE);
		_72List.add(JCLQ_SFC_H_21_25_VALUE);
		_72List.add(JCLQ_SFC_H_26_PLUS_VALUE);
		_72List.add(JCLQ_SFC_A_1_5_VALUE);
		_72List.add(JCLQ_SFC_A_6_10_VALUE);
		_72List.add(JCLQ_SFC_A_11_15_VALUE);
		_72List.add(JCLQ_SFC_A_16_20_VALUE);
		_72List.add(JCLQ_SFC_A_21_25_VALUE);
		_72List.add(JCLQ_SFC_A_26_PLUS_VALUE);
		lotteryConstantMap.put(LotteryType.JCLQ_SFC, _72List);
		
		List<String> _73List = new ArrayList<String>();
		_73List.add(JCLQ_DXF_SMALL);
		_73List.add(JCLQ_DXF_LARGE);
		_73List.add(JCLQ_DXF_PRESETSCORE);
		lotteryConstantMap.put(LotteryType.JCLQ_DXF, _73List);
		
		List<String> _80List = new ArrayList<String>();
		_80List.add(JCZQ_SPF_S_VALUE);
		_80List.add(JCZQ_SPF_P_VALUE);
        _80List.add(JCZQ_SPF_F_VALUE);
		//_80List.add(JCZQ_SPF_RQ_VALUE);
		lotteryConstantMap.put(LotteryType.JCZQ_SPF, _80List);
		
		List<String> _81List = new ArrayList<String>();
		_81List.add(JCZQ_BF_ZS_1_0_VALUE);
		_81List.add(JCZQ_BF_ZS_2_0_VALUE);
		_81List.add(JCZQ_BF_ZS_2_1_VALUE);
        _81List.add(JCZQ_BF_ZS_3_0_VALUE);
		_81List.add(JCZQ_BF_ZS_3_1_VALUE);
		_81List.add(JCZQ_BF_ZS_3_2_VALUE);
        _81List.add(JCZQ_BF_ZS_4_0_VALUE);
		_81List.add(JCZQ_BF_ZS_4_1_VALUE);
		_81List.add(JCZQ_BF_ZS_4_2_VALUE);
        _81List.add(JCZQ_BF_ZS_5_0_VALUE);
		_81List.add(JCZQ_BF_ZS_5_1_VALUE);
		_81List.add(JCZQ_BF_ZS_5_2_VALUE);
        _81List.add(JCZQ_BF_ZS_QT_VALUE);
		_81List.add(JCZQ_BF_ZP_0_0_VALUE);
		_81List.add(JCZQ_BF_ZP_1_1_VALUE);
        _81List.add(JCZQ_BF_ZP_2_2_VALUE);
		_81List.add(JCZQ_BF_ZP_3_3_VALUE);
		_81List.add(JCZQ_BF_ZP_QT_VALUE);
		_81List.add(JCZQ_BF_ZF_0_1_VALUE);
        _81List.add(JCZQ_BF_ZF_0_2_VALUE);
		_81List.add(JCZQ_BF_ZF_1_2_VALUE);
		_81List.add(JCZQ_BF_ZF_0_3_VALUE);
        _81List.add(JCZQ_BF_ZF_1_3_VALUE);
		_81List.add(JCZQ_BF_ZF_2_3_VALUE);
		_81List.add(JCZQ_BF_ZF_0_4_VALUE);
        _81List.add(JCZQ_BF_ZF_1_4_VALUE);
		_81List.add(JCZQ_BF_ZF_2_4_VALUE);
		_81List.add(JCZQ_BF_ZF_0_5_VALUE);
        _81List.add(JCZQ_BF_ZF_1_5_VALUE);
		_81List.add(JCZQ_BF_ZF_2_5_VALUE);
		_81List.add(JCZQ_BF_ZF_QT_VALUE);
		lotteryConstantMap.put(LotteryType.JCZQ_BF, _81List);
		
		List<String> _82List = new ArrayList<String>();
		_82List.add(JCZQ_JQS_0_VALUE);
		_82List.add(JCZQ_JQS_1_VALUE);
		_82List.add(JCZQ_JQS_2_VALUE);
		_82List.add(JCZQ_JQS_3_VALUE);
		_82List.add(JCZQ_JQS_4_VALUE);
		_82List.add(JCZQ_JQS_5_VALUE);
		_82List.add(JCZQ_JQS_6_VALUE);
		_82List.add(JCZQ_JQS_7_VALUE);
		lotteryConstantMap.put(LotteryType.JCZQ_JQS, _82List);
		
		List<String> _83List = new ArrayList<String>();
		_83List.add(JCZQ_BQC_SS_VALUE);
		_83List.add(JCZQ_BQC_SP_VALUE);
		_83List.add(JCZQ_BQC_SF_VALUE);
        _83List.add(JCZQ_BQC_PS_VALUE);
		_83List.add(JCZQ_BQC_PP_VALUE);
		_83List.add(JCZQ_BQC_PF_VALUE);
        _83List.add(JCZQ_BQC_FS_VALUE);
		_83List.add(JCZQ_BQC_FP_VALUE);
		_83List.add(JCZQ_BQC_FF_VALUE);
		lotteryConstantMap.put(LotteryType.JCZQ_BQC, _83List);
	}
	
	public static List<String> getLotteryConstantList(LotteryType lotteryType) {
		return lotteryConstantMap.get(lotteryType);
	}
}
