/**
 * 
 */
package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherLotteryTypeMap;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDrawPrizeItem;
import com.lehecai.core.util.CoreFetcherUtils;
import com.lehecai.core.util.CoreStringUtils;


/**
 * 全国开奖页面星彩网通用抓取页面实现类
 * @author Sunshow
 *
 */
public class CountryLotteryDrawFetchWorkerSTARLOTT extends AbstractLotteryDrawFetchWorker {
	
	private static Map<LotteryType, String> defaultUrlMap = new HashMap<LotteryType, String>();
	private static Map<LotteryType, String> historyUrlMap = new HashMap<LotteryType, String>();
	
	static {
		//"31选7", 542
		defaultUrlMap.put(LotteryType.A_31x7, "http://31x7.starlott.com");
		historyUrlMap.put(LotteryType.A_31x7, "http://31x7.starlott.com");
		//七星彩
		defaultUrlMap.put(LotteryType.QXC, "http://qxc.starlott.com");
		historyUrlMap.put(LotteryType.QXC, "http://qxc.starlott.com");
		//七乐彩
		defaultUrlMap.put(LotteryType.QLC, "http://qlc.starlott.com");
		historyUrlMap.put(LotteryType.QLC, "http://qlc.starlott.com");
		//福彩3D
		defaultUrlMap.put(LotteryType.FC3D, "http://3d.starlott.com");
		historyUrlMap.put(LotteryType.FC3D, "http://3d.starlott.com");
		//超级大乐透
		defaultUrlMap.put(LotteryType.DLT, "http://kj.starlott.com/kj/detail.do?code=SHTCDLT");
		historyUrlMap.put(LotteryType.DLT, "http://kj.starlott.com/kj/detail.do?code=SHTCDLT&issue=%s");
		//15选5
		defaultUrlMap.put(LotteryType.HD15X5, "http://kj.starlott.com/kj/detail.do?code=FCJS15X5");
		historyUrlMap.put(LotteryType.HD15X5, "http://kj.starlott.com/kj/detail.do?code=FCJS15X5&issue=%s");
		//东方6+1
		defaultUrlMap.put(LotteryType.DF6J1, "http://df61.starlott.com");
		historyUrlMap.put(LotteryType.DF6J1, "http://df61.starlott.com");
		//双色球
		defaultUrlMap.put(LotteryType.SSQ, "http://ssq.starlott.com/");
		historyUrlMap.put(LotteryType.SSQ, "http://ssq.starlott.com/");
		//排列5
		defaultUrlMap.put(LotteryType.PL5, "http://p5.starlott.com/");
		historyUrlMap.put(LotteryType.PL5, "http://p5.starlott.com/");
		//排列3
		defaultUrlMap.put(LotteryType.PL3, "http://p3.starlott.com/");
		historyUrlMap.put(LotteryType.PL3, "http://p3.starlott.com/");
		//胜负彩
		defaultUrlMap.put(LotteryType.SFC, "http://zc.starlott.com/sfc");
		historyUrlMap.put(LotteryType.SFC, "http://zc.starlott.com/sfc");
		//胜负任九
		defaultUrlMap.put(LotteryType.SFR9, "http://zc.starlott.com/sfc");
		historyUrlMap.put(LotteryType.SFR9, "http://zc.starlott.com/sfc");
		//4场进球
		defaultUrlMap.put(LotteryType.JQC, "http://zc.starlott.com/jqc");
		historyUrlMap.put(LotteryType.JQC, "http://zc.starlott.com/jqc");
		//6场半全场
		defaultUrlMap.put(LotteryType.BQC, "http://zc.starlott.com/bqc");
		historyUrlMap.put(LotteryType.BQC, "http://zc.starlott.com/bqc");
		//22选5
		defaultUrlMap.put(LotteryType.TC22X5, "http://22x5.starlott.com");
		historyUrlMap.put(LotteryType.TC22X5, "http://22x5.starlott.com");
	}
	
	private static Map<LotteryType, String> lotteryDetailUrlMap = new HashMap<LotteryType, String>();
	
	protected void setLotteryDetailUrl(LotteryType lotteryType, String url) {
		synchronized (this) {
			lotteryDetailUrlMap.put(lotteryType, url);
		}
	}
	
