package com.lehecai.core.lottery.lock;

import com.lehecai.core.memcached.IMemcachedObject;

/**
 * 派奖memCache锁对象
 * 用于防止重复派奖
 * @author leiming
 *
 */
public class LotteryRewardMemCacheLock implements IMemcachedObject{
	private static final long serialVersionUID = 3082622543269110759L;
	
	private String phase;//彩期号
	private Integer lotteryTypeValue;//彩期类型值
	
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public Integer getLotteryTypeValue() {
		return lotteryTypeValue;
	}
	public void setLotteryTypeValue(Integer lotteryTypeValue) {
		this.lotteryTypeValue = lotteryTypeValue;
	}
	
}
