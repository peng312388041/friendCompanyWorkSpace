package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.model.Channel;

public class ChannelsAction extends BaseAction {
	private static final long serialVersionUID = 7903954666905059306L;
	private List list;
	private List gachctlist;
	private String[] checkbox;

	public String execute() throws Exception {
		list = schannel.findAll();
		gachctlist = schcontent.findAllGlobal();
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		if (null != checkbox && checkbox.length > 0) {
			for (int i=0; i<checkbox.length; i++) {
				Channel channel = schannel.findById(checkbox[i]);
				if (null != channel)
					schannel.delete(channel);
			}
		}
		return SUCCESS;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public List getGachctlist() {
		return gachctlist;
	}

	public void setGachctlist(List gachctlist) {
		this.gachctlist = gachctlist;
	}

	public String[] getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}
}
