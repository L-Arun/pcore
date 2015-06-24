package com.lehecai.core.lottery.fetcher.dc.impl.worker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.CssSelectorNodeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.OptionTag;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.dc.AbstractDcScheduleFetchWorker;
import com.lehecai.core.lottery.fetcher.dc.DcScheduleItem;
import com.lehecai.core.util.CoreDateUtils;
import com.lehecai.core.util.CoreFetcherUtils;

/**
 * 通用单场赛程抓取实现类
 * @author leiming
 *
 */
public class CommonDcScheduleFetchWorkerAIBO extends AbstractDcScheduleFetchWorker{
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	protected static final String SCHEDULE_URL_AIBO = "http://www.aibo123.com/sportsweb/hpo/hposhedule.aspx";
	
	public List<DcScheduleItem> fetchDcSchedule(String phase){
		Map<String, String> headerParams = new HashMap<String, String>();
		headerParams.put("Referer", "http://www.aibo123.com");
		headerParams.put("user-agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.8) Gecko/20100722 Firefox/3.6.8");
		List<DcScheduleItem> dcScheduleItemList = new ArrayList<DcScheduleItem>();
		Calendar calendar = GregorianCalendar.getInstance();
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		String encoding = "utf-8";
		DcScheduleItem dcScheduleItem = null;
		String matchTime = null;
		String siteName = "爱波网[单场赛程]";
		String logHeader = siteName+SCHEDULE_URL_AIBO;
		String lotteryPhase = null;//实际页面抓取的期号
		try {
			if(phase==null){
				logHeader += "抓取==当前期==";
			}else{
				logHeader += "抓取==指定期==";
			}
			String webInfo = CoreFetcherUtils.URLGetWithHeaderParams(SCHEDULE_URL_AIBO,headerParams,null,encoding);
			if (webInfo == null || webInfo.indexOf("404 Not Found") > 0) {
				logger.error(logHeader+"第<"+phase+">期,data is null or 404 Not Found");
				return null;
			}
			OptionTag optionNode = CoreFetcherUtils.getSelectedOptionByHtml(webInfo, encoding);
			if(optionNode!=null){
				lotteryPhase = optionNode.getOptionText().trim();
			}
			if(lotteryPhase==null){
				logger.error(logHeader+",当前期号不存在,返回null");
				return null;
			}
			lotteryPhase = "1"+lotteryPhase;//爱波网单场期数与乐和彩不一致，首位补1统一期数
			
			//彩期抓取不一致
			if(phase!=null&&(!lotteryPhase.equals(phase))){
				logger.error(logHeader+",指定单场赛程第<"+phase+">期与实际页面抓取期号"+lotteryPhase+"不一致,返回null");
				return null;
			}
			logger.info(logHeader+"期号为:"+lotteryPhase);
			
			Parser parser = Parser.createParser(webInfo, encoding);
			
			NodeList nodeList = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("div[class='side763'] #rounds"));
			if(null != nodeList && nodeList.size() > 0){
				NodeFilter tableFilter = new TagNameFilter("table");
				Parser parser2 = Parser.createParser(nodeList.toHtml(), encoding);
				NodeList tableNodeList = parser2.extractAllNodesThatMatch(tableFilter);
				if(tableNodeList!=null&&tableNodeList.size()>0){
					TableTag catchTableTag=new TableTag();
					catchTableTag = (TableTag)tableNodeList.elementAt(0);
					if(catchTableTag!=null){
						TableRow[] catchRows = catchTableTag.getRows();
						TableColumn[] catchColumns = null;
						for(int i=2;i<catchRows.length;i += 2){
							catchColumns = catchRows[i].getColumns();
							if(catchColumns!=null&&catchColumns.length>=6){
								dcScheduleItem = new DcScheduleItem();
								dcScheduleItem.setPhase(lotteryPhase);
								dcScheduleItem.setMatchIndex(Integer.parseInt(catchColumns[0].toPlainTextString().trim()));
								dcScheduleItem.setLeague(catchColumns[1].toPlainTextString().trim());
								matchTime = catchColumns[2].toPlainTextString().trim();
								dcScheduleItem.setMatchTime(CoreDateUtils.parseLongDate(year + "-"+ matchTime + ":00"));
								dcScheduleItem.setHomeTeam(catchColumns[3].toPlainTextString().trim());
								dcScheduleItem.setHandicap(catchColumns[4].toPlainTextString().trim());
								dcScheduleItem.setAwayTeam(catchColumns[5].toPlainTextString().trim());
								logger.info(dcScheduleItem.getDcScheduleInfo());
								dcScheduleItemList.add(dcScheduleItem);
							}
						}//end for catchRows
					}//end if catchTableTag!=null
				}//end if(tableNodeList!=null&&tableNodeList.size()>0)
			}else{
				logger.error(logHeader+"单场赛程数据表格不存在，返回null");
				return null;
			}
		} catch (Exception e) {
			logger.error(logHeader+"单场赛程错误"+e.getMessage(),e);
			return null;
		}
		return dcScheduleItemList;
	}
}
