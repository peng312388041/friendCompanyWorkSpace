package com.e6mall.action.manager;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;

import com.e6mall.model.Attachment;
import com.e6mall.model.Paymode;
import com.e6mall.model.Setting;

public class PaymodeUpdateAction extends BaseUploadAction {
	private static final long serialVersionUID = -5738827243048403341L;
	private String pm;
	private Paymode paymode;
	private List list;
	private List<Setting> settings;

	public String execute() throws Exception {
		paymode = spaymode.findById(pm);
		DetachedCriteria dc = DetachedCriteria.forClass(Setting.class);
		dc.add(Property.forName("paymode").eq(paymode));
		dc.addOrder(Order.asc("property"));
		list = ssetting.findAllByCriteria(dc);//已有的参数
		List root = ssetting.findAllRoot(paymode.getPmtype());	//默认参数
		for (int i=0; i<root.size(); i++) {
			Setting setting = (Setting)root.get(i);
			boolean flag = false;//标记
			for (int j=0; j<list.size(); j++) {
				Setting sett = (Setting)list.get(j);
				if (sett.getProperty().equals(setting.getProperty())) {
					flag = true;//已有参数
					break;
				}
			}
			if (!flag) {
				list.add(setting);
			}
		}
		return SUCCESS;
	}
	
	public String update() throws Exception {
		Paymode upm = spaymode.findById(paymode.getId());
		if (null != upm) {
			upm.setCsort(paymode.getCsort());
			upm.setIntro(paymode.getIntro());
			upm.setName(paymode.getName());
			upm.setRate(paymode.getRate());
			upm.setFocrating(paymode.getFocrating());
			Attachment attachment = upload();
			Attachment oimage = upm.getImage();
			if (null != attachment)
				upm.setImage(attachment);
			spaymode.merge(upm);
			if (null != attachment && null != oimage)
				sattachment.delete(oimage);
		}
		return SUCCESS;
	}
	
	/*
	 * 更新第三方支付方式的参数
	 */
	public String updateSetting() throws Exception {
		paymode = spaymode.findById(pm);
		for (int i=0; i<settings.size(); i++) {
			Setting setting = (Setting)settings.get(i);
			String id = existId(paymode, setting.getProperty());
			if (!id.equals("")) {
				setting.setId(id);
			} else {
				setting.setId(getUuid());
			}
			setting.setPaymode(paymode);
			ssetting.merge(setting);
		}
		return SUCCESS;
	}
	
	private String existId(Paymode paymode, String property) throws Exception {
		String id = "";
		DetachedCriteria dc = DetachedCriteria.forClass(Setting.class);
		dc.add(Property.forName("property").eq(property));
		dc.add(Property.forName("paymode").eq(paymode));
		List list = ssetting.findAllByCriteria(dc);
		if (list.size() > 0) {
			Setting sti = (Setting)list.get(0);
			id = sti.getId();
		}
		return id;
	}

	public String getPm() {
		return pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}

	public Paymode getPaymode() {
		return paymode;
	}

	public void setPaymode(Paymode paymode) {
		this.paymode = paymode;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public List<Setting> getSettings() {
		return settings;
	}

	public void setSettings(List<Setting> settings) {
		this.settings = settings;
	}
}
