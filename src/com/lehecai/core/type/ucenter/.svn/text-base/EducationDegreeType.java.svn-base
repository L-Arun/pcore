/**
 * 
 */
package com.lehecai.core.type.ucenter;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * 文化程度
 * @author qatang
 *  
 */
public class EducationDegreeType extends IntegerBeanLabelItem {
	private static final long serialVersionUID = 1497568813772971022L;

	private static final Logger logger = LoggerFactory.getLogger(EducationDegreeType.class.getName());
	
	private static List<EducationDegreeType> items = new ArrayList<EducationDegreeType>();
	private static List<EducationDegreeType> queryItems = new ArrayList<EducationDegreeType>();
	
	protected EducationDegreeType(String name, int value, boolean queryOnly) {
		super(EducationDegreeType.class.getName(), name, value);
		
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	
	protected EducationDegreeType(String name, int value) {
		this(name, value, false);
	}
	
	public static EducationDegreeType getItem(int value){
		try {
			return (EducationDegreeType)EducationDegreeType.getResult(EducationDegreeType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<EducationDegreeType> getItems() {
		return items;
	}
	
	public static List<EducationDegreeType> getItemsForQuery() {
		return queryItems;
	}

	public static final EducationDegreeType ALL = new EducationDegreeType("全部", -1, true);
	
	public static final EducationDegreeType HIGH_SCHOOL = new EducationDegreeType("高中", 1);
	public static final EducationDegreeType ASSOCIATES = new EducationDegreeType("专科", 2);
	public static final EducationDegreeType BACHELOR = new EducationDegreeType("本科", 3);
	public static final EducationDegreeType MASTERS = new EducationDegreeType("硕士", 4);
	public static final EducationDegreeType DOCTORATE = new EducationDegreeType("博士", 5);
}
