/**
 * 
 */
package com.lehecai.core.api.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.LotteryType;

/**
 * 分成配置
 * @author yanweijie
 *
 */
public class SourceRebateConfig extends AbstractApiResultBean {
	
	public static final String QUERY_PARTNER_ID = "partner_id";
	public static final String QUERY_LOTTERY_TYPE = "lottery_type";
	public static final String QUERY_SOURCE = "source";
	
	public static final String SET_PARTNER_ID = "partner_id";
	public static final String SET_LOTTERY_TYPE = "lottery_type";
	public static final String SET_SOURCE = "source";
	public static final String SET_REBATE = "rebate";
	
	private Integer partnerId;		//编码
	private LotteryType lotteryType;//彩种
	private Integer source;			//来源
	private double rebate;			//分成
	
	public static SourceRebateConfig convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		SourceRebateConfig partner = new SourceRebateConfig();
		
		partner.partnerId = getInt(object, "partner_id");
		partner.lotteryType = LotteryType.getItem(getInt(object, "lottery_type"));
		partner.source = getInt(object, "source");
		partner.rebate = getDouble(object, "rebate");
		
		return partner;
	}
	
	@SuppressWarnings("unchecked")
	public static List<SourceRebateConfig> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<SourceRebateConfig> list = new ArrayList<SourceRebateConfig>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public Integer getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	public LotteryType getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public double getRebate() {
		return rebate;
	}

	public void setRebate(double rebate) {
		this.rebate = rebate;
	}	
}
