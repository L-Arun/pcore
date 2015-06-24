package com.lehecai.core.lottery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;


public class PlayType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PlayType.class.getName());
	
	private static Map<LotteryType, List<PlayType>> lotteryItems = new HashMap<LotteryType, List<PlayType>>(64);
	
	private LotteryType lotteryType;

	protected PlayType(String name, int value, LotteryType lotteryType) {
		super(PlayType.class.getName(), name, value);
		
		if (lotteryType != null) {
			this.lotteryType = lotteryType;
			
			List<PlayType> list = lotteryItems.get(lotteryType);
			if (list == null) {
				list = new ArrayList<PlayType>();
				list.add(PlayType.ALL);		//每一个彩种的集合都添加ALL，供查询使用
				lotteryItems.put(lotteryType, list);
			}
			list.add(this);
		}
	}
	
	public LotteryType getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public static List<PlayType> getItemsByLotteryType(LotteryType lotteryType) {
		return lotteryItems.get(lotteryType);
	}
	
	public static PlayType getItem(int value){
		try {
			return (PlayType)PlayType.getResult(PlayType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static final PlayType ALL = new PlayType("全部", -1, null);
	
	public static final PlayType DEFAULT = new PlayType("默认", 0, null);
	
	// 1-99预留为彩种无关的特殊玩法
	public static final PlayType UPLOAD_LATER = new PlayType("发起后上传", 1, null);
	
	
	public static final PlayType SSQ_HH = new PlayType("双色球混合", 5000, LotteryType.SSQ);
	
	public static final PlayType SSQ_DS = new PlayType("双色球单式", 5001, LotteryType.SSQ);
	
	public static final PlayType SSQ_FS = new PlayType("双色球复式", 5002, LotteryType.SSQ);
	
	public static final PlayType SSQ_DT = new PlayType("双色球胆拖", 5003, LotteryType.SSQ);
	
	
	public static final PlayType DLT_HH = new PlayType("大乐透混合", 100, LotteryType.DLT);	
	
	public static final PlayType DLT_DS = new PlayType("大乐透单式", 101, LotteryType.DLT);
	
	public static final PlayType DLT_FS = new PlayType("大乐透复式", 102, LotteryType.DLT);
	
	public static final PlayType DLT_DT = new PlayType("大乐透胆拖", 103, LotteryType.DLT);
	
	public static final PlayType DLT_XYC_DS = new PlayType("大乐透幸运彩单式", 104, LotteryType.DLT);
	
	public static final PlayType DLT_XYC_FS = new PlayType("大乐透幸运彩复式", 105, LotteryType.DLT);
	
	public static final PlayType DLT_XYC_DT = new PlayType("大乐透幸运彩胆拖", 106, LotteryType.DLT);
	
	public static final PlayType PL3_HH = new PlayType("排列三混合", 300, LotteryType.PL3);
	
	public static final PlayType PL3_FS = new PlayType("排列三复式", 301, LotteryType.PL3);
	
	public static final PlayType PL3_ZXDS = new PlayType("排列三直选单式", 302, LotteryType.PL3);
	
	public static final PlayType PL3_Z3DS = new PlayType("排列三组三单式", 303, LotteryType.PL3);
	
	public static final PlayType PL3_Z6DS = new PlayType("排列三组六单式", 304, LotteryType.PL3);
	
	public static final PlayType PL3_Z6DT = new PlayType("排列三组六胆拖", 305, LotteryType.PL3);

	public static final PlayType PL3_Z3HZ = new PlayType("排列三组三和值", 306, LotteryType.PL3);
	
	public static final PlayType PL3_Z6HZ = new PlayType("排列三组六和值", 307, LotteryType.PL3);
	
	public static final PlayType PL3_Z3BH = new PlayType("排列三组三包号", 308, LotteryType.PL3);
	
	public static final PlayType PL3_Z6BH = new PlayType("排列三组六包号", 309, LotteryType.PL3);
	
	public static final PlayType PL5_HH = new PlayType("排列五混合", 400, LotteryType.PL5);
	
	public static final PlayType PL5_DS = new PlayType("排列五单式", 401, LotteryType.PL5);	
	
	public static final PlayType PL5_FS = new PlayType("排列五复式", 402, LotteryType.PL5);
	
	public static final PlayType QXC_HH = new PlayType("混合", 200, LotteryType.QXC);
	
	public static final PlayType QXC_DS = new PlayType("单式", 201, LotteryType.QXC);
	
	public static final PlayType QXC_FS = new PlayType("复式", 202, LotteryType.QXC);
	
	public static final PlayType TC22X5_HH = new PlayType("22选5混合", 500, LotteryType.TC22X5);
	
	public static final PlayType TC22X5_DS = new PlayType("22选5单式", 501, LotteryType.TC22X5);
	
	public static final PlayType TC22X5_FS = new PlayType("22选5复式", 502, LotteryType.TC22X5);
	
	public static final PlayType TC22X5_DT = new PlayType("22选5胆拖", 503, LotteryType.TC22X5);
	
	public static final PlayType QLC_HH = new PlayType("七乐彩混合", 5100, LotteryType.QLC);
	
	public static final PlayType QLC_DS = new PlayType("七乐彩单式", 5101, LotteryType.QLC);
	
	public static final PlayType QLC_FS = new PlayType("七乐彩复式", 5102, LotteryType.QLC);

	public static final PlayType QLC_DT = new PlayType("七乐彩胆拖", 5103, LotteryType.QLC); 
	
	public static final PlayType FC3D_HH = new PlayType("福彩3D混合", 5200, LotteryType.FC3D);

	public static final PlayType FC3D_ZXDS = new PlayType("福彩3D直选单式", 5201, LotteryType.FC3D);
	
	public static final PlayType FC3D_ZXFS = new PlayType("福彩3D直选复式", 5202, LotteryType.FC3D);
	
	public static final PlayType FC3D_DSZX = new PlayType("福彩3D单式组选", 5203, LotteryType.FC3D);
	
	public static final PlayType FC3D_Z3DS = new PlayType("福彩3D组三单式", 5204, LotteryType.FC3D);
	
	public static final PlayType FC3D_Z3HZ = new PlayType("福彩3D组三和值", 5205, LotteryType.FC3D);
	
	public static final PlayType FC3D_Z3BH = new PlayType("福彩3D组三包号", 5206, LotteryType.FC3D);
	
	public static final PlayType FC3D_Z6DS = new PlayType("福彩3D组六单式", 5207, LotteryType.FC3D);
	
	public static final PlayType FC3D_Z6DT = new PlayType("福彩3D组六胆拖", 5208, LotteryType.FC3D);
	
	public static final PlayType FC3D_Z6HZ = new PlayType("福彩3D组六和值", 5209, LotteryType.FC3D);
	
	public static final PlayType FC3D_Z6BH = new PlayType("福彩3D组六包号", 5210, LotteryType.FC3D);

	public static final PlayType DF6J1_HH = new PlayType("东方6+1混合", 5400, LotteryType.DF6J1);
	
	public static final PlayType DF6J1_DS = new PlayType("东方6+1单式", 5401, LotteryType.DF6J1);
	
	public static final PlayType DF6J1_FS = new PlayType("东方6+1复式", 5402, LotteryType.DF6J1);
	
	public static final PlayType HD15X5_HH = new PlayType("华东15选5混合", 5500, LotteryType.HD15X5);
	
	public static final PlayType HD15X5_DS = new PlayType("华东15选5单式", 5501, LotteryType.HD15X5);
	
	public static final PlayType HD15X5_FS = new PlayType("华东15选5复式", 5502, LotteryType.HD15X5);
	
	public static final PlayType HD15X5_DT = new PlayType("华东15选5胆拖", 5503, LotteryType.HD15X5);
	
	public static final PlayType CQSSC_HH = new PlayType("重庆时时彩混合", 20000, LotteryType.CQSSC);
	
	public static final PlayType CQSSC_DSDXDS = new PlayType("单式大小单双", 20001, LotteryType.CQSSC);
	
	public static final PlayType CQSSC_FSDXDS = new PlayType("复式大小单双", 20002, LotteryType.CQSSC);
	
	public static final PlayType CQSSC_FS = new PlayType("复式", 20003, LotteryType.CQSSC);
	
	public static final PlayType CQSSC_YXDS = new PlayType("一星单式", 20004, LotteryType.CQSSC);
	
	public static final PlayType CQSSC_YXFS = new PlayType("一星复式", 20005, LotteryType.CQSSC);
	
	public static final PlayType CQSSC_LXDS = new PlayType("两星单式", 20006, LotteryType.CQSSC);
	
	public static final PlayType CQSSC_LXFS = new PlayType("两星复式", 20007, LotteryType.CQSSC);
	
	public static final PlayType CQSSC_EXBHDS = new PlayType("二星包号单式", 20008, LotteryType.CQSSC);
	
	public static final PlayType CQSSC_EXBHFS = new PlayType("二星包号复式", 20009, LotteryType.CQSSC);
	
	public static final PlayType CQSSC_EXHZ = new PlayType("二星和值", 20010, LotteryType.CQSSC);
	
	public static final PlayType CQSSC_SXDS = new PlayType("三星单式", 20011, LotteryType.CQSSC);
	
	public static final PlayType CQSSC_SXFS = new PlayType("三星复式", 20012, LotteryType.CQSSC);
	
	public static final PlayType CQSSC_SXHZ = new PlayType("三星和值", 20013, LotteryType.CQSSC);
	
	public static final PlayType CQSSC_Z3BH = new PlayType("组三包号", 20014, LotteryType.CQSSC);
	
	public static final PlayType CQSSC_WXFS = new PlayType("五星复式", 20015, LotteryType.CQSSC);
	
	public static final PlayType CQSSC_Z6DS = new PlayType("组六单式", 20016, LotteryType.CQSSC);
	
	public static final PlayType CQSSC_Z6BH = new PlayType("组六包号", 20017, LotteryType.CQSSC);
	
	public static final PlayType CQSSC_WXDS = new PlayType("五星单式", 20018, LotteryType.CQSSC);	
	
	public static final PlayType CQSSC_WXTXDS = new PlayType("五星通选单式", 20019, LotteryType.CQSSC);	
	
	public static final PlayType CQSSC_Z3DS = new PlayType("组三单式", 20020, LotteryType.CQSSC);	

	public static final PlayType CQSSC_WXTXFS = new PlayType("五星通选复式", 20021, LotteryType.CQSSC);	
	
	
	public static final PlayType JXSSC_HH = new PlayType("混合", 20200,LotteryType.JXSSC);
	public static final PlayType JXSSC_WXDS = new PlayType("五星单式", 20201,LotteryType.JXSSC);
	public static final PlayType JXSSC_WXFS = new PlayType("五星复式", 20202,LotteryType.JXSSC);
	public static final PlayType JXSSC_SIXDS = new PlayType("四星单式", 20203,LotteryType.JXSSC);
	public static final PlayType JXSSC_SIXFS = new PlayType("四星复式", 20204,LotteryType.JXSSC);	
	public static final PlayType JXSSC_SXDS = new PlayType("三星单式", 20205,LotteryType.JXSSC);
	public static final PlayType JXSSC_SXFS = new PlayType("三星复式", 20206,LotteryType.JXSSC);
	public static final PlayType JXSSC_LXDS = new PlayType("两星单式", 20207,LotteryType.JXSSC);
	public static final PlayType JXSSC_LXFS = new PlayType("两星复式", 20208,LotteryType.JXSSC);
	public static final PlayType JXSSC_YXDS = new PlayType("一星单式", 20209,LotteryType.JXSSC);
	public static final PlayType JXSSC_YXFS = new PlayType("一星复式", 20210,LotteryType.JXSSC);	

	public static final PlayType JXSSC_WXFX = new PlayType("五星复选", 20211,LotteryType.JXSSC);
	public static final PlayType JXSSC_SIXFX = new PlayType("四星复选", 20212,LotteryType.JXSSC);
	public static final PlayType JXSSC_SXFX = new PlayType("三星复选", 20213,LotteryType.JXSSC);
	public static final PlayType JXSSC_EXFX = new PlayType("二星复选", 20214,LotteryType.JXSSC);
	
	public static final PlayType JXSSC_WXTXDS = new PlayType("五星通选单式", 20215,LotteryType.JXSSC);
	public static final PlayType JXSSC_WXTXFS = new PlayType("五星通选复式", 20216,LotteryType.JXSSC);
	public static final PlayType JXSSC_SXHZ = new PlayType("三星和值", 20217,LotteryType.JXSSC);
	public static final PlayType JXSSC_Z3BH = new PlayType("组三包号", 20218,LotteryType.JXSSC);
	public static final PlayType JXSSC_Z6BH = new PlayType("组六包号", 20219,LotteryType.JXSSC);
	public static final PlayType JXSSC_EXHZ = new PlayType("二星和值", 20220,LotteryType.JXSSC);
	public static final PlayType JXSSC_EXBHDS = new PlayType("二星包号单式", 20221,LotteryType.JXSSC);
	public static final PlayType JXSSC_EXBHFS = new PlayType("二星包号复式", 20222,LotteryType.JXSSC);
	public static final PlayType JXSSC_DSDXDS = new PlayType("单式大小单双", 20223,LotteryType.JXSSC);
	public static final PlayType JXSSC_FSDXDS = new PlayType("复式大小单双", 20224,LotteryType.JXSSC);
	public static final PlayType JXSSC_R1DS = new PlayType("任选1单式", 20225,LotteryType.JXSSC);
	public static final PlayType JXSSC_R1FS = new PlayType("任选1复式", 20226,LotteryType.JXSSC);
	public static final PlayType JXSSC_R2DS = new PlayType("任选2单式", 20227,LotteryType.JXSSC);
	public static final PlayType JXSSC_R2FS = new PlayType("任选2复式", 20228,LotteryType.JXSSC);
	public static final PlayType JXSSC_Z3DS = new PlayType("组三单式", 20229,LotteryType.JXSSC);
	public static final PlayType JXSSC_Z6DS = new PlayType("组六单式", 20230,LotteryType.JXSSC);	
	
	public static final PlayType SHSSL_HH = new PlayType("时时乐混合", 20100, LotteryType.SHSSL);
	public static final PlayType SHSSL_ZXDS = new PlayType("时时乐直选单式", 20101, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_ZXFS = new PlayType("时时乐直选复式", 20102, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_ZXBHDS1 = new PlayType("时时乐直选包号不过滤", 20103, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_ZXBHDS2 = new PlayType("时时乐直选包号过滤豹子号", 20104, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_ZXBHDS3 = new PlayType("时时乐直选包号过滤组三号", 20105, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_ZXBHDS4 = new PlayType("时时乐直选包号过滤组三号和豹子号", 20106, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_ZXHZ = new PlayType("时时乐直选和值", 20107, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_ZXDT = new PlayType("时时乐直选胆拖", 20108, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_Z3DS = new PlayType("时时乐组三单式", 20109, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_Z3FS = new PlayType("时时乐组三复式", 20110, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_Z3BH = new PlayType("时时乐组三包号", 20111, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_Z3HZ = new PlayType("时时乐组三和值", 20112, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_Z3DT = new PlayType("时时乐组三胆拖", 20113, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_Z6DS = new PlayType("时时乐组六单式", 20114, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_Z6FS = new PlayType("时时乐组六复式", 20115, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_Z6BH = new PlayType("时时乐组六包号", 20116, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_Z6HZ = new PlayType("时时乐组六和值", 20117, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_Z6DT = new PlayType("时时乐组六胆拖", 20118, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_Q2DS = new PlayType("时时乐前二单式", 20119, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_Q2FS = new PlayType("时时乐前二复式", 20120, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_H2DS = new PlayType("时时乐后二单式", 20121, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_H2FS = new PlayType("时时乐后二复式", 20122, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_Q1DS = new PlayType("时时乐前一单式", 20123, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_Q1FS = new PlayType("时时乐前一复式", 20124, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_H1DS = new PlayType("时时乐后一单式", 20125, LotteryType.SHSSL);
	
	public static final PlayType SHSSL_H1FS = new PlayType("时时乐后一复式", 20126, LotteryType.SHSSL);
	
	public static final PlayType SD11X5_HH = new PlayType("混合", 2000, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R1_BZ_DS = new PlayType("前1标准单式", 2001, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R1_BZ_FS = new PlayType("前1标准复式", 2002, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R2_BZ_DS = new PlayType("任选2标准单式", 2003, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R2_BZ_FS = new PlayType("任选2标准复式", 2004, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R3_BZ_DS = new PlayType("任选3标准单式", 2005, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R3_BZ_FS = new PlayType("任选3标准复式", 2006, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R4_BZ_DS = new PlayType("任选4标准单式", 2007, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R4_BZ_FS = new PlayType("任选4标准复式", 2008, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R5_BZ_DS = new PlayType("任选5标准单式", 2009, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R5_BZ_FS = new PlayType("任选5标准复式", 2010, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R6_BZ_DS = new PlayType("任选6标准单式", 2011, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R6_BZ_FS = new PlayType("任选6标准复式", 2012, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R7_BZ_DS = new PlayType("任选7标准单式", 2013, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R7_BZ_FS = new PlayType("任选7标准复式", 2014, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R8_BZ_DS = new PlayType("任选8标准单式", 2015, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R8_BZ_FS = new PlayType("任选8标准复式", 2016, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R2_DT = new PlayType("任选2胆拖", 2017, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R3_DT = new PlayType("任选3胆拖", 2018, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R4_DT = new PlayType("任选4胆拖", 2019, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R5_DT = new PlayType("任选5胆拖", 2020, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R6_DT = new PlayType("任选6胆拖", 2021, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R7_DT = new PlayType("任选7胆拖", 2022, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_R8_DT = new PlayType("任选8胆拖", 2023, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_Q2_DS = new PlayType("前2直选单式", 2024, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_Q2_FS = new PlayType("前2直选复式", 2025, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_Q2ZX_DS = new PlayType("前2组选单式", 2026, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_Q2ZX_FS = new PlayType("前2组选复式", 2027, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_Q3_DS = new PlayType("前3直选单式", 2028, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_Q3_FS = new PlayType("前3直选复式", 2029, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_Q3ZX_DS = new PlayType("前3组选单式", 2030, LotteryType.SD11X5);
	
	public static final PlayType SD11X5_Q3ZX_FS = new PlayType("前3组选复式", 2031, LotteryType.SD11X5);
	
    public static final PlayType GD11X5_HH = new PlayType("混合", 2300, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R1_BZ_DS = new PlayType("前1标准单式", 2301, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R1_BZ_FS = new PlayType("前1标准复式", 2302, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R2_BZ_DS = new PlayType("任选2标准单式", 2303, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R2_BZ_FS = new PlayType("任选2标准复式", 2304, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R3_BZ_DS = new PlayType("任选3标准单式", 2305, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R3_BZ_FS = new PlayType("任选3标准复式", 2306, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R4_BZ_DS = new PlayType("任选4标准单式", 2307, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R4_BZ_FS = new PlayType("任选4标准复式", 2308, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R5_BZ_DS = new PlayType("任选5标准单式", 2309, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R5_BZ_FS = new PlayType("任选5标准复式", 2310, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R6_BZ_DS = new PlayType("任选6标准单式", 2311, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R6_BZ_FS = new PlayType("任选6标准复式", 2312, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R7_BZ_DS = new PlayType("任选7标准单式", 2313, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R7_BZ_FS = new PlayType("任选7标准复式", 2314, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R8_BZ_DS = new PlayType("任选8标准单式", 2315, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R8_BZ_FS = new PlayType("任选8标准复式", 2316, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R2_DT = new PlayType("任选2胆拖", 2317, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R3_DT = new PlayType("任选3胆拖", 2318, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R4_DT = new PlayType("任选4胆拖", 2319, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R5_DT = new PlayType("任选5胆拖", 2320, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R6_DT = new PlayType("任选6胆拖", 2321, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R7_DT = new PlayType("任选7胆拖", 2322, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_R8_DT = new PlayType("任选8胆拖", 2323, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_Q2_DS = new PlayType("前2直选单式", 2324, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_Q2_FS = new PlayType("前2直选复式", 2325, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_Q2ZX_DS = new PlayType("前2组选单式", 2326, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_Q2ZX_FS = new PlayType("前2组选复式", 2327, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_Q3_DS = new PlayType("前3直选单式", 2328, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_Q3_FS = new PlayType("前3直选复式", 2329, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_Q3ZX_DS = new PlayType("前3组选单式", 2330, LotteryType.GD11X5);
	
	public static final PlayType GD11X5_Q3ZX_FS = new PlayType("前3组选复式", 2331, LotteryType.GD11X5);

	public static final PlayType GDKL10_HH = new PlayType("广东快乐十分混合", 54400, LotteryType.GDKL10);
	public static final PlayType GDKL10_X1_ST_DS = new PlayType("选1数投单式", 54401, LotteryType.GDKL10);
	public static final PlayType GDKL10_X1_ST_FS = new PlayType("选1数投复式", 54402, LotteryType.GDKL10);
	public static final PlayType GDKL10_X1_HT_DS = new PlayType("选1红投单式", 54403, LotteryType.GDKL10);
	public static final PlayType GDKL10_X1_HT_FS = new PlayType("选1红投复式", 54404, LotteryType.GDKL10);
	public static final PlayType GDKL10_R2_DS = new PlayType("任选2单式", 54405, LotteryType.GDKL10);
	public static final PlayType GDKL10_R2_FS = new PlayType("任选2复式", 54406, LotteryType.GDKL10);
	public static final PlayType GDKL10_R2_DT = new PlayType("任选2胆拖", 54407, LotteryType.GDKL10);
	public static final PlayType GDKL10_X2_LZU_DS = new PlayType("选2连组单式", 54408, LotteryType.GDKL10);
	public static final PlayType GDKL10_X2_LZU_FS = new PlayType("选2连组复式", 54409, LotteryType.GDKL10);
	public static final PlayType GDKL10_X2_LZU_DT = new PlayType("选2连组胆拖", 54410, LotteryType.GDKL10);
	public static final PlayType GDKL10_X2_LZHI_DS = new PlayType("选2连直单式", 54411, LotteryType.GDKL10);
	public static final PlayType GDKL10_X2_LZHI_FS = new PlayType("选2连直复式", 54412, LotteryType.GDKL10);
	public static final PlayType GDKL10_R3_DS = new PlayType("任选3单式", 54413, LotteryType.GDKL10);
	public static final PlayType GDKL10_R3_FS = new PlayType("任选3复式", 54414, LotteryType.GDKL10);
	public static final PlayType GDKL10_R3_DT = new PlayType("任选3胆拖", 54415, LotteryType.GDKL10);
	public static final PlayType GDKL10_X3_QZU_DS = new PlayType("选3前组单式", 54416, LotteryType.GDKL10);
	public static final PlayType GDKL10_X3_QZU_FS = new PlayType("选3前组复式", 54417, LotteryType.GDKL10);
	public static final PlayType GDKL10_X3_QZU_DT = new PlayType("选3前组胆拖", 54418, LotteryType.GDKL10);
	public static final PlayType GDKL10_X3_QZHI_DS = new PlayType("选3前直单式", 54419, LotteryType.GDKL10);
	public static final PlayType GDKL10_X3_QZHI_FS = new PlayType("选3前直复式", 54420, LotteryType.GDKL10);
	public static final PlayType GDKL10_R4_DS = new PlayType("任选4单式", 54421, LotteryType.GDKL10);
	public static final PlayType GDKL10_R4_FS = new PlayType("任选4复式", 54422, LotteryType.GDKL10);
	public static final PlayType GDKL10_R4_DT = new PlayType("任选4胆拖", 54423, LotteryType.GDKL10);
	public static final PlayType GDKL10_R5_DS = new PlayType("任选5单式", 54424, LotteryType.GDKL10);
	public static final PlayType GDKL10_R5_FS = new PlayType("任选5复式", 54425, LotteryType.GDKL10);
	public static final PlayType GDKL10_R5_DT = new PlayType("任选5胆拖", 54426, LotteryType.GDKL10);
	
	public static final PlayType HNKL10_HH = new PlayType("湖南快乐十分混合", 55600, LotteryType.HNKL10);
	public static final PlayType HNKL10_X1_ST_DS = new PlayType("选1数投单式", 55601, LotteryType.HNKL10);
	public static final PlayType HNKL10_X1_ST_FS = new PlayType("选1数投复式", 55602, LotteryType.HNKL10);
	public static final PlayType HNKL10_X1_HT_DS = new PlayType("选1红投单式", 55603, LotteryType.HNKL10);
	public static final PlayType HNKL10_X1_HT_FS = new PlayType("选1红投复式", 55604, LotteryType.HNKL10);
	public static final PlayType HNKL10_R2_DS = new PlayType("任选2单式", 55605, LotteryType.HNKL10);
	public static final PlayType HNKL10_R2_FS = new PlayType("任选2复式", 55606, LotteryType.HNKL10);
	public static final PlayType HNKL10_R2_DT = new PlayType("任选2胆拖", 55607, LotteryType.HNKL10);
	public static final PlayType HNKL10_X2_LZU_DS = new PlayType("选2连组单式", 55608, LotteryType.HNKL10);
	public static final PlayType HNKL10_X2_LZU_FS = new PlayType("选2连组复式", 55609, LotteryType.HNKL10);
	public static final PlayType HNKL10_X2_LZU_DT = new PlayType("选2连组胆拖", 55610, LotteryType.HNKL10);
	public static final PlayType HNKL10_X2_LZHI_DS = new PlayType("选2连直单式", 55611, LotteryType.HNKL10);
	public static final PlayType HNKL10_X2_LZHI_FS = new PlayType("选2连直复式", 55612, LotteryType.HNKL10);
	public static final PlayType HNKL10_R3_DS = new PlayType("任选3单式", 55613, LotteryType.HNKL10);
	public static final PlayType HNKL10_R3_FS = new PlayType("任选3复式", 55614, LotteryType.HNKL10);
	public static final PlayType HNKL10_R3_DT = new PlayType("任选3胆拖", 55615, LotteryType.HNKL10);
	public static final PlayType HNKL10_X3_QZU_DS = new PlayType("选3前组单式", 55616, LotteryType.HNKL10);
	public static final PlayType HNKL10_X3_QZU_FS = new PlayType("选3前组复式", 55617, LotteryType.HNKL10);
	public static final PlayType HNKL10_X3_QZU_DT = new PlayType("选3前组胆拖", 55618, LotteryType.HNKL10);
	public static final PlayType HNKL10_X3_QZHI_DS = new PlayType("选3前直单式", 55619, LotteryType.HNKL10);
	public static final PlayType HNKL10_X3_QZHI_FS = new PlayType("选3前直复式", 55620, LotteryType.HNKL10);
	public static final PlayType HNKL10_R4_DS = new PlayType("任选4单式", 55621, LotteryType.HNKL10);
	public static final PlayType HNKL10_R4_FS = new PlayType("任选4复式", 55622, LotteryType.HNKL10);
	public static final PlayType HNKL10_R4_DT = new PlayType("任选4胆拖", 55623, LotteryType.HNKL10);
	public static final PlayType HNKL10_R5_DS = new PlayType("任选5单式", 55624, LotteryType.HNKL10);
	public static final PlayType HNKL10_R5_FS = new PlayType("任选5复式", 55625, LotteryType.HNKL10);
	public static final PlayType HNKL10_R5_DT = new PlayType("任选5胆拖", 55626, LotteryType.HNKL10);
	
	public static final PlayType GXKL10_HH = new PlayType("广西快乐十分混合", 54500, LotteryType.GXKL10);
	public static final PlayType GXKL10_ZHIX_T_DS = new PlayType("直选好运特单式", 54501, LotteryType.GXKL10);
	public static final PlayType GXKL10_ZHIX_T_FS = new PlayType("直选好运特复式", 54502, LotteryType.GXKL10);
	public static final PlayType GXKL10_ZHIX1_DS = new PlayType("直选好运一单式", 54503, LotteryType.GXKL10);
	public static final PlayType GXKL10_ZHIX1_FS = new PlayType("直选好运一复式", 54504, LotteryType.GXKL10);
	public static final PlayType GXKL10_ZHIX2_DS = new PlayType("直选好运二单式", 54505, LotteryType.GXKL10);
	public static final PlayType GXKL10_ZHIX2_FS = new PlayType("直选好运二复式", 54506, LotteryType.GXKL10);
	public static final PlayType GXKL10_ZHIX2_DT = new PlayType("直选好运二胆拖", 54507, LotteryType.GXKL10);
	public static final PlayType GXKL10_ZHIX3_DS = new PlayType("直选好运三单式", 54508, LotteryType.GXKL10);
	public static final PlayType GXKL10_ZHIX3_FS = new PlayType("直选好运三复式", 54509, LotteryType.GXKL10);
	public static final PlayType GXKL10_ZHIX3_DT = new PlayType("直选好运三胆拖", 54510, LotteryType.GXKL10);
	public static final PlayType GXKL10_ZHIX4_DS = new PlayType("直选好运四单式", 54511, LotteryType.GXKL10);
	public static final PlayType GXKL10_ZHIX4_FS = new PlayType("直选好运四复式", 54512, LotteryType.GXKL10);
	public static final PlayType GXKL10_ZHIX4_DT = new PlayType("直选好运四胆拖", 54513, LotteryType.GXKL10);
	public static final PlayType GXKL10_ZHIX5_DS = new PlayType("直选好运五单式", 54514, LotteryType.GXKL10);
	public static final PlayType GXKL10_ZHIX5_FS = new PlayType("直选好运五复式", 54515, LotteryType.GXKL10);
	public static final PlayType GXKL10_ZHIX5_DT = new PlayType("直选好运五胆拖", 54516, LotteryType.GXKL10);
	public static final PlayType GXKL10_TONGX3_DS = new PlayType("通选好运三单式", 54517, LotteryType.GXKL10);
	public static final PlayType GXKL10_TONGX3_FS = new PlayType("通选好运三复式", 54518, LotteryType.GXKL10);
	public static final PlayType GXKL10_TONGX3_DT = new PlayType("通选好运三胆拖", 54519, LotteryType.GXKL10);
	public static final PlayType GXKL10_TONGX4_DS = new PlayType("通选好运四单式", 54520, LotteryType.GXKL10);
	public static final PlayType GXKL10_TONGX4_FS = new PlayType("通选好运四复式", 54521, LotteryType.GXKL10);
	public static final PlayType GXKL10_TONGX4_DT = new PlayType("通选好运四胆拖", 54522, LotteryType.GXKL10);
	public static final PlayType GXKL10_TONGX5_DS = new PlayType("通选好运五单式", 54523, LotteryType.GXKL10);
	public static final PlayType GXKL10_TONGX5_FS = new PlayType("通选好运五复式", 54524, LotteryType.GXKL10);
	public static final PlayType GXKL10_TONGX5_DT = new PlayType("通选好运五胆拖", 54525, LotteryType.GXKL10);
	
	public static final PlayType BJKL8_HH = new PlayType("北京快乐8混合", 54300, LotteryType.BJKL8);
	public static final PlayType BJKL8_R1_DS = new PlayType("北京快乐8任选1单式", 54301, LotteryType.BJKL8);
	public static final PlayType BJKL8_R1_FS = new PlayType("北京快乐8任选1复式", 54302, LotteryType.BJKL8);
	public static final PlayType BJKL8_R2_DS = new PlayType("北京快乐8任选2单式", 54303, LotteryType.BJKL8);
	public static final PlayType BJKL8_R2_FS = new PlayType("北京快乐8任选2复式", 54304, LotteryType.BJKL8);
	public static final PlayType BJKL8_R3_DS = new PlayType("北京快乐8任选3单式", 54305, LotteryType.BJKL8);
	public static final PlayType BJKL8_R3_FS = new PlayType("北京快乐8任选3复式", 54306, LotteryType.BJKL8);
	public static final PlayType BJKL8_R4_DS = new PlayType("北京快乐8任选4单式", 54307, LotteryType.BJKL8);
	public static final PlayType BJKL8_R4_FS = new PlayType("北京快乐8任选4复式", 54308, LotteryType.BJKL8);
	public static final PlayType BJKL8_R5_DS = new PlayType("北京快乐8任选5单式", 54309, LotteryType.BJKL8);
	public static final PlayType BJKL8_R5_FS = new PlayType("北京快乐8任选5复式", 54310, LotteryType.BJKL8);
	public static final PlayType BJKL8_R6_DS = new PlayType("北京快乐8任选6单式", 54311, LotteryType.BJKL8);
	public static final PlayType BJKL8_R6_FS = new PlayType("北京快乐8任选6复式", 54312, LotteryType.BJKL8);
	public static final PlayType BJKL8_R7_DS = new PlayType("北京快乐8任选7单式", 54313, LotteryType.BJKL8);
	public static final PlayType BJKL8_R7_FS = new PlayType("北京快乐8任选7复式", 54314, LotteryType.BJKL8);
	public static final PlayType BJKL8_R8_DS = new PlayType("北京快乐8任选8单式", 54315, LotteryType.BJKL8);
	public static final PlayType BJKL8_R8_FS = new PlayType("北京快乐8任选8复式", 54316, LotteryType.BJKL8);
	public static final PlayType BJKL8_R9_DS = new PlayType("北京快乐8任选9单式", 54317, LotteryType.BJKL8);
	public static final PlayType BJKL8_R9_FS = new PlayType("北京快乐8任选9复式", 54318, LotteryType.BJKL8);
	public static final PlayType BJKL8_R10_DS = new PlayType("北京快乐8任选10单式", 54319, LotteryType.BJKL8);
	public static final PlayType BJKL8_R10_FS = new PlayType("北京快乐8任选10复式", 54320, LotteryType.BJKL8);
	
	public static final PlayType PK10_HH = new PlayType("PK拾混合", 55700, LotteryType.PK10);
	public static final PlayType PK10_PT_X1_DS = new PlayType("PK拾普通选1单式", 55701, LotteryType.PK10);
	public static final PlayType PK10_PT_X1_FS = new PlayType("PK拾普通选1复式", 55702, LotteryType.PK10);
	public static final PlayType PK10_PT_X2_DS = new PlayType("PK拾普通选2单式", 55703, LotteryType.PK10);
	public static final PlayType PK10_PT_X2_FS = new PlayType("PK拾普通选2复式", 55704, LotteryType.PK10);
	public static final PlayType PK10_PT_X3_DS = new PlayType("PK拾普通选3单式", 55705, LotteryType.PK10);
	public static final PlayType PK10_PT_X3_FS = new PlayType("PK拾普通选3复式", 55706, LotteryType.PK10);
	public static final PlayType PK10_PT_X4_DS = new PlayType("PK拾普通选4单式", 55707, LotteryType.PK10);
	public static final PlayType PK10_PT_X4_FS = new PlayType("PK拾普通选4复式", 55708, LotteryType.PK10);
	public static final PlayType PK10_PT_X5_DS = new PlayType("PK拾普通选5单式", 55709, LotteryType.PK10);
	public static final PlayType PK10_PT_X5_FS = new PlayType("PK拾普通选5复式", 55710, LotteryType.PK10);
	public static final PlayType PK10_PT_X6_DS = new PlayType("PK拾普通选6单式", 55711, LotteryType.PK10);
	public static final PlayType PK10_PT_X6_FS = new PlayType("PK拾普通选6复式", 55712, LotteryType.PK10);
	public static final PlayType PK10_PT_X7_DS = new PlayType("PK拾普通选7单式", 55713, LotteryType.PK10);
	public static final PlayType PK10_PT_X7_FS = new PlayType("PK拾普通选7复式", 55714, LotteryType.PK10);
	public static final PlayType PK10_PT_X8_DS = new PlayType("PK拾普通选8单式", 55715, LotteryType.PK10);
	public static final PlayType PK10_PT_X8_FS = new PlayType("PK拾普通选8复式", 55716, LotteryType.PK10);
	public static final PlayType PK10_PT_X9_DS = new PlayType("PK拾普通选9单式", 55717, LotteryType.PK10);
	public static final PlayType PK10_PT_X9_FS = new PlayType("PK拾普通选9复式", 55718, LotteryType.PK10);
	public static final PlayType PK10_PT_X10_DS = new PlayType("PK拾普通选10单式", 55719, LotteryType.PK10);
	public static final PlayType PK10_PT_X10_FS = new PlayType("PK拾普通选10复式", 55720, LotteryType.PK10);
	public static final PlayType PK10_JQ_X2_DS = new PlayType("PK拾精确选2单式", 55721, LotteryType.PK10);
	public static final PlayType PK10_JQ_X2_FS = new PlayType("PK拾精确选2复式", 55722, LotteryType.PK10);
	public static final PlayType PK10_JQ_X3_DS = new PlayType("PK拾精确选3单式", 55723, LotteryType.PK10);
	public static final PlayType PK10_JQ_X3_FS = new PlayType("PK拾精确选3复式", 55724, LotteryType.PK10);
	public static final PlayType PK10_JQ_X4_DS = new PlayType("PK拾精确选4单式", 55725, LotteryType.PK10);
	public static final PlayType PK10_JQ_X4_FS = new PlayType("PK拾精确选4复式", 55726, LotteryType.PK10);
	
	public static final PlayType SDQYH_HH = new PlayType("山东群英会混合", 51700, LotteryType.SDQYH);
	public static final PlayType SDQYH_R1_DS = new PlayType("山东群英会任选1单式", 51701, LotteryType.SDQYH);
	public static final PlayType SDQYH_R1_FS = new PlayType("山东群英会任选1复式", 51702, LotteryType.SDQYH);
	public static final PlayType SDQYH_R2_DS = new PlayType("山东群英会任选2单式", 51703, LotteryType.SDQYH);
	public static final PlayType SDQYH_R2_FS = new PlayType("山东群英会任选2复式", 51704, LotteryType.SDQYH);
	public static final PlayType SDQYH_R3_DS = new PlayType("山东群英会任选3单式", 51705, LotteryType.SDQYH);
	public static final PlayType SDQYH_R3_FS = new PlayType("山东群英会任选3复式", 51706, LotteryType.SDQYH);
	public static final PlayType SDQYH_R4_DS = new PlayType("山东群英会任选4单式", 51707, LotteryType.SDQYH);
	public static final PlayType SDQYH_R4_FS = new PlayType("山东群英会任选4复式", 51708, LotteryType.SDQYH);
	public static final PlayType SDQYH_R5_DS = new PlayType("山东群英会任选5单式", 51709, LotteryType.SDQYH);
	public static final PlayType SDQYH_R5_FS = new PlayType("山东群英会任选5复式", 51710, LotteryType.SDQYH);
	public static final PlayType SDQYH_R6_DS = new PlayType("山东群英会任选6单式", 51711, LotteryType.SDQYH);
	public static final PlayType SDQYH_R6_FS = new PlayType("山东群英会任选6复式", 51712, LotteryType.SDQYH);
	public static final PlayType SDQYH_R7_DS = new PlayType("山东群英会任选7单式", 51713, LotteryType.SDQYH);
	public static final PlayType SDQYH_R7_FS = new PlayType("山东群英会任选7复式", 51714, LotteryType.SDQYH);
	public static final PlayType SDQYH_R8_DS = new PlayType("山东群英会任选8单式", 51715, LotteryType.SDQYH);
	public static final PlayType SDQYH_R8_FS = new PlayType("山东群英会任选8复式", 51716, LotteryType.SDQYH);
	public static final PlayType SDQYH_R9_DS = new PlayType("山东群英会任选9单式", 51717, LotteryType.SDQYH);
	public static final PlayType SDQYH_R9_FS = new PlayType("山东群英会任选9复式", 51718, LotteryType.SDQYH);
	public static final PlayType SDQYH_R10_DS = new PlayType("山东群英会任选10单式", 51719, LotteryType.SDQYH);
	public static final PlayType SDQYH_R10_FS = new PlayType("山东群英会任选10复式", 51720, LotteryType.SDQYH);
	
	public static final PlayType SDQYH_R2_DT = new PlayType("山东群英会任选2胆拖", 51721, LotteryType.SDQYH);
	public static final PlayType SDQYH_R3_DT = new PlayType("山东群英会任选3胆拖", 51722, LotteryType.SDQYH);
	public static final PlayType SDQYH_R4_DT = new PlayType("山东群英会任选4胆拖", 51723, LotteryType.SDQYH);
	public static final PlayType SDQYH_R5_DT = new PlayType("山东群英会任选5胆拖", 51724, LotteryType.SDQYH);
	public static final PlayType SDQYH_R6_DT = new PlayType("山东群英会任选6胆拖", 51725, LotteryType.SDQYH);
	public static final PlayType SDQYH_R7_DT = new PlayType("山东群英会任选7胆拖", 51726, LotteryType.SDQYH);
	public static final PlayType SDQYH_R8_DT = new PlayType("山东群英会任选8胆拖", 51727, LotteryType.SDQYH);
	public static final PlayType SDQYH_R9_DT = new PlayType("山东群英会任选9胆拖", 51728, LotteryType.SDQYH);
	public static final PlayType SDQYH_R10_DT = new PlayType("山东群英会任选10胆拖", 51729, LotteryType.SDQYH);
	
	public static final PlayType SDQYH_W2_DS = new PlayType("山东群英会围2单式", 51730, LotteryType.SDQYH);
	public static final PlayType SDQYH_W2_FS = new PlayType("山东群英会围2复式", 51731, LotteryType.SDQYH);
	public static final PlayType SDQYH_W2_DT = new PlayType("山东群英会围2胆拖", 51732, LotteryType.SDQYH);
	public static final PlayType SDQYH_W3_DS = new PlayType("山东群英会围3单式", 51733, LotteryType.SDQYH);
	public static final PlayType SDQYH_W3_FS = new PlayType("山东群英会围3复式", 51734, LotteryType.SDQYH);
	public static final PlayType SDQYH_W3_DT = new PlayType("山东群英会围3胆拖", 51735, LotteryType.SDQYH);
	public static final PlayType SDQYH_W4_DS = new PlayType("山东群英会围4单式", 51736, LotteryType.SDQYH);
	public static final PlayType SDQYH_W4_FS = new PlayType("山东群英会围4复式", 51737, LotteryType.SDQYH);
	public static final PlayType SDQYH_W4_DT = new PlayType("山东群英会围4胆拖", 51738, LotteryType.SDQYH);
	
	public static final PlayType SDQYH_S1_DS = new PlayType("山东群英会顺1单式", 51739, LotteryType.SDQYH);
	public static final PlayType SDQYH_S1_FS = new PlayType("山东群英会顺1复式", 51740, LotteryType.SDQYH);
	public static final PlayType SDQYH_S2_DS = new PlayType("山东群英会顺2单式", 51741, LotteryType.SDQYH);
	public static final PlayType SDQYH_S2_FS = new PlayType("山东群英会顺2复式", 51742, LotteryType.SDQYH);
	public static final PlayType SDQYH_S2_DT = new PlayType("山东群英会顺2胆拖", 51743, LotteryType.SDQYH);
	public static final PlayType SDQYH_S3_DS = new PlayType("山东群英会顺3单式", 51744, LotteryType.SDQYH);
	public static final PlayType SDQYH_S3_FS = new PlayType("山东群英会顺3复式", 51745, LotteryType.SDQYH);
	public static final PlayType SDQYH_S3_DT = new PlayType("山东群英会顺3胆拖", 51746, LotteryType.SDQYH);
	
	public static final PlayType JX11X5_HH = new PlayType("混合", 2200, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R1_BZ_DS = new PlayType("前1标准单式", 2201, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R1_BZ_FS = new PlayType("前1标准复式", 2202, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R2_BZ_DS = new PlayType("任选2标准单式", 2203, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R2_BZ_FS = new PlayType("任选2标准复式", 2204, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R3_BZ_DS = new PlayType("任选3标准单式", 2205, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R3_BZ_FS = new PlayType("任选3标准复式", 2206, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R4_BZ_DS = new PlayType("任选4标准单式", 2207, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R4_BZ_FS = new PlayType("任选4标准复式", 2208, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R5_BZ_DS = new PlayType("任选5标准单式", 2209, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R5_BZ_FS = new PlayType("任选5标准复式", 2210, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R6_BZ_DS = new PlayType("任选6标准单式", 2211, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R6_BZ_FS = new PlayType("任选6标准复式", 2212, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R7_BZ_DS = new PlayType("任选7标准单式", 2213, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R7_BZ_FS = new PlayType("任选7标准复式", 2214, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R8_BZ_DS = new PlayType("任选8标准单式", 2215, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R8_BZ_FS = new PlayType("任选8标准复式", 2216, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R2_DT = new PlayType("任选2胆拖", 2217, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R3_DT = new PlayType("任选3胆拖", 2218, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R4_DT = new PlayType("任选4胆拖", 2219, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R5_DT = new PlayType("任选5胆拖", 2220, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R6_DT = new PlayType("任选6胆拖", 2221, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R7_DT = new PlayType("任选7胆拖", 2222, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_R8_DT = new PlayType("任选8胆拖", 2223, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_Q2_DS = new PlayType("前2直选单式", 2224, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_Q2_FS = new PlayType("前2直选复式", 2225, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_Q2ZX_DS = new PlayType("前2组选单式", 2226, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_Q2ZX_FS = new PlayType("前2组选复式", 2227, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_Q3_DS = new PlayType("前3直选单式", 2228, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_Q3_FS = new PlayType("前3直选复式", 2229, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_Q3ZX_DS = new PlayType("前3组选单式", 2230, LotteryType.JX11X5);
	
	public static final PlayType JX11X5_Q3ZX_FS = new PlayType("前3组选复式", 2231, LotteryType.JX11X5);
	
	public static final PlayType DC_SFP_ZYGG = new PlayType("自由过关", 3000, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_ZHGG = new PlayType("组合过关", 3001, LotteryType.DC_SFP);
	
	public static final PlayType DC_SFP_DC_1 = new PlayType("单关", 3002, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_2_1 = new PlayType("2串1", 3003, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_3_1 = new PlayType("3串1", 3004, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_4_1 = new PlayType("4串1", 3005, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_5_1 = new PlayType("5串1", 3006, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_6_1 = new PlayType("6串1", 3007, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_7_1 = new PlayType("7串1", 3008, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_8_1 = new PlayType("8串1", 3009, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_9_1 = new PlayType("9串1", 3010, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_10_1 = new PlayType("10串1", 3011, LotteryType.DC_SFP);
	
	public static final PlayType DC_SFP_DC_11_1 = new PlayType("11串1", 3012, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_12_1 = new PlayType("12串1", 3013, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_13_1 = new PlayType("13串1", 3014, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_14_1 = new PlayType("14串1", 3015, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_15_1 = new PlayType("15串1", 3016, LotteryType.DC_SFP);
	
	public static final PlayType DC_SFP_DC_2_3 = new PlayType("2串3", 3017, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_3_4 = new PlayType("3串4", 3018, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_3_7 = new PlayType("3串7", 3019, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_4_5 = new PlayType("4串5", 3020, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_4_11 = new PlayType("4串11", 3021, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_4_15 = new PlayType("4串15", 3022, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_5_6 = new PlayType("5串6", 3023, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_5_16 = new PlayType("5串16", 3024, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_5_26 = new PlayType("5串26", 3025, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_5_31 = new PlayType("5串31", 3026, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_6_7 = new PlayType("6串7", 3027, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_6_22 = new PlayType("6串22", 3028, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_6_42 = new PlayType("6串42", 3029, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_6_57 = new PlayType("6串57", 3030, LotteryType.DC_SFP);
	public static final PlayType DC_SFP_DC_6_63 = new PlayType("6串63", 3031, LotteryType.DC_SFP);
	
	
	public static final PlayType DC_SXDS_ZYGG = new PlayType("自由过关", 3100, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_ZHGG = new PlayType("组合过关", 3101, LotteryType.DC_SXDS);
	
	public static final PlayType DC_SXDS_DC_1 = new PlayType("单关", 3102, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_2_1 = new PlayType("2串1", 3103, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_3_1 = new PlayType("3串1", 3104, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_4_1 = new PlayType("4串1", 3105, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_5_1 = new PlayType("5串1", 3106, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_6_1 = new PlayType("6串1", 3107, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_7_1 = new PlayType("7串1", 3108, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_8_1 = new PlayType("8串1", 3109, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_9_1 = new PlayType("9串1", 3110, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_10_1 = new PlayType("10串1", 3111, LotteryType.DC_SXDS);
	
	public static final PlayType DC_SXDS_DC_11_1 = new PlayType("11串1", 3112, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_12_1 = new PlayType("12串1", 3113, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_13_1 = new PlayType("13串1", 3114, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_14_1 = new PlayType("14串1", 3115, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_15_1 = new PlayType("15串1", 3116, LotteryType.DC_SXDS);
	
	public static final PlayType DC_SXDS_DC_2_3 = new PlayType("2串3", 3117, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_3_4 = new PlayType("3串4", 3118, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_3_7 = new PlayType("3串7", 3119, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_4_5 = new PlayType("4串5", 3120, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_4_11 = new PlayType("4串11", 3121, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_4_15 = new PlayType("4串15", 3122, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_5_6 = new PlayType("5串6", 3123, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_5_16 = new PlayType("5串16", 3124, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_5_26 = new PlayType("5串26", 3125, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_5_31 = new PlayType("5串31", 3126, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_6_7 = new PlayType("6串7", 3127, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_6_22 = new PlayType("6串22", 3128, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_6_42 = new PlayType("6串42", 3129, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_6_57 = new PlayType("6串57", 3130, LotteryType.DC_SXDS);
	public static final PlayType DC_SXDS_DC_6_63 = new PlayType("6串63", 3131, LotteryType.DC_SXDS);	
	
	public static final PlayType DC_JQS_ZYGG = new PlayType("自由过关", 3200, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_ZHGG = new PlayType("组合过关", 3201, LotteryType.DC_JQS);
	
	public static final PlayType DC_JQS_DC_1 = new PlayType("单关", 3202, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_2_1 = new PlayType("2串1", 3203, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_3_1 = new PlayType("3串1", 3204, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_4_1 = new PlayType("4串1", 3205, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_5_1 = new PlayType("5串1", 3206, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_6_1 = new PlayType("6串1", 3207, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_7_1 = new PlayType("7串1", 3208, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_8_1 = new PlayType("8串1", 3209, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_9_1 = new PlayType("9串1", 3210, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_10_1 = new PlayType("10串1", 3211, LotteryType.DC_JQS);
	
	public static final PlayType DC_JQS_DC_11_1 = new PlayType("11串1", 3212, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_12_1 = new PlayType("12串1", 3213, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_13_1 = new PlayType("13串1", 3214, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_14_1 = new PlayType("14串1", 3215, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_15_1 = new PlayType("15串1", 3216, LotteryType.DC_JQS);
	
	public static final PlayType DC_JQS_DC_2_3 = new PlayType("2串3", 3217, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_3_4 = new PlayType("3串4", 3218, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_3_7 = new PlayType("3串7", 3219, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_4_5 = new PlayType("4串5", 3220, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_4_11 = new PlayType("4串11", 3221, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_4_15 = new PlayType("4串15", 3222, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_5_6 = new PlayType("5串6", 3223, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_5_16 = new PlayType("5串16", 3224, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_5_26 = new PlayType("5串26", 3225, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_5_31 = new PlayType("5串31", 3226, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_6_7 = new PlayType("6串7", 3227, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_6_22 = new PlayType("6串22", 3228, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_6_42 = new PlayType("6串42", 3229, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_6_57 = new PlayType("6串57", 3230, LotteryType.DC_JQS);
	public static final PlayType DC_JQS_DC_6_63 = new PlayType("6串63", 3231, LotteryType.DC_JQS);		
	
	public static final PlayType DC_BF_ZYGG = new PlayType("自由过关", 3300, LotteryType.DC_BF);
	public static final PlayType DC_BF_ZHGG = new PlayType("组合过关", 3301, LotteryType.DC_BF);
	
	public static final PlayType DC_BF_DC_1 = new PlayType("单关", 3302, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_2_1 = new PlayType("2串1", 3303, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_3_1 = new PlayType("3串1", 3304, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_4_1 = new PlayType("4串1", 3305, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_5_1 = new PlayType("5串1", 3306, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_6_1 = new PlayType("6串1", 3307, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_7_1 = new PlayType("7串1", 3308, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_8_1 = new PlayType("8串1", 3309, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_9_1 = new PlayType("9串1", 3310, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_10_1 = new PlayType("10串1", 3311, LotteryType.DC_BF);
	
	public static final PlayType DC_BF_DC_11_1 = new PlayType("11串1", 3312, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_12_1 = new PlayType("12串1", 3313, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_13_1 = new PlayType("13串1", 3314, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_14_1 = new PlayType("14串1", 3315, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_15_1 = new PlayType("15串1", 3316, LotteryType.DC_BF);
	
	public static final PlayType DC_BF_DC_2_3 = new PlayType("2串3", 3317, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_3_4 = new PlayType("3串4", 3318, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_3_7 = new PlayType("3串7", 3319, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_4_5 = new PlayType("4串5", 3320, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_4_11 = new PlayType("4串11", 3321, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_4_15 = new PlayType("4串15", 3322, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_5_6 = new PlayType("5串6", 3323, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_5_16 = new PlayType("5串16", 3324, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_5_26 = new PlayType("5串26", 3325, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_5_31 = new PlayType("5串31", 3326, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_6_7 = new PlayType("6串7", 3327, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_6_22 = new PlayType("6串22", 3328, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_6_42 = new PlayType("6串42", 3329, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_6_57 = new PlayType("6串57", 3330, LotteryType.DC_BF);
	public static final PlayType DC_BF_DC_6_63 = new PlayType("6串63", 3331, LotteryType.DC_BF);		
	
	public static final PlayType DC_BCSFP_ZYGG = new PlayType("自由过关", 3400, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_ZHGG = new PlayType("组合过关", 3401, LotteryType.DC_BCSFP);
	
	public static final PlayType DC_BCSFP_DC_1 = new PlayType("单关", 3402, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_2_1 = new PlayType("2串1", 3403, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_3_1 = new PlayType("3串1", 3404, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_4_1 = new PlayType("4串1", 3405, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_5_1 = new PlayType("5串1", 3406, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_6_1 = new PlayType("6串1", 3407, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_7_1 = new PlayType("7串1", 3408, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_8_1 = new PlayType("8串1", 3409, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_9_1 = new PlayType("9串1", 3410, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_10_1 = new PlayType("10串1", 3411, LotteryType.DC_BCSFP);
	
	public static final PlayType DC_BCSFP_DC_11_1 = new PlayType("11串1", 3412, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_12_1 = new PlayType("12串1", 3413, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_13_1 = new PlayType("13串1", 3414, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_14_1 = new PlayType("14串1", 3415, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_15_1 = new PlayType("15串1", 3416, LotteryType.DC_BCSFP);
	
	public static final PlayType DC_BCSFP_DC_2_3 = new PlayType("2串3", 3417, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_3_4 = new PlayType("3串4", 3418, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_3_7 = new PlayType("3串7", 3419, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_4_5 = new PlayType("4串5", 3420, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_4_11 = new PlayType("4串11", 3421, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_4_15 = new PlayType("4串15", 3422, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_5_6 = new PlayType("5串6", 3423, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_5_16 = new PlayType("5串16", 3424, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_5_26 = new PlayType("5串26", 3425, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_5_31 = new PlayType("5串31", 3426, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_6_7 = new PlayType("6串7", 3427, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_6_22 = new PlayType("6串22", 3428, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_6_42 = new PlayType("6串42", 3429, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_6_57 = new PlayType("6串57", 3430, LotteryType.DC_BCSFP);
	public static final PlayType DC_BCSFP_DC_6_63 = new PlayType("6串63", 3431, LotteryType.DC_BCSFP);
	
	public static final PlayType DC_SFGG_ZYGG = new PlayType("自由过关", 4000, LotteryType.DC_SFGG);
	public static final PlayType DC_SFGG_ZHGG = new PlayType("组合过关", 4001, LotteryType.DC_SFGG);
	
	public static final PlayType DC_SFGG_3_1 = new PlayType("3串1", 4004, LotteryType.DC_SFGG);
	public static final PlayType DC_SFGG_4_1 = new PlayType("4串1", 4005, LotteryType.DC_SFGG);
	public static final PlayType DC_SFGG_5_1 = new PlayType("5串1", 4006, LotteryType.DC_SFGG);
	public static final PlayType DC_SFGG_6_1 = new PlayType("6串1", 4007, LotteryType.DC_SFGG);
	public static final PlayType DC_SFGG_7_1 = new PlayType("7串1", 4008, LotteryType.DC_SFGG);
	public static final PlayType DC_SFGG_8_1 = new PlayType("8串1", 4009, LotteryType.DC_SFGG);
	public static final PlayType DC_SFGG_9_1 = new PlayType("9串1", 4010, LotteryType.DC_SFGG);
	public static final PlayType DC_SFGG_10_1 = new PlayType("10串1", 4011, LotteryType.DC_SFGG);
	
	public static final PlayType DC_SFGG_11_1 = new PlayType("11串1", 4012, LotteryType.DC_SFGG);
	public static final PlayType DC_SFGG_12_1 = new PlayType("12串1", 4013, LotteryType.DC_SFGG);
	public static final PlayType DC_SFGG_13_1 = new PlayType("13串1", 4014, LotteryType.DC_SFGG);
	public static final PlayType DC_SFGG_14_1 = new PlayType("14串1", 4015, LotteryType.DC_SFGG);
	public static final PlayType DC_SFGG_15_1 = new PlayType("15串1", 4016, LotteryType.DC_SFGG);
	
	public static final PlayType DC_SFGG_4_5 = new PlayType("4串5", 4020, LotteryType.DC_SFGG);
	public static final PlayType DC_SFGG_5_6 = new PlayType("5串6", 4023, LotteryType.DC_SFGG);
	public static final PlayType DC_SFGG_5_16 = new PlayType("5串16", 4024, LotteryType.DC_SFGG);
	public static final PlayType DC_SFGG_6_7 = new PlayType("6串7", 4027, LotteryType.DC_SFGG);
	public static final PlayType DC_SFGG_6_22 = new PlayType("6串22", 4028, LotteryType.DC_SFGG);
	public static final PlayType DC_SFGG_6_42 = new PlayType("6串42", 4029, LotteryType.DC_SFGG);
	
	public static final PlayType JCLQ_SF_GD = new PlayType("固定奖金", 7000, LotteryType.JCLQ_SF);
	public static final PlayType JCLQ_SF_FD = new PlayType("浮动奖金", 7001, LotteryType.JCLQ_SF);
	
	public static final PlayType JCLQ_SF_FD_1 = new PlayType("浮动奖金单关", 7002, LotteryType.JCLQ_SF);
	public static final PlayType JCLQ_SF_GD_2_1 = new PlayType("固定奖金2串1", 7003, LotteryType.JCLQ_SF);
	public static final PlayType JCLQ_SF_GD_3_1 = new PlayType("固定奖金3串1", 7004, LotteryType.JCLQ_SF);
	public static final PlayType JCLQ_SF_GD_4_1 = new PlayType("固定奖金4串1", 7005, LotteryType.JCLQ_SF);
	public static final PlayType JCLQ_SF_GD_5_1 = new PlayType("固定奖金5串1", 7006, LotteryType.JCLQ_SF);
	public static final PlayType JCLQ_SF_GD_6_1 = new PlayType("固定奖金6串1", 7007, LotteryType.JCLQ_SF);
	public static final PlayType JCLQ_SF_GD_7_1 = new PlayType("固定奖金7串1", 7008, LotteryType.JCLQ_SF);
	public static final PlayType JCLQ_SF_GD_8_1 = new PlayType("固定奖金8串1", 7009, LotteryType.JCLQ_SF);
	
	public static final PlayType JCLQ_RFSF_GD = new PlayType("固定奖金", 7100, LotteryType.JCLQ_RFSF);
	public static final PlayType JCLQ_RFSF_FD = new PlayType("浮动奖金", 7101, LotteryType.JCLQ_RFSF);
	
	public static final PlayType JCLQ_RFSF_FD_1 = new PlayType("浮动奖金单关", 7102, LotteryType.JCLQ_RFSF);
	public static final PlayType JCLQ_RFSF_GD_2_1 = new PlayType("固定奖金2串1", 7103, LotteryType.JCLQ_RFSF);
	public static final PlayType JCLQ_RFSF_GD_3_1 = new PlayType("固定奖金3串1", 7104, LotteryType.JCLQ_RFSF);
	public static final PlayType JCLQ_RFSF_GD_4_1 = new PlayType("固定奖金4串1", 7105, LotteryType.JCLQ_RFSF);
	public static final PlayType JCLQ_RFSF_GD_5_1 = new PlayType("固定奖金5串1", 7106, LotteryType.JCLQ_RFSF);
	public static final PlayType JCLQ_RFSF_GD_6_1 = new PlayType("固定奖金6串1", 7107, LotteryType.JCLQ_RFSF);
	public static final PlayType JCLQ_RFSF_GD_7_1 = new PlayType("固定奖金7串1", 7108, LotteryType.JCLQ_RFSF);
	public static final PlayType JCLQ_RFSF_GD_8_1 = new PlayType("固定奖金8串1", 7109, LotteryType.JCLQ_RFSF);
	
	public static final PlayType JCLQ_SFC_GD = new PlayType("固定奖金", 7200, LotteryType.JCLQ_SFC);
	public static final PlayType JCLQ_SFC_FD = new PlayType("浮动奖金", 7201, LotteryType.JCLQ_SFC);
	
	public static final PlayType JCLQ_SFC_FD_1 = new PlayType("浮动奖金单关", 7202, LotteryType.JCLQ_SFC);
	public static final PlayType JCLQ_SFC_GD_2_1 = new PlayType("固定奖金2串1", 7203, LotteryType.JCLQ_SFC);
	public static final PlayType JCLQ_SFC_GD_3_1 = new PlayType("固定奖金3串1", 7204, LotteryType.JCLQ_SFC);
	public static final PlayType JCLQ_SFC_GD_4_1 = new PlayType("固定奖金4串1", 7205, LotteryType.JCLQ_SFC);
	
	public static final PlayType JCLQ_DXF_GD = new PlayType("固定奖金", 7300, LotteryType.JCLQ_DXF);
	public static final PlayType JCLQ_DXF_FD = new PlayType("浮动奖金", 7301, LotteryType.JCLQ_DXF);
	
	public static final PlayType JCLQ_DXF_FD_1 = new PlayType("浮动奖金单关", 7302, LotteryType.JCLQ_DXF);
	public static final PlayType JCLQ_DXF_GD_2_1 = new PlayType("固定奖金2串1", 7303, LotteryType.JCLQ_DXF);
	public static final PlayType JCLQ_DXF_GD_3_1 = new PlayType("固定奖金3串1", 7304, LotteryType.JCLQ_DXF);
	public static final PlayType JCLQ_DXF_GD_4_1 = new PlayType("固定奖金4串1", 7305, LotteryType.JCLQ_DXF);
	public static final PlayType JCLQ_DXF_GD_5_1 = new PlayType("固定奖金5串1", 7306, LotteryType.JCLQ_DXF);
	public static final PlayType JCLQ_DXF_GD_6_1 = new PlayType("固定奖金6串1", 7307, LotteryType.JCLQ_DXF);
	public static final PlayType JCLQ_DXF_GD_7_1 = new PlayType("固定奖金7串1", 7308, LotteryType.JCLQ_DXF);
	public static final PlayType JCLQ_DXF_GD_8_1 = new PlayType("固定奖金8串1", 7309, LotteryType.JCLQ_DXF);
	
	public static final PlayType JCZQ_SPF_GD = new PlayType("固定奖金", 8000, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_FD = new PlayType("浮动奖金", 8001, LotteryType.JCZQ_SPF);
	
	public static final PlayType JCZQ_SPF_FD_1 = new PlayType("浮动奖金单关", 8002, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_2_1 = new PlayType("固定奖金2串1", 8003, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_3_1 = new PlayType("固定奖金3串1", 8004, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_4_1 = new PlayType("固定奖金4串1", 8005, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_5_1 = new PlayType("固定奖金5串1", 8006, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_6_1 = new PlayType("固定奖金6串1", 8007, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_3_3 = new PlayType("固定奖金3串3", 8008, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_3_4 = new PlayType("固定奖金3串4", 8009, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_4_4 = new PlayType("固定奖金4串4", 8010, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_4_5 = new PlayType("固定奖金4串5", 8011, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_4_6 = new PlayType("固定奖金4串6", 8012, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_4_11 = new PlayType("固定奖金4串11", 8013, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_5_5 = new PlayType("固定奖金5串5", 8014, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_5_6 = new PlayType("固定奖金5串6", 8015, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_5_10 = new PlayType("固定奖金5串10", 8016, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_5_16 = new PlayType("固定奖金5串16", 8017, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_5_20 = new PlayType("固定奖金5串20", 8018, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_5_26 = new PlayType("固定奖金5串26", 8019, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_6_6 = new PlayType("固定奖金6串6", 8020, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_6_7 = new PlayType("固定奖金6串7", 8021, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_6_15 = new PlayType("固定奖金6串15", 8022, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_6_20 = new PlayType("固定奖金6串20", 8023, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_6_22 = new PlayType("固定奖金6串22", 8024, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_6_35 = new PlayType("固定奖金6串35", 8025, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_6_42 = new PlayType("固定奖金6串42", 8026, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_6_50 = new PlayType("固定奖金6串50", 8027, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_6_57 = new PlayType("固定奖金6串57", 8028, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_7_1 = new PlayType("固定奖金7串1", 8029, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_8_1 = new PlayType("固定奖金8串1", 8030, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_7_7 = new PlayType("固定奖金7串7", 8031, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_7_8 = new PlayType("固定奖金7串8", 8032, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_7_21 = new PlayType("固定奖金7串21", 8033, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_7_35 = new PlayType("固定奖金7串35", 8034, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_7_120 = new PlayType("固定奖金7串120", 8035, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_8_8 = new PlayType("固定奖金8串8", 8036, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_8_9 = new PlayType("固定奖金8串9", 8037, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_8_28 = new PlayType("固定奖金8串28", 8038, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_8_56 = new PlayType("固定奖金8串56", 8039, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_8_70 = new PlayType("固定奖金8串70", 8040, LotteryType.JCZQ_SPF);
	public static final PlayType JCZQ_SPF_GD_8_247 = new PlayType("固定奖金8串247", 8041, LotteryType.JCZQ_SPF);
	
	public static final PlayType JCZQ_BF_GD = new PlayType("固定奖金", 8100, LotteryType.JCZQ_BF);
	public static final PlayType JCZQ_BF_FD = new PlayType("浮动奖金", 8101, LotteryType.JCZQ_BF);
	
	public static final PlayType JCZQ_BF_FD_1 = new PlayType("浮动奖金单关", 8102, LotteryType.JCZQ_BF);
	public static final PlayType JCZQ_BF_GD_2_1 = new PlayType("固定奖金2串1", 8103, LotteryType.JCZQ_BF);
	public static final PlayType JCZQ_BF_GD_3_1 = new PlayType("固定奖金3串1", 8104, LotteryType.JCZQ_BF);
	public static final PlayType JCZQ_BF_GD_3_3 = new PlayType("固定奖金3串3", 8105, LotteryType.JCZQ_BF);
	public static final PlayType JCZQ_BF_GD_3_4 = new PlayType("固定奖金3串4", 8106, LotteryType.JCZQ_BF);
	public static final PlayType JCZQ_BF_GD_4_1 = new PlayType("固定奖金4串1", 8107, LotteryType.JCZQ_BF);
	public static final PlayType JCZQ_BF_GD_4_4 = new PlayType("固定奖金4串4", 8108, LotteryType.JCZQ_BF);
	public static final PlayType JCZQ_BF_GD_4_5 = new PlayType("固定奖金4串5", 8109, LotteryType.JCZQ_BF);
	public static final PlayType JCZQ_BF_GD_4_6 = new PlayType("固定奖金4串6", 8110, LotteryType.JCZQ_BF);
	public static final PlayType JCZQ_BF_GD_4_11 = new PlayType("固定奖金4串11", 8111, LotteryType.JCZQ_BF);
	
	public static final PlayType JCZQ_JQS_GD = new PlayType("固定奖金", 8200, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_FD = new PlayType("浮动奖金", 8201, LotteryType.JCZQ_JQS);
	
	public static final PlayType JCZQ_JQS_FD_1 = new PlayType("浮动奖金单关", 8202, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_2_1 = new PlayType("固定奖金2串1", 8203, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_3_1 = new PlayType("固定奖金3串1", 8204, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_4_1 = new PlayType("固定奖金4串1", 8205, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_5_1 = new PlayType("固定奖金5串1", 8206, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_6_1 = new PlayType("固定奖金6串1", 8207, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_3_3 = new PlayType("固定奖金3串3", 8208, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_3_4 = new PlayType("固定奖金3串4", 8209, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_4_4 = new PlayType("固定奖金4串4", 8210, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_4_5 = new PlayType("固定奖金4串5", 8211, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_4_6 = new PlayType("固定奖金4串6", 8212, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_4_11 = new PlayType("固定奖金4串11", 8213, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_5_5 = new PlayType("固定奖金5串5", 8214, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_5_6 = new PlayType("固定奖金5串6", 8215, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_5_10 = new PlayType("固定奖金5串10", 8216, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_5_16 = new PlayType("固定奖金5串16", 8217, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_5_20 = new PlayType("固定奖金5串20", 8218, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_5_26 = new PlayType("固定奖金5串26", 8219, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_6_6 = new PlayType("固定奖金6串6", 8220, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_6_7 = new PlayType("固定奖金6串7", 8221, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_6_15 = new PlayType("固定奖金6串15", 8222, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_6_20 = new PlayType("固定奖金6串20", 8223, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_6_22 = new PlayType("固定奖金6串22", 8224, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_6_35 = new PlayType("固定奖金6串35", 8225, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_6_42 = new PlayType("固定奖金6串42", 8226, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_6_50 = new PlayType("固定奖金6串50", 8227, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_6_57 = new PlayType("固定奖金6串57", 8228, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_7_1 = new PlayType("固定奖金7串1", 8229, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_8_1 = new PlayType("固定奖金8串1", 8230, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_7_7 = new PlayType("固定奖金7串7", 8231, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_7_8 = new PlayType("固定奖金7串8", 8232, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_7_21 = new PlayType("固定奖金7串21", 8233, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_7_35 = new PlayType("固定奖金7串35", 8234, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_7_120 = new PlayType("固定奖金7串120", 8235, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_8_8 = new PlayType("固定奖金8串8", 8236, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_8_9 = new PlayType("固定奖金8串9", 8237, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_8_28 = new PlayType("固定奖金8串28", 8238, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_8_56 = new PlayType("固定奖金8串56", 8239, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_8_70 = new PlayType("固定奖金8串70", 8240, LotteryType.JCZQ_JQS);
	public static final PlayType JCZQ_JQS_GD_8_247 = new PlayType("固定奖金8串247", 8241, LotteryType.JCZQ_JQS);
	
	public static final PlayType JCZQ_BQC_GD = new PlayType("固定奖金", 8300, LotteryType.JCZQ_BQC);
	public static final PlayType JCZQ_BQC_FD = new PlayType("浮动奖金", 8301, LotteryType.JCZQ_BQC);
	
	public static final PlayType JCZQ_BQC_FD_1 = new PlayType("浮动奖金单关", 8302, LotteryType.JCZQ_BQC);
	public static final PlayType JCZQ_BQC_GD_2_1 = new PlayType("固定奖金2串1", 8303, LotteryType.JCZQ_BQC);
	public static final PlayType JCZQ_BQC_GD_3_1 = new PlayType("固定奖金3串1", 8304, LotteryType.JCZQ_BQC);
	public static final PlayType JCZQ_BQC_GD_3_3 = new PlayType("固定奖金3串3", 8305, LotteryType.JCZQ_BQC);
	public static final PlayType JCZQ_BQC_GD_3_4 = new PlayType("固定奖金3串4", 8306, LotteryType.JCZQ_BQC);
	public static final PlayType JCZQ_BQC_GD_4_1 = new PlayType("固定奖金4串1", 8307, LotteryType.JCZQ_BQC);
	public static final PlayType JCZQ_BQC_GD_4_4 = new PlayType("固定奖金4串4", 8308, LotteryType.JCZQ_BQC);
	public static final PlayType JCZQ_BQC_GD_4_5 = new PlayType("固定奖金4串5", 8309, LotteryType.JCZQ_BQC);
	public static final PlayType JCZQ_BQC_GD_4_6 = new PlayType("固定奖金4串6", 8310, LotteryType.JCZQ_BQC);
	public static final PlayType JCZQ_BQC_GD_4_11 = new PlayType("固定奖金4串11", 8311, LotteryType.JCZQ_BQC);
	
	public static final PlayType JCZQ_GJ_HH = new PlayType("混合", 9000, LotteryType.JCZQ_GJ);
	public static final PlayType JCZQ_GJ_DS = new PlayType("单式", 9001, LotteryType.JCZQ_GJ);
	public static final PlayType JCZQ_GJ_FS = new PlayType("复式", 9002, LotteryType.JCZQ_GJ);
	public static final PlayType JCZQ_GYJ_HH = new PlayType("混合", 9100, LotteryType.JCZQ_GYJ);
	public static final PlayType JCZQ_GYJ_DS = new PlayType("单式", 9101, LotteryType.JCZQ_GYJ);
	public static final PlayType JCZQ_GYJ_FS = new PlayType("复式", 9102, LotteryType.JCZQ_GYJ);
	
	public static final PlayType SFC_HH = new PlayType("混合", 700, LotteryType.SFC);
	public static final PlayType SFC_DS = new PlayType("单式", 701, LotteryType.SFC);
	public static final PlayType SFC_FS = new PlayType("复式", 702, LotteryType.SFC);
	
	public static final PlayType SFR9_HH = new PlayType("混合", 800, LotteryType.SFR9);
	public static final PlayType SFR9_DS = new PlayType("单式", 801, LotteryType.SFR9);
	public static final PlayType SFR9_FS = new PlayType("复式", 802, LotteryType.SFR9);
	public static final PlayType SFR9_DT = new PlayType("胆拖", 803, LotteryType.SFR9);
	
	public static final PlayType JQC_HH = new PlayType("混合", 900, LotteryType.JQC);
	public static final PlayType JQC_DS = new PlayType("单式", 901, LotteryType.JQC);
	public static final PlayType JQC_FS = new PlayType("复式", 902, LotteryType.JQC);
	
	public static final PlayType BQC_HH = new PlayType("混合", 1000, LotteryType.BQC);
	public static final PlayType BQC_DS = new PlayType("单式", 1001, LotteryType.BQC);
	public static final PlayType BQC_FS = new PlayType("复式", 1002, LotteryType.BQC);
	
	public static final PlayType BJTC33X7_HH = new PlayType("北京体彩33选7混合", 55200, LotteryType.BJTC33X7);
	public static final PlayType BJTC33X7_DS = new PlayType("北京体彩33选7单式", 55201, LotteryType.BJTC33X7);
	public static final PlayType BJTC33X7_FS = new PlayType("北京体彩33选7复式", 55202, LotteryType.BJTC33X7);
	public static final PlayType BJTC33X7_DT = new PlayType("北京体彩33选7胆拖", 55203, LotteryType.BJTC33X7);
	
	public static final PlayType CQ11X5_HH = new PlayType("混合", 55800, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R1_BZ_DS = new PlayType("前1标准单式", 55801, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R1_BZ_FS = new PlayType("前1标准复式", 55802, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R2_BZ_DS = new PlayType("任选2标准单式", 55803, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R2_BZ_FS = new PlayType("任选2标准复式", 55804, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R3_BZ_DS = new PlayType("任选3标准单式", 55805, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R3_BZ_FS = new PlayType("任选3标准复式", 55806, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R4_BZ_DS = new PlayType("任选4标准单式", 55807, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R4_BZ_FS = new PlayType("任选4标准复式", 55808, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R5_BZ_DS = new PlayType("任选5标准单式", 55809, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R5_BZ_FS = new PlayType("任选5标准复式", 55810, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R6_BZ_DS = new PlayType("任选6标准单式", 55811, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R6_BZ_FS = new PlayType("任选6标准复式", 55812, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R7_BZ_DS = new PlayType("任选7标准单式", 55813, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R7_BZ_FS = new PlayType("任选7标准复式", 55814, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R8_BZ_DS = new PlayType("任选8标准单式", 55815, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R8_BZ_FS = new PlayType("任选8标准复式", 55816, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R2_DT = new PlayType("任选2胆拖", 55817, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R3_DT = new PlayType("任选3胆拖", 55818, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R4_DT = new PlayType("任选4胆拖", 55819, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R5_DT = new PlayType("任选5胆拖", 55820, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R6_DT = new PlayType("任选6胆拖", 55821, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R7_DT = new PlayType("任选7胆拖", 55822, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_R8_DT = new PlayType("任选8胆拖", 55823, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_Q2_DS = new PlayType("前2直选单式", 55824, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_Q2_FS = new PlayType("前2直选复式", 55825, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_Q2ZX_DS = new PlayType("前2组选单式", 55826, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_Q2ZX_FS = new PlayType("前2组选复式", 55827, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_Q3_DS = new PlayType("前3直选单式", 55828, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_Q3_FS = new PlayType("前3直选复式", 55829, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_Q3ZX_DS = new PlayType("前3组选单式", 55830, LotteryType.CQ11X5);
	
	public static final PlayType CQ11X5_Q3ZX_FS = new PlayType("前3组选复式", 55831, LotteryType.CQ11X5);
}
