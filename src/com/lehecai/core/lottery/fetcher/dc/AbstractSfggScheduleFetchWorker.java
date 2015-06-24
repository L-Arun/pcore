package com.lehecai.core.lottery.fetcher.dc;

import java.util.List;
/**
 * 胜负过关赛程抓取抽象类
 * @author leiming
 *
 */
public abstract class AbstractSfggScheduleFetchWorker {
	/**
	 * 抓取胜负过关赛程
	 * @param phase
	 * @return
	 */
	abstract public List<SfggScheduleItem> fetchSfggSchedule(String phase);
}
