/**
 * 
 */
package com.lehecai.core.lottery;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * 合买红人状态
 * @author yanweijie
 */
public class SyndicateStarStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = -8013814461233302001L;

	private static final Logger logger = LoggerFactory.getLogger(SyndicateStarStatus.class.getName());
	
	private static List<SyndicateStarStatus> items = new ArrayList<SyndicateStarStatus>();
	private static List<SyndicateStarStatus> queryItems = new ArrayList<SyndicateStarStatus>();
	
	protected SyndicateStarStatus(String name, int value, boolean queryOnly) {
		super(SyndicateStarStatus.class.getName(), name, value);
		
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	
	protected SyndicateStarStatus(String name, int value) {
		this(name, value, false);
	}
	
	public static SyndicateStarStatus getItem(int value){
		try {
			return (SyndicateStarStatus)SyndicateStarStatus.getResult(SyndicateStarStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<SyndicateStarStatus> getItems() {
		return items;
	}
	
	public static List<SyndicateStarStatus> getItemsForQuery() {
		return queryItems;
	}

	public static final SyndicateStarStatus ALL = new SyndicateStarStatus("全部", -1, true);
	
	public static final SyndicateStarStatus NONESYNDICATE = new SyndicateStarStatus("当前无可参与的合买", 1);
	public static final SyndicateStarStatus FULLSYNDICATE = new SyndicateStarStatus("当前合买方案已满员", 2);
	public static final SyndicateStarStatus SYNDICATE = new SyndicateStarStatus("当前有可参与的合买方案", 3);

}
