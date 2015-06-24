package com.lehecai.core.lottery.fetcher;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.LotteryType;

/**
 * 各个抓取类型和彩票名称与网站彩票类型的对应关系
 * @author leiming
 *
 */
public class FetcherLotteryTypeMap {
	private static final Logger logger = LoggerFactory.getLogger(FetcherLotteryTypeMap.class.getName());
	
	/**
	 * 500Wan彩票名称与对应编号映射
	 * key：抓取类型名+抓取网站前1列或2列的名称组合
	 * value:乐和彩彩票类型值
	 */
	private static HashMap<String,Integer> lotteryNameValueMap = new HashMap<String,Integer>();
	
	static{
		//500wan
		//全国开奖
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"超级大乐透",1);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"七星彩", 2);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"排列3", 3);
	    lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"排列5", 4);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"22选5", 5);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"29选7", 6);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"胜负彩(任9)", 7);
		//特殊处理 胜负彩(任9) 加入类型实际名称加以区分
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+LotteryType.SFC.getName()+"胜负彩(任9)", 7);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+LotteryType.SFR9.getName()+"胜负彩(任9)", 8);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"胜负彩(任9)", 7);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"4场进球彩", 9);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"6场半全场", 10);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"双色球", 50);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"七乐彩", 51);	
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"福彩3D", 52);	
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"20选5", 515);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"东方6+1", 54);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"好彩1", 61);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"31选7", 542);
		
	    // 地方采种
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"华东六省福彩15选5",55);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"华东六省东方6+1", 54);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"北京福彩两步彩",501);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"北京体彩36选7",502);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"上海福彩天天彩选4",524);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"天津天津15选5",503);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"天津体彩6+1",504);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"安徽福彩15选5",506);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"重庆福彩20选5",525);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"江苏体彩7位数",533);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"江苏体彩5+1",532);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"浙江体彩6+1",538);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"浙江体彩20选5",540);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"浙江体彩31选7",537);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"福建福建36选7",509);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"福建体彩22选5",508);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"福建福彩15选5",507);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"福建体彩31选7",510);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"广东福彩26选5",526);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"广东福彩好彩1",61);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"广东体彩36选7",57);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"广东福彩36选7",536);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"黑龙江福彩P62",529);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"黑龙江体彩6+1",530);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"黑龙江福彩22选5",528);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"黑龙江福彩36选7",527);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"四川福彩22选5",519);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"辽宁福彩35选7",516);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"河北福彩排列7",513);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"河北福彩排列5",515);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"河北福彩20选5",514);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"河南福彩22选5",512);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"湖北福彩22选5",511);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"山东福彩23选5",518);
	                	
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"山西福彩21选5",535);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"浙江福彩15选5",539);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"内蒙古福彩22选5",534);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"新疆福彩25选7",523);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"新疆福彩35选7",520);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"新疆福彩18选7",522);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"新疆福彩偶数10选7",521);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"湖南福彩22选5",531);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"广西福彩快乐双彩",550);
		lotteryNameValueMap.put(FetcherType.T_500WAN.getName()+"安徽福彩25选5",505);
		
		//星彩网
		//全国开奖
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"超级大乐透",1);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"七星彩", 2);
	    lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"排列五", 4);
	    lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"排列三", 3);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"22选5", 5);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"29选7", 6);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"足彩胜负彩", 7);
		//特殊处理 胜负彩(任9) 加入类型实际名称加以区分
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+LotteryType.SFC.getName()+"足彩胜负彩", 7);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+LotteryType.SFR9.getName()+"足彩胜负彩", 8);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"四场进球彩", 9);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"半全场胜负彩", 10);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"双色球", 50);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"七乐彩", 51);	
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"福彩3D", 52);	
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"20选5", 515);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"东方6+1", 54);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"泛珠36选7", 57);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"好彩1", 61);
		
		//地方开奖
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"上海15选5", 55);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"北京北京两步彩", 501);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"北京北京体彩36选7", 502);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"天津天津风采15选5", 503);
	    lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"天津天津体彩6+1", 504);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"安徽安徽25选5", 505);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"安徽安徽15选5", 506);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"福建福建风采15选5", 507);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"福建福建22选5", 508);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"福建福建36选7", 509);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"福建福建31选7", 510);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"湖北楚天风采22选5", 511);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"河南中原风采22选5", 512);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"河北燕赵风采排列7", 513);	
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"河北燕赵风采20选5", 514);	
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"河北燕赵风采排列5", 515);
		
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"辽宁辽宁风采35选7", 516);
		
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"山东齐鲁风采23选5", 518);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"贵州云贵川天天乐", 519);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"新疆新疆风采35选7", 520);
		
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"新疆新疆风采偶数10选7", 521);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"新疆新疆风采18选7", 522);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"新疆新疆风采25选7", 523);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"上海上海天天彩选4", 524);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"重庆重庆风采20选5", 525);
		
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"广东南粤风采26选5", 526);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"黑龙江黑龙江36选7", 527);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"黑龙江黑龙江22选5", 528);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"黑龙江黑龙江P62", 529);
		
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"黑龙江黑龙江6+1", 530);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"湖南湖南风采22选5", 531);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"江苏江苏5+1", 532);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"江苏江苏7位数", 533);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"内蒙古内蒙古风采22选5", 534);
		
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"山西三晋风采21选5", 535);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"广东南粤风采36选7", 536);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"浙江浙江31选7", 537);
		
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"浙江浙江6+1", 538);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"浙江浙江风采15选5", 539);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"浙江浙江20选5", 540);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"浙江浙江29选7", 541);
		lotteryNameValueMap.put(FetcherType.T_STARLOTT.getName()+"浙江浙江31选7", 542);
		
		logger.info(FetcherType.T_500WAN.getName()+"和"+FetcherType.T_STARLOTT.getName()+"的彩票名称与网站彩票类型的对应关系初始化完毕");
	}
	/**
	 * 根据地方列表页面前两列串组合获得彩票类型编号
	 * @param key
	 * @return 不存在返回-1
	 */
	public static Integer getLotteryValueByKey(String key){
		if(null!=lotteryNameValueMap.get(key))
			return (Integer) lotteryNameValueMap.get(key);
		else
			return -1;
	}
}
