/**
 * 
 */
package com.lehecai.core.lottery.fetcher;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * @author Sunshow
 *
 */
public class FetcherType extends IntegerBeanLabelItem {
	
	private static final long serialVersionUID = -6956187828967068356L;
	
	private static final Logger logger = LoggerFactory.getLogger(FetcherType.class.getName());
	
	private static List<FetcherType> items = new ArrayList<FetcherType>();
	
	public final static FetcherType T_DEFAULT = new FetcherType("Default", 0);
	public final static FetcherType T_OFFICIAL = new FetcherType("Official", 1);
	public final static FetcherType T_500WAN = new FetcherType("500Wan", 2);
	public final static FetcherType T_DYJ = new FetcherType("DYJ", 3);
	public final static FetcherType T_STARLOTT = new FetcherType("STARLOTT", 4);
	public final static FetcherType T_AIBO = new FetcherType("AIBO", 5);
	public final static FetcherType T_CLIENT = new FetcherType("Client", 6);
	public final static FetcherType T_ZJOL = new FetcherType("ZJOL", 7);	
	public final static FetcherType T_OKOOO = new FetcherType("Okooo", 8); 
	public final static FetcherType T_PLOTAPI = new FetcherType("PlotAPI", 9);
	public final static FetcherType T_PLOTREMOTE = new FetcherType("PlotRemote", 10);
	public final static FetcherType T_SHISHICAI = new FetcherType("ShiShiCai", 11);
	public final static FetcherType T_AICAIPIAO = new FetcherType("AiCaiPiao", 12);
	public final static FetcherType T_PENGINEAPI = new FetcherType("PengineAPI", 13);
	public final static FetcherType T_ZHCW = new FetcherType("ZHCW", 14);
	public final static FetcherType T_500WAN_WEB = new FetcherType("500WanWeb", 15); 
	public final static FetcherType T_8788 = new FetcherType("8788", 16); 

	protected FetcherType(String name, int value) {
		super(FetcherType.class.getName(), name, value);
		items.add(this);
	}
	
	public static FetcherType getItem(int value){
		try {
			return (FetcherType)FetcherType.getResult(FetcherType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	/**
	 * @return 所有抓取的列表
	 */
	public static List<FetcherType> getItems() {
		return items;
	}
}
