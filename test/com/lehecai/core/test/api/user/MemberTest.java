/**
 * 
 */
package com.lehecai.core.test.api.user;

import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.api.user.Member;
import com.lehecai.core.api.user.Wallet;

/**
 * @author Sunshow
 *
 */
public class MemberTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberTest.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String jsonStr = "[{'uid':1,'username':'sskaje','auth_type':10,'auth_data':'123','status':0,'phone':'','email':'','realname':'','id_type':0,'id_data':'','source':{'id':1,'name':'\u6ca1\u6709\u60a8\u8981\u67e5\u7684\u4fe1\u606f','status':0},'reg_time':'2010-07-09 00:00:00','reg_ip':'','groupid':0,'recharge_count':3,'last_login_time':'0000-00-00 00:00:00','latest_login_time':'0000-00-00 00:00:00','last_login_ip':'','latest_login_ip':'','wallet':{'1':{'uid':'1','type':'1','recharged':'100.00','frozen':'0.00','balance':'100.00','consumed':'0.00','withdraw':'0.00','exchanged_in':'0.00','exchanged_out':'0.00','winning':'0.00','checksum':'1432642996','status':'0'},'101':{'uid':1,'type':101,'recharged':0,'frozen':0,'balance':0,'consumed':0,'withdraw':0,'winning':0,'exchanged_in':0,'exchanged_out':0},'102':{'uid':1,'type':102,'recharged':0,'frozen':0,'balance':0,'consumed':0,'withdraw':0,'winning':0,'exchanged_in':0,'exchanged_out':0}}}]";
		
		JSONArray array = JSONArray.fromObject(jsonStr);
		
		List<Member> list = Member.convertFromJSONArray(array);
		
		for (Iterator<Member> iterator = list.iterator(); iterator.hasNext();) {
			Member member = iterator.next();
			logger.info("Member id={},username={}", member.getUid(), member.getUsername());
			logger.info("Source id={}, name={}", member.getSourceId(), member.getSource());
			for (Iterator<Wallet> iterator2 = member.getWalletList().iterator(); iterator2.hasNext();) {
				Wallet wallet = iterator2.next();
				logger.info("==== Wallety type={},name={}", wallet.getType().getValue(), wallet.getType().getName());
			}
		}
	}

}
