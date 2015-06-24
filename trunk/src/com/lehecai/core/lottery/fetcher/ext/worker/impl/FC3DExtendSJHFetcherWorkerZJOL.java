package com.lehecai.core.lottery.fetcher.ext.worker.impl;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.RegexFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.lehecai.core.lottery.fetcher.ext.LotteryExtendItem;
import com.lehecai.core.lottery.fetcher.ext.worker.AbstractFC3DExtendSJHFetcherWorker;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreHttpUtils;
import com.lehecai.core.util.CoreStringUtils;

public class FC3DExtendSJHFetcherWorkerZJOL extends AbstractFC3DExtendSJHFetcherWorker {
	
	private final String url = "http://fc.zjol.com.cn/";
	
	@Override
	public LotteryExtendItem fetch(String phase) {
		logger.info("准备抓取{}期福彩3D试机号", phase);
		
		String html = null;;
		
		try {
			List<String> result = CoreHttpUtils.getUrl(url, "", CharsetConstant.CHARSET_GBK, 30000);
			html = CoreStringUtils.join(result, "");
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		
		if (html == null || "".equals(html)) {
			logger.error("未抓取到{}期福彩3D试机号,访问页面返回空", phase == null ? "最新" : phase);
			return null;
		}
		try {
			Parser parser = Parser.createParser(html, CharsetConstant.CHARSET_GBK);
			NodeFilter filter = new RegexFilter(
			"^\\s+第\\d+期\\s+\\d{2}/\\d{1,2}/\\d{1,2}\\s+\\w机\\w球");
			NodeFilter idFilter = new HasAttributeFilter("id", "blink");
			NodeList nodes;
			LotteryExtendItem item = new LotteryExtendItem();
			JSONObject jsonObj = new JSONObject();
			nodes = parser.extractAllNodesThatMatch(filter);
			String content = nodes.elementAt(0).toPlainTextString();
			String fetchedPhase = this.match(content, "\\d{3}\\d+");

			if (phase != null && !phase.equals(fetchedPhase)) {
				logger.warn("抓取结果与指定彩期不匹配, fetched phase={}, specified={}", fetchedPhase, phase);
				return null;
			}

			jsonObj.put("phase", fetchedPhase);
			String machine = this.match(content, "\\d+机");
			machine = this.match(machine, "\\d+");
			jsonObj.put("machine", machine);

			String ball = this.match(content, "\\d+球");
			ball = this.match(ball, "\\d+");
			jsonObj.put("ball", ball);

			parser.setInputHTML(html); // parser extract后改变了，需要重新设置。
			String sjhStr = parser.extractAllNodesThatMatch(idFilter)
					.elementAt(0).toPlainTextString().trim();
			jsonObj.put("sjh", this.buildSJH(sjhStr));
			
			JSONObject sjhJsonObj = new JSONObject();
			sjhJsonObj.put("fc3d_sjh", jsonObj);
			logger.info(sjhJsonObj.toString());
			item.setExtendInfo(sjhJsonObj.toString());
			return item;
		} catch (ParserException e) {
			logger.error("解析url=" + url + "页面出错");
			return null;
		}
	}

	/**
	 * 按正则表达式匹配字符串，并返回第一个匹配结果
	 * @param content
	 * @param regex
	 * @return
	 */
	private String match(String content, String regex) {
		Pattern p;
		Matcher m;
		String result = "";
		p = Pattern.compile(regex);
		m = p.matcher(content);
		if (m.find()) {
			result = m.group();
		}
		return result;
	}
	
	private String buildSJH(String sjh){
		JSONArray sjhArr = new JSONArray();
		for(int i = 0; i < sjh.length(); i++ ){
			if( sjh.charAt(i) != ' '){
				sjhArr.add(String.valueOf(sjh.charAt(i)));
			}
		}
		return sjhArr.toString();
	}
}
