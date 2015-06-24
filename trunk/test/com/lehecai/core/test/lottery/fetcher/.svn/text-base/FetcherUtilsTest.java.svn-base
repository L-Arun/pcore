/**
 * 
 */
package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.util.CoreFetcherUtils;

/**
 * @author Sunshow
 *
 */
public class FetcherUtilsTest {

	private static final Logger logger = LoggerFactory.getLogger(FetcherUtilsTest.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		String url = "http://www.sina.com";
		String encoding = "utf-8";
		String data = null;
		String logHeader = "";
		HashMap<String,String> params = new HashMap<String,String>();
		
		HttpClientParams clientParams = new HttpClientParams();
		clientParams.setParameter(HttpClientParams.HTTP_CONTENT_CHARSET,encoding);
		clientParams.setSoTimeout(50000);
		HttpClient client = new HttpClient(clientParams);
		
		//get方法
		GetMethod getMethod = new GetMethod(url);
		try {
			client.executeMethod(getMethod);
			data = getMethod.getResponseBodyAsString();
		} catch (Exception e1) {
			logger.error(logHeader+"连接错误==",e1);
		} finally {
			getMethod.releaseConnection();
		}
		//post方法
		
		PostMethod postMethod = new PostMethod(url);
		postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,encoding);
		if(params!=null){
			Set<String> keySet = params.keySet();
			for (String key : keySet) {
				String value = params.get(key);
				postMethod.addParameter(key, value);
			}
		}
		try{
			int statusCode = client.executeMethod(postMethod);
			data = postMethod.getResponseBodyAsString();
		}catch (Exception e1) {
			logger.error(logHeader+"连接错误==",e1);
		} finally {
			postMethod.releaseConnection();
		}*/
		logger.info(CoreFetcherUtils.formatTimeDraw("2010年9月3日"));
		logger.info(CoreFetcherUtils.formatTimeDraw("2010-9-3"));
		logger.info(CoreFetcherUtils.formatTimeDraw(null));
	}

}
