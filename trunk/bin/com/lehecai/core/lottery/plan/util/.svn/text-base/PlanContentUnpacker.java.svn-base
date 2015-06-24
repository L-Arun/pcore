/**
 * 
 */
package com.lehecai.core.lottery.plan.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.InvalidPlanContentException;
import com.lehecai.core.lottery.PlayType;
import com.lehecai.core.lottery.plan.PlanContent;
import com.lehecai.core.lottery.plan.PlanContentConstant;
import com.lehecai.core.lottery.plan.PlanContentElement;
import com.lehecai.core.lottery.plan.PlanContentGroup;
import com.lehecai.core.lottery.plan.PlanContentLine;

/**
 * 方案内容解包器
 * @author sunshow
 *
 */
public class PlanContentUnpacker {
	
	protected static final Logger logger = LoggerFactory.getLogger(PlanContentUnpacker.class.getName());

	public static PlanContent unpack(String content) throws InvalidPlanContentException {
		if (content == null) {
			return null;
		}
		
		PlanContent planContent = new PlanContent();
		
		String toparse = content;
		
		// 解析倍数
		{
			logger.info("to parse string is: {}", toparse);
			String[] tmp = StringUtils.split(toparse, PlanContentConstant.MULTIPLE);
			if (tmp.length != 2) {
				logger.error("解析倍数失败, toparse={}", toparse);
				throw new InvalidPlanContentException("解析倍数失败");
			}
			
			String multipleStr = tmp[1];
			toparse = tmp[0];
			
			try {
				int multiple = Integer.parseInt(multipleStr);
				if (multiple <= 0) {
					logger.error("无效倍数：{}", multiple);
					throw new InvalidPlanContentException("无效倍数：" + multiple);
				}
				planContent.setMultiple(multiple);
				logger.info("解析到倍数：{}", multiple);
			} catch (NumberFormatException e) {
				logger.error("不正确的倍数格式：{}", multipleStr);
				throw new InvalidPlanContentException("不正确的倍数格式：" + multipleStr);
			}
		}
		
		
		// 解析数据区
		{
			logger.info("to parse string is: {}", toparse);
			// 首先分组多注
			String[] lines = StringUtils.split(toparse, PlanContentConstant.LINE);
			
			List<PlanContentLine> result = new ArrayList<PlanContentLine>();
			
			for (String line : lines) {
				try {
					PlanContentLine contentLine = unpackLine(line);
					if (contentLine == null) {
						throw new InvalidPlanContentException("单行内容解析结果为空：" + line);
					}
					result.add(contentLine);
					logger.info("解析单行方案内容成功：{}", line);
				} catch (InvalidPlanContentException e) {
					logger.error(e.getMessage(), e);
					logger.error("方案内容为：{}", content);
					throw e;
				}
				
			}
			
			planContent.setLines(result);
		}
		
		return planContent;
	}
	
	public static PlanContentLine unpackLine(String line) throws InvalidPlanContentException {
		if (line == null) {
			return null;
		}
		
		PlanContentLine contentLine = new PlanContentLine();
		
		String toparse = line;
		// 解析玩法
		{
			logger.info("to parse string is: {}", toparse);
			String[] tmp = StringUtils.split(toparse, PlanContentConstant.PLAY);
			if (tmp.length != 2) {
				throw new InvalidPlanContentException("解析玩法失败：" + line);
			}
			String playstr = tmp[0];
			toparse = tmp[1];
			
			// 解析子玩法
			tmp = StringUtils.split(playstr, PlanContentConstant.PLAYSUB);
			if (tmp.length > 2) {
				throw new InvalidPlanContentException("解析子玩法失败：" + line);
			}

			String playParentStr = tmp[0];
			try {
				PlayType playTypeParent = PlayType.getItem(Integer.parseInt(playParentStr));
				if (playTypeParent == null) {
					logger.error("不支持的玩法类型");
					throw new InvalidPlanContentException("不支持的玩法类型：" + playParentStr);
				}
				contentLine.setPlayType(playTypeParent);
				logger.info("解析到主玩法({}), id={}", playTypeParent.getName(), playTypeParent.getValue());
			} catch (NumberFormatException e) {
				logger.error("玩法转换出错" + playParentStr, e);
				throw new InvalidPlanContentException("玩法转换失败：" + playParentStr);
			}
			if (tmp.length == 2) {
				// 存在子玩法
				String playSubStr = tmp[1];
				// 分离各个子玩法
				tmp = StringUtils.split(playSubStr, PlanContentConstant.PLAYELEMENT);
				PlayType[] playTypeSubArray = new PlayType[tmp.length];
				for (int i = 0; i < tmp.length; i ++) {
					String playTypeSubStr = tmp[i];
					try {
						PlayType playTypeSub = PlayType.getItem(Integer.parseInt(playTypeSubStr));
						if (playTypeSub == null) {
							logger.error("不支持的玩法类型：", playTypeSubStr);
							throw new InvalidPlanContentException("不支持的玩法类型：" + playTypeSubStr);
						}
						playTypeSubArray[i] = playTypeSub;
						logger.info("解析到子玩法({}), id={}", playTypeSub.getName(), playTypeSub.getValue());
					} catch (NumberFormatException e) {
						logger.error("玩法转换出错" + playSubStr, e);
						throw new InvalidPlanContentException("玩法转换失败：" + playSubStr);
					}
				}
				contentLine.setPlayTypeSubs(playTypeSubArray);
			}
		}
		
		// 解析数据区
		{
			logger.info("to parse string is: {}", toparse);
			
			// 先解析出数据组
			String[] tmp = StringUtils.split(toparse, PlanContentConstant.GROUP);
			
			PlanContentGroup[] groupArray = new PlanContentGroup[tmp.length];
			for (int i = 0; i < tmp.length; i ++) {
				try {
					PlanContentGroup group = unpackGroup(tmp[i]);
					if (group == null) {
						logger.error("分组数据转换结果为空：{}", tmp[i]);
						throw new InvalidPlanContentException("分组数据转换结果为空：" + tmp[i]);
					}
					groupArray[i] = group;
					logger.info("解析分组成功：{}", tmp[i]);
				} catch (InvalidPlanContentException e) {
					logger.error("转换分组数据出错：{}", tmp[i]);
					logger.error(e.getMessage(), e);
					throw e;
				}
			}
			
			contentLine.setGroups(groupArray);
		}
		
		return contentLine;
	}
	
