/**
 * 
 */
package com.lehecai.core.service.impl.memcached;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.CheckedOperationTimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.MemcachedConnectionTimeoutException;
import com.lehecai.core.exception.MemcachedOperationTimeoutException;
import com.lehecai.core.memcached.IMemcachedObject;
import com.lehecai.core.memcached.MemcachedConfig;
import com.lehecai.core.service.memcached.MemcachedService;

/**
 * @author Sunshow
 *
 */
public class SpyMemcachedServiceImpl implements MemcachedService {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private MemcachedConfig memcachedConfig;
	
	protected MemcachedClient getConnection() throws Exception {
		try {
			MemcachedClient mc = new MemcachedClient(new InetSocketAddress(memcachedConfig.getHostname(), memcachedConfig.getPort()));
			return mc;
		} catch (IOException e) {
			logger.error("连接MC出错", e);
			throw new MemcachedConnectionTimeoutException("连接MC出错");
		}
	}
	
	protected void disconnect(MemcachedClient mc) throws Exception {
		if (mc != null && mc.isAlive()) {
			mc.shutdown(memcachedConfig.getTimeout(), TimeUnit.SECONDS);
		}
	}

	@Override
	public boolean delete(String key) throws Exception {
		MemcachedClient mc = this.getConnection();
		
		try {
			Future<Boolean> f = mc.delete(key);
			return f.get(memcachedConfig.getTimeout(), TimeUnit.SECONDS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			if (e.getCause() instanceof CheckedOperationTimeoutException) {
				throw new MemcachedOperationTimeoutException(e.getMessage());
			}
			throw e;
		} finally {
			this.disconnect(mc);
		}
	}

	/* (non-Javadoc)
	 * @see com.lehecai.core.service.memcached.MemcachedService#get(java.lang.String)
	 */
	@Override
	public IMemcachedObject get(String key) throws Exception {
		try {
			return get(key, memcachedConfig.getTimeout());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			if (e.getCause() instanceof CheckedOperationTimeoutException) {
				throw new MemcachedOperationTimeoutException(e.getMessage());
			}
			throw e;
		}
	}

	@Override
	public IMemcachedObject get(String key, long timeout) throws Exception {
		MemcachedClient mc = this.getConnection();
		
		try {
			IMemcachedObject obj = null;
			Future<Object> f = mc.asyncGet(key);
			obj = (IMemcachedObject)f.get(timeout, TimeUnit.SECONDS);
			return obj;
		} catch (InterruptedException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (ExecutionException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (TimeoutException e) {
			logger.error("请求超时", e);
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			if (e.getCause() instanceof CheckedOperationTimeoutException) {
				throw new MemcachedOperationTimeoutException(e.getMessage());
			}
			throw e;
		} finally {
			this.disconnect(mc);
		}
	}

	@Override
	public boolean set(String key, IMemcachedObject object, int alive,
			long timeout) throws Exception {
		MemcachedClient mc = this.getConnection();
		
		try {
			Future<Boolean> b = null;
			b = mc.set(key, alive, object);
			if (b.get().booleanValue()) {
				return true;
			}
			return false;
		} catch (InterruptedException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (ExecutionException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			if (e.getCause() instanceof CheckedOperationTimeoutException) {
				throw new MemcachedOperationTimeoutException(e.getMessage());
			}
			throw e;
		} finally {
			this.disconnect(mc);
		}
	}

	@Override
	public Map<String, IMemcachedObject> mget(Collection<String> keys) throws Exception {
		return mget(keys, memcachedConfig.getTimeout());
	}

	@Override
	public Map<String, IMemcachedObject> mget(Collection<String> keys,
			long timeout) throws Exception {
		MemcachedClient mc = this.getConnection();
		
		try {
			Map<String, Object> found = null;
			Future<Map<String, Object>> f = mc.asyncGetBulk(keys);
			found = (Map<String, Object>)f.get(timeout, TimeUnit.SECONDS);
			Map<String, IMemcachedObject> result = new HashMap<String, IMemcachedObject>();
			if (found != null) {
				for (String key : keys) {
					IMemcachedObject obj = (IMemcachedObject)found.get(key);
					if (obj != null) {
						result.put(key, obj);
					}
				}
			}
			return result;
		} catch (InterruptedException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (ExecutionException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (TimeoutException e) {
			logger.error("请求超时", e);
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			if (e.getCause() instanceof CheckedOperationTimeoutException) {
				throw new MemcachedOperationTimeoutException(e.getMessage());
			}
			throw e;
		} finally {
			this.disconnect(mc);
		}
	}

	@Override
	public boolean set(String key, IMemcachedObject object, int alive) throws Exception {
		return this.set(key, object, alive, memcachedConfig.getTimeout());
	}

	public MemcachedConfig getMemcachedConfig() {
		return memcachedConfig;
	}

	public void setMemcachedConfig(MemcachedConfig memcachedConfig) {
		this.memcachedConfig = memcachedConfig;
	}

}
