package com.lehecai.core.api.lottery;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.lotteryconfig.ResultDetailTemplateItem;
import com.lehecai.core.lottery.lotteryconfig.ResultTemplateItem;
/**
 * 彩票配置,主要为服务器缓存提供数据结构定义
 * 说明:LotteryConfig与 LotteryType是一一对应的关系
 * 彩票相关配置的定义结构如下:
 * 1.开奖结果模板定义   ResultTemplateItem
 * 2.开奖详情模板定义   ResultDetailTemplateItem
 * @author leiming
 *
 */
public class LotteryConfig {
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	public static final String SETTING_OPERATE_TYPE_ADD = "add";//配置操作类型-添加,原配置不存在执行add操作
	public static final String SETTING_OPERATE_TYPE_UPDATE = "update";//配置操作类型-更新
	/**
	 * LotteryDraw和Phase对象中属性result(开奖结果)在抓取后保存到数据库的json对象字符串的key的名称
	 * {"result":[{"key":"red","data":["1","2","3","4","5"]},{"key":"blue","data":["6","7"]}]}
	 */
	public static final String JSON_KEYNAME_RESULT = "result";
	/**
	 * LotteryDraw和Phase对象中属性resultDetail(开奖详情)在抓取后保存到数据库的json对象字符串的key的名称
	 * {"resultDetail":[{"key":"prize1","bet":"3","prize":"100000"},{"key":"prize2","bet":"10","prize":"50000"}]}
	 */
	public static final String JSON_KEYNAME_RESULTDETAIL = "resultDetail";
	/**
	 * LotteryDraw和Phase对象的result对应数据库中jsonArray对象的key的名称
	 */
	public static final String JSON_KEYNAME_RESULT_KEY = "key";
	/**
	 * LotteryDraw和Phase对象的result对应数据库中jsonArray对象的data的名称
	 */
	public static final String JSON_KEYNAME_RESULT_DATA = "data";
	
	private LotteryType lotteryType;//对应配置的彩票类型
	private Map<String, ResultDetailTemplateItem> resultDetailItemMap;//Map key:ResultDetailTemplateItem对应的自身key值
	private List<ResultTemplateItem> resultTemplateItemList;//具体彩种开奖结果配置列表
	private List<ResultDetailTemplateItem> resultDetailTemplateItemList;//开奖详情配置项模板列表
	
	private Map<String, String> resultDetailKeyToNameMap;
	private Map<String, String> resultDetailNameToKeyMap;
	/**
	 * 开奖结果模板列表有顺序要求需使用List创建
	 * @param resultTemplateItemList
	 * @param resultDetailItemMap  开奖详情key对应的开奖详情模板
	 * @param lotteryType   配置对应的彩票类型  允许为null
	 */
	public LotteryConfig(List<ResultTemplateItem> resultTemplateItemList,List<ResultDetailTemplateItem> resultDetailTemplateItemList,Map<String, ResultDetailTemplateItem> resultDetailItemMap,LotteryType lotteryType){
		this.resultTemplateItemList = resultTemplateItemList;
		this.resultDetailTemplateItemList = resultDetailTemplateItemList;
		this.resultDetailItemMap = resultDetailItemMap;
		this.lotteryType = lotteryType;
		
		resultDetailKeyToNameMap = new HashMap<String, String>();
		resultDetailNameToKeyMap = new HashMap<String, String>();
		for (Iterator<String> iterator = resultDetailItemMap.keySet().iterator(); iterator.hasNext();) {
			String key = iterator.next();
			String name = resultDetailItemMap.get(key).getName();
			
			resultDetailKeyToNameMap.put(key, name);
			resultDetailNameToKeyMap.put(name, key);
		}
		
	}
	/**
	 * 获取配置项的开奖结果模板列表
	 * 用于分析开奖结果结构
	 * @return
	 */
	public List<ResultTemplateItem> getResultTemplateItemList(){
		return this.resultTemplateItemList;
	}
	/**
	 * 获取配置项的奖项映射map
	 * 用于获得奖项模板中的默认开奖金额
	 * @return Map<String, ResultDetailTemplateItem>  key = ResultDetailTemplateItem.key属性;value=ResultDetailTemplateItem对象
	 */
	public Map<String, ResultDetailTemplateItem> getResultDetailItemMap(){
		return this.resultDetailItemMap;
	}
	/**
	 * 根据奖项key值获得配置里对应的开奖详情模板项 不存在返回null
	 * @param prizeItemKey
	 * @return ResultDetailTemplateItem
	 */
	public ResultDetailTemplateItem getResultDetailTemplateItemByPrizeItemKey(String prizeItemKey){
		ResultDetailTemplateItem rdti = null;
		if(prizeItemKey!=null){
			try{
				rdti = resultDetailItemMap.get(prizeItemKey);
			}catch(Exception e){
				logger.error("从["+(lotteryType==null?"未指定彩种类型":lotteryType.getName())+"]彩票配置中获取奖项key:"+prizeItemKey+"对应的开奖详情模板不存在");
				rdti = null;
			}
		}
		return rdti;
	}
	/**
	 * 根据开奖详情模板中的中文名称获得对应的开奖详情模板 
	 * @param name
	 * @return
	 */
	public ResultDetailTemplateItem getResultDetailItemByPrizeItemName(String prizeItemName) {
		String key = this.resultDetailNameToKey(prizeItemName);
		if (key == null) {
			return null;
		}
		return getResultDetailTemplateItemByPrizeItemKey(key);
	}
	/**
	 * 根据开奖详情模板的中文名称获得对应的key值
	 * @param name
	 * @return
	 */
	public String resultDetailNameToKey(String name) {
		return resultDetailNameToKeyMap.get(name);
	}
	/**
	 * 根据开奖详情模板中的key获得对应的中文名称
	 * @param key
	 * @return
	 */
	public String resultDetailKeyToName(String key) {
		return resultDetailKeyToNameMap.get(key);
	}
	/**
	 * 获取开奖详情配置项模板列表
	 * @return
	 */
	public List<ResultDetailTemplateItem> getResultDetailTemplateItemList() {
		return resultDetailTemplateItemList;
	}
	public LotteryType getLotteryType() {
		return lotteryType;
	}
	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}
	
}
