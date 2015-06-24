/**
 * 
 */
package com.lehecai.core.test.api.retrymodel;

import com.lehecai.core.api.retrymodel.ApiRetryCallback;
import com.lehecai.core.api.retrymodel.ApiRetryTaskExecutor;

/**
 * @author Sunshow
 *
 */
public class ApiRetryTaskTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApiRetryTaskExecutor executor = new ApiRetryTaskExecutor();
		executor.init();
		
		try {
			Object object = executor.invokeAsyncWithResult(new ApiRetryCallback<Object>() {
				
				@Override
				protected Object execute() throws Exception {
					System.out.println(11111);
					synchronized (this) {
						this.wait(1000);
						System.out.println(22222);
					}
					return "444444";
				}
			}, 3000);
			System.out.println(object.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(33333);
			executor.destroy();
		}
		
		/*
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<String> future = executor.submit(new Callable<String>() {// 使用Callable接口作为构造参数
					public String call() {
						System.out.println(33333);
						return "hihihi";
					}
				});

		System.out.println(future.isDone());
		
		try {
			String result = future.get(5000, TimeUnit.MILLISECONDS); //取得结果，同时设置超时执行时间为5秒。同样可以用future.get()，不设置执行超时时间取得结果
			System.out.println(result);
			System.out.println(future.isDone());
		} catch (InterruptedException e) {
			future.cancel(true);
		} catch (ExecutionException e) {
			future.cancel(true);
		} catch (TimeoutException e) {
			future.cancel(true);
		} finally {
			executor.shutdown();
		}
		*/
	}

}
