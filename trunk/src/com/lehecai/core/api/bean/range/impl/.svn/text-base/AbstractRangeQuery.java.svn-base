package com.lehecai.core.api.bean.range.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.api.ApiRequestRange;
import com.lehecai.core.api.bean.range.IRangeProp;
import com.lehecai.core.api.bean.range.IRangePropHandleResult;
import com.lehecai.core.api.bean.range.IRangePropHandler;
import com.lehecai.core.api.bean.range.IRangeQuery;
import com.lehecai.core.api.bean.range.RangePropRule;
import com.lehecai.core.api.bean.range.RangePropType;
import com.lehecai.core.api.bean.range.RangeType;
import com.lehecai.core.api.bean.range.impl.handler.DateRangePropHandleResult;
import com.lehecai.core.util.CoreDateUtils;

/**
 * 
 * @author qatang
 *
 */
public abstract class AbstractRangeQuery implements IRangeQuery{
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private List<IRangeProp> rangePropItemList;
	
	public AbstractRangeQuery(List<IRangeProp> rangePropItemList) {
		this.rangePropItemList = rangePropItemList;
	}
	
	protected List<IRangeProp> getRangePropItemList() {
		return rangePropItemList;
	}

	abstract protected RangePropRule[] getRangePropRules();
	
	@Override
	public ApiRequestRange getRange() throws Exception {
		List<IRangeProp> rangePropItemList = this.getRangePropItemList();
		if (rangePropItemList == null || rangePropItemList.isEmpty()) {
			logger.warn("未设置range条件");
			return null;
		}

		RangePropRule[] rangePropRuleArray = this.getRangePropRules();
		
		IRangePropHandleResult finalResult = null;
		for (RangePropRule ruleItem : rangePropRuleArray) {
			// 默认实现只支持日期型的范围，其他跳过
			if (ruleItem.getRangeType().getValue() != RangeType.DATE.getValue()) {
				continue;
			}

			for (IRangeProp propItem : rangePropItemList) {
				if (ruleItem.getName().equals(propItem.getName())) {
					
					IRangePropHandler handler = ruleItem.getRangePropHandler();
					if (handler == null) {
						logger.warn("未找到处理器, prop name={}", ruleItem.getName());
						break;
					}
					
					finalResult = compareDateRange(finalResult, handler.getRange(propItem));
					
					if (ruleItem.getRangePropType().getValue() == RangePropType.BREAK.getValue()) {
						break;
					}

					// 理论上允许存在一个条件多次设置，所以每次都遍历完
				}
			}
			
			if (finalResult != null && ruleItem.getRangePropType().getValue() == RangePropType.BREAK.getValue()) {
				break;
			}
		}

		if (finalResult == null) {
			logger.warn("比对所有规则后未生成有效的range范围");
			return null;
		}
		
		return new ApiRequestRange(finalResult.getBegin(), finalResult.getEnd());
	}

	/**
	 * 合并两个日期范围，返回最小的区间
	 * @param range1
	 * @param range2
	 * @return
	 * @throws Exception 如果两个区间无交集，则查询结果必然为空集，则抛出异常
	 */
	protected IRangePropHandleResult compareDateRange(IRangePropHandleResult range1, IRangePropHandleResult range2) throws Exception {
		Date beginDate1 = range1 == null || range1.getBegin() == null ? null : CoreDateUtils.parseDate(range1.getBegin());
		Date endDate1 = range1 == null || range1.getEnd() == null ? null : CoreDateUtils.parseDate(range1.getEnd());
		
		Date beginDate2 = range2 == null || range2.getBegin() == null ? null : CoreDateUtils.parseDate(range2.getBegin());
		Date endDate2 = range2 == null || range2.getEnd() == null ? null : CoreDateUtils.parseDate(range2.getEnd());

		Date beginDate = null, endDate = null;
		
		if (beginDate1 != null && beginDate2 != null) {
			// 如果两个均不为空，取较晚的一个
			if (beginDate1.before(beginDate2)) {
				beginDate = beginDate2;
			} else {
				beginDate = beginDate1;
			}
		} else if (beginDate1 == null) {
			beginDate = beginDate2;
		} else {
			beginDate = beginDate1;
		}
		
		if (endDate1 != null && endDate2 != null) {
			// 如果两个均不为空，取较早的一个
			if (endDate1.before(endDate2)) {
				endDate = endDate1;
			} else {
				endDate = endDate2;
			}
		} else if (endDate1 == null) {
			endDate = endDate2;
		} else {
			endDate = endDate1;
		}

		// 如果无交集
		if (beginDate != null && endDate != null && beginDate.after(endDate)) {
			throw new RuntimeException("两个日期范围无交集");
		}

		IRangePropHandleResult resultRange = new DateRangePropHandleResult(beginDate, endDate);
		return resultRange;
	}
}
