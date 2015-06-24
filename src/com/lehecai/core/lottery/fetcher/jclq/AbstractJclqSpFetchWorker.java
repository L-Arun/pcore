package com.lehecai.core.lottery.fetcher.jclq;

import java.util.List;
/**
 * 竞彩篮球sp抓取抽象类
 * @author qatang
 *
 */
public abstract class AbstractJclqSpFetchWorker {
	/**
	 * 抓取竞彩篮球sp
	 * @param officialDate
	 * @return
	 */
	abstract public List<JclqSpItem> fetchJclqSp(String officialDate);
}
