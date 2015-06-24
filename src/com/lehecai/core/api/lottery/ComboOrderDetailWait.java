package com.lehecai.core.api.lottery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.FinishComboStatus;
import com.lehecai.core.lottery.LotteryType;

/**
 * 套餐待执行记录
 * 仅作执行套餐用，最简化结构
 * @author sunshow
 *
 */
public class ComboOrderDetailWait extends AbstractApiResultBean {
	
	public static final String QUERY_COMBO_ORDER_ID = "comboorder_id";
	public static final String QUERY_LOTTERY_TYPE = "lottery_type";
	public static final String QUERY_PHASE = "phase";
	
	private long comboOrderId; //订单
	private LotteryType lotteryType; //彩种
	private FinishComboStatus finishStatus; // 套餐完成状态
	
	public static ComboOrderDetailWait convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		ComboOrderDetailWait record = new ComboOrderDetailWait();

		record.comboOrderId = getLong(object, "comboorder_id");
		int lt = getInt(object, "lottery_type");
		record.lotteryType = LotteryType.getItem(lt);
		record.setFinishStatus(FinishComboStatus.getItem(getInt(object, "status")));
		return record;
	}
	
	@SuppressWarnings("unchecked")
	public static List<ComboOrderDetailWait> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<ComboOrderDetailWait> list = new ArrayList<ComboOrderDetailWait>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public long getComboOrderId() {
		return comboOrderId;
	}

	public void setComboOrderId(long comboOrderId) {
		this.comboOrderId = comboOrderId;
	}

	public LotteryType getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public FinishComboStatus getFinishStatus() {
		return finishStatus;
	}

	public void setFinishStatus(FinishComboStatus finishStatus) {
		this.finishStatus = finishStatus;
	}


}
