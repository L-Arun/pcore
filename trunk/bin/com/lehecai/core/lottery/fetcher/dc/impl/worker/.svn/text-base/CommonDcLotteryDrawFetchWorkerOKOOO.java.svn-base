package com.lehecai.core.lottery.fetcher.dc.impl.worker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.OptionTag;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.dc.AbstractDcLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.dc.DcLotteryDrawItem;
import com.lehecai.core.util.CoreFetcherUtils;
import com.lehecai.core.util.CoreObjectUtils;

/**
 * 从澳客网抓我取开奖结果，主要抓取精确的开奖SP值。
 * 当phase为null时，抓取当前期
 * @author 唐容
 *    
 */
public class CommonDcLotteryDrawFetchWorkerOKOOO extends
		AbstractDcLotteryDrawFetchWorker {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private final String baseURL = "http://www.okooo.com/danchang/";
	
	private final String encode = "GBK";
		
	private static Map<String,String> map = new HashMap<String,String>();
	private static Map<String,String> urlMap = new HashMap<String,String>();
	
	private String phase;		//彩期
	
	private List<DcLotteryDrawItem> items;
	
	static{
		map.put("TotalGoals", "SpJQS");//总进球数
		map.put("WDL", "SpSFP");		//让球胜负平
		map.put("OverUnder", "SpSXDS");	//上下单双
		map.put("Score", "SpBF");		//比分
		map.put("HalfFull", "SpBCSFP");	//半场胜负平
	}
	
	static{
		urlMap.put("TotalGoals", "/jinqiu/kaijiang/");//总进球数
		urlMap.put("WDL", "/kaijiang/");		//让球胜负平
		urlMap.put("OverUnder", "/danshuang/kaijiang/");	//上下单双
		urlMap.put("Score", "/bifen/kaijiang/");		//比分
		urlMap.put("HalfFull", "/banquan/kaijiang/");	//半场胜负平
	}
	
	@Override
	public List<DcLotteryDrawItem> fetchDcLotteryDraw(String phase) {
		this.phase = phase;
		items = new ArrayList<DcLotteryDrawItem>();
		this.fetchBaseInfo();
		Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<String, String> entry = itr.next();
			this.fetchDrawSP(entry.getKey(), entry.getValue());
		}
		return items;
	}

	/**
	 * 获取基本信息
	 * @param phase
	 */
	private void fetchBaseInfo(){
		Map<String,String> params = new HashMap<String,String>();
		if( phase != null ){
			params.put("LotteryNo", phase);
		}
		params.put("LotteryType", "WDL");
		
		String html = CoreFetcherUtils.URLGet(baseURL + urlMap.get("WDL"), params, encode);
		Parser parser = Parser.createParser(html, encode);
		
		NodeFilter tableFilter = new TagNameFilter("table");
		NodeFilter hasFilter = new HasAttributeFilter("class","ContentBrim");
		NodeFilter andFilter = new AndFilter(new NodeFilter[]{tableFilter,hasFilter});
		NodeList nodes;
		try {
			nodes = parser.extractAllNodesThatMatch(andFilter);
			if( nodes.size() <= 1 ){
				logger.info("目标网页发生变化，没有找到对应的表");
				return;
			}
			//去彩期
			if(phase == null){
				TableTag phaseTableTag = (TableTag) nodes.elementAt(1);
				TableColumn phaseCol = phaseTableTag.getRows()[1].getColumns()[1];
				OptionTag phaseTag = CoreFetcherUtils.getSelectedOptionByHtml(phaseCol.toHtml(), encode);
				phase = phaseTag.toPlainTextString().trim();
				phase = phase.substring(phase.indexOf("第") + 1,phase.indexOf("期"));
			}
			TableTag tableTag = (TableTag) nodes.elementAt(0);	//有两个满足条件的表，取第一个
			TableRow[] rows = tableTag.getRows();
			TableColumn[] cols;
			DcLotteryDrawItem item = null;
			for(int i = 1; i < rows.length; i++ ){
				item = new DcLotteryDrawItem();
				cols = rows[i].getColumns();
				item.setPhase(phase);
				item.setMatchIndex(Integer.valueOf(cols[0].toPlainTextString().trim()));
				item.setLeague(cols[1].toPlainTextString().trim());
				item.setHomeTeam(cols[2].toPlainTextString().trim());
				item.setAwayTeam(cols[3].toPlainTextString().trim());
				String halfScore = cols[5].toPlainTextString().trim();
				halfScore = halfScore.replace("-", ":");
				if( halfScore.trim().equals(":")){
					halfScore = "";
				}
				item.setHalfTimeResult(halfScore);
				String fullScore = cols[6].toPlainTextString().trim();
				fullScore = fullScore.replace("-", ":");
				if( fullScore.trim().equals(":")){
					fullScore = "";
				}
				item.setFullTimeResult(fullScore);
				items.add(item);
			}
			
		} catch (ParserException e) {
			logger.error("解析网页内容时出错");
		}
		
		return ;
	}
	
	/**
	 * 获取对应彩种的开奖SP
	 * @param typeStr	彩种在url中的string表示
	 * @param methodStr	在DcLotteryDrawItem对应的set方法
	 * @return
	 */
	private void fetchDrawSP(String typeStr, String methodName){
		Map<String,String> params = new HashMap<String,String>();
		params.put("LotteryNo", phase);
		params.put("LotteryType", typeStr);
		
		String html = CoreFetcherUtils.URLGet(baseURL + urlMap.get(typeStr), params, encode);
		Parser parser = Parser.createParser(html, encode);
		
		NodeFilter tableFilter = new TagNameFilter("table");
		NodeFilter hasFilter = new HasAttributeFilter("class","ContentBrim");
		NodeFilter andFilter = new AndFilter(new NodeFilter[]{tableFilter,hasFilter});
		NodeList nodes;
		try {
			nodes = parser.extractAllNodesThatMatch(andFilter);
			if( nodes.size() <= 0 ){
				logger.info("目标网页发生变化，没有找到对应的表");
				return ;
			}
			TableTag tableTag = (TableTag) nodes.elementAt(0);	//有两个满足条件的表，取第一个
			TableRow[] rows = tableTag.getRows();
			TableColumn[] cols;
			for(int i = 1; i < rows.length; i++ ){
				cols = rows[i].getColumns();
				DcLotteryDrawItem item = items.get(i-1);
				String drawSP = cols[8].toPlainTextString().trim();
				drawSP = StringUtils.replace(drawSP, ",", "");
				this.invoke(DcLotteryDrawItem.class, methodName, drawSP, item);
			}
			
		} catch (ParserException e) {
			logger.error("解析网页内容时出错");
		}
		return ;
	}
	
	private void invoke(Class<?> clazz, String methodName, String value,DcLotteryDrawItem item){
		Method m = null;
		try {
			m = CoreObjectUtils.getMethod(clazz, "set" + methodName, new Class[]{String.class});
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return;
		}
		try {
			m.invoke(item, new Object[]{value});
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
			
	}

}
