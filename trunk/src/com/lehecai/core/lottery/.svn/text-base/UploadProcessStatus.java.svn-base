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
 * @author Sunshow
 * 方案状态
 */
public class UploadProcessStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = -1273815467245832589L;

	private static final Logger logger = LoggerFactory.getLogger(UploadProcessStatus.class.getName());
	
	private static List<UploadProcessStatus> items = new ArrayList<UploadProcessStatus>();
	
	protected UploadProcessStatus(String name, int value) {
		super(UploadProcessStatus.class.getName(), name, value);
		items.add(this);
	}
	
	public static UploadProcessStatus getItem(int value){
		try {
			return (UploadProcessStatus)UploadProcessStatus.getResult(UploadProcessStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<UploadProcessStatus> getItems() {
		return items;
	}
	
	public static final UploadProcessStatus ALL = new UploadProcessStatus("全部", -1);
	public static final UploadProcessStatus DEFAULT = new UploadProcessStatus("默认", 0);

	public static final UploadProcessStatus FINISHED = new UploadProcessStatus("完成", 1);
	public static final UploadProcessStatus START = new UploadProcessStatus("开始处理", 2);
	public static final UploadProcessStatus TRYING = new UploadProcessStatus("正在处理中", 3);
	public static final UploadProcessStatus NOSTART = new UploadProcessStatus("没有处理", 4);
	public static final UploadProcessStatus FAILURE = new UploadProcessStatus("处理失败", 5);
}
