/**
 * 
 */
package com.lehecai.core.test.api.user;

import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONObject;

import com.lehecai.core.api.user.Wallet;

/**
 * @author Sunshow
 *
 */
public class WalletTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String jsonStr = "{\"1\":{\"uid\":1,\"type\":1,\"recharged\":0,\"frozen\":0,\"balance\":0,\"consumed\":0,\"withdraw\":0,\"winning\":0,\"exchanged_in\":0,\"exchanged_out\":0},\"101\":{\"uid\":1,\"type\":101,\"recharged\":0,\"frozen\":0,\"balance\":0,\"consumed\":0,\"withdraw\":0,\"winning\":0,\"exchanged_in\":0,\"exchanged_out\":0},\"102\":{\"uid\":1,\"type\":102,\"recharged\":0,\"frozen\":0,\"balance\":0,\"consumed\":0,\"withdraw\":0,\"winning\":0,\"exchanged_in\":0,\"exchanged_out\":0}}";
		
		JSONObject objectMap = JSONObject.fromObject(jsonStr);
		
		List<Wallet> list = Wallet.convertFromJSONObjectMap(objectMap);
		for (Iterator<Wallet> iterator = list.iterator(); iterator.hasNext();) {
			Wallet wallet = (Wallet) iterator.next();
			System.out.println(wallet.getType().getName());
		}
	}

}
