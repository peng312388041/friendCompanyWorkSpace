package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.model.Config;

public class ConfigCreateAction extends BaseAction {
	private static final long serialVersionUID = 559811333580854092L;
	private List configroot;
	private Config config = new Config();

	public String execute() throws Exception {
		configroot = sconfig.findAllRoot();
		return SUCCESS;
	}
	
	public String create() throws Exception {
		if (null != config.getConfig() && !config.getConfig().getId().equals("")) {
		} else {
			config.setConfig(null);
		}
		config.setId(getUuid());
		config.setUtime(getTimestamp());
		sconfig.save(config);
		return SUCCESS;
	}

	public List getConfigroot() {
		return configroot;
	}

	public void setConfigroot(List configroot) {
		this.configroot = configroot;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}
}
