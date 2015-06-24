package com.lehecai.core.lottery.fetcher.jczq.impl.worker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.JczqSPType;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jczq.AbstractJczqStaticInstantSpFetchWorker;
import com.lehecai.core.lottery.fetcher.jczq.JczqStaticInstantSpItem;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreHttpUtils;
import com.lehecai.core.util.CoreJSONUtils;
import com.lehecai.core.util.lottery.JczqUtil;

/**
 * 通用竞彩足球固定奖金即时sp抓取实现类
 * @author qatang
 *
 */
public class CommonJczqStaticInstantSpFetchWorkerPengineAPI extends AbstractJczqStaticInstantSpFetchWorker{
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private static final String PROCESS_CODE = "10004"; 
	
	private static final String URL_PENGINE_API = "http://phase.lehecai.com:16041/JczqServlet";
    //private static final String URL_PENGINE_API = "http://172.16.10.195:8080/pengine/JczqServlet";

	@SuppressWarnings("unchecked")
	public List<JczqStaticInstantSpItem> fetchJczqSp(String officialDate, LotteryType lotteryType){
		if (officialDate == null || "".equals(officialDate)) {
			logger.error("竞彩足球抓取官方sp时，officialDate为空");
			return null;
		}
		
		List<String> list = null;
		try {
			list = CoreHttpUtils.getUrl(URL_PENGINE_API, "ProcessCode=" + PROCESS_CODE + "&officialDate=" + officialDate + "&lotteryType=" + lotteryType.getValue(), CharsetConstant.CHARSET_UTF8, 100000);
		} catch (Exception e) {
			logger.error("竞彩足球抓取官方固定奖金即时sp失败", e);
			return null;
		}
		if (list == null || list.size() == 0) {
			logger.error("竞彩足球抓取官方固定奖金即时sp失败");
			return null;
		}
		String matches = list.get(0);
		if (matches == null || "".equals(matches)) {
			logger.error("未获取到竞彩足球官方固定奖金即时sp");
			return null;
		}
		JSONArray jsonArray = JSONArray.fromObject(matches);
		if (jsonArray.isEmpty()) {
			logger.error("未获取到竞彩足球官方固定奖金即时sp");
			return null;
		}
		List<JczqStaticInstantSpItem> jczqStaticInstantSpItems = new ArrayList<JczqStaticInstantSpItem>();
		for (Iterator iterator = jsonArray.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			if (object == null) {
				return null;
			}
			JczqStaticInstantSpItem item = new JczqStaticInstantSpItem();
			
			item.setMatchNum(CoreJSONUtils.getString(object, "matchNum"));
			item.setOfficialNum(CoreJSONUtils.getString(object, "officialNum"));
			item.setOfficialDate(CoreJSONUtils.getDate(object, "officialDate", "yyyyMMdd"));
			item.setMatchName(JczqUtil.convertMatchName(CoreJSONUtils.getString(object, "matchName"), LotteryType.JCZQ_SPF, FetcherType.T_PENGINEAPI));
			item.setMatchDate(CoreJSONUtils.getDate(object, "matchDate", "yyyyMMddHHmmss"));
			item.setHomeTeam(CoreJSONUtils.getString(object, "homeTeam"));
			item.setAwayTeam(CoreJSONUtils.getString(object, "awayTeam"));
			
			String spmap = CoreJSONUtils.getString(object, "spmap");
			JSONObject spObj = JSONObject.fromObject(spmap);
			
			Map<JczqSPType, String> map = new HashMap<JczqSPType, String>();
			if (lotteryType.getValue() == LotteryType.JCZQ_SPF.getValue()) {
				map.put(JczqSPType.SPF_S, CoreJSONUtils.getString(spObj, "spf_s"));
				map.put(JczqSPType.SPF_P, CoreJSONUtils.getString(spObj, "spf_p"));
				map.put(JczqSPType.SPF_F, CoreJSONUtils.getString(spObj, "spf_f"));
				//map.put(JczqSPType.SPF_RQ, CoreJSONUtils.getString(spObj, "spf_rq"));
			} else if (lotteryType.getValue() == LotteryType.JCZQ_BF.getValue()) {
				map.put(JczqSPType.BF_ZS_1_0, CoreJSONUtils.getString(spObj, "bf_zs_1_0"));
				map.put(JczqSPType.BF_ZS_2_0, CoreJSONUtils.getString(spObj, "bf_zs_2_0"));
				map.put(JczqSPType.BF_ZS_2_1, CoreJSONUtils.getString(spObj, "bf_zs_2_1"));
		        map.put(JczqSPType.BF_ZS_3_0, CoreJSONUtils.getString(spObj, "bf_zs_3_0"));
				map.put(JczqSPType.BF_ZS_3_1, CoreJSONUtils.getString(spObj, "bf_zs_3_1"));
				map.put(JczqSPType.BF_ZS_3_2, CoreJSONUtils.getString(spObj, "bf_zs_3_2"));
		        map.put(JczqSPType.BF_ZS_4_0, CoreJSONUtils.getString(spObj, "bf_zs_4_0"));
				map.put(JczqSPType.BF_ZS_4_1, CoreJSONUtils.getString(spObj, "bf_zs_4_1"));
				map.put(JczqSPType.BF_ZS_4_2, CoreJSONUtils.getString(spObj, "bf_zs_4_2"));
		        map.put(JczqSPType.BF_ZS_5_0, CoreJSONUtils.getString(spObj, "bf_zs_5_0"));
				map.put(JczqSPType.BF_ZS_5_1, CoreJSONUtils.getString(spObj, "bf_zs_5_1"));
				map.put(JczqSPType.BF_ZS_5_2, CoreJSONUtils.getString(spObj, "bf_zs_5_2"));
		        map.put(JczqSPType.BF_ZS_QT, CoreJSONUtils.getString(spObj, "bf_zs_qt"));
				map.put(JczqSPType.BF_ZP_0_0, CoreJSONUtils.getString(spObj, "bf_zp_0_0"));
				map.put(JczqSPType.BF_ZP_1_1, CoreJSONUtils.getString(spObj, "bf_zp_1_1"));
		        map.put(JczqSPType.BF_ZP_2_2, CoreJSONUtils.getString(spObj, "bf_zp_2_2"));
				map.put(JczqSPType.BF_ZP_3_3, CoreJSONUtils.getString(spObj, "bf_zp_3_3"));
				map.put(JczqSPType.BF_ZP_QT, CoreJSONUtils.getString(spObj, "bf_zp_qt"));
				map.put(JczqSPType.BF_ZF_0_1, CoreJSONUtils.getString(spObj, "bf_zf_0_1"));
		        map.put(JczqSPType.BF_ZF_0_2, CoreJSONUtils.getString(spObj, "bf_zf_0_2"));
				map.put(JczqSPType.BF_ZF_1_2, CoreJSONUtils.getString(spObj, "bf_zf_1_2"));
				map.put(JczqSPType.BF_ZF_0_3, CoreJSONUtils.getString(spObj, "bf_zf_0_3"));
		        map.put(JczqSPType.BF_ZF_1_3, CoreJSONUtils.getString(spObj, "bf_zf_1_3"));
				map.put(JczqSPType.BF_ZF_2_3, CoreJSONUtils.getString(spObj, "bf_zf_2_3"));
				map.put(JczqSPType.BF_ZF_0_4, CoreJSONUtils.getString(spObj, "bf_zf_0_4"));
		        map.put(JczqSPType.BF_ZF_1_4, CoreJSONUtils.getString(spObj, "bf_zf_1_4"));
				map.put(JczqSPType.BF_ZF_2_4, CoreJSONUtils.getString(spObj, "bf_zf_2_4"));
				map.put(JczqSPType.BF_ZF_0_5, CoreJSONUtils.getString(spObj, "bf_zf_0_5"));
		        map.put(JczqSPType.BF_ZF_1_5, CoreJSONUtils.getString(spObj, "bf_zf_1_5"));
				map.put(JczqSPType.BF_ZF_2_5, CoreJSONUtils.getString(spObj, "bf_zf_2_5"));
				map.put(JczqSPType.BF_ZF_QT, CoreJSONUtils.getString(spObj, "bf_zf_qt"));
			} else if (lotteryType.getValue() == LotteryType.JCZQ_JQS.getValue()) {
				map.put(JczqSPType.JQS_0, CoreJSONUtils.getString(spObj, "jqs_0"));
				map.put(JczqSPType.JQS_1, CoreJSONUtils.getString(spObj, "jqs_1"));
				map.put(JczqSPType.JQS_2, CoreJSONUtils.getString(spObj, "jqs_2"));
				map.put(JczqSPType.JQS_3, CoreJSONUtils.getString(spObj, "jqs_3"));
				map.put(JczqSPType.JQS_4, CoreJSONUtils.getString(spObj, "jqs_4"));
				map.put(JczqSPType.JQS_5, CoreJSONUtils.getString(spObj, "jqs_5"));
				map.put(JczqSPType.JQS_6, CoreJSONUtils.getString(spObj, "jqs_6"));
				map.put(JczqSPType.JQS_7, CoreJSONUtils.getString(spObj, "jqs_7"));
			} else if (lotteryType.getValue() == LotteryType.JCZQ_BQC.getValue()) {
				map.put(JczqSPType.BQC_SS, CoreJSONUtils.getString(spObj, "bqc_ss"));
				map.put(JczqSPType.BQC_SP, CoreJSONUtils.getString(spObj, "bqc_sp"));
				map.put(JczqSPType.BQC_SF, CoreJSONUtils.getString(spObj, "bqc_sf"));
				map.put(JczqSPType.BQC_PS, CoreJSONUtils.getString(spObj, "bqc_ps"));
				map.put(JczqSPType.BQC_PP, CoreJSONUtils.getString(spObj, "bqc_pp"));
				map.put(JczqSPType.BQC_PF, CoreJSONUtils.getString(spObj, "bqc_pf"));
				map.put(JczqSPType.BQC_FS, CoreJSONUtils.getString(spObj, "bqc_fs"));
				map.put(JczqSPType.BQC_FP, CoreJSONUtils.getString(spObj, "bqc_fp"));
				map.put(JczqSPType.BQC_FF, CoreJSONUtils.getString(spObj, "bqc_ff"));
			}
			item.setSpmap(map);
			jczqStaticInstantSpItems.add(item);
		}
		return jczqStaticInstantSpItems;
	}
}
