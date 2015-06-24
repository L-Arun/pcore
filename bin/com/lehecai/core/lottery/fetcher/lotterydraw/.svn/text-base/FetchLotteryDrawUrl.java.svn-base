package com.lehecai.core.lottery.fetcher.lotterydraw;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
/**
 * 抓取地址 映射实体类
 * 
 * 按抓取类型,彩票类型和当前/历史后缀为key
 * 
 * 注:
 * 如需抓取某种彩票的历史数据,必须在map中记录其对应抓取类型的url
 * 
 * 抓取当前期彩票时,可通过抓取列表页面的彩票的连接地址
 * 作为抓取详细页面的彩票地址,因此在一些只抓取当前期的
 * 彩票(如只在乐和彩网站显示结果不做销售的彩票)时,
 * 无须再为其指定详细页面的地址,系统会自动抓取.
 * 
 * 如果系统跳过列表页面直接抓取详细页面,
 * 仍需要在map中配置该彩种的当前期详细页面抓取地址.
 * 
 * 但如果查询指定彩期(彩票历史)数据时,必须在map中含有其自身历史数据地址,
 * 否则会导致无法抓取
 * @author leiming
 *
 */
public class FetchLotteryDrawUrl {
	private static final Logger logger = LoggerFactory.getLogger(FetchLotteryDrawUrl.class.getName());
	
	/**
	 * 默认详细url后缀，url值为彩票当前期的url地址
	 */
	private static final String _DEFAULT_DETAIL_URL = "_DEFAULT_DETAIL_URL";
	/**
	 * 历史详细url后缀,url值为彩票各历史的url地址，需写入历史期号
	 */
	private static final String _HISTORY_DETAIL_URL = "_HISTORY_DETAIL_URL";
	/**
	 * key: LotteryType+"_"+FetcherType+"DEFAULT_DETAIL_URL|DETAIL_URL"
	 * value:url
	 */
	private static HashMap<String,String> urlMap = new HashMap<String,String>();
	
