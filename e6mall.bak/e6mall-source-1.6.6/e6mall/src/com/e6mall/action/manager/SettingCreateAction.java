package com.e6mall.action.manager;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;

import com.e6mall.model.Setting;

public class SettingCreateAction extends BaseAction {
	private static final long serialVersionUID = -2011831135838326169L;
	private List list;
	private Setting setting = new Setting();

	public String execute() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Setting.class);
		dc.add(Property.forName("paymode").isNull());
		dc.addOrder(Order.asc("pmtype"));
		list = ssetting.findAllByCriteria(dc);
		return SUCCESS;
	}
	
	public String create() throws Exception {
		setting.setId(getUuid());
		ssetting.save(setting);
		return SUCCESS;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Setting getSetting() {
		return setting;
	}

	public void setSetting(Setting setting) {
		this.setting = setting;
	}
}
