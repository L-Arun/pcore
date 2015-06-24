package com.lehecai.core.test.lottery.fetcher.jclq;

import java.util.Date;
import java.util.List;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jclq.IJclqScheduleFetcher;
import com.lehecai.core.lottery.fetcher.jclq.JclqScheduleItem;
import com.lehecai.core.lottery.fetcher.jclq.impl.CommonJclqScheduleFetcher;
import com.lehecai.core.util.CoreDateUtils;

public class JclqScheduleFetcherTest {
	public static void main(String[] args) throws Exception {
		IJclqScheduleFetcher c = new CommonJclqScheduleFetcher();
		List<JclqScheduleItem> list = null;
		try {
			list = c.fetch(CoreDateUtils.formatDate(new Date()), FetcherType.T_OFFICIAL);
		} catch (UnsupportedFetcherTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (JclqScheduleItem j : list) {
			System.out.println(j.getJclqScheduleInfo());
		}
		
	}
}
