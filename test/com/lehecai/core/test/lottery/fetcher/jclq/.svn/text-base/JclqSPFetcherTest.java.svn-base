package com.lehecai.core.test.lottery.fetcher.jclq;

import java.util.List;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jclq.IJclqSpFetcher;
import com.lehecai.core.lottery.fetcher.jclq.JclqSpItem;
import com.lehecai.core.lottery.fetcher.jclq.impl.CommonJclqSpFetcher;

public class JclqSPFetcherTest {
	public static void main(String[] args) throws Exception {
		IJclqSpFetcher c = new CommonJclqSpFetcher();
		List<JclqSpItem> list = null;
		try {
			list = c.fetch("20120403", FetcherType.T_500WAN);
		} catch (UnsupportedFetcherTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (list != null && list.size() > 0) {
			for (JclqSpItem j : list) {
				System.out.println(j.getJclqScheduleInfo());
			}
		}
	}
}
