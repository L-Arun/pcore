/**
 * 
 */
package com.lehecai.core.api.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;

/**
 * @author Sunshow
 *
 */
public class SiteConfig extends AbstractApiResultBean {

	private String rootJS;
	private String rootCSS;
	private String rootIMG;
	private String rootSTATIC;
	private String rootURL;
	private String rootWAPCSS;
	private String rootWAPIMG;
	private String rootWAPJS;
	
	public static SiteConfig convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		SiteConfig config = new SiteConfig();
		
		config.setRootCSS(getString(object, "ROOT_CSS"));
		config.setRootIMG(getString(object, "ROOT_IMG"));
		config.setRootJS(getString(object, "ROOT_JS"));
		config.setRootSTATIC(getString(object, "ROOT_STATIC"));
		config.setRootURL(getString(object, "ROOT_URL"));
		config.setRootWAPCSS(getString(object, "ROOT_WAPCSS"));
		config.setRootWAPIMG(getString(object, "ROOT_WAPIMG"));
		config.setRootWAPJS(getString(object, "ROOT_WAPJS"));
		
		return config;
	}
	
	@SuppressWarnings("unchecked")
	public static List<SiteConfig> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<SiteConfig> list = new ArrayList<SiteConfig>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public String getRootJS() {
		return rootJS;
	}

	public void setRootJS(String rootJS) {
		this.rootJS = rootJS;
	}

	public String getRootCSS() {
		return rootCSS;
	}

	public void setRootCSS(String rootCSS) {
		this.rootCSS = rootCSS;
	}

	public String getRootIMG() {
		return rootIMG;
	}

	public void setRootIMG(String rootIMG) {
		this.rootIMG = rootIMG;
	}

	public String getRootSTATIC() {
		return rootSTATIC;
	}

	public void setRootSTATIC(String rootSTATIC) {
		this.rootSTATIC = rootSTATIC;
	}

	public String getRootURL() {
		return rootURL;
	}

	public void setRootURL(String rootURL) {
		this.rootURL = rootURL;
	}

	public String getRootWAPCSS() {
		return rootWAPCSS;
	}

	public void setRootWAPCSS(String rootWAPCSS) {
		this.rootWAPCSS = rootWAPCSS;
	}

	public String getRootWAPIMG() {
		return rootWAPIMG;
	}

	public void setRootWAPIMG(String rootWAPIMG) {
		this.rootWAPIMG = rootWAPIMG;
	}

	public String getRootWAPJS() {
		return rootWAPJS;
	}

	public void setRootWAPJS(String rootWAPJS) {
		this.rootWAPJS = rootWAPJS;
	}

}
