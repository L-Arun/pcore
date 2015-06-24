package com.lehecai.core.lottery.fetcher.dc.impl.worker;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.dc.AbstractDcLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.dc.DcLotteryDrawItem;
import com.lehecai.core.util.CoreFetcherUtils;
import com.lehecai.core.util.CoreStringUtils;

public class CommonDcLotteryDrawFetchWorker8788 extends AbstractDcLotteryDrawFetchWorker{
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	protected static final String LOTTERYDRAW_URL_8788 = "http://www.8788.cn/static/bd/info/kjsp/all/";
	
	public List<DcLotteryDrawItem> fetchDcLotteryDraw(String phase){
		String encoding = "GBK";
		String siteName = "菠菜娃娃[单场开奖结果]";
		String logHeader = siteName;
		String lotteryAddress = null;//实际页面抓取的地址
		String webInfo = null;
		String phaseName = null;
		String url = null;
		//处理彩期
		if(phase==null){
			phaseName = "抓取==当前期==";
			logHeader = siteName + LOTTERYDRAW_URL_8788 + phaseName;
			webInfo = CoreFetcherUtils.URLGet(LOTTERYDRAW_URL_8788, null, encoding);
			if (webInfo == null || webInfo.indexOf("404 Not Found") > 0) {
				logger.error(logHeader+"当前期,data is null or 404 Not Found");
				return null;
			}
			lotteryAddress = CoreStringUtils.substringBetween(webInfo, "0;URL=", "\">");
			phase = lotteryAddress.replace(".shtml", "");
		}else{
			phaseName = "抓取==指定期==";
			lotteryAddress = phase + ".shtml";
		}
		//爱波网抓取必须去掉本地期号的首位
		url = LOTTERYDRAW_URL_8788 + lotteryAddress;
		logHeader = siteName+url+phaseName;
		
		webInfo = CoreFetcherUtils.URLGet(url, null, encoding);
		if (webInfo == null || webInfo.indexOf("404 Not Found") > 0) {
			logger.error(logHeader+"第<"+phase+">期,data is null or 404 Not Found");
			return null;
		}
		
		List<DcLotteryDrawItem> list = null;
		DcLotteryDrawItem dcLotteryDrawItem = null;
		
		try {
			list = new ArrayList<DcLotteryDrawItem>();
			Parser parser = Parser.createParser(webInfo, encoding);
			NodeFilter tableFilter = new TagNameFilter("table");
			NodeFilter classFilter = new HasAttributeFilter("class", "BscBox_table");
			NodeList nodeList = parser.extractAllNodesThatMatch(new AndFilter(tableFilter, classFilter));
			if (nodeList != null && nodeList.size() > 0) {
				TableTag catchTableTag = new TableTag();
				catchTableTag = (TableTag) nodeList.elementAt(0);
				if(catchTableTag != null){
					TableRow[] catchRows = catchTableTag.getRows();
					TableColumn[] catchColumns = null;
					String homeTeam = null;		//主队
					String awayTeam = null;		//客队
					String halfTimeResult = null;	//半场比分
					String fullTimeResult = null;	//全场比分
					
					String spSFP = null;		//单场胜负平的SP值
					String spSXDS = null;		//单场上下单双的SP值
					String spJQS = null;		//单场进球数的SP值
					String spBF = null;			//单场比分的SP值
					String spBCSFP = null;		//单场半场胜负平的SP值
					
					for(int i = 1; i < catchRows.length; i++){
						catchColumns = catchRows[i].getColumns();
						if(catchColumns != null && catchColumns.length >= 10){
							dcLotteryDrawItem = new DcLotteryDrawItem();
							
							dcLotteryDrawItem.setPhase(phase);
							dcLotteryDrawItem.setMatchIndex(Integer.parseInt(catchColumns[0].toPlainTextString().trim()));
							dcLotteryDrawItem.setLeague(CoreStringUtils.trimAll(catchColumns[1].toPlainTextString()));
							homeTeam = CoreStringUtils.trimAll(catchColumns[2].toPlainTextString());
							dcLotteryDrawItem.setHomeTeam(homeTeam);
							awayTeam = CoreStringUtils.trimAll(catchColumns[5].toPlainTextString());
							dcLotteryDrawItem.setAwayTeam(awayTeam);
							
							halfTimeResult = CoreStringUtils.trimAll(catchColumns[3].toPlainTextString());
							dcLotteryDrawItem.setHalfTimeResult(halfTimeResult.replace("-", ":"));
							fullTimeResult = CoreStringUtils.trimAll(catchColumns[4].toPlainTextString());
							dcLotteryDrawItem.setFullTimeResult(fullTimeResult.replace("-", ":"));
							spSFP = trimAllForNumber(catchColumns[6].toPlainTextString());
							dcLotteryDrawItem.setSpSFP(spSFP);
							spJQS = trimAllForNumber(catchColumns[9].toPlainTextString());
							dcLotteryDrawItem.setSpJQS(spJQS);
							spSXDS = trimAllForNumber(catchColumns[7].toPlainTextString());
							dcLotteryDrawItem.setSpSXDS(spSXDS);
							spBF = trimAllForNumber(catchColumns[8].toPlainTextString());
							dcLotteryDrawItem.setSpBF(spBF);
							spBCSFP = trimAllForNumber(catchColumns[10].toPlainTextString());
							dcLotteryDrawItem.setSpBCSFP(spBCSFP);
							logger.info(dcLotteryDrawItem.getLogInfo());
							list.add(dcLotteryDrawItem);
						}
					}//end for catchRows.length
				}
			}
		} catch (Exception e) {
			logger.error(logHeader+"解析单场开奖结果发生错误"+e.getMessage(),e);
			return null;
		}
		return list;
	}
	
	protected String trimAllForNumber(String str) {
		if (str != null) {
			return StringUtils.replace(CoreStringUtils.trimAll(str), ",", "");
		}
		return StringUtils.EMPTY;
	}
}
