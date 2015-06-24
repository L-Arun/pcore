package com.lehecai.core.lottery.fetcher.football;

import java.util.List;

import com.lehecai.core.lottery.LotteryType;

/**
 * 足球赛程具体工作抓取 抽象类
 * @author leiming
 *
 */
public abstract class AbstractFootballScheduleFetchWorker {
	protected String scheduleUrl;
	protected String fetchPhase;
	protected LotteryType lotteryType;
	/**
	 * 获取抓取赛程地址 抽象方法
	 * @return
	 */
	abstract public String getScheduleUrl();

	public void setScheduleUrl(String scheduleUrl) {
		this.scheduleUrl = scheduleUrl;
	}

	public String getFetchPhase() {
		return fetchPhase;
	}

	public void setFetchPhase(String fetchPhase) {
		this.fetchPhase = fetchPhase;
	}
	
	public LotteryType getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	/**
	 * 根据彩期抓取足球赛程列表
	 * @param phase
	 * @return
	 */
	abstract public List<FootballScheduleItem> fetchFootballSchedule(String phase);
}
