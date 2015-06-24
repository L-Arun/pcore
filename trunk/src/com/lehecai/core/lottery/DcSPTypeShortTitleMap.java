/**
 * 
 */
package com.lehecai.core.lottery;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 单场SP类型值对应英文缩写映射
 * @author leiming
 *
 */
public class DcSPTypeShortTitleMap {

	private static final Logger logger = LoggerFactory.getLogger(DcSPTypeShortTitleMap.class.getName());
	
	private static Map<DcSPType,String> shortTitleMap = new HashMap<DcSPType,String>();
	
	static{
		//单场胜负平
		shortTitleMap.put(DcSPType.SFP_S, "s");
		shortTitleMap.put(DcSPType.SFP_F, "f");
		shortTitleMap.put(DcSPType.SFP_P, "p");
		
		//单场上下单双
		shortTitleMap.put(DcSPType.SXDS_SD, "sd");
		shortTitleMap.put(DcSPType.SXDS_SS, "ss");
		shortTitleMap.put(DcSPType.SXDS_XD, "xd");
		shortTitleMap.put(DcSPType.SXDS_XS, "xs");
		
		//单场进球数
		shortTitleMap.put(DcSPType.JQS_0, "jqx0");
		shortTitleMap.put(DcSPType.JQS_1, "jqx1");
		shortTitleMap.put(DcSPType.JQS_2, "jqx2");
		shortTitleMap.put(DcSPType.JQS_3, "jqx3");
		shortTitleMap.put(DcSPType.JQS_4, "jqx4");
		shortTitleMap.put(DcSPType.JQS_5, "jqx5");
		shortTitleMap.put(DcSPType.JQS_6, "jqx6");
		shortTitleMap.put(DcSPType.JQS_7, "jqx7");
		
		//单场比分-胜
		shortTitleMap.put(DcSPType.BF_S_10, "bfs10");
		shortTitleMap.put(DcSPType.BF_S_20, "bfs20");
		shortTitleMap.put(DcSPType.BF_S_21, "bfs21");
		shortTitleMap.put(DcSPType.BF_S_30, "bfs30");
		shortTitleMap.put(DcSPType.BF_S_31, "bfs31");
		shortTitleMap.put(DcSPType.BF_S_32, "bfs32");
		shortTitleMap.put(DcSPType.BF_S_40, "bfs40");
		shortTitleMap.put(DcSPType.BF_S_41, "bfs41");
		shortTitleMap.put(DcSPType.BF_S_42, "bfs42");
		shortTitleMap.put(DcSPType.BF_S_Other, "bfsother");
		
		//单场比分-平
		shortTitleMap.put(DcSPType.BF_P_0, "bfp0");
		shortTitleMap.put(DcSPType.BF_P_1, "bfp1");
		shortTitleMap.put(DcSPType.BF_P_2, "bfp2");
		shortTitleMap.put(DcSPType.BF_P_3, "bfp3");
		shortTitleMap.put(DcSPType.BF_P_Other, "bfpother");
		
		//单场比分-负
		shortTitleMap.put(DcSPType.BF_F_01, "bff01");
		shortTitleMap.put(DcSPType.BF_F_02, "bff02");
		shortTitleMap.put(DcSPType.BF_F_12, "bff12");
		shortTitleMap.put(DcSPType.BF_F_03, "bff03");
		shortTitleMap.put(DcSPType.BF_F_13, "bff13");
		shortTitleMap.put(DcSPType.BF_F_23, "bff23");
		shortTitleMap.put(DcSPType.BF_F_04, "bff04");
		shortTitleMap.put(DcSPType.BF_F_14, "bff14");
		shortTitleMap.put(DcSPType.BF_F_24, "bff24");
		shortTitleMap.put(DcSPType.BF_F_Other, "bffother");
		
		//单场半场胜负平
		shortTitleMap.put(DcSPType.BCSFP_SS, "bcss");
		shortTitleMap.put(DcSPType.BCSFP_SP, "bcsp");
		shortTitleMap.put(DcSPType.BCSFP_SF, "bcsf");
		shortTitleMap.put(DcSPType.BCSFP_PS, "bcps");
		shortTitleMap.put(DcSPType.BCSFP_PP, "bcpp");
		shortTitleMap.put(DcSPType.BCSFP_PF, "bcpf");
		shortTitleMap.put(DcSPType.BCSFP_FS, "bcfs");
		shortTitleMap.put(DcSPType.BCSFP_FP, "bcfp");
		shortTitleMap.put(DcSPType.BCSFP_FF, "bcff");
		
	}
	/**
	 * 根据单场Sp类型获取对应缩写
	 * @param dcSPType
	 * @return
	 */
	public static String getShortTitleOfDcSPType(DcSPType dcSPType){
		if(dcSPType == null){
			return null;
		}
		String shortTitle = shortTitleMap.get(dcSPType);
		if(shortTitle == null){
			logger.error("{}未配置单场Sp缩写映射",dcSPType.getName());
		}
		return shortTitle;
	}
}
