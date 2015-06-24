package com.lehecai.core.lottery.fetcher.dc.impl.worker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.DcSPType;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.dc.AbstractDcInstantSPFetcherWorker;
import com.lehecai.core.lottery.fetcher.dc.DcInstantSPItem;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreHttpUtils;
import com.lehecai.core.util.CoreJSONUtils;

/**
 * 北单pengineAPI抓取实现类
 * @author qatang
 *
 */
public class CommonDcInstantSPFetchWorkerPengineAPI extends AbstractDcInstantSPFetcherWorker{
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private static final String PROCESS_CODE = "10002"; 
	
	private static final String URL_PENGINE_API = "http://phase.lehecai.com:16041/LsshServlet";
	//private static final String URL_PENGINE_API = "http://119.255.59.115:11108/pengine/LsshServlet";

	@SuppressWarnings("unchecked")
	public List<DcInstantSPItem> fetchDcInstantSP(String phase,LotteryType lotteryType){
		List<String> list = null;
		try {
			list = CoreHttpUtils.getUrl(URL_PENGINE_API, "ProcessCode=" + PROCESS_CODE + "&phase=" + phase + "&lotteryType=" + lotteryType.getValue(), CharsetConstant.CHARSET_UTF8, 100000);
		} catch (Exception e) {
			logger.error("北京单场抓取官方即时sp失败", e);
			return null;
		}
		if (list == null || list.size() == 0) {
			logger.error("北京单场抓取官方即时sp失败");
			return null;
		}
		String matches = list.get(0);
		if (matches == null || "".equals(matches)) {
			logger.error("未获取到北京单场官方即时sp");
			return null;
		}
		JSONArray jsonArray = JSONArray.fromObject(matches);
		if (jsonArray.isEmpty()) {
			logger.error("未获取到北京单场官方即时sp");
			return null;
		}
		List<DcInstantSPItem> spList = new ArrayList<DcInstantSPItem>();
		for (Iterator iterator = jsonArray.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			
			if (object == null) {
				return null;
			}
			DcInstantSPItem item = new DcInstantSPItem();
			
			item.setPhase(object.getString("phase"));
			item.setMatchIndex(object.getInt("matchIndex"));
			item.setLeague(object.getString("league"));
			item.setHomeTeam(object.getString("homeTeam"));
			item.setAwayTeam(object.getString("awayTeam"));
			
			String spmap = object.getString("spmap");
			JSONObject spObj = JSONObject.fromObject(spmap);
			
			Map<DcSPType, String> map = new HashMap<DcSPType, String>();
			if (lotteryType.getValue() == LotteryType.DC_SFP.getValue()) {
				map.put(DcSPType.SFP_S, CoreJSONUtils.getString(spObj, "sfp_s"));
				map.put(DcSPType.SFP_F, CoreJSONUtils.getString(spObj, "sfp_f"));
				map.put(DcSPType.SFP_P, CoreJSONUtils.getString(spObj, "sfp_p"));
			} else if (lotteryType.getValue() == LotteryType.DC_SXDS.getValue()) {
				map.put(DcSPType.SXDS_SD, CoreJSONUtils.getString(spObj, "sxds_sd"));
				map.put(DcSPType.SXDS_SS, CoreJSONUtils.getString(spObj, "sxds_ss"));
				map.put(DcSPType.SXDS_XD, CoreJSONUtils.getString(spObj, "sxds_xd"));
				map.put(DcSPType.SXDS_XS, CoreJSONUtils.getString(spObj, "sxds_xs"));
			} else if (lotteryType.getValue() == LotteryType.DC_JQS.getValue()) {
				map.put(DcSPType.JQS_0, CoreJSONUtils.getString(spObj, "jqs_0"));
				map.put(DcSPType.JQS_1, CoreJSONUtils.getString(spObj, "jqs_1"));
				map.put(DcSPType.JQS_2, CoreJSONUtils.getString(spObj, "jqs_2"));
				map.put(DcSPType.JQS_3, CoreJSONUtils.getString(spObj, "jqs_3"));
				map.put(DcSPType.JQS_4, CoreJSONUtils.getString(spObj, "jqs_4"));
				map.put(DcSPType.JQS_5, CoreJSONUtils.getString(spObj, "jqs_5"));
				map.put(DcSPType.JQS_6, CoreJSONUtils.getString(spObj, "jqs_6"));
				map.put(DcSPType.JQS_7, CoreJSONUtils.getString(spObj, "jqs_7"));
			} else if (lotteryType.getValue() == LotteryType.DC_BF.getValue()) {
				map.put(DcSPType.BF_F_01, CoreJSONUtils.getString(spObj, "bf_f_01"));
				map.put(DcSPType.BF_F_02, CoreJSONUtils.getString(spObj, "bf_f_02"));
				map.put(DcSPType.BF_F_03, CoreJSONUtils.getString(spObj, "bf_f_03"));
				map.put(DcSPType.BF_F_04, CoreJSONUtils.getString(spObj, "bf_f_04"));
				map.put(DcSPType.BF_F_12, CoreJSONUtils.getString(spObj, "bf_f_12"));
				map.put(DcSPType.BF_F_13, CoreJSONUtils.getString(spObj, "bf_f_13"));
				map.put(DcSPType.BF_F_14, CoreJSONUtils.getString(spObj, "bf_f_14"));
				map.put(DcSPType.BF_F_23, CoreJSONUtils.getString(spObj, "bf_f_23"));
				map.put(DcSPType.BF_F_24, CoreJSONUtils.getString(spObj, "bf_f_24"));
				map.put(DcSPType.BF_F_Other, CoreJSONUtils.getString(spObj, "bf_f_other"));
				map.put(DcSPType.BF_P_0, CoreJSONUtils.getString(spObj, "bf_p_0"));
				map.put(DcSPType.BF_P_1, CoreJSONUtils.getString(spObj, "bf_p_1"));
				map.put(DcSPType.BF_P_2, CoreJSONUtils.getString(spObj, "bf_p_2"));
				map.put(DcSPType.BF_P_3, CoreJSONUtils.getString(spObj, "bf_p_3"));
				map.put(DcSPType.BF_P_Other, CoreJSONUtils.getString(spObj, "bf_p_other"));
				map.put(DcSPType.BF_S_10, CoreJSONUtils.getString(spObj, "bf_s_10"));
				map.put(DcSPType.BF_S_20, CoreJSONUtils.getString(spObj, "bf_s_20"));
				map.put(DcSPType.BF_S_30, CoreJSONUtils.getString(spObj, "bf_s_30"));
				map.put(DcSPType.BF_S_40, CoreJSONUtils.getString(spObj, "bf_s_40"));
				map.put(DcSPType.BF_S_21, CoreJSONUtils.getString(spObj, "bf_s_21"));
				map.put(DcSPType.BF_S_31, CoreJSONUtils.getString(spObj, "bf_s_31"));
				map.put(DcSPType.BF_S_41, CoreJSONUtils.getString(spObj, "bf_s_41"));
				map.put(DcSPType.BF_S_32, CoreJSONUtils.getString(spObj, "bf_s_32"));
				map.put(DcSPType.BF_S_42, CoreJSONUtils.getString(spObj, "bf_s_42"));
				map.put(DcSPType.BF_S_Other, CoreJSONUtils.getString(spObj, "bf_s_other"));
			} else if (lotteryType.getValue() == LotteryType.DC_BCSFP.getValue()) {
				map.put(DcSPType.BCSFP_FF, CoreJSONUtils.getString(spObj, "bcsfp_ff"));
				map.put(DcSPType.BCSFP_FP, CoreJSONUtils.getString(spObj, "bcsfp_fp"));
				map.put(DcSPType.BCSFP_FS, CoreJSONUtils.getString(spObj, "bcsfp_fs"));
				map.put(DcSPType.BCSFP_PF, CoreJSONUtils.getString(spObj, "bcsfp_pf"));
				map.put(DcSPType.BCSFP_PP, CoreJSONUtils.getString(spObj, "bcsfp_pp"));
				map.put(DcSPType.BCSFP_PS, CoreJSONUtils.getString(spObj, "bcsfp_ps"));
				map.put(DcSPType.BCSFP_SF, CoreJSONUtils.getString(spObj, "bcsfp_sf"));
				map.put(DcSPType.BCSFP_SP, CoreJSONUtils.getString(spObj, "bcsfp_sp"));
				map.put(DcSPType.BCSFP_SS, CoreJSONUtils.getString(spObj, "bcsfp_ss"));
			}
			item.setSpmap(map);
			
			spList.add(item);
		}
		return spList;
	}
}
