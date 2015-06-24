package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreHttpUtils;
import com.lehecai.core.util.CoreStringUtils;



/**
 * 爱彩票 开奖结果抓取
 * @author Sunshow
 *
 */
public class LotteryDrawFetchWorkerAiCaiPiao extends AbstractLotteryDrawFetchWorker {

	private static final String RESULT_FETCH_URL = "http://www.2caipiao.com/lottery/termVerify.jhtml";
	
	public LotteryDrawFetchWorkerAiCaiPiao(LotteryType lotteryType){
		super(lotteryType);
	}
	
	@Override
	public LotteryDraw fetchResult(String phase) {
		LotteryType lotteryType = this.getLotteryType();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("lotteryType", this.getLotteryType().getValue() + "");
		params.put("time", System.currentTimeMillis() + "");
		
		String response = null;
		try {
			List<String> result = CoreHttpUtils.postUrl(RESULT_FETCH_URL, params, CharsetConstant.CHARSET_GBK, 5000);
			if (result != null && !result.isEmpty()) {
				response = CoreStringUtils.join(result, "");
			}
		} catch (IOException e) {
			logger.error("抓取出错, lotteryType={},phase={}", this.getLotteryType().getName(), phase);
			logger.error(e.getMessage(), e);
			return null;
		}
		
		if (response == null) {
			logger.error("抓取出错, lotteryType={},phase={}", this.getLotteryType().getName(), phase);
			return null;
		}
		
		
		// 转换成JSON
		JSONObject jsonObject = null;
		try {
			jsonObject = JSONObject.fromObject(response);
		} catch (Exception e) {
			logger.error("转换成JSON数据出错, response={}", response);
		}
		if (jsonObject == null) {
			logger.error("无效的开奖结果");
			return null;
		}
		
		JSONArray terms = null, openResults = null;
		try {
			terms = jsonObject.getJSONArray("terms");
			openResults = jsonObject.getJSONArray("openResults");
		} catch (Exception e) {
			logger.error("从JSON数据中获取terms,openResults出错, response={}", response);
		}
		if (terms == null || openResults == null) {
			logger.error("从JSON数据中获取terms,openResults出错, response={}", response);
			return null;
		}
		
		int index = -1;
		
		if (phase == null) {
			logger.info("抓取最新期");
			if (terms.size() > 0) {
				index = 0;
			}
		} else {
			int total = terms.size() / 2;
			for (int i = 0; i < total; i++) {
				JSONObject termObject = terms.getJSONObject(i * 2);
				String term = termObject.getString("term");
				if (phase.equals(term)) {
					index = i;
					break;
				}
			}
		}
		
		if (index == -1) {
			logger.error("未找到要抓取的彩期: {},{}", lotteryType.getName(), phase);
			return null;
		}
		
		String fetchedPhase = null, fetchedResult = null, fetchedOpenTime = null;
		
		JSONObject termObj = terms.getJSONObject(index * 2);
		JSONObject resultObj = openResults.getJSONObject(index);
		
		fetchedPhase = termObj.getString("term");
		fetchedOpenTime = termObj.getString("currentOpenTime");
		fetchedResult = resultObj.getString("result");
		fetchedResult = StringUtils.replace(fetchedResult, " ", ",");
		
		LotteryDraw lotteryDraw = new LotteryDraw();
		lotteryDraw.setLotteryType(lotteryType);
		lotteryDraw.setPhase(fetchedPhase);
		lotteryDraw.setResult(fetchedResult);
		lotteryDraw.setTimeDraw(fetchedOpenTime);
		
		return lotteryDraw;
	}

	@Override
	public LotteryDraw fetchResultDetail(String phase) {
		return null;
	}

	@Override
	protected String getResultDetailUrl(String phase) {
		return null;
	}

	@Override
	protected String getResultUrl(String phase) {
		return null;
	}
}
