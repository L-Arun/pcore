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
import com.lehecai.core.lottery.BetType;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.PhaseType;
import com.lehecai.core.lottery.PlanCreateType;
import com.lehecai.core.lottery.PlanStatus;
import com.lehecai.core.lottery.PlanTicketStatus;
import com.lehecai.core.lottery.PlanType;
import com.lehecai.core.lottery.PlatformType;
import com.lehecai.core.lottery.PlayType;
import com.lehecai.core.lottery.PublicStatus;
import com.lehecai.core.lottery.RebateStatus;
import com.lehecai.core.lottery.ResultStatus;
import com.lehecai.core.lottery.SelectType;
import com.lehecai.core.util.CoreDateUtils;

/**
 * @author Sunshow
 *
 */
public class Plan extends AbstractApiResultBean {
	public static final String QUERY_ID = "plan_id";
	public static final String QUERY_UID = "uid";
	public static final String QUERY_USERNAME = "username";
	public static final String QUERY_LOTTERY_TYPE = "lottery_type";
	public static final String QUERY_PHASE_TYPE = "phasetype";
	public static final String QUERY_PHASE = "phase";
	public static final String QUERY_CREATED_TIME = "create_at";
	public static final String QUERY_PLAN_TYPE = "plan_type";
	public static final String QUERY_SELECT_TYPE = "select_type";
	public static final String QUERY_PLAY_TYPE = "play_type";
	public static final String QUERY_PUBLIC_STATUS = "public_status";
	public static final String QUERY_DEAD_LINE = "deadline";
	public static final String QUERY_PRINT_TIME = "ticket_print_time";
	public static final String QUERY_PLAN_STATUS = "plan_status";
	public static final String QUERY_SOURCE_ID = "source";
	public static final String QUERY_RESULT_STATUS = "result_status";
	public static final String QUERY_TITLE = "title";
	public static final String QUERY_DESCRIPTION = "description";
	public static final String QUERY_IS_TOP = "top";
	public static final String QUERY_ALLOW_AUTO_FOLLOW = "allow_auto_follow";
	public static final String QUERY_DC_LAST_NUM = "dc_last_num";
	public static final String QUERY_DC_FIRST_NUM = "dc_first_num";
	public static final String QUERY_UPLOAD_ID = "upload_id";
	public static final String QUERY_PLANTICKETSTATUS = "ticket_status";
	public static final String QUERY_CONTENT = "content";
	public static final String QUERY_AMOUNT = "amount";
	public static final String QUERY_BETTYPE = "bet_type";
	public static final String QUERY_REBATE_STATUS = "rebate_status";
	public static final String QUERY_LAST_MATCH_TIME = "last_match_time";
	public static final String QUERY_PRIZE_TIME = "prize_time";
	public static final String QUERY_PLAN_CREATE_TYPE = "create_type";
	public static final String QUERY_PLATFORM = "platform";
	
	public static final String SET_PLAN_STATUS = "plan_status";
	public static final String SET_RESULT_STATUS = "result_status";
	public static final String SET_TOP = "top";
	public static final String SET_PRETAX_PRIZE = "prize_pretax";
	public static final String SET_POSTTAX_PRIZE = "prize_posttax";
	public static final String SET_PRIZE_CONTENT = "prize_content";
	public static final String SET_PRIZE_TIME = "prize_time";
	public static final String SET_PRINT_TIME = "ticket_print_time";
	public static final String SET_FC3D_SJH = "fc3d_sjh";
	public static final String SET_PLANTICKETSTATUS = "ticket_status";
	public static final String SET_REBATE_AMOUNT = "rebate_amount";
	public static final String SET_REBATE = "rebate";
	public static final String SET_REBATE_STATUS = "rebate_status";
	public static final String SET_TITLE = "title";
	public static final String SET_DESCRIPTION = "description";
	public static final String SET_DEADLINE = "deadline";
	public static final String SET_SALE_DEADLINE = "sale_deadline";
	
	public static final String ORDER_ID = "plan_id";
	public static final String ORDER_LOTTERY_TYPE = "lottery_type";
	public static final String ORDER_PHASE = "phase";
	public static final String ORDER_CREATED_TIME = "create_at";
	public static final String ORDER_AMOUNT = "amount";
	public static final String ORDER_DEAD_LINE = "deadline";
	public static final String ORDER_PRINT_TIME = "ticket_print_time";
	public static final String ORDER_PRETAX_PRIZE = "prize_pretax";
	public static final String ORDER_POSTTAX_PRIZE = "prize_posttax";
	public static final String ORDER_RESULT_STATUS = "result_status";
	public static final String ORDER_PROGRESS = "progress";
	public static final String ORDER_TOP = "top";
	public static final String ORDER_LAST_MATCH_TIME = "last_match_time";

