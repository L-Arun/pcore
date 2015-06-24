/**
 * 
 */
package com.lehecai.core.api.lottery;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.YesNoStatus;
import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.ChaseStatus;
import com.lehecai.core.lottery.ChaseType;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.PlanCreateType;
import com.lehecai.core.lottery.PlayType;
import com.lehecai.core.lottery.SelectType;
import com.lehecai.core.lottery.StopChaseType;
import com.lehecai.core.util.CoreDateUtils;

/**
 * @author Sunshow
 * 追号
 */
public class Chase extends AbstractApiResultBean {
	public static final String QUERY_ID = "chase_id";
	public static final String QUERY_PLAN_ID = "plan_id";
	public static final String QUERY_UID = "uid";
	public static final String QUERY_PHASE = "phase";
	public static final String QUERY_USERNAME = "username";
	public static final String QUERY_LOTTERY_TYPE = "lottery_type";
	public static final String QUERY_RECYCLE_TYPE = "type";
	public static final String QUERY_CONTENT = "content";
	public static final String QUERY_CHASE_STATUS = "status";
	public static final String QUERY_STOPCHASE_TYPE = "win_operate";
	
	public static final String ORDER_ID = "chase_id";
	public static final String ORDER_PLAN_ID = "plan_id";
	public static final String ORDER_CREATED_TIME = "timeline";
	public static final String ORDER_AMOUNT = "plan_amount";
	
	private String id;				//追号编号
	private LotteryType lotteryType;
	private long uid;
	private String username;
	
	private SelectType selectType;	//选号类型
	private ChaseType chaseType;    //追号类型
	
	private Date createdTime;		//方案创建时间
	
	private PlayType playType;		//玩法
	
	private String content;			//方案内容
	private int amount;				//方案金额
	
	private ChaseStatus status;		//追号状态
	
	private StopChaseType stopChaseType;	//停止追号类型
	
	private PlanCreateType createType;	//方案创建类型
	
	private YesNoStatus dltAddition;		//大乐透扩展字段：是否追加投注

	public static Chase convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		Chase chase = new Chase();
		
		chase.id = getString(object, "chase_id");
		chase.setLotteryType(LotteryType.getItem(getInt(object, "lottery_type")));
		chase.uid = getLong(object, "uid");
		chase.username = getString(object, "username");
		chase.setCreatedTime(CoreDateUtils.parseDate(getString(object, "timeline"), CoreDateUtils.DATETIME));
		chase.setSelectType(SelectType.getItem(getInt(object, "select_type")));
		chase.setPlayType(PlayType.getItem(getInt(object, "play_type")));
		chase.setChaseType(ChaseType.getItem(getInt(object, "chase_type")));
		chase.content = getString(object, "plan_content");
		chase.amount = getInt(object, "plan_amount");
		
		chase.setStatus(ChaseStatus.getItem(getInt(object, "status")));
		chase.setStopChaseType(StopChaseType.getItem(getInt(object, "win_operate")));
		
		JSONObject obj = getObject(object, "ext");
		if(obj != null && obj.containsKey("dlt_addition") && getInt(obj, "dlt_addition") != -1){		
			chase.setDltAddition(YesNoStatus.getItem(getInt(obj, "dlt_addition")));
		}else{
			chase.setDltAddition(null);
		}
		
		if (!isEmpty(object, "create_type") && !isNull(object, "create_type")) {
			chase.setCreateType(PlanCreateType.getItem(getInt(object, "create_type")));
		} else {
			chase.setCreateType(PlanCreateType.DEFAULT);
		}
		
		return chase;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Chase> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<Chase> list = new ArrayList<Chase>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LotteryType getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public SelectType getSelectType() {
		return selectType;
	}

	public void setSelectType(SelectType selectType) {
		this.selectType = selectType;
	}

	public PlayType getPlayType() {
		return playType;
	}

	public void setPlayType(PlayType playType) {
		this.playType = playType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public ChaseStatus getStatus() {
		return status;
	}

	public void setStatus(ChaseStatus status) {
		this.status = status;
	}

	public StopChaseType getStopChaseType() {
		return stopChaseType;
	}

	public void setStopChaseType(StopChaseType stopChaseType) {
		this.stopChaseType = stopChaseType;
	}

	public YesNoStatus getDltAddition() {
		return dltAddition;
	}

	public void setDltAddition(YesNoStatus dltAddition) {
		this.dltAddition = dltAddition;
	}

	public ChaseType getChaseType() {
		return chaseType;
	}

	public void setChaseType(ChaseType chaseType) {
		this.chaseType = chaseType;
	}

	public PlanCreateType getCreateType() {
		return createType;
	}

	public void setCreateType(PlanCreateType createType) {
		this.createType = createType;
	}
	
}
