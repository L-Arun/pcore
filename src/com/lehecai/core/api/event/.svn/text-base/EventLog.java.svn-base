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
import com.lehecai.core.lottery.PlatformType;
import com.lehecai.core.util.CoreDateUtils;

/**
 * @author qatang
 *
 */
public class EventLog extends AbstractApiResultBean {
	public static final String QUERY_ID = "id";
	public static final String QUERY_UID = "uid";
	public static final String QUERY_EVENT_ID = "event_id";
	public static final String QUERY_PRIZE_ID = "prize_id";
	public static final String QUERY_EVENT_STATUS = "status";
	public static final String QUERY_SOURCE = "source";
	public static final String QUERY_PLATFORM  = "platform";
	public static final String QUERY_TIMELINE  = "timeline";
	
	public static final String ORDER_ID = "id";
	public static final String ORDER_EVENT_TIMELINE = "timeline";
	public static final String ORDER_EVENT_SOURCE = "source";
	public static final String ORDER_EVENT_STATUS = "status";
	public static final String ORDER_EVENT_PRIZEID = "prize_id";

	private int id;			//活动记录编码
	private long uid;     	//用户编码
	private int eventId;	//活动编码
	private int prizeId;	//奖金编码
	private String prizeName; //奖项名称
	private String prizeLevel; //奖项等级
	private Date timeline;  //活动创建时间
	private int source;	    //来源
	private PlatformType platform;	//平台
	
	private EventLogStatus status;	//0代表未派奖，1代表已派奖
	

	public static EventLog convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		EventLog eventLog = new EventLog();
		
		eventLog.id = getInt(object, "id");
		eventLog.setUid(getLong(object, "uid"));
		eventLog.eventId = getInt(object, "event_id");
		eventLog.prizeId = getInt(object, "prize_id");
		eventLog.prizeName = getString(object, "prize_name");
		eventLog.prizeLevel = getString(object, "prize_level");
		eventLog.setTimeline(CoreDateUtils.parseDate(getString(object, "timeline"), CoreDateUtils.DATETIME));
		eventLog.source = getInt(object, "source");
		eventLog.setPlatform(PlatformType.getItem(getInt(object, "platform")));
		eventLog.setStatus(EventLogStatus.getItem(getInt(object, "status")));
	
		return eventLog;
	}
	
	@SuppressWarnings("unchecked")
	public static List<EventLog> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<EventLog> list = new ArrayList<EventLog>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getPrizeId() {
		return prizeId;
	}

	public void setPrizeId(int prizeId) {
		this.prizeId = prizeId;
	}

	public Date getTimeline() {
		return timeline;
	}

	public void setTimeline(Date timeline) {
		this.timeline = timeline;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public PlatformType getPlatform() {
		return platform;
	}

	public void setPlatform(PlatformType platform) {
		this.platform = platform;
	}

	public EventLogStatus getStatus() {
		return status;
	}

	public void setStatus(EventLogStatus status) {
		this.status = status;
	}

	public String getPrizeName() {
		return prizeName;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}

	public String getPrizeLevel() {
		return prizeLevel;
	}

	public void setPrizeLevel(String prizeLevel) {
		this.prizeLevel = prizeLevel;
	}
}
