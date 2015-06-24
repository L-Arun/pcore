package com.lehecai.core.lottery.fetcher.ext.worker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.ext.LotteryExtendItem;

public abstract class AbstractFC3DExtendSJHFetcherWorker {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	abstract public LotteryExtendItem fetch(String phase);
}
