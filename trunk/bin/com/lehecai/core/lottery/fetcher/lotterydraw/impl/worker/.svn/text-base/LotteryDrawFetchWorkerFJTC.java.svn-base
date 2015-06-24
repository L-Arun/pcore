package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.util.NodeList;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreHttpUtils;
import com.lehecai.core.util.CoreStringUtils;

/**
 * 福建体彩官网抓取
 * @author Sunshow
 *
 */
public abstract class LotteryDrawFetchWorkerFJTC extends AbstractLotteryDrawFetchWorker{

	protected static final String BASE_URL = "http://www.fjtc.com.cn/Notice-%s";
	protected static final String PHASE_REQUEST_URL = "http://www.fjtc.com.cn/Notice-%s?NO=%s";
	
	private static Map<LotteryType, String> lotteryValueMap = new HashMap<LotteryType, String>();
	
	static {
		lotteryValueMap.put(LotteryType.A_FJ22, "2205");
		lotteryValueMap.put(LotteryType.A_FJ31, "3107");
		lotteryValueMap.put(LotteryType.A_FJ36, "3607");
	}
	
	protected boolean isSupportedLotteryType(LotteryType lotteryType) {
		return lotteryValueMap.containsKey(lotteryType);
	}
	
	public LotteryDrawFetchWorkerFJTC(LotteryType lotteryType){
		super(lotteryType);
	}
	
	@Override
	public LotteryDraw fetchResult(String phase) {
		return null;
	}

	@Override
	public LotteryDraw fetchResultDetail(String phase) {
		
		LotteryType lotteryType = this.getLotteryType();
		
		if (!isSupportedLotteryType(lotteryType)) {
			logger.error("不支持的彩种抓取, lotteryType={}", lotteryType.getName());
			return null;
		}
		
		String encoding = CharsetConstant.CHARSET_UTF8;
		
		logger.info("要抓取的彩期号={}, lotteryType={}", phase, lotteryType.getName());
		
		String url = this.getResultDetailUrl(phase);
		logger.info("从福建体彩列表页面抓取开奖结果号码开始, url={}", url);
		
		String html = null;
		try {
			List<String> result = CoreHttpUtils.getUrl(url, "", encoding, 30000);
			html = CoreStringUtils.join(result, "");
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		
		if (html == null) {
			logger.error("抓取开奖结果内容出错, lotteryType={}, phase={}", lotteryType.getName(), phase);
			return null;
		}
		
		try {
			Parser parser = Parser.createParser(html, encoding);
			NodeFilter filter = new HasAttributeFilter("class", "artCon KJDetail");
			NodeList nodeList = parser.extractAllNodesThatMatch(filter);
			if (nodeList.size() > 0) {
				LotteryDraw lotteryDraw = parseLotteryDrawResult(nodeList.elementAt(0).toHtml());
				if (lotteryDraw != null) {
					if (phase != null && !phase.equals(lotteryDraw.getPhase())) {
						logger.error("抓取到的彩期不匹配, fetchedPhase={}, phase={}", lotteryDraw.getPhase(), phase);
						return null;
					}
				}
				return lotteryDraw;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return null;
	}
	
	abstract protected LotteryDraw parseLotteryDrawResult(String html);

	@Override
	protected String getResultDetailUrl(String phase) {
		LotteryType lotteryType = this.getLotteryType();
		
		if (!isSupportedLotteryType(lotteryType)) {
			logger.error("不支持的彩种抓取, lotteryType={}", lotteryType.getName());
			return null;
		}
		
		String lotId = lotteryValueMap.get(lotteryType);
		
		if (phase == null || phase.equals("")) {
			return String.format(BASE_URL, lotId);
		}
		return String.format(PHASE_REQUEST_URL, lotId, phase);
	}

	@Override
	protected String getResultUrl(String phase) {
		return null;
	}
	
}
