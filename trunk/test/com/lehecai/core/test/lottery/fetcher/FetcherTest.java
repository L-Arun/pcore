/**
 * 
 */
package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.FrequentLotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.LocalityLotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.LotteryDrawFetcher50;

/**
 * 测试
 *
 */
public class FetcherTest {

	private static final Logger logger = LoggerFactory.getLogger(FetcherTest.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			LotteryType lotteryType = null;
			LotteryDraw lotteryDraw = null;
			ILotteryDrawFetcher lotteryFetcher = null;
			//双色球
			lotteryFetcher = new LotteryDrawFetcher50();
			lotteryType = LotteryType.SSQ;
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("2010111",FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("2010111",FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			logger.info("================================");
			/*
			//七乐彩
			lotteryFetcher = new LotteryDrawFetcher51();
			lotteryType = LotteryType.QLC;
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("2010111",FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("2010111",FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			logger.info("================================");
			//福彩3D
			lotteryFetcher = new LotteryDrawFetcher52();
			lotteryType = LotteryType.FC3D;
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("2010111",FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("2010111",FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			logger.info("================================");
			//东方6+1
			lotteryFetcher = new LotteryDrawFetcher54();
			lotteryType = LotteryType.DF6J1;
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("2010111",FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("2010111",FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			logger.info("================================");
			//华东15选5
			lotteryFetcher = new LotteryDrawFetcher55();
			lotteryType = LotteryType.HD15X5;
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("2010111",FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("2010111",FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			logger.info("================================");
			//超级大乐透
			lotteryFetcher = new LotteryDrawFetcher1();
			lotteryType = LotteryType.DLT;
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10111",FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10111",FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			logger.info("================================");
			//排列三
			lotteryFetcher = new CountryLotteryDrawFetcher(LotteryType.PL3);
			lotteryType = LotteryType.PL3;
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10111",FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10111",FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			logger.info("================================");
			//排列五
			lotteryFetcher = new CountryLotteryDrawFetcher(LotteryType.PL5);
			lotteryType = LotteryType.PL5;
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10111",FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10111",FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			logger.info("================================");
			//七星彩
			lotteryFetcher = new CountryLotteryDrawFetcher(LotteryType.QXC);
			lotteryType = LotteryType.QXC;
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10111",FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10111",FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			logger.info("================================");
			//31选7 542
			lotteryFetcher = new CountryLotteryDrawFetcher(LotteryType.A_31x7);
			lotteryType = LotteryType.A_31x7;
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10111",FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10111",FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			logger.info("================================");
			//14场胜负彩
			lotteryFetcher = new LotteryDrawFetcher7();
			lotteryType = LotteryType.SFC;
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10084",FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10084",FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			logger.info("================================");
			//任选9场
			lotteryFetcher = new LotteryDrawFetcher8();
			lotteryType = LotteryType.SFR9;
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10084",FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10084",FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			logger.info("================================");
			//4场进球彩
			lotteryFetcher = new LotteryDrawFetcher9();
			lotteryType = LotteryType.JQC;
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10111",FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10111",FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			logger.info("================================");
			//6场半全场
			lotteryFetcher = new LotteryDrawFetcher10();
			lotteryType = LotteryType.BQC;
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10105",FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10105",FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			logger.info("================================");
			
			/////////////////地方//////////////////
			
			
			//浙江体彩6+1
			lotteryFetcher = new LocalityLotteryDrawFetcher(LotteryType.A_ZJ6);
			lotteryType = LotteryType.A_ZJ6;
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			/*
			lotteryDraw = lotteryFetcher.fetch("10105",FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10105",FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			*/
			logger.info("================================");
			//浙江体彩20选5
			lotteryFetcher = new LocalityLotteryDrawFetcher(LotteryType.A_ZJ20);
			lotteryType = LotteryType.A_ZJ20;
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			/*
			lotteryDraw = lotteryFetcher.fetch("10105",FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10105",FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			*/
			logger.info("================================");
			
			
			//高频彩：快乐8
			logger.info("================================");
			lotteryFetcher = new FrequentLotteryDrawFetcher(LotteryType.GXKL10);
			lotteryType = LotteryType.GXKL10;
//			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_500WAN);
//			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			/*
			lotteryDraw = lotteryFetcher.fetch("10105",FetcherType.T_500WAN);
			logger.info(FetcherType.T_500WAN.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			lotteryDraw = lotteryFetcher.fetch("10105",FetcherType.T_STARLOTT);
			logger.info(FetcherType.T_STARLOTT.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			*/
			logger.info("================================");
			logger.info("==测试结束==");
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
		
	}

}
