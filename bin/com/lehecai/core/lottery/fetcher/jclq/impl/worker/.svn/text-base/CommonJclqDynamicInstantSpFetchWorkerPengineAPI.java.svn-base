package com.lehecai.core.lottery.fetcher.jclq.impl.worker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.JclqSPType;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jclq.AbstractJclqDynamicInstantSpFetchWorker;
import com.lehecai.core.lottery.fetcher.jclq.JclqDynamicInstantSpItem;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreHttpUtils;
import com.lehecai.core.util.CoreJSONUtils;
import com.lehecai.core.util.lottery.JclqUtil;

/**
 * 通用竞彩篮球浮动奖金即时sp抓取实现类
 * @author qatang
 *
 */
public class CommonJclqDynamicInstantSpFetchWorkerPengineAPI extends AbstractJclqDynamicInstantSpFetchWorker{
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private static final String PROCESS_CODE = "10003"; 
	
	private static final String URL_PENGINE_API = "http://phase.lehecai.com:16041/JclqServlet";
	//private static final String URL_PENGINE_API = "http://172.16.10.195:8080/pengine/JclqServlet";

	@SuppressWarnings("unchecked")
	public List<JclqDynamicInstantSpItem> fetchJclqSp(String officialDate, LotteryType lotteryType){
		if (officialDate == null || "".equals(officialDate)) {
			logger.error("竞彩篮球抓取官方sp时，officialDate为空");
			return null;
		}
		
		List<String> list = null;
		try {
			list = CoreHttpUtils.getUrl(URL_PENGINE_API, "ProcessCode=" + PROCESS_CODE + "&officialDate=" + officialDate + "&lotteryType=" + lotteryType.getValue(), CharsetConstant.CHARSET_UTF8, 100000);
		} catch (Exception e) {
			logger.error("竞彩篮球抓取官方浮动奖金即时sp失败", e);
			return null;
		}
		if (list == null || list.size() == 0) {
			logger.error("竞彩篮球抓取官方浮动奖金即时sp失败");
			return null;
		}
		String matches = list.get(0);
		if (matches == null || "".equals(matches)) {
			logger.error("未获取到竞彩篮球官方浮动奖金即时sp");
			return null;
		}
		JSONArray jsonArray = JSONArray.fromObject(matches);
		if (jsonArray.isEmpty()) {
			logger.error("未获取到竞彩篮球官方浮动奖金即时sp");
			return null;
		}
		List<JclqDynamicInstantSpItem> jclqDynamicInstantSpItems = new ArrayList<JclqDynamicInstantSpItem>();
		for (Iterator iterator = jsonArray.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			
			if (object == null) {
				return null;
			}
			JclqDynamicInstantSpItem item = new JclqDynamicInstantSpItem();
			
			item.setMatchNum(CoreJSONUtils.getString(object, "matchNum"));
			item.setOfficialNum(CoreJSONUtils.getInt(object, "officialNum"));
			item.setOfficialDate(CoreJSONUtils.getDate(object, "officialDate", "yyyyMMdd"));
			item.setMatchName(JclqUtil.convertMatchName(CoreJSONUtils.getString(object, "matchName"), LotteryType.JCLQ_SF, FetcherType.T_PENGINEAPI));
			item.setMatchDate(CoreJSONUtils.getDate(object, "matchDate", "yyyyMMddHHmmss"));
			item.setHomeTeam(CoreJSONUtils.getString(object, "homeTeam"));
			item.setAwayTeam(CoreJSONUtils.getString(object, "awayTeam"));
			
			String spmap = CoreJSONUtils.getString(object, "spmap");
			JSONObject spObj = JSONObject.fromObject(spmap);
			
			Map<JclqSPType, String> map = new HashMap<JclqSPType, String>();
			if (lotteryType.getValue() == LotteryType.JCLQ_SF.getValue()) {
				map.put(JclqSPType.SF_S, CoreJSONUtils.getString(spObj, "sf_s"));
				map.put(JclqSPType.SF_F, CoreJSONUtils.getString(spObj, "sf_f"));
			} else if (lotteryType.getValue() == LotteryType.JCLQ_RFSF.getValue()) {
				map.put(JclqSPType.RFSF_S, CoreJSONUtils.getString(spObj, "rfsf_s"));
				map.put(JclqSPType.RFSF_F, CoreJSONUtils.getString(spObj, "rfsf_f"));
			} else if (lotteryType.getValue() == LotteryType.JCLQ_SFC.getValue()) {
				map.put(JclqSPType.SFC_KS_1_5, CoreJSONUtils.getString(spObj, "sfc_ks_1_5"));
				map.put(JclqSPType.SFC_ZS_1_5, CoreJSONUtils.getString(spObj, "sfc_zs_1_5"));
				map.put(JclqSPType.SFC_KS_6_10, CoreJSONUtils.getString(spObj, "sfc_ks_6_10"));
				map.put(JclqSPType.SFC_ZS_6_10, CoreJSONUtils.getString(spObj, "sfc_zs_6_10"));
				map.put(JclqSPType.SFC_KS_11_15, CoreJSONUtils.getString(spObj, "sfc_ks_11_15"));
				map.put(JclqSPType.SFC_ZS_11_15, CoreJSONUtils.getString(spObj, "sfc_zs_11_15"));
				map.put(JclqSPType.SFC_KS_16_20, CoreJSONUtils.getString(spObj, "sfc_ks_16_20"));
				map.put(JclqSPType.SFC_ZS_16_20, CoreJSONUtils.getString(spObj, "sfc_zs_16_20"));
				map.put(JclqSPType.SFC_KS_21_25, CoreJSONUtils.getString(spObj, "sfc_ks_21_25"));
				map.put(JclqSPType.SFC_ZS_21_25, CoreJSONUtils.getString(spObj, "sfc_zs_21_25"));
				map.put(JclqSPType.SFC_KS_26, CoreJSONUtils.getString(spObj, "sfc_ks_26"));
				map.put(JclqSPType.SFC_ZS_26, CoreJSONUtils.getString(spObj, "sfc_zs_26"));
			} else if (lotteryType.getValue() == LotteryType.JCLQ_DXF.getValue()) {
				map.put(JclqSPType.DXF_S, CoreJSONUtils.getString(spObj, "dxf_s"));
				map.put(JclqSPType.DXF_F, CoreJSONUtils.getString(spObj, "dxf_f"));
			}
			
			item.setSpmap(map);
			jclqDynamicInstantSpItems.add(item);
		}
		return jclqDynamicInstantSpItems;
	}
}
