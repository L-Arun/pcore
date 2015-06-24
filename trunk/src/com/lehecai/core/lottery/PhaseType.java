package com.lehecai.core.lottery;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;
import com.lehecai.core.lottery.cache.DcLotteryMap;
import com.lehecai.core.lottery.cache.JclqLottery;
import com.lehecai.core.lottery.cache.JczqLottery;

public class PhaseType extends IntegerBeanLabelItem {
	
	private static final Logger logger = LoggerFactory.getLogger(PhaseType.class.getName());
	
	private static final long serialVersionUID = 5959923813363953414L;
	
	private static List<PhaseType> items = new ArrayList<PhaseType>();

	protected PhaseType(String name, int value) {
		super(PhaseType.class.getName(), name, value);
	}
	
	public static PhaseType getItem(int value){
		try {
			return (PhaseType)PhaseType.getResult(PhaseType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static PhaseType getItem(LotteryType lotteryType){
		if (DcLotteryMap.get().containsKey(lotteryType.getValue())) {
			return getItem(LotteryType.DC_SFP.getValue());
		}
		if (JclqLottery.contains(lotteryType)) {
			return getItem(LotteryType.JCLQ_SF.getValue());
		}
		if (JczqLottery.contains(lotteryType)) {
			return getItem(LotteryType.JCZQ_SPF.getValue());
		}
		return getItem(lotteryType.getValue());
	}
	
	static {
		for (LotteryType lotteryType : LotteryType.getItems()) {
			if (DcLotteryMap.get().containsKey(lotteryType.getValue())) {
				// 北京单场共用彩期，使用单场胜平负的编号
				if (lotteryType.getValue() == LotteryType.DC_SFP.getValue()) {
					PhaseType phaseType = new PhaseType("北京单场", lotteryType.getValue());
					items.add(phaseType);
				}
				continue;
			}
			if (JclqLottery.contains(lotteryType)) {
				// 竞彩篮球共用彩期，使用竞彩篮球胜负的编号
				if (lotteryType.getValue() == LotteryType.JCLQ_SF.getValue()) {
					PhaseType phaseType = new PhaseType("竞彩篮球", lotteryType.getValue());
					items.add(phaseType);
				}
				continue;
			}
			if (JczqLottery.contains(lotteryType)) {
				// 竞彩足球共用彩期，使用竞彩足球胜平负的编号
				if (lotteryType.getValue() == LotteryType.JCZQ_SPF.getValue()) {
					PhaseType phaseType = new PhaseType("竞彩足球", lotteryType.getValue());
					items.add(phaseType);
				}
				continue;
			}
			PhaseType phaseType = new PhaseType(lotteryType.getName(), lotteryType.getValue());
			items.add(phaseType);
		}
	}
	
	/**
	 * @return 所有彩种的列表
	 */
	public static List<PhaseType> getItems() {
		return items;
	}
}
