/**
 * 
 */
package com.lehecai.core.thread.impl.message;

import java.util.ArrayList;
import java.util.List;

import com.lehecai.core.bean.PairValue;
import com.lehecai.core.exception.message.MessagePublishException;
import com.lehecai.core.message.EventType;
import com.lehecai.core.message.IMessagePublisher;
import com.lehecai.core.thread.AbstractThreadRunnable;
import com.lehecai.core.warning.IWarningTool;
import com.lehecai.core.warning.WarningType;

/**
 * 消息发布的异步线程实现，添加时无阻塞，异步执行
 * @author sunshow
 *
 */
public abstract class AbstractMessagePublishRunnable extends
		AbstractThreadRunnable implements IMessagePublisher {
	
	private IWarningTool warningTool;
	
	private Object taskLock = new Object();
	private List<PairValue<EventType, String>> tasks = new ArrayList<PairValue<EventType, String>>();
	
	private PairValue<EventType, String> lastFailedTask = null;	// 最近失败的一个消息任务

	protected abstract boolean execute(EventType eventType, String message) throws MessagePublishException;
	
	protected abstract long getRetryFailedWaitTimeInMillis();
	
	/* (non-Javadoc)
	 * @see com.lehecai.core.thread.AbstractThreadRunnable#executeRun()
	 */
	@Override
	protected void executeRun() {
		logger.info("准备启动事件消息发布处理线程");
		
		if (running) {
			logger.error("该线程已经在运行中");
			return;
		}
		
		running = true;
		while (running) {
			while (true) {
				PairValue<EventType, String> task = null;
				
				// 如果有等待重试的任务，优先执行
				if (lastFailedTask != null) {
					task = lastFailedTask;
					lastFailedTask = null;
					
					long waitTimeInMillis = this.getRetryFailedWaitTimeInMillis();
					if (waitTimeInMillis > 0) {
						// 重试等待
						synchronized (this) {
							try {
								this.wait(waitTimeInMillis);
							} catch (InterruptedException e) {
								logger.error(e.getMessage(), e);
							}
						}
					}
				} else {
					synchronized (taskLock) {
						if (tasks.size() > 0) {
							task = tasks.remove(0);
						}
					}
				}
				if (task == null) {
					break;
				}
				logger.info("消息类型：{}, 消息体：{}", task.getLeft(), task.getRight());
				
				// 执行任务
				boolean rc = false;
				try {
					rc = execute(task.getLeft(), task.getRight());
				} catch (Exception e) {
					logger.error("执行任务出错");
					logger.error(e.getMessage(), e);
				}
				if (!rc) {
					// 发布消息失败后的处理
					// 阻塞执行，等待修复
					logger.error("任务处理失败");
					logger.error("消息类型：{}, 消息体：{}", task.getLeft(), task.getRight());
					
					try {
						warningTool.sendMail(WarningType.EVENT_MESSAGE_PUBLISH_ERROR, String.format("事件消息发布失败，消息类型：%s, 消息体：%s", task.getLeft(), task.getRight()));
					} catch (Exception e) {
						logger.error(e.getMessage(), e);
					}

					// 标记最新失败的任务，等待重试
					lastFailedTask = task;
					continue;
				}

			}

			synchronized (this) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
		
		logger.info("事件消息发布执行线程结束");
	}

	/* (non-Javadoc)
	 * @see com.lehecai.core.thread.message.IEventMessagePublisher#publish(com.lehecai.core.message.EventType, java.lang.String)
	 */
	@Override
	public void publish(EventType eventType, String message)
			throws MessagePublishException {
		synchronized (taskLock) {
			tasks.add(new PairValue<EventType, String>(eventType, message));
		}
		// 添加完后唤醒执行
		this.executeNotify();
	}

	public IWarningTool getWarningTool() {
		return warningTool;
	}

	public void setWarningTool(IWarningTool warningTool) {
		this.warningTool = warningTool;
	}

}
