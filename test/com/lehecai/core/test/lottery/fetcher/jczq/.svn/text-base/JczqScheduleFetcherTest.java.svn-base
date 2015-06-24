package com.lehecai.core.test.lottery.fetcher.jczq;

import java.util.List;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.jczq.IJczqDynamicInstantSpFetcher;
import com.lehecai.core.lottery.fetcher.jczq.JczqDynamicInstantSpItem;
import com.lehecai.core.lottery.fetcher.jczq.impl.CommonJczqDynamicInstantSpFetcher;

public class JczqScheduleFetcherTest {
	public static void main(String[] args) {
//		IJczqScheduleFetcher c = new CommonJczqScheduleFetcher();
//		List<JczqScheduleItem> list = null;
//		try {
//			list = c.fetch(null);
//		} catch (UnsupportedFetcherTypeException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for (JczqScheduleItem j : list) {
//			System.out.println(j.getJczqScheduleInfo());
//		}
		IJczqDynamicInstantSpFetcher j = new CommonJczqDynamicInstantSpFetcher();
		List<JczqDynamicInstantSpItem> list = null;
		try {
			list = j.fetch("20110721", LotteryType.JCZQ_JQS);
		} catch (UnsupportedFetcherTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (JczqDynamicInstantSpItem jj : list) {
			System.out.println(jj.getSpmap());
		}
	}
}
