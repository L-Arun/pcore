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
 * 欧洲杯球队信息
 * @author chirowong
 *
 */
public class EuroCupTeam extends AbstractApiResultBean {
	public static final String QUERY_TEAM_ID = "team_id";
	
	public static final String SET_TOP1_STATUS = "top1_status";
	public static final String SET_TOP1_SP = "top1_sp";
	public static final String SET_TOP1_SP_TREND = "top1_sp_trend";
	public static final String SET_TOP4_STATUS = "top4_status";
	public static final String SET_TOP4_SP = "top4_sp";
	public static final String SET_TOP4_SP_TREND = "top4_sp_trend";
	public static final String SET_TOP8_STATUS = "top8_status";
	public static final String SET_TOP8_SP = "top8_sp";
	public static final String SET_TOP8_SP_TREND = "top8_sp_trend";
	public static final String SET_ADMIN_ID = "admin_id";
	
	private Integer teamId;//球队ID
	private String teamName;//球队名称
	private String group;//所属组别
	private Integer top1Status;//猜冠军状态：【0：关闭投注，1：开启投注】
	private Double top1Sp;//猜冠军sp
	private Integer top1SpTrend;//sp变化趋势：【小于0，下降；等于0，不变；大于0，上升】
	private Integer top4Status;
	private Double top4Sp;
	private Integer top4SpTrend;
	private Integer top8Status;
	private Double top8Sp;
	private Integer top8SpTrend;
	private Long userId;
	
	public static EuroCupTeam convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		EuroCupTeam euroCupTeam = new EuroCupTeam();
		euroCupTeam.setTeamId(getInt(object, "team_id"));
		euroCupTeam.setTeamName(getString(object, "team_name"));
		euroCupTeam.setGroup(getString(object, "group"));
		euroCupTeam.setTop1Status(getInt(object, "top1_status"));
		euroCupTeam.setTop1Sp(getDouble(object,"top1_sp"));
		euroCupTeam.setTop1SpTrend(getInt(object,"top1_sp_trend"));
		euroCupTeam.setTop4Status(getInt(object, "top4_status"));
		euroCupTeam.setTop4Sp(getDouble(object,"top4_sp"));
		euroCupTeam.setTop4SpTrend(getInt(object,"top4_sp_trend"));
		euroCupTeam.setTop8Status(getInt(object, "top8_status"));
		euroCupTeam.setTop8Sp(getDouble(object,"top8_sp"));
		euroCupTeam.setTop8SpTrend(getInt(object,"top8_sp_trend"));
		return euroCupTeam;
	}
	
	public static List<EuroCupTeam> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<EuroCupTeam> list = new ArrayList<EuroCupTeam>();
		for (Iterator<?> iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}
	
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Integer getTop1Status() {
		return top1Status;
	}

	public void setTop1Status(Integer top1Status) {
		this.top1Status = top1Status;
	}

	public Double getTop1Sp() {
		return top1Sp;
	}

	public void setTop1Sp(Double top1Sp) {
		this.top1Sp = top1Sp;
	}

	public Integer getTop1SpTrend() {
		return top1SpTrend;
	}

	public void setTop1SpTrend(Integer top1SpTrend) {
		this.top1SpTrend = top1SpTrend;
	}

	public Integer getTop4Status() {
		return top4Status;
	}

	public void setTop4Status(Integer top4Status) {
		this.top4Status = top4Status;
	}

	public Double getTop4Sp() {
		return top4Sp;
	}

	public void setTop4Sp(Double top4Sp) {
		this.top4Sp = top4Sp;
	}

	public Integer getTop4SpTrend() {
		return top4SpTrend;
	}

	public void setTop4SpTrend(Integer top4SpTrend) {
		this.top4SpTrend = top4SpTrend;
	}

	public Integer getTop8Status() {
		return top8Status;
	}

	public void setTop8Status(Integer top8Status) {
		this.top8Status = top8Status;
	}

	public Double getTop8Sp() {
		return top8Sp;
	}

	public void setTop8Sp(Double top8Sp) {
		this.top8Sp = top8Sp;
	}

	public Integer getTop8SpTrend() {
		return top8SpTrend;
	}

	public void setTop8SpTrend(Integer top8SpTrend) {
		this.top8SpTrend = top8SpTrend;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
