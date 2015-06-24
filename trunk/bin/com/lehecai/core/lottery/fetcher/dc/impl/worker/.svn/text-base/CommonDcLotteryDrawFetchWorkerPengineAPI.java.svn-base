package com.lehecai.core.lottery.fetcher.dc.impl.worker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.dc.AbstractDcLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.dc.DcLotteryDrawItem;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreFetcherUtils;

/**
 * 从PEngine抓取开奖结果，主要抓取精确的开奖SP值。
 * @author Sunshow
 *    
 */
public class CommonDcLotteryDrawFetchWorkerPengineAPI extends
		AbstractDcLotteryDrawFetchWorker {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private static final String PROCESS_CODE = "10001"; 
	
	private static final String URL_PENGINE_API = "http://phase.lehecai.com:16041/LsshServlet";
	//private static final String URL_PENGINE_API = "http://172.16.10.195:8080/pengine/LsshServlet";
	
	@Override
	public List<DcLotteryDrawItem> fetchDcLotteryDraw(String phase) {
		if (phase == null || phase.equals("")) {
			logger.error("不支持未指定彩期的抓取");
			return null;
		}
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("ProcessCode", PROCESS_CODE);
		params.put("phase", phase);
		
		String html = CoreFetcherUtils.URLGet(URL_PENGINE_API, params, CharsetConstant.CHARSET_UTF8);
		
		JSONArray jsonArray = null;
		try {
			jsonArray = JSONArray.fromObject(html);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if (jsonArray == null) {
			logger.error("未抓取到开奖结果");
			return null;
		}
		
		List<DcLotteryDrawItem> items = new ArrayList<DcLotteryDrawItem>();
		for (Object object : jsonArray) {
			JSONObject jsonObject = null;
			try {
				jsonObject = (JSONObject)object;
			} catch (Exception e) {
				logger.error("转换数据出错: {}", object);
				continue;
			}
			if (jsonObject == null) {
				continue;
			}
			try {
				DcLotteryDrawItem item = (DcLotteryDrawItem)JSONObject.toBean(jsonObject, DcLotteryDrawItem.class);
				items.add(item);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}

		return items;
	}

}
