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
import com.lehecai.core.event.EventInfoStatus;
import com.lehecai.core.util.CoreDateUtils;

/**
 * @author qatang
 *
 */
public class EventInfo extends AbstractApiResultBean {
	public static final String QUERY_EVENT_ID = "event_id";
	public static final String QUERY_EVENT_NAME = "event_name";
	public static final String QUERY_EVENT_STATUS = "status";
	public static final String QUERY_EVENT_START_TIME = "event_time_start";
	public static final String QUERY_EVENT_END_TIME = "event_time_end";
	public static final String QUERY_EVENT_TIMELINE = "timeline";
	
	public static final String SET_EVENT_NAME = "event_name";
	public static final String SET_EVENT_DESCRIPTION = "event_description";
	public static final String SET_EVENT_START_TIME = "event_time_start";
	public static final String SET_EVENT_END_TIME = "event_time_end";
	public static final String SET_TIME_LINE = "timeline";
	public static final String SET_EVENT_STATUS = "status";
	public static final String SET_PRESET_HITS="preset_hits";
	
	public static final String ORDER_EVENT_ID = "event_id";
	public static final String ORDER_EVENT_START_TIME = "event_time_start";
	public static final String ORDER_EVENT_END_TIME = "event_time_end";
	public static final String ORDER_EVENT_TIMELINE = "timeline";

	private int eventId;			//活动编码
	private String eventName;       //活动名称
	private String eventDescription;	//活动描述
	
	private Date eventStartTime;    //活动起始时间
	private Date eventEndTime;      //活动结束时间
	private Date timeline;          //活动创建时间
	
	private EventInfoStatus status;     //0,活动关闭  1,活动开启
	
	private Integer presetHits;	//预估的参与人数

	public static EventInfo convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		EventInfo eventInfo = new EventInfo();
		
		eventInfo.eventId = getInt(object, "event_id");
		eventInfo.setEventName(getString(object, "event_name"));
		eventInfo.setEventDescription(getString(object, "event_description"));
		eventInfo.setEventStartTime(CoreDateUtils.parseDate(getString(object, "event_time_start"), CoreDateUtils.DATETIME));
		eventInfo.setEventEndTime(CoreDateUtils.parseDate(getString(object, "event_time_end"), CoreDateUtils.DATETIME));
		eventInfo.setTimeline(CoreDateUtils.parseDate(getString(object, "timeline"), CoreDateUtils.DATETIME));
		eventInfo.setStatus(EventInfoStatus.getItem(getInt(object, "status")));
		eventInfo.setPresetHits(getInt(object, "preset_hits"));
	
		return eventInfo;
	}
	
	@SuppressWarnings("unchecked")
	public static List<EventInfo> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<EventInfo> list = new ArrayList<EventInfo>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public Date getEventStartTime() {
		return eventStartTime;
	}
	public void setEventStartTime(Date eventStartTime) {
		this.eventStartTime = eventStartTime;
	}
	public Date getEventEndTime() {
		return eventEndTime;
	}
	public void setEventEndTime(Date eventEndTime) {
		this.eventEndTime = eventEndTime;
	}
	public Date getTimeline() {
		return timeline;
	}
	public void setTimeline(Date timeline) {
		this.timeline = timeline;
	}
	public EventInfoStatus getStatus() {
		return status;
	}
	public void setStatus(EventInfoStatus status) {
		this.status = status;
	}
	public Integer getPresetHits() {
		return presetHits;
	}
	public void setPresetHits(Integer presetHits) {
		this.presetHits = presetHits;
	}
}
