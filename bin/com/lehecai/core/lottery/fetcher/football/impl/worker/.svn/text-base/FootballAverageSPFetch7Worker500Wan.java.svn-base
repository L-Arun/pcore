package com.lehecai.core.lottery.fetcher.football.impl.worker;

import java.util.ArrayList;
import java.util.List;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.BulletList;
import org.htmlparser.tags.Div;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.SimpleNodeIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.football.AbstractFootballAverageSPFetchWorker;
import com.lehecai.core.lottery.fetcher.football.FootballAverageSPItem;
import com.lehecai.core.util.CoreFetcherUtils;

/**
 * 从500wan里抓取胜负彩的平均SP值 7:胜负彩
 * @author 唐容
 *
 */
public class FootballAverageSPFetch7Worker500Wan extends
		AbstractFootballAverageSPFetchWorker {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	protected String sitename="500Wan";
	
	protected String encoding = "GBK";
	
	protected String spaceMark = "&nbsp;";
	
	protected String AverageSP_URL_500Wan = "http://trade.500wan.com/static/public/sfc/daigou/shtml/%s.shtml";
	
	protected String url = null;
	
	protected String webinfo = null;
	
	protected List<FootballAverageSPItem> list = null;
	
	@Override
	public List<FootballAverageSPItem> fetch(String phase) {
		String fetchLotteryInfo = "[抓取胜负彩平均SP数值]";//抓取彩票信息
		if( phase == null ){
			logger.error(fetchLotteryInfo + "==彩期号不能为空，抓取平均SP值失败");
			return null;
		}
		url = String.format(AverageSP_URL_500Wan, phase);
		webinfo = CoreFetcherUtils.URLGet(url, null, encoding);
		if( webinfo == null || webinfo.indexOf("404 Not Found") > 0){
			logger.error(fetchLotteryInfo + "==抓取彩期号为" + phase + ",url地址为==" + url + "的页面失败，抓取平均SP值失败");
			return null;
		}
		
		Parser parser = new Parser();
		try {
			parser.setInputHTML(webinfo);
			NodeFilter divFilter = new TagNameFilter("div");
			HasAttributeFilter idFilter = new HasAttributeFilter("id","matchList");
			NodeList nodeList = parser.extractAllNodesThatMatch(new AndFilter(new NodeFilter[]{divFilter,idFilter}));
			if( nodeList != null && nodeList.size() > 0){
				Div divTag = (Div) nodeList.elementAt(0);
				
				parser.setInputHTML(divTag.toHtml());
				NodeList ulList = parser.extractAllNodesThatMatch(new TagNameFilter("ul"));
				
				
				SimpleNodeIterator itr = ulList.elements();
				FootballAverageSPItem item = null;
				list = new ArrayList<FootballAverageSPItem>();
				
				while(itr.hasMoreNodes()){
					item = new FootballAverageSPItem();
					BulletList ulTag = (BulletList) itr.nextNode();
					if( ulTag.getAttribute("class")!=null && ulTag.getAttribute("class").indexOf("iframe_tr") >= 0){
						item.setPhase(phase);		//彩期号
						parser.setInputHTML(ulTag.toHtml());
						NodeList liList = parser.extractAllNodesThatMatch(new TagNameFilter("li"));
						String mathIndexStr = liList.elementAt(0).toPlainTextString().trim();
						item.setMatchIndex(Integer.parseInt(mathIndexStr));		//比赛场次
				
						String averageSPStr = liList.elementAt(4).toPlainTextString();	//平均欧指
						String[] averageSPArr = averageSPStr.split(spaceMark);
						item.setAverageSP_S(averageSPArr[0]);
						item.setAverageSP_P(averageSPArr[1]);
						item.setAverageSP_F(averageSPArr[2]);
						
						list.add(item);
					}
				}
			}
			
		} catch (ParserException e) {
			logger.error(fetchLotteryInfo + "==解析url=" + url +"的页面出现错误，抓取平均SP值失败");
			return null;
		}
		
		logger.info(fetchLotteryInfo + "==解析url=" + url + "==解析页面结束，成功获取平均欧指");
		return list;
	}

}
