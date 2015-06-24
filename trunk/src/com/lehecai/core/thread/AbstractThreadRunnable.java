/**
 * 
 */
package com.lehecai.core.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sunshow
 *
 */
public abstract class AbstractThreadRunnable implements IThreadRunnable {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	protected volatile boolean running = false;
	
	private long beforeRunWaitTime = 0;	//启动前等待时间

	/* (non-Javadoc)
	 * @see com.lehecai.engine.thread.IThreadRunnable#executeNotify()
	 */
	@Override
	public void executeNotify() {
		synchronized (this) {
			notify();
		}
	}

	/* (non-Javadoc)
	 * @see com.lehecai.engine.thread.IThreadRunnable#executeStop()
	 */
	@Override
	public void executeStop() {
		synchronized (this) {
			running = false;
		}
		executeNotify();
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		if (beforeRunWaitTime > 0) {
			logger.info("启动前休眠等待({})毫秒", beforeRunWaitTime);
			synchronized (this) {
				try {
					wait(beforeRunWaitTime);
				} catch (InterruptedException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
		try {
			executeRun();
		} catch (Exception e) {
			logger.error("线程执行时发生异常", e);
		}
		logger.info("线程执行结束");
		running = false;
	}
	
	abstract protected void executeRun();

	@Override
	public boolean isRunning() {
		return running;
	}

	public long getBeforeRunWaitTime() {
		return beforeRunWaitTime;
	}

	public void setBeforeRunWaitTime(long beforeRunWaitTime) {
		this.beforeRunWaitTime = beforeRunWaitTime;
	}

}
