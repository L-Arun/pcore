package com.lehecai.core.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.DcSPType;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.dc.DcInstantSPItem;
import com.lehecai.core.lottery.fetcher.football.FootballScheduleItem;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.util.lottery.FetcherLotteryDrawConverter;

/**
 * xml工具类
 * @author leiming
 *
 */
public class CoreXmlUtils {
	private static final Logger logger = LoggerFactory.getLogger(CoreXmlUtils.class.getName());
	
	/**
	 * 获得子元素列表
	 * @param filePath
	 * @param parentElemName
	 * @param childElemName
	 * @return
	 */
	public static List<String> getValueList(String xmlPath, String parentElemName,String childElemName) {
		ArrayList<String> list = new ArrayList<String>();
		String chileElemValue = null;
		SAXReader saxreader = new SAXReader();
		Document document = DocumentFactory.getInstance().createDocument();
		try {
			document = saxreader.read(xmlPath);
			Iterator<?> it = document.getRootElement().elementIterator();
			while (it.hasNext()) {
				Element element = (Element) it.next();
				Iterator<?> childIt = element.elementIterator(childElemName);
				while (childIt.hasNext()) {
					Element childElement = (Element) childIt.next();
					chileElemValue = childElement.getTextTrim();
					list.add(chileElemValue);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return list;
	}
	/**
	 * 获取xmlData的足球赛程列表
	 * @param xmlData
	 * @param phase
	 * @param encoding 编码 默认utf-8
	 * @return List<FootballScheduleItem>
	 */
	public static List<FootballScheduleItem> getSFCScheduleList(String xmlData,String phase,String encoding){
		List<FootballScheduleItem> list = null;
		if(xmlData!=null&&xmlData.trim().length()>0&&phase!=null){
			FootballScheduleItem footballScheduleItem = null;
			SAXReader saxReader = new SAXReader();
			Document document = DocumentFactory.getInstance().createDocument();
			String enc = encoding;
			if(encoding==null){
				enc = "utf-8";//默认utf-8
			}
			try {
				ByteArrayInputStream bais = new ByteArrayInputStream(xmlData.getBytes(enc)); 
				document = saxReader.read(bais);
				Iterator<?> it = document.getRootElement().elementIterator();
				int matchIndex = 1; // 场次顺序
				String league = null; // 联赛或赛事名称
				Date matchTime = null; // 比赛时间
				String homeTeam = null; // 主队
				String awayTeam = null; // 客队
				list = new ArrayList<FootballScheduleItem>();
				while (it.hasNext()) {
					Element element = (Element) it.next();
					footballScheduleItem = new FootballScheduleItem();
					Iterator<?> childIt = element.elementIterator();
					Element childElement = null;
					String chileElemValue = null;
					/*
					<matchid>290795</matchid>
					<matchtime>2010-10-16 22:00:00</matchtime>
					<leaguename>英　　超,106,#FF3333</leaguename>
					<seasonname>2010/2011英格兰超级联赛,2114</seasonname>
					<hometeam>阿森纳,554</hometeam>
					<awayteam>伯明翰,701</awayteam>
					<statusid>1</statusid>
					<score>:-:</score>
					*/
					while (childIt.hasNext()) {
						childElement = (Element) childIt.next();
						if(childElement.getName().equals("leaguename")){
							chileElemValue = childElement.getTextTrim();
							chileElemValue = chileElemValue.substring(0,chileElemValue.indexOf(","));
							chileElemValue = chileElemValue.replaceAll("　", "");
							chileElemValue = chileElemValue.replaceAll(" ", "");
							league = chileElemValue;
							footballScheduleItem.setLeague(CoreStringUtils.trimAll(league));
						}
						if(childElement.getName().equals("matchtime")){
							chileElemValue = childElement.getTextTrim();
							matchTime = CoreDateUtils.parseLongDate(chileElemValue);
							footballScheduleItem.setMatchTime(matchTime);
						}
						if(childElement.getName().equals("hometeam")){
							chileElemValue = childElement.getTextTrim();
							chileElemValue = chileElemValue.substring(0,chileElemValue.indexOf(","));
							homeTeam = chileElemValue;
							footballScheduleItem.setHomeTeam(CoreStringUtils.trimAll(homeTeam));
						}
						if(childElement.getName().equals("awayteam")){
							chileElemValue = childElement.getTextTrim();
							chileElemValue = chileElemValue.substring(0,chileElemValue.indexOf(","));
							awayTeam = chileElemValue;
							footballScheduleItem.setAwayTeam(CoreStringUtils.trimAll(awayTeam));
						}
						footballScheduleItem.setMatchIndex(matchIndex);
						footballScheduleItem.setPhase(phase);
					}
					list.add(footballScheduleItem);
					logger.info(footballScheduleItem.getLogInfo());
					matchIndex++;
				}
				bais.close();
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}
		return list;
	}
	/**
	 * 创建抓取奖项映射   Map<String, Map<String, String>>
	 * key:fetcherType.getName() + "_" + lotteryType.getValue()
	 * value:Map<String, String>   key:抓取网站的中文奖项名  value:本站中文奖项名
	 * @return
	 */
	public static Map<String, Map<String, String>> createFetcherPrizeItemMapping(){
		Map<String, Map<String,String>> fetcherPrizeItemMapping = new HashMap<String, Map<String,String>>();
		Map<String,String> lotteryPrizeItemMapping = null;//某个具体彩票外网网站和本站奖项的映射
		InputStream in = CoreXmlUtils.class.getClassLoader().getResourceAsStream("prizeItemConfig.xml");
		SAXReader saxReader = new SAXReader();
		Document document = DocumentFactory.getInstance().createDocument();
		final String attr_fetcherTypeValue="fetcherTypeValue";
		final String attr_lotteryValue = "value";
		final String attr_siteName="siteName";
		final String attr_lehecaiName="lehecaiName";
		final String tag_lottery = "lottery";
		final String tag_prizeItem = "prizeItem";
		Integer fetcherTypeValue = null;
		Integer lotteryTypeValue = null;
		FetcherType fetcherType = null;
		LotteryType lotteryType = null;
		String siteName = null;
		String lehecaiName = null;
		String key = null;
		try {
			document = saxReader.read(in);
			Iterator<?> it = document.getRootElement().elementIterator();
			while (it.hasNext()) {
				Element siteElement = (Element) it.next();//site element
				fetcherTypeValue = Integer.parseInt(siteElement.attributeValue(attr_fetcherTypeValue));
				fetcherType = FetcherType.getItem(fetcherTypeValue);
				Iterator<?> childIt = siteElement.elementIterator(tag_lottery);
				while (childIt.hasNext()) {
					Element lotteryElement = (Element) childIt.next();
					lotteryTypeValue = Integer.parseInt(lotteryElement.attributeValue(attr_lotteryValue));
					lotteryType = LotteryType.getItem(lotteryTypeValue);
					Iterator<?> prizeItemIt = lotteryElement.elementIterator(tag_prizeItem);
					lotteryPrizeItemMapping = new HashMap<String,String>();
					while(prizeItemIt.hasNext()){
						Element prizeItemElement = (Element) prizeItemIt.next();
						siteName = prizeItemElement.attributeValue(attr_siteName);
						lehecaiName = prizeItemElement.attributeValue(attr_lehecaiName);
						logger.info(fetcherType.getName()+"["+lotteryType.getName()+"],siteName:"+siteName+",lehecaiName:"+lehecaiName);
						lotteryPrizeItemMapping.put(siteName, lehecaiName);
					}
					key = FetcherLotteryDrawConverter.generateKey(fetcherType, lotteryType);
					fetcherPrizeItemMapping.put(key, lotteryPrizeItemMapping);
					logger.info(fetcherType.getName()+"["+lotteryType.getName()+"]彩票的中文奖项映射放入映射内存");
				}
			}
		} catch (Exception e) {
			logger.error("解析prizeItemConfig.xml文件发生错误,"+e.getMessage(),e);
			return null;
		}
		return fetcherPrizeItemMapping;
	}
	/**
	 * 竞彩篮球比赛名称映射   Map<String, Map<String, String>>
	 * key:fetcherType.getName() + "_" + lotteryType.getValue()
	 * value:Map<String, String>   key:抓取网站的比赛名称  value:本站中比赛简称
	 * @return
	 */
	public static Map<String, Map<String, String>> createFetcherMatchNameMapping(){
		Map<String, Map<String,String>> fetcherMatchNameMapping = new HashMap<String, Map<String,String>>();
		Map<String,String> lotteryMatchNameMapping = null;//某个具体彩票外网网站和本站奖项的映射
		InputStream in = CoreXmlUtils.class.getClassLoader().getResourceAsStream("jclqMatchNameConfig.xml");
		SAXReader saxReader = new SAXReader();
		Document document = DocumentFactory.getInstance().createDocument();
		final String attr_fetcherTypeValue="fetcherTypeValue";
		final String attr_lotteryValue = "value";
		final String attr_siteName="siteName";
		final String attr_lehecaiName="lehecaiName";
		final String tag_lottery = "lottery";
		final String tag_prizeItem = "prizeItem";
		Integer fetcherTypeValue = null;
		Integer lotteryTypeValue = null;
		FetcherType fetcherType = null;
		LotteryType lotteryType = null;
		String siteName = null;
		String lehecaiName = null;
		String key = null;
		try {
			document = saxReader.read(in);
			Iterator<?> it = document.getRootElement().elementIterator();
			while (it.hasNext()) {
				Element siteElement = (Element) it.next();//site element
				fetcherTypeValue = Integer.parseInt(siteElement.attributeValue(attr_fetcherTypeValue));
				fetcherType = FetcherType.getItem(fetcherTypeValue);
				Iterator<?> childIt = siteElement.elementIterator(tag_lottery);
				while (childIt.hasNext()) {
					Element lotteryElement = (Element) childIt.next();
					lotteryTypeValue = Integer.parseInt(lotteryElement.attributeValue(attr_lotteryValue));
					lotteryType = LotteryType.getItem(lotteryTypeValue);
					Iterator<?> prizeItemIt = lotteryElement.elementIterator(tag_prizeItem);
					lotteryMatchNameMapping = new HashMap<String,String>();
					while(prizeItemIt.hasNext()){
						Element prizeItemElement = (Element) prizeItemIt.next();
						siteName = prizeItemElement.attributeValue(attr_siteName);
						lehecaiName = prizeItemElement.attributeValue(attr_lehecaiName);
						logger.info(fetcherType.getName()+"["+lotteryType.getName()+"],siteName:"+siteName+",lehecaiName:"+lehecaiName);
						lotteryMatchNameMapping.put(siteName, lehecaiName);
					}
					key = FetcherLotteryDrawConverter.generateKey(fetcherType, lotteryType);
					fetcherMatchNameMapping.put(key, lotteryMatchNameMapping);
					logger.info(fetcherType.getName()+"["+lotteryType.getName()+"]彩票的中文奖项映射放入映射内存");
				}
			}
		} catch (Exception e) {
			logger.error("解析jclqMatchNameConfig.xml文件发生错误,"+e.getMessage(),e);
			return null;
		}
		return fetcherMatchNameMapping;
	}
	public static void main(String[] args){
		createFetcherPrizeItemMapping();
	}
	public static LotteryDraw parseFrequentLotteryDraw(String xmlData, LotteryDraw lotteryDraw, String encoding) {
		if (xmlData == null || xmlData.isEmpty()) {
			return null;
		}
		
		String enc = encoding;
		if(encoding==null){
			enc = "utf-8";//默认utf-8
		}
		
		try {
			SAXReader saxReader = new SAXReader();
			Document document = DocumentFactory.getInstance().createDocument();
			ByteArrayInputStream bais = new ByteArrayInputStream(xmlData.getBytes(enc)); 
			document = saxReader.read(bais);
			Iterator<?> it = document.getRootElement().elementIterator();
			while (it.hasNext()) {
				Element rootElement = (Element) it.next();
				String expectValue = rootElement.attributeValue("expect");
				String opencodeValue = rootElement.attributeValue("opencode");
				String opentimeValue = rootElement.attributeValue("opentime");
				
				lotteryDraw.setPhase(expectValue);
				lotteryDraw.setResult(opencodeValue);
				lotteryDraw.setTimeDraw(CoreFetcherUtils.formatTimeDraw(opentimeValue));
				
				return lotteryDraw;
			}
		} catch (Exception e) {
			logger.error("解析高频彩开奖XML数据发生错误,"+e.getMessage(),e);
			return null;
		}
		return null;
	}
	/**
	 * 获取xmlData的单场胜负平即时Sp列表
	 * @param xmlData
	 * @param phase
	 * @param encoding 编码 默认utf-8
	 * @return List<FootballScheduleItem>
	 */
	public static List<DcInstantSPItem> getDcSfpInstantSPList(String xmlData,String phaseNo,String encoding){
		List<DcInstantSPItem> list = null;
		if(xmlData!=null&&xmlData.trim().length()>0&&phaseNo!=null){
			DcInstantSPItem dcInstantSPItem = null;
			SAXReader saxReader = new SAXReader();
			Document document = DocumentFactory.getInstance().createDocument();
			String enc = encoding;
			if(encoding==null){
				enc = "utf-8";//默认utf-8
			}
			try {
				ByteArrayInputStream bais = new ByteArrayInputStream(xmlData.getBytes(enc)); 
				document = saxReader.read(bais);
				Iterator<?> it = document.getRootElement().elementIterator();
				int matchIndex = 0; // 场次顺序
				String league = null; // 联赛或赛事名称
				String homeTeam = null; // 主队
				String awayTeam = null; // 客队
				list = new ArrayList<DcInstantSPItem>();
				while (it.hasNext()) {
					Element element = (Element) it.next();
					dcInstantSPItem = new DcInstantSPItem();
					Map<DcSPType, String> spmap = new HashMap<DcSPType,String>();
					/*
					 <w1 c1="" c2="" c3="" c4="" c5="2.07" c6="" h="中央陆军" a="塞萨洛尼基" r="2" gt="2001:00" gn="欧洲联赛" st=""/>
					 */
					
					// 联赛
					league = element.attributeValue("gn");
					homeTeam = element.attributeValue("h");
					awayTeam = element.attributeValue("a");
					String elementName = element.getName();
					matchIndex = getMatchIndexByElementName(elementName);
					
					spmap.put(DcSPType.SFP_S,element.attributeValue("c1"));
					spmap.put(DcSPType.SFP_P,element.attributeValue("c3"));
					spmap.put(DcSPType.SFP_F,element.attributeValue("c5"));
					
					dcInstantSPItem.setMatchIndex(matchIndex);
					dcInstantSPItem.setLeague(league);
					dcInstantSPItem.setHomeTeam(homeTeam);
					dcInstantSPItem.setAwayTeam(awayTeam);
					dcInstantSPItem.setSpmap(spmap);
					dcInstantSPItem.setPhase(phaseNo);
					
					list.add(dcInstantSPItem);
					//logger.info(dcInstantSPItem.getLogInfo());
					//matchIndex++;
				}
				bais.close();
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}
		return list;
	}
	/**
	 * 获取xmlData的单场进球数即时Sp列表
	 * @param xmlData
	 * @param phase
	 * @param encoding 编码 默认utf-8
	 * @return List<FootballScheduleItem>
	 */
	public static List<DcInstantSPItem> getDcJqsInstantSPList(String xmlData,String phaseNo,String encoding){
		List<DcInstantSPItem> list = null;
		if(xmlData!=null&&xmlData.trim().length()>0&&phaseNo!=null){
			DcInstantSPItem dcInstantSPItem = null;
			SAXReader saxReader = new SAXReader();
			Document document = DocumentFactory.getInstance().createDocument();
			String enc = encoding;
			if(encoding==null){
				enc = "utf-8";//默认utf-8
			}
			try {
				ByteArrayInputStream bais = new ByteArrayInputStream(xmlData.getBytes(enc)); 
				document = saxReader.read(bais);
				Iterator<?> it = document.getRootElement().elementIterator();
				int matchIndex = 0; // 场次顺序
				String league = null; // 联赛或赛事名称
				String homeTeam = null; // 主队
				String awayTeam = null; // 客队
				list = new ArrayList<DcInstantSPItem>();
				while (it.hasNext()) {
					Element element = (Element) it.next();
					dcInstantSPItem = new DcInstantSPItem();
					Map<DcSPType, String> spmap = new HashMap<DcSPType,String>();
					/*
					 <w1 c1="" c2="" c3="" c4="" c5="4.15" c6="" c7="" c8="" c9="" c10="" c11="" c12="" c13="" 
					 c14="" c15="" c16="" h="中央陆军" a="塞萨洛尼基" r="" gt="2002-23 01:00" gn="欧洲联赛" st=""/>
					 */
					
					// 联赛
					league = element.attributeValue("gn");
					homeTeam = element.attributeValue("h");
					awayTeam = element.attributeValue("a");
					String elementName = element.getName();
					matchIndex = getMatchIndexByElementName(elementName);
					
					
					spmap.put(DcSPType.JQS_0, element.attributeValue("c1"));
					spmap.put(DcSPType.JQS_1, element.attributeValue("c3"));
					spmap.put(DcSPType.JQS_2, element.attributeValue("c5"));
					spmap.put(DcSPType.JQS_3, element.attributeValue("c7"));
					spmap.put(DcSPType.JQS_4, element.attributeValue("c9"));
					spmap.put(DcSPType.JQS_5, element.attributeValue("c11"));
					spmap.put(DcSPType.JQS_6, element.attributeValue("c13"));
					spmap.put(DcSPType.JQS_7, element.attributeValue("c15"));
					
					dcInstantSPItem.setMatchIndex(matchIndex);
					dcInstantSPItem.setLeague(league);
					dcInstantSPItem.setHomeTeam(homeTeam);
					dcInstantSPItem.setAwayTeam(awayTeam);
					dcInstantSPItem.setSpmap(spmap);
					dcInstantSPItem.setPhase(phaseNo);
					
					list.add(dcInstantSPItem);
					//logger.info(dcInstantSPItem.getLogInfo());
					//matchIndex++;
				}
				bais.close();
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}
		return list;
	}
	/**
	 * 获取xmlData的单场上下单双即时Sp列表
	 * @param xmlData
	 * @param phase
	 * @param encoding 编码 默认utf-8
	 * @return List<FootballScheduleItem>
	 */
	public static List<DcInstantSPItem> getDcSxdsInstantSPList(String xmlData,String phaseNo,String encoding){
		List<DcInstantSPItem> list = null;
		if(xmlData!=null&&xmlData.trim().length()>0&&phaseNo!=null){
			DcInstantSPItem dcInstantSPItem = null;
			SAXReader saxReader = new SAXReader();
			Document document = DocumentFactory.getInstance().createDocument();
			String enc = encoding;
			if(encoding==null){
				enc = "utf-8";//默认utf-8
			}
			try {
				ByteArrayInputStream bais = new ByteArrayInputStream(xmlData.getBytes(enc)); 
				document = saxReader.read(bais);
				Iterator<?> it = document.getRootElement().elementIterator();
				int matchIndex = 0; // 场次顺序
				String league = null; // 联赛或赛事名称
				String homeTeam = null; // 主队
				String awayTeam = null; // 客队
				list = new ArrayList<DcInstantSPItem>();
				while (it.hasNext()) {
					Element element = (Element) it.next();
					dcInstantSPItem = new DcInstantSPItem();
					Map<DcSPType, String> spmap = new HashMap<DcSPType,String>();
					/*
					 <w51 c1="5.30" c2="" c3="8.99" c4="" c5="2.96" c6="" c7="2.76" c8="" 
					 h="利物浦" a="布拉格斯巴达" r="" gt="2002:00" gn="欧洲联赛" st=""/>
					 */
					
					// 联赛
					league = element.attributeValue("gn");
					homeTeam = element.attributeValue("h");
					awayTeam = element.attributeValue("a");
					String elementName = element.getName();
					matchIndex = getMatchIndexByElementName(elementName);
					
					
					spmap.put(DcSPType.SXDS_SD, element.attributeValue("c1"));
					spmap.put(DcSPType.SXDS_SS, element.attributeValue("c3"));
					spmap.put(DcSPType.SXDS_XD, element.attributeValue("c5"));
					spmap.put(DcSPType.SXDS_XS, element.attributeValue("c7"));
					
					dcInstantSPItem.setMatchIndex(matchIndex);
					dcInstantSPItem.setLeague(league);
					dcInstantSPItem.setHomeTeam(homeTeam);
					dcInstantSPItem.setAwayTeam(awayTeam);
					dcInstantSPItem.setSpmap(spmap);
					dcInstantSPItem.setPhase(phaseNo);
					
					list.add(dcInstantSPItem);
					//logger.info(dcInstantSPItem.getLogInfo());
					//matchIndex++;
				}
				bais.close();
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}
		return list;
	}
	/**
	 * 获取xmlData的单场比分即时Sp列表
	 * @param xmlData
	 * @param phase
	 * @param encoding 编码 默认utf-8
	 * @return List<FootballScheduleItem>
	 */
	public static List<DcInstantSPItem> getDcBfInstantSPList(String xmlData,String phaseNo,String encoding){
		List<DcInstantSPItem> list = null;
		if(xmlData!=null&&xmlData.trim().length()>0&&phaseNo!=null){
			DcInstantSPItem dcInstantSPItem = null;
			SAXReader saxReader = new SAXReader();
			Document document = DocumentFactory.getInstance().createDocument();
			String enc = encoding;
			if(encoding==null){
				enc = "utf-8";//默认utf-8
			}
			try {
				ByteArrayInputStream bais = new ByteArrayInputStream(xmlData.getBytes(enc)); 
				document = saxReader.read(bais);
				Iterator<?> it = document.getRootElement().elementIterator();
				int matchIndex = 0; // 场次顺序
				String league = null; // 联赛或赛事名称
				String homeTeam = null; // 主队
				String awayTeam = null; // 客队
				list = new ArrayList<DcInstantSPItem>();
				while (it.hasNext()) {
					Element element = (Element) it.next();
					dcInstantSPItem = new DcInstantSPItem();
					Map<DcSPType, String> spmap = new HashMap<DcSPType,String>();
					/*
					 * 胜sp   <w1 c1="" c2="" c3="" c4="" c5="" c6="" c7="" c8="" c9="" c10="" 
					 * 平sp   c11="" c12="" c13="17.72" c14="" c15="" 
					 * 负sp   c16="" c17="" c18="" c19="" c20="" c21="" c22="" c23="" c24="" c25="" 
					 *        h="中央陆军" a="塞萨洛尼基" gt="2001:00" gn="欧洲联赛" st=""/>
					 */
					
					// 联赛
					league = element.attributeValue("gn");
					homeTeam = element.attributeValue("h");
					awayTeam = element.attributeValue("a");
					String elementName = element.getName();
					matchIndex = getMatchIndexByElementName(elementName);
					
					//主胜sp
					spmap.put(DcSPType.BF_S_Other, element.attributeValue("c1"));
					spmap.put(DcSPType.BF_S_10, element.attributeValue("c2"));
					spmap.put(DcSPType.BF_S_20, element.attributeValue("c3"));
					spmap.put(DcSPType.BF_S_21, element.attributeValue("c4"));
					spmap.put(DcSPType.BF_S_30, element.attributeValue("c5"));
					spmap.put(DcSPType.BF_S_31, element.attributeValue("c6"));
					spmap.put(DcSPType.BF_S_32, element.attributeValue("c7"));
					spmap.put(DcSPType.BF_S_40, element.attributeValue("c8"));
					spmap.put(DcSPType.BF_S_41, element.attributeValue("c9"));
					spmap.put(DcSPType.BF_S_42, element.attributeValue("c10"));
					
					//平sp
					spmap.put(DcSPType.BF_P_Other, element.attributeValue("c11"));
					spmap.put(DcSPType.BF_P_0, element.attributeValue("c12"));
					spmap.put(DcSPType.BF_P_1, element.attributeValue("c13"));
					spmap.put(DcSPType.BF_P_2, element.attributeValue("c14"));
					spmap.put(DcSPType.BF_P_3, element.attributeValue("c15"));
					
					//客胜sp
					spmap.put(DcSPType.BF_F_Other, element.attributeValue("c16"));
					spmap.put(DcSPType.BF_F_01, element.attributeValue("c17"));
					spmap.put(DcSPType.BF_F_02, element.attributeValue("c18"));
					spmap.put(DcSPType.BF_F_12, element.attributeValue("c19"));
					spmap.put(DcSPType.BF_F_03, element.attributeValue("c20"));
					spmap.put(DcSPType.BF_F_13, element.attributeValue("c21"));
					spmap.put(DcSPType.BF_F_23, element.attributeValue("c22"));
					spmap.put(DcSPType.BF_F_04, element.attributeValue("c23"));
					spmap.put(DcSPType.BF_F_14, element.attributeValue("c24"));
					spmap.put(DcSPType.BF_F_24, element.attributeValue("c25"));
					
					dcInstantSPItem.setMatchIndex(matchIndex);
					dcInstantSPItem.setLeague(league);
					dcInstantSPItem.setHomeTeam(homeTeam);
					dcInstantSPItem.setAwayTeam(awayTeam);
					dcInstantSPItem.setSpmap(spmap);
					dcInstantSPItem.setPhase(phaseNo);
					
					list.add(dcInstantSPItem);
					//logger.info(dcInstantSPItem.getLogInfo());
					//matchIndex++;
				}
				bais.close();
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}
		return list;
	}
	/**
	 * 获取xmlData的单场半全场即时Sp列表
	 * @param xmlData
	 * @param phase
	 * @param encoding 编码 默认utf-8
	 * @return List<FootballScheduleItem>
	 */
	public static List<DcInstantSPItem> getDcBcsfpInstantSPList(String xmlData,String phaseNo,String encoding){
		List<DcInstantSPItem> list = null;
		if(xmlData!=null&&xmlData.trim().length()>0&&phaseNo!=null){
			DcInstantSPItem dcInstantSPItem = null;
			SAXReader saxReader = new SAXReader();
			Document document = DocumentFactory.getInstance().createDocument();
			String enc = encoding;
			if(encoding==null){
				enc = "utf-8";//默认utf-8
			}
			try {
				ByteArrayInputStream bais = new ByteArrayInputStream(xmlData.getBytes(enc)); 
				document = saxReader.read(bais);
				Iterator<?> it = document.getRootElement().elementIterator();
				int matchIndex = 0; // 场次顺序
				String league = null; // 联赛或赛事名称
				String homeTeam = null; // 主队
				String awayTeam = null; // 客队
				list = new ArrayList<DcInstantSPItem>();
				while (it.hasNext()) {
					Element element = (Element) it.next();
					dcInstantSPItem = new DcInstantSPItem();
					Map<DcSPType, String> spmap = new HashMap<DcSPType,String>();
					/*
					<w50 c1="3.91" c2="" c3="24.81" c4="" c5="45.30" c6="" c7="5.54" c8="" c9="6.64" c10="" c11="5.55" 
					c12="" c13="51.84" c14="" c15="15.96" c16="" c17="11.33" c18="" h="里斯本竞技" a="格拉斯哥流浪者" r="" gt="2002-25 02:00" gn="欧洲联赛" st=""/>
					 */
					
					// 联赛
					league = element.attributeValue("gn");
					homeTeam = element.attributeValue("h");
					awayTeam = element.attributeValue("a");
					String elementName = element.getName();
					matchIndex = getMatchIndexByElementName(elementName);
					
					//主胜sp
					spmap.put(DcSPType.BCSFP_SS, element.attributeValue("c1"));
					spmap.put(DcSPType.BCSFP_SP, element.attributeValue("c3"));
					spmap.put(DcSPType.BCSFP_SF, element.attributeValue("c5"));
					spmap.put(DcSPType.BCSFP_PS, element.attributeValue("c7"));
					spmap.put(DcSPType.BCSFP_PP, element.attributeValue("c9"));
					spmap.put(DcSPType.BCSFP_PF, element.attributeValue("c11"));
					spmap.put(DcSPType.BCSFP_FS, element.attributeValue("c13"));
					spmap.put(DcSPType.BCSFP_FP, element.attributeValue("c15"));
					spmap.put(DcSPType.BCSFP_FF, element.attributeValue("c17"));
					
					dcInstantSPItem.setMatchIndex(matchIndex);
					dcInstantSPItem.setLeague(league);
					dcInstantSPItem.setHomeTeam(homeTeam);
					dcInstantSPItem.setAwayTeam(awayTeam);
					dcInstantSPItem.setSpmap(spmap);
					dcInstantSPItem.setPhase(phaseNo);
					
					list.add(dcInstantSPItem);
					//logger.info(dcInstantSPItem.getLogInfo());
					//matchIndex++;
				}
				bais.close();
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}
		return list;
	}
	
	private static int getMatchIndexByElementName(String elementName){
		int matchIndex = 0;
		String indexStr = elementName.replaceAll("w", "");
		try{
			matchIndex = Integer.parseInt(indexStr);
		}catch(Exception e){
			logger.error("转换单场场次序列号为整型数字发生错误", e);
		}
		
		return matchIndex;
	}
	
	
}