	//超级大乐透
	private static final String DLT_DETAIL_URL_DEFAULT_500WAN = "http://kaijiang.500wan.com/dlt.shtml";
	private static final String DLT_DETAIL_URL_500WAN = "http://kaijiang.500wan.com/shtml/dlt/%s.shtml";
	private static final String DLT_DETAIL_URL_DEFAULT_STARLOTT = "http://kj.starlott.com/kj/detail.do?code=SHTCDLT";
	private static final String DLT_DETAIL_URL_STARLOTT = "http://kj.starlott.com/kj/detail.do?code=SHTCDLT&issue=%s";
	//七星彩
	private static final String QXC_DETAIL_URL_DEFAULT_500WAN = "http://kaijiang.500wan.com/qxc.shtml";
	private static final String QXC_DETAIL_URL_500WAN = "http://kaijiang.500wan.com/shtml/qxc/%s.shtml";
	private static final String QXC_DETAIL_URL_DEFAULT_STARLOTT = "http://qxc.starlott.com";
	private static final String QXC_DETAIL_URL_STARLOTT = "http://qxc.starlott.com";
	//排列3
	private static final String PL3_DETAIL_URL_DEFAULT_500WAN = "http://kaijiang.500wan.com/pls.shtml";
	private static final String PL3_DETAIL_URL_500WAN = "http://kaijiang.500wan.com/shtml/pls/%s.shtml";
	private static final String PL3_DETAIL_URL_DEFAULT_STARLOTT = "http://p3.starlott.com/";
	private static final String PL3_DETAIL_URL_STARLOTT = "http://p3.starlott.com";
	//排列5
	private static final String PL5_DETAIL_URL_DEFAULT_500WAN = "http://kaijiang.500wan.com/plw.shtml";
	private static final String PL5_DETAIL_URL_500WAN = "http://kaijiang.500wan.com/shtml/plw/%s.shtml";
	private static final String PL5_DETAIL_URL_DEFAULT_STARLOTT = "http://p5.starlott.com/";
	private static final String PL5_DETAIL_URL_STARLOTT = "http://p5.starlott.com";
	//胜负彩
	private static final String SFC_DETAIL_URL_DEFAULT_500WAN = "http://kaijiang.500wan.com/sfc.shtml";
	private static final String SFC_DETAIL_URL_500WAN = "http://kaijiang.500wan.com/shtml/sfc/%s.shtml";
	private static final String SFC_DETAIL_URL_DEFAULT_STARLOTT = "http://zc.starlott.com/sfc";
	private static final String SFC_DETAIL_URL_STARLOTT = "http://zc.starlott.com/sfc";
	//胜负任九
	private static final String SFR9_DETAIL_URL_DEFAULT_500WAN = "http://kaijiang.500wan.com/sfc.shtml";
	private static final String SFR9_DETAIL_URL_500WAN = "http://kaijiang.500wan.com/shtml/sfc/%s.shtml";
	private static final String SFR9_DETAIL_URL_DEFAULT_STARLOTT = "http://zc.starlott.com/sfc";
	private static final String SFR9_DETAIL_URL_STARLOTT = "http://zc.starlott.com/sfc";
	//4场进球
	private static final String JQC_DETAIL_URL_DEFAULT_500WAN = "http://kaijiang.500wan.com/jq4.shtml";
	private static final String JQC_DETAIL_URL_500WAN = "http://kaijiang.500wan.com/shtml/jq4/%s.shtml";
	private static final String JQC_DETAIL_URL_DEFAULT_STARLOTT = "http://zc.starlott.com/jqc";
	private static final String JQC_DETAIL_URL_STARLOTT = "http://zc.starlott.com/jqc";
	//6场半全场
	private static final String BQC_DETAIL_URL_DEFAULT_500WAN = "http://kaijiang.500wan.com/zc6.shtml";
	private static final String BQC_DETAIL_URL_500WAN = "http://kaijiang.500wan.com/shtml/zc6/%s.shtml";
	private static final String BQC_DETAIL_URL_DEFAULT_STARLOTT = "http://zc.starlott.com/bqc";
	private static final String BQC_DETAIL_URL_STARLOTT = "http://zc.starlott.com/bqc";
	//双色球
	private static final String SSQ_DETAIL_URL_DEFAULT_500WAN = "http://kaijiang.500wan.com/shtml/ssq/";
	private static final String SSQ_DETAIL_URL_500WAN = "http://kaijiang.500wan.com/shtml/ssq/%s.shtml";
	private static final String SSQ_DETAIL_URL_DEFAULT_STARLOTT = "http://ssq.starlott.com/";
	private static final String SSQ_DETAIL_URL_STARLOTT = "http://ssq.starlott.com";
	//东方6+1
	private static final String DF6J1_DETAIL_URL_DEFAULT_500WAN = "http://kaijiang.500wan.com/df6j1.shtml";
	private static final String DF6J1_DETAIL_URL_500WAN = "http://kaijiang.500wan.com/shtml/df6j1/%s.shtml";
	private static final String DF6J1_DETAIL_URL_DEFAULT_STARLOTT = "http://df61.starlott.com";
	private static final String DF6J1_DETAIL_URL_STARLOTT = "http://df61.starlott.com/";
	//15选5
	private static final String HD15X5_DETAIL_URL_DEFAULT_500WAN = "http://kaijiang.500wan.com/hdswxw.shtml";
	private static final String HD15X5_DETAIL_URL_500WAN = "http://kaijiang.500wan.com/shtml/hdswxw/%s.shtml";
	private static final String HD15X5_DETAIL_URL_DEFAULT_STARLOTT = "http://kj.starlott.com/kj/detail.do?code=FCJS15X5";
	private static final String HD15X5_DETAIL_URL_STARLOTT = "http://kj.starlott.com/kj/detail.do?code=FCJS15X5&issue=%s";
	//七乐彩
	private static final String QLC_DETAIL_URL_DEFAULT_500WAN = "http://kaijiang.500wan.com/qlc.shtml";
	private static final String QLC_DETAIL_URL_500WAN = "http://kaijiang.500wan.com/shtml/qlc/%s.shtml";
	private static final String QLC_DETAIL_URL_DEFAULT_STARLOTT = "http://qlc.starlott.com";
	private static final String QLC_DETAIL_URL_STARLOTT = "http://qlc.starlott.com";
	//福彩3D
	private static final String FC3D_DETAIL_URL_DEFAULT_500WAN = "http://kaijiang.500wan.com/sd.shtml";
	private static final String FC3D_DETAIL_URL_500WAN = "http://kaijiang.500wan.com/shtml/sd/%s.shtml";
	private static final String FC3D_DETAIL_URL_DEFAULT_STARLOTT = "http://3d.starlott.com";
	private static final String FC3D_DETAIL_URL_STARLOTT = "http://3d.starlott.com";
	//"31选7", 542
	private static final String A_31x7_DETAIL_URL_DEFAULT_500WAN = "http://kaijiang.500wan.com/syxq.shtml";
	private static final String A_31x7_DETAIL_URL_500WAN = "http://kaijiang.500wan.com/shtml/syxq/%s.shtml";
	private static final String A_31x7_DETAIL_URL_DEFAULT_STARLOTT = "http://31x7.starlott.com";
	private static final String A_31x7_DETAIL_URL_STARLOTT = "http://31x7.starlott.com";
	//22选5
	private static final String TC22X5_DETAIL_URL_DEFAULT_500WAN = "http://kaijiang.500wan.com/shtml/eexw/";
	private static final String TC22X5_DETAIL_URL_500WAN = "http://kaijiang.500wan.com/shtml/eexw/%s.shtml";
	
