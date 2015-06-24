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
 * 银行列表
 */
public class BankType extends IntegerBeanLabelItem {


	private static final long serialVersionUID = -530998782071935781L;

	private static final Logger logger = LoggerFactory.getLogger(BankType.class.getName());
	
	private static List<BankType> items = new ArrayList<BankType>();
	
	protected BankType(String name, int value) {
		super(BankType.class.getName(), name, value);
		items.add(this);
	}
	
	public static BankType getItem(int value){
		try {
			return (BankType)BankType.getResult(BankType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<BankType> getItems() {
		return items;
	}
	
	public static final BankType ALL = new BankType("全部", -1);
	public static final BankType DEFAULT = new BankType("默认", 0);
	public static final BankType BC = new BankType("中国银行", 1);
	public static final BankType ICBC = new BankType("中国工商银行", 2);
	public static final BankType CMBC = new BankType("招商银行", 3);
	public static final BankType CBC = new BankType("中国建设银行", 4);
	public static final BankType BOCOM = new BankType("交通银行", 5);
	public static final BankType ABC = new BankType("中国农业银行", 6);
	public static final BankType SPD_BANK = new BankType("上海浦东发展银行", 7);
	public static final BankType CIB = new BankType("兴业银行", 8);
	//public static final BankType GDB = new BankType("广发银行股份有限公司", 9);
	public static final BankType GDB = new BankType("广东发展银行", 9);
	public static final BankType SDB = new BankType("深圳发展银行", 10);
	public static final BankType CCB = new BankType("中信银行", 11);
	public static final BankType CEB = new BankType("光大银行", 12);
	public static final BankType MBC = new BankType("民生银行", 13);
	public static final BankType HCCB = new BankType("杭州银行", 14);
	public static final BankType NBCB = new BankType("宁波银行", 15);
	public static final BankType FDBC = new BankType("富滇银行", 16);
	public static final BankType PABC = new BankType("平安银行", 17);
	public static final BankType SHBC = new BankType("上海银行", 18);
	public static final BankType BRCB = new BankType("北京农村商业银行", 19);
	public static final BankType ICBC_B2B = new BankType("中国工商银行(B2B)", 20);
	public static final BankType CBC_B2B = new BankType("中国建设银行(B2B)", 21);
	public static final BankType ABC_B2B = new BankType("中国农业银行(B2B)", 22);
	public static final BankType SPD_BANK_B2B = new BankType("上海浦东发展银行(B2B)", 23);
	public static final BankType PSBC = new BankType("中国邮政储蓄银行", 24);
	public static final BankType NCXYS = new BankType("农村信用社", 25);
	public static final BankType CZYH = new BankType("村镇银行", 26);
	public static final BankType JCC = new BankType("晋城市商业银行", 27);
	public static final BankType HKBEA = new BankType("东亚银行", 28);
	public static final BankType HSBC = new BankType("汇丰银行", 29);
	public static final BankType ADBC = new BankType("中国农业发展银行", 30);
	public static final BankType RCU = new BankType("农村合作银行", 31);
	public static final BankType NCSYYH = new BankType("农村商业银行", 32);
	public static final BankType HXB = new BankType("华夏银行", 33);
	public static final BankType HS = new BankType("徽商银行股份有限公司", 34);
	public static final BankType CHARTERED = new BankType("渣打银行", 35);
	public static final BankType CBHB = new BankType("渤海银行", 36);
	public static final BankType EG = new BankType("恒丰银行", 37);
	public static final BankType NCB = new BankType("南洋商业银行", 38);
	public static final BankType CZ = new BankType("浙商银行", 39);
	
	public static final BankType HYYH = new BankType("华一银行", 40);
	public static final BankType GJKFYH = new BankType("国家开发银行", 41);
	public static final BankType CSXYS = new BankType("城市信用社", 42);
	public static final BankType CSSYYH = new BankType("城市商业银行", 43);
	public static final BankType HSYH = new BankType("恒生银行", 44);
	public static final BankType HQYH = new BankType("花旗银行", 45);
	public static final BankType GSYH_WAP = new BankType("工商银行WAP", 46);
	public static final BankType ZSYH_WAP = new BankType("招商银行WAP", 47);
	public static final BankType JSYH_WAP = new BankType("建设银行WAP", 48);
	
	public static final BankType NJYH = new BankType("南京银行", 49);
	public static final BankType BJYH = new BankType("北京银行", 50);
	public static final BankType SXJSYH = new BankType("晋商银行", 51);
	public static final BankType WZYH = new BankType("温州银行", 52);
	public static final BankType ZJCZSYYH = new BankType("浙江稠州商业银行", 53);
	public static final BankType YDXYHZLS = new BankType("尧都信用合作联社", 54);
	public static final BankType SDNXS = new BankType("顺德农信社", 55);
	public static final BankType GZYH = new BankType("广州银行", 56);
	public static final BankType ZHNCXYHZLS = new BankType("珠海市农村信用合作联社", 57);
	public static final BankType HKYH = new BankType("汉口银行", 58);
	public static final BankType SHNCSYYH = new BankType("上海市农村商业银行", 59);
	public static final BankType GZNCXYHZS = new BankType("广州市农村信用合作社", 60);
}
