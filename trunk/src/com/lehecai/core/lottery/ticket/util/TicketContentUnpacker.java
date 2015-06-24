/**
 * 
 */
package com.lehecai.core.lottery.ticket.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.InvalidTicketContentException;
import com.lehecai.core.lottery.PlayType;
import com.lehecai.core.lottery.ticket.TicketContentConstant;
import com.lehecai.core.lottery.ticket.TicketContentElement;
import com.lehecai.core.lottery.ticket.TicketContentGroup;
import com.lehecai.core.lottery.ticket.TicketContentLine;

/**
 * 票内容解包器
 * @author sunshow
 *
 */
public class TicketContentUnpacker {
	
	protected static final Logger logger = LoggerFactory.getLogger(TicketContentUnpacker.class.getName());
	
	/**
	 * 解包票内容,并将指定玩法设置给解包完的票内容
	 * @param content 不带玩法的票内容字符串
	 * @param playType
	 * @return
	 * @throws InvalidTicketContentException
	 */
	public static List<TicketContentLine> unpack(String content, PlayType playType) throws InvalidTicketContentException {
		if (content == null) {
			return null;
		}
		
		// 首先分组多注
		String[] lines = StringUtils.split(content, TicketContentConstant.LINE);
		
		List<TicketContentLine> result = new ArrayList<TicketContentLine>();
		
		for (String line : lines) {
			try {
				TicketContentLine contentLine = unpackLineWithoutPlayType(line);
				if (contentLine == null) {
					throw new InvalidTicketContentException("单行内容解析结果为空：" + line);
				}
				contentLine.setPlayType(playType);
				result.add(contentLine);
				logger.info("解析单行票内容成功：{}", line);
			} catch (InvalidTicketContentException e) {
				logger.error(e.getMessage(), e);
				logger.error("票内容为：{}", content);
				throw e;
			}
			
		}
		
		return result;
	}

	/**
	 * 解包票内容,同时支持带玩法和不带玩法的情况
	 * @param content
	 * @return
	 * @throws InvalidTicketContentException
	 */
	public static List<TicketContentLine> unpack(String content) throws InvalidTicketContentException {
		if (content == null) {
			return null;
		}
		
		// 首先分组多注
		String[] lines = StringUtils.split(content, TicketContentConstant.LINE);
		
		List<TicketContentLine> result = new ArrayList<TicketContentLine>();
		
		for (String line : lines) {
			try {
				TicketContentLine contentLine = unpackLine(line);
				if (contentLine == null) {
					throw new InvalidTicketContentException("单行内容解析结果为空：" + line);
				}
				result.add(contentLine);
				logger.info("解析单行票内容成功：{}", line);
			} catch (InvalidTicketContentException e) {
				logger.error(e.getMessage(), e);
				logger.error("票内容为：{}", content);
				throw e;
			}
			
		}
		
		return result;
	}
	
	public static TicketContentLine unpackLine(String line) throws InvalidTicketContentException {
		if (line == null) {
			return null;
		}
		
		TicketContentLine contentLine = new TicketContentLine();
		
		String toparse = line;
		
		// 解析玩法
		// 实际存储时票内容不带玩法，这里兼容不带玩法的解析，可以单独设置玩法
		if (toparse.indexOf(TicketContentConstant.PLAY) >= 0) {
			logger.info("to parse string is: {}", toparse);
			String[] tmp = StringUtils.split(toparse, TicketContentConstant.PLAY);
			if (tmp.length != 2) {
				throw new InvalidTicketContentException("解析玩法失败：" + line);
			}
			String playstr = tmp[0];
			toparse = tmp[1];
			try {
				PlayType playType = PlayType.getItem(Integer.parseInt(playstr));
				if (playType == null) {
					logger.error("不支持的玩法类型");
					throw new InvalidTicketContentException("不支持的玩法类型：" + playstr);
				}
				contentLine.setPlayType(playType);
				logger.info("解析到玩法({}), id={}", playType.getName(), playType.getValue());
			} catch (NumberFormatException e) {
				logger.error("玩法转换出错" + playstr, e);
				throw new InvalidTicketContentException("玩法转换失败：" + playstr);
			}
		}
		
		contentLine.setGroups(unpackGroupArray(toparse));
		
		return contentLine;
	}
	
	public static TicketContentLine unpackLineWithoutPlayType(String line) throws InvalidTicketContentException {
		if (line == null) {
			return null;
		}
		
		TicketContentLine contentLine = new TicketContentLine();
		
		String toparse = line;
		
		contentLine.setGroups(unpackGroupArray(toparse));
		
		return contentLine;
	}
	
	public static TicketContentGroup[] unpackGroupArray(String groupArrayStr) throws InvalidTicketContentException {
		String toparse = groupArrayStr;
		
		// 解析数据区
		logger.info("to parse string is: {}", toparse);
		
		// 先解析出数据组
		String[] tmp = StringUtils.split(toparse, TicketContentConstant.GROUP);
		
		TicketContentGroup[] groupArray = new TicketContentGroup[tmp.length];
		for (int i = 0; i < tmp.length; i ++) {
			try {
				TicketContentGroup group = unpackGroup(tmp[i]);
				if (group == null) {
					logger.error("分组数据转换结果为空：{}", tmp[i]);
					throw new InvalidTicketContentException("分组数据转换结果为空：" + tmp[i]);
				}
				groupArray[i] = group;
				logger.info("解析分组成功：{}", tmp[i]);
			} catch (InvalidTicketContentException e) {
				logger.error("转换分组数据出错：{}", tmp[i]);
				logger.error(e.getMessage(), e);
				throw e;
			}
		}
		
		return groupArray;
	}
	
