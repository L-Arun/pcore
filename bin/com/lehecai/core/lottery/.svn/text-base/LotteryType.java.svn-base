package com.lehecai.core.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

public class LotteryType extends IntegerBeanLabelItem {
	private static final Logger logger = LoggerFactory.getLogger(LotteryType.class.getName());
	private static final long serialVersionUID = 5959923813363953414L;
	
	private static List<LotteryType> _items = new ArrayList<LotteryType>();
	
	private static List<LotteryType> items;

	protected LotteryType(String name, int value) {
		super(LotteryType.class.getName(), name, value);
		_items.add(this);
	}
	
	public static LotteryType getItem(int value){
		try {
			return (LotteryType)LotteryType.getResult(LotteryType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	/**
	 * @return 所有彩种的列表
	 */
	public static List<LotteryType> getItems() {
		return items;
	}

	public static Logger getLogger(LotteryType lotteryType) {
		return LoggerFactory.getLogger("process_" + lotteryType.getValue());
	}
	
	public final static LotteryType ALL = new LotteryType("全部", -1);
	// 体彩
	public final static LotteryType DLT = new LotteryType("大乐透", 1);
	public final static LotteryType QXC = new LotteryType("七星彩", 2);
	public final static LotteryType PL3 = new LotteryType("排列3", 3);
	public final static LotteryType PL5 = new LotteryType("排列5", 4);
	public final static LotteryType TC22X5 = new LotteryType("22选5", 5);
	public final static LotteryType SFC = new LotteryType("胜负彩14场", 7);
	public final static LotteryType SFR9 = new LotteryType("任选9场", 8);
	public final static LotteryType JQC = new LotteryType("4场进球", 9);
	public final static LotteryType BQC = new LotteryType("6场半全场", 10);
	
	// 北单
	public final static LotteryType DC_SFP = new LotteryType("单场胜负平", 30);
	public final static LotteryType DC_SXDS = new LotteryType("单场上下盘单双", 31);
	public final static LotteryType DC_JQS = new LotteryType("单场总进球数", 32);
	public final static LotteryType DC_BF = new LotteryType("单场比分", 33);
	public final static LotteryType DC_BCSFP = new LotteryType("单场半场胜负平", 34);
	//北单奥运竞猜胜负过关
	public final static LotteryType DC_SFGG = new LotteryType("胜负过关", 40);
	
	// 竞彩篮球
	public final static LotteryType JCLQ_SF = new LotteryType("竞彩篮球胜负", 70);
	public final static LotteryType JCLQ_RFSF = new LotteryType("竞彩篮球让分胜负", 71);
	public final static LotteryType JCLQ_SFC = new LotteryType("竞彩篮球胜分差", 72);
	public final static LotteryType JCLQ_DXF = new LotteryType("竞彩篮球大小分", 73);
	// 竞彩足球
	public final static LotteryType JCZQ_SPF = new LotteryType("竞彩足球让球胜平负", 80);
	public final static LotteryType JCZQ_BF = new LotteryType("竞彩足球全场比分", 81);
	public final static LotteryType JCZQ_JQS = new LotteryType("竞彩足球进球数", 82);
	public final static LotteryType JCZQ_BQC = new LotteryType("竞彩足球半全场胜平负", 83);
	// 竞彩猜冠亚军
	public final static LotteryType JCZQ_GJ = new LotteryType("竞彩足球冠军", 90);
	public final static LotteryType JCZQ_GYJ = new LotteryType("竞彩足球冠亚军", 91);
	
	// 福彩
	public final static LotteryType SSQ = new LotteryType("双色球", 50);
	public final static LotteryType QLC = new LotteryType("七乐彩", 51);
	public final static LotteryType FC3D = new LotteryType("福彩3D", 52);
	public final static LotteryType DF6J1 = new LotteryType("东方6+1", 54);
	public final static LotteryType HD15X5 = new LotteryType("15选5", 55);
	
	// 高频彩
	public final static LotteryType SD11X5 = new LotteryType("十一运夺金", 20);
	public final static LotteryType JX11X5 = new LotteryType("11选5", 22);
	public final static LotteryType GD11X5 = new LotteryType("广东11选5", 23);
	public final static LotteryType GDKL10 = new LotteryType("广东快乐十分", 544);
	public final static LotteryType CQSSC = new LotteryType("时时彩", 200);
	public final static LotteryType SHSSL = new LotteryType("时时乐", 201);
	public final static LotteryType JXSSC = new LotteryType("江西时时彩", 202);
	public final static LotteryType BJKL8 = new LotteryType("北京快乐8", 543);
	public final static LotteryType SDQYH = new LotteryType("山东群英会", 517);
	public final static LotteryType GXKL10 = new LotteryType("广西快乐十分", 545);
	public final static LotteryType HNKL10 = new LotteryType("湖南快乐十分", 556);
	public final static LotteryType PK10 = new LotteryType("PK拾", 557);
	public final static LotteryType CQ11X5 = new LotteryType("重庆11选5", 558);
	
	//地方彩
	public final static LotteryType BJTC33X7 = new LotteryType("北京体彩33选7", 552);
	
	//全国各地彩种
	public final static LotteryType A_BJLB = new LotteryType("北京两步彩", 501);
	public final static LotteryType A_BJTC36 = new LotteryType("北京体彩36选7", 502);
	public final static LotteryType A_TJFC = new LotteryType("天津风采15选5", 503);
	public final static LotteryType A_TJTC6 = new LotteryType("天津体彩6+1", 504);
	public final static LotteryType A_AH25 = new LotteryType("安徽25选5", 505);
	public final static LotteryType A_AH15 = new LotteryType("安徽15选5", 506);
	public final static LotteryType A_FJFC15 = new LotteryType("福建风采15选5", 507);
	public final static LotteryType A_FJ22 = new LotteryType("福建22选5", 508);
	public final static LotteryType A_FJ36 = new LotteryType("福建36选7", 509);
	public final static LotteryType A_FJ31 = new LotteryType("福建31选7", 510);
	public final static LotteryType A_CTFC22 = new LotteryType("楚天风采22选5", 511);
	public final static LotteryType A_ZYFC22 = new LotteryType("中原风采22选5", 512);
	public final static LotteryType A_YZFCPL7 = new LotteryType("燕赵风采排列7", 513);	
	public final static LotteryType A_YZFC20 = new LotteryType("燕赵风采20选5", 514);	
	public final static LotteryType A_CYFCPL5 = new LotteryType("燕赵风采排列5", 515);
	
	public final static LotteryType A_LNFC35 = new LotteryType("辽宁风采35选7", 516);
	public final static LotteryType A_QLFC23 = new LotteryType("齐鲁风采23选5", 518);
	public final static LotteryType A_YGCTTL = new LotteryType("云贵川天天乐", 519);
	public final static LotteryType A_XJFC35 = new LotteryType("新疆风采35选7", 520);
	
	public final static LotteryType A_XJFCOS10 = new LotteryType("新疆风采偶数10选7", 521);
	public final static LotteryType A_XJFC18 = new LotteryType("新疆风采18选7", 522);
	public final static LotteryType A_XJFC25 = new LotteryType("新疆风采25选7", 523);
	public final static LotteryType A_SHTTLX4 = new LotteryType("上海天天彩选4", 524);
	public final static LotteryType A_CQFC20 = new LotteryType("重庆风采20选5", 525);
	
	public final static LotteryType A_NYFC26 = new LotteryType("南粤风采26选5", 526);
	public final static LotteryType A_HLJ36 = new LotteryType("黑龙江36选7", 527);
	public final static LotteryType A_HLJ22 = new LotteryType("黑龙江22选5", 528);
	public final static LotteryType A_HLJP62 = new LotteryType("黑龙江P62", 529);
	
	public final static LotteryType A_HLJ6 = new LotteryType("黑龙江6+1", 530);
	public final static LotteryType A_HNFC22 = new LotteryType("湖南风采22选5", 531);
	public final static LotteryType A_JS5 = new LotteryType("江苏体彩5+1", 532);
	public final static LotteryType A_JS7 = new LotteryType("江苏体彩7位数", 533);
	public final static LotteryType A_NMGFC22 = new LotteryType("内蒙古风采22选5", 534);
	
	public final static LotteryType A_SJFC21 = new LotteryType("三晋风采21选5", 535);
	public final static LotteryType A_NYFC36 = new LotteryType("南粤风采36选7", 536);
	public final static LotteryType A_ZJ31 = new LotteryType("浙江体彩31选7", 537);
	
	public final static LotteryType A_ZJ6 = new LotteryType("浙江体彩6+1", 538);
	public final static LotteryType A_ZJFC15 = new LotteryType("浙江福彩15选5", 539);
	public final static LotteryType A_ZJ20= new LotteryType("浙江体彩20选5", 540);
	public final static LotteryType A_ZJ29= new LotteryType("浙江体彩29选7", 541);
	
	public final static LotteryType A_31x7= new LotteryType("31选7", 542);
	
	public final static LotteryType T36x7 = new LotteryType("广东体彩36选7", 57);
	
	public final static LotteryType A_KLPK= new LotteryType("快乐扑克", 546);
	public final static LotteryType A_YTDJ= new LotteryType("泳坛夺金", 547);
	public final static LotteryType A_PKCSFL= new LotteryType("扑克彩·十分乐", 548);
	public final static LotteryType A_HN4= new LotteryType("海南4+1", 549);
	public final static LotteryType A_GXFCKLSC= new LotteryType("广西福彩快乐双彩", 550);
	public final static LotteryType A_SZFC= new LotteryType("深圳风采", 551);
	
	public final static LotteryType A_YZFCHYC2 = new LotteryType("燕赵风采好运彩2", 553);
	public final static LotteryType A_YZFCHYC3 = new LotteryType("燕赵风采好运彩3", 554);
	public final static LotteryType A_NYFCHC1 = new LotteryType("南粤风采好彩1", 555);
	
	static {
		synchronized (_items) {
			items = Collections.unmodifiableList(_items);
		}
	}
}

