package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.model.Config;

public class ConfigUpdateAction extends BaseAction {
	private static final long serialVersionUID = 4506943983883024077L;
	private List configroot;
	private String cf;
	private Config config;

	public String execute() throws Exception {
		configroot = sconfig.findAllRoot();
		config = sconfig.findById(cf);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		Config ucf = sconfig.findById(config.getId());
		if (null != config.getConfig() && null != config.getConfig().getId() && !config.getConfig().getId().equals("")) {
			ucf.setConfig(config.getConfig());
		} else {
			ucf.setConfig(null);
		}
		ucf.setName(config.getName());
		ucf.setProperty(config.getProperty());
		ucf.setValue(config.getValue());
		ucf.setContent(config.getContent());
		ucf.setUtime(getTimestamp());
		sconfig.merge(ucf);
		return SUCCESS;
	}
	
	public String doset() throws Exception {
		Config ucf = sconfig.findById(config.getId());
		ucf.setValue(config.getValue());
		ucf.setUtime(getTimestamp());
		sconfig.merge(ucf);
		return SUCCESS;
	}

	public List getConfigroot() {
		return configroot;
	}

	public void setConfigroot(List configroot) {
		this.configroot = configroot;
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
}
