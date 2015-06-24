/**
 * 
 */
package com.lehecai.core.lottery.plan;

import org.apache.commons.lang.StringUtils;

import com.lehecai.core.lottery.PlayType;

/**
 * 单注方案内容
 * @author sunshow
 *
 */
public class PlanContentLine {

	/**
	 * 父玩法
	 */
	private PlayType playType;
	
	/**
	 * 子玩法，可能有多个
	 */
	private PlayType[] playTypeSubs;
	
	/**
	 * 元素组
	 */
	private PlanContentGroup[] groups;

	public PlayType getPlayType() {
		return playType;
	}

	public void setPlayType(PlayType playType) {
		this.playType = playType;
	}

	public PlayType[] getPlayTypeSubs() {
		return playTypeSubs;
	}

	public void setPlayTypeSubs(PlayType[] playTypeSubs) {
		this.playTypeSubs = playTypeSubs;
	}

	public PlanContentGroup[] getGroups() {
		return groups;
	}

	public void setGroups(PlanContentGroup[] groups) {
		this.groups = groups;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		// 主玩法
		sb.append(playType.getValue());
		
		// 如果有子玩法
		if (playTypeSubs != null && playTypeSubs.length > 0) {
			sb.append(PlanContentConstant.PLAYSUB);
			
			String[] subStrArray = new String[playTypeSubs.length];
			for (int i = 0; i < playTypeSubs.length; i++) {
				subStrArray[i] = String.valueOf(playTypeSubs[i].getValue());
			}
			
			sb.append(StringUtils.join(subStrArray, PlanContentConstant.PLAYELEMENT));
		}
		
		sb.append(PlanContentConstant.PLAY);
		
		// 数据区
		sb.append(StringUtils.join(groups, PlanContentConstant.GROUP));
		
		return sb.toString();
	}
	
}
