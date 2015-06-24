/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jczq;

import java.util.Date;

import com.lehecai.core.lottery.JczqDynamicSaleStatus;
import com.lehecai.core.lottery.JczqRaceStatus;
import com.lehecai.core.lottery.JczqStaticSaleStatus;
import com.lehecai.core.util.CoreDateUtils;

/**
 * @author qatang
 *
 */
public class JczqScheduleItem {
	
	private String matchNum;        //赛事编码
	private String officialNum;    //官方编码
	private Date officialDate;      //官方公布比赛场次的日期
	private String matchName;		//联赛或赛事名称
	private Date matchDate;		    //比赛日期
	//private Date endSaleTime;		//销售截止时间
	private JczqRaceStatus status;  //赛程状态
	private String homeTeam;		//主队
	private String awayTeam;		//客队
	private String handicap;     //让球
	private JczqStaticSaleStatus staticSaleSpfStatus;	//固定奖金让球胜平负玩法销售状态
	private JczqDynamicSaleStatus dynamicSaleSpfStatus;	//浮动奖金让球胜平负玩法销售状态
	private JczqStaticSaleStatus staticSaleBfStatus;	//固定奖金全场比分玩法销售状态
	private JczqDynamicSaleStatus dynamicSaleBfStatus;  //浮动奖金全场比分玩法销售状态
	private JczqStaticSaleStatus staticSaleJqsStatus;	//固定奖金进球总数玩法销售状态
	private JczqDynamicSaleStatus dynamicSaleJqsStatus;	//浮动奖金进球总数玩法销售状态
	private JczqStaticSaleStatus staticSaleBqcStatus;	//固定奖金半全场胜平负玩法销售状态
	private JczqDynamicSaleStatus dynamicSaleBqcStatus;	//浮动奖金半全场胜平负玩法销售状态
	
	public String getJczqScheduleInfo(){
		StringBuffer sb = new StringBuffer();
		sb.append("[竞彩足球赛程]");
		sb.append(",赛事编码:").append(this.getMatchNum());
		sb.append(",官方编码:").append(this.getOfficialNum());
		sb.append(",官方公布比赛场次的日期:").append(CoreDateUtils.formatDate(this.getOfficialDate()));
		sb.append(",赛事:").append(this.getMatchName());
		sb.append(",比赛日期:").append(CoreDateUtils.formatDateTime(this.getMatchDate()));
		sb.append(",赛程状态:").append(this.getStatus().getName());
		sb.append(",主队:").append(this.getHomeTeam());
		sb.append(",客队:").append(this.getAwayTeam());
		sb.append(",让球:").append(this.getHandicap());
		sb.append(",浮动奖金胜平负玩法销售状态:").append(this.getDynamicSaleSpfStatus().getName());
		sb.append(",固定奖金胜平负玩法销售状态:").append(this.getStaticSaleSpfStatus().getName());
		sb.append(",浮动奖金全场比分玩法销售状态:").append(this.getDynamicSaleBfStatus().getName());
		sb.append(",固定奖金全场比分玩法销售状态:").append(this.getStaticSaleBfStatus().getName());
		sb.append(",浮动奖金进球总数玩法销售状态:").append(this.getDynamicSaleJqsStatus().getName());
		sb.append(",固定奖金进球总数玩法销售状态:").append(this.getStaticSaleJqsStatus().getName());
		sb.append(",浮动奖金半全场胜平负玩法销售状态:").append(this.getDynamicSaleBqcStatus().getName());
		sb.append(",固定奖金半全场胜平负玩法销售状态:").append(this.getStaticSaleBqcStatus().getName());
		return sb.toString();
	}

	public String getMatchNum() {
		return matchNum;
	}

	public void setMatchNum(String matchNum) {
		this.matchNum = matchNum;
	}

	public String getOfficialNum() {
		return officialNum;
	}

	public void setOfficialNum(String officialNum) {
		this.officialNum = officialNum;
	}

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	public JczqRaceStatus getStatus() {
		return status;
	}

	public void setStatus(JczqRaceStatus status) {
		this.status = status;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public String getHandicap() {
		return handicap;
	}

	public void setHandicap(String handicap) {
		this.handicap = handicap;
	}

	public Date getOfficialDate() {
		return officialDate;
	}

	public void setOfficialDate(Date officialDate) {
		this.officialDate = officialDate;
	}

	public Date getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	public JczqStaticSaleStatus getStaticSaleSpfStatus() {
		return staticSaleSpfStatus;
	}

	public void setStaticSaleSpfStatus(JczqStaticSaleStatus staticSaleSpfStatus) {
		this.staticSaleSpfStatus = staticSaleSpfStatus;
	}

	public JczqDynamicSaleStatus getDynamicSaleSpfStatus() {
		return dynamicSaleSpfStatus;
	}

	public void setDynamicSaleSpfStatus(JczqDynamicSaleStatus dynamicSaleSpfStatus) {
		this.dynamicSaleSpfStatus = dynamicSaleSpfStatus;
	}

	public JczqStaticSaleStatus getStaticSaleBfStatus() {
		return staticSaleBfStatus;
	}

	public void setStaticSaleBfStatus(JczqStaticSaleStatus staticSaleBfStatus) {
		this.staticSaleBfStatus = staticSaleBfStatus;
	}

	public JczqDynamicSaleStatus getDynamicSaleBfStatus() {
		return dynamicSaleBfStatus;
	}

	public void setDynamicSaleBfStatus(JczqDynamicSaleStatus dynamicSaleBfStatus) {
		this.dynamicSaleBfStatus = dynamicSaleBfStatus;
	}

	public JczqStaticSaleStatus getStaticSaleJqsStatus() {
		return staticSaleJqsStatus;
	}

	public void setStaticSaleJqsStatus(JczqStaticSaleStatus staticSaleJqsStatus) {
		this.staticSaleJqsStatus = staticSaleJqsStatus;
	}

	public JczqDynamicSaleStatus getDynamicSaleJqsStatus() {
		return dynamicSaleJqsStatus;
	}

	public void setDynamicSaleJqsStatus(JczqDynamicSaleStatus dynamicSaleJqsStatus) {
		this.dynamicSaleJqsStatus = dynamicSaleJqsStatus;
	}

	public JczqStaticSaleStatus getStaticSaleBqcStatus() {
		return staticSaleBqcStatus;
	}

	public void setStaticSaleBqcStatus(JczqStaticSaleStatus staticSaleBqcStatus) {
		this.staticSaleBqcStatus = staticSaleBqcStatus;
	}

	public JczqDynamicSaleStatus getDynamicSaleBqcStatus() {
		return dynamicSaleBqcStatus;
	}

	public void setDynamicSaleBqcStatus(JczqDynamicSaleStatus dynamicSaleBqcStatus) {
		this.dynamicSaleBqcStatus = dynamicSaleBqcStatus;
	}
}
