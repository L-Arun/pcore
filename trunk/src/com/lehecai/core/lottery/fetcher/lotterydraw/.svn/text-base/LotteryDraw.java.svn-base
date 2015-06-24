/**
 * 
 */
package com.lehecai.core.lottery.fetcher.lotterydraw;

import java.util.List;

import net.sf.json.JSONObject;

import com.lehecai.core.lottery.LotteryType;

/**
 * @author Sunshow
 *
 */
public class LotteryDraw {

	private LotteryType lotteryType;
	
	private String phase;			//期号
	private String result;			//开奖结果
	private List<LotteryDrawPrizeItem> resultDetail;	//开奖详情，奖金奖级等
	
	private String volumeOfSales;	//销售量
	private String jackpot;			//奖池
	private String timeDraw;		//开奖时间
	
	public LotteryType getLotteryType() {
		return lotteryType;
	}
	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public List<LotteryDrawPrizeItem> getResultDetail() {
		return resultDetail;
	}
	public void setResultDetail(List<LotteryDrawPrizeItem> resultDetail) {
		this.resultDetail = resultDetail;
	}
	public String getVolumeOfSales() {
		return volumeOfSales;
	}
	public void setVolumeOfSales(String volumeOfSales) {
		this.volumeOfSales = volumeOfSales;
	}
	public String getJackpot() {
		return jackpot;
	}
	public void setJackpot(String jackpot) {
		this.jackpot = jackpot;
	}
	public String getTimeDraw() {
		return timeDraw;
	}
	public void setTimeDraw(String timeDraw) {
		this.timeDraw = timeDraw;
	}
	/**
	 * 获取彩票开奖结果日志信息
	 * @return
	 */
	public String getLotteryOpenResultLogMsg(){
		StringBuffer sb = new StringBuffer("");
		sb.append("==开奖信息==").append(this.getLotteryType()==null?"无彩票类型":this.getLotteryType().getName()+"("+this.getLotteryType().getValue()+")");
		sb.append("==第(").append(this.getPhase()).append(")期");
		sb.append("==result:").append(this.getResult());
		sb.append("==timeDraw:").append(this.getTimeDraw());
		sb.append("==jackpot:").append(this.getJackpot());
		sb.append("==volumeOfSales:").append(this.getVolumeOfSales());
		sb.append("==resultDetail:").append(LotteryDrawPrizeItem.listDataInfo(this.getResultDetail())+"==");
		return sb.toString();
	}
	
	public static JSONObject toJSON(LotteryDraw lotteryDraw){
		JSONObject object = new JSONObject();
		if(lotteryDraw != null){
			object.put("lotteryType", lotteryDraw.getLotteryType().getValue());
			object.put("phase", lotteryDraw.getPhase());
			object.put("result", lotteryDraw.getResult());
			object.put("resultDetail", LotteryDrawPrizeItem.convertListToDBJsonString(lotteryDraw.getResultDetail()));
			object.put("volumeOfSales", lotteryDraw.getVolumeOfSales());
			object.put("jackpot", lotteryDraw.getJackpot());
			object.put("timeDraw", lotteryDraw.getTimeDraw());
		}
		return object;
	}
	
}
