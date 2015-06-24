package com.lehecai.core.test.lottery.fetcher.jczq;

import java.util.List;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jczq.IJczqSpFetcher;
import com.lehecai.core.lottery.fetcher.jczq.JczqSpItem;
import com.lehecai.core.lottery.fetcher.jczq.impl.CommonJczqSpFetcher;

public class JczqSPFetcherTest {
	public static void main(String[] args) {
		IJczqSpFetcher c = new CommonJczqSpFetcher();
		List<JczqSpItem> list = null;
		try {
			list = c.fetch("20120403", FetcherType.T_500WAN);
		} catch (UnsupportedFetcherTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (list != null && list.size() > 0) {
			for (JczqSpItem j : list) {
				System.out.println(j.getJczqScheduleInfo());
			}
		}
	}
}
