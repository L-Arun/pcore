package com.lehecai.core.lottery.fetcher.football.impl.worker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.football.AbstractFootballScheduleFetchWorker;
import com.lehecai.core.lottery.fetcher.football.FootballScheduleItem;
import com.lehecai.core.util.CoreFetcherUtils;
import com.lehecai.core.util.CoreStringUtils;

/**
 * 4场进球 足球赛程 Okooo 抓取worker
 * 2010-3-30
 *
 */
public class FootballScheduleFetch9WorkerOkooo extends AbstractFootballScheduleFetchWorker {
		protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
		
		protected final static String JQC_SCHEDULE_FETCH_URL_OKOOO = "http://www.okooo.com/zucai/jinqiu/";
		
		protected String siteName = "Okooo";

		@Override
		public List<FootballScheduleItem> fetchFootballSchedule(String phase) {
			String fetchLotteryInfo = "["+getLotteryType().getName().trim()+" 足球赛程]";//抓取彩票信息

			this.setFetchPhase(phase);
			if(this.getFetchPhase()==null||"".equals(this.getFetchPhase())){
				this.getPhase();
			}
			String url = this.getScheduleUrl();
			if(url==null||url.isEmpty()){
				logger.error(siteName+"==抓取==期号:"+this.getFetchPhase()+"==地址url:"+url+"不存在，返回null");
				return null;
			}
			String encoding = "GBK";
			String phaseInfo = "第<"+this.getFetchPhase()+">期";//彩期信息
			String logHeader = siteName+fetchLotteryInfo+"=="+url+"==抓取=="+phaseInfo+"==";
			
			logger.info(logHeader+"开始==");
			List<FootballScheduleItem> footballScheduleItems=new ArrayList<FootballScheduleItem>();
			
			String data=null;
			
			data = CoreFetcherUtils.URLGet(url+"/"+this.getFetchPhase(), null, encoding);
			if (data == null || data.indexOf("404 Not Found") > 0) {
				logger.error(logHeader+"data is null or 404 Not Found");
				return null;
			}
			
			Parser parser= Parser.createParser(data,  encoding);

			NodeList nodeList = null;
			NodeFilter tableFilter = new HasAttributeFilter("class", "ContentBrim");
			try {
				nodeList = parser.extractAllNodesThatMatch(tableFilter);
				TableRow[] tableRows = ((TableTag)nodeList.elementAt(0)).getRows();
				for(int i=2,j=1;i<10;i=i+2,j++){
					FootballScheduleItem footballScheduleItem = new FootballScheduleItem();
					TableColumn[] tableColumnHome = tableRows[i].getColumns();
					TableColumn[] tableColumnAway = tableRows[i+1].getColumns();
					//场次
					footballScheduleItem.setMatchIndex(j);
					//主队
					footballScheduleItem.setHomeTeam(CoreStringUtils.trimAll(tableColumnHome[1].toPlainTextString()));
					//客队
					footballScheduleItem.setAwayTeam(CoreStringUtils.trimAll(tableColumnAway[1].toPlainTextString()));
					//联赛或赛事名称
					footballScheduleItem.setLeague(CoreStringUtils.trimAll(tableColumnHome[6].getChildren().elementAt(0).toPlainTextString()));
					//比赛时间
					String strDate = tableColumnHome[6].getChildren().elementAt(2).toPlainTextString().trim();
					if(!(strDate.indexOf(":") > 0)){
						footballScheduleItem.setMatchTime(null);	
					}else{
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.set(cal.get(Calendar.YEAR), Integer.parseInt(strDate.substring(0,2))-1, 
								Integer.parseInt(strDate.substring(3,5)), Integer.parseInt(strDate.substring(6,8)), 
								Integer.parseInt(strDate.substring(9,11)), 0);
						Date date = cal.getTime();
						footballScheduleItem.setMatchTime(date);
					}
					//期号
					if(this.getFetchPhase()!=null&&!"".equals(this.getFetchPhase())){
						footballScheduleItem.setPhase(this.getFetchPhase());
					}
					else{
						return null;
					}
					
					logger.info(footballScheduleItem.getLogInfo());
					footballScheduleItems.add(footballScheduleItem);
				}
				logger.info(logHeader+"抓取足球赛程共"+footballScheduleItems.size()+"场。");
			}catch(ParserException e2){
				logger.error("数据解析错误=="+e2.getMessage(), e2);
				return null;
			}
			return footballScheduleItems;
		}
		
		public void getPhase() {
				
			String url = this.getScheduleUrl();
			if(url==null||url.isEmpty()){
				logger.error(siteName+"==抓取==彩期以及地址url错误==");
				
			}
			String encoding = "GBK";
			
			String data=null;
			
			
			
			data = CoreFetcherUtils.URLGet(url, null, encoding);
			if (data == null || data.indexOf("404 Not Found") > 0) {
				logger.error("data is null or 404 Not Found");
				
			}
			
			Parser parser= Parser.createParser(data,  encoding);

			NodeList nodeList = null;
			NodeFilter tableFilter = new HasAttributeFilter("class", "Buttongl");
			try {
				nodeList = parser.extractAllNodesThatMatch(tableFilter);
				String phase = nodeList.elementAt(0).toHtml().substring(nodeList.elementAt(0).toHtml().indexOf("value=")+7, nodeList.elementAt(0).toHtml().indexOf("期"));
				this.setFetchPhase(phase);
								
			}catch(ParserException e2){
				logger.error("数据解析错误=="+e2.getMessage(), e2);
				
			}
		}

		@Override
		public String getScheduleUrl() {
			// TODO Auto-generated method stub
			return JQC_SCHEDULE_FETCH_URL_OKOOO;
		}
	}

