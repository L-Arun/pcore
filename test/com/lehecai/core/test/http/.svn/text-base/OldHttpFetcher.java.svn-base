package com.lehecai.core.test.http;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 老的http抓取数据连接处理方式
 * @author leiming
 *
 */
public class OldHttpFetcher {
	private Logger logger = LoggerFactory.getLogger(OldHttpFetcher.class);
	public void fetcherSsq(String url){
		String totalmonery="";
		HttpClientParams clientParams = new HttpClientParams();
		clientParams.setParameter(HttpClientParams.HTTP_CONTENT_CHARSET, "GBK");
		clientParams.setSoTimeout(50000);
		HttpClient client = new HttpClient(clientParams);
		GetMethod getMethod = new GetMethod(url);
		String data=null;
		try {
			//getMethod.setRequestHeader("Connection", "close");// 优化方法
			client.executeMethod(getMethod);
			data=getMethod.getResponseBodyAsString();
			if(-1!=data.indexOf("本期销量：")){
              totalmonery=data.split("本期销量：")[1].split("元")[0].split(">")[1];
              totalmonery=totalmonery.replaceAll(",", "");
              logger.info("本期销量："+totalmonery);
			}
		} 
		catch (Exception e){
		     logger.error(url+e.getMessage());
		} finally{
			getMethod.releaseConnection();
		}
	}
}
