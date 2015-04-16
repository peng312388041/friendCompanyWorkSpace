package com.e6mall.action.manager;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Category;

public class CategorysAction extends BaseAction {
	private static final long serialVersionUID = 2008351528678629798L;
	private String pc;
	private Category pcategory;
	private List list;
	private String[] checkbox;

	public String execute() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
		if (null != pc && !pc.equals("")) {
			pcategory = scategory.findById(pc);
			dc.add(Property.forName("category").eq(pcategory));
		} else {
			dc.add(Property.forName("category").isNull());
		}
		dc.addOrder(Order.asc("csort"));
		list = scategory.findAllByCriteria(dc);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		for (int i=0; i<checkbox.length; i++) {
			Category category = scategory.findById(checkbox[i]);
			scategory.delete(category);
		}
		return SUCCESS;
	}

	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	public Category getPcategory() {
		return pcategory;
	}

	public void setPcategory(Category pcategory) {
		this.pcategory = pcategory;
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
