package com.lehecai.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.CssSelectorNodeFilter;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.OptionTag;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.football.FootballScheduleItem;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawComparator;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDrawPrizeItem;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.CommonLotteryDrawComparator;

/**
 * 抓取工具类
 * @author leiming
 *
 */
public class CoreFetcherUtils {
	private static final Logger logger = LoggerFactory.getLogger(CoreFetcherUtils.class.getName());
	/**
	 * 定义编码格式 UTF-8
	 */
	public static final String URL_PARAM_CHARSET_UTF8 = "UTF-8";
	/**
	 * 定义编码格式 GBK
	 */
	public static final String URL_PARAM_CHARSET_GBK = "GBK";
	private static final String URL_PARAM_CONNECT_FLAG = "&";
	private static final String EMPTY = "";
	public static final String PLOT_REMOTE_FETCH_ERROR = "ERROR";

	private static MultiThreadedHttpConnectionManager connectionManager = null;

	private static int connectionTimeOut = 30000;
	private static int socketTimeOut = 30000;
	private static int maxConnectionPerHost = 20;
	private static int maxTotalConnections = 20;

	private static HttpClient client;

	static {
		connectionManager = new MultiThreadedHttpConnectionManager();
		connectionManager.getParams().setConnectionTimeout(connectionTimeOut);
		connectionManager.getParams().setSoTimeout(socketTimeOut);
		connectionManager.getParams().setDefaultMaxConnectionsPerHost(maxConnectionPerHost);
		connectionManager.getParams().setMaxTotalConnections(maxTotalConnections);
		client = new HttpClient(connectionManager);
	}