	private String id;			//方案编号
	private LotteryType lotteryType;
	private PhaseType phaseType;	//彩期类型
	private	String phase;			//彩期编号
	private long uid;
	private String username;
	
	private Date createdTime;		//方案创建时间
	private PlanType planType;		//方案类型
	private SelectType selectType;	//选号类型
	private int multiple;			//投注倍数
	private PlayType playType;		//玩法
	
	private String content;			//方案内容
	private long uploadId;				//上传文件的ID，非文件上传时=0
	private PublicStatus publicStatus;	//隐私状态
	
	private long amount;				//方案金额
	private long parts;				//方案总份数
	private long founderParts;		//发起人购买份数
	private long reservedParts;		//保底份额
	private long soldParts;			//售出份额
	
	private PlanStatus planStatus;  //方案状态
	private Date deadline;			//出票截止时间
	private Date printTime;			//出票时间
	private ResultStatus resultStatus;	//结果状态，是否已中奖等
	
	private double rebate;			//发单人提成，百分比1-100
	private double rebateAmount;	//发单人提成金额
	private RebateStatus rebateStatus;	//提成状态
	
	private double pretaxPrize;		//税前奖金
	private double posttaxPrize;	//税后奖金
	private String prizeContent;	//中奖详细描述
	private Date prizeTime;			//计奖时间
	
	private int sourceId;			//渠道来源
	private String title;			//方案标题
	private String description;		//方案描述
	private int top;				//置顶值
	
	private YesNoStatus allowAutoFollow;	//是否允许自动跟单
	
	private String fc3dSJH;					//福彩3D扩展字段：试机号
	private YesNoStatus dltAddition;		//大乐透扩展字段：是否追加投注
	private long dcLastNum;					//北单扩展字段：方案中最后一个场次的索引顺序
	private long dcFirstNum;					//北单扩展字段：方案中第一个场次的索引顺序
	
	private String[] matchNums;            //北单、竞彩方案内容中比赛编码
	
	private PlanTicketStatus planTicketStatus;  //方案票状态 
	
	private Date saleDeadline;		//销售截止时间
	
	private BetType betType;//投注类型 如竞彩篮球的固定投注和浮动投注
	
	private Date lastMatchTime;		//最后一场比赛的时间，用来判断竞彩的日期
	
	private PlanCreateType createType;	//方案创建类型
	
	private PlatformType platformType; //平台

	public static Plan convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		Plan plan = new Plan();
		
		plan.id = getString(object, "plan_id");
		plan.setLotteryType(LotteryType.getItem(getInt(object, "lottery_type")));
		plan.setPhaseType(PhaseType.getItem(getInt(object, "phasetype")));
		plan.phase = getString(object, "phase");
		plan.uid = getLong(object, "uid");
		plan.username = getString(object, "username");
		plan.setCreatedTime(getDate(object, "create_at", CoreDateUtils.DATETIME));
		plan.setPlanType(PlanType.getItem(getInt(object, "plan_type")));
		plan.setSelectType(SelectType.getItem(getInt(object, "select_type")));
		plan.multiple = getInt(object, "multiple");
		plan.setPlayType(PlayType.getItem(getInt(object, "play_type")));
		plan.content = getString(object, "content");
		plan.uploadId = getLong(object, "upload_id");
		plan.setPublicStatus(PublicStatus.getItem(getInt(object, "public_status")));
		plan.amount = getLong(object, "amount");
		plan.parts = getLong(object, "parts");
		plan.founderParts = getLong(object, "parts_founder");
		plan.reservedParts = getLong(object, "parts_reserved");
		plan.soldParts = getLong(object, "parts_sold");
		plan.setPlanStatus(PlanStatus.getItem(getInt(object, "plan_status")));
		
		plan.rebate = getDouble(object, "rebate");
		plan.rebateAmount = getDouble(object, "rebate_amount");
		plan.setRebateStatus(RebateStatus.getItem(getInt(object, "rebate_status")));
		
		plan.setDeadline(getDate(object, "deadline", CoreDateUtils.DATETIME));
		plan.setSaleDeadline(getDate(object, "sale_deadline", CoreDateUtils.DATETIME));
		plan.setPrintTime(getDate(object, "ticket_print_time", CoreDateUtils.DATETIME));
		plan.setResultStatus(ResultStatus.getItem(getInt(object, "result_status")));
		
		plan.pretaxPrize = getDouble(object, "prize_pretax");
		plan.posttaxPrize = getDouble(object, "prize_posttax");
		plan.prizeContent = getString(object, "prize_content");
		plan.setPrizeTime(getDate(object, "prize_time", CoreDateUtils.DATETIME));
		
		plan.sourceId = getInt(object, "source");
		plan.title = getString(object, "title");
		plan.description = getString(object, "description");
		plan.setTop(getInt(object, "top"));
		plan.setAllowAutoFollow(YesNoStatus.getItem(getInt(object, "allow_auto_follow")));
		
