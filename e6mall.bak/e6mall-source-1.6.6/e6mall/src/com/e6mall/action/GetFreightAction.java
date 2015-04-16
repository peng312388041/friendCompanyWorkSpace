package com.e6mall.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.model.District;
import com.e6mall.model.Lsarea;
import com.e6mall.model.Staddress;

public class GetFreightAction extends BaseAction {
	private static final long serialVersionUID = 6932037959126977567L;
	private String str;
	private List list;

	public String execute() throws Exception {
		Staddress staddress = sstaddress.findById(str);
		if (null != staddress) {
			District district = staddress.getDistrict();
			
			DetachedCriteria adc = DetachedCriteria.forClass(Lsarea.class);
			//adc.add(Property.forName("district").eq(district));
			list = slsarea.findAllByCriteria(adc);	//获得所有该地区的运费
		} else {
			//错误请求
		}
		return SUCCESS;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
}
