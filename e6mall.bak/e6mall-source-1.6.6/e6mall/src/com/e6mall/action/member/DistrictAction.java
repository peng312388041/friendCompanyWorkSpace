package com.e6mall.action.member;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.e6mall.action.BaseAction;
import com.e6mall.model.District;

public class DistrictAction extends BaseAction {
	private static final long serialVersionUID = 6076906051399982150L;
	private int id;
	private List list;

	public String execute() throws Exception {
		if (id > 0) {
			District district = sdistrict.findById(id);
			if (null != district) {
				DetachedCriteria dc = DetachedCriteria.forClass(District.class);
				dc.add(Property.forName("district").eq(district));
				list = sdistrict.findAllByCriteria(dc);
			}
		}
		return SUCCESS;
	}
	
	@JSON(serialize=false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
}
