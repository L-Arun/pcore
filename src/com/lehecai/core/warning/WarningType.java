/**
 * 
 */
package com.lehecai.core.warning;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * @author Sunshow
 * 警告类型
 */
public class WarningType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = -5295221734170645849L;

	private static final Logger logger = LoggerFactory.getLogger(WarningType.class.getName());
	
	private static List<WarningType> items = new ArrayList<WarningType>();
	
	protected WarningType(String name, int value) {
		super(WarningType.class.getName(), name, value);
		items.add(this);
	}
	
	public static WarningType getItem(int value){
		try {
			return (WarningType)WarningType.getResult(WarningType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<WarningType> getItems() {
		return items;
	}
	
	public static final WarningType ALL = new WarningType("全部", -1);
	public static final WarningType DEFAULT = new WarningType("默认", 0);

	public static final WarningType PHASE_CURRENT_NOT_FOUND = new WarningType("未找到当前彩期", 1);

	public static final WarningType TERMINAL_NOT_FOUND = new WarningType("未找到可用终端", 2);
	
	public static final WarningType TICKET_SEND_FAILURE = new WarningType("送票失败", 3);
	
	public static final WarningType BALANCE_LACKING = new WarningType("出票帐户余额不足", 4);
	
	public static final WarningType EXECUTE_DRAW_ERROR = new WarningType("开奖出错", 6);
	public static final WarningType EXECUTE_REWARD_ERROR = new WarningType("派奖出错", 7);
	
	public static final WarningType API_CALL_FAILED = new WarningType("API请求调用出错", 8);
	
	public static final WarningType SALE_HM_CLOSE_ERROR = new WarningType("销售合买截止出错", 9);
	
	public static final WarningType FROZEN_TO_CONSUME_ERROR = new WarningType("冻结转消费出错", 10);
	
	public static final WarningType CHASE_STOP_ERROR = new WarningType("取消追号出错", 11);	
	
	public static final WarningType SYNC_TICKET_VENDER_BALANCE = new WarningType("同步出票供应商余额", 12);	
	
	public static final WarningType TICKET_BATCH_ERROR = new WarningType("批次处理出错", 13);
	
	public static final WarningType TICKET_ERROR = new WarningType("票处理出错", 14);
	
	public static final WarningType JCLQ_RACE_NOTICE = new WarningType("竞彩篮球赛程通知", 15);
	
	public static final WarningType JCZQ_RACE_NOTICE = new WarningType("竞彩足球赛程通知", 16);
	
	public static final WarningType TICKET_PRINT_FAILURE = new WarningType("出票失败", 17);
	
	public static final WarningType PLAN_ALARM_NOTICE = new WarningType("方案预警", 18);
	
	public static final WarningType THREAD_MONITOR_NOTICE = new WarningType("线程监控预警", 19);
	
	public static final WarningType COMBO_FAILED_NOTICE = new WarningType("套餐操作出错", 20);
	
	public static final WarningType STATIC_CACHE_ERROR = new WarningType("静态缓存操作出错", 21);
	
	public static final WarningType FOOTBALL_MATCH = new WarningType("足球比赛匹配", 22);
	
	public static final WarningType FOOTBALL_SCORE_WRITE_BACK = new WarningType("足球比赛比分回写", 23);
	
	public static final WarningType SPORTRADAR_DATA_SEND_OVER_TIME = new WarningType("sportradar数据推送超时", 24);
	
	public static final WarningType FTP_MONITOR_NOTICE = new WarningType("ftp心跳监控预警", 25);
	
	public static final WarningType LEO_MATCH_SPECIAL_STATUS = new WarningType("leo比赛特殊状态", 26);
	
	public static final WarningType DRAW_BIG_PRIZE_NOTIFY = new WarningType("大奖通知", 27);
	
	public static final WarningType ARCHIVE_DATA_ERROR = new WarningType("数据归档出错", 28);
	
	public static final WarningType JCLQ_PHASE_RACE_NOTICE = new WarningType("竞彩篮球彩期守护中赛程与数据库中开启赛程不一致", 29);
	
	public static final WarningType JCZQ_PHASE_RACE_NOTICE = new WarningType("竞彩足球彩期守护中赛程与数据库中开启赛程不一致", 30);
	
	public static final WarningType MONITOR_WARNING = new WarningType("监控器报警", 31);
	
	public static final WarningType STATISTIC_PROCESS_ERROR = new WarningType("过关统计错误", 32);
	
	public static final WarningType STATISTIC_MATCHLOG_NEED = new WarningType("需要匹配的日志", 33);
	
	public static final WarningType EVENT_MESSAGE_PUBLISH_ERROR = new WarningType("事件消息发布失败", 34);
	
	public static final WarningType LEO_MATCH_EDIT_TEAM = new WarningType("比赛球队被修改", 35);
}
