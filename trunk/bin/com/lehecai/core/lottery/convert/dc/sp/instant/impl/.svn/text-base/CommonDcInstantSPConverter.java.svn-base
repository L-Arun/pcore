package com.lehecai.core.lottery.convert.dc.sp.instant.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.lehecai.core.lottery.DcSPType;
import com.lehecai.core.lottery.DcSPTypeShortTitleMap;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.cache.DcInstantSPCache;
import com.lehecai.core.lottery.cache.bean.DcInstantSPBean;
import com.lehecai.core.lottery.convert.dc.sp.instant.IDcInstantSPConverter;
import com.lehecai.core.lottery.fetcher.dc.DcInstantSPItem;
import com.lehecai.core.util.CoreStringUtils;
/**
 * 通用单场即时SP转换器
 * @author leiming
 *
 */
public class CommonDcInstantSPConverter implements IDcInstantSPConverter{
	
	@Override
	public String fetchInstantSPConvert(LotteryType lotteryType,
			List<DcInstantSPItem> dcInstantSPItems, String phaseNo) {
		if(dcInstantSPItems == null || phaseNo == null){
			return null;
		}
		//JSONArray spJsonArray = new JSONArray();
		//JSONArray spStatusJsonArray = new JSONArray();
		JSONObject fullSpJson = new JSONObject();
		JSONObject fullSpStatusJson = new JSONObject();
		String matchSpKey = null;
		String fetchSpValue = null;
		Map<DcSPType, String> spFetchMap = null;
		//获取缓存
		DcInstantSPBean dcInstantSPBean = getDcInstantSPBeanFromCache(lotteryType, phaseNo);
		Map<String,String> spCacheMap = dcInstantSPBean.getSpMap();
		// 处理抓取的单场比赛Sp值
		for(DcInstantSPItem dcInstantSPItem : dcInstantSPItems){
			spFetchMap = dcInstantSPItem.getSpmap();
			if(spFetchMap != null && spFetchMap.size() > 0 ){
				DcSPType dcSPType = null;
				JSONObject spJson = null;
				JSONObject spStatusJson = null;
				for(Iterator<DcSPType> it = spFetchMap.keySet().iterator();it.hasNext();){
					dcSPType = it.next();
					if(dcSPType == null){
						continue;
					}
					// 处理抓取sp值
					fetchSpValue = spFetchMap.get(dcSPType);
					matchSpKey = getSpJsonKey(dcInstantSPItem.getMatchIndex(),dcSPType);
					if(matchSpKey == null){
						continue;
					}else{
						spJson = new JSONObject();
						spJson.put(matchSpKey, fetchSpValue);
						//spJsonArray.add(spJson);//改用大对象方式
						fullSpJson.put(matchSpKey, fetchSpValue);
						// 处理抓取sp状态
						spStatusJson = getSpStatusJson(dcInstantSPItem.getMatchIndex(),dcSPType, fetchSpValue, spCacheMap);
						if(spStatusJson != null){
							//spStatusJsonArray.add(spStatusJson);
							fullSpStatusJson.put(matchSpKey, spStatusJson.get(matchSpKey));
						}
					}
				}// end for spFetchMap
			}
		}
		// start 更新缓存
		dcInstantSPBean.setSpMap(spCacheMap);
		updateDcInstantSPCache(dcInstantSPBean);
		// end 更新缓存
		JSONObject instantSPJson = new JSONObject();//最终返回的对象
		instantSPJson.put(IDcInstantSPConverter.JSON_KEY_INSTANT_LOTTERYTYPE, lotteryType.getValue());
		instantSPJson.put(IDcInstantSPConverter.JSON_KEY_INSTANT_PHASENO, phaseNo);
		instantSPJson.put(IDcInstantSPConverter.JSON_KEY_INSTANT_SP, fullSpJson);
		instantSPJson.put(IDcInstantSPConverter.JSON_KEY_INSTANT_SPSTATUS, fullSpStatusJson);
		instantSPJson.put(IDcInstantSPConverter.JSON_KEY_INSTANT_VERSION, System.currentTimeMillis());
		return instantSPJson.toString();
	}
	/**
	 * 获取某场比赛对应SP类型的状态变化情况
	 * @param matchIndex
	 * @param dcSPType
	 * @param spVal
	 * @param spCacheMap
	 * @return
	 */
	protected JSONObject getSpStatusJson(int matchIndex, DcSPType dcSPType,String spVal, Map<String,String> spCacheMap){
		JSONObject json = null;
		String matchSpKey = getSpJsonKey(matchIndex, dcSPType);
		String spCacheVal = null;
		String spStatus = null;
		Double spValD = null; 
		Double spCacheValD = null; 
		if(spCacheMap != null && spVal != null && matchSpKey != null && spVal.trim().length()>0 ){
			spValD = CoreStringUtils.convertDouble(spVal);
			if(spCacheMap.containsKey(matchSpKey)){
				spCacheVal = spCacheMap.get(matchSpKey);
				spCacheValD = CoreStringUtils.convertDouble(spCacheVal);
				if(spCacheValD != null && spValD != null){
					json = new JSONObject();
					if(spValD.doubleValue() > spCacheValD.doubleValue()){
						spStatus = IDcInstantSPConverter.JSON_KEY_INSTANT_SP_STATUS_UP;
					}else if(spValD.doubleValue() == spCacheValD.doubleValue()){
						spStatus = IDcInstantSPConverter.JSON_KEY_INSTANT_SP_STATUS_EQUAL;
					}else if(spValD.doubleValue() < spCacheValD.doubleValue()){
						spStatus = IDcInstantSPConverter.JSON_KEY_INSTANT_SP_STATUS_DOWN;
					}
					json.put(matchSpKey, spStatus);
				}
			}
			spCacheMap.put(matchSpKey, spVal);//刷新缓存SP中的数值
		}
		return json;
	}
	
