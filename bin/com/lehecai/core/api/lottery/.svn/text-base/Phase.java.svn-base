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
import com.lehecai.core.lottery.PhaseStatus;
import com.lehecai.core.lottery.PhaseType;
import com.lehecai.core.lottery.TerminalStatus;
import com.lehecai.core.util.CoreDateUtils;

/**
 * 彩期
 *
 */
public class Phase extends AbstractApiResultBean {
	public static final String QUERY_PHASETYPE = "phasetype";
	public static final String QUERY_PHASE = "phase";
	public static final String QUERY_STATUS = "status";
	public static final String QUERY_FORSALE = "forsale";
	public static final String QUERY_IS_CURRENT = "is_current";
	public static final String QUERY_CREATETIME = "create_at";
	public static final String QUERY_TIME_STARTSALE = "time_startsale";
	public static final String QUERY_TIME_ENDSALE = "time_endsale";
	public static final String QUERY_TIME_ENDTICKET = "time_endticket";
	public static final String QUERY_TIME_DRAW = "time_draw";
	public static final String QUERY_RESULT = "result";
	public static final String QUERY_TERMINAL_STATUS = "terminal_status";
	
	public static final String SET_PHASETYPE = "phasetype";
	public static final String SET_PHASES = "phases";
	public static final String SET_PHASE = "phase";
	public static final String SET_TIME_STARTSALE = "time_startsale";
	public static final String SET_TIME_ENDSALE = "time_endsale";
	public static final String SET_TIME_ENDTICKET = "time_endticket";
	public static final String SET_TIME_DRAW = "time_draw";
	public static final String SET_STATUS = "status";
	public static final String SET_FORSALE = "forsale";
	public static final String SET_IS_CURRENT = "is_current";
	public static final String SET_RESULT = "result";
	public static final String SET_RESULT_DETAIL = "result_detail";
	public static final String SET_POOL_AMOUNT = "pool_amount";
	public static final String SET_SALE_AMOUNT = "sale_amount";
	public static final String SET_EXT = "ext";
	public static final String SET_CREATE_AT = "create_at";
	public static final String SET_CREATE_NUM = "num";
	public static final String SET_CREATE_START_TIME = "start";
	public static final String SET_FC3D_SJH = "fc3d_sjh";
	public static final String SET_TERMINAL_STATUS = "terminal_status";
	public static final String SET_FORDRAW = "fordraw";
	
	public static final String ORDER_PHASE = "phase";
	public static final String ORDER_PHASETYPE = "phasetype";
	public static final String ORDER_CREATETIME = "create_at";
	public static final String ORDER_TIME_STARTSALE = "time_startsale";
	public static final String ORDER_TIME_ENDSALE = "time_endsale";
	public static final String ORDER_TIME_ENDTICKET = "time_endticket";
	public static final String ORDER_TIME_DRAW = "time_draw";
	
	
	private PhaseType phaseType;		//彩期类型
	private String phase;				//彩期号
	private Date createTime;			//创建彩期时间
	private Date startSaleTime;			//开始销售时间
	private Date endSaleTime;			//结束销售时间
	private Date endTicketTime;			//停止出票时间
	private Date drawTime;				//开奖时间
	private PhaseStatus phaseStatus;	//彩期状态
	private YesNoStatus forsale;		//是否开启销售
	private YesNoStatus fordraw;		//是否设为开奖结果
	private YesNoStatus isCurrent;		//是否为当前彩期
	private String result;				//开奖结果
	private String resultDetail;		//开奖结果详情
	private String poolAmount;			//奖池金额
	private String saleAmount;			//销售总金额
	private String ext;					//扩展信息
	private String fc3dSjh;			//福彩3D试机号
	private TerminalStatus terminalStatus; 	//终端是否可以出票的状态
	
