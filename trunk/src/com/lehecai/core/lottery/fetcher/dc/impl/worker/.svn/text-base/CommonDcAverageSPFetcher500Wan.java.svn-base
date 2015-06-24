package com.lehecai.core.lottery.fetcher.dc.impl.worker;

import java.util.ArrayList;
import java.util.List;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.dc.AbstractDcAverageSPFetcherWorker;
import com.lehecai.core.lottery.fetcher.dc.DcAverageSPItem;
import com.lehecai.core.util.CoreFetcherUtils;

public class CommonDcAverageSPFetcher500Wan extends
		AbstractDcAverageSPFetcherWorker {

	protected Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	protected static final String AverageSP_URL_500Wan = "http://trade.500wan.com/pages/info/bjdc/zc.php?nav=0";
	
	@Override
	public List<DcAverageSPItem> fetchDcAverageSP(String phase) {
		String encoding = "GBK";
		String siteName = "500万[即时SP抓取]";
		String logHeader = siteName;
		String lotteryPhase = null;//实际页面抓取的期号
		String webInfo = null;
		String phaseName = null;
	    String url = null;
	    
		webInfo = CoreFetcherUtils.URLGet(AverageSP_URL_500Wan, null, encoding);
		if (webInfo == null || webInfo.indexOf("404 Not Found") > 0) {
			logger.error(logHeader+"当前期,data is null or 404 Not Found");
			return null;
		}
		
		//处理彩期
		if(phase==null){
			phaseName = "抓取==当前期==";
			logHeader = siteName+AverageSP_URL_500Wan+phaseName; 		
			OptionTag optionNode = CoreFetcherUtils.getSelectedOptionByHtml(webInfo, encoding);
			if(optionNode!=null){
				lotteryPhase = optionNode.getOptionText().trim();
			}
			if(lotteryPhase==null){
				logger.error(logHeader+",当前期号不存在,返回null");
				return null;
			}
			lotteryPhase = lotteryPhase.substring(0, lotteryPhase.indexOf(" ")); //500万当前彩期号显示时 彩期号+" " + "当前期"
		}else{
			phaseName = "抓取==指定期==";
			lotteryPhase = phase;
		}
		
		logHeader = siteName+AverageSP_URL_500Wan+phaseName;
		
		logger.info(logHeader+"本地期号为:"+lotteryPhase);
		
		
		url = AverageSP_URL_500Wan + "&expect=" + lotteryPhase;
		webInfo = CoreFetcherUtils.URLGet(url, null, encoding);
		if (webInfo == null || webInfo.indexOf("404 Not Found") > 0) {
			logger.error(logHeader+"当前期,data is null or 404 Not Found");
			return null;
		}
		
		DcAverageSPItem dcAverageSPItem = null;
		
		List<DcAverageSPItem> list = null;
		
		try {
			list = new ArrayList<DcAverageSPItem>();
			Parser parser = Parser.createParser(webInfo, encoding);
			NodeFilter tableFilter = new TagNameFilter("table");
			HasAttributeFilter tableAttributeFilter = new HasAttributeFilter("id","table_vs");
			AndFilter andFilter = new AndFilter(new NodeFilter[]{tableFilter,tableAttributeFilter});
			NodeList nodeList = parser.extractAllNodesThatMatch(andFilter);
			if(nodeList!=null&&nodeList.size()>0){
				TableTag catchTableTag = (TableTag)nodeList.elementAt(0);
				if(catchTableTag!=null){
					TableRow[] catchRows = catchTableTag.getRows();
					TableColumn[] catchColumns = null;
										
					for(int i = 0; i < catchRows.length; i++){
						if(!(catchRows[i].getAttribute("class")!= null && catchRows[i].getAttribute("class").indexOf("form_tr4") >= 0 ) ){
							continue;
						}
						catchColumns = catchRows[i].getColumns();
						dcAverageSPItem = new DcAverageSPItem();
						dcAverageSPItem.setPhase(lotteryPhase);
						dcAverageSPItem.setMatchIndex(Integer.parseInt(catchColumns[0].toPlainTextString().trim()));
						dcAverageSPItem.setLeague(catchColumns[1].toPlainTextString().trim());
						dcAverageSPItem.setHomeTeam(catchColumns[4].toPlainTextString().trim());
						dcAverageSPItem.setAwayTeam(catchColumns[6].toPlainTextString().trim());
						dcAverageSPItem.setAverageSP_S(catchColumns[8].toPlainTextString().trim());
						dcAverageSPItem.setAverageSP_P(catchColumns[9].toPlainTextString().trim());
						dcAverageSPItem.setAverageSP_F(catchColumns[10].toPlainTextString().trim());
						logger.info(dcAverageSPItem.toString());
						list.add(dcAverageSPItem);
					}
				}
			}
		} catch (Exception e) {
			logger.error(logHeader+"解析平均欧赔时发生错误"+e.getMessage(),e);
		}
					
		return list;
	}

}