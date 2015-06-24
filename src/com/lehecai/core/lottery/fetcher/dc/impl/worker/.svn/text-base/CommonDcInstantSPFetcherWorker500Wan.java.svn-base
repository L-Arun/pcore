package com.lehecai.core.lottery.fetcher.dc.impl.worker;

import java.util.List;
import java.util.Map;

import org.htmlparser.tags.OptionTag;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.DcSPType;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.dc.AbstractDcInstantSPFetcherWorker;
import com.lehecai.core.lottery.fetcher.dc.DcInstantSPItem;
import com.lehecai.core.util.CoreFetcherUtils;
import com.lehecai.core.util.CoreXmlUtils;

/**
 * 从500wan网站中抓取北京单场的即时SP值
 * @author 唐容
 *
 */
public class CommonDcInstantSPFetcherWorker500Wan extends
		AbstractDcInstantSPFetcherWorker {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	protected static final String DC_PHASE_URL_500Wan = "http://zc.trade.500wan.com/bjdc/index.php"; // 抓取500万的当前彩期号地址
	protected static final String InstantSP_URL_500Wan = "http://trade.500wan.com/static/public/bjdc/xml/sp/"; // 500万即时sp的抓取地址前缀
	
	@Override
	public List<DcInstantSPItem> fetchDcInstantSP(String phase,LotteryType lotteryType) {
		String encoding = "GBK";
		String siteName = "500万[即时SP抓取]";
		String logHeader = siteName;
		String lotteryPhase = null;//实际页面抓取的期号
		String webInfo = null;
		String phaseName = null;
		String url = null;
		
		url = this.getURL(InstantSP_URL_500Wan, lotteryType);
		webInfo = CoreFetcherUtils.URLGet(DC_PHASE_URL_500Wan, null, encoding);
		if (webInfo == null || webInfo.indexOf("404 Not Found") > 0) {
			logger.error(logHeader+"当前期,data is null or 404 Not Found");
			return null;
		}
		//处理彩期
		if(phase==null){
			phaseName = "抓取==当前期==";
			logHeader = siteName+InstantSP_URL_500Wan+phaseName; 		
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
		
		logHeader = siteName+url+phaseName;
		
		logger.info(logHeader+"本地期号为:"+lotteryPhase);
		
		url = this.getURLByPhaseNo(InstantSP_URL_500Wan, lotteryType , lotteryPhase);
		webInfo = CoreFetcherUtils.URLGet(url, null, encoding);
		if (webInfo == null || webInfo.indexOf("404 Not Found") > 0) {
			logger.error(logHeader+"当前期,data is null or 404 Not Found");
			return null;
		}
		
		List<DcInstantSPItem> list = null;
		
		// 解析即时sp的xml数据
		list = parseDcIntantSPXml(webInfo, lotteryPhase, encoding, lotteryType);
		
		/* 废弃,500wan的即时sp地址发生错误,原无法正常正常抓取 note by lm 2011-02-24
		DcInstantSPItem dcInstantSPItem = null;
		
		try { 
			list = new ArrayList<DcInstantSPItem>();
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
						if(catchColumns!=null&&catchColumns.length>=10){
							dcInstantSPItem = new DcInstantSPItem();
							dcInstantSPItem.setPhase(lotteryPhase);	//彩期号
							dcInstantSPItem.setMatchIndex(Integer.parseInt(catchColumns[0].toPlainTextString().trim()));	//场次
							dcInstantSPItem.setLeague(catchColumns[1].toPlainTextString().trim());		//比赛类型
							dcInstantSPItem.setHomeTeam(catchColumns[4].toPlainTextString().trim());	//主场
							
							Map<DcSPType, String> spmap = new HashMap<DcSPType,String>();
							
							//分彩种获取对应SP值
							if(lotteryType == LotteryType.DC_SFP){		//让球胜负平
								dcInstantSPItem.setAwayTeam(catchColumns[6].toPlainTextString().trim());	//客队
			
								spmap.put(DcSPType.SFP_S,dealSPStr(catchColumns[15].toPlainTextString().trim()));
								spmap.put(DcSPType.SFP_P,dealSPStr(catchColumns[16].toPlainTextString().trim()));
								spmap.put(DcSPType.SFP_F,dealSPStr(catchColumns[17].toPlainTextString().trim()));
							}else if( lotteryType == LotteryType.DC_JQS ){		//总进球数
								dcInstantSPItem.setAwayTeam(catchColumns[5].toPlainTextString().trim());	//客队
								spmap.put(DcSPType.JQX_0, dealSPStr(catchColumns[8].toPlainTextString().trim()));
								spmap.put(DcSPType.JQX_1, dealSPStr(catchColumns[9].toPlainTextString().trim()));
								spmap.put(DcSPType.JQX_2, dealSPStr(catchColumns[10].toPlainTextString().trim()));
								spmap.put(DcSPType.JQX_3, dealSPStr(catchColumns[11].toPlainTextString().trim()));
								spmap.put(DcSPType.JQX_4, dealSPStr(catchColumns[12].toPlainTextString().trim()));
								spmap.put(DcSPType.JQX_5, dealSPStr(catchColumns[13].toPlainTextString().trim()));
								spmap.put(DcSPType.JQX_6, dealSPStr(catchColumns[14].toPlainTextString().trim()));
								spmap.put(DcSPType.JQX_7, dealSPStr(catchColumns[15].toPlainTextString().trim()));
							}else if( lotteryType == LotteryType.DC_SXDS ){		//上下单双
								dcInstantSPItem.setAwayTeam(catchColumns[5].toPlainTextString().trim());	//客队
								spmap.put(DcSPType.SXDS_SD, dealSPStr(catchColumns[8].toPlainTextString().trim()));
								spmap.put(DcSPType.SXDS_SS, dealSPStr(catchColumns[9].toPlainTextString().trim()));
								spmap.put(DcSPType.SXDS_XD, dealSPStr(catchColumns[10].toPlainTextString().trim()));
								spmap.put(DcSPType.SXDS_XS, dealSPStr(catchColumns[11].toPlainTextString().trim()));
							}else if( lotteryType == LotteryType.DC_BF ){		//比分
								dcInstantSPItem.setAwayTeam(catchColumns[5].toPlainTextString().trim());	//客队
								
								Parser trParser = Parser.createParser(catchRows[i+1].toHtml(), encoding);
								NodeFilter trFilter = new TagNameFilter("table");
								NodeList tableList = trParser.extractAllNodesThatMatch(trFilter);	
								if(tableList != null && tableList.size() > 0){
									TableTag spTable = (TableTag) tableList.elementAt(0);
									this.FetchBFIntantSP(spTable, spmap);
								}
							}else{		//半场胜负平
								dcInstantSPItem.setAwayTeam(catchColumns[5].toPlainTextString().trim());	//客队
								spmap.put(DcSPType.BCSFP_SS, dealSPStr(catchColumns[8].toPlainTextString().trim()));
								spmap.put(DcSPType.BCSFP_SP, dealSPStr(catchColumns[9].toPlainTextString().trim()));
								spmap.put(DcSPType.BCSFP_SF, dealSPStr(catchColumns[10].toPlainTextString().trim()));
								spmap.put(DcSPType.BCSFP_PS, dealSPStr(catchColumns[11].toPlainTextString().trim()));
								spmap.put(DcSPType.BCSFP_PP, dealSPStr(catchColumns[12].toPlainTextString().trim()));
								spmap.put(DcSPType.BCSFP_PF, dealSPStr(catchColumns[13].toPlainTextString().trim()));
								spmap.put(DcSPType.BCSFP_FS, dealSPStr(catchColumns[14].toPlainTextString().trim()));
								spmap.put(DcSPType.BCSFP_FP, dealSPStr(catchColumns[15].toPlainTextString().trim()));
								spmap.put(DcSPType.BCSFP_FF, dealSPStr(catchColumns[16].toPlainTextString().trim()));
							}
							dcInstantSPItem.setSpmap(spmap);
//							logger.info(dcInstantSPItem.toString());
							list.add(dcInstantSPItem);
						}
					}//end for catchRows.length
				}
			}
		} catch (Exception e) {
			logger.error(logHeader+"解析即时SP值时发生错误"+e.getMessage(),e);
		}
		*/
		
		return list;
	}
	
	/**
	 * url拼接
	 * @param url
	 * @param dcLotteryType
	 * @return
	 */
	private String getURL(String url, LotteryType dcLotteryType){
		
		if( dcLotteryType == LotteryType.DC_SFP){
			url += "zc.php?nav=0";
		}else if(dcLotteryType == LotteryType.DC_JQS){
			url += "jq.php?nav=1";
		}else if(dcLotteryType == LotteryType.DC_SXDS){
			url += "ds.php?nav=2";
		}else if(dcLotteryType == LotteryType.DC_BF){
			url += "bf.php?nav=3";
		}else{
			url += "bqc.php?nav=4";
		}
		
		return url;		
	}
	/**
	 * 根据url前缀,彩种和彩期号获得对应单场即时sp地址
	 * @param url
	 * @param dcLotteryType
	 * @param phaseNo
	 * @return
	 */
	private String getURLByPhaseNo(String url, LotteryType dcLotteryType,String phaseNo){
		if( dcLotteryType.getValue() == LotteryType.DC_SFP.getValue()){
			url += "just_"+phaseNo+"_34.xml";
		}else if(dcLotteryType.getValue() == LotteryType.DC_JQS.getValue()){
			url += "just_"+phaseNo+"_40.xml";
		}else if(dcLotteryType.getValue() == LotteryType.DC_SXDS.getValue()){
			url += "just_"+phaseNo+"_41.xml";
		}else if(dcLotteryType.getValue() == LotteryType.DC_BF.getValue()){
			url += "just_"+phaseNo+"_42.xml";
		}else{
			url += "just_"+phaseNo+"_51.xml";
		}
		return url;
	}
	/**
	 * 解析单场即时SP抓取到的xml文件
	 * @param webInfo
	 * @param phase
	 * @param encoding
	 * @param dcLotteryType
	 * @return
	 */
	private List<DcInstantSPItem> parseDcIntantSPXml(String webInfo, String phase, String encoding,LotteryType dcLotteryType){
		if( dcLotteryType.getValue() == LotteryType.DC_SFP.getValue()){
			return CoreXmlUtils.getDcSfpInstantSPList(webInfo, phase, encoding);
		}else if(dcLotteryType.getValue() == LotteryType.DC_JQS.getValue()){
			return CoreXmlUtils.getDcJqsInstantSPList(webInfo, phase, encoding);
		}else if(dcLotteryType.getValue() == LotteryType.DC_SXDS.getValue()){
			return CoreXmlUtils.getDcSxdsInstantSPList(webInfo, phase, encoding);
		}else if(dcLotteryType.getValue() == LotteryType.DC_BF.getValue()){
			return CoreXmlUtils.getDcBfInstantSPList(webInfo, phase, encoding);
		}else{
			return CoreXmlUtils.getDcBcsfpInstantSPList(webInfo, phase, encoding);
		}
	}
	
	
	
	/**
	 * 获取比赛类型是全场比分时的即时sp值
	 * @param spTable
	 * @param spmap
	 */
	@SuppressWarnings("unused")
	private void FetchBFIntantSP(TableTag spTable, Map<DcSPType, String> spmap){
		TableRow[] spRows = spTable.getRows();
		TableColumn[] spCol_S = spRows[0].getColumns();
		TableColumn[] spCol_P = spRows[1].getColumns();
		TableColumn[] spCol_F = spRows[2].getColumns();

		spmap.put(DcSPType.BF_S_Other, this.getSPStr(spCol_S[1]));
		spmap.put(DcSPType.BF_S_10, this.getSPStr(spCol_S[2]));
		spmap.put(DcSPType.BF_S_20, this.getSPStr(spCol_S[3]));
		spmap.put(DcSPType.BF_S_21, this.getSPStr(spCol_S[4]));
		spmap.put(DcSPType.BF_S_30, this.getSPStr(spCol_S[5]));
		spmap.put(DcSPType.BF_S_31, this.getSPStr(spCol_S[6]));
		spmap.put(DcSPType.BF_S_32, this.getSPStr(spCol_S[7]));
		spmap.put(DcSPType.BF_S_40, this.getSPStr(spCol_S[8]));
		spmap.put(DcSPType.BF_S_41, this.getSPStr(spCol_S[9]));
		spmap.put(DcSPType.BF_S_42, this.getSPStr(spCol_S[10]));
		
		spmap.put(DcSPType.BF_P_Other, this.getSPStr(spCol_P[1]));
		spmap.put(DcSPType.BF_P_0, this.getSPStr(spCol_P[2]));
		spmap.put(DcSPType.BF_P_1, this.getSPStr(spCol_P[3]));
		spmap.put(DcSPType.BF_P_2, this.getSPStr(spCol_P[4]));
		spmap.put(DcSPType.BF_P_3, this.getSPStr(spCol_P[5]));
		
		spmap.put(DcSPType.BF_F_Other, this.getSPStr(spCol_F[1]));
		spmap.put(DcSPType.BF_F_01, this.getSPStr(spCol_F[2]));
		spmap.put(DcSPType.BF_F_02, this.getSPStr(spCol_F[3]));
		spmap.put(DcSPType.BF_F_12, this.getSPStr(spCol_F[4]));
		spmap.put(DcSPType.BF_F_03, this.getSPStr(spCol_F[5]));
		spmap.put(DcSPType.BF_F_13, this.getSPStr(spCol_F[6]));
		spmap.put(DcSPType.BF_F_23, this.getSPStr(spCol_F[7]));
		spmap.put(DcSPType.BF_F_04, this.getSPStr(spCol_F[8]));
		spmap.put(DcSPType.BF_F_14, this.getSPStr(spCol_F[9]));
		spmap.put(DcSPType.BF_F_24, this.getSPStr(spCol_F[10]));
	}
	
	/**
	 * 从TableColumn中得到sp的值
	 * @param col
	 * @return
	 */
	private String getSPStr(TableColumn col){	//比赛过期后，取消值了的列的的列数会变为5
		String strSP = "";
		if( col.getChildCount() > 6 ){
			strSP = col.getChild(6).toPlainTextString();	
			strSP = this.dealSPStr(strSP);
		}
		return strSP;
	}
	
	private String dealSPStr(String strSP){
		if(strSP.indexOf("(") >= 0 ){
			strSP = strSP.substring(strSP.indexOf("(")+1, strSP.indexOf(")")).trim();
		}
		if(strSP.equals("--")){
			strSP = "";
		}
		return strSP;
	}
}
