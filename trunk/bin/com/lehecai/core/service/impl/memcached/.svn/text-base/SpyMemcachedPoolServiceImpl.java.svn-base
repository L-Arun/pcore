/**
 * 
 */
package com.lehecai.core.service.impl.memcached;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import net.spy.memcached.MemcachedClient;

/**
 * @author Sunshow
 *
 */
public class SpyMemcachedPoolServiceImpl extends SpyMemcachedServiceImpl {

	private int checkedOut;		// 当前活动的连接数
	
	private Map<MemcachedClient, Boolean> activeConnections = new HashMap<MemcachedClient, Boolean>();	// 活动的连接
	private Vector<MemcachedClient> freeConnections = new Vector<MemcachedClient>();	// 可用的连接
	
	private long getConnectionTimeout = 5000;
	
	private int maxActive;		// 最大活动连接数
	
	/* (non-Javadoc)
	 * @see com.lehecai.core.service.impl.memcached.SpyMemcachedServiceImpl#disconnect(net.spy.memcached.MemcachedClient)
	 * 使用完毕的连接不销毁，放回连接池留待下次使用
	 */
	@Override
	protected synchronized void disconnect(MemcachedClient mc) throws Exception {
		freeConnections.add(mc);	// 放回连接池
		activeConnections.remove(mc);	// 从活动的连接里移除
		checkedOut --;
		notifyAll();
	}
	
	/* (non-Javadoc)
	 * @see com.lehecai.core.service.impl.memcached.SpyMemcachedServiceImpl#getConnection()
	 * 从连接池中获取连接，如果没有可用的连接，创建一个新的
	 */
	@Override
	protected synchronized MemcachedClient getConnection() throws Exception {
		MemcachedClient mc = null;
		if (freeConnections.size() > 0) {
			// 如果有可用连接
			mc = freeConnections.remove(0);
			if (!mc.isAlive()) {
				logger.error("连接已不可用，尝试重新获取");
				mc = this.getConnection();
			}
		} else if (maxActive <= 0 || checkedOut < maxActive) {
			// 如果无可用连接且活动连接数上限未满
			mc = this.newConnection();
		} else {
			// 如果无可用连接且活动连接数上限满
			mc = this.getConnection(getConnectionTimeout);
		}
		if (mc != null) {
			checkedOut ++;
			activeConnections.put(mc, true);
		}
		return mc;
	}
	
	protected synchronized MemcachedClient getConnection(long timeout) throws Exception {
		long start = System.currentTimeMillis();
		MemcachedClient mc;
		while ((mc = this.getConnection()) == null) {
			try {
				wait(timeout);
			} catch (InterruptedException e) {
				logger.error(e.getMessage(), e);
			}
			if (System.currentTimeMillis() - start > timeout) {
				return null;
			}
		}
		return mc;
	}
	
	protected MemcachedClient newConnection() throws Exception {
		return super.getConnection();
	}

	public synchronized void destroy() throws Exception {
		// 关闭所有可用的连接
		for (MemcachedClient mc : freeConnections) {
			try {
				super.disconnect(mc);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		// 关闭活动的连接
		Set<MemcachedClient> activeClients = activeConnections.keySet();
		for (MemcachedClient mc : activeClients) {
			try {
				super.disconnect(mc);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		// 重置
		checkedOut = 0;
		activeConnections.clear();
		freeConnections.clear();
	}

	public void setGetConnectionTimeout(long getConnectionTimeout) {
		this.getConnectionTimeout = getConnectionTimeout;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}
	
}
