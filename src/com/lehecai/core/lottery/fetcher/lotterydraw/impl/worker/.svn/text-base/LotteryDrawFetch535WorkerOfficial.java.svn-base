package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
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

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDrawPrizeItem;
import com.lehecai.core.util.CoreFetcherUtils;

/**
 * 三晋福彩网 开奖结果抓取
 * 抓取三晋风采21选5  <br/>
 * 历史地址:http://www.sjfc.org.cn/cade/215/215hitoryanalyse100.html  <br/>
 * @author liurd
 *
 */
public class LotteryDrawFetch535WorkerOfficial extends AbstractLotteryDrawFetchWorker {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	protected static final String RESULT_LOCALITY_URL = "http://www.sjfc.org.cn/xml/c521Prize.xml";
	protected static final String RESULT_MORE_LOCALITY_URL = "http://www.sjfc.org.cn/cade/215/215hitoryanalyse100.html";
	
	protected String siteName = "三晋福彩网";
	protected String lotteryScope = "三晋风采21选5";
	
	public LotteryDrawFetch535WorkerOfficial() {
		super(LotteryType.A_SJFC21);
	}
	
	@Override
	public LotteryDraw fetchResultDetail(String phase) {
		
		LotteryDraw lotteryDraw = null;
		lotteryDraw = nowPhaseResult();
		if (phase == null || "".equals(phase) || lotteryDraw.getPhase().equals(phase)  ) {
			return lotteryDraw;
		} else {
			lotteryDraw = null;
		}
		
		String url = RESULT_MORE_LOCALITY_URL;
		
		String data = null;
		String pageInfo = "结果页面" + url;
		String encoding = "utf-8";
		String logHeader = "==" + lotteryScope + "==" + siteName + "=="
				+ pageInfo + "==抓取==" + getLotteryType().getName() + "==";

		try {
			data = CoreFetcherUtils.URLGet(url, null, encoding);
		} catch (Exception e) {
			logger.error("获取html数据失败" + e.getMessage());
			return null;
		}
		
		if (data == null || data.indexOf("404 Not Found") > 0 || data.isEmpty()) {
			logger.error(logHeader + "data is null or 404 Not Found");
			return null;
		}	
		Parser parser = null;
		
		try {
			parser = Parser.createParser(data,  encoding);
		} catch (Exception e) {
			logger.error("解析html页面失败" + e.getMessage());
			return null;
		}
		
		NodeFilter filter = new HasAttributeFilter("class", "mytable");		
		NodeList nodeList = null;
		
		try {
			nodeList = parser.extractAllNodesThatMatch(filter);
			TableTag tableTag = (TableTag) nodeList.elementAt(0);
			TableRow[] tableRows = tableTag.getRows();
			for (int i = 2; i < tableRows.length; i++) {
				TableColumn[] tableColumns = tableRows[i].getColumns();
				String phaseTmp = tableColumns[1].toPlainTextString();
				if (phaseTmp != null && !"".equals(phaseTmp) && phase.equals(phaseTmp)) {
					lotteryDraw = new LotteryDraw();
					//彩期
					lotteryDraw.setPhase(phaseTmp);
					//开奖结果
					lotteryDraw.setResult(tableColumns[2].toPlainTextString().replace(" ", ","));
					//彩种
					lotteryDraw.setLotteryType(super.getLotteryType());
					break;
				}
			}
		} catch (ParserException e) {
			logger.error("数据解析错误==" + e.getMessage(), e);
			return null;
		}
		return lotteryDraw;
	}

	private LotteryDraw nowPhaseResult() {
		String url = RESULT_LOCALITY_URL;
		
		LotteryDraw lotteryDraw = new LotteryDraw();
		String data = null;
		String pageInfo = "结果页面" + url;
		String encoding = "utf-8";
		String logHeader = "==" + lotteryScope + "==" + siteName + "=="
				+ pageInfo + "==抓取==" + getLotteryType().getName() + "==";

		try {
			data = CoreFetcherUtils.URLGet(url, null, encoding);
		} catch (Exception e) {
			logger.error("获取html数据失败" + e.getMessage());
			return null;
		}
		
		if (data == null || data.indexOf("404 Not Found") > 0 || data.isEmpty()) {
			logger.error(logHeader + "data is null or 404 Not Found");
			return null;
		}	
		
		List<LotteryDrawPrizeItem> lotteryDrawPrizeItemList = new ArrayList<LotteryDrawPrizeItem>();
		
		SAXReader saxReader = new SAXReader();
		Document document = DocumentFactory.getInstance().createDocument();
		
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(data.getBytes(encoding));
			document = saxReader.read(bais);
			Iterator<?> it = document.getRootElement().elementIterator();
			int itCount = 9;
			while (it.hasNext()) {
				Element element = (Element) it.next();
				if (itCount > 0) {
					itCount--;
					continue;
				}
				Iterator<?> childIt = element.elementIterator();
				Element childElement = null;
				String name = "";
				String count = "";
				String bonus = "";
				
				while (childIt.hasNext()) {
					childElement = (Element) childIt.next();
					if (childElement.getName().equals("code")) {
						lotteryDraw.setResult(childElement.getTextTrim());
					}
					if (childElement.getName().equals("term")) {
						lotteryDraw.setPhase(childElement.getTextTrim());
						lotteryDraw.setLotteryType(getLotteryType());
					}
					if (childElement.getName().equals("drawOpenDate")) {
						lotteryDraw.setTimeDraw(childElement.getTextTrim() + " 00:00:00");
					}
					if (childElement.getName().equals("drawSaleCount")) {
						lotteryDraw.setVolumeOfSales(childElement.getTextTrim().replace(",", ""));
					}
					if (childElement.getName().equals("drawPrizePoolCount")) {
						lotteryDraw.setJackpot(childElement.getTextTrim().replace(",", ""));
					}
					if (childElement.getName().equals("name")) {
						name = childElement.getTextTrim();
					}
					if (childElement.getName().equals("count2")) {
						count = childElement.getTextTrim().replace(",", "");
					}
					if (childElement.getName().equals("bonus")) {
						bonus = childElement.getTextTrim().replace(",", "");
					}
					if (name != null && !"".equals(name) && bonus != null && !"".equals(bonus) && count != null && !"".equals(count)) {
						LotteryDrawPrizeItem lotteryDrawPrizeItem = new LotteryDrawPrizeItem();
						lotteryDrawPrizeItem.setName(name);
						lotteryDrawPrizeItem.setWinningCount(count);
						lotteryDrawPrizeItem.setPrizeAmount(bonus);
						name = "";
						bonus = "";
						count = "";
						lotteryDrawPrizeItemList.add(lotteryDrawPrizeItem);
					}
				}
			}
			lotteryDraw.setResultDetail(lotteryDrawPrizeItemList);
		} catch (Exception e) {
			logger.error("数据解析错误==" + e.getMessage(), e);
			return null;
		} 
		return lotteryDraw;
	}

	@Override
	public LotteryDraw fetchResult(String phase) {
		return null;
	}

	@Override
	protected String getResultDetailUrl(String phase) {
		return null;
	}

	@Override
	protected String getResultUrl(String phase) {
		return null;
	}
}