	//快乐扑克
	private static final String A_KLPK_DETAIL_URL_DEFAULT_500WAN = "http://www.500wan.com/static/info/kaijiang/xml/klpk/newlyopen.xml";
	private static final String A_KLPK_DETAIL_URL_500WAN = "http://www.500wan.com/static/info/kaijiang/xml/klpk/newlyopen.xml";
	//群英会
	private static final String A_QYH_DETAIL_URL_DEFAULT_500WAN = "http://www.500wan.com/static/info/kaijiang/xml/qyh/newlyopen.xml";
	private static final String A_QYH_DETAIL_URL_500WAN =  "http://www.500wan.com/static/info/kaijiang/xml/qyh/newlyopen.xml";
	//扑克彩·十分乐
	private static final String A_PKCSFL_DETAIL_URL_DEFAULT_500WAN = "http://www.500wan.com/static/info/kaijiang/xml/pkcsfl/newlyopen.xml";
	private static final String A_PKCSFL_DETAIL_URL_500WAN = "http://www.500wan.com/static/info/kaijiang/xml/pkcsfl/newlyopen.xml";
	//广西快乐十分
	private static final String A_GXKLSF_DETAIL_URL_DEFAULT_500WAN = "http://www.500wan.com/static/info/kaijiang/xml/gxklsf/newlyopen.xml";
	private static final String A_GXKLSF_DETAIL_URL_500WAN = "http://www.500wan.com/static/info/kaijiang/xml/gxklsf/newlyopen.xml";
	//广东快乐十分
	private static final String A_GDKLSF_DETAIL_URL_DEFAULT_500WAN = "http://www.500wan.com/static/info/kaijiang/xml/gdklsf/newlyopen.xml";
	private static final String A_GDKLSF_DETAIL_URL_500WAN = "http://www.500wan.com/static/info/kaijiang/xml/gdklsf/newlyopen.xml";
	//快乐8
	private static final String A_KL8_DETAIL_URL_DEFAULT_500WAN = "http://www.500wan.com/static/info/kaijiang/xml/kl8/newlyopen.xml";
	private static final String A_KL8_DETAIL_URL_500WAN = "http://www.500wan.com/static/info/kaijiang/xml/kl8/newlyopen.xml";
	//泳坛夺金
	private static final String A_YTDJ_DETAIL_URL_DEFAULT_500WAN = "http://www.500wan.com/static/info/kaijiang/xml/ytdj/newlyopen.xml";
	private static final String A_YTDJ_DETAIL_URL_500WAN = "http://www.500wan.com/static/info/kaijiang/xml/ytdj/newlyopen.xml";
	//快乐123   url：http://www.500wan.com/static/info/kaijiang/xml/kl123/newlyopen.xml
	