	public static final String JSON_KEY_PHASETYPE_VALUE = "phaseTypeValue";
	public static final String JSON_KEY_PHASETYPE_NAME = "phaseTypeName";
	public static final String JSON_KEY_PHASE = "phase";
	public static final String JSON_KEY_CREATETIME = "createTime";
	public static final String JSON_KEY_STARTSALETIME = "startSaleTime";
	public static final String JSON_KEY_ENDSALETIME = "endSaleTime";
	public static final String JSON_KEY_ENDTICKETTIME = "endTicketTime";
	public static final String JSON_KEY_DRAWTIME = "drawTime";
	public static final String JSON_KEY_PHASESTATUS_VALUE = "phaseStatusValue";
	public static final String JSON_KEY_PHASESTATUS_NAME = "phaseStatusName";
	public static final String JSON_KEY_FORSALE = "forsale";
	public static final String JSON_KEY_ISCURRENT = "isCurrent";
	public static final String JSON_KEY_RESULT = "result";
	public static final String JSON_KEY_RESULTDETAIL = "resultDetail";
	public static final String JSON_KEY_POOLAMOUNT = "poolAmount";
	public static final String JSON_KEY_SALEAMOUNT = "saleAmount";
	public static final String JSON_KEY_EXT = "ext";
	public static final String JSON_KEY_FC3DSJH = "fc3dSjh";
	
	
	public static Phase convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		Phase phase = new Phase();
		
		phase.setPhaseType(PhaseType.getItem(getInt(object,"phasetype")));
		phase.phase = getString(object, "phase");
		phase.setCreateTime(getDate(object, "create_at", CoreDateUtils.DATETIME));
		phase.setStartSaleTime(getDate(object, "time_startsale", CoreDateUtils.DATETIME));
		phase.setEndSaleTime(getDate(object, "time_endsale", CoreDateUtils.DATETIME));
		phase.setEndTicketTime(getDate(object, "time_endticket", CoreDateUtils.DATETIME));
		phase.setDrawTime(getDate(object, "time_draw", CoreDateUtils.DATETIME));
		phase.setPhaseStatus(PhaseStatus.getItem(getInt(object,"status")));
		phase.setForsale(YesNoStatus.getItem(getInt(object,"forsale")));
		phase.setFordraw(YesNoStatus.getItem(getInt(object,"fordraw")));
		phase.setIsCurrent(YesNoStatus.getItem(getInt(object,"is_current")));
		phase.setResult(getString(object, "result"));
		phase.resultDetail = getString(object, "result_detail");
		phase.poolAmount = getString(object, "pool_amount");
		phase.saleAmount = getString(object, "sale_amount");
		phase.ext = getString(object, "ext");
		if (object.containsKey("fc3d_sjh")) {
			phase.fc3dSjh = getString(object, "fc3d_sjh");
		}
		phase.setTerminalStatus(TerminalStatus.getItem(getInt(object, "terminal_status")));
		
