package com.lehecai.core.message.phase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.message.EventType;
import com.lehecai.core.util.CoreJSONUtils;

/**
 * @author gb
 * 彩期事件通知消息
 */
public class PhaseMessage{
	
	private static final String JSON_KEY_EVENT_TYPE = "event_type";
	
	private static final String JSON_KEY_LOTTERY_TYPE = "lottery_type";
	
	private static final String JSON_KEY_PHASE_NO = "phase";
	
	private EventType eventType;

	private LotteryType lotteryType;
	
	private String phaseNo;

	@Override
	public String toString() {
		JSONObject object = new JSONObject();
		object.put(JSON_KEY_EVENT_TYPE, eventType==null?"":eventType.getValue());
		object.put(JSON_KEY_LOTTERY_TYPE, lotteryType==null?"":lotteryType.getValue());
		object.put(JSON_KEY_PHASE_NO, phaseNo==null?"":phaseNo);
		return object.toString();
	}
	
	public static PhaseMessage convertFromJson(JSONObject jsonObject) {
		PhaseMessage message = new PhaseMessage();
		message.setLotteryType(LotteryType.getItem(CoreJSONUtils.getInt(jsonObject, JSON_KEY_LOTTERY_TYPE)));
		message.setEventType(EventType.getItem(CoreJSONUtils.getInt(jsonObject, JSON_KEY_EVENT_TYPE )));
		message.setPhaseNo(CoreJSONUtils.getString(jsonObject, JSON_KEY_PHASE_NO));
		return message;
	}
	
	public static List<PhaseMessage> getListFromJsonString(String jsonString) {
		List<PhaseMessage> result = new ArrayList<PhaseMessage>();
		
		JSONArray array = JSONArray.fromObject(jsonString);
		for(Iterator<?> iterator = array.iterator();iterator.hasNext();){
			result.add(convertFromJson((JSONObject)iterator.next()));
		}
		
		return result;
	}
	
	@Override
	public boolean equals(Object another){
		if (another == null) {
			return false;
		}
		
		if (!(another instanceof PhaseMessage)) {
			return false;
		}
		
		PhaseMessage message = (PhaseMessage) another;
		
		boolean result = message.getLotteryType() == this.getLotteryType() && message.getEventType() == this.getEventType();
		
		if(!result) {
			return false;
		}
		
		if (message.getPhaseNo() == null) {
			return this.getPhaseNo() == null;
		}else {
			return message.getPhaseNo().equals(this.getPhaseNo());
		}	
	}
	
	@Override
	public int hashCode(){
		return (this.getPhaseNo()+this.getLotteryType().getValue()+this.getEventType().getValue()).hashCode();
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public LotteryType getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public String getPhaseNo() {
		return phaseNo;
	}

	public void setPhaseNo(String phaseNo) {
		this.phaseNo = phaseNo;
	}
	
}
