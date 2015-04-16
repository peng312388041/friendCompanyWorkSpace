package com.e6mall.action.manager;

import java.io.PrintWriter;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.e6mall.model.Config;

public class ConfigUpdateAjaxAction extends BaseAction {
	private static final long serialVersionUID = -2629384011158929575L;
	private String cf;
	private Config config;
	private String optionallist;
	private JSONArray jo;
	private String newvalue;

	/*
	 * AJAX更新系统设置
	 */
	public String execute() throws Exception {
		try {
			Config conf = sconfig.findById(cf);
			conf.setValue(newvalue);
			sconfig.merge(conf);
			PrintWriter out = response.getWriter();   
		    out.print(newvalue);
		} catch (NullPointerException e) {
		}
		return null;
	}
	
	/*
	 * 获得可选设置项
	 */
	public String getOptional() throws Exception {
		config = sconfig.findById(cf);
		String optional = config.getOptional();
		String[] ot = optional.split("[|]");	//由于|属于正则表达式字符，必须使用[|]
		//jo = JSONArray.fromObject(ot);
		JSONObject jj = JSONObject.fromObject(ot);
		System.out.println(jj);
		optionallist = jj.toString();
		return SUCCESS;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public String getOptionallist() {
		return optionallist;
	}

	public void setOptionallist(String optionallist) {
		this.optionallist = optionallist;
	}

	public JSONArray getJo() {
		return jo;
	}

	public void setJo(JSONArray jo) {
		this.jo = jo;
	}

	public String getNewvalue() {
		return newvalue;
	}

	public void setNewvalue(String newvalue) {
		this.newvalue = newvalue;
	}
}
