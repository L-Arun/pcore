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
 * 充值类型
 */
public class RechargeType extends IntegerBeanLabelItem {


	private static final long serialVersionUID = -530998782071935781L;

	private static final Logger logger = LoggerFactory.getLogger(RechargeType.class.getName());
	
	private static List<RechargeType> items = new ArrayList<RechargeType>();
	
	protected RechargeType(String name, int value) {
		super(RechargeType.class.getName(), name, value);
		items.add(this);
	}
	
	public static RechargeType getItem(int value){
		try {
			return (RechargeType)RechargeType.getResult(RechargeType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<RechargeType> getItems() {
		return items;
	}
	
	public static final RechargeType ALL = new RechargeType("全部", -1);
	public static final RechargeType DEFAULT = new RechargeType("默认", 0);

	public static final RechargeType ALIPAY_BANK = new RechargeType("支付宝网银支付", 1);
	public static final RechargeType ALIPAY_DIRECT = new RechargeType("支付宝", 2);
	
	public static final RechargeType YEEPAY_MOBILE = new RechargeType("神州行卡（易宝）", 3);
	public static final RechargeType YEEPAY_UNICOM = new RechargeType("联通卡（易宝）", 4);
	public static final RechargeType YEEPAY_TELECOM = new RechargeType("电信卡（易宝）", 5);
	
	public static final RechargeType REMITTANCE = new RechargeType("电子汇款", 6);
	public static final RechargeType YEEPAY_BANK = new RechargeType("易宝网银", 7);
	public static final RechargeType MANUALLY_AWARD = new RechargeType("补充派奖", 8);
	public static final RechargeType BAIDUPAY_DIRECT = new RechargeType("百付宝", 9);
	public static final RechargeType GIFT = new RechargeType("彩金赠送", 10);
	public static final RechargeType YILIAN_IVR = new RechargeType("ivr语音充值", 11);
	
	public static final RechargeType ALIPAY_WAP = new RechargeType("支付宝WAP充值", 12);
	public static final RechargeType ALIPAY_ALIXPAY = new RechargeType("支付宝安全充值", 13);
	
	public static final RechargeType SHENGPAY_DIRECT = new RechargeType("盛大盛付通直连", 14);
	public static final RechargeType SHENGPAY_INDIRECT = new RechargeType("盛大盛付通非直连", 15);
	
	public static final RechargeType LEHECAI = new RechargeType("内部账户充值", 16);
	
	public static final RechargeType COMMISSION = new RechargeType("佣金派发", 17);
	public static final RechargeType COMPENSATE = new RechargeType("赔偿", 18);
	public static final RechargeType OTHERS = new RechargeType("其他", 19);
	
	public static final RechargeType GIFTCARD = new RechargeType("彩金卡兑换", 20);
	
	public static final RechargeType CHINAPAY = new RechargeType("银联在线", 21);
}
