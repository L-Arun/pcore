/**
 * 
 */
package com.lehecai.core.api.bean.range;


/**
 * @author qatang
 *
 */
public class RangePropRule {

	/**
	 * 属性名称
	 */
	private String name;

	/**
	 * 计算range时的方式，如id为break型，则只用id一个属性计算range，其他属性忽略
	 */
	private RangePropType rangePropType;

	/**
	 * range的类型，目前只有时间型的range
	 */
	private RangeType rangeType;

	/**
	 * 计算单个属性range的接口，返回IRangeHandleResult类型结果
	 */
	private IRangePropHandler rangePropHandler;

	/**
	 * 将查询属性转换为range属性
	 */
	private IRangePropConverter rangePropConverter;
	
	public RangePropRule(String name, RangePropType rangePropType, RangeType rangeType, IRangePropHandler rangePropHandler, IRangePropConverter rangePropConverter) {
		this.setName(name);
		this.setRangePropType(rangePropType);
		this.setRangeType(rangeType);
		this.setRangePropHandler(rangePropHandler);
		this.setRangePropConverter(rangePropConverter);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RangeType getRangeType() {
		return rangeType;
	}

	public void setRangeType(RangeType rangeType) {
		this.rangeType = rangeType;
	}

	public RangePropType getRangePropType() {
		return rangePropType;
	}

	public void setRangePropType(RangePropType rangePropType) {
		this.rangePropType = rangePropType;
	}

	public IRangePropHandler getRangePropHandler() {
		return rangePropHandler;
	}

	public void setRangePropHandler(IRangePropHandler rangePropHandler) {
		this.rangePropHandler = rangePropHandler;
	}

	public IRangePropConverter getRangePropConverter() {
		return rangePropConverter;
	}

	public void setRangePropConverter(IRangePropConverter rangePropConverter) {
		this.rangePropConverter = rangePropConverter;
	}

}
