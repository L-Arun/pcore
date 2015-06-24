package com.lehecai.core;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class IntegerBeanLabel implements Serializable {

	private static final long serialVersionUID = -1573317468532371095L;
	protected static Map<String, Map<String, IntegerBeanLabel>> nameMap = new HashMap<String, Map<String, IntegerBeanLabel>>(16);
	protected static Map<String, Map<Integer, IntegerBeanLabel>> valueMap = new HashMap<String, Map<Integer, IntegerBeanLabel>>(16);
    
    protected int value;
    protected transient String name;
    protected String className;

    protected IntegerBeanLabel(String className,String name, int value) {
    	this.className = className;
        this.value = value;
        this.name = name;
        add();
    }

    protected void add() {
		if (nameMap.containsKey(this.className)) {
			nameMap.get(this.className).put(this.name, this);
			valueMap.get(this.className).put(new Integer(this.value), this);
		} else {
			Map<String, IntegerBeanLabel> nameMaps = new HashMap<String, IntegerBeanLabel>();
			Map<Integer, IntegerBeanLabel> valueMaps = new HashMap<Integer, IntegerBeanLabel>();
			nameMaps.put(this.name, this);
			valueMaps.put(new Integer(this.value), this);
			nameMap.put(this.className, nameMaps);
			valueMap.put(this.className, valueMaps);
		}
    }

	public static IntegerBeanLabel get(String className, String name) {
		return nameMap.get(className).get(name);
	}

	public static IntegerBeanLabel get(String className, int value) {
		return valueMap.get(className).get(new Integer(value));
	}

	public static boolean contain(String className, int value) {
		return valueMap.get(className).containsKey(new Integer(value));
	}
	
	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	protected Object readResolve() throws ObjectStreamException {
		return get(this.className, this.value);
	}

}
