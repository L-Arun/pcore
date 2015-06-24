package com.lehecai.core.lottery.fetcher.dc.impl.worker;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.OptionTag;
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

public class CommonDcLotteryDrawFetchWorkerAIBO extends AbstractDcLotteryDrawFetchWorker{
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	protected static final String LOTTERYDRAW_URL_AIBO = "http://result.aibo123.com/Notice/GameResult/DataCenter/Prize/Html/Wares_new2008/";
	protected static final String DEFAULT_LOTTERYDRAW_URL_AIBO = "http://result.aibo123.com/GameResult/HPOResult.aspx";
	
	public List<DcLotteryDrawItem> fetchDcLotteryDraw(String phase){
		String encoding = "GBK";
		String spaceMark = "&nbsp;";
		String siteName = "爱波网[单场开奖结果]";
		String logHeader = siteName;
		String lotteryPhase = null;//实际页面抓取的期号
		String webInfo = null;
		String phaseName = null;
		String url = null;
		//处理彩期
		if(phase==null){
			phaseName = "抓取==当前期==";
			logHeader = siteName+DEFAULT_LOTTERYDRAW_URL_AIBO+phaseName;
			webInfo = CoreFetcherUtils.URLGet(DEFAULT_LOTTERYDRAW_URL_AIBO, null, encoding);
			if (webInfo == null || webInfo.indexOf("404 Not Found") > 0) {
				logger.error(logHeader+"当前期,data is null or 404 Not Found");
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
		}else{
			phaseName = "抓取==指定期==";
			lotteryPhase = phase;
		}
		//爱波网抓取必须去掉本地期号的首位
		url = LOTTERYDRAW_URL_AIBO + lotteryPhase.substring(1) + "_zh.html";
		logHeader = siteName+url+phaseName;
		
		logger.info(logHeader+"本地期号为:"+lotteryPhase);

		webInfo = CoreFetcherUtils.URLGet(url, null, encoding);
		if (webInfo == null || webInfo.indexOf("404 Not Found") > 0) {
			logger.error(logHeader+"第<"+lotteryPhase+">期,data is null or 404 Not Found");
			return null;
		}
		
		List<DcLotteryDrawItem> list = null;
		DcLotteryDrawItem dcLotteryDrawItem = null;
		
		try {
			list = new ArrayList<DcLotteryDrawItem>();
			Parser parser = Parser.createParser(webInfo, encoding);
			NodeFilter tableFilter = new TagNameFilter("table");
			NodeList nodeList = parser.extractAllNodesThatMatch(tableFilter);
			if(nodeList!=null&&nodeList.size()>0){
				TableTag catchTableTag=new TableTag();
				catchTableTag = (TableTag)nodeList.elementAt(0);
				if(catchTableTag!=null){
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
						if(catchColumns!=null&&catchColumns.length>=10){
							dcLotteryDrawItem = new DcLotteryDrawItem();
							
							dcLotteryDrawItem.setPhase(lotteryPhase);
							dcLotteryDrawItem.setMatchIndex(Integer.parseInt(catchColumns[0].toPlainTextString().trim()));
							dcLotteryDrawItem.setLeague(catchColumns[1].toPlainTextString().trim());
							homeTeam = catchColumns[2].toPlainTextString().trim();
							if(homeTeam.lastIndexOf("(")>-1){
								homeTeam = homeTeam.substring(0, homeTeam.lastIndexOf("("));
							}
							dcLotteryDrawItem.setHomeTeam(homeTeam);
							awayTeam = catchColumns[5].toPlainTextString().trim();
							dcLotteryDrawItem.setAwayTeam(awayTeam.replaceAll(spaceMark, ""));
							
							halfTimeResult = catchColumns[3].toPlainTextString().trim();
							dcLotteryDrawItem.setHalfTimeResult(halfTimeResult.substring(0, halfTimeResult.length() - 6));
							fullTimeResult = catchColumns[4].toPlainTextString().trim();
							dcLotteryDrawItem.setFullTimeResult(fullTimeResult.substring(0, fullTimeResult.length() - 6));
							spSFP = trimAllForNumber(catchColumns[6].toPlainTextString());
							dcLotteryDrawItem.setSpSFP(spSFP.substring(0, spSFP.length() - 6));
							spJQS = trimAllForNumber(catchColumns[7].toPlainTextString());
							dcLotteryDrawItem.setSpJQS(spJQS.substring(0, spJQS.length() - 6));
							spSXDS = trimAllForNumber(catchColumns[8].toPlainTextString());
							dcLotteryDrawItem.setSpSXDS(spSXDS.substring(0, spSXDS.length() - 6));
							spBF = trimAllForNumber(catchColumns[9].toPlainTextString());
							dcLotteryDrawItem.setSpBF(spBF.substring(0, spBF.length() - 6));
							spBCSFP = trimAllForNumber(catchColumns[10].toPlainTextString());
							dcLotteryDrawItem.setSpBCSFP(spBCSFP.substring(0, spBCSFP.length() - 6));
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
