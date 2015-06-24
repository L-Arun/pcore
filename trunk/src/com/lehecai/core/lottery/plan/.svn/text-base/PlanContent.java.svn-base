/**
 * 
 */
package com.lehecai.core.lottery.plan;

import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 方案内容
 * @author Sunshow
 *
 */
public class PlanContent {
	/**
	 * 倍数
	 */
	private int multiple;
	
	/**
	 * 多个数据行的内容
	 */
	private List<PlanContentLine> lines;

	public int getMultiple() {
		return multiple;
	}

	public void setMultiple(int multiple) {
		this.multiple = multiple;
	}

	public List<PlanContentLine> getLines() {
		return lines;
	}

	public void setLines(List<PlanContentLine> lines) {
		this.lines = lines;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(StringUtils.join(lines, PlanContentConstant.LINE));
		
		sb.append(PlanContentConstant.MULTIPLE);
		sb.append(multiple);
		
		return sb.toString();
	}
}
