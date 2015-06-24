/**
 * 
 */
package com.lehecai.core.lottery.fetcher.jclq;

import java.util.Date;

import com.lehecai.core.lottery.JclqDynamicSaleStatus;
import com.lehecai.core.lottery.JclqRaceStatus;
import com.lehecai.core.lottery.JclqStaticSaleStatus;
import com.lehecai.core.util.CoreDateUtils;

/**
 * @author qatang
 *
 */
public class JclqScheduleItem {
	
	private String matchNum;        //赛事编码
	private Integer officialNum;    //官方编码
	private Date officialDate;      //官方公布比赛场次的日期
	private String matchName;		//联赛或赛事名称
	private Date matchDate;		    //比赛日期
	//private Date endSaleTime;		//销售截止时间
	private JclqRaceStatus status;  //赛程状态
	private String homeTeam;		//主队
	private String awayTeam;		//客队
	private String dynamicHandicap;     //浮动奖金投注让分
	private String staticHandicap;      //固定奖金投注当前让分
	private String dynamicPresetScore;  //浮动奖金投注预设总分
	private String staticPresetScore;   //固定奖金投注当前预设总分
	private JclqStaticSaleStatus staticSaleSfStatus;	//固定奖金胜负玩法销售状态
	private JclqDynamicSaleStatus dynamicSaleSfStatus;	//浮动奖金胜负玩法销售状态
	private JclqStaticSaleStatus staticSaleRfsfStatus;	//固定奖金让分胜负玩法销售状态
	private JclqDynamicSaleStatus dynamicSaleRfsfStatus;//浮动奖金让分胜负玩法销售状态
	private JclqStaticSaleStatus staticSaleSfcStatus;	//固定奖金胜分差玩法销售状态
	private JclqDynamicSaleStatus dynamicSaleSfcStatus;	//浮动奖金胜分差玩法销售状态
	private JclqStaticSaleStatus staticSaleDxfStatus;	//固定奖金大小分玩法销售状态
	private JclqDynamicSaleStatus dynamicSaleDxfStatus;	//浮动奖金大小分玩法销售状态
	
	public String getJclqScheduleInfo(){
		StringBuffer sb = new StringBuffer();
		sb.append("[竞彩篮球赛程]");
		sb.append(",赛事编码:").append(this.getMatchNum());
		sb.append(",官方编码:").append(this.getOfficialNum());
		sb.append(",官方公布比赛场次的日期:").append(CoreDateUtils.formatDate(this.getOfficialDate()));
		sb.append(",赛事:").append(this.getMatchName());
		sb.append(",比赛日期:").append(CoreDateUtils.formatDateTime(this.getMatchDate()));
		sb.append(",赛程状态:").append(this.getStatus().getName());
		sb.append(",主队:").append(this.getHomeTeam());
		sb.append(",客队:").append(this.getAwayTeam());
		sb.append(",浮动奖金投注让分:").append(this.getDynamicHandicap());
		sb.append(",固定奖金投注当前让分:").append(this.getStaticHandicap());
		sb.append(",浮动奖金投注预设总分:").append(this.getDynamicPresetScore());
		sb.append(",固定奖金投注当前预设总分:").append(this.getStaticPresetScore());
		sb.append(",浮动奖金胜负玩法销售状态:").append(this.getDynamicSaleSfStatus().getName());
		sb.append(",固定奖金胜负玩法销售状态:").append(this.getStaticSaleSfStatus().getName());
		sb.append(",浮动奖金让分胜负玩法销售状态:").append(this.getDynamicSaleRfsfStatus().getName());
		sb.append(",固定奖金让分胜负玩法销售状态:").append(this.getStaticSaleRfsfStatus().getName());
		sb.append(",浮动奖金胜分差玩法销售状态:").append(this.getDynamicSaleSfcStatus().getName());
		sb.append(",固定奖金胜分差玩法销售状态:").append(this.getStaticSaleSfcStatus().getName());
		sb.append(",浮动奖金大小分玩法销售状态:").append(this.getDynamicSaleDxfStatus().getName());
		sb.append(",固定奖金大小分玩法销售状态:").append(this.getStaticSaleDxfStatus().getName());
		return sb.toString();
	}

