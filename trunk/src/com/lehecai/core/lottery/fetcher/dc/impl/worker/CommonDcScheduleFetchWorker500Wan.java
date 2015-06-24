package com.lehecai.core.lottery.fetcher.dc.impl.worker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.dc.AbstractDcScheduleFetchWorker;
import com.lehecai.core.lottery.fetcher.dc.DcScheduleItem;
import com.lehecai.core.util.CoreDateUtils;
import com.lehecai.core.util.CoreFetcherUtils;
import com.lehecai.core.util.CoreStringUtils;

public class CommonDcScheduleFetchWorker500Wan extends
		AbstractDcScheduleFetchWorker {

	protected final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass().getName());
	
//	protected static final String URL_SCHEDULE_500WAN = "http://www.500wan.com/zqdc/saicheng.php";
	protected static final String URL_SCHEDULE_500WAN = "http://zc.trade.500wan.com/bjdc/";
	@Override
	public List<DcScheduleItem> fetchDcSchedule(String phase) {
		
		if( phase == null ){
			logger.info("抓取500万单场赛程页面信息失败,彩期号phase不能为空");
			return null;
		}
		String encoding = "GBK";
		String pageInfo = null;
		Parser parser = null;
		
//		String action = "saicheng.php";
		Map<String,String> params = new HashMap<String,String>();
//		params.put("action", action);
		params.put("expect", phase);
		pageInfo = CoreFetcherUtils.URLPost(URL_SCHEDULE_500WAN, params, encoding);
		
		if( pageInfo == null || pageInfo.indexOf("404 Not Found") != -1){
			logger.error("抓取500万单场赛程页面信息失败，url=" + URL_SCHEDULE_500WAN);
		}
		
		HasAttributeFilter idFilter = new HasAttributeFilter("id","vs_table");
		parser = Parser.createParser(pageInfo, encoding);
		NodeList list = null;
		TableRow[] rowArray = null;
		try {
			list = parser.extractAllNodesThatMatch(idFilter);
			rowArray = ((TableTag)list.elementAt(0)).getRows();
		} catch (ParserException e) {
			logger.info("抓取500万单场赛程页面信息失败，获取id为frm1的节点失败");
		}
		
		List<DcScheduleItem> dcScheduleList = new ArrayList<DcScheduleItem>();
		if(list != null && list.size() > 0) {
			Calendar cal = Calendar.getInstance();
			for (int i = 0; i < rowArray.length; i++) {
					TableRow row = rowArray[i];
					TableColumn[] cols = row.getColumns();
					if (cols.length == 1) {
						String dateStr = CoreStringUtils.trimAll(cols[0].toPlainTextString()).substring(0, 10);
						Date date = CoreDateUtils.parseDate(dateStr);
						cal.setTime(date);
					} else {
					DcScheduleItem item = new DcScheduleItem();
					item.setPhase(phase);
					item.setMatchIndex(Integer.valueOf(cols[0].toPlainTextString().trim()));
					item.setLeague(cols[1].toPlainTextString().trim());
					String homeTeam = CoreStringUtils.trimAll(cols[3].toPlainTextString());
					if (homeTeam.indexOf("[") != -1) {
						homeTeam = homeTeam.replace(homeTeam.substring(0, homeTeam.indexOf("]") + 1), "");
					}
					item.setHomeTeam(homeTeam);
					String awayTeam = CoreStringUtils.trimAll(cols[5].toPlainTextString());
					if (awayTeam.indexOf("[") != -1) {
						awayTeam = awayTeam.replace(awayTeam.substring(awayTeam.indexOf("["), awayTeam.length()), "");
					}
					item.setAwayTeam(awayTeam);
					Integer hour = Integer.parseInt(CoreStringUtils.trimAll(cols[2].toPlainTextString()).substring(0, 2));
					String dateStr = "";
					if (hour < 10) {
						dateStr = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + (cal.get(Calendar.DAY_OF_MONTH) + 1);
					} else {
						dateStr = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH);
					}
					dateStr = dateStr + " " +  CoreStringUtils.trimAll(cols[2].toPlainTextString()) + ":00";
					item.setMatchTime(CoreDateUtils.parseDate(dateStr, CoreDateUtils.DATETIME));
					item.setHandicap(cols[4].toPlainTextString().trim());
					logger.info("抓取到一条赛程 " + item.getDcScheduleInfo());
					dcScheduleList.add(item);
					}
			}
//			if( list.elementAt(0) instanceof TableTag) {
//				TableTag tableTag = (TableTag) list.elementAt(0);
//				TableRow[] rows = tableTag.getRows();
//				for(int i = 1; i < rows.length; i++ ){
//					TableColumn[] cols = rows[i].getColumns();
//					item = new DcScheduleItem();
//					item.setPhase(phase);
//					item.setMatchIndex(Integer.valueOf(cols[0].toPlainTextString().trim()));
//					item.setLeague(cols[1].toPlainTextString().trim());
//					String vs = cols[2].toPlainTextString().trim().replace(spaceMark, "");
//					String[] teams = vs.split("VS");
//					item.setHomeTeam(teams[0]);
//					item.setAwayTeam(teams[1]);
//					Date matchTime = CoreDateUtils.parseDate(cols[3].toPlainTextString().trim(), "yyyy-MM-dd HH:mm");
//					item.setMatchTime(matchTime);
//					item.setHandicap(cols[4].toPlainTextString().trim());
//					logger.info("抓取到一条赛程 " + item.getDcScheduleInfo());
//					dcScheduleList.add(item);
//				}
//			}
		}
		logger.info("抓取500wan单场赛程结束");
		return dcScheduleList;
	}

}
