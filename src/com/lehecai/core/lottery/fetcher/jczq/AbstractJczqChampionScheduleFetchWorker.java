package com.lehecai.core.lottery.fetcher.jczq;

import java.util.List;

import com.lehecai.core.exception.FetchFailedException;
/**
 * 竞彩足球猜冠军赛程抓取抽象类
 * @author qatang
 *
 */
public abstract class AbstractJczqChampionScheduleFetchWorker {
	/**
	 * 抓取竞彩足球猜冠军赛程
	 * @return
	 */
	abstract public List<JczqChampionScheduleItem> fetchJczqChampionSchedule(String phase) throws FetchFailedException;
}
