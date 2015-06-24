/**
 * 
 */
package com.lehecai.core.api.event;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.event.EventLogStatus;
import com.lehecai.core.util.CoreDateUtils;

/**
 * @author qatang
 *
 */
public class EventPrize extends AbstractApiResultBean {
	public static final String QUERY_PRIZE_ID = "prize_id";
	public static final String QUERY_EVENT_ID = "event_id";
	
	public static final String SET_EVENT_ID = "event_id";
	public static final String SET_PRIZE_NAME = "prize_name";
	public static final String SET_PRIZE_QUANTITY = "prize_quantity";
	public static final String SET_PRIZE_MONEY = "prize_money";
	public static final String SET_PRIZE_LEVEL="prize_level";
	public static final String SET_PRIZE_TYPE="prize_type";
	public static final String SET_IMG_SRC="img_src";
	
	public static final String ORDER_PRIZE_ID = "prize_id";
	public static final String ORDER_EVENT_TIMELINE = "timeline";

	private int prizeId;	//奖项编码
	private int eventId;	//活动编码
	private String prizeName;//奖项名称
	private int prizeQuantity;//奖项总数
	private int prizeAwarded; //已派奖数
	private double prizeMoney;   //奖金
	private Date timeline;  //活动创建时间
	private int prizeLevel;	    //奖级
	private EventPrizeType prizeType;//奖项类型
	private String imgSrc;	//奖项图片
	
	private EventLogStatus status;	//0代表未派奖，1代表已派奖
	

	public static EventPrize convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		EventPrize eventPrize = new EventPrize();
		
		eventPrize.prizeId = getInt(object, "prize_id");
		eventPrize.eventId = getInt(object, "event_id");
		eventPrize.setPrizeName(getString(object, "prize_name"));
		eventPrize.prizeQuantity = getInt(object, "prize_quantity");
		eventPrize.prizeAwarded = getInt(object, "prize_awarded");
		eventPrize.prizeMoney = getDouble(object, "prize_money");
		eventPrize.setTimeline(CoreDateUtils.parseDate(getString(object, "timeline"), CoreDateUtils.DATETIME));
		eventPrize.prizeLevel = getInt(object, "prize_level");
		eventPrize.prizeType = EventPrizeType.getItem(getInt(object, "prize_type"));
		eventPrize.setImgSrc(getString(object, "img_src"));
	
		return eventPrize;
	}
	
	@SuppressWarnings("unchecked")
	public static List<EventPrize> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<EventPrize> list = new ArrayList<EventPrize>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public int getPrizeId() {
		return prizeId;
	}

	public void setPrizeId(int prizeId) {
		this.prizeId = prizeId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getPrizeName() {
		return prizeName;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}

	public int getPrizeQuantity() {
		return prizeQuantity;
	}

	public void setPrizeQuantity(int prizeQuantity) {
		this.prizeQuantity = prizeQuantity;
	}

	public int getPrizeAwarded() {
		return prizeAwarded;
	}

	public void setPrizeAwarded(int prizeAwarded) {
		this.prizeAwarded = prizeAwarded;
	}

	public double getPrizeMoney() {
		return prizeMoney;
	}

	public void setPrizeMoney(double prizeMoney) {
		this.prizeMoney = prizeMoney;
	}

	public Date getTimeline() {
		return timeline;
	}

	public void setTimeline(Date timeline) {
		this.timeline = timeline;
	}

	public int getPrizeLevel() {
		return prizeLevel;
	}

	public void setPrizeLevel(int prizeLevel) {
		this.prizeLevel = prizeLevel;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	
	public EventPrizeType getPrizeType() {
		return prizeType;
	}

	public void setPrizeType(EventPrizeType prizeType) {
		this.prizeType = prizeType;
	}

	public EventLogStatus getStatus() {
		return status;
	}

	public void setStatus(EventLogStatus status) {
		this.status = status;
	}
}
