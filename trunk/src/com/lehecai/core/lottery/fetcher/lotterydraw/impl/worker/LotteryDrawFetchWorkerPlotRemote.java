package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDrawPrizeItem;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreFetcherUtils;
import com.lehecai.core.util.CoreStringUtils;



/**
 * Plot远程开奖结果抓取
 * @author leiming
 *
 */
public class LotteryDrawFetchWorkerPlotRemote extends AbstractLotteryDrawFetchWorker {

	protected static final String RESULT_URL = "http://www.lehecai.com/api/draw/draw.php";
	
	public LotteryDrawFetchWorkerPlotRemote(LotteryType lotteryType){
		super(lotteryType);
	}
	
	@Override
	public LotteryDraw fetchResult(String phase) {
		LotteryType lotteryType = this.getLotteryType();
		String url = RESULT_URL;
		String encoding = CharsetConstant.CHARSET_UTF8;
		String logHeader = "==抓取==" + lotteryType.getName() + "==";
		logger.info(logHeader+"开始==");
		
		String data = null;
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("lotteryType", String.valueOf(getLotteryType().getValue()));
		if (phase != null) {
			params.put("phase", phase);
		}
		
		data = CoreFetcherUtils.URLGet(url, params, encoding);
		if (data == null || data.indexOf(CoreFetcherUtils.PLOT_REMOTE_FETCH_ERROR) >= 0 || data.isEmpty()) {
			logger.error(logHeader+"data is null or "+CoreFetcherUtils.PLOT_REMOTE_FETCH_ERROR);
			return null;
		}
		
		data = CoreStringUtils.unicodeToString(data);
		
		JSONObject json = null;
		try {
			json = JSONObject.fromObject(data);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
		
		LotteryDraw lotteryDraw = new LotteryDraw();
		lotteryDraw.setLotteryType(LotteryType.getItem(json.getInt("lotteryType")));
		lotteryDraw.setPhase(json.getString("phase"));
		lotteryDraw.setResult(json.getString("result"));
		// 解析中奖详情
		lotteryDraw.setResultDetail(LotteryDrawPrizeItem.convertFromJSONArray(json.getJSONArray("resultDetail")));
		
		lotteryDraw.setVolumeOfSales(json.getString("volumeOfSales"));
		lotteryDraw.setJackpot(json.getString("jackpot"));
		lotteryDraw.setTimeDraw(json.getString("timeDraw"));
		
		logger.info(logHeader + "结束==");
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
