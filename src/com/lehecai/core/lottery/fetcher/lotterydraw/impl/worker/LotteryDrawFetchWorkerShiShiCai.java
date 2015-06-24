package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.util.CoreDateUtils;
import com.lehecai.core.util.CoreFetcherUtils;



/**
 * 时时彩网 开奖结果抓取
 * 主要抓取快猜, 目前实现广东快乐十分  <br/>
 * 分析: 时时彩网都是各彩种分开的<br/>
 * 当前期地址:http://video.shishicai.cn/haoma/gdkl10/list/84.aspx   <br/>
 * 历史地址:  http://video.shishicai.cn/haoma/gdkl10/list/2011-02-25.aspx  <br/>
 * @author leiming
 *
 */
public class LotteryDrawFetchWorkerShiShiCai extends AbstractLotteryDrawFetchWorker {
	
	private static final Map<LotteryType, String> lotteryTypeMap = new HashMap<LotteryType, String>();
	private static final Map<LotteryType, String> lotteryDefaultUrlMap = new HashMap<LotteryType, String>();
	private static final Map<LotteryType, String> lotteryPhaseConvertionMap = new HashMap<LotteryType, String>();
	
	private static final String URL_DEFAULT = "http://video.shishicai.cn/haoma/%s/list/%s.aspx";
	private static final String URL_HISTORY = "http://video.shishicai.cn/haoma/%s/list/%s.aspx";
	
	
	static {
		lotteryTypeMap.put(LotteryType.SHSSL, "shssl");
		lotteryDefaultUrlMap.put(LotteryType.SHSSL, "23");

		lotteryTypeMap.put(LotteryType.GDKL10, "gdkl10");
		lotteryDefaultUrlMap.put(LotteryType.GDKL10, "84");
		
		lotteryTypeMap.put(LotteryType.CQSSC, "cqssc");
		lotteryDefaultUrlMap.put(LotteryType.CQSSC, "120");
		
		lotteryTypeMap.put(LotteryType.SDQYH, "sdqyh");
		lotteryDefaultUrlMap.put(LotteryType.SDQYH, "40");
		
		lotteryTypeMap.put(LotteryType.GXKL10, "gxkl10");
		lotteryDefaultUrlMap.put(LotteryType.GXKL10, "50");
		
		lotteryTypeMap.put(LotteryType.JXSSC, "jxssc");
		lotteryDefaultUrlMap.put(LotteryType.JXSSC, "84");
		
		lotteryTypeMap.put(LotteryType.GD11X5, "gd11x5");
		lotteryDefaultUrlMap.put(LotteryType.GD11X5, "65");
		lotteryPhaseConvertionMap.put(LotteryType.GD11X5, "20");
		
		lotteryTypeMap.put(LotteryType.JX11X5, "jx11x5");
		lotteryDefaultUrlMap.put(LotteryType.JX11X5, "65");
		
		lotteryTypeMap.put(LotteryType.CQ11X5, "cq11x5");
		lotteryDefaultUrlMap.put(LotteryType.CQ11X5, "85");
		lotteryPhaseConvertionMap.put(LotteryType.CQ11X5, "20");
	}

	public LotteryDrawFetchWorkerShiShiCai(LotteryType lotteryType) {
		super(lotteryType);
	}
	
	@Override
	public LotteryDraw fetchResult(String phase) {
		return null;
	}

	@Override
	public LotteryDraw fetchResultDetail(String phase) {
		LotteryType lotteryType = this.getLotteryType();
		

		if (lotteryPhaseConvertionMap.containsKey(lotteryType)) {
			// 补回彩期
			phase = lotteryPhaseConvertionMap.get(lotteryType) + phase;
		}
		
		String url = this.getResultDetailUrl(phase);
		if (url == null || url.isEmpty()) {
			logger.error("==详细页面==抓取=={}==期号：{}==详细地址不存在，返回null", lotteryType.getName(), phase);
			return null;
		}
		String pageInfo = "详细页面" + url;
		String encoding = "UTF-8";
		String logHeader = "=="
				+ pageInfo + "==抓取==" + getLotteryType().getName() + "==";

		logger.info(logHeader + "开始==");
		LotteryDraw lotteryDraw = null;

		String data = null;
		
		Map<String, String> headerParams = new HashMap<String, String>();
		headerParams.put("Referer", "http://www.shishicai.cn");
		headerParams.put("user-agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.8) Gecko/20100722 Firefox/3.6.8");
		
		data = CoreFetcherUtils.URLGetWithHeaderParams(url, headerParams, null, encoding);
		
		if (data == null || data.indexOf("404 Not Found") > 0 || data.isEmpty()) {
			logger.error(logHeader + "data is null or 404 Not Found");
			return null;
		}
		
		lotteryDraw = CoreFetcherUtils.parseShiShiCaiFrequentLotteryDraw(data, lotteryType, phase, encoding);

		if (lotteryDraw != null) {
			if (lotteryPhaseConvertionMap.containsKey(lotteryType)) {
				// 补回彩期
				lotteryDraw.setPhase(StringUtils.substringAfter(lotteryDraw.getPhase(), lotteryPhaseConvertionMap.get(lotteryType)));
			}
		}
		
		return lotteryDraw;
	}

	@Override
	protected String getResultDetailUrl(String phase) {
		LotteryType lotteryType = this.getLotteryType();
		
		if (!lotteryTypeMap.containsKey(lotteryType)) {
			return null;
		}
		
		String lotteryTypeExternal = lotteryTypeMap.get(lotteryType);
		
		if (phase == null) {
			String param = lotteryDefaultUrlMap.get(lotteryType);
			return String.format(URL_DEFAULT, lotteryTypeExternal, param);
		} else {
			if (lotteryType.getValue() == LotteryType.GXKL10.getValue()) {
				// 广西快乐十分的彩期规则不一样，是按照当年的第几个购彩日计算（且农历春节停售，无法预测具体天数）
				// 暂时采用先抓取最新一期，得到天数，然后根据相对时间计算归档日期的方法（此方法不能精确覆盖所有情况）
				LotteryDraw lotteryDraw = this.fetchResultDetail(null);
				if (lotteryDraw == null) {
					return null;
				}
				try {
					Date drawDate = CoreDateUtils.parseLongDate(lotteryDraw.getTimeDraw());
					String latestPhase = lotteryDraw.getPhase();
					int latestPhaseDay = Integer.parseInt(latestPhase.substring(4, 7));
					int queryPhaseDay = Integer.parseInt(phase.substring(4, 7));
					
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(drawDate);
					calendar.add(Calendar.DATE, queryPhaseDay - latestPhaseDay);
					
					return String.format(URL_HISTORY, lotteryTypeExternal, CoreDateUtils.formatDate(calendar.getTime(), "yyyy-MM-dd"));
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
					return null;
				}
			}
			// 默认按日期归档, yyyy-MM-dd
			try {
				String archiveUrl = CoreDateUtils.formatDate(
						CoreDateUtils.parseDate(phase.substring(0, 8), "yyyyMMdd"),
						"yyyy-MM-dd");
				
				return String.format(URL_HISTORY, lotteryTypeExternal, archiveUrl);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				return null;
			}
		}
	}

	@Override
	protected String getResultUrl(String phase) {
		return null;
	}
	
	
}
