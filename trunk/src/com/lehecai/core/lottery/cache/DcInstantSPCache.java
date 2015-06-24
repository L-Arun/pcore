package com.lehecai.core.lottery.cache;

import java.io.Serializable;
import java.util.Hashtable;

import com.lehecai.core.lottery.cache.bean.DcInstantSPBean;
/**
 * 单场即时SP缓存
 * @author leiming
 *
 */
public class DcInstantSPCache implements Serializable{
	private static final long serialVersionUID = -7174948299996879967L;
	
	/**
	 * key: lotterytype value
	 * value: 对应得DcInstantSPBean
	 */
	private static Hashtable<Integer, DcInstantSPBean> dcInstantSPMap = new Hashtable<Integer, DcInstantSPBean>();
	
	
	/**
	 * 根据彩期类型获得对应的单场即时SP
	 * @param id  lotteryTypeValue
	 * @return
	 */
	public static DcInstantSPBean getDcInstantSPBean(int id){
		return dcInstantSPMap.get(id);
	}
	public static void setDcInstantSPMapBean(Integer id,DcInstantSPBean dcInstantSPBean){
		dcInstantSPMap.put(id, dcInstantSPBean);
	}

	public static void setDcInstantSPMap(Hashtable<Integer, DcInstantSPBean> dcInstantSPMap) {
		DcInstantSPCache.dcInstantSPMap = dcInstantSPMap;
	}

	public static Hashtable<Integer, DcInstantSPBean> getDcInstantSPMap() {
		return dcInstantSPMap;
	}

}
