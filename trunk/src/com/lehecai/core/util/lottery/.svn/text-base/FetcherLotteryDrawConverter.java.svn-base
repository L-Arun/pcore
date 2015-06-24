package com.lehecai.core.util.lottery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.EnabledStatus;
import com.lehecai.core.api.lottery.LotteryConfig;
import com.lehecai.core.api.lottery.Phase;
import com.lehecai.core.exception.UnmatchedLotteryDrawResultException;
import com.lehecai.core.exception.UnsupportedLotteryConfigException;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.PhaseType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDrawPrizeItem;
import com.lehecai.core.lottery.lotteryconfig.ResultDetailTemplateItem;
import com.lehecai.core.lottery.lotteryconfig.ResultTemplateItem;
import com.lehecai.core.util.CoreDateUtils;
import com.lehecai.core.util.CoreXmlUtils;

/**
 * 抓取彩票开奖数据转换器 工具类
 * @author leiming
 *
 */
public class FetcherLotteryDrawConverter {
	private static final Logger logger = LoggerFactory.getLogger(FetcherLotteryDrawConverter.class);
	/**
	 * 抓取的奖项映射
	 * key:fetcherType.getName() + "_" + lotteryType.getValue()
	 * value:Map<String, String>   key:抓取网站的中文奖项名  value:本站中文奖项名
	 */
	private static Map<String, Map<String, String>> fetcherPrizeItemMappings = new HashMap<String, Map<String,String>>();
	
