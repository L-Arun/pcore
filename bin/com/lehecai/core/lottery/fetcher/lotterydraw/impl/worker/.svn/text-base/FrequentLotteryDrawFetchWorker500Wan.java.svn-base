package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.util.HashMap;
import java.util.Map;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.util.CoreFetcherUtils;
import com.lehecai.core.util.CoreXmlUtils;

/**
 * 高频开奖页面500Wan通用抓取结果
 * 
 * @author leiming
 * 
 */
public class FrequentLotteryDrawFetchWorker500Wan extends
		AbstractLotteryDrawFetchWorker {
	
	private static Map<LotteryType, String> lotteryTypeMap = new HashMap<LotteryType, String>();
	private static Map<LotteryType, String> lotteryTypeHistoryMap = new HashMap<LotteryType, String>();
	
	private static final String URL_DEFAULT = "http://www.500wan.com/static/info/kaijiang/xml/%s/newlyopen.xml";
	private static final String URL_HISTORY = "http://kaijiang.500wan.com/static/info/kaijiang/xml/%s/%s.xml";
	
	static {
		//快乐扑克
		lotteryTypeMap.put(LotteryType.A_KLPK, "klpk");
		//群英会
		lotteryTypeMap.put(LotteryType.SDQYH, "qyh");
		//扑克彩·十分乐
		lotteryTypeMap.put(LotteryType.A_PKCSFL, "scpkc");
		//广西快乐十分
		lotteryTypeMap.put(LotteryType.GXKL10, "gxklsf");
		//广东快乐十分
		lotteryTypeMap.put(LotteryType.GDKL10, "gdklsf");
		//快乐8
		lotteryTypeMap.put(LotteryType.BJKL8, "kl8");
		//泳坛夺金
		lotteryTypeMap.put(LotteryType.A_YTDJ, "ytdj");
		//重庆时时彩
		lotteryTypeMap.put(LotteryType.CQSSC, "ssc");
		
	}

	public FrequentLotteryDrawFetchWorker500Wan(LotteryType lotteryType) {
		super(lotteryType);
	}
	
	@Override
	public LotteryDraw fetchResult(String phase) {
		return null;
	}

	@Override
	public LotteryDraw fetchResultDetail(String phase) {
		LotteryType lotteryType = this.getLotteryType();
		
		String url = this.getResultDetailUrl(phase);
		if (url == null || url.isEmpty()) {
			logger.error("==详细页面==抓取==" + lotteryType.getName() + "==期号：" + phase
					+ "==详细地址不存在，返回null");
			return null;
		}
		String pageInfo = "详细页面" + url;
		String encoding = "GBK";
		String logHeader = "==" + pageInfo + "==抓取==" + getLotteryType().getName() + "==";

		logger.info(logHeader + "开始==");
		LotteryDraw lotteryDraw = null;

		String data = null;

		data = CoreFetcherUtils.URLGet(url, null, encoding);
		if (data == null || data.indexOf("404 Not Found") > 0) {
			logger.error(logHeader + "data is null or 404 Not Found");
			return null;
		}
		
		lotteryDraw = new LotteryDraw();
		lotteryDraw.setLotteryType(getLotteryType());
		
		return CoreXmlUtils.parseFrequentLotteryDraw(data, lotteryDraw, null);
	}

	@Override
	protected String getResultDetailUrl(String phase) {
		String lotteryId = lotteryTypeMap.get(this.getLotteryType());
		if (lotteryId == null) {
			return null;
		}
		if (phase == null || phase.trim().length() == 0) {
			return String.format(URL_DEFAULT, lotteryId);
		}
		
		if (!lotteryTypeHistoryMap.containsKey(this.getLotteryType())) {
			return null;
		}
		String date = null;
		try {
			date = phase.substring(0, 8);
		} catch (Exception e) {
			logger.error("从期号中解析日期不正确, phase={}", phase);
		}
		if (date == null) {
			return null;
		}
		return String.format(URL_HISTORY, phase, date);
	}

	@Override
	protected String getResultUrl(String phase) {
		return null;
	}
}