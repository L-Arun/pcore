package com.lehecai.core.lottery.fetcher.jczq;

import java.util.List;

import com.lehecai.core.lottery.LotteryType;
/**
 * 竞彩足球猜冠亚军固定奖金即时sp抓取抽象类
 * @author qatang
 *
 */
public abstract class AbstractJczqChampionSecondStaticInstantSpFetchWorker {
	/**
	 * 抓取竞彩足球猜冠亚军固定奖金即时sp
	 * @param phase
	 * @return
	 */
	abstract public List<JczqChampionSecondStaticInstantSpItem> fetchJczqSp(String phase, LotteryType lotteryType);
}
