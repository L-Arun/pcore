package com.lehecai.core.lottery.fetcher.ext.worker.impl;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONObject;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.lehecai.core.lottery.fetcher.ext.LotteryExtendItem;
import com.lehecai.core.lottery.fetcher.ext.worker.AbstractFC3DExtendSJHFetcherWorker;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreHttpUtils;
import com.lehecai.core.util.CoreStringUtils;

public class FC3DExtendSJHFetcherWorkerZHCW extends AbstractFC3DExtendSJHFetcherWorker {
	
	private final String url = "http://kaijiang.zhcw.com/zhcw/html/3d/new_sjh_";
	private final String urlLastest = "http://www.zhcw.com/kaijiang/zhcw_3d_sjh.html";
	
	@Override
	public LotteryExtendItem fetch(String phase) {
		logger.info("准备抓取{}期福彩3D试机号", phase);
		
		if (phase == null || "".equals(phase)) {
			phase = getLastestPhaseNo();
			if(phase == null || "".equals(phase)) {
				logger.error("彩期不能为空！");
				return null;
			}
		}
	
		String machine = "0";
		String ball = "0";
		String html = null;
		String encoding = CharsetConstant.CHARSET_UTF8;
		
		try {
			List<String> result = CoreHttpUtils.getUrl(url + phase + ".html", "", encoding, 30000);
			html = CoreStringUtils.join(result, "");
		} catch (IOException e) {
			logger.error("未抓取到{}期福彩3D试机号,访问页面返回空", phase == null ? "最新" : phase);
			return null;
		}
		
		if (html == null || "".equals(html)) {
			logger.error("未抓取到{}期福彩3D试机号,访问页面返回空", phase == null ? "最新" : phase);
			return null;
		}
		
		Parser parser = null;
		
		try {
			JSONObject jsonSjh = new JSONObject();
			parser = Parser.createParser(html, encoding);
			NodeFilter filter = new HasAttributeFilter("selected");
			NodeList nodeList = parser.extractAllNodesThatMatch(filter);
			String phaseNo = nodeList.elementAt(0).toPlainTextString().trim();
			
			if (phaseNo != null && !"".equals(phaseNo)) {
				if (phaseNo.equals(phase)) {
					jsonSjh.put("phase", phaseNo);
				} else {
					logger.error("抓取到得彩期与输入彩期不匹配");
					return null;
				}
			}
			
			parser.reset();
			
			parser = Parser.createParser(html,  encoding);
			NodeFilter filterSjh = new HasAttributeFilter("class", "sjh_div1");
			NodeList nodeListSjh = parser.extractAllNodesThatMatch(filterSjh);
			
			String sjh = "";
			if (nodeListSjh.elementAt(0).getChildren().elementAt(0).getChildren().elementAt(3) instanceof TextNode) {
				sjh = nodeListSjh.elementAt(0).getChildren().elementAt(0).getChildren().elementAt(3).toPlainTextString();
				sjh = sjh.replaceAll("&nbsp;", ""); 
				sjh = sjh.replaceAll(" ", ""); 
				char [] sjhArray = sjh.toCharArray();
				jsonSjh.put("sjh", sjhArray);
				jsonSjh.put("machine", machine);
				jsonSjh.put("ball", ball);
				System.out.println();
			}
			LotteryExtendItem item = new LotteryExtendItem();
			JSONObject json = new JSONObject();
			json.put("fc3d_sjh", jsonSjh.toString());
			logger.info(json.toString());
			item.setExtendInfo(json.toString());
			return item;
		} catch (ParserException e1) {
			logger.error("HTML文件解析错误");
			return null;
		}			
	}
	
	private String getLastestPhaseNo() {
		String encoding = CharsetConstant.CHARSET_UTF8;
		String html = "";
		String phaseNo = null;
		try {
			List<String> result = CoreHttpUtils.getUrl(urlLastest, "", encoding, 30000);
			html = CoreStringUtils.join(result, "");
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		
		if (html == null || "".equals(html)) {
			logger.error("未抓取到{}期福彩3D试机号最新");
			return null;
		}
		
		Parser parser = null;
		
		try {
			parser = Parser.createParser(html,  encoding);
			NodeFilter filter = new HasAttributeFilter("selected");
			NodeList nodeList = parser.extractAllNodesThatMatch(filter);
			phaseNo = nodeList.elementAt(0).toPlainTextString().trim();
		} catch (Exception e) {
			logger.error("抓取最新彩期号出错");
			return null;
		}
		return phaseNo;
	}
}
