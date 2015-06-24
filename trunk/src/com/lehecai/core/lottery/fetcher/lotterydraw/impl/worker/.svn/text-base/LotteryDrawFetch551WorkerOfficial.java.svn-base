package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDrawPrizeItem;
import com.lehecai.core.util.CoreFetcherUtils;

/**
 * 深圳彩票网 开奖结果抓取
 * 抓取深圳风采  <br/>
 * 历史地址:http://hbfc.cnhubei.com/22x5/index.shtml  <br/>
 * @author liurd
 *
 */
public class LotteryDrawFetch551WorkerOfficial extends AbstractLotteryDrawFetchWorker {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	//http://kaijiang.2caipiao.com/pages/allopenprized/detail_shenzhen.jsp?category=citylottery&lotteryType=szfc&issueNo=2011064&cityArea=shenzhen
	protected static final String RESULT_LOCALITY_URL = "http://kaijiang.2caipiao.com/allopenprized/historyprizedetail/history/df/0/504/szfc.html";
	protected static final String RESULT_MORE_LOCALITY_URL = "http://kaijiang.2caipiao.com/allopenprized/historyprizedetail/putong/504/";
	
	protected String siteName = "深圳彩票网";
	protected String lotteryScope = "深圳风采";
	
	public LotteryDrawFetch551WorkerOfficial() {
		super(LotteryType.A_SZFC);
	}
	
	@Override
	public LotteryDraw fetchResultDetail(String phase) {
		if (phase == null || "".equals(phase)) {
			phase = nowPhase();
		}
		if (phase == null || "".equals(phase)) {
			logger.error("==获取彩期错误==");
			return null;
		}
		LotteryDraw lotteryDraw = null;
		
		String url = RESULT_MORE_LOCALITY_URL + phase + ".html";
		
		String data = null;
		String pageInfo = "结果页面" + url;
		String encoding = "GBK";
		String logHeader = "==" + lotteryScope + "==" + siteName + "=="
				+ pageInfo + "==抓取==" + getLotteryType().getName() + "==";

		try {
			data = CoreFetcherUtils.URLGet(url, null, encoding);
		} catch (Exception e) {
			logger.error("获取html数据失败" + e.getMessage());
			return null;
		}
		
		if (data == null || data.indexOf("404 Not Found") > 0 || data.isEmpty()) {
			logger.error(logHeader + "data is null or 404 Not Found");
			return null;
		}	
		try{
			NumberFormat myformat = NumberFormat.getInstance();
			myformat.setGroupingUsed(false);
			myformat.setMaximumFractionDigits(0);	//设置最多小数位数
			myformat.setMinimumFractionDigits(0);	//设置最少小数位数
			
			JSONObject json = JSONObject.fromObject(data).getJSONObject("result");
			lotteryDraw = new LotteryDraw();
			lotteryDraw.setJackpot(myformat.format(Double.parseDouble(json.getString("pool").replace("￥", "").replace(",", ""))).toString());
			lotteryDraw.setPhase(phase);
			lotteryDraw.setLotteryType(getLotteryType());
			lotteryDraw.setVolumeOfSales(myformat.format(Double.parseDouble(json.getString("sales").replace("￥", "").replace(",", ""))));
			lotteryDraw.setTimeDraw(json.getString("updateTime") + " 00:00:00");
			String result = json.getString("issueCode");
			result = result.replace("|", ",");
			lotteryDraw.setResult(result);
			
			JSONArray jsonArray = json.getJSONArray("prize");
			List<LotteryDrawPrizeItem> lotteryDrawPrizeItemList = new ArrayList<LotteryDrawPrizeItem>();
			for (int i = 0; i < jsonArray.size(); i ++) {
				JSONArray tmp = jsonArray.getJSONArray(i);
				LotteryDrawPrizeItem lotteryDrawPrizeItem = new LotteryDrawPrizeItem(); 
				lotteryDrawPrizeItem.setName(tmp.getString(3));
				lotteryDrawPrizeItem.setPrizeAmount(myformat.format(Double.parseDouble(tmp.getString(0).replace("￥", "").replace(",", ""))));
				lotteryDrawPrizeItem.setWinningCount(tmp.getString(1));
				lotteryDrawPrizeItemList.add(lotteryDrawPrizeItem);
			}
			lotteryDraw.setResultDetail(lotteryDrawPrizeItemList);
		} catch (Exception e) {
			logger.error("数据解析错误==" + e.getMessage(), e);
			return null;
		}
		return lotteryDraw;
	}

	private String nowPhase() {
		String url = RESULT_LOCALITY_URL;
		
		String data = null;
		String pageInfo = "结果页面" + url;
		String encoding = "gbk";
		String logHeader = "==" + lotteryScope + "==" + siteName + "=="
				+ pageInfo + "==抓取==" + getLotteryType().getName() + "==";

		try {
			data = CoreFetcherUtils.URLGet(url, null, encoding);
		} catch (Exception e) {
			logger.error("获取html数据失败" + e.getMessage());
			return null;
		}
		
		if (data == null || data.indexOf("404 Not Found") > 0 || data.isEmpty()) {
			logger.error(logHeader + "data is null or 404 Not Found");
			return null;
		}	
		try {
			JSONObject json = JSONObject.fromObject(data);
			JSONArray jsonArray = json.getJSONObject("result").getJSONArray("historyCodes");
			JSONArray array = JSONArray.fromObject(jsonArray.get(0));
			return array.get(0).toString();
		} catch (Exception e) {
			logger.error("获取当前彩期错误");
			return null;
		}
	}

	@Override
	public LotteryDraw fetchResult(String phase) {
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
