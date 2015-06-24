/**
 * 
 */
package com.lehecai.core.lottery;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * @author Sunshow
 * 结果类型
 */
public class ResultStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 6202761979404329974L;

	private static final Logger logger = LoggerFactory.getLogger(ResultStatus.class.getName());
	
	private static List<ResultStatus> items = new ArrayList<ResultStatus>();
	
	protected ResultStatus(String name, int value) {
		super(ResultStatus.class.getName(), name, value);
		items.add(this);
	}
	
	public static ResultStatus getItem(int value){
		try {
			return (ResultStatus)ResultStatus.getResult(ResultStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<ResultStatus> getItems() {
		return items;
	}

	public static final ResultStatus ALL = new ResultStatus("全部", -1);
	public static final ResultStatus DEFAULT = new ResultStatus("默认", 0);
	
	public static final ResultStatus NOT_DREW = new ResultStatus("未开奖", 1);
	public static final ResultStatus NOT_WON = new ResultStatus("未中奖", 2);
	public static final ResultStatus WON = new ResultStatus("已中奖", 3);
	public static final ResultStatus REWARDED = new ResultStatus("已派奖", 4);
	
	public static final ResultStatus DRAWING = new ResultStatus("正在开奖", 5);
	public static final ResultStatus PREDRAWING = new ResultStatus("正在预开奖", 6);
	public static final ResultStatus PRIZE_COMPUTE_PENDING = new ResultStatus("待计算奖金", 7);
	public static final ResultStatus PRIZE_COMPUTING = new ResultStatus("正在计算奖金", 8);
	
}
