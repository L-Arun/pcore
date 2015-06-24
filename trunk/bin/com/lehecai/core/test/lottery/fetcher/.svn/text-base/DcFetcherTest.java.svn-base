package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.dc.impl.CommonDcLotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.dc.impl.CommonDcScheduleFetcher;
/**
 * 单场抓取测试类
 * @author leiming
 *
 */
public class DcFetcherTest {
	private static final Logger logger = LoggerFactory.getLogger(DcFetcherTest.class.getName());
	public static void main(String[] args){
		try{
			CommonDcScheduleFetcher commonDcScheduleFetcher = new CommonDcScheduleFetcher();
			commonDcScheduleFetcher.fetch(null);//当前期
			commonDcScheduleFetcher.fetch("101009");
			commonDcScheduleFetcher.fetch("101008");
			commonDcScheduleFetcher.fetch("1242额");
			logger.info("==========抓取赛程测试结束");
			
			CommonDcLotteryDrawFetcher commonDcLotteryDrawFetcher = new CommonDcLotteryDrawFetcher();
			commonDcLotteryDrawFetcher.fetch(null);//当前期
			commonDcLotteryDrawFetcher.fetch("101008");
			commonDcLotteryDrawFetcher.fetch("101009");
			commonDcLotteryDrawFetcher.fetch("101007");
			commonDcLotteryDrawFetcher.fetch("9567");
			logger.info("==========抓取单场开奖结果测试结束");
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
	}
}
