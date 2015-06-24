package com.lehecai.core.lottery.fetcher.jclq.impl.worker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.FetchFailedException;
import com.lehecai.core.lottery.JclqDynamicSaleStatus;
import com.lehecai.core.lottery.JclqRaceStatus;
import com.lehecai.core.lottery.JclqStaticSaleStatus;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jclq.AbstractJclqScheduleFetchWorker;
import com.lehecai.core.lottery.fetcher.jclq.JclqScheduleItem;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreHttpUtils;
import com.lehecai.core.util.CoreJSONUtils;
import com.lehecai.core.util.lottery.JclqUtil;

/**
 * 通用竞彩篮球赛程抓取实现类
 * @author qatang
 *
 */
public class CommonJclqScheduleFetchWorkerPengineAPI extends AbstractJclqScheduleFetchWorker{
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private static final String PROCESS_CODE = "10001"; 
	
	private static final String URL_PENGINE_API = "http://phase.lehecai.com:16041/JclqServlet";
	//private static final String URL_PENGINE_API = "http://172.16.10.195:8080/pengine/JclqServlet";

	@SuppressWarnings("unchecked")
	@Override
	public List<JclqScheduleItem> fetchJclqSchedule(String officialDate) throws FetchFailedException {
		List<String> list = null;
		try {
			list = CoreHttpUtils.getUrl(URL_PENGINE_API, "ProcessCode=" + PROCESS_CODE, CharsetConstant.CHARSET_UTF8, 100000);
		} catch (Exception e) {
			logger.error("竞彩篮球抓取官方赛程失败", e);
			throw new FetchFailedException(e.getMessage());
		}
		if (list == null || list.size() == 0) {
			logger.error("未获取到竞彩篮球官方赛程");
			throw new FetchFailedException("未获取到竞彩篮球官方赛程");
		}
		String matches = list.get(0);
		if (matches == null || "".equals(matches)) {
			logger.error("未获取到竞彩篮球官方赛程");
			throw new FetchFailedException("未获取到竞彩篮球官方赛程");
		}
		JSONArray jsonArray = null;
		try {
			jsonArray = JSONArray.fromObject(matches);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		if (jsonArray == null) {
			logger.error("转换竞彩篮球官方赛程出错");
			throw new FetchFailedException("转换竞彩篮球官方赛程出错");
		}
		if (jsonArray.isEmpty()) {
			logger.warn("竞彩篮球官方赛程为空");
			return null;
		}
		List<JclqScheduleItem> jclqScheduleItems = new ArrayList<JclqScheduleItem>();
		for (Iterator iterator = jsonArray.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			
			if (object == null) {
				throw new FetchFailedException("转换竞彩篮球官方赛程出错");
			}
			JclqScheduleItem item = new JclqScheduleItem();
			
			item.setMatchNum(CoreJSONUtils.getString(object, "matchNum"));
			item.setOfficialNum(CoreJSONUtils.getInt(object, "officialNum"));
			item.setOfficialDate(CoreJSONUtils.getDate(object, "officialDate", "yyyyMMdd"));
			item.setMatchName(JclqUtil.convertMatchName(CoreJSONUtils.getString(object, "matchName"), LotteryType.JCLQ_SF, FetcherType.T_PENGINEAPI));
			item.setMatchDate(CoreJSONUtils.getDate(object, "matchDate", "yyyyMMddHHmmss"));
			item.setHomeTeam(CoreJSONUtils.getString(object, "homeTeam"));
			item.setAwayTeam(CoreJSONUtils.getString(object, "awayTeam"));
			item.setDynamicHandicap(CoreJSONUtils.getString(object, "dynamicHandicap"));
			item.setStaticHandicap(CoreJSONUtils.getString(object, "staticHandicap"));
			item.setDynamicPresetScore(CoreJSONUtils.getString(object, "dynamicPresetScore"));
			item.setStaticPresetScore(CoreJSONUtils.getString(object, "staticPresetScore"));
			item.setStatus(JclqRaceStatus.getItem(CoreJSONUtils.getInt(object, "status")));
			item.setStaticSaleSfStatus(JclqStaticSaleStatus.getItem(CoreJSONUtils.getInt(object, "staticSaleSfStatus")));
			item.setDynamicSaleSfStatus(JclqDynamicSaleStatus.getItem(CoreJSONUtils.getInt(object, "dynamicSaleSfStatus")));
			item.setStaticSaleRfsfStatus(JclqStaticSaleStatus.getItem(CoreJSONUtils.getInt(object, "staticSaleRfsfStatus")));
			item.setDynamicSaleRfsfStatus(JclqDynamicSaleStatus.getItem(CoreJSONUtils.getInt(object, "dynamicSaleRfsfStatus")));
			item.setStaticSaleSfcStatus(JclqStaticSaleStatus.getItem(CoreJSONUtils.getInt(object, "staticSaleSfcStatus")));
			item.setDynamicSaleSfcStatus(JclqDynamicSaleStatus.getItem(CoreJSONUtils.getInt(object, "dynamicSaleSfcStatus")));
			item.setStaticSaleDxfStatus(JclqStaticSaleStatus.getItem(CoreJSONUtils.getInt(object, "staticSaleDxfStatus")));
			item.setDynamicSaleDxfStatus(JclqDynamicSaleStatus.getItem(CoreJSONUtils.getInt(object, "dynamicSaleDxfStatus")));
			
			jclqScheduleItems.add(item);
		}
		return jclqScheduleItems;
	}
}
