package com.lehecai.core.lottery.fetcher.jczq.impl.worker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.FetchFailedException;
import com.lehecai.core.lottery.JczqDynamicSaleStatus;
import com.lehecai.core.lottery.JczqRaceStatus;
import com.lehecai.core.lottery.JczqStaticSaleStatus;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jczq.AbstractJczqScheduleFetchWorker;
import com.lehecai.core.lottery.fetcher.jczq.JczqScheduleItem;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreHttpUtils;
import com.lehecai.core.util.CoreJSONUtils;
import com.lehecai.core.util.lottery.JczqUtil;

/**
 * 通用竞彩足球赛程抓取实现类
 * @author qatang
 *
 */
public class CommonJczqScheduleFetchWorkerPengineAPI extends AbstractJczqScheduleFetchWorker{
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private static final String PROCESS_CODE = "10001"; 
	
	private static final String URL_PENGINE_API = "http://phase.lehecai.com:16041/JczqServlet";
	//private static final String URL_PENGINE_API = "http://172.16.10.195:8080/pengine/JczqServlet";

	@SuppressWarnings("unchecked")
	@Override
	public List<JczqScheduleItem> fetchJczqSchedule(String officialDate) throws FetchFailedException {
		List<String> list = null;
		try {
			list = CoreHttpUtils.getUrl(URL_PENGINE_API, "ProcessCode=" + PROCESS_CODE, CharsetConstant.CHARSET_UTF8, 100000);
		} catch (Exception e) {
			logger.error("竞彩足球抓取官方赛程失败", e);
			throw new FetchFailedException(e.getMessage());
		}
		if (list == null || list.size() == 0) {
			logger.error("未获取到竞彩足球官方赛程");
			throw new FetchFailedException("未获取到竞彩足球官方赛程");
		}
		String matches = list.get(0);
		if (matches == null || "".equals(matches)) {
			logger.error("未获取到竞彩足球官方赛程");
			throw new FetchFailedException("未获取到竞彩足球官方赛程");
		}
		JSONArray jsonArray = null;
		try {
			jsonArray = JSONArray.fromObject(matches);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		if (jsonArray == null) {
			logger.error("转换竞彩足球官方赛程出错");
			throw new FetchFailedException("转换竞彩足球官方赛程出错");
		}
		if (jsonArray.isEmpty()) {
			logger.warn("竞彩足球官方赛程为空");
			return null;
		}
		List<JczqScheduleItem> jczqScheduleItems = new ArrayList<JczqScheduleItem>();
		for (Iterator iterator = jsonArray.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			if (object == null) {
				throw new FetchFailedException("转换竞彩足球官方赛程出错");
			}
			JczqScheduleItem item = new JczqScheduleItem();
			
			item.setMatchNum(CoreJSONUtils.getString(object, "matchNum"));
			item.setOfficialNum(CoreJSONUtils.getString(object, "officialNum"));
			item.setOfficialDate(CoreJSONUtils.getDate(object, "officialDate", "yyyyMMdd"));
			item.setMatchName(JczqUtil.convertMatchName(CoreJSONUtils.getString(object, "matchName"), LotteryType.JCZQ_SPF, FetcherType.T_PENGINEAPI));
			item.setMatchDate(CoreJSONUtils.getDate(object, "matchDate", "yyyyMMddHHmmss"));
			item.setHomeTeam(CoreJSONUtils.getString(object, "homeTeam"));
			item.setAwayTeam(CoreJSONUtils.getString(object, "awayTeam"));
			item.setHandicap(CoreJSONUtils.getString(object, "handicap"));
			item.setStatus(JczqRaceStatus.getItem(CoreJSONUtils.getInt(object, "status")));
			item.setStaticSaleSpfStatus(JczqStaticSaleStatus.getItem(CoreJSONUtils.getInt(object, "staticSaleSpfStatus")));
			item.setDynamicSaleSpfStatus(JczqDynamicSaleStatus.getItem(CoreJSONUtils.getInt(object, "dynamicSaleSpfStatus")));
			item.setStaticSaleBfStatus(JczqStaticSaleStatus.getItem(CoreJSONUtils.getInt(object, "staticSaleBfStatus")));
			item.setDynamicSaleBfStatus(JczqDynamicSaleStatus.getItem(CoreJSONUtils.getInt(object, "dynamicSaleBfStatus")));
			item.setStaticSaleJqsStatus(JczqStaticSaleStatus.getItem(CoreJSONUtils.getInt(object, "staticSaleJqsStatus")));
			item.setDynamicSaleJqsStatus(JczqDynamicSaleStatus.getItem(CoreJSONUtils.getInt(object, "dynamicSaleJqsStatus")));
			item.setStaticSaleBqcStatus(JczqStaticSaleStatus.getItem(CoreJSONUtils.getInt(object, "staticSaleBqcStatus")));
			item.setDynamicSaleBqcStatus(JczqDynamicSaleStatus.getItem(CoreJSONUtils.getInt(object, "dynamicSaleBqcStatus")));
			jczqScheduleItems.add(item);
		}
		return jczqScheduleItems;
	}
}