	public static TicketContentGroup unpackGroup(String groupStr) throws InvalidTicketContentException {
		logger.info("Group string is: {}", groupStr);
		if (groupStr == null) {
			return null;
		}
		
		String toparse = groupStr;
		
		TicketContentGroup group = new TicketContentGroup();
		
		// 解析元素组
		{
			logger.info("to parse string is: {}", toparse);
			
			// 先解析出胆拖分组
			String[] tmp = StringUtils.split(toparse, TicketContentConstant.DANTUO);
			
			if (tmp.length > 2) {
				logger.error("不正确的分组元素数据：{}", toparse);
				throw new InvalidTicketContentException("不正确的分组元素数据：" + toparse);
			}
			
			String danStr = null;
			String tuoStr = null;
			
			// 如果存在胆码
			if (tmp.length == 2) {
				danStr = tmp[0];
				tuoStr = tmp[1];
			} else {
				tuoStr = tmp[0];
			}
			
			// 解析胆码元素
			if (danStr != null) {
				try {
					TicketContentElement[] dan = unpackElementArray(danStr);
					if (dan == null) {
						logger.error("解析胆码元素结果为空：{}", danStr);
						throw new InvalidTicketContentException("解析胆码元素结果为空：" + danStr);
					}
					
					group.setDan(dan);
					logger.info("解析胆码元素成功：{}", danStr);
				} catch (InvalidTicketContentException e) {
					logger.error("转换胆码元素出错：{}", danStr);
					logger.error(e.getMessage(), e);
					throw e;
				}
			}
			
			// 解析拖码元素
			if (tuoStr != null) {
				try {
					TicketContentElement[] tuo = unpackElementArray(tuoStr);
					if (tuo == null) {
						logger.error("解析拖码元素结果为空：{}", tuoStr);
						throw new InvalidTicketContentException("解析拖码元素结果为空：" + tuoStr);
					}
					
					group.setTuo(tuo);
					logger.info("解析拖码元素成功：{}", tuoStr);
				} catch (InvalidTicketContentException e) {
					logger.error("转换拖码元素出错：{}", tuoStr);
					logger.error(e.getMessage(), e);
					throw e;
				}
			}
		}
		
		return group;
	}
	
	public static TicketContentElement[] unpackElementArray(String elementArrayStr) throws InvalidTicketContentException {
		logger.info("elementArrayStr string is: {}", elementArrayStr);
		if (elementArrayStr == null) {
			return null;
		}
		
		String toparse = elementArrayStr;
		logger.info("to parse string is: {}", toparse);
		
		// 分拆多个元素进行
		String[] tmp = StringUtils.split(toparse, TicketContentConstant.ELEMENT);
		TicketContentElement[] elementArray = new TicketContentElement[tmp.length];
		
		for (int i = 0; i < tmp.length; i ++) {
			try {
				TicketContentElement element = unpackElement(tmp[i]);
				if (element == null) {
					logger.error("解析单个元素结果为空：{}", tmp[i]);
					throw new InvalidTicketContentException("解析单个元素结果为空：" + tmp[i]);
				}
				
				elementArray[i] = element;
				logger.info("解析单个元素成功：{}", tmp[i]);
			} catch (InvalidTicketContentException e) {
				logger.error("转换单个元素出错：{}", tmp[i]);
				logger.error(e.getMessage(), e);
				throw e;
			}
		}
		
		return elementArray;
	}
	
	public static TicketContentElement unpackElement(String elementTotalStr) throws InvalidTicketContentException {
		logger.info("element total string is: {}", elementTotalStr);
		if (elementTotalStr == null) {
			return null;
		}
		
		String toparse = elementTotalStr;
		logger.info("to parse string is: {}", toparse);
		
		// 同时匹配不带属性和带属性的情况，提取出element和attribute
		Pattern pattern = Pattern.compile("^([^\\(\\)]+)+?(\\(([^\\(\\)]+)\\))?$");
		Matcher matcher = pattern.matcher(toparse);
		
		String elementStr = null;
		String attributeStr = null;
		if (matcher.find()) {
			if (!matcher.group(0).equals(toparse)) {
				// 如果没有完整匹配整个字符串，抛出异常
				logger.error("元素匹配不完整：{}", toparse);
				throw new InvalidTicketContentException("元素匹配不完整：" + toparse);
			}
			elementStr = matcher.group(1);
			attributeStr = matcher.group(3);
		}
		
		if (elementStr == null) {
			logger.error("解析元素失败：{}", toparse);
			throw new InvalidTicketContentException("解析元素失败：" + toparse);
		}
		
		logger.info("解析到元素主体：{}", elementStr);
		logger.info("解析到元素属性：{}", attributeStr);
		
		TicketContentElement element = new TicketContentElement();
		element.setElement(elementStr);
		
		// 如果存在元素属性，解析属性
		if (attributeStr != null) {
			toparse = attributeStr;
			logger.info("to parse string is: {}", toparse);
			String[] attributes = StringUtils.split(toparse, TicketContentConstant.ATTRIBUTE);
			element.setAttributes(attributes);
		}
		
		return element;
	}
}
