/**
 * 
 */
package com.lehecai.core.exception;

/**
 * @author leiming
 *
 */
public class UnmatchedLotteryDrawResultException extends Exception {

	private static final long serialVersionUID = 5485918198294802761L;

	public UnmatchedLotteryDrawResultException(String message) {
		super(message);
	}
	
	public UnmatchedLotteryDrawResultException() {
		this("不匹配的开奖结果格式");
	}
}
