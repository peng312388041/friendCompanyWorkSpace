package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.model.Config;

public class ConfigsAction extends BaseAction {
	private static final long serialVersionUID = 5778216668081411564L;
	private List<Config> list;
	private String[] checkbox;
	
	public String execute() throws Exception {
		list = sconfig.findAllRoot();
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		for (int i=0; i<checkbox.length; i++) {
			Config config = sconfig.findById(checkbox[i]);
			if (null != config)
				sconfig.delete(config);
		}
		return SUCCESS;
	}

	public List<Config> getList() {
		return list;
	}

	public void setList(List<Config> list) {
		this.list = list;
	}
}
