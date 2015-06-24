/**
 * 
 */
package com.lehecai.core.api.bean.range.impl.handler;

import java.util.Calendar;
import java.util.Date;

import com.lehecai.core.api.bean.range.IRangeProp;
import com.lehecai.core.api.bean.range.IRangePropHandleResult;
import com.lehecai.core.api.bean.range.impl.prop.SingleRangeProp;
import com.lehecai.core.util.CoreDateUtils;

/**
 * 根据发号器规则产生的ID来生成range
 * 此种情况下，前六位表示: yyMMdd
 * @author qatang
 *
 */
public class DateGeneratedIdRangePropHandler extends AbstractRangePropHandler {

	/**
	 * 往前往后的边界推断值
	 * [0]: left
	 * [1]: right
	 */
	private int[] range;
	
	/**
	 * rangeDay确定下边界推迟天数
	 * @param rangeDay
	 */
	public DateGeneratedIdRangePropHandler(int[] range) {
		this.range = range;
	}
	
	@Override
	public IRangePropHandleResult getRange(IRangeProp rangeProp) throws Exception {
		SingleRangeProp singleRangeProp = (SingleRangeProp) rangeProp;

		String id = singleRangeProp.getValue();
		
		Date date = CoreDateUtils.parseDate(id.substring(0, 6), "yyMMdd");
		
		Calendar begin = Calendar.getInstance();
		begin.setTime(date);
		begin.add(Calendar.DATE, -1 * range[0]);
		
		
		Calendar end = Calendar.getInstance();
		end.setTime(date);
		end.add(Calendar.DATE, range[1]);
		
		IRangePropHandleResult result = new DateRangePropHandleResult(begin.getTime(), end.getTime());
		
		return result;
	}

}