	public String getMatchNum() {
		return matchNum;
	}

	public void setMatchNum(String matchNum) {
		this.matchNum = matchNum;
	}

	public Integer getOfficialNum() {
		return officialNum;
	}

	public void setOfficialNum(Integer officialNum) {
		this.officialNum = officialNum;
	}

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	public JclqRaceStatus getStatus() {
		return status;
	}

	public void setStatus(JclqRaceStatus status) {
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

	public JclqStaticSaleStatus getStaticSaleSfStatus() {
		return staticSaleSfStatus;
	}

	public void setStaticSaleSfStatus(JclqStaticSaleStatus staticSaleSfStatus) {
		this.staticSaleSfStatus = staticSaleSfStatus;
	}

	public JclqDynamicSaleStatus getDynamicSaleSfStatus() {
		return dynamicSaleSfStatus;
	}

	public void setDynamicSaleSfStatus(JclqDynamicSaleStatus dynamicSaleSfStatus) {
		this.dynamicSaleSfStatus = dynamicSaleSfStatus;
	}

	public JclqStaticSaleStatus getStaticSaleRfsfStatus() {
		return staticSaleRfsfStatus;
	}

	public void setStaticSaleRfsfStatus(JclqStaticSaleStatus staticSaleRfsfStatus) {
		this.staticSaleRfsfStatus = staticSaleRfsfStatus;
	}

	public JclqDynamicSaleStatus getDynamicSaleRfsfStatus() {
		return dynamicSaleRfsfStatus;
	}

	public void setDynamicSaleRfsfStatus(JclqDynamicSaleStatus dynamicSaleRfsfStatus) {
		this.dynamicSaleRfsfStatus = dynamicSaleRfsfStatus;
	}

	public JclqStaticSaleStatus getStaticSaleSfcStatus() {
		return staticSaleSfcStatus;
	}

	public void setStaticSaleSfcStatus(JclqStaticSaleStatus staticSaleSfcStatus) {
		this.staticSaleSfcStatus = staticSaleSfcStatus;
	}

	public JclqDynamicSaleStatus getDynamicSaleSfcStatus() {
		return dynamicSaleSfcStatus;
	}

	public void setDynamicSaleSfcStatus(JclqDynamicSaleStatus dynamicSaleSfcStatus) {
		this.dynamicSaleSfcStatus = dynamicSaleSfcStatus;
	}

	public JclqStaticSaleStatus getStaticSaleDxfStatus() {
		return staticSaleDxfStatus;
	}

	public void setStaticSaleDxfStatus(JclqStaticSaleStatus staticSaleDxfStatus) {
		this.staticSaleDxfStatus = staticSaleDxfStatus;
	}

	public JclqDynamicSaleStatus getDynamicSaleDxfStatus() {
		return dynamicSaleDxfStatus;
	}

	public void setDynamicSaleDxfStatus(JclqDynamicSaleStatus dynamicSaleDxfStatus) {
		this.dynamicSaleDxfStatus = dynamicSaleDxfStatus;
	}

	public String getDynamicHandicap() {
		return dynamicHandicap;
	}

	public void setDynamicHandicap(String dynamicHandicap) {
		this.dynamicHandicap = dynamicHandicap;
	}

	public String getStaticHandicap() {
		return staticHandicap;
	}

	public void setStaticHandicap(String staticHandicap) {
		this.staticHandicap = staticHandicap;
	}

	public String getDynamicPresetScore() {
		return dynamicPresetScore;
	}

	public void setDynamicPresetScore(String dynamicPresetScore) {
		this.dynamicPresetScore = dynamicPresetScore;
	}

	public String getStaticPresetScore() {
		return staticPresetScore;
	}

	public void setStaticPresetScore(String staticPresetScore) {
		this.staticPresetScore = staticPresetScore;
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
}
