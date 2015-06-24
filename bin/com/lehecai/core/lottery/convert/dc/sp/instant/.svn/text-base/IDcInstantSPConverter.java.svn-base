package com.lehecai.core.lottery.convert.dc.sp.instant;

import java.util.List;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.dc.DcInstantSPItem;

/**
 * 单场即时SP转换接口
 * @author leiming
 *
 */
public interface IDcInstantSPConverter {
	public static final String JSON_KEY_INSTANT_SP = "sp";
	public static final String JSON_KEY_INSTANT_SPSTATUS = "spstatus";
	public static final String JSON_KEY_INSTANT_PHASENO = "phaseNo";
	public static final String JSON_KEY_INSTANT_LOTTERYTYPE = "lotteryType";
	public static final String JSON_KEY_INSTANT_VERSION = "version";
	
	public static final String JSON_KEY_INSTANT_SP_STATUS_UP = "+";
	public static final String JSON_KEY_INSTANT_SP_STATUS_EQUAL = "";//没有变动
	public static final String JSON_KEY_INSTANT_SP_STATUS_DOWN = "-";
	/**
	 * 将抓取的某dc的某期即时sp值转换为对应的文本内容<br/>
	 * 便于页面获取数据进行更新对应sp值
	 * @param lotteryType
	 * @param dcInstantSPItems
	 * @param PhaseNo
	 * @return String json格式  正使用  {"phaseNo":"101120","lotteryType":"31","version":"12334341221","sp":[{"m12f":"3.02"},{"m24s":"5.2"},...],"spstatus":[{"m12f":"+"},{"m24s":"-"},...]}
	 * @return String json格式  弃用 {"phaseNo":"101120","lotteryType":"31","version":"12334341221","sp":[{"m":"m12f","sp":"3.02","status":"+"},{"m":"m24s","sp":"5.2","status":"-"},...]}
	 */
	public String fetchInstantSPConvert(LotteryType lotteryType,List<DcInstantSPItem> dcInstantSPItems,String phaseNo);
}
