/**
 * 
 */
package com.lehecai.core.api.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;

/**
 * @author Sunshow
 *
 */
public class MemberLevel extends AbstractApiResultBean {
	
	public static final String QUERY_UID = "uid";
	
	private long uid;
	private int numericScore;
	private int numericLevel;
	private int sportsScore;	
	private int sportsLevel;	
	private int highfreqScore;	
	private int highfreqLevel;	

	public static MemberLevel convertFromJSONObject(JSONObject object, long uid) {
		if (object == null || uid == 0) {
			return null;
		}
		
		MemberLevel memberLevel = new MemberLevel();
		
		memberLevel.uid = uid;
		
		try {
			memberLevel.numericScore = object.getJSONArray("numeric").getInt(0);
			memberLevel.numericLevel = object.getJSONArray("numeric").getInt(1);
			
			memberLevel.sportsScore = object.getJSONArray("sports").getInt(0);
			memberLevel.sportsLevel = object.getJSONArray("sports").getInt(1);
			
			memberLevel.highfreqScore = object.getJSONArray("highfreq").getInt(0);
			memberLevel.highfreqLevel = object.getJSONArray("highfreq").getInt(1);
		} catch (Exception e) {
			logger.error("convert json failed, json str = {}, uid = {}", object.toString(), uid);
		}
		
		return memberLevel;
	}
	
	@SuppressWarnings("unchecked")
	public static List<MemberLevel> convertFromJSONObjectMap(JSONObject objectMap) {
		if (objectMap == null) {
			return null;
		}
		List<MemberLevel> list = new ArrayList<MemberLevel>();
		for (Iterator iterator = objectMap.keys(); iterator.hasNext();) {
			String key = (String)iterator.next();
			long uid = 0;
			try {
				uid = Long.parseLong(key);
			} catch (NumberFormatException e) {
				logger.error("invalid uid value: {}", key);
				continue;
			}
			JSONObject object = (JSONObject) objectMap.get(key);
			list.add(convertFromJSONObject(object, uid));
		}
		return list;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public int getNumericScore() {
		return numericScore;
	}

	public void setNumericScore(int numericScore) {
		this.numericScore = numericScore;
	}

	public int getNumericLevel() {
		return numericLevel;
	}

	public void setNumericLevel(int numericLevel) {
		this.numericLevel = numericLevel;
	}

	public int getSportsScore() {
		return sportsScore;
	}

	public void setSportsScore(int sportsScore) {
		this.sportsScore = sportsScore;
	}

	public int getSportsLevel() {
		return sportsLevel;
	}

	public void setSportsLevel(int sportsLevel) {
		this.sportsLevel = sportsLevel;
	}

	public int getHighfreqScore() {
		return highfreqScore;
	}

	public void setHighfreqScore(int highfreqScore) {
		this.highfreqScore = highfreqScore;
	}

	public int getHighfreqLevel() {
		return highfreqLevel;
	}

	public void setHighfreqLevel(int highfreqLevel) {
		this.highfreqLevel = highfreqLevel;
	}


}