	protected String getLotteryDetailUrl(LotteryType lotteryType) {
		synchronized (this) {
			return lotteryDetailUrlMap.get(lotteryType);
		}
	}

	
	protected final String siteName = "星彩网";
	protected final String lotteryScope = "全国开奖";
	protected String volumeOfSalesName = "cathMoney";
	//特殊情况用以区分页面同名不同的彩种,如胜负彩任九,子类可根据情况重写
	protected String lotteryMiddleKeyValue = "";
	
	protected static final String RESULT_URL = "http://kj.starlott.com";
	
	public CountryLotteryDrawFetchWorkerSTARLOTT(LotteryType lotteryType){
		super(lotteryType);
	}
	
	@Override
	public LotteryDraw fetchResult(String phase) {
		LotteryType lotteryType = this.getLotteryType();
		
		String url = RESULT_URL;
		String pageInfo = "列表页面"+url;
		String logHeader = "=="+lotteryScope+"=="+siteName+"=="+pageInfo+"==抓取=="+getLotteryType().getName()+"==";
		logger.info(logHeader+"开始==");
		LotteryDraw lotteryOpenResult = null;
		String encoding = "utf-8";
		
		String data = null;
		Parser parser = null;

		
		data = CoreFetcherUtils.URLGet(url, null, encoding);
		
		if (data == null || data.indexOf("404 Not Found") > 0) {
			logger.error(logHeader+"data is null or 404 Not Found");
			return null;
		}
		parser = Parser.createParser(data, encoding);
		
		String filterStr = "table";
		NodeFilter filter = new TagNameFilter(filterStr);
		NodeList nodeList = null;

		try {
			nodeList = parser.extractAllNodesThatMatch(filter);
		} catch (ParserException e2) {
			logger.error(logHeader+"数据解析错误=="+e2.getMessage(), e2);
			return null;
		}
		try{
			TableTag tableTag = (TableTag)nodeList.elementAt(0);
			TableRow[] tableRows=tableTag.getRows();
			TableColumn[] tableRowColumns = null;
			int startIndex = 0;
			for(int i=1;i<tableRows.length;i++){
				tableRowColumns=tableRows[i].getColumns();
				String detailLink = null;
				String lotteryName = null;
				/*
				detailLink=tableRowColumns[startIndex].getStringText().split("href=\"")[1].split("/\"")[0];
				lotteryName=tableRowColumns[startIndex].getStringText().split(">")[1].split("<")[0].trim();
				*/
				//获取含有链接td的对应href和text
				NodeList childList = tableRowColumns[startIndex].getChildren();
				LinkTag linkNode = null;
				if(childList!=null&&childList.size()>0){
					for(int m = 0;m<childList.size();m++){
						if(childList.elementAt(m) instanceof LinkTag){
							linkNode = (LinkTag)childList.elementAt(m);
							detailLink = linkNode.getLink().trim();
							lotteryName = linkNode.getLinkText().trim();
						}
					}
				}
				String lotteryPhase = null;//页面抓取的彩期号
				//判断是否是所抓类型
				if(getLotteryType().getValue() == FetcherLotteryTypeMap.getLotteryValueByKey(FetcherType.T_STARLOTT.getName()+lotteryMiddleKeyValue+lotteryName)){
					lotteryPhase=tableRowColumns[startIndex+1].getStringText().trim().split("期")[0];
					if(lotteryPhase==null){
						logger.error(logHeader+"页面抓取的彩期号({})不存在,返回null==",lotteryPhase);
						return null;
					}
					//处理列表页面抓取的彩期
					//指定彩期为null，抓取列表页面的彩期数据
					if(phase==null||phase.isEmpty()){
						phase = lotteryPhase;
						//当前期可写入详细url，以便抓取对应的详细信息
						this.setLotteryDetailUrl(lotteryType, detailLink);
					}else{
						if(lotteryPhase.equals(phase)){
							phase = lotteryPhase;
						}else{
							logger.error(logHeader+"指定抓取的彩期号({})与页面抓取的彩期号({})不一致,返回null==",phase,lotteryPhase);
							return null;
						}
					}
					String timeDraw = tableRowColumns[startIndex+2].getStringText();
					String columnTmp = tableRowColumns[startIndex+3].getStringText().trim();
					NodeFilter subFilter = new TagNameFilter("li");
					NodeList subNodeList = null;
					Parser subParser = null;
					StringBuffer openPrizeCodeSb = new StringBuffer();
					String result = null;
					try {
						subParser = Parser.createParser(columnTmp, "utf-8");
						subNodeList = subParser.extractAllNodesThatMatch(subFilter);
						for (Node node : subNodeList.toNodeArray()) {
							openPrizeCodeSb.append(node.toPlainTextString().trim()).append(",");
						}
						result = openPrizeCodeSb.toString();
						if(result!=null&&result.length()>0){
							result = result.substring(0,result.length()-1);
						}
					} catch (ParserException e3){
						logger.error(e3.getMessage(), e3);
						return null;
					}
					//奖池有可能不存在
					String jackpot = null;
					if(tableRowColumns!=null&&tableRowColumns.length>=5){
						jackpot = tableRowColumns[startIndex+4].toPlainTextString().trim();
						if(jackpot.indexOf("元")>0&&jackpot.indexOf("奖池:")>0){
							jackpot = tableRowColumns[startIndex+3].toPlainTextString().trim().split("元")[0].split("奖池:")[1].replaceAll(",", "");
						}else{
							jackpot=null;
						}
					}
					
					lotteryOpenResult = new LotteryDraw();
					lotteryOpenResult.setPhase(lotteryPhase);
					lotteryOpenResult.setResult(result);
					//格式化时间串
					lotteryOpenResult.setTimeDraw(CoreFetcherUtils.formatTimeDraw(timeDraw));
					lotteryOpenResult.setJackpot(jackpot);
					lotteryOpenResult.setLotteryType(getLotteryType());
					
					logger.info(logHeader+lotteryOpenResult.getLotteryOpenResultLogMsg());
					break;
				}
			}//end for
		}catch(Exception e1){
			logger.error(logHeader+"页面错误=="+e1.getMessage(),e1);
			return null;
		}
		logger.info(logHeader+"结束==");
		return lotteryOpenResult;
	}

