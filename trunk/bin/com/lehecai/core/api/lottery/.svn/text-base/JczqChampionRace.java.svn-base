package com.lehecai.core.api.lottery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.JczqRaceStatus;
import com.lehecai.core.util.CoreDateUtils;
/**
 * 
 * @author qatang
 *
 */
public class JczqChampionRace extends AbstractApiResultBean implements Serializable{
	private static final long serialVersionUID = 259588566502612614L;
	
	public static final String QUERY_ID = "id";
	public static final String QUERY_MATCH_NUM = "team_num";
	public static final String QUERY_PHASE = "phase";
	public static final String QUERY_STATUS = "status";
	
	public static final String SET_MATCH_NUM = "team_num";
	public static final String SET_PHASE = "phase";
	public static final String SET_TEAM = "team_name";
	public static final String SET_STATUS = "status";
	public static final String SET_PRIORITY = "priority";
	public static final String SET_FX_ID = "fx_id";
	public static final String SET_EXT = "ext";
	
	public static final String ORDER_MATCH_NUM = "team_num";
	public static final String ORDER_CREATE_AT = "create_at";
	
	private Long id;
	private String matchNum;              //比赛编码,年月日+01+官方赛事编码（01为预留位）2011031401001
	private String phase;             	//彩期号
	private Date createAt;        		//创建时间
	private String team;        	//冠军队
	private JczqRaceStatus status;		//比赛状态
	private int fxId;					//分析id
	private int priority;				//优先级
	private String ext;               	//扩展信息
	
	public static JczqChampionRace convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		JczqChampionRace jczqChampionRace = new JczqChampionRace();
		
		jczqChampionRace.setId(getLong(object, "id"));
		jczqChampionRace.setMatchNum(getString(object, "team_num"));
		jczqChampionRace.setPhase(getString(object, "phase"));
		jczqChampionRace.setCreateAt(CoreDateUtils.parseDate(getString(object, "create_at"), CoreDateUtils.DATETIME));
		jczqChampionRace.setTeam(getString(object, "team_name"));
		jczqChampionRace.setStatus(JczqRaceStatus.getItem(getInt(object, "status")));
		jczqChampionRace.setFxId(getInt(object, "fx_id"));
		jczqChampionRace.setPriority(getInt(object, "priority"));
		jczqChampionRace.setExt(getString(object, "ext"));
		
		return jczqChampionRace;
	}
	@SuppressWarnings("unchecked")
	public static List<JczqChampionRace> convertFromJSONArray(JSONArray array) {
		logger.info(array.toString());
		if (array == null) {
			return null;
		}
		List<JczqChampionRace> list = new ArrayList<JczqChampionRace>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}
	
	public static JSONObject toJSON(JczqChampionRace dcRace) {
		JSONObject object = JSONObject.fromObject(dcRace);
		return object;
	}
	
	public static JSONArray toJSONArray(List<JczqChampionRace> dcRaces) {
		JSONArray ja = new JSONArray();
		JSONObject jsonObject = null;
		if(dcRaces != null && dcRaces.size() > 0){
			for(JczqChampionRace dcRace:dcRaces){
				jsonObject = JczqChampionRace.toJSON(dcRace);
				ja.add(jsonObject);
			}
		}
		return ja;
	}
	public String getMatchNum() {
		return matchNum;
	}
	public void setMatchNum(String matchNum) {
		this.matchNum = matchNum;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	
	public Date getCreateAt() {
		return createAt;
	}
	
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	
	public JczqRaceStatus getStatus() {
		return status;
	}
	public void setStatus(JczqRaceStatus status) {
		this.status = status;
	}
	
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getFxId() {
		return fxId;
	}
	public void setFxId(int fxId) {
		this.fxId = fxId;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	/**
	 * 获取对阵基本信息
	 * @return
	 */
	public String getJczqRaceInfo(){
		StringBuffer sb = new StringBuffer();
		sb.append("[竞彩足球猜冠军赛程]");
		sb.append("彩期:").append(this.getPhase());
		sb.append(",赛事编码:").append(this.getMatchNum());
		sb.append(",赛程状态:").append(this.getStatus().getName());
		sb.append(",冠军队:").append(this.getTeam());
		return sb.toString();
	}
}
