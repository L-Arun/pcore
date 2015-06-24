package com.lehecai.core.lottery.fetcher.dc.impl.worker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
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
import com.lehecai.core.util.CoreStringUtils;

public class CommonDcLotteryDrawFetchWorker500Wan extends
		AbstractDcLotteryDrawFetchWorker {

	protected final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass().getName());
	
	protected static final String URL_LOTTERY_DRAW_500WAN = "http://zx.500wan.com/zqdc/kaijiang.php";
	
	@Override
	public List<DcLotteryDrawItem> fetchDcLotteryDraw(String phase) {

		if( phase == null ){
			logger.info("抓取500万单场开奖结果页面信息失败,彩期号phase不能为空");
			return null;
		}
		String encoding = "GBK";
		String pageInfo = null;
		Parser parser = null;
		
//		String action = "kaijiang.php";
		Map<String,String> params = new HashMap<String,String>();
//		params.put("action", action);
		params.put("expect", phase);
		pageInfo = CoreFetcherUtils.URLPost(URL_LOTTERY_DRAW_500WAN, params, encoding);

		if( pageInfo == null || pageInfo.indexOf("404 Not Found") != -1){
			logger.error("抓取500万单场开奖结果页面信息失败，url=" + URL_LOTTERY_DRAW_500WAN);
		}
		
		HasAttributeFilter classFilter = new HasAttributeFilter("class","ld_table");
		parser = Parser.createParser(pageInfo, encoding);
		NodeList list = null;
		TableRow[] rows = null;
		try {
			list = parser.extractAllNodesThatMatch(classFilter);
			rows = ((TableTag)list.elementAt(0)).getRows();
		} catch (ParserException e) {
			logger.info("抓取500万单场开奖结果页面信息失败，获取id为frm1的节点失败");
		}
		
		
		List<DcLotteryDrawItem> dcLotteryDrawList = new ArrayList<DcLotteryDrawItem>();
		if (rows != null && rows.length > 1) {
			for (int i = 1; i < rows.length; i++) {
				TableRow row = rows[i];
				TableColumn[] cols = row.getColumns();
				DcLotteryDrawItem item = new DcLotteryDrawItem();
				item.setPhase(phase);
				item.setMatchIndex(Integer.valueOf(cols[0].toPlainTextString().trim()));
				item.setLeague(cols[1].toPlainTextString().trim());
				item.setHomeTeam(CoreStringUtils.trimAll(cols[3].toPlainTextString()));
				item.setAwayTeam(CoreStringUtils.trimAll(cols[5].toPlainTextString()));
				String bf = CoreStringUtils.trimAll(cols[6].toPlainTextString());
				if (bf == null || "".equals(bf)) {
					item.setFullTimeResult("");
					item.setHalfTimeResult("");
				}else {
					if (bf.indexOf("(") != -1) {
						item.setFullTimeResult(bf.substring(bf.indexOf(")") + 1, bf.length()));
						item.setHalfTimeResult(bf.substring(bf.indexOf("(") + 1,bf.indexOf(")")));
					} else {
						item.setFullTimeResult("");
						item.setHalfTimeResult("");
					}
				}
				item.setSpSFP(trimAllForNumber(cols[9].toPlainTextString()));
				item.setSpSXDS(trimAllForNumber(cols[18].toPlainTextString()));
				item.setSpBF(trimAllForNumber(cols[15].toPlainTextString()));
				item.setSpJQS(trimAllForNumber(cols[12].toPlainTextString()));
				item.setSpBCSFP(trimAllForNumber(cols[21].toPlainTextString()));
				
				logger.info("抓取到一条开奖结果 " + item.getLogInfo());
				dcLotteryDrawList.add(item);
				
			}
			
		}
		
//		if( list != null && list.size() > 0){
//			if( list.elementAt(0) instanceof TableTag){
//				TableTag tableTag = (TableTag) list.elementAt(0);
////				TableRow[] rows = tableTag.getRows();
//				for(int i = 1; i < rows.length; i++ ){
//					if( rows[i].getColumnCount() == 0){
//						continue;
//					}
//					
//					TableColumn[] cols = rows[i].getColumns();
//					item = new DcLotteryDrawItem();
//					item.setPhase(phase);
//					item.setMatchIndex(Integer.valueOf(cols[0].toPlainTextString().trim()));
//					item.setLeague(cols[1].toPlainTextString().trim());
//					String vs = cols[2].toPlainTextString().trim().replace(spaceMark, "");
//					String[] teams = vs.split("VS");
//					item.setHomeTeam(teams[0]);
//					item.setAwayTeam(teams[1]);
//					String bf = cols[5].toPlainTextString().trim();
//					if (bf == null || "".equals(bf)) {
//						item.setFullTimeResult("");
//						item.setHalfTimeResult("");
//					}else {
//						if (bf.indexOf("(") != -1) {
//							item.setFullTimeResult(bf.substring(0,bf.indexOf("(")));
//							item.setHalfTimeResult(bf.substring(bf.indexOf("(")+1,bf.indexOf(")")));
//						} else {
//							item.setFullTimeResult("");
//							item.setHalfTimeResult("");
//						}
//					}
//					item.setSpSFP(trimAllForNumber(cols[6].toPlainTextString()));
//					item.setSpSXDS(trimAllForNumber(cols[7].toPlainTextString()));
//					item.setSpBF(trimAllForNumber(cols[8].toPlainTextString()));
//					item.setSpJQS(trimAllForNumber(cols[9].toPlainTextString()));
//					item.setSpBCSFP(trimAllForNumber(cols[10].toPlainTextString()));
//					
//					logger.info("抓取到一条开奖结果 " + item.getLogInfo());
//					dcLotteryDrawList.add(item);
//				}
//			}
//		}
		logger.info("抓取500wan单场开奖结果结束");
		return dcLotteryDrawList;
	}
	
	protected String trimAllForNumber(String str) {
		if (str != null) {
			return StringUtils.replace(CoreStringUtils.trimAll(str), ",", "");
		}
		return StringUtils.EMPTY;
	}
}
