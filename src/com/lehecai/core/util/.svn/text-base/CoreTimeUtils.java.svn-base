package com.lehecai.core.util;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.bean.PairValue;
import com.lehecai.core.bean.common.Time;
import com.lehecai.core.bean.common.TimeRegion;

public class CoreTimeUtils {
	private static final Logger logger = LoggerFactory.getLogger(CoreTimeUtils.class.getName());
	
	/**
	 * 默认判断：大于等于左边界，小于右边界
	 * @param date
	 * @param timeRegion
	 * @return
	 */
	public static boolean isDuringPeriod(Date date, TimeRegion timeRegion) {
		if (timeRegion == null) {
			logger.error("时间范围为空，不做判断");
			return false;
		}
		List<PairValue<Time, Time>> regionList = timeRegion.getRegionList();
		if (regionList == null || regionList.isEmpty()) {
			logger.error("时间段为空，不做判断");
			return false;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		Calendar regionLeftCalendar = Calendar.getInstance();
		regionLeftCalendar.setTime(date);

		Calendar regionRightCalendar = Calendar.getInstance();
		regionRightCalendar.setTime(date);

		for (PairValue<Time, Time> pairValue : regionList) {
			Time timeLeft = pairValue.getLeft();
			Time timeRight = pairValue.getRight();
			if (timeLeft == null || timeRight == null) {
				logger.error("不是有效的范围，跳过");
				continue;
			}
			// 设置左右边界
			regionLeftCalendar.set(Calendar.HOUR_OF_DAY, timeLeft.getHour());
			regionLeftCalendar.set(Calendar.MINUTE, timeLeft.getMinute());
			regionLeftCalendar.set(Calendar.SECOND, timeLeft.getSecond());
			regionLeftCalendar.set(Calendar.MILLISECOND, timeLeft.getMillisecond());
			
			regionRightCalendar.set(Calendar.HOUR_OF_DAY, timeRight.getHour());
			regionRightCalendar.set(Calendar.MINUTE, timeRight.getMinute());
			regionRightCalendar.set(Calendar.SECOND, timeRight.getSecond());
			regionRightCalendar.set(Calendar.MILLISECOND, timeRight.getMillisecond());

			// 大于等于左边界，小于右边界
			if (calendar.getTimeInMillis() >= regionLeftCalendar.getTimeInMillis() && calendar.getTimeInMillis() < regionRightCalendar.getTimeInMillis()) {
				return true;
			}
		}
		return false;
	}

	public static boolean isCurrentDuringPeriod(TimeRegion timeRegion) {
		return isDuringPeriod(new Date(), timeRegion);
	}
}
