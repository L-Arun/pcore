package com.lehecai.core.lottery.fetcher.ext;

import net.sf.json.JSONObject;

public class LotteryExtendItem {
	
	private String extendInfo;		//扩展信息

	public void setExtendInfo(String extendInfo) {
		this.extendInfo = extendInfo;
	}

	public String getExtendInfo() {
		return extendInfo;
	}
	
	@SuppressWarnings("static-access")
	public static JSONObject toJSON(LotteryExtendItem lotteryExtendItem){
		JSONObject object = new JSONObject();
		if(lotteryExtendItem!= null&&lotteryExtendItem.getExtendInfo()!=null&&!"".equals(lotteryExtendItem.getExtendInfo())){
			object=object.fromObject(lotteryExtendItem.getExtendInfo());
			object=object.fromObject(object.get("fc3d_sjh"));
		}
		return object;
	}
}
