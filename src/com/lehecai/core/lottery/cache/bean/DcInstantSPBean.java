package com.lehecai.core.lottery.cache.bean;

import java.util.HashMap;
import java.util.Map;

import com.lehecai.core.lottery.LotteryType;
/**
 * 单场即时SP封装Bean
 * @author leiming
 *
 */
public class DcInstantSPBean {
	private Integer lotteryTypeVal;
	
	private String phaseNo;
	/**
	 * phaseNo期即时SP值映射
	 * 格式:key:m12f
	 * value:3.02
	 */
	private Map<String,String> spMap;
	
	public DcInstantSPBean(){}
	
	public DcInstantSPBean(LotteryType lotteryType, String phaseNo){
		this.setLotteryTypeVal(lotteryType.getValue());
		this.setPhaseNo(phaseNo);
		Map<String,String> spCacheMap = new HashMap<String,String>();
		this.setSpMap(spCacheMap);
	}
	
	public Integer getLotteryTypeVal() {
		return lotteryTypeVal;
	}
	public void setLotteryTypeVal(Integer lotteryTypeVal) {
		this.lotteryTypeVal = lotteryTypeVal;
	}
	public String getPhaseNo() {
		return phaseNo;
	}
	public void setPhaseNo(String phaseNo) {
		this.phaseNo = phaseNo;
	}
	public Map<String, String> getSpMap() {
		return spMap;
	}
	public void setSpMap(Map<String, String> spMap) {
		this.spMap = spMap;
	}
	
	
	
}
