package com.e6mall.action.manager;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Channel;
import com.e6mall.model.Chcontent;

public class ChcontentsAction extends BaseAction {
	private static final long serialVersionUID = 1788395728394368111L;
	private String ca;
	private Channel channel;
	private List list;
	private String[] checkbox;

	public String execute() throws Exception {
		if (null != ca && !ca.equals("")) {
			channel = schannel.findById(ca);
			if (null != channel) {
				DetachedCriteria dc = DetachedCriteria.forClass(Chcontent.class);
				dc.add(Property.forName("channel").eq(channel));
				dc.addOrder(Order.asc("marker"));
				list = schcontent.findAllByCriteria(dc);
			}
		}
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		boolean global = false;
		for (int i=0; i<checkbox.length; i++) {
			Chcontent chcontent = schcontent.findById(checkbox[i]);
			if (null != chcontent) {
				schcontent.delete(chcontent);
				if (null != chcontent.getGlobal() && chcontent.getGlobal().equals("yes"))
					global = true;
			}
		}
		if (global)
			return "global";
		else
			return SUCCESS;
	}

	public String getCa() {
		return ca;
	}

	public void setCa(String ca) {
		this.ca = ca;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String[] getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}
}