	private static final String A_GDKLSF_DETAIL_URL_DEFAULT_SHISHICAI = "http://video.shishicai.cn/haoma/gdkl10/list/84.aspx";
	private static final String A_GDKLSF_DETAIL_URL_SHISHICAI = "http://video.shishicai.cn/haoma/gdkl10/list/2011-02-25.aspx";
	
	static{
		//"31选7", 542
		urlMap.put(getDefaultUrlKey(LotteryType.A_31x7,FetcherType.T_500WAN), A_31x7_DETAIL_URL_DEFAULT_500WAN);
		urlMap.put(getHistoryUrlKey(LotteryType.A_31x7,FetcherType.T_500WAN), A_31x7_DETAIL_URL_500WAN);
		urlMap.put(getDefaultUrlKey(LotteryType.A_31x7,FetcherType.T_STARLOTT), A_31x7_DETAIL_URL_DEFAULT_STARLOTT);
		urlMap.put(getHistoryUrlKey(LotteryType.A_31x7,FetcherType.T_STARLOTT), A_31x7_DETAIL_URL_STARLOTT);
		//七星彩
		urlMap.put(getDefaultUrlKey(LotteryType.QXC,FetcherType.T_500WAN), QXC_DETAIL_URL_DEFAULT_500WAN);
		urlMap.put(getHistoryUrlKey(LotteryType.QXC,FetcherType.T_500WAN), QXC_DETAIL_URL_500WAN);
		urlMap.put(getDefaultUrlKey(LotteryType.QXC,FetcherType.T_STARLOTT), QXC_DETAIL_URL_DEFAULT_STARLOTT);
		urlMap.put(getHistoryUrlKey(LotteryType.QXC,FetcherType.T_STARLOTT), QXC_DETAIL_URL_STARLOTT);
		//七乐彩
		urlMap.put(getDefaultUrlKey(LotteryType.QLC,FetcherType.T_500WAN), QLC_DETAIL_URL_DEFAULT_500WAN);
		urlMap.put(getHistoryUrlKey(LotteryType.QLC,FetcherType.T_500WAN), QLC_DETAIL_URL_500WAN);
		urlMap.put(getDefaultUrlKey(LotteryType.QLC,FetcherType.T_STARLOTT), QLC_DETAIL_URL_DEFAULT_STARLOTT);
		urlMap.put(getHistoryUrlKey(LotteryType.QLC,FetcherType.T_STARLOTT), QLC_DETAIL_URL_STARLOTT);
		//福彩3D
		urlMap.put(getDefaultUrlKey(LotteryType.FC3D,FetcherType.T_500WAN), FC3D_DETAIL_URL_DEFAULT_500WAN);
		urlMap.put(getHistoryUrlKey(LotteryType.FC3D,FetcherType.T_500WAN), FC3D_DETAIL_URL_500WAN);
		urlMap.put(getDefaultUrlKey(LotteryType.FC3D,FetcherType.T_STARLOTT), FC3D_DETAIL_URL_DEFAULT_STARLOTT);
		urlMap.put(getHistoryUrlKey(LotteryType.FC3D,FetcherType.T_STARLOTT), FC3D_DETAIL_URL_STARLOTT);
		//超级大乐透
		urlMap.put(getDefaultUrlKey(LotteryType.DLT,FetcherType.T_500WAN), DLT_DETAIL_URL_DEFAULT_500WAN);
		urlMap.put(getHistoryUrlKey(LotteryType.DLT,FetcherType.T_500WAN), DLT_DETAIL_URL_500WAN);
		urlMap.put(getDefaultUrlKey(LotteryType.DLT,FetcherType.T_STARLOTT), DLT_DETAIL_URL_DEFAULT_STARLOTT);
		urlMap.put(getHistoryUrlKey(LotteryType.DLT,FetcherType.T_STARLOTT), DLT_DETAIL_URL_STARLOTT);
		//15选5
		urlMap.put(getDefaultUrlKey(LotteryType.HD15X5,FetcherType.T_500WAN), HD15X5_DETAIL_URL_DEFAULT_500WAN);
		urlMap.put(getHistoryUrlKey(LotteryType.HD15X5,FetcherType.T_500WAN), HD15X5_DETAIL_URL_500WAN);
		urlMap.put(getDefaultUrlKey(LotteryType.HD15X5,FetcherType.T_STARLOTT), HD15X5_DETAIL_URL_DEFAULT_STARLOTT);
		urlMap.put(getHistoryUrlKey(LotteryType.HD15X5,FetcherType.T_STARLOTT), HD15X5_DETAIL_URL_STARLOTT);
		//东方6+1
		urlMap.put(getDefaultUrlKey(LotteryType.DF6J1,FetcherType.T_500WAN), DF6J1_DETAIL_URL_DEFAULT_500WAN);
		urlMap.put(getHistoryUrlKey(LotteryType.DF6J1,FetcherType.T_500WAN), DF6J1_DETAIL_URL_500WAN);
		urlMap.put(getDefaultUrlKey(LotteryType.DF6J1,FetcherType.T_STARLOTT), DF6J1_DETAIL_URL_DEFAULT_STARLOTT);
		urlMap.put(getHistoryUrlKey(LotteryType.DF6J1,FetcherType.T_STARLOTT), DF6J1_DETAIL_URL_STARLOTT);
		//双色球
		urlMap.put(getDefaultUrlKey(LotteryType.SSQ,FetcherType.T_500WAN), SSQ_DETAIL_URL_DEFAULT_500WAN);
		urlMap.put(getHistoryUrlKey(LotteryType.SSQ,FetcherType.T_500WAN), SSQ_DETAIL_URL_500WAN);
		urlMap.put(getDefaultUrlKey(LotteryType.SSQ,FetcherType.T_STARLOTT), SSQ_DETAIL_URL_DEFAULT_STARLOTT);
		urlMap.put(getHistoryUrlKey(LotteryType.SSQ,FetcherType.T_STARLOTT), SSQ_DETAIL_URL_STARLOTT);
		//排列5
		urlMap.put(getDefaultUrlKey(LotteryType.PL5,FetcherType.T_500WAN), PL5_DETAIL_URL_DEFAULT_500WAN);
		urlMap.put(getHistoryUrlKey(LotteryType.PL5,FetcherType.T_500WAN), PL5_DETAIL_URL_500WAN);
		urlMap.put(getDefaultUrlKey(LotteryType.PL5,FetcherType.T_STARLOTT), PL5_DETAIL_URL_DEFAULT_STARLOTT);
		urlMap.put(getHistoryUrlKey(LotteryType.PL5,FetcherType.T_STARLOTT), PL5_DETAIL_URL_STARLOTT);
		//排列3
		urlMap.put(getDefaultUrlKey(LotteryType.PL3,FetcherType.T_500WAN), PL3_DETAIL_URL_DEFAULT_500WAN);
		urlMap.put(getHistoryUrlKey(LotteryType.PL3,FetcherType.T_500WAN), PL3_DETAIL_URL_500WAN);
		urlMap.put(getDefaultUrlKey(LotteryType.PL3,FetcherType.T_STARLOTT), PL3_DETAIL_URL_DEFAULT_STARLOTT);
		urlMap.put(getHistoryUrlKey(LotteryType.PL3,FetcherType.T_STARLOTT), PL3_DETAIL_URL_STARLOTT);
		//胜负彩
		urlMap.put(getDefaultUrlKey(LotteryType.SFC,FetcherType.T_500WAN), SFC_DETAIL_URL_DEFAULT_500WAN);
		urlMap.put(getHistoryUrlKey(LotteryType.SFC,FetcherType.T_500WAN), SFC_DETAIL_URL_500WAN);
		urlMap.put(getDefaultUrlKey(LotteryType.SFC,FetcherType.T_STARLOTT), SFC_DETAIL_URL_DEFAULT_STARLOTT);
		urlMap.put(getHistoryUrlKey(LotteryType.SFC,FetcherType.T_STARLOTT), SFC_DETAIL_URL_STARLOTT);
		//胜负任九
		urlMap.put(getDefaultUrlKey(LotteryType.SFR9,FetcherType.T_500WAN), SFR9_DETAIL_URL_DEFAULT_500WAN);
		urlMap.put(getHistoryUrlKey(LotteryType.SFR9,FetcherType.T_500WAN), SFR9_DETAIL_URL_500WAN);
		urlMap.put(getDefaultUrlKey(LotteryType.SFR9,FetcherType.T_STARLOTT), SFR9_DETAIL_URL_DEFAULT_STARLOTT);
		urlMap.put(getHistoryUrlKey(LotteryType.SFR9,FetcherType.T_STARLOTT), SFR9_DETAIL_URL_STARLOTT);
		//4场进球
		urlMap.put(getDefaultUrlKey(LotteryType.JQC,FetcherType.T_500WAN), JQC_DETAIL_URL_DEFAULT_500WAN);
		urlMap.put(getHistoryUrlKey(LotteryType.JQC,FetcherType.T_500WAN), JQC_DETAIL_URL_500WAN);
		urlMap.put(getDefaultUrlKey(LotteryType.JQC,FetcherType.T_STARLOTT), JQC_DETAIL_URL_DEFAULT_STARLOTT);
		urlMap.put(getHistoryUrlKey(LotteryType.JQC,FetcherType.T_STARLOTT), JQC_DETAIL_URL_STARLOTT);
		//6场半全场
		urlMap.put(getDefaultUrlKey(LotteryType.BQC,FetcherType.T_500WAN), BQC_DETAIL_URL_DEFAULT_500WAN);
		urlMap.put(getHistoryUrlKey(LotteryType.BQC,FetcherType.T_500WAN), BQC_DETAIL_URL_500WAN);
		urlMap.put(getDefaultUrlKey(LotteryType.BQC,FetcherType.T_STARLOTT), BQC_DETAIL_URL_DEFAULT_STARLOTT);
		urlMap.put(getHistoryUrlKey(LotteryType.BQC,FetcherType.T_STARLOTT), BQC_DETAIL_URL_STARLOTT);
		//22选5
		urlMap.put(getDefaultUrlKey(LotteryType.TC22X5,FetcherType.T_500WAN), TC22X5_DETAIL_URL_DEFAULT_500WAN);
		urlMap.put(getHistoryUrlKey(LotteryType.TC22X5,FetcherType.T_500WAN), TC22X5_DETAIL_URL_500WAN);
		
		//快乐扑克
		urlMap.put(getDefaultUrlKey(LotteryType.A_KLPK,FetcherType.T_500WAN), A_KLPK_DETAIL_URL_DEFAULT_500WAN);
		urlMap.put(getHistoryUrlKey(LotteryType.A_KLPK,FetcherType.T_500WAN), A_KLPK_DETAIL_URL_500WAN);
		//群英会
		urlMap.put(getDefaultUrlKey(LotteryType.SDQYH,FetcherType.T_500WAN), A_QYH_DETAIL_URL_DEFAULT_500WAN);
		urlMap.put(getHistoryUrlKey(LotteryType.SDQYH,FetcherType.T_500WAN), A_QYH_DETAIL_URL_500WAN);
		//扑克彩·十分乐
		urlMap.put(getDefaultUrlKey(LotteryType.A_PKCSFL,FetcherType.T_500WAN), A_PKCSFL_DETAIL_URL_DEFAULT_500WAN);
		urlMap.put(getHistoryUrlKey(LotteryType.A_PKCSFL,FetcherType.T_500WAN), A_PKCSFL_DETAIL_URL_500WAN);
		//广西快乐十分
		urlMap.put(getDefaultUrlKey(LotteryType.GXKL10,FetcherType.T_500WAN), A_GXKLSF_DETAIL_URL_DEFAULT_500WAN);
		urlMap.put(getHistoryUrlKey(LotteryType.GXKL10,FetcherType.T_500WAN), A_GXKLSF_DETAIL_URL_500WAN);
		//广东快乐十分
		urlMap.put(getDefaultUrlKey(LotteryType.GDKL10,FetcherType.T_500WAN), A_GDKLSF_DETAIL_URL_DEFAULT_500WAN);
		urlMap.put(getHistoryUrlKey(LotteryType.GDKL10,FetcherType.T_500WAN), A_GDKLSF_DETAIL_URL_500WAN);
		urlMap.put(getDefaultUrlKey(LotteryType.GDKL10,FetcherType.T_SHISHICAI), A_GDKLSF_DETAIL_URL_DEFAULT_SHISHICAI);
		urlMap.put(getHistoryUrlKey(LotteryType.GDKL10,FetcherType.T_SHISHICAI), A_GDKLSF_DETAIL_URL_SHISHICAI);
		//快乐8
		urlMap.put(getDefaultUrlKey(LotteryType.BJKL8,FetcherType.T_500WAN), A_KL8_DETAIL_URL_DEFAULT_500WAN);
		urlMap.put(getHistoryUrlKey(LotteryType.BJKL8,FetcherType.T_500WAN), A_KL8_DETAIL_URL_500WAN);
		//泳坛夺金
		urlMap.put(getDefaultUrlKey(LotteryType.A_YTDJ,FetcherType.T_500WAN), A_YTDJ_DETAIL_URL_DEFAULT_500WAN);
		urlMap.put(getHistoryUrlKey(LotteryType.A_YTDJ,FetcherType.T_500WAN), A_YTDJ_DETAIL_URL_500WAN);
		
		
		
		logger.info("初始化抓取url地址完成");
	}
	/**
	 * 创建urlKey
	 * @param lotteryType
	 * @param fetcherType
	 * @param type  0为 默认  1为历史详细页面url
	 * @return
	 */
	private static String createUrlKey(LotteryType lotteryType,FetcherType fetcherType,int type){
		if(type==0){
			return lotteryType.getName()+"_"+fetcherType.getName()+_DEFAULT_DETAIL_URL;
		}else{
			return lotteryType.getName()+"_"+fetcherType.getName()+_HISTORY_DETAIL_URL;
		}
	}
	/**
	 * 获得默认当前期号的url的key
	 * @param lotteryType
	 * @param fetcherType
	 * @return
	 */
	public static String getDefaultUrlKey(LotteryType lotteryType,FetcherType fetcherType){
		return createUrlKey(lotteryType,fetcherType,0);
	}
	/**
	 * 获得历史期号的url的key，
	 * 需根据情况处理
	 * @param lotteryType
	 * @param fetcherType
	 * @return
	 */
	public static String getHistoryUrlKey(LotteryType lotteryType,FetcherType fetcherType){
		return createUrlKey(lotteryType,fetcherType,1);
	}
	/**
	 * 根据key获得url地址信息
	 * @param key
	 * @return
	 */
	public static String getUrlBykey(String key){
		if(key==null){
			return null;
		}else{
			return urlMap.get(key);
		}
	}
	/**
	 * 根据彩种和抓取类型获取当前或历史url
	 * @param lotteryType
	 * @param fetcherType
	 * @param type 0当前 1历史
	 * @return
	 */
	public static String getUrl(LotteryType lotteryType,FetcherType fetcherType,int type){
		if(lotteryType==null&&fetcherType==null){
			return null;
		}
		String url = urlMap.get(createUrlKey(lotteryType,fetcherType,type));
		if(url==null){
			logger.error(createUrlKey(lotteryType,fetcherType,type)+"==对应的抓取地址不存在,返回null==");
		}
		return url;
	}
}