	/**
	 * POST方式提交数据
	 * @param url 待请求的URL
	 * @param params 要提交的数据
	 * @param enc 编码
	 * @return 响应结果
	 * @throws IOException IO异常
	 */
	public static String URLPost(String url, Map<String, String> params,String enc) {
		String responseData = null;
		PostMethod postMethod = null;
		try {
			postMethod = new PostMethod(url);
			postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,enc);
			postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 30000);
			if(params!=null){
				// 将表单的值放入postMethod中
				Set<String> keySet = params.keySet();
				for (String key : keySet) {
					String value = params.get(key);
					postMethod.addParameter(key, value);
				}
			}
			logger.debug("POST请求URL = " + url.toString());
			// 执行postMethod
			int statusCode = client.executeMethod(postMethod);
			if (statusCode == HttpStatus.SC_OK) {
				String responseEncoding = postMethod.getResponseCharSet();
				if(responseEncoding==null||responseEncoding.trim().length()==0){
					responseEncoding = enc;
				}
				// 如果响应数据编码为gb2312，则强制转换为gbk（页面数据有可能含有big5，会导致乱码）
				else if(responseEncoding.toLowerCase().equals(CharsetConstant.CHARSET_GB2312)){
					responseEncoding = CharsetConstant.CHARSET_GBK;
				}
				InputStream is = postMethod.getResponseBodyAsStream();  
				//这里的编码规则要与上面的相对应  
				BufferedReader br = new BufferedReader(new InputStreamReader(is,responseEncoding));  
				String tempbf = null;;  
				StringBuffer sb = new StringBuffer();  
				while (true) {
					tempbf = br.readLine();
					if (tempbf == null) {
						break;
					} else {
						sb.append(tempbf);  
					}
				}
				responseData = sb.toString();
				logger.debug("POST请求响应内容："+responseData);
				br.close();
				responseEncoding = null;
			} else {
				logger.error("POST请求失败,请求地址:"+url+",响应状态码 :" + postMethod.getStatusCode());
			}
		} catch (HttpException e) {
			logger.error("发生致命的异常，可能是协议不对或者返回的内容有问题,post请求url:"+url);
		} catch (IOException e) {
			logger.error("发生网络异常,get请求url:"+url);
		}
		if (postMethod != null) {
			postMethod.releaseConnection();
			postMethod = null;
		}
		return responseData;
	}

	/**
	 * GET方式提交数据
	 * @param url 待请求的URL
	 * @param params 要提交的数据
	 * @param enc 编码
	 * @return 响应结果
	 * @throws IOException IO异常
	 */
	public static String URLGet(String url, Map<String, String> params,String enc) {
		String responseData = null;
		GetMethod getMethod = null;
		StringBuffer strtTotalURL = new StringBuffer(EMPTY);
		String tmpParam = null;
		tmpParam = getUrl(params, enc);
		if (url.indexOf("?") == -1) {
			if(tmpParam!=null&&tmpParam.trim().length()>0){
				strtTotalURL.append(url).append("?").append(tmpParam);
			}else{
				strtTotalURL.append(url);
			}
		} else {
			if(tmpParam!=null&&tmpParam.trim().length()>0){
				strtTotalURL.append(url).append("&").append(getUrl(params, enc));
			}else{
				strtTotalURL.append(url);
			}
		}
		logger.debug("GET请求URL = " + strtTotalURL.toString());

		try {
			getMethod = new GetMethod(strtTotalURL.toString());
			getMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,enc);
			getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 30000);
			// 执行getMethod
			int statusCode = client.executeMethod(getMethod);
			if (statusCode == HttpStatus.SC_OK) {
				String responseEncoding = getMethod.getResponseCharSet();
				if(responseEncoding==null||responseEncoding.trim().length()==0){
					responseEncoding = enc;
				}
				// 如果响应数据编码为gb2312，则强制转换为gbk（页面数据有可能含有big5，会导致乱码）
				else if(responseEncoding.toLowerCase().equals(CharsetConstant.CHARSET_GB2312)){
					responseEncoding = CharsetConstant.CHARSET_GBK;
				}
				InputStream in = getMethod.getResponseBodyAsStream();  
				//这里的编码规则要与页面的相对应  
				BufferedReader br = new BufferedReader(new InputStreamReader(in,responseEncoding));  
				String tempbf = null;;  
				StringBuffer sb = new StringBuffer(100);  
				while (true) {
					tempbf = br.readLine();
					if (tempbf == null) {
						break;
					} else {
						sb.append(tempbf);  
					}
				}
				responseData = sb.toString();
				logger.debug("GET请求响应内容："+responseData);
				br.close();
				responseEncoding = null;
			} else {
				logger.error("GET请求失败,请求地址:"+strtTotalURL.toString()+",响应状态码:" + getMethod.getStatusCode());
			}
		} catch (HttpException e) {
			logger.error("发生致命的异常，可能是协议不对或者返回的内容有问题,get请求url:"+strtTotalURL.toString(),e);
		} catch (IOException e) {
			logger.error("发生网络异常,get请求url:"+strtTotalURL.toString(),e);
		}
		if (getMethod != null) {
			getMethod.releaseConnection();
			getMethod = null;
			tmpParam = null;
		}
		return responseData;
	}
	/**
	 * 带参数头的POST方式提交数据
	 * @param url 待请求的URL
	 * @param headerParams 请求头的参数
	 * @param params 要提交的数据
	 * @param enc 编码
	 * @return 响应结果
	 * @throws IOException IO异常
	 */
	public static String URLPostWithHeaderParams(String url, Map<String, String> headerParams, Map<String, String> params,String enc) {
		String responseData = null;
		PostMethod postMethod = null;
		try {
			postMethod = new PostMethod(url);
			postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,enc);
			postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 30000);
			if(params!=null){
				// 将表单的值放入postMethod中
				Set<String> keySet = params.keySet();
				for (String key : keySet) {
					String value = params.get(key);
					postMethod.addParameter(key, value);
				}
			}
			logger.debug("POST请求URL = " + url.toString());
			//为了防止被抓取网站屏蔽，伪造一些信息
	        if(headerParams != null){
	            Iterator<String> itheader = headerParams.keySet().iterator();
	            while (itheader.hasNext()) {
	            	String headName = itheader.next();
	            	postMethod.addRequestHeader(headName,headerParams.get(headName).toString()); 
	            }
	        }
			// 执行postMethod
			int statusCode = client.executeMethod(postMethod);
			if (statusCode == HttpStatus.SC_OK) {
				String responseEncoding = postMethod.getResponseCharSet();
				if(responseEncoding==null||responseEncoding.trim().length()==0){
					responseEncoding = enc;
				}
				// 如果响应数据编码为gb2312，则强制转换为gbk（页面数据有可能含有big5，会导致乱码）
				else if(responseEncoding.toLowerCase().equals(CharsetConstant.CHARSET_GB2312)){
					responseEncoding = CharsetConstant.CHARSET_GBK;
				}
				InputStream is = postMethod.getResponseBodyAsStream();  
				//这里的编码规则要与上面的相对应  
				BufferedReader br = new BufferedReader(new InputStreamReader(is,responseEncoding));  
				String tempbf = null;;  
				StringBuffer sb = new StringBuffer();  
				while (true) {
					tempbf = br.readLine();
					if (tempbf == null) {
						break;
					} else {
						sb.append(tempbf);  
					}
				}
				responseData = sb.toString();
				logger.debug("POST请求响应内容："+responseData);
				br.close();
				responseEncoding = null;
			} else {
				logger.error("POST请求失败,请求地址:"+url+",响应状态码 :" + postMethod.getStatusCode());
			}
		} catch (HttpException e) {
			logger.error("发生致命的异常，可能是协议不对或者返回的内容有问题,post请求url:"+url);
		} catch (IOException e) {
			logger.error("发生网络异常,get请求url:"+url);
		}
		if (postMethod != null) {
			postMethod.releaseConnection();
			postMethod = null;
		}
		return responseData;
	}
	/**
	 * 带参数头的GET方式提交数据,伪造抓取身份
	 * @param url 待请求的URL
	 * @param headerParams 消息头参数
	 * @param params 要提交的数据
	 * @param enc 编码
	 * @return 响应结果
	 * @throws IOException IO异常
	 */
	public static String URLGetWithHeaderParams(String url, Map<String, String> headerParams,Map<String, String> params,String enc) {
		String responseData = null;
		GetMethod getMethod = null;
		StringBuffer strtTotalURL = new StringBuffer(EMPTY);
		String tmpParam = null;
		tmpParam = getUrl(params, enc);
		if (url.indexOf("?") == -1) {
			if(tmpParam!=null&&tmpParam.trim().length()>0){
				strtTotalURL.append(url).append("?").append(tmpParam);
			}else{
				strtTotalURL.append(url);
			}
		} else {
			if(tmpParam!=null&&tmpParam.trim().length()>0){
				strtTotalURL.append(url).append("&").append(getUrl(params, enc));
			}else{
				strtTotalURL.append(url);
			}
		}
		logger.debug("GET请求URL = " + strtTotalURL.toString());

		try {
			getMethod = new GetMethod(strtTotalURL.toString());
			getMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,enc);
			getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 30000);
			//为了防止被抓取网站屏蔽，伪造一些信息
	        if(headerParams != null){
	            Iterator<String> itheader = headerParams.keySet().iterator();
	            while (itheader.hasNext()) {
	            	String headName = itheader.next();
	    			getMethod.addRequestHeader(headName,headerParams.get(headName).toString()); 
	            }
	        }
			// 执行getMethod
			int statusCode = client.executeMethod(getMethod);
			if (statusCode == HttpStatus.SC_OK) {
				String responseEncoding = getMethod.getResponseCharSet();
				if(responseEncoding==null||responseEncoding.trim().length()==0){
					responseEncoding = enc;
				}
				// 如果响应数据编码为gb2312，则强制转换为gbk（页面数据有可能含有big5，会导致乱码）
				else if(responseEncoding.toLowerCase().equals(CharsetConstant.CHARSET_GB2312)){
					responseEncoding = CharsetConstant.CHARSET_GBK;
				}
				InputStream in = getMethod.getResponseBodyAsStream();  
				//这里的编码规则要与页面的相对应  
				BufferedReader br = new BufferedReader(new InputStreamReader(in,responseEncoding));  
				String tempbf = null;;  
				StringBuffer sb = new StringBuffer(100);  
				while (true) {
					tempbf = br.readLine();
					if (tempbf == null) {
						break;
					} else {
						sb.append(tempbf);  
					}
				}
				responseData = sb.toString();
				logger.debug("GET请求响应内容："+responseData);
				br.close();
				responseEncoding = null;
			} else {
				logger.error("GET请求失败,请求地址:"+strtTotalURL.toString()+",响应状态码:" + getMethod.getStatusCode());
			}
		} catch (HttpException e) {
			logger.error("发生致命的异常，可能是协议不对或者返回的内容有问题,get请求url:"+strtTotalURL.toString(),e);
		} catch (IOException e) {
			logger.error("发生网络异常,get请求url:"+strtTotalURL.toString(),e);
		}
		if (getMethod != null) {
			getMethod.releaseConnection();
			getMethod = null;
			tmpParam = null;
		}
		return responseData;
	}

	/**
	 * 据Map生成URL字符串
	 * @param map Map
	 * @param valueEnc URL编码
	 * @return URL
	 */
	private static String getUrl(Map<String, String> map, String valueEnc) {
		if (null == map || map.keySet().size() == 0) {
			return (EMPTY);
		}
		StringBuffer url = new StringBuffer();
		Set<String> keys = map.keySet();
		for (Iterator<String> it = keys.iterator(); it.hasNext();) {
			String key = it.next();
			if (map.containsKey(key)) {
				String val = map.get(key);
				String str = val != null ? val : EMPTY;
				try {
					url.append(URLEncoder.encode(key, valueEnc));
					url.append("=");
					url.append(URLEncoder.encode(str, valueEnc));
				} catch (UnsupportedEncodingException e) {
					logger.error(e.getMessage(), e);
					e.printStackTrace();
					continue;
				}
				url.append(URL_PARAM_CONNECT_FLAG);
			}
		}
		String strURL = EMPTY;
		strURL = url.toString();
		if (URL_PARAM_CONNECT_FLAG.equals(EMPTY
				+ strURL.charAt(strURL.length() - 1))) {
			strURL = strURL.substring(0, strURL.length() - 1);
		}
		return (strURL);
	}
	/**
	 * 解析htmlData内第tableIndexNumber个表格的第tableRow行所有的列指定格式(1txt | 0html)内容
	 * @param htmlData html格式的数据
	 * @param tableIndexNumber 从0开始
	 * @param tableRow 从0开始
	 * @param encoding
	 * @param txtFlag 1为文本 0为html
	 * @return
	 */
	public static String[] getContentFromTableRow(String htmlData,int tableIndexNumber,int tableRow,String encoding,int txtFlag){
		
		Parser parser = null;
		String result[] = null;
		try {
			parser = Parser.createParser(htmlData, encoding);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return null;
		} 
		NodeFilter tableFilter = new TagNameFilter("table");
		
		try{
			NodeList tableNodeList = parser.parse(tableFilter);
			TableTag catchTableTag=new TableTag();
			catchTableTag = (TableTag)tableNodeList.elementAt(tableIndexNumber);
			if(catchTableTag!=null){
				TableRow[] catchRows = catchTableTag.getRows();
				TableColumn[] catchColumn = catchRows[tableRow].getColumns();
				if(catchColumn.length>0){
					result = new String[catchColumn.length];
					for(int i = 0;i<catchColumn.length;i++){
						if(txtFlag==1){
							result[i] = catchColumn[i].toPlainTextString().trim();
						}else{
							result[i] = catchColumn[i].toHtml();
						}
						
					}
				}
			}
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			result = null;
		}
		return result;
	}
	/**
	 * 解析htmlData内第tableIndexNumber个表格的第tableRow行所有的列指定格式(1txt | 0html)内容
	 * 必须正规m * n的正规表格
	 * @param htmlData html格式的数据
	 * @param tableIndexNumber 从0开始
	 * @param encoding
	 * @param txtFlag 1为文本 0为html
	 * @return
	 */
	public static String[][] getTableContentFromHtmlTable(String htmlData,int tableIndexNumber,String encoding,int txtFlag){
		
		Parser parser = null;
		String result[][] = null;
		try {
			parser = Parser.createParser(htmlData, encoding);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return null;
		} 
		NodeFilter tableFilter = new TagNameFilter("table");
		try{
			NodeList tableNodeList = parser.parse(tableFilter);
			TableTag catchTableTag=new TableTag();
			catchTableTag = (TableTag)tableNodeList.elementAt(tableIndexNumber);
			if(catchTableTag!=null){
				TableRow[] catchRows = catchTableTag.getRows();
				TableColumn[] catchColumn = catchRows[0].getColumns();
				result = new String[catchRows.length][catchColumn.length];
				for(int k =0;k<catchRows.length;k++ ){
					catchColumn = catchRows[k].getColumns();
					for(int i = 0;i<catchColumn.length;i++){
						if(txtFlag==1){
							result[k][i] = catchColumn[i].toPlainTextString().trim();
						}else{
							result[k][i] = catchColumn[i].toHtml();
						}
					}
				}
			}
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			result = null;
		}
		return result;
	}
	/**
	 * 解析htmlData内表格第tableColumn列内容为keyValue的所在行的所有列数据
	 * @param htmlData
	 * @param tableIndexNumber
	 * @param tableColumn 从0开始
	 * @param keyValue
	 * @param encoding
	 * @return
	 */
	public static String[] getHtmlTableRowDataByColumnKey(String htmlData,int tableIndexNumber,int tableColumn,String keyValue,String encoding){
		Parser parser = null;
		String result[] = null;
		try {
			parser = Parser.createParser(htmlData, encoding);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return null;
		}
		NodeFilter tableFilter = new TagNameFilter("table");
		
		try{
			NodeList tableNodeList = parser.parse(tableFilter);
			TableTag catchTableTag=new TableTag();
			catchTableTag = (TableTag)tableNodeList.elementAt(tableIndexNumber);
			if(catchTableTag!=null){
				TableRow[] catchRows = catchTableTag.getRows();
				TableColumn[] catchColumn = null;
				if (catchRows.length > 0) {
					for (int i = 0; i < catchRows.length; i++) {
						catchColumn = catchRows[i].getColumns();
						if(catchColumn.length>0&&tableColumn<=catchColumn.length&&catchColumn[tableColumn].toPlainTextString().trim().equals(keyValue)){
							result = new String[catchColumn.length];
							for(int j = 0;j<catchColumn.length;j++){
								result[j] = catchColumn[j].toPlainTextString().trim();
							}
							break;
						}
					}
				}
			}//end 表格元素非空
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			result = null;
		}
		return result;
	}
	/**
	 * 获得html内容里的li数据内容，返回数组
	 * @param htmlData
	 * @param encoding
	 * @return
	 */
	public static String[] getLiDataByHtml(String htmlData,String encoding){
		Parser parser = null;
		String result[] = null;
		try {
			parser = Parser.createParser(htmlData, encoding);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return null;
		}
		NodeFilter liFilter = new TagNameFilter("li");
		
		try{
			NodeList liNodeList = parser.parse(liFilter);
			if(liNodeList!=null&&liNodeList.size()>0){
				result = new String[liNodeList.size()];
				for(int i=0;i<liNodeList.size();i++){
					result[i] = liNodeList.elementAt(i).toPlainTextString().trim();
				}
			}
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			result = null;
		}
		return result;
	}
	/**
	 * 从500万抓取4场进球和6场半全场的足球赛程数据
	 * @param htmlData
	 * @param encoding
	 * @param phase
	 * @return
	 */
	public static List<FootballScheduleItem> getFootballScheduleItemListByHtmlData4JQCAndBQCFrom500Wan(String htmlData,String encoding,String phase){
		Parser parser = null;
		List<FootballScheduleItem> list = null;
		FootballScheduleItem footballScheduleItem = null;
		try {
			parser = Parser.createParser(htmlData, encoding);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return null;
		}
		NodeFilter cssFilter = new CssSelectorNodeFilter("#fsendtime");
		NodeFilter ulFilter = new TagNameFilter("ul");
		NodeFilter liFilter = new TagNameFilter("li");
		NodeFilter aFilter = new NodeClassFilter(LinkTag.class);
		String matchTime = null; // 比赛时间
		
		String homeTeam = null; // 主队
		String awayTeam = null; // 客队
		String spaceMark = "&nbsp;";
		String year = null;
		try{
			NodeList cssNodeList = parser.parse(cssFilter);
			if(cssNodeList!=null&&cssNodeList.size()>0){
				year = cssNodeList.elementAt(0).toPlainTextString().trim();
				year = year.substring(0,year.indexOf("-"));
			}else{
				if(phase!=null&&phase.length()>2){
					year = "20"+phase.substring(0,2);
				}else{
					Calendar cal = Calendar.getInstance();
					year = String.valueOf(cal.get(Calendar.YEAR));
				}
			}
			parser.reset();
			NodeList ulNodeList = parser.parse(ulFilter);
			Node ulNode = null;
			if(ulNodeList!=null&&ulNodeList.size()>0){
				Parser liParser = null;
				NodeList liNodeList = null;
				list = new ArrayList<FootballScheduleItem>();
				for(int m=0;m<ulNodeList.size();m++){
					if(m>0){
						ulNode = ulNodeList.elementAt(m);
						liParser = Parser.createParser(ulNode.toHtml(), encoding);
						liNodeList = liParser.parse(liFilter);
						if(liNodeList!=null&&liNodeList.size()>0){
							footballScheduleItem = new FootballScheduleItem();
							Parser aParser = null;
							NodeList linkNodeList = null;
							LinkTag linkNode = null;
							for(int i=0;i<liNodeList.size();i++){
								//从第一行才开始是有效数据
								//主客队
								if(i==1){
									aParser = Parser.createParser(liNodeList.elementAt(i).toHtml(), encoding);
									linkNodeList = aParser.extractAllNodesThatMatch(aFilter);
									if(linkNodeList!=null&&linkNodeList.size()>0){
										if(linkNodeList.elementAt(0) instanceof LinkTag){
											linkNode = (LinkTag)linkNodeList.elementAt(0);
											homeTeam = linkNode.getLinkText().trim();
											homeTeam = homeTeam.replaceAll(spaceMark, "");
											footballScheduleItem.setHomeTeam(homeTeam);
										}
										if(linkNodeList.elementAt(1) instanceof LinkTag){
											linkNode = (LinkTag)linkNodeList.elementAt(1);
											awayTeam = linkNode.getLinkText().trim();
											awayTeam = awayTeam.replaceAll(spaceMark, "");
											footballScheduleItem.setAwayTeam(awayTeam);
										}
									}
								}
								//比赛时间
								if(i==2){
									matchTime = liNodeList.elementAt(i).toPlainTextString().trim();
									footballScheduleItem.setMatchTime(CoreDateUtils.parseLongDate(year + "-"+ matchTime + ":00"));
								}
								if(i>2){
									continue;
								}
							}//end for li
							footballScheduleItem.setPhase(phase);
							footballScheduleItem.setMatchIndex(m);
							list.add(footballScheduleItem);
							logger.info(footballScheduleItem.getLogInfo());
						}
					}
				}//end for ul
			}
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			list = null;
		}
		return list;
	}
	/**
	 * 获得html内容里的被选中的option
	 * @param htmlData
	 * @param encoding
	 * @return
	 */
	public static OptionTag getSelectedOptionByHtml(String htmlData,String encoding){
		Parser parser = null;
		OptionTag optionNode = null;
		OptionTag selectedOptionNode = null;
		OptionTag firstOptionNode = null;
		try {
			parser = Parser.createParser(htmlData, encoding);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return null;
		}
		NodeFilter optionFilter = new TagNameFilter("option");
		try{
			NodeList optionNodeList = parser.parse(optionFilter);
			if(optionNodeList!=null&&optionNodeList.size()>0){
				for(int i=0;i<optionNodeList.size();i++){
					if(optionNodeList.elementAt(i) instanceof OptionTag){
						if(i==0){
							firstOptionNode = (OptionTag)optionNodeList.elementAt(0);;
						}
						optionNode = (OptionTag)optionNodeList.elementAt(i);
						if(optionNode.getAttributeEx("selected")!=null){
							selectedOptionNode = optionNode; 
							break;
						}
					}
				}
			}
		}catch(Exception e){
			logger.error("解析option发生错误"+e.getMessage(),e);
			optionNode = null;
		}
		//不存在默认选择选项默认选择第一个
		if(selectedOptionNode==null){
			selectedOptionNode = firstOptionNode;
		}
		return selectedOptionNode;
	}
	/**
	 * 根据500万详细页面首行解析彩票名称，彩期号和开奖时间
	 * @param data 带解析数据
	 * @param logHeader 日志头
	 * @param phase 彩期号，当前期为null
	 * @return String[] 0:lotteryName,1:lotteryPhase,2:timeDraw
	 */
	public static String[] parser500WanDrawInfo(String data,String logHeader,String phase){
		String[] result = null;
		if (data!=null&&(!data.isEmpty())) {
			String lotteryName = null;
			String lotteryPhase = null;
			String timeDraw = null;
			if(data.indexOf("期")>0){
				String lotteryPhaseBody = data.split("期")[0];
				if(lotteryPhaseBody.indexOf("第")>0){
					lotteryName = lotteryPhaseBody.split("第")[0].trim();
					lotteryPhase = lotteryPhaseBody.split("第")[1].trim();
					if(lotteryPhase==null||lotteryPhase.isEmpty()){
						logger.error(logHeader+"解析的彩期号不存在，返回null==");
						return null;
					}
					if(phase!=null&&phase.trim().length()>0&&(!lotteryPhase.equals(phase))){
						logger.error(logHeader+"指定抓取的彩期号({})与页面抓取的彩期号({})不一致,返回null==",phase,lotteryPhase);
						return null;
					}
				}else{
					logger.error(logHeader+"解析期号发生错误，页面无'第'字==");
					return null;
				}
			}else{
				logger.error(logHeader+"解析期号发生错误，页面无'期'字==");
				return null;
			}
			logger.info(logHeader+"解析"+lotteryName+"期号为:"+lotteryPhase);
			//开奖时间   备注：500万双色球是YYYY年MM月DD日格式 其余格式是2008-8-8
			if(data.indexOf("兑奖截止")>-1){
				String timeDrawBody = data.split("兑奖截止")[0];
				if(timeDrawBody.indexOf("开奖日期：")>-1){
					timeDraw = timeDrawBody.split("开奖日期：")[1].trim();
				}else{
					logger.error(logHeader+"解析开奖日期发生错误，页面无'开奖日期：'字==");
					return null;
				}
			}else{
				logger.error(logHeader+"解析开奖日期发生错误，页面无'兑奖截止'字==");
				return null;
			}
			logger.info(logHeader+"解析开奖日期为:"+timeDraw);
			result = new String[3];
			result[0] = lotteryName;
			result[1] = lotteryPhase;
			result[2] = timeDraw;
		}
		return result;
	}
	/**
	 * 时时彩网 抓取快彩解析
	 * @param htmlData
	 * @param lotteryType
	 * @param encoding
	 * @return
	 */
	public static LotteryDraw parseShiShiCaiFrequentLotteryDraw(String htmlData, LotteryType lotteryType, String phase, String encoding) {
		if (htmlData == null || htmlData.isEmpty() ) {
			return null;
		}
		LotteryDraw lotteryDraw = null;

		String logHeader = lotteryType.getName();
		
		String scriptHeadStr = "var listIssue = ";
		String scriptFootStr = "var stringBuilder";
		
		String[] tmpStrArray = null;
		String tmpStr = null;
		String jsonArrayStr = null;
		
		if(htmlData.indexOf(scriptHeadStr)!=-1){
			tmpStrArray = htmlData.split(scriptHeadStr);
			if(tmpStrArray.length>1){
				tmpStr = tmpStrArray[1];
				
				if(tmpStr != null && tmpStr.indexOf(scriptFootStr)!=-1){
					tmpStrArray = tmpStr.split(scriptFootStr);
					
					if(tmpStrArray.length>1){
						jsonArrayStr = tmpStrArray[0];
						int lastStr = jsonArrayStr.lastIndexOf(";");
						jsonArrayStr = jsonArrayStr.substring(0, lastStr);
					}
				}
			}
		}
		if(jsonArrayStr == null || jsonArrayStr.isEmpty()){
			return null;
		}
		try{
			JSONArray ja = JSONArray.fromObject(jsonArrayStr);
			if(ja != null && ja.size() >0 ){
				String issueNumber = null;
				if(phase == null || phase.isEmpty()){
					// 默认获取第一个彩期
					JSONObject js = (JSONObject)ja.get(0);
					if(js!= null){
						if(js.containsKey("IssueNumber")){
							issueNumber = js.getString("IssueNumber");
							if(issueNumber == null || issueNumber.isEmpty()){
								return null;
							}
						}
						
						issueNumber = issueNumber.replaceAll("-", "");
						
						lotteryDraw = buildLotteryDrawFromShiShiCaiJson(js, lotteryType, issueNumber);
					}
				}
				// 指定彩期号
				else{
					for(int i = 0;i<ja.size();i++){
						JSONObject js = (JSONObject)ja.get(i);
						if(js.containsKey("IssueNumber")){
							issueNumber = js.getString("IssueNumber");
						}
						
						if(issueNumber == null || issueNumber.isEmpty()){
							continue;
						}
						
						issueNumber = issueNumber.replaceAll("-", "");
						
						// 彩期不匹配
						if(!issueNumber.equals(phase)){
							continue;
						}
						if(phase!=null && issueNumber.equals(phase)){
							lotteryDraw = buildLotteryDrawFromShiShiCaiJson(js, lotteryType, issueNumber);
						}
						
					}
				}
				
			}
		}catch(Exception e){
			logger.error(logHeader+",抓取时时彩网的开奖结果发生错误,"+e.getMessage(),e);
		}
		
		return lotteryDraw;
		
	}
	/**
	 * 构建从时时彩网json为开奖结果
	 * @param js
	 * @param lotteryType
	 * @param phase
	 * @return
	 */
	protected static LotteryDraw buildLotteryDrawFromShiShiCaiJson(JSONObject js,LotteryType lotteryType,String phase){
		String[] ta = null;
		int fetchTimeLength = "2011-02-25 16:37".length();//抓取的时间字符串长度
		String bonusTime = null;
		String bonusNumberString = null;
		String result = null;
		String timeDraw = null;
		if(js.containsKey("BonusTime")){
			bonusTime = js.getString("BonusTime");
			if(bonusTime!= null && bonusTime.length()==fetchTimeLength){
				timeDraw = bonusTime+":00";
			}else{
				timeDraw = bonusTime;
			}
		}
		if(js.containsKey("BonusNumberString")){
			bonusNumberString = js.getString("BonusNumberString");
			if(bonusNumberString != null && bonusNumberString.indexOf("|")!=-1){
				ta =  bonusNumberString.split("\\|");
				if(ta!=null && ta.length >0){
					result = ta[0];
				}
			}
		}
		LotteryDraw lotteryDraw = new LotteryDraw();
		lotteryDraw.setLotteryType(lotteryType);
		lotteryDraw.setResult(result);
		lotteryDraw.setTimeDraw(timeDraw);
		lotteryDraw.setPhase(phase);
		
		return lotteryDraw;
	}
	
	/**
	 * 根据表格标签获得500万的开奖详情
	 * @param tableTag
	 * @param needlessRowNumer 忽略表格行数  全国忽略3行，地方忽略2行
	 * @return
	 */
	public static List<LotteryDrawPrizeItem> get500WanResultDetailByTable(TableTag tableTag,int needlessRowNumer){
		if (null != tableTag) {
			List<LotteryDrawPrizeItem> list = new ArrayList<LotteryDrawPrizeItem>();
			LotteryDrawPrizeItem lotteryDrawPrizeItem = null;
			TableRow[] rowsTable = tableTag.getRows();
			String prizeItemName = "";//奖项名称
			String level = "";
			String money = "";
			String columnHeader = "";//复合表格4列的列头
			String rowspan = null;//跨行行数
			Integer rowspanCount = 1;//默认1行
			Integer currentRowNumber = 0;//当前行号,从0开始 可参见500万大乐透
			int startColumnIndex = 0;//起始列号
			//首行,确定表格列数
			TableColumn[] columnsFirstRow = rowsTable[0].getColumns();
			String columnCountStr = columnsFirstRow[0].getAttribute("colspan");
			Integer tableMaxColumnCount = 1;//表格最大列数
			try{
				tableMaxColumnCount = Integer.parseInt(columnCountStr);
			}catch(Exception e){
				logger.error("页面表格首行colspan属性数据格式非法");
				tableMaxColumnCount = 1;//默认1列
			}
			
			for (int i = 0; i < rowsTable.length - needlessRowNumer; i++) {
				TableColumn[] columnsTable = rowsTable[i + 2].getColumns();
				Integer columnsTableCount = columnsTable.length;//当前行列数
				if (tableMaxColumnCount == columnsTableCount) {
					//处理跨行问题
					rowspan = columnsTable[0].getAttribute("rowspan");
					if(rowspan==null){
						rowspanCount = 1;//默认1行
					}else{
						try{
							rowspanCount = Integer.parseInt(rowspan);
						}catch(Exception e){
							logger.error("页面表格rowspan属性数据格式非法");
							rowspanCount = 1;//默认1行
						}
					}
					currentRowNumber = 0;
					//只为单行,清空列头
					if(rowspanCount==1){
						columnHeader = "";
						startColumnIndex = 0;
					}else{
						startColumnIndex = 1;
						columnHeader = columnsTable[0].getStringText().trim();
					}
				} else {
					startColumnIndex = 0;
					currentRowNumber++;
				}
				//当前行超出前一行最大行数跨度
				if(currentRowNumber>=rowspanCount){
					columnHeader = "";//清空原头列数据
				}
				
				// start页面不显示行处理,不做抓取 display:none;
				String styleAttr = rowsTable[i + 2].getAttribute("style");
				styleAttr = CoreStringUtils.trimAll(styleAttr);
				if(styleAttr != null && styleAttr.indexOf("display:none")>=0){
					logger.info("500万开奖详细页面表格有表格行属性为display:none");
					continue;
				}
				// end页面不显示行处理,不做抓取
				
				prizeItemName = columnHeader+columnsTable[startColumnIndex].getStringText().trim();
				level = columnsTable[startColumnIndex+1].getStringText().trim();
				money = columnsTable[startColumnIndex+2].getStringText().trim().replaceAll("\\,", "");
				
				lotteryDrawPrizeItem = new LotteryDrawPrizeItem();
				lotteryDrawPrizeItem.setName(prizeItemName);
				lotteryDrawPrizeItem.setWinningCount(level);
				lotteryDrawPrizeItem.setPrizeAmount(money);
				list.add(lotteryDrawPrizeItem);
			}
			return list;
		}else{
			return null;
		}
	}
	/**
	 * 根据星彩网历史数据表格获取开奖结果
	 * @param tableTag
	 * @param logHeader
	 * @param encoding
	 * @param lotteryType
	 * @return LotteryDraw
	 */
	public static LotteryDraw getLotteryDrawByStarLottHistoryTable(TableTag tableTag,String logHeader,String encoding,LotteryType lotteryType){
		LotteryDraw lotteryDraw = null;
		if(tableTag!=null&&encoding!=null&&lotteryType!=null){
			try{
				TableRow[] tableRows=tableTag.getRows();
				TableColumn[] tableRowColumns = null;
				String columnTmp = null;
				
				String lotteryPhase = null;
				String result = null;
				List<LotteryDrawPrizeItem> resultDetail = null;
				LotteryDrawPrizeItem lotteryDrawPrizeItem = null;
				String timeDraw = null;
				String volumeOfSales=null;
				String jackpot=null;
				for(int i=0;i<tableRows.length;i++){
					tableRowColumns = tableRows[i].getColumns();
					//逐行解析
					//彩种名称  彩期号
					if(i==0){
						columnTmp = tableRowColumns[0].toPlainTextString().trim();
						if(columnTmp.indexOf("第")>0){
							lotteryPhase = columnTmp.split("第")[1];
							lotteryPhase = CoreFetcherUtils.formatLotteryTerm(lotteryPhase);
						}
					}
					//开 奖 日 期,本期投注金额,滚入下期奖金
					if(i==1){
						columnTmp = tableRowColumns[0].toHtml();
						String[] firstRow = getContentFromTableRow(columnTmp, 0, 0, encoding, 1);
						if(firstRow!=null&&firstRow.length>1){
							timeDraw = firstRow[0];
							timeDraw = timeDraw.split("：")[1];
							volumeOfSales = firstRow[1];
							volumeOfSales = volumeOfSales.split("本期投注金额：")[1];
							volumeOfSales = volumeOfSales.split("元")[0];
							volumeOfSales = volumeOfSales.replaceAll(",", "");
						}
						String[] secondRow = getContentFromTableRow(columnTmp, 0, 1, encoding, 1);
						if(secondRow!=null&&secondRow.length>1){
							jackpot = secondRow[1];
							jackpot = jackpot.split("滚入下期奖金：")[1];
							jackpot = jackpot.split("元")[0];
							jackpot = jackpot.replaceAll(",", "");
						}
					}
					//开奖结果
					if(i==2){
						columnTmp = tableRowColumns[0].toHtml();
						String[] resultArray = CoreFetcherUtils.getLiDataByHtml(columnTmp, encoding);
						result = CoreFetcherUtils.mergeStringArray(resultArray, ",");
					}
					//开奖详情 
					if(i==3){
						columnTmp = tableRowColumns[0].toHtml();
						String[][] resultArray = getTableContentFromHtmlTable(columnTmp, 0, encoding, 1);
						if(resultArray!=null){
							resultDetail = new ArrayList<LotteryDrawPrizeItem>();
							String record = null;
							String money = null;
							String prizeItemName = null;//奖项名称
							for(int m=0;m<resultArray.length;m++){
								if(m>0){
									prizeItemName = resultArray[m][0];
									record = resultArray[m][1];
									record = record.replaceAll("注", "").trim();
									money = resultArray[m][2];
									money = money.replaceAll("元", "");
									money = money.replaceAll(",", "");
									if(money.indexOf(".")>0){
										money = money.substring(0, money.indexOf("."));
									}
									lotteryDrawPrizeItem = new LotteryDrawPrizeItem();
									lotteryDrawPrizeItem.setName(prizeItemName);
									lotteryDrawPrizeItem.setWinningCount(record);
									lotteryDrawPrizeItem.setPrizeAmount(money);
									resultDetail.add(lotteryDrawPrizeItem);
								}
							}//end for m
						}
					}
				}//end for tableRows
				lotteryDraw = new LotteryDraw();
				lotteryDraw.setPhase(lotteryPhase);
				lotteryDraw.setResult(result);
				//格式化时间串
				lotteryDraw.setTimeDraw(formatTimeDraw(timeDraw));
				lotteryDraw.setJackpot(jackpot);
				lotteryDraw.setVolumeOfSales(volumeOfSales);
				lotteryDraw.setLotteryType(lotteryType);
				lotteryDraw.setResultDetail(resultDetail);
			}catch(Exception e){
				logger.error(logHeader+"解析详细页面错误",e);
				lotteryDraw = null;
			}
		}
		return lotteryDraw;
	}
	/**
	 * 根据plot的数据获取足球赛程数据
	 * @param data
	 * @return
	 */
	public static List<FootballScheduleItem> getScheduleListFromPlot(String data){
		if(data == null || data.isEmpty()){
			return null;
		}
		JSONArray array = null;
		try {
			array = JSONArray.fromObject(data);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
		List<FootballScheduleItem> footballScheduleItems = new ArrayList<FootballScheduleItem>();
		for(Object obj : array){
			JSONObject json = (JSONObject)obj;
			FootballScheduleItem footballScheduleItem = new FootballScheduleItem();
			footballScheduleItem.setPhase(json.getString("phase"));
			footballScheduleItem.setMatchIndex(json.getInt("matchIndex"));
			footballScheduleItem.setLeague(json.getString("league"));
			footballScheduleItem.setHomeTeam(json.getString("homeTeam"));
			footballScheduleItem.setAwayTeam(json.getString("awayTeam"));
			if(json.getString("matchTime") != null && !"".equals(json.getString("matchTime"))){	
				footballScheduleItem.setMatchTime(CoreDateUtils.parseDate(json.getString("matchTime"), "yyyy-MM-dd HH:mm:ss"));
			}
			footballScheduleItems.add(footballScheduleItem);
		}
		return footballScheduleItems;
	}
	/**
	 * 格式化金钱字符串，形如：￥8,162,781.00的字符串为8162781
	 * @param moneyStr
	 * @return
	 */
	public static String formatMoneyString(String moneyStr){
		String money = null;
		if(moneyStr!=null){
			moneyStr = moneyStr.replaceAll("￥", "");
			if(moneyStr.indexOf(".")>-1){
				money = moneyStr.split("\\.")[0];
			}else{
				money = moneyStr;
			}
			money = money.replaceAll(",", "");
		}
		return money;
	}
	/**
	 * 格式化奖期，去掉字符串中的"期"字
	 * @param term
	 * @return
	 */
	public static String formatLotteryTerm(String term){
		if(term!=null){
			term = term.replaceAll("期", "");
			return term;
		}else{
			return null;
		}
	}
	/**
	 * 以指定字符合并数组内容
	 * @param arrayStr
	 * @param symbol
	 * @return
	 */
	public static String mergeStringArray(String[] arrayStr,String symbol){
		if(arrayStr==null||arrayStr.length==0||symbol==null){
			return null;
		}
		StringBuffer sb = new StringBuffer("");
		for(int i = 0;i<arrayStr.length;i++){
			sb.append(arrayStr[i]);
			if(i<(arrayStr.length-1)){
				sb.append(symbol);
			}
		}
		return sb.toString();
	}
	/**
	 * 格式化日期，
	 * 如果是yyyy年MM月dd日格式 转化为 yyyy-MM-dd
	 * 否则原样返回
	 * @param timeDraw
	 * @return
	 */
	public static String formatTimeDraw(String timeDraw){
		if(timeDraw==null){
			return null;
		}
		String tmp = timeDraw;
		if(timeDraw.indexOf("年")>0&&timeDraw.indexOf("月")>0&&timeDraw.indexOf("日")>0){
			DateFormat shortFormat = new SimpleDateFormat("yyyy年MM月dd日");
			DateFormat normalFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try{
				date = shortFormat.parse(timeDraw);
				tmp = normalFormat.format(date);
			}catch(Exception e){
				logger.error("转换日期字符串"+timeDraw+"错误,原样返回",e);
				return tmp;
			}
		}
		return tmp;
	}
	
	/**
	 * 比较彩期结果，如果彩期号一样，优先返回第二个参数的开奖结果
	 * @param result1
	 * @param result2
	 * @return
	 */
	public static LotteryDraw getComparedResult(LotteryDraw result1, LotteryDraw result2, ILotteryDrawComparator comparator) {
		if (comparator != null) {
			return comparator.compare(result1, result2);
		}
		return result2;
	}
	
	/**
	 * 比较彩期结果，如果彩期号一样，优先返回第二个参数的开奖结果
	 * @param result1
	 * @param result2
	 * @return
	 */
	public static LotteryDraw getComparedResult(LotteryDraw result1, LotteryDraw result2) {
		return getComparedResult(result1, result2, new CommonLotteryDrawComparator());
	}
}