		if (object.containsKey("ticket_status")) {
			plan.setPlanTicketStatus(PlanTicketStatus.getItem(getInt(object, "ticket_status")));
		} else {
			plan.setPlanTicketStatus(PlanTicketStatus.DEFAULT);
		}
		
		if (object.containsKey("bet_type")) {
			plan.setBetType(BetType.getItem(getInt(object, "bet_type")));
		} else {
			plan.setBetType(BetType.DEFAULT);
		}
		
		plan.setLastMatchTime(getDate(object, "last_match_time", CoreDateUtils.DATETIME));
		
		// 扩展字段的处理
		if (object.containsKey("dlt_addition")) {
			plan.setDltAddition(YesNoStatus.getItem(getInt(object, "dlt_addition")));
		}
		if (object.containsKey("dc_last_num")) {
			plan.dcLastNum = getLong(object, "dc_last_num");
		}
		if (object.containsKey("dc_first_num")) {
			plan.dcFirstNum = getLong(object, "dc_first_num");
		}
		if (object.containsKey("fc3d_sjh")) {
			plan.fc3dSJH = getString(object, "fc3d_sjh");
		}
		if (object.containsKey("match_nums")) {
			JSONArray jsonArray = getArray(object, "match_nums");
			if (jsonArray != null && jsonArray.size() > 0) {
				plan.matchNums = new String[jsonArray.size()];
				for (int i = 0; i < jsonArray.size(); i++) {
					plan.matchNums[i] = jsonArray.getString(i);
				}
			} else {
				plan.matchNums = null;
			}
		}
		
		if (!isEmpty(object, "create_type") && !isNull(object, "create_type")) {
			plan.setCreateType(PlanCreateType.getItem(getInt(object, "create_type")));
		} else {
			plan.setCreateType(PlanCreateType.DEFAULT);
		}
		
