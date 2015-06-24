package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.LotteryDrawFetcher1;

/**
 * 抓取转换使用样例
 * 该类只是展示如果应用转换,具体的功能要在具体项目中实现
 * @author leiming
 *
 */
public class FetcherLotteryDrawConverterTest {
	private static final Logger logger = LoggerFactory.getLogger(FetcherLotteryDrawConverterTest.class.getName());
	
	public static void main(String[] args) {
		try {
			LotteryType lotteryType = LotteryType.DLT;
			ILotteryDrawFetcher lotteryFetcher = new LotteryDrawFetcher1();
			LotteryDraw lotteryDraw = null;
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10111",FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10111",FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			logger.info("=============抓取完毕===================");
			
			/*
			LotteryConfig config = null;
			//两种方式获取
			//第一种 缓存
			config = LotteryConfigCache.getLotteryConfig(lotteryType);
			//第二种  自己创建配置
			LotteryConfigCacheBuilder builder = new LotteryConfigCacheBuilder();
			config = builder.build(lotteryType);
			
			//根据模板配置转换抓取的开奖结果为json字符串对象
			lotteryDraw = FetcherLotteryDrawConverter.convertFetchResult2JsonString(lotteryDraw, config);
			//根据彩票配置转换抓取的奖项name为对应key
			lotteryDraw = FetcherLotteryDrawConverter.convertFetchResultDetailPrizeItemName2Key(lotteryDraw, config);
			
			//以上为单独转换
			//转换抓取开奖结果数据的开奖结果,奖项名称
			lotteryDraw = FetcherLotteryDrawConverter.convertFetcherLotteryDraw(lotteryDraw, config);
			//可根据具体需要调用具体方法
			*/
		} catch(Exception e) {
			logger.error(e.getMessage(),e);
		}
		
	}
}
