/**
 * 
 */
package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONObject;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDrawPrizeItem;
import com.lehecai.core.queue.QueueConstant;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreHttpUtils;
import com.lehecai.core.util.CoreStringUtils;



/**
 * 老版客户端数据抓取
 * @author qatang
 *
 */
public class LotteryDrawFetchWorkerClient extends AbstractLotteryDrawFetchWorker {
	
	private final static String CLIENT_FETCHER_URL = "http://www.lehecai.com/lottery/lotteryTermQueryForJsonPrize.jhtml";
	
	public LotteryDrawFetchWorkerClient(LotteryType lotteryType){
		super(lotteryType);
	}
	
	@Override
	public LotteryDraw fetchResult(String phase) {
		phase = phase == null ? "" : phase;
		List<String> result;
		try {
			result = CoreHttpUtils.postUrl(CLIENT_FETCHER_URL, "lotteryType=" + this.getLotteryType().getValue() + "&phase=" + phase, CharsetConstant.CHARSET_UTF8, QueueConstant.HTTP_TIME_OUT_DEFAULT);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			return null;
		}
		if (result == null || result.isEmpty()) {
			logger.error("响应结果为空，非法");
			return null;
		}
		
		String responseStr = result.get(0);
		logger.info("Response string: {}", responseStr);
		
		// 转换unicode到可识别的中文
		responseStr = CoreStringUtils.unicodeToString(responseStr);
		
		JSONObject json = null;
		try {
			json = JSONObject.fromObject(responseStr);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
		LotteryDraw lotteryDraw = new LotteryDraw();
		lotteryDraw.setLotteryType(LotteryType.getItem(json.getInt("lotteryType")));
		lotteryDraw.setPhase(json.getString("phase"));
		lotteryDraw.setResult(json.getString("result"));
		lotteryDraw.setResultDetail(LotteryDrawPrizeItem.convertFromJsonObjectString(responseStr));
		lotteryDraw.setVolumeOfSales(json.getString("volumeOfSales"));
		lotteryDraw.setJackpot(json.getString("jackpot"));
		lotteryDraw.setTimeDraw(json.getString("timeDraw"));
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
