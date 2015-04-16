package com.e6mall.action.manager;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.apache.struts2.json.annotations.JSON;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.e6mall.model.District;

public class DistrictAjaxAction extends BaseAction {
	private static final long serialVersionUID = -3241333116976701481L;
	private int id;
	//private String result;
	private List list;
	
	public String execute() throws Exception {
		JsonConfig config = new JsonConfig();
		config.setJsonPropertyFilter(new PropertyFilter() {
			public boolean apply(Object source, String name, Object value) {
				if (name.equals("district") || name.equals("districts")
						|| name.equals("lsareas")
						|| name.equals("staddresses")) {
					return true;
				} else {
					return false;
				}
			}
		});
		
		if (id > 0) {
			District district = sdistrict.findById(id);
			if (null != district) {
				DetachedCriteria dc = DetachedCriteria.forClass(District.class);
				dc.add(Property.forName("district").eq(district));
				list = sdistrict.findAllByCriteria(dc);
				JSONArray jo = JSONArray.fromObject(list, config);
				//result = jo.toString();
			}
		} else {	//顶级省份
			list = sdistrict.findAllRoot();
			JSONArray jo = JSONArray.fromObject(list, config);
			//result = jo.toString();
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
