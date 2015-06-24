package com.lehecai.core.test.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.util.CoreFetcherUtils;

/**
 * Http抓取性能测试
 * @author leiming
 *
 */
public class HttpPerformanceTest {
	private static final Logger logger = LoggerFactory.getLogger(HttpPerformanceTest.class);
	public static void main(String[] args){
		String url = "http://kj.cpdyj.com/df/";
		int testCount = 10000;//测试次数
		
		logger.info("开始老方式Http性能测试...");
		OldHttpFetcher oldHttp = new OldHttpFetcher();
		for(int i=0;i<testCount;i++){
			logger.info("老方式Http第"+(i+1)+"/"+testCount+"请求");
			oldHttp.fetcherSsq(url);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		logger.info("结束老方式Http性能测试...");
		
		logger.info("开始Http Client Manager性能测试...");
		for(int i=0;i<testCount;i++){
			logger.info("Http Client Manager第"+(i+1)+"/"+testCount+"请求");
			CoreFetcherUtils.URLGet(url, null, "GBK");
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		logger.info("结束Http Client Manager性能测试...");
		
	}
}
