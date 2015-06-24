/**
 * 
 */
package com.lehecai.core.message.phase;

import net.sf.json.JSONObject;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.message.EventType;

/**
 * @author gb
 *
 */
public class PhaseDrawnMessage {

private static final String JSON_KEY_EVENT_TYPE = "event_type";
	
	private static final String JSON_KEY_LOTTERY_TYPE = "lottery_type";
	
	private static final String JSON_KEY_PHASE_NO = "phase";
	
	private static final String JSON_KEY_AFFECTED_ITEMS = "affected";
	
	private EventType eventType;

	private LotteryType lotteryType;
	
	private String phaseNo;
	
	private long affectedItems;

	@Override
	public String toString() {
		JSONObject object = new JSONObject();
		object.put(JSON_KEY_EVENT_TYPE, eventType==null?"":eventType.getValue());
		object.put(JSON_KEY_LOTTERY_TYPE, lotteryType==null?"":lotteryType.getValue());
		object.put(JSON_KEY_PHASE_NO, phaseNo==null?"":phaseNo);
		object.put(JSON_KEY_AFFECTED_ITEMS, affectedItems);
		return object.toString();
	}
	
	public static PhaseDrawnMessage convertFromJsonString(String jsonString) {
		try {
			return convertFromJson(JSONObject.fromObject(jsonString));
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 每个字段不能为空，否则转换失败
	 * @param jsonObject
	 * @return 转换失败返回null
	 */
	public static PhaseDrawnMessage convertFromJson(JSONObject jsonObject) {
		PhaseDrawnMessage message = new PhaseDrawnMessage();
		try {
			LotteryType lotteryType = LotteryType.getItem(jsonObject.getInt(JSON_KEY_LOTTERY_TYPE));
			if (lotteryType == null) {
				return null;
			}
			message.setLotteryType(lotteryType);
				
			EventType eventType =EventType.getItem(jsonObject.getInt(JSON_KEY_EVENT_TYPE));
			if (eventType == null) {
				return null;
			}
			message.setEventType(eventType);
				
			String phaseNo = jsonObject.getString(JSON_KEY_PHASE_NO);
			if (phaseNo == null || phaseNo.trim().equals("")) {
				return null;
			}
			message.setPhaseNo(phaseNo);
				
			message.setAffectedItems(jsonObject.getLong(JSON_KEY_AFFECTED_ITEMS));
		} catch (Exception e) {
			return null;
		}
		return message;
	}
	
	@Override
	public boolean equals(Object another){
		if (another == null) {
			return false;
		}
		
		if (!(another instanceof PhaseDrawnMessage)) {
			return false;
		}
		
		PhaseDrawnMessage message = (PhaseDrawnMessage) another;
		
		boolean result = message.getLotteryType() == this.getLotteryType()
						&&message.getEventType() == this.getEventType()
						&&message.getAffectedItems() == this.getAffectedItems();
		
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
		return (this.getPhaseNo()+this.getLotteryType().getValue()+this.getEventType().getValue()+this.getAffectedItems()).hashCode() ;
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

	public long getAffectedItems() {
		return affectedItems;
	}

	public void setAffectedItems(long affectedItems) {
		this.affectedItems = affectedItems;
	}
	
}