		return phase;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Phase> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<Phase> list = new ArrayList<Phase>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}
	public static JSONObject toJSON(Phase phase) {
		JSONObject object = JSONObject.fromObject(phase);
		
		return object;
	}
	/**
	 * 编辑开奖结果json
	 * @param phase
	 * @return
	 */
	public static JSONObject toEditJSON(Phase phase) {
		JSONObject object = new JSONObject();
		if(phase != null){
			object.put(JSON_KEY_PHASETYPE_VALUE, phase.getPhaseType()==null?"":phase.getPhaseType().getValue());
			object.put(JSON_KEY_PHASETYPE_NAME, phase.getPhaseType()==null?"":phase.getPhaseType().getName());
			object.put(JSON_KEY_PHASE, phase.getPhase()==null?"":phase.getPhase());
			object.put(JSON_KEY_CREATETIME, phase.getCreateTime()==null?"":CoreDateUtils.formatDateTime(phase.getCreateTime()));
			object.put(JSON_KEY_STARTSALETIME, phase.getStartSaleTime()==null?"":CoreDateUtils.formatDateTime(phase.getStartSaleTime()));
			object.put(JSON_KEY_ENDSALETIME, phase.getEndSaleTime()==null?"":CoreDateUtils.formatDateTime(phase.getEndSaleTime()));
			object.put(JSON_KEY_ENDTICKETTIME, phase.getEndTicketTime()==null?"":CoreDateUtils.formatDateTime(phase.getEndTicketTime()));
			object.put(JSON_KEY_DRAWTIME, phase.getDrawTime()==null?"":CoreDateUtils.formatDateTime(phase.getDrawTime()));
			object.put(JSON_KEY_PHASESTATUS_VALUE, phase.getPhaseStatus()==null?"":phase.getPhaseStatus().getValue());
			object.put(JSON_KEY_PHASESTATUS_NAME, phase.getPhaseStatus()==null?"":phase.getPhaseStatus().getName());
			object.put(JSON_KEY_FORSALE, phase.getForsale()==null?YesNoStatus.NO.getValue():phase.getForsale().getValue());
			object.put(JSON_KEY_ISCURRENT, phase.getIsCurrent()==null?YesNoStatus.NO.getValue():phase.getIsCurrent().getValue());
			object.put(JSON_KEY_RESULT, phase.getResult()==null?"":phase.getResult());
			object.put(JSON_KEY_RESULTDETAIL, phase.getResultDetail()==null?"":phase.getResultDetail());
			object.put(JSON_KEY_POOLAMOUNT, phase.getPoolAmount()==null?"":phase.getPoolAmount());
			object.put(JSON_KEY_SALEAMOUNT, phase.getSaleAmount()==null?"":phase.getSaleAmount());
			object.put(JSON_KEY_EXT, phase.getExt()==null?"":phase.getExt());
			object.put(JSON_KEY_FC3DSJH, phase.getFc3dSjh()==null?"":phase.getFc3dSjh());
		}
		
		return object;
	}
	public static JSONArray toJSONArray(List<Phase> phases) {
		JSONArray ja = new JSONArray();
		JSONObject jsonObject = null;
		if(phases!=null&&phases.size()>0){
			for(Phase phase:phases){
				jsonObject = Phase.toJSON(phase);
				ja.add(jsonObject);
			}
		}
		return ja;
	}
	public PhaseType getPhaseType() {
		return phaseType;
	}

	public void setPhaseType(PhaseType phaseType) {
		this.phaseType = phaseType;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getStartSaleTime() {
		return startSaleTime;
	}

	public void setStartSaleTime(Date startSaleTime) {
		this.startSaleTime = startSaleTime;
	}

	public Date getEndSaleTime() {
		return endSaleTime;
	}

	public void setEndSaleTime(Date endSaleTime) {
		this.endSaleTime = endSaleTime;
	}

	public Date getEndTicketTime() {
		return endTicketTime;
	}

	public void setEndTicketTime(Date endTicketTime) {
		this.endTicketTime = endTicketTime;
	}

	public Date getDrawTime() {
		return drawTime;
	}

	public void setDrawTime(Date drawTime) {
		this.drawTime = drawTime;
	}

	public PhaseStatus getPhaseStatus() {
		return phaseStatus;
	}

	public void setPhaseStatus(PhaseStatus phaseStatus) {
		this.phaseStatus = phaseStatus;
	}

	public YesNoStatus getForsale() {
		return forsale;
	}

	public void setForsale(YesNoStatus forsale) {
		this.forsale = forsale;
	}

	public YesNoStatus getFordraw() {
		return fordraw;
	}

	public void setFordraw(YesNoStatus fordraw) {
		this.fordraw = fordraw;
	}

	public YesNoStatus getIsCurrent() {
		return isCurrent;
	}

	public void setIsCurrent(YesNoStatus isCurrent) {
		this.isCurrent = isCurrent;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResultDetail() {
		return resultDetail;
	}

	public void setResultDetail(String resultDetail) {
		this.resultDetail = resultDetail;
	}

	public String getPoolAmount() {
		return poolAmount;
	}

	public void setPoolAmount(String poolAmount) {
		this.poolAmount = poolAmount;
	}

	public String getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(String saleAmount) {
		this.saleAmount = saleAmount;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getFc3dSjh() {
		return fc3dSjh;
	}

	public void setFc3dSjh(String fc3dSjh) {
		this.fc3dSjh = fc3dSjh;
	}

	public TerminalStatus getTerminalStatus() {
		return terminalStatus;
	}

	public void setTerminalStatus(TerminalStatus terminalStatus) {
		this.terminalStatus = terminalStatus;
	}
	
}