	@Override
	public LotteryDraw fetchResultDetail(String phase) {
		String url = this.getResultDetailUrl(phase);
		if(url==null||url.isEmpty()){
			logger.error("=="+lotteryScope+"=="+siteName+"==详细页面==抓取=="+getLotteryType().getName()+"==期号："+phase+"==详细地址不存在，返回null");
			return null;
		}
		String pageInfo = "详细页面"+url;
		String logHeader = "=="+lotteryScope+"=="+siteName+"=="+pageInfo+"==抓取=="+getLotteryType().getName()+"==";
		LotteryDraw lotteryOpenResult=null;
		String encoding = "utf-8";
		String data = null;
		Parser parser = null;
		
		String lotteryPhase = null;
		String result = null;
		List<LotteryDrawPrizeItem> resultDetail = null;
		LotteryDrawPrizeItem lotteryDrawPrizeItem = null;
		String timeDraw = null;
		String volumeOfSales=null;
		String jackpot=null;
		logger.info(logHeader+"开始==");
		
		data = CoreFetcherUtils.URLGet(url, null, encoding);
		
		parser = Parser.createParser(data, encoding);
		String tmpStr = null;
		NodeFilter scriptFilter = new TagNameFilter("script");
		NodeList scriptNodeList = null;
		String lotteryCode = null;//星彩网彩票编码
		try{
			scriptNodeList = parser.extractAllNodesThatMatch(scriptFilter);
			for(int i=0;i<scriptNodeList.size();i++){
				tmpStr = scriptNodeList.elementAt(i).toPlainTextString();
				if(tmpStr.indexOf("ArrondiUtil")>-1){
					lotteryCode = tmpStr.split("ArrondiUtil")[1];
					lotteryCode = lotteryCode.split(";")[0];
					Pattern pattern = Pattern.compile("\\w+");   
			        Matcher matcher = pattern.matcher(lotteryCode);
			        if(matcher.find()){
			        	lotteryCode = matcher.group();
			        }
				}
			}
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
		//彩期号不存在,是当前期，抓取当前期详细页面内容
		if(phase==null||phase.isEmpty()){
			NodeFilter optionFilter = new TagNameFilter("option");
			NodeList optionNodeList = null;
			try{
				parser.reset();
				optionNodeList = parser.extractAllNodesThatMatch(optionFilter);
				tmpStr = optionNodeList.elementAt(0).toPlainTextString();
				lotteryPhase = tmpStr;
			}catch(Exception e){
				logger.error(logHeader+"获取当前期号错误"+e.getMessage(),e);
				return null;
			}
		}else{
			lotteryPhase = phase;
		}
		
		//模拟异步读取星彩开奖详细内容
		String ajaxUrl = url.substring(0,url.indexOf(".com")+4) +"/dwr/exec/Index.getAwardInfo.dwr";
		pageInfo = "详细页面"+ajaxUrl;
		//修正日志信息头
		logHeader = "=="+lotteryScope+"=="+siteName+"=="+pageInfo+"==抓取=="+getLotteryType().getName()+"==";
		
		HashMap<String,String> postParams = new HashMap<String,String>();
		postParams.put("callCount", "1");
		postParams.put("c0-scriptName", "Index");
		postParams.put("c0-methodName", "getAwardInfo");
		//postParams.put("c0-id", "1182_1285388909272");
		postParams.put("c0-param0", "string:"+lotteryCode);
		postParams.put("c0-param1", "string:"+lotteryPhase);
		postParams.put("xml", "true");
		data = CoreFetcherUtils.URLPost(ajaxUrl, postParams, encoding);
		
		if (data == null || data.indexOf("404 Not Found") > 0) {
			logger.error(logHeader+" data is null or 404 Not Found");
			return null;
		}
		try{
			String[] tmpArray = data.split("\";");
			tmpArray = tmpArray[0].split("=");
			String jsonStr = tmpArray[2];
			jsonStr = CoreStringUtils.unicodeToString(jsonStr);
			jsonStr = jsonStr.replaceAll("\\\\", "");
			JSONObject js = JSONObject.fromObject(jsonStr);
			
			timeDraw = js.getString("awardTime");
			result = js.getString("awardNumber");
			result = result.replace(":", ",");
			volumeOfSales = js.getString(volumeOfSalesName);
			volumeOfSales = volumeOfSales.replaceAll(",", "");
			jackpot = js.getString("awardPool");
			jackpot = jackpot.replaceAll(",", "");
			JSONArray ja = js.getJSONArray("moneies");
			
			if(ja!=null){
				resultDetail = new ArrayList<LotteryDrawPrizeItem>();
				JSONObject jsTmp = null;
				//StringBuffer tmpSb = new StringBuffer("");
				String tmpRecord = null;
				String tmpMoney = null;
				String prizeItemName = "";//奖项名称
				for(int i=0;i<ja.size();i++){
					jsTmp = ja.getJSONObject(i);
					prizeItemName = jsTmp.getString("level");
					tmpRecord = jsTmp.getString("prizeNumber");
					tmpMoney = jsTmp.getString("prizew");
					tmpMoney = tmpMoney.replaceAll(",", "");
					/*
					tmpSb.append("prize").append((i+1)).append("^").append(tmpRecord).append("^").append(tmpMoney);
					if(i<(ja.size()-1)){
						tmpSb.append("#");
					}
					resultDetail = tmpSb.toString();
					*/
					lotteryDrawPrizeItem = new LotteryDrawPrizeItem();
					lotteryDrawPrizeItem.setName(prizeItemName);
					lotteryDrawPrizeItem.setWinningCount(tmpRecord);
					lotteryDrawPrizeItem.setPrizeAmount(tmpMoney);
					resultDetail.add(lotteryDrawPrizeItem);
				}
			}
		}catch(Exception e){
			logger.error(logHeader+"解析异步请求数据错误"+e.getMessage(),e);
			return null;
		}
		

		lotteryOpenResult = new LotteryDraw();
		lotteryOpenResult.setPhase(lotteryPhase);
		lotteryOpenResult.setResult(result);
		//格式化时间串
		lotteryOpenResult.setTimeDraw(CoreFetcherUtils.formatTimeDraw(timeDraw));
		lotteryOpenResult.setJackpot(jackpot);
		lotteryOpenResult.setVolumeOfSales(volumeOfSales);
		lotteryOpenResult.setLotteryType(getLotteryType());
		lotteryOpenResult.setResultDetail(resultDetail);
		
		logger.info(logHeader+lotteryOpenResult.getLotteryOpenResultLogMsg());
		logger.info(logHeader+"结束==");
		return lotteryOpenResult;
	}

	@Override
	protected String getResultDetailUrl(String phase) {
		String url = this.getLotteryDetailUrl(this.getLotteryType());
		if (url != null) {
			return url;
		}
		if (phase != null && phase.trim().length() > 0) {
			return historyUrlMap.get(this.getLotteryType());
		}
		return defaultUrlMap.get(this.getLotteryType());
	}

	@Override
	protected String getResultUrl(String phase) {
		return null;
	}
}