	static {
		fetcherPrizeItemMappings = CoreXmlUtils.createFetcherPrizeItemMapping();
	}
	/**
	 * 转换奖项名称 外网 至 内网
	 * 将从网站抓取的彩票奖项名称转换为本站对应的奖项中文名
	 * 找不到自定义的默认不做转换
	 * @param name
	 * @param lotteryType
	 * @param fetcherType
	 * @return
	 */
	public static String convertPrizeItemName(String name, LotteryType lotteryType, FetcherType fetcherType) {
		Map<String, String> lotteryMappings = fetcherPrizeItemMappings.get(generateKey(fetcherType,lotteryType));
		if (lotteryMappings != null) {
			String convertedName = lotteryMappings.get(name);
			if (convertedName != null) {
				return convertedName;
			} else{
				logger.warn("未找到可转换奖项名称,原样返回.从["+fetcherType.getName()+"]抓取["+lotteryType.getName()+"]的奖项name("+name+")与系统配置的奖项名称没有匹配项,请检查系统奖项配置文件prizeItemConfig.xml;");
			}
		}else{
			logger.warn("未配置彩种["+lotteryType.getName()+"]可转换奖项名称,原样返回.从["+fetcherType.getName()+"]抓取["+lotteryType.getName()+"]的奖项name("+name+")与系统配置的奖项名称没有匹配项,系统中没有配置该彩种["+lotteryType.getName()+"]的奖项名称对应模板,请检查系统奖项配置文件prizeItemConfig.xml;");
		}
		return name;
	}
	/**
	 * 根据抓取类型和彩票类型生成fetcherPrizeItemMappings的key
	 * @param fetcherType
	 * @param lotteryType
	 * @return
	 */
	public static String generateKey(FetcherType fetcherType,LotteryType lotteryType) {
		return fetcherType.getName() + "_" + lotteryType.getValue();
	}
	/**
	 * 转换某抓取类型的奖项信息   具体外网奖项信息  -> 乐和彩奖项信息
	 * @param fetcherType  抓取类型
	 * @param lotteryDraw  需转换的开奖结果
	 * @return
	 */
	public static LotteryDraw convertPrizeItem(FetcherType fetcherType,LotteryDraw lotteryDraw){
		if(lotteryDraw==null||fetcherType==null){
			return null;
		}
		LotteryDraw convertLotteryDraw = new LotteryDraw();
		convertLotteryDraw.setLotteryType(lotteryDraw.getLotteryType());
		convertLotteryDraw.setPhase(lotteryDraw.getPhase());
		convertLotteryDraw.setResult(lotteryDraw.getResult());
		convertLotteryDraw.setVolumeOfSales(lotteryDraw.getVolumeOfSales());
		convertLotteryDraw.setJackpot(lotteryDraw.getJackpot());
		convertLotteryDraw.setTimeDraw(lotteryDraw.getTimeDraw());
		List<LotteryDrawPrizeItem> resultDetail = lotteryDraw.getResultDetail();
		
		List<LotteryDrawPrizeItem> convertResultDetail = null;
		if(resultDetail!=null){
			convertResultDetail = new ArrayList<LotteryDrawPrizeItem>();
			LotteryDrawPrizeItem tmpLtteryDrawPrizeItem = null;
			String convertPrizeItemName = null;//转换后名称
			for(LotteryDrawPrizeItem lotteryDrawPrizeItem:resultDetail){
				tmpLtteryDrawPrizeItem = new LotteryDrawPrizeItem();
				//转换名称
				convertPrizeItemName = convertPrizeItemName(lotteryDrawPrizeItem.getName(),lotteryDraw.getLotteryType(),fetcherType);
				tmpLtteryDrawPrizeItem.setName(convertPrizeItemName);
				tmpLtteryDrawPrizeItem.setWinningCount(lotteryDrawPrizeItem.getWinningCount());
				tmpLtteryDrawPrizeItem.setPrizeAmount(lotteryDrawPrizeItem.getPrizeAmount());
				convertResultDetail.add(tmpLtteryDrawPrizeItem);
			}
		}
		convertLotteryDraw.setResultDetail(convertResultDetail);
		return convertLotteryDraw;
	}
	/**
	 * 根据模板配置转换抓取的开奖结果为json字符串对象
	 * @param lotteryDraw
	 * @param lotteryConfing
	 * @return LotteryDraw  result format:{"result":[{"key":"red","data":["1","2","3","4","5"]},{"key":"blue","data":["6","7"]}]}
	 */
	public static LotteryDraw convertFetchResult2JsonString(LotteryDraw lotteryDraw,LotteryConfig lotteryConfing){
		if(lotteryDraw==null){
			logger.error("根据模板配置转换抓取的开奖结果为json字符串对象的参数LotteryDraw为null,返回null");
			return null;
		}
		if(lotteryConfing==null){
			logger.error("根据模板配置转换抓取的开奖结果为json字符串对象的参数lotteryConfing为null,返回null");
			return null;
		}
		LotteryDraw convertLotteryDraw = new LotteryDraw();
		convertLotteryDraw.setLotteryType(lotteryDraw.getLotteryType());
		convertLotteryDraw.setPhase(lotteryDraw.getPhase());
		convertLotteryDraw.setVolumeOfSales(lotteryDraw.getVolumeOfSales());
		convertLotteryDraw.setJackpot(lotteryDraw.getJackpot());
		convertLotteryDraw.setTimeDraw(lotteryDraw.getTimeDraw());
		convertLotteryDraw.setResultDetail(lotteryDraw.getResultDetail());
		String logHeader = "彩票["+(lotteryConfing.getLotteryType()==null?"未指定彩票类型":lotteryConfing.getLotteryType().getName())
				+"<"+(lotteryDraw.getPhase()==null?"null":lotteryDraw.getPhase())+">期]转换开奖结果,";
		
		String result = null;
		try {
			result = convertFetchResult2DBJsonString(lotteryDraw.getResult(),lotteryConfing);
		} catch (UnmatchedLotteryDrawResultException e) {
			logger.error("转换开奖结果出错", e);
			logger.error("result={}, lotteryType={}", lotteryDraw.getResult(), lotteryDraw.getLotteryType().getName());
		}
		if (result == null) {
			logger.error(logHeader+"转换开奖结果为数据库配置开奖结果格式错误,返回null");
			return null;
		}
		convertLotteryDraw.setResult(result);
		return convertLotteryDraw;
	}
	/**
	 * 根据模板配置转换抓取的开奖结果为DB的json字符串对象
	 * @param fetchResultString  页面抓取的原始result,如1,2,3,4,5,6,7
	 * @param lotteryConfing 彩票配置
	 * @param phase  抓取的彩期号
	 * @return String  result format:{"result":[{"key":"red","data":["1","2","3","4","5"]},{"key":"blue","data":["6","7"]}]}
	 */
	public static String convertFetchResult2DBJsonString(String fetchResultString,LotteryConfig lotteryConfing) throws UnmatchedLotteryDrawResultException {
		if(lotteryConfing==null){
			logger.error("根据模板配置转换抓取的开奖结果为json字符串对象的参数lotteryConfing为null,返回null");
			return null;
		}
		if(fetchResultString==null){
			logger.error("根据模板配置转换抓取的开奖结果为json字符串对象的参数fetchResultString为null,返回null");
			return null;
		}
		
		//String result = lotteryDraw.getResult();//原始格式,如1,2,3,4,5,6,7
		String[] resultArray = null;//抓取结果分离后的数组
		String convertResult = null;//json格式的字符串
		Integer validateNumber = null;//校验数字,保证抓取结果与配置结果一致
		List<ResultTemplateItem> resultTemplateItems = lotteryConfing.getResultTemplateItemList();
		JSONObject resultJson = null;//最终结果封装对象
		JSONArray resultJsonArray = null;//结果json数组
		String logHeader = "彩票["+(lotteryConfing.getLotteryType()==null?"未指定彩票类型":lotteryConfing.getLotteryType().getName())
				+"转换开奖结果,";
		if(fetchResultString!=null&&resultTemplateItems!=null){
			resultJson = new JSONObject();
			resultJsonArray = new JSONArray();
			JSONObject dataJson = null;
			JSONArray dataJsonArray = null;//数据json数组,内部各个元素存放单个开奖结果,如["1","2","3","4","5"]
			Integer dataCount = null;//模板配置项对应
			resultArray = fetchResultString.split(",");
			int arrayStartIndex = 0;//resultArray数组起始序列号
			validateNumber = resultArray.length;
			for(ResultTemplateItem resultTemplateItem:resultTemplateItems){
				// start 过滤不可用
				if(resultTemplateItem.getUsable() != null && resultTemplateItem.getUsable().getValue() == EnabledStatus.DISABLED.getValue()){
					continue;
				}
				// end 过滤不可用 
				
				if(resultTemplateItem.getKey()!=null&&resultTemplateItem.getResultCount()!=null&&resultTemplateItem.getResultCount()>0){
					dataJsonArray = new JSONArray();
					dataJson = new JSONObject();
					dataCount = resultTemplateItem.getResultCount();
					for(int i=0;i<dataCount;i++){
						if(arrayStartIndex<validateNumber){//防止数组溢出
							dataJsonArray.add(resultArray[arrayStartIndex]);
						}
						arrayStartIndex++;
					}
					dataJson.put(LotteryConfig.JSON_KEYNAME_RESULT_KEY, resultTemplateItem.getKey().trim());
					dataJson.put(LotteryConfig.JSON_KEYNAME_RESULT_DATA, dataJsonArray);
					resultJsonArray.add(dataJson);
				}
			}
			//验证开奖结果合法性,已解析的结果与实际抓取结果数量匹配
			if(arrayStartIndex==validateNumber){
				resultJson.put(LotteryConfig.JSON_KEYNAME_RESULT, resultJsonArray);
				convertResult = resultJson.toString();
				logger.info(logHeader+"开奖结果与开奖结果模板匹配");
			}
			//不匹配原样返回
			else{
				convertResult = fetchResultString;
				logger.error(logHeader+"抓取结果("+fetchResultString+")与开奖结果模板配置不匹配,根据模板解析开奖结果个数为:"
						+arrayStartIndex+"个,实际抓取开奖结果的个数为:"+validateNumber+"个,两者数量不匹配,请检查配置模板("
						+ResultTemplateItem.toJSONArrayString(resultTemplateItems)+")及开奖结果,开奖结果原样返回");
				throw new UnmatchedLotteryDrawResultException("抓取的开奖结果格式与配置个数不匹配");
			}
		}
		//都不存在返回null
		else{
			//convertResult = lotteryDraw.getResult();
			convertResult = null;
			logger.error(logHeader+"抓取结果为"+fetchResultString+"与结果配置模板"+resultTemplateItems+"可能有null,开奖结果返回null");
			return null;
		}
		logger.info(logHeader+"通过开奖结果配置模板处理后的结果为:"+convertResult);
		return convertResult;
	}
	/**
	 * 转换开奖结果json对象字符串为页面显示字符串,用于后台页面显示
	 * {"result":[{"key":"red","data":["1","2","3","4","5"]},{"key":"blue","data":["6","7"]}]}
	 * ==>
	 * [1,2,3,4,5][6,7]
	 * @param resultJsonString
	 * @return
	 */
	public static String convertResultJsonString2ShowString(String resultJsonString){
		if(resultJsonString==null||resultJsonString.isEmpty()||resultJsonString.equals("null")){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		JSONObject json = JSONObject.fromObject(resultJsonString);
		JSONArray ja = json.getJSONArray(LotteryConfig.JSON_KEYNAME_RESULT);
		JSONArray dataArray = null;
		String data = null;
		for(Iterator<?> iterator = ja.iterator();iterator.hasNext();){
			JSONObject jajs = (JSONObject)iterator.next();
			dataArray = jajs.getJSONArray(LotteryConfig.JSON_KEYNAME_RESULT_DATA);
			Integer dataSize = dataArray.size();
			int i = 0;
			sb.append("[");
			for(Iterator<?> dataIterator = dataArray.iterator();dataIterator.hasNext();){
				data = dataIterator.next().toString();
				sb.append(data);
				if(i<(dataSize-1)){
					sb.append(",");
				}
				i++;
			}
			sb.append("]");
		}
		return sb.toString();
	}
	/**
	 * 转换开奖结果json对象字符串为页面显示字符串,转换成原始字符串格式
	 * {"result":[{"key":"red","data":["1","2","3","4","5"]},{"key":"blue","data":["6","7"]}]}
	 * ==>
	 * 1,2,3,4,5,6,7
	 * @param resultJsonString
	 * @return
	 */
	public static String convertResultJsonString2String(String resultJsonString){
		if(resultJsonString==null||resultJsonString.isEmpty()||resultJsonString.equals("null")){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		JSONObject json = JSONObject.fromObject(resultJsonString);
		JSONArray ja = json.getJSONArray(LotteryConfig.JSON_KEYNAME_RESULT);
		Integer resultSize = ja.size();
		int k = 0;
		JSONArray dataArray = null;
		String data = null;
		for(Iterator<?> iterator = ja.iterator();iterator.hasNext();){
			JSONObject jajs = (JSONObject)iterator.next();
			dataArray = jajs.getJSONArray(LotteryConfig.JSON_KEYNAME_RESULT_DATA);
			Integer dataSize = dataArray.size();
			int i = 0;
			for(Iterator<?> dataIterator = dataArray.iterator();dataIterator.hasNext();){
				data = dataIterator.next().toString();
				sb.append(data);
				if(i<(dataSize-1)){
					sb.append(",");
				}
				i++;
			}
			//多组结果间加","
			if(k<(resultSize-1)){
				sb.append(",");
			}
			k++;
		}
		return sb.toString();
	}
	
	/**
	 * 根据彩票配置转换抓取的奖项name为对应key
	 * @param lotteryDraw
	 * @param lotteryConfing
	 * @return
	 */
	public static LotteryDraw convertFetchResultDetailPrizeItemName2Key(LotteryDraw lotteryDraw,LotteryConfig lotteryConfing) throws UnsupportedLotteryConfigException{
		if(lotteryDraw==null){
			logger.warn("根据彩票配置转换抓取的奖项name为对应key的参数LotteryDraw为null,返回null");
			return null;
		}
		if(lotteryConfing==null){
			logger.error("根据彩票配置转换抓取的奖项name为对应key的参数lotteryConfing为null,原样返回lotteryDraw");
			return lotteryDraw;
		}
		LotteryDraw convertLotteryDraw = new LotteryDraw();
		convertLotteryDraw.setLotteryType(lotteryDraw.getLotteryType());
		convertLotteryDraw.setPhase(lotteryDraw.getPhase());
		convertLotteryDraw.setVolumeOfSales(lotteryDraw.getVolumeOfSales());
		convertLotteryDraw.setJackpot(lotteryDraw.getJackpot());
		convertLotteryDraw.setTimeDraw(lotteryDraw.getTimeDraw());
		convertLotteryDraw.setResult(lotteryDraw.getResult());
		
		List<LotteryDrawPrizeItem> resultDetail = lotteryDraw.getResultDetail();
		List<LotteryDrawPrizeItem> convertResultDetail = null;
		LotteryDrawPrizeItem tmpLotteryDrawPrizeItem = null;
		String key = null;
		String logHeader = "彩票["+(lotteryDraw.getLotteryType()==null?"未指定彩票类型":lotteryDraw.getLotteryType().getName())
				+"<"+(lotteryDraw.getPhase()==null?"null":lotteryDraw.getPhase())+">期]转换奖项名称为key,";
		if(resultDetail!=null){
			convertResultDetail = new ArrayList<LotteryDrawPrizeItem>();
			for(LotteryDrawPrizeItem lotteryDrawPrizeItem:resultDetail){
				tmpLotteryDrawPrizeItem = new LotteryDrawPrizeItem();
				key = lotteryConfing.resultDetailNameToKey(lotteryDrawPrizeItem.getName());
				if(key!=null){
					tmpLotteryDrawPrizeItem.setName(key);
					tmpLotteryDrawPrizeItem.setPrizeAmount(lotteryDrawPrizeItem.getPrizeAmount());
					tmpLotteryDrawPrizeItem.setWinningCount(lotteryDrawPrizeItem.getWinningCount());
					convertResultDetail.add(tmpLotteryDrawPrizeItem);
				}else{
					logger.error(logHeader+"获取key值失败,name("+lotteryDrawPrizeItem.getName()+")对应的key不存在,原样返回");
					convertResultDetail = null;//note 也可执行其他方式
					throw new UnsupportedLotteryConfigException("未找到彩票["+lotteryDraw.getLotteryType().getName()+"]关于开奖详情的配置");
				}
			}
		}
		logger.info(logHeader+"转换前开奖详情内容:"+LotteryDrawPrizeItem.listDataInfo(resultDetail));
		logger.info(logHeader+"转换后开奖详情内容:"+LotteryDrawPrizeItem.listDataInfo(convertResultDetail));
		convertLotteryDraw.setResultDetail(convertResultDetail);
		return convertLotteryDraw;
	}
	
	/**
	 * 根据彩票配置转换抓取的奖项name为对应key
	 * @param lotteryDraw
	 * @param lotteryConfig
	 * @return
	 */
	public static String convertFetchResultDetailKey2PrizeItemName(String resultDetailWithKey, LotteryConfig lotteryConfig) throws UnsupportedLotteryConfigException{
		if(resultDetailWithKey == null){
			logger.warn("根据彩票配置转换抓取的奖项name为对应key的参数LotteryDraw为null,返回null");
			return null;
		}
		if(lotteryConfig == null){
			logger.error("根据彩票配置转换抓取的奖项name为对应key的参数lotteryConfing为null,原样返回lotteryDraw");
			return null;
		}
		List<LotteryDrawPrizeItem> list = LotteryDrawPrizeItem.convertFromJsonObjectString(resultDetailWithKey);
		if(list !=null && list.size() > 0){
		
			for(LotteryDrawPrizeItem lotteryDrawPrizeItem : list){
				lotteryDrawPrizeItem.setName(lotteryConfig.resultDetailKeyToName(lotteryDrawPrizeItem.getName()));
			}
		}
		return LotteryDrawPrizeItem.toJSONArrayString(list);
	}
	/**
	 * 抓换开奖详情的模板项为默认的DB开奖详情内容
	 * format {"resultDetail":[{"key":"prize1","bet":"0","prize":"100000"},{"key":"prize2","bet":"0","prize":"50000"}]}
	 * @param lotteryConfig
	 * @return
	 */
	public static String convertResultDetailFromDefaultLotteryConfig(LotteryConfig lotteryConfig){
		if(lotteryConfig==null){
			return null;
		}
		String resultDetailJson = null;
		List<ResultDetailTemplateItem> resultDetailTemplateItemList= lotteryConfig.getResultDetailTemplateItemList();
		resultDetailJson = ResultDetailTemplateItem.toJSONString4DefaultPrizeItem(resultDetailTemplateItemList);
		return resultDetailJson;
	}
	/**
	 * 转换抓取开奖结果数据的开奖结果,奖项名称
	 * 主要用于抓取后对彩票开奖结果的处理
	 * @param lotteryDraw
	 * @param lotteryConfing
	 * @return
	 * @throws UnsupportedLotteryConfigException
	 */
	public static LotteryDraw convertFetcherLotteryDraw(LotteryDraw lotteryDraw,LotteryConfig lotteryConfing) throws UnsupportedLotteryConfigException{
		LotteryDraw convertLotteryDraw = null;
		//修改开奖结果
		convertLotteryDraw = convertFetchResult2JsonString(lotteryDraw,lotteryConfing);
		if(convertLotteryDraw == null){
			logger.error("根据模板配置转换抓取的开奖结果为json字符串对象发生错误");
			return null;
		}
		//转换开奖详情的奖项名称为对应key
		convertLotteryDraw = convertFetchResultDetailPrizeItemName2Key(convertLotteryDraw,lotteryConfing);
		return convertLotteryDraw;
	}
	/**
	 * 转换抓取的开奖结果为彩期对象LotteryDraw==>Phase<br/>
	 * 注:该方法不做任何lotteryConfig的对应配置转换,原样装换
	 * @param loggeryDraw
	 * @return
	 */
	public static Phase convertFromLotteryDraw(LotteryDraw lotteryDraw){
		if(lotteryDraw == null){
			return null;
		}
		if(lotteryDraw.getLotteryType() == null){
			return null;
		}
		if(lotteryDraw.getPhase() == null){
			return null;
		}
		Phase phase = new Phase();
		
		phase.setPhase(lotteryDraw.getPhase());
		phase.setPhaseType(PhaseType.getItem(lotteryDraw.getLotteryType()));
		phase.setResult(lotteryDraw.getResult());
		phase.setResultDetail(LotteryDrawPrizeItem.convertListToDBJsonString(lotteryDraw.getResultDetail()));
		phase.setSaleAmount(lotteryDraw.getVolumeOfSales());
		phase.setPoolAmount(lotteryDraw.getJackpot());
		if(lotteryDraw.getTimeDraw() != null && lotteryDraw.getTimeDraw().trim().length() > 0 ){
			if(lotteryDraw.getTimeDraw().trim().length() > 10){
				phase.setDrawTime(CoreDateUtils.parseLongDate(lotteryDraw.getTimeDraw()));
			}else{
				phase.setDrawTime(CoreDateUtils.parseDate(lotteryDraw.getTimeDraw()));
			}
			
		}
		
		return phase;
	}
	
	/**
	 * 将开奖结果详情转换为DB json字符串
	 * @param lotteryConfig
	 * @param resultDetailStr
	 * @return
	 */
	public static String convertResultDetail2DBJsonString(LotteryConfig lotteryConfig,String resultDetailStr){
		if( lotteryConfig == null ){
			logger.info("lotteryConfig 为 null,返回开奖详情为null");
			return "";
		}
		List<ResultDetailTemplateItem> resultDetailTemplateItemList = lotteryConfig.getResultDetailTemplateItemList();
		resultDetailStr = resultDetailStr.replace(",", "");		//去掉money中的','
		String[] resultDetailArr = resultDetailStr.split("#");
		JSONArray jsonArr = new JSONArray();		//存放结果数据的jsonArray
		JSONObject jsonObj = null;					//存放结果详情中的一个prize级别
		String[] itemDetail = null;
		for(ResultDetailTemplateItem item : resultDetailTemplateItemList){
			jsonObj = new JSONObject();
			itemDetail = getResultDetail4PrizeItem(resultDetailArr,item.getKey());
			if(itemDetail == null ){
				continue;
			}
			jsonObj.put(LotteryDrawPrizeItem.JSON_KEYNAME_KEY, item.getKey());
			jsonObj.put(LotteryDrawPrizeItem.JSON_KEYNAME_BET, itemDetail[1]);
			jsonObj.put(LotteryDrawPrizeItem.JSON_KEYNAME_PRIZE, itemDetail[2]);
			jsonArr.add(jsonObj);
		}
		
		JSONObject resultJson = new JSONObject();
		resultJson.put(LotteryConfig.JSON_KEYNAME_RESULTDETAIL, jsonArr);
		logger.info(resultJson.toString());
		return resultJson.toString();
	}
	
	private static String[] getResultDetail4PrizeItem(String[] resultDetailArr, String prize){
		String[] itemDetailArr = null;
		for(String resultDetail : resultDetailArr){
			if( resultDetail.indexOf(prize) > -1 ){
				itemDetailArr = resultDetail.split("\\^");
				break;
			}
		}
		return itemDetailArr;
	}
	
	/**
	 * 根据彩票配置转换开奖详情列表的奖项中文名称为对应的key 如一等奖 转为 prize1
	 * @param resultDetail
	 * @param lotteryConfing
	 * @return
	 * @throws UnsupportedLotteryConfigException
	 */
	public static List<LotteryDrawPrizeItem> convertFetchResultDetailPrizeItemName2Key(List<LotteryDrawPrizeItem> resultDetail,LotteryConfig lotteryConfig) throws UnsupportedLotteryConfigException{
		if(resultDetail==null){
			logger.warn("根据彩票配置转换抓取的奖项name为对应key的参数resultDetail为null,返回null");
			return null;
		}
		if(lotteryConfig==null){
			logger.error("根据彩票配置转换抓取的奖项name为对应key的参数lotteryConfing为null,原样返回resultDetail");
			return resultDetail;
		}
		
		List<LotteryDrawPrizeItem> convertResultDetail = null;
		LotteryDrawPrizeItem tmpLotteryDrawPrizeItem = null;
		String key = null;
		LotteryType lotteryType = lotteryConfig.getLotteryType();
		String logHeader = "彩票["+(lotteryType==null?"未指定彩票类型":lotteryType.getName())+"]转换奖项名称为key,";
		if(resultDetail!=null){
			convertResultDetail = new ArrayList<LotteryDrawPrizeItem>();
			for(LotteryDrawPrizeItem lotteryDrawPrizeItem:resultDetail){
				tmpLotteryDrawPrizeItem = new LotteryDrawPrizeItem();
				key = lotteryConfig.resultDetailNameToKey(lotteryDrawPrizeItem.getName());
				if(key!=null){
					tmpLotteryDrawPrizeItem.setName(key);
					String prizeAmount = lotteryDrawPrizeItem.getPrizeAmount();
					if (prizeAmount == null && lotteryConfig.getResultDetailItemMap() != null && lotteryConfig.getResultDetailItemMap().containsKey(key)) {
						Double defaultPrizeAmount = lotteryConfig.getResultDetailItemMap().get(key).getDefaultPrizeAmount();
						if (lotteryConfig.getResultDetailItemMap().get(key).getUsable() != null && lotteryConfig.getResultDetailItemMap().get(key).getUsable().getValue() == EnabledStatus.DISABLED.getValue()) {
							// 跳过禁用的奖级
							continue;
						}
						prizeAmount = defaultPrizeAmount == null ? prizeAmount : String.valueOf(defaultPrizeAmount);
					}
					tmpLotteryDrawPrizeItem.setPrizeAmount(prizeAmount);
					tmpLotteryDrawPrizeItem.setWinningCount(lotteryDrawPrizeItem.getWinningCount());
					convertResultDetail.add(tmpLotteryDrawPrizeItem);
				}else{
					/* 不做throw处理,只打error级日志,以抓取到的奖项为准
					logger.error(logHeader+"获取key值失败,name("+lotteryDrawPrizeItem.getName()+")对应的key不存在,原样返回");
					convertResultDetail = null;//note 也可执行其他方式
					throw new UnsupportedLotteryConfigException("未找到彩票["+lotteryType.getName()+"]关于开奖详情的配置");
					*/
					
					logger.error(logHeader+"获取key值失败,name("+lotteryDrawPrizeItem.getName()+")对应的key不存在,该奖项将不做转换并在抓取的开奖结果中删除该奖项");
					
					
				}
			}
		}
		logger.info(logHeader+"转换前开奖详情内容:"+LotteryDrawPrizeItem.listDataInfo(resultDetail));
		logger.info(logHeader+"转换后开奖详情内容:"+LotteryDrawPrizeItem.listDataInfo(convertResultDetail));
		
		return convertResultDetail;
	}
}
