package com.e6mall.action.member;

import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.e6mall.action.BaseAction;
import com.e6mall.model.District;
import com.e6mall.model.Staddress;

public class StaddressesAction extends BaseAction {
	private static final long serialVersionUID = -7357355245586878102L;
	private List list;
	private List districtroot;
	private String sid = "";//编辑
	private Staddress staddress;
	private String stid = "";//删除,设置默认
	private String editDistrict;

	public String execute() throws Exception {
		districtroot = sdistrict.findAllRoot();
		DetachedCriteria dc = DetachedCriteria.forClass(Staddress.class);
		dc.add(Property.forName("member").eq(this.getMsession()));
		list = sstaddress.findAllByCriteria(dc);
		
		if (null != sid && !sid.equals("")) {
			staddress = sstaddress.findById(sid);
			//取出省份地区
			District dt = staddress.getDistrict().getDistrict();
			Iterator it = dt.getDistricts().iterator();
			while(it.hasNext()) {
				District subdt = (District)it.next();
				if (subdt.getId().equals(staddress.getDistrict().getId()))
					editDistrict += "<option value='" + subdt.getId() + "' selected='selected'>" + subdt.getName() + "</option>";
				else
					editDistrict += "<option value='" + subdt.getId() + "'>" + subdt.getName() + "</option>";
			}
		}
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		if (null != stid && !stid.equals("")) {
			Staddress staddress = sstaddress.findById(stid);
			if (null != staddress)
				sstaddress.delete(staddress);
		}
		return SUCCESS;
	}
	
	public String setDefault() throws Exception {
		if (null != stid && !stid.equals("")) {
			Staddress staddress = sstaddress.findById(stid);
			if (null != staddress) {
				DetachedCriteria dc = DetachedCriteria.forClass(Staddress.class);
				dc.add(Property.forName("member").eq(this.getMsession()));
				dc.add(Property.forName("status").eq("default"));
				list = sstaddress.findAllByCriteria(dc);
				//实际上默认的地址只可能有一个
				for (int i=0; i<list.size(); i++) {
					Staddress sd = (Staddress)list.get(i);
					sd.setStatus("normal");
					sstaddress.merge(sd);
				}
				
				staddress.setStatus("default");
				sstaddress.merge(staddress);
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

	public List getDistrictroot() {
		return districtroot;
	}

	public void setDistrictroot(List districtroot) {
		this.districtroot = districtroot;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Staddress getStaddress() {
		return staddress;
	}

	public void setStaddress(Staddress staddress) {
		this.staddress = staddress;
	}

	public String getStid() {
		return stid;
	}

	public void setStid(String stid) {
		this.stid = stid;
	}

	public String getEditDistrict() {
		return editDistrict;
	}

	public void setEditDistrict(String editDistrict) {
		this.editDistrict = editDistrict;
	}
}
