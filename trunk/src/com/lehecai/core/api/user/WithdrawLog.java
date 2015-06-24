/**
 * 
 */
package com.lehecai.core.api.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.YesNoStatus;
import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.BankType;
import com.lehecai.core.lottery.WalletType;
import com.lehecai.core.lottery.WithdrawStatus;
import com.lehecai.core.lottery.WithdrawType;
import com.lehecai.core.util.CoreDateUtils;

/**
 * @author Sunshow
 * 提款日志
 */
public class WithdrawLog extends AbstractApiResultBean {
	public static final String QUERY_ID = "withdraw_id";
	public static final String QUERY_USERNAME = "username";
	public static final String QUERY_UID = "uid";
	public static final String QUERY_AMOUNT = "amount";
	public static final String QUERY_TIMELINE = "timeline";
	public static final String QUERY_STATUS = "status";
	public static final String QUERY_PHONE = "phone";
	public static final String QUERY_ID_DATA = "id_data";
	public static final String QUERY_BANK_ID = "bank_id";
	public static final String QUERY_BANK_TYPE = "bank_type";
	public static final String QUERY_BANK_REALNAME = "bank_realname";
	public static final String QUERY_BANK_BRANCH = "bank_branch";
	public static final String QUERY_BANK_CARDNO = "bank_cardno";
	public static final String QUERY_WITHDRAW_TYPE = "type";
	public static final String QUERY_IS_EXPORT = "is_export";
	public static final String QUERY_BATCH_NO = "batch_no";
	public static final String QUERY_WALLET_TYPE = "wallet_type";
	
	public static final String ORDER_LOG_ID = "withdraw_id";
	public static final String ORDER_AMOUNT = "amount";
	public static final String ORDER_TIMELINE = "timeline";
	
	public static final String SET_WITHDRAW_REMARK = "remark";
	public static final String SET_DELAY_DAY = "day";
	public static final String SET_IS_EXPORT = "is_export";
	public static final String SET_BATCH_NO = "batch_no";
	public static final String SET_PROVINCE = "province";
	public static final String SET_CITY = "city";
	
	private String id;			//流水ID
	private long uid;			//用户ID
	private String username;	//用户名
	
	private Date timeline;		//创建时间
	private double amount;			//提款金额
	
	private WithdrawStatus withdrawStatus;	//提款状态
	
	private String phone;
	private String idData;			//证件号码
	
	private BankType bankType;		//银行
	private String bankId;			//银行id
	private String bankRealname;	//提款用户真实姓名
	private String bankBranch;		//银行分行
	private String bankCardno;		//银行卡号
	
	private WithdrawType withdrawType;	//提款类型
	
	private YesNoStatus exportStatus;
	
	private String frozenId;		//冻结ID
	
	private String extra;			//推迟时间
	
	private String remark;			//备注信息
	
	private String batchNo;			//导出批次号
	
	private int provinceId;			//省ID
	private String provinceName;	//省NAME
	
	private int cityId;				//市ID
	private String cityName;		//市NAME
	private WalletType walletType;	//钱包类型

	public static WithdrawLog convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		WithdrawLog log = new WithdrawLog();
		int walletTypeValue = getInt(object, "wallet_type");
		log.walletType = WalletType.getItem(walletTypeValue);
		
		log.id = getString(object, "withdraw_id");
		log.uid = getLong(object, "uid");
		log.username = getString(object, "username");
		
		log.provinceName = getString(object, "province_name");
		log.cityName = getString(object, "city_name");
		
		log.provinceId = getInt(object, "province");
		log.cityId = getInt(object, "city");
		
		log.timeline = CoreDateUtils.parseDate(getString(object, "timeline"), CoreDateUtils.DATETIME);
		log.amount = getDouble(object, "amount");
		
		int iWithdrawStatus = getInt(object, "status");
		if (iWithdrawStatus >= 0) {
			log.withdrawStatus = WithdrawStatus.getItem(iWithdrawStatus);
		}
		
		log.phone = getString(object, "phone");
		log.idData = getString(object, "id_data");
		
		int iBankType = getInt(object, "bank_type");
		if (iBankType >= 0) {
			log.bankType = BankType.getItem(iBankType);
		}
		
		log.bankRealname = getString(object, "bank_id");
		log.bankRealname = getString(object, "bank_realname");
		log.bankBranch = getString(object, "bank_branch");
		log.bankCardno = getString(object, "bank_cardno");
		
		int iWithdrawType = getInt(object, "type");
		if (iWithdrawType >= 0) {
			log.withdrawType = WithdrawType.getItem(iWithdrawType);
		}
		
		log.exportStatus = YesNoStatus.getItem(getInt(object, "is_export"));
		
		log.frozenId = getString(object, "frozen_id");
		log.extra = getString(object, "ext");
		log.remark = getString(object, "remark");
		log.batchNo = getString(object, "batch_no");
		
		return log;
	}
	
	@SuppressWarnings("unchecked")
	public static List<WithdrawLog> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<WithdrawLog> list = new ArrayList<WithdrawLog>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getTimeline() {
		return timeline;
	}

	public void setTimeline(Date timeline) {
		this.timeline = timeline;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public WithdrawStatus getWithdrawStatus() {
		return withdrawStatus;
	}

	public void setWithdrawStatus(WithdrawStatus withdrawStatus) {
		this.withdrawStatus = withdrawStatus;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdData() {
		return idData;
	}

	public void setIdData(String idData) {
		this.idData = idData;
	}

	public BankType getBankType() {
		return bankType;
	}

	public void setBankType(BankType bankType) {
		this.bankType = bankType;
	}

	public String getBankRealname() {
		return bankRealname;
	}

	public void setBankRealname(String bankRealname) {
		this.bankRealname = bankRealname;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getBankCardno() {
		return bankCardno;
	}

	public void setBankCardno(String bankCardno) {
		this.bankCardno = bankCardno;
	}

	public WithdrawType getWithdrawType() {
		return withdrawType;
	}

	public void setWithdrawType(WithdrawType withdrawType) {
		this.withdrawType = withdrawType;
	}

	public YesNoStatus getExportStatus() {
		return exportStatus;
	}

	public void setExportStatus(YesNoStatus exportStatus) {
		this.exportStatus = exportStatus;
	}

	public String getFrozenId() {
		return frozenId;
	}

	public void setFrozenId(String frozenId) {
		this.frozenId = frozenId;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public WalletType getWalletType() {
		return walletType;
	}

	public void setWalletType(WalletType walletType) {
		this.walletType = walletType;
	}

}