	/**
	 * 从缓存获取DcInstantSPBean
	 * @param lotteryType
	 * @param phaseNo
	 * @return
	 */
	protected DcInstantSPBean getDcInstantSPBeanFromCache(LotteryType lotteryType, String phaseNo){
		DcInstantSPBean dcInstantSPBean = null;
		dcInstantSPBean = DcInstantSPCache.getDcInstantSPBean(lotteryType.getValue());
		if(dcInstantSPBean == null){
			dcInstantSPBean = new DcInstantSPBean(lotteryType, phaseNo);
		}else{
			//查询的彩期号与缓存中的彩期号不一致,重新初始化
			if(!dcInstantSPBean.getPhaseNo().equals(phaseNo)){
				dcInstantSPBean = new DcInstantSPBean(lotteryType, phaseNo);
			}
		}
		return dcInstantSPBean;
	}
	/**
	 * 更新单场即时SP缓存
	 * @param dcInstantSPBean
	 */
	protected void updateDcInstantSPCache(DcInstantSPBean dcInstantSPBean){
		if(dcInstantSPBean != null && dcInstantSPBean.getLotteryTypeVal() != null){
			DcInstantSPCache.setDcInstantSPMapBean(dcInstantSPBean.getLotteryTypeVal(), dcInstantSPBean);
		}
	}
	
	/**
	 * 根据比赛场次和单场Sp类型获取Json的SP值的Key
	 * @param matchIndex
	 * @param dcSPType
	 * @return String
	 */
	protected String getSpJsonKey(int matchIndex , DcSPType dcSPType){
		String key = null;
		String dcSpTypeShortTitle = DcSPTypeShortTitleMap.getShortTitleOfDcSPType(dcSPType);
		if(dcSpTypeShortTitle == null){
			return null;
		}
		key = "m" + matchIndex + dcSpTypeShortTitle;
		return key;
	}
}
