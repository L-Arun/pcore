package com.lehecai.core.util.lottery;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.PhaseType;
/**
 * 彩票工具类
 * @author leiming
 *
 */
public class LotteryUtil {

	private static final String LOTTERYDRAW_PREFIX = "LOTTERYDRAW";
	private static final String LOTTERY = "lottery";
	private static final String PHASE = "phase";
	private static final String DRAW = "draw";
	private static final String REWARD = "reward";
	private static final String LOCK = "lock";
	private static final String SEPARATOR = ":";
	private static final String CURRENT_PHASENO = "current_phaseNo";
	private static final String LOTTERY_TICKET_CONFIG = "lottery_ticket_config";
	
	private static final String LOTTERYREWARD_PREFIX = "LOTTERYREWARD";	
	/**
	 * 开奖锁在memcached中读取的超时时间 单位:秒
	 */
	public static final long DRAW_LOCK_TIMEOUT = 5;
	/**
	 * 派奖锁在memcached中读取的超时时间 单位:秒
	 */
	public static final long REWARD_LOCK_TIMEOUT = 10;
	/**
	 * 获得彩种在memcached当前彩期号的超时时间 单位:秒
	 */
	public static final long GET_CURRENT_PHASENO_TIMEOUT = 5;
	/**
	 * 获得彩种在memcached彩种出票配置的超时时间 单位:秒
	 */
	public static final long GET_LOTTERY_TICKET_CONFIG_TIMEOUT = 5;
	
	public static final int ALIVE_TIME = 600; // 默认缓存10分钟	
	
	/**
	 * 生成memcache开奖 key
	 * @param lotteryType
	 * @param phase
	 * @return
	 */
	public static String generateLotteryDrawKey(LotteryType lotteryType, String phase) {
		return LOTTERYDRAW_PREFIX + SEPARATOR + String.valueOf(lotteryType.getValue()) + SEPARATOR + phase;
	}
	/**
	 * 根据投注类型生成memcache开奖 key
	 * @param lotteryType
	 * @param phase
	 * @param betTypeValue
	 * @return
	 */
	public static String generateLotteryDrawKeyByBetType(LotteryType lotteryType,String endDateStr, String betTypeValue) {
		return LOTTERYDRAW_PREFIX + SEPARATOR + String.valueOf(lotteryType.getValue()) + SEPARATOR + endDateStr + SEPARATOR + betTypeValue;
	}
	
	/**
	 * 生成memcached开奖操作锁的key
	 * @param lotteryType
	 * @param phase
	 * @return
	 */
	public static String generateLotteryDrawLockKey(LotteryType lotteryType, String phase) {
		return LOTTERY + SEPARATOR + DRAW + SEPARATOR + LOCK + SEPARATOR + String.valueOf(lotteryType.getValue()) + SEPARATOR + phase;
	}
	/**
	 * 根据投注类型生成memcached开奖操作锁的key
	 * @param lotteryType
	 * @param startDateStr
	 * @param endDateStr
	 * @param betTypeValue
	 * @return
	 */
	public static String generateLotteryDrawLockKeyByBetType(LotteryType lotteryType, String startDateStr,String endDateStr ,String betTypeValue) {
		return LOTTERY + SEPARATOR + DRAW + SEPARATOR + LOCK + SEPARATOR + String.valueOf(lotteryType.getValue()) + SEPARATOR + startDateStr + SEPARATOR + endDateStr + SEPARATOR + betTypeValue;
	}
	/**
	 * 生成memcached派奖操作锁的key
	 * @param lotteryType
	 * @param phase
	 * @return
	 */
	public static String generateLotteryRewardLockKey(LotteryType lotteryType, String phase) {
		return LOTTERY + SEPARATOR + REWARD + SEPARATOR + LOCK + SEPARATOR + String.valueOf(lotteryType.getValue()) + SEPARATOR + phase;
	}

	/**
	 * 生成memcached派奖 key
	 * @param lotteryType
	 * @param phase
	 * @return
	 */
	public static String generateLotteryRewardKey(LotteryType lotteryType, String phase) {
		return LOTTERYREWARD_PREFIX + SEPARATOR + String.valueOf(lotteryType.getValue()) + SEPARATOR + phase;
	}	
	/**
	 * 生成memcached派奖 key
	 * @param lotteryType
	 * @param phase
	 * @return
	 */
	public static String generateLotteryRewardStatusKey(String taskId) {
		return LOTTERYREWARD_PREFIX + SEPARATOR + taskId;
	}
	/**
	 * 生成memcached当前彩期号key
	 * @param lotteryType
	 * @return
	 */
	public static String generateCurrentPhaseKey(LotteryType lotteryType){
		return PHASE + SEPARATOR + CURRENT_PHASENO + SEPARATOR + String.valueOf(PhaseType.getItem(lotteryType).getValue());
	}
	/**
	 * 生成memcached彩种出票配置key
	 * @param lotteryType
	 * @return
	 */
	public static String generateLotteryTicketConfigKey(LotteryType lotteryType){
		return LOTTERY + SEPARATOR + LOTTERY_TICKET_CONFIG + SEPARATOR + String.valueOf(lotteryType.getValue());
	}
}