		plan.setPlatformType(PlatformType.getItem(getInt(object,"platform")));
		return plan;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Plan> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<Plan> list = new ArrayList<Plan>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	/**
	 * 获取方案日志显示的信息头<br/>
	 * [彩种]第<xxx>期,方案(id:)
	 * @param plan
	 * @return
	 */
	public static String getPlanLogHeader(Plan plan){
		if(plan == null){
			return "方案不存在";
		}else{
			StringBuffer sb = new StringBuffer("");
			sb.append("[").append(plan.getLotteryType()==null?"未指定彩票类型":plan.getLotteryType().getName()).append("]");
			sb.append("第<").append(plan.getPhase()==null?"未指定彩期号":plan.getPhase()).append(">期,");
			sb.append("方案(id:").append(plan.getId()).append(")");
			return sb.toString();
		}
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

	public PlanType getPlanType() {
		return planType;
	}

	public void setPlanType(PlanType planType) {
		this.planType = planType;
	}

	public SelectType getSelectType() {
		return selectType;
	}

	public void setSelectType(SelectType selectType) {
		this.selectType = selectType;
	}

	public int getMultiple() {
		return multiple;
	}

	public void setMultiple(int multiple) {
		this.multiple = multiple;
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

	public PublicStatus getPublicStatus() {
		return publicStatus;
	}

	public void setPublicStatus(PublicStatus publicStatus) {
		this.publicStatus = publicStatus;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getParts() {
		return parts;
	}

	public void setParts(long parts) {
		this.parts = parts;
	}

	public long getFounderParts() {
		return founderParts;
	}

	public void setFounderParts(long founderParts) {
		this.founderParts = founderParts;
	}

	public long getReservedParts() {
		return reservedParts;
	}

	public void setReservedParts(long reservedParts) {
		this.reservedParts = reservedParts;
	}

	public long getSoldParts() {
		return soldParts;
	}

	public void setSoldParts(long soldParts) {
		this.soldParts = soldParts;
	}

	public double getRebate() {
		return rebate;
	}

	public void setRebate(double rebate) {
		this.rebate = rebate;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Date getPrintTime() {
		return printTime;
	}

	public void setPrintTime(Date printTime) {
		this.printTime = printTime;
	}

	public ResultStatus getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(ResultStatus resultStatus) {
		this.resultStatus = resultStatus;
	}

	public double getPretaxPrize() {
		return pretaxPrize;
	}

	public void setPretaxPrize(double pretaxPrize) {
		this.pretaxPrize = pretaxPrize;
	}

	public double getPosttaxPrize() {
		return posttaxPrize;
	}

	public void setPosttaxPrize(double posttaxPrize) {
		this.posttaxPrize = posttaxPrize;
	}

	public String getPrizeContent() {
		return prizeContent;
	}

	public void setPrizeContent(String prizeContent) {
		this.prizeContent = prizeContent;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public YesNoStatus getDltAddition() {
		return dltAddition;
	}

	public void setDltAddition(YesNoStatus dltAddition) {
		this.dltAddition = dltAddition;
	}

	public long getDcLastNum() {
		return dcLastNum;
	}

	public void setDcLastNum(long dcLastNum) {
		this.dcLastNum = dcLastNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public YesNoStatus getAllowAutoFollow() {
		return allowAutoFollow;
	}

	public void setAllowAutoFollow(YesNoStatus allowAutoFollow) {
		this.allowAutoFollow = allowAutoFollow;
	}

	public PlanStatus getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(PlanStatus planStatus) {
		this.planStatus = planStatus;
	}

	public long getDcFirstNum() {
		return dcFirstNum;
	}

	public void setDcFirstNum(long dcFirstNum) {
		this.dcFirstNum = dcFirstNum;
	}
	
	public long getUploadId() {
		return uploadId;
	}
	public void setUploadId(long uploadId) {
		this.uploadId = uploadId;
	}
	public String getFc3dSJH() {
		return fc3dSJH;
	}

	public void setFc3dSJH(String fc3dSJH) {
		this.fc3dSJH = fc3dSJH;
	}

	public PlanTicketStatus getPlanTicketStatus() {
		return planTicketStatus;
	}

	public void setPlanTicketStatus(PlanTicketStatus planTicketStatus) {
		this.planTicketStatus = planTicketStatus;
	}
	

	public BetType getBetType() {
		return betType;
	}

	public void setBetType(BetType betType) {
		this.betType = betType;
	}

	public double getRebateAmount() {
		return rebateAmount;
	}

	public void setRebateAmount(double rebateAmount) {
		this.rebateAmount = rebateAmount;
	}

	public RebateStatus getRebateStatus() {
		return rebateStatus;
	}

	public void setRebateStatus(RebateStatus rebateStatus) {
		this.rebateStatus = rebateStatus;
	}

	public Date getSaleDeadline() {
		return saleDeadline;
	}

	public void setSaleDeadline(Date saleDeadline) {
		this.saleDeadline = saleDeadline;
	}

	public Date getLastMatchTime() {
		return lastMatchTime;
	}

	public void setLastMatchTime(Date lastMatchTime) {
		this.lastMatchTime = lastMatchTime;
	}

	/**
	 * 获取方案基本信息
	 * @return
	 */
	public String getPlanInfo(){
		StringBuffer sb = new StringBuffer("");
		sb.append("[").append(this.getLotteryType()==null?"未指定彩票类型":this.getLotteryType().getName()).append("]");
		sb.append("第<").append(this.getPhase()==null?"未指定彩期号":this.getPhase()).append(">期,");
		sb.append("方案(id:").append(this.getId()).append("),");
		sb.append("方案类型:").append(this.getPlanType()==null?"":this.getPlanType().getName()).append(",");
		sb.append("方案内容(").append(this.getContent()).append("),");
		sb.append("方案状态:").append(this.getPlanStatus()==null?"":this.getPlanStatus().getName()).append(",");
		sb.append("方案玩法:").append(this.getPlayType()==null?"":this.getPlayType().getName()).append(",");
		sb.append("选号类型:").append(this.getSelectType()==null?"":this.getSelectType().getName()).append(",");
		sb.append("倍数:").append(this.getMultiple()).append("倍,");
		sb.append("方案金额:").append(this.getAmount()).append("元,");
		sb.append("方案总份数:").append(this.getParts()).append("份");
		sb.append(".");
		return sb.toString();
	}
	
	/**
	 * 获取方案中奖信息
	 * @return
	 */
	public String getPlanWinningInfo(){
		StringBuffer sb = new StringBuffer("");
		sb.append(getPlanInfo());
		sb.append("中奖状态:").append(resultStatus==null?"未开奖":resultStatus.getName()).append(",");
		sb.append("中奖税前金额:").append(pretaxPrize).append("元,");
		sb.append("中奖税后金额:").append(posttaxPrize).append("元,");
		sb.append("中奖详情:").append(prizeContent).append(".");
		return sb.toString();
	}

	public PlanCreateType getCreateType() {
		return createType;
	}

	public void setCreateType(PlanCreateType createType) {
		this.createType = createType;
	}

	public String[] getMatchNums() {
		return matchNums;
	}

	public void setMatchNums(String[] matchNums) {
		this.matchNums = matchNums;
	}

	public Date getPrizeTime() {
		return prizeTime;
	}

	public void setPrizeTime(Date prizeTime) {
		this.prizeTime = prizeTime;
	}

	public PlatformType getPlatformType() {
		return platformType;
	}

	public void setPlatformType(PlatformType platformType) {
		this.platformType = platformType;
	}
}