	public static PlanContentGroup unpackGroup(String groupStr) throws InvalidPlanContentException {
		logger.info("Group string is: {}", groupStr);
		if (groupStr == null) {
			return null;
		}
		
		String toparse = groupStr;
		
		PlanContentGroup group = new PlanContentGroup();
		
		// 解析元素组
		{
			logger.info("to parse string is: {}", toparse);
			
			// 先解析出胆拖分组
			String[] tmp = StringUtils.split(toparse, PlanContentConstant.DANTUO);
			
			if (tmp.length > 2) {
				logger.error("不正确的分组元素数据：{}", toparse);
				throw new InvalidPlanContentException("不正确的分组元素数据：" + toparse);
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
					PlanContentElement[] dan = unpackElementArray(danStr);
					if (dan == null) {
						logger.error("解析胆码元素结果为空：{}", danStr);
						throw new InvalidPlanContentException("解析胆码元素结果为空：" + danStr);
					}
					
					group.setDan(dan);
					logger.info("解析胆码元素成功：{}", danStr);
				} catch (InvalidPlanContentException e) {
					logger.error("转换胆码元素出错：{}", danStr);
					logger.error(e.getMessage(), e);
					throw e;
				}
			}
			
			// 解析拖码元素
			if (tuoStr != null) {
				try {
					PlanContentElement[] tuo = unpackElementArray(tuoStr);
					if (tuo == null) {
						logger.error("解析拖码元素结果为空：{}", tuoStr);
						throw new InvalidPlanContentException("解析拖码元素结果为空：" + tuoStr);
					}
					
					group.setTuo(tuo);
					logger.info("解析拖码元素成功：{}", tuoStr);
				} catch (InvalidPlanContentException e) {
					logger.error("转换拖码元素出错：{}", tuoStr);
					logger.error(e.getMessage(), e);
					throw e;
				}
			}
		}
		
		return group;
	}
	
	public static PlanContentElement[] unpackElementArray(String elementArrayStr) throws InvalidPlanContentException {
		logger.info("elementArrayStr string is: {}", elementArrayStr);
		if (elementArrayStr == null) {
			return null;
		}
		
		String toparse = elementArrayStr;
		logger.info("to parse string is: {}", toparse);
		
		// 分拆多个元素进行
		String[] tmp = StringUtils.split(toparse, PlanContentConstant.ELEMENT);
		PlanContentElement[] elementArray = new PlanContentElement[tmp.length];
		
		for (int i = 0; i < tmp.length; i ++) {
			try {
				PlanContentElement element = unpackElement(tmp[i]);
				if (element == null) {
					logger.error("解析单个元素结果为空：{}", tmp[i]);
					throw new InvalidPlanContentException("解析单个元素结果为空：" + tmp[i]);
				}
				
				elementArray[i] = element;
				logger.info("解析单个元素成功：{}", tmp[i]);
			} catch (InvalidPlanContentException e) {
				logger.error("转换单个元素出错：{}", tmp[i]);
				logger.error(e.getMessage(), e);
				throw e;
			}
		}
		
		return elementArray;
	}
	
	public static PlanContentElement unpackElement(String elementTotalStr) throws InvalidPlanContentException {
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
				throw new InvalidPlanContentException("元素匹配不完整：" + toparse);
			}
			elementStr = matcher.group(1);
			attributeStr = matcher.group(3);
		}
		
		if (elementStr == null) {
			logger.error("解析元素失败：{}", toparse);
			throw new InvalidPlanContentException("解析元素失败：" + toparse);
		}
		
		logger.info("解析到元素主体：{}", elementStr);
		logger.info("解析到元素属性：{}", attributeStr);
		
		PlanContentElement element = new PlanContentElement();
		element.setElement(elementStr);
		
		// 如果存在元素属性，解析属性
		if (attributeStr != null) {
			toparse = attributeStr;
			logger.info("to parse string is: {}", toparse);
			String[] attributes = StringUtils.split(toparse, PlanContentConstant.ATTRIBUTE);
			element.setAttributes(attributes);
		}
		
		return element;
	}
}
