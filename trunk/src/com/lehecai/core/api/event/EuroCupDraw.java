/**
 * 
 */
package com.lehecai.core.api.event;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;

/**
 * 欧洲杯开奖信息
 * @author chirowong
 *
 */
public class EuroCupDraw extends AbstractApiResultBean {	
	public static final String SET_MATCH_NUM = "team_ids";

	private Integer status;//开奖状态 1-待处理 2-正在处理 3-处理完成
	private Integer totalAbout;//大约需要开奖的订单数
	private Integer totalExact;//精确需要开奖的订单数
	private Integer successedNum;//开奖成功的订单数
	private Integer failedNum;//开奖失败的订单数
	private Double timeConsuming;//耗时
	
	public static EuroCupDraw convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		EuroCupDraw euroCupDraw = new EuroCupDraw();
		euroCupDraw.setStatus(getInt(object,"status"));
		euroCupDraw.setTotalAbout(getInt(object, "total_about"));
		euroCupDraw.setTotalExact(getInt(object, "total_exact"));
		euroCupDraw.setSuccessedNum(getInt(object, "succed_num"));
		euroCupDraw.setFailedNum(getInt(object, "failed_num"));
		euroCupDraw.setTimeConsuming(getDouble(object,"timeconsuming"));
		return euroCupDraw;
	}
	
	public static List<EuroCupDraw> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<EuroCupDraw> list = new ArrayList<EuroCupDraw>();
		for (Iterator<?> iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public Integer getTotalAbout() {
		return totalAbout;
	}

	public void setTotalAbout(Integer totalAbout) {
		this.totalAbout = totalAbout;
	}

	public Integer getTotalExact() {
		return totalExact;
	}

	public void setTotalExact(Integer totalExact) {
		this.totalExact = totalExact;
	}

	public Integer getSuccessedNum() {
		return successedNum;
	}

	public void setSuccessedNum(Integer successedNum) {
		this.successedNum = successedNum;
	}

	public Integer getFailedNum() {
		return failedNum;
	}

	public void setFailedNum(Integer failedNum) {
		this.failedNum = failedNum;
	}

	public Double getTimeConsuming() {
		return timeConsuming;
	}

	public void setTimeConsuming(Double timeConsuming) {
		this.timeConsuming = timeConsuming;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
