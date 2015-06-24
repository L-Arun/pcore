/**
 * 
 */
package com.lehecai.core.api.bean.range.impl.handler;

import java.util.Calendar;
import java.util.Date;

import com.lehecai.core.api.bean.range.IRangeProp;
import com.lehecai.core.api.bean.range.IRangePropHandleResult;
import com.lehecai.core.api.bean.range.impl.prop.RegionRangeProp;
import com.lehecai.core.util.CoreDateUtils;

/**
 * 根据支持上下边界的日期型数据来产生range
 * 处理方法：
 * 根据左边界-range[0]产生: 输出左边界=输入左边界 - range[0]，如果未指定左边界， 则左边界 = 右边界 - range[0]
 * 根据右边界+range[1]产生: 输出右边界=输出右边界 + range[1]，如果未指定右边界，则右边界 = 左边界 + range[1]
 * 然后合并，取最大的范围
 * @author qatang
 *
 */
public class RegionDateRangePropHandler extends AbstractRangePropHandler {

	/**
	 * 往前往后的开始边界推断值
	 * [0]: left
	 * [1]: right
	 */
	private int[] beginRange;
	/**
	 * 往前往后的结束边界推断值
	 * [0]: left
	 * [1]: right
	 */
	private int[] endRange;
	
	/**
	 * rangeDay确定下边界推迟天数
	 * @param rangeDay
	 */
	public RegionDateRangePropHandler(int[] beginRange, int[] endRange) {
		this.beginRange = beginRange;
		this.endRange = endRange;
	}

	@Override
	public IRangePropHandleResult getRange(IRangeProp rangeProp) throws Exception {
		RegionRangeProp regionRangeProp = (RegionRangeProp) rangeProp;

		String begin = regionRangeProp.getBegin();
		String end = regionRangeProp.getEnd();
		
		Date beginLeftDate = null, beginRightDate = null;
		
		Date endLeftDate = null, endRightDate = null;
		
		Date beginDate = null, endDate = null;
		
		if (begin != null) {
			Date beginDateTmp = CoreDateUtils.parseDate(begin);
			
			Calendar beginLeft = Calendar.getInstance();
			beginLeft.setTime(beginDateTmp);
			beginLeft.add(Calendar.DATE, -1 * beginRange[0]);
			beginLeftDate = beginLeft.getTime();
			
			Calendar beginRight = Calendar.getInstance();
			beginRight.setTime(beginDateTmp);
			beginRight.add(Calendar.DATE, beginRange[1]);
			beginRightDate = beginRight.getTime();
			
			beginDate = beginLeftDate;
			endDate = beginRightDate;
		}
		
		if (end != null) {
			Date endDateTmp = CoreDateUtils.parseDate(end);
			
			Calendar endLeft = Calendar.getInstance();
			endLeft.setTime(endDateTmp);
			endLeft.add(Calendar.DATE, -1 * endRange[0]);
			endLeftDate = endLeft.getTime();
			
			Calendar endRight = Calendar.getInstance();
			endRight.setTime(endDateTmp);
			endRight.add(Calendar.DATE, endRange[1]);
			endRightDate = endRight.getTime();
			
			beginDate = beginDate == null ? endLeftDate : beginDate;
			endDate = endRightDate;
		}
		
		IRangePropHandleResult result = new DateRangePropHandleResult(beginDate, endDate);
		
		return result;
	}

}
