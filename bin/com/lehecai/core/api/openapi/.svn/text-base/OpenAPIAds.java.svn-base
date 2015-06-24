package com.lehecai.core.api.openapi;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.YesNoStatus;
import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.util.CoreDateUtils;

public class OpenAPIAds extends AbstractApiResultBean {
	
	public static final String QUERY_ADS_TITLE = "ads_title";
	public static final String QUERY_ADS_ID = "ads_id";
	public static final String QUERY_STATUS = "status";
	public static final String QUERY_TIME_ADD = "time_add";
	
	public static final String SET_ADS_TITLE = "ads_title";
	public static final String SET_ADS_NEWS_ID = "news_id";
	public static final String SET_ADS_CONTENT = "ads_content";
	public static final String SET_ADS_DESC = "ads_desc";
	public static final String SET_ADS_IMG1_URL = "img1_url";
	public static final String SET_ADS_IMG2_URL  ="img2_url";
	public static final String SET_ADS_STATUS = "status";
	public static final String SET_ADS_IMG_DISABLE_DESC = "img_disable_desc";
	public static final String SET_APP_VERSION = "app_version";
	public static final String SET_APP_TYPE = "app_type";
	
	public static final String ORDER_ADS_ID = "ads_id";
	public static final String ORDER_ADS_TIME_ADD = "time_add";
	
	private long adsId;					//广告编号
	private String appVersion;				//版本号
	private OpenAPIAppType appType;		//平台类型
	private String adsTitle;			//广告标题
	private String adsDesc;				//广告描述
	private String img1Url;				//广告图片1 的地址
	private String img2Url;				//广告图片2 的地址
	private String imgDisableDesc;		//图片不可用事显示的文字描述
	private YesNoStatus status;			//广告的状态  （0 已禁用,1 已启用） 默认是禁用 0
	private String adsContent;			//广告内容
	private Date timeAdd;				//添加时间
	private long newsId;				//对应新闻活动ID
	
	public static OpenAPIAds convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		OpenAPIAds openAPIAds = new OpenAPIAds();
		
		openAPIAds.setAdsId(getLong(object, "ads_id"));
		openAPIAds.setAdsTitle(getString(object, "ads_title"));
		openAPIAds.setAppVersion(getString(object, "app_version"));
		int appTypeValue = getInt(object, "app_type");
		openAPIAds.setAppType(OpenAPIAppType.getItem(appTypeValue));
		openAPIAds.setAdsDesc(getString(object, "ads_desc"));
		openAPIAds.setImg1Url(getString(object, "img1_url"));
		openAPIAds.setImg2Url(getString(object, "img2_url"));
		openAPIAds.setImgDisableDesc(getString(object, "img_disable_desc"));
		int statusValue = getInt(object, "status");
		openAPIAds.setAdsContent(getString(object, "ads_content"));
		openAPIAds.setStatus(YesNoStatus.getItem(statusValue));
		openAPIAds.setTimeAdd(CoreDateUtils.parseDate(getString(object, "time_add"), CoreDateUtils.DATETIME));
		openAPIAds.setNewsId(getLong(object, "news_id"));
		
		return openAPIAds;
	}
	
	public static List<OpenAPIAds> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<OpenAPIAds> list = new ArrayList<OpenAPIAds>();
		for (Iterator<?> iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public long getAdsId() {
		return adsId;
	}

	public void setAdsId(long adsId) {
		this.adsId = adsId;
	}

	public String getAdsTitle() {
		return adsTitle;
	}

	public void setAdsTitle(String adsTitle) {
		this.adsTitle = adsTitle;
	}

	public String getAdsDesc() {
		return adsDesc;
	}

	public void setAdsDesc(String adsDesc) {
		this.adsDesc = adsDesc;
	}

	public String getImg1Url() {
		return img1Url;
	}

	public void setImg1Url(String img1Url) {
		this.img1Url = img1Url;
	}

	public String getImg2Url() {
		return img2Url;
	}

	public void setImg2Url(String img2Url) {
		this.img2Url = img2Url;
	}

	public String getImgDisableDesc() {
		return imgDisableDesc;
	}

	public void setImgDisableDesc(String imgDisableDesc) {
		this.imgDisableDesc = imgDisableDesc;
	}

	public YesNoStatus getStatus() {
		return status;
	}

	public void setStatus(YesNoStatus status) {
		this.status = status;
	}

	public String getAdsContent() {
		return adsContent;
	}

	public void setAdsContent(String adsContent) {
		this.adsContent = adsContent;
	}

	public Date getTimeAdd() {
		return timeAdd;
	}

	public void setTimeAdd(Date timeAdd) {
		this.timeAdd = timeAdd;
	}

	public long getNewsId() {
		return newsId;
	}

	public void setNewsId(long newsId) {
		this.newsId = newsId;
	}

	public OpenAPIAppType getAppType() {
		return appType;
	}

	public void setAppType(OpenAPIAppType appType) {
		this.appType = appType;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

}
