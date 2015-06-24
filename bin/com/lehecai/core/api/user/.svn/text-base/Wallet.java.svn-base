/**
 * 
 */
package com.lehecai.core.api.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.WalletType;

/**
 * @author Sunshow
 *
 */
public class Wallet extends AbstractApiResultBean {
	
	public static final String SET_AMOUNT = "amount";
	
	public static final String QUERY_UID = "uid";
	public static final String QUERY_FROMWALLET = "from_wallet";
	public static final String QUERY_TOWALLET = "to_wallet";
	
	private long uid;
	private WalletType type;
	
	private double recharged;		//已充值
	private double frozen;			//已冻结
	private double balance;			//可用余额
	private double consumed;		//已消费
	private double withdraw;		//已提款
	private double winning;			//已中奖
	private double exchangedIn;		//已转入
	private double exchangedOut;	//已转出
	
	public static Wallet convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		Wallet wallet = new Wallet();

		wallet.uid = getLong(object, "uid");
		int walletType = getInt(object, "type");
		if (walletType > 0) {
			wallet.setType(WalletType.getItem(walletType));
		}
		wallet.recharged = getDouble(object, "recharged");
		wallet.frozen = getDouble(object, "frozen");
		wallet.balance = getDouble(object, "balance");
		wallet.consumed = getDouble(object, "consumed");
		wallet.withdraw = getDouble(object, "withdraw");
		wallet.winning = getDouble(object, "winning");
		wallet.exchangedIn = getDouble(object, "exchanged_in");
		wallet.exchangedOut = getDouble(object, "exchanged_out");
		
		return wallet;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Wallet> convertFromJSONObjectMap(JSONObject objectMap) {
		if (objectMap == null) {
			return null;
		}
		List<Wallet> list = new ArrayList<Wallet>();
		for (Iterator iterator = objectMap.keys(); iterator.hasNext();) {
			JSONObject object = (JSONObject) objectMap.get(iterator.next());
			list.add(convertFromJSONObject(object));
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Wallet> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<Wallet> list = new ArrayList<Wallet>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public WalletType getType() {
		return type;
	}

	public void setType(WalletType type) {
		this.type = type;
	}

	public double getRecharged() {
		return recharged;
	}

	public void setRecharged(double recharged) {
		this.recharged = recharged;
	}

	public double getFrozen() {
		return frozen;
	}

	public void setFrozen(double frozen) {
		this.frozen = frozen;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getConsumed() {
		return consumed;
	}

	public void setConsumed(double consumed) {
		this.consumed = consumed;
	}

	public double getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}

	public double getWinning() {
		return winning;
	}

	public void setWinning(double winning) {
		this.winning = winning;
	}

	public double getExchangedIn() {
		return exchangedIn;
	}

	public void setExchangedIn(double exchangedIn) {
		this.exchangedIn = exchangedIn;
	}

	public double getExchangedOut() {
		return exchangedOut;
	}

	public void setExchangedOut(double exchangedOut) {
		this.exchangedOut = exchangedOut;
	}
}
