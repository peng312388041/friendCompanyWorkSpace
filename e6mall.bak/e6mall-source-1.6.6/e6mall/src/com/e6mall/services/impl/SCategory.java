package com.e6mall.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;

import com.e6mall.dao.ICategoryDAO;
import com.e6mall.model.Category;
import com.e6mall.model.Locale;
import com.e6mall.services.ISCategory;
import com.e6mall.utils.PaginationSupport;

public class SCategory extends BaseServices implements ISCategory {
	private ICategoryDAO categorydao;

	public ICategoryDAO getCategorydao() {
		return categorydao;
	}

	public void setCategorydao(ICategoryDAO categorydao) {
		this.categorydao = categorydao;
	}

	public void attachClean(Category instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Category instance) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<Category> findAllTree() {
		ArrayList<Category> list = new ArrayList<Category>();
		DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
		dc.add(Property.forName("category").isNull());
		dc.addOrder(Order.asc(CSORT));
		List categorys = categorydao.findAllByCriteria(dc);
		for (int i=0; i<categorys.size(); i++) {
			Category category = (Category)categorys.get(i);
			this.findSubTree(list, category);
		}
		return list;
	}
	
	public ArrayList<Category> findAllTree(Locale locale) {
		ArrayList<Category> list = new ArrayList<Category>();
		DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
		dc.add(Property.forName("category").isNull());
		dc.add(Property.forName("locale").eq(locale));
		dc.addOrder(Order.asc(CSORT));
		List categorys = categorydao.findAllByCriteria(dc);
		for (int i=0; i<categorys.size(); i++) {
			Category category = (Category)categorys.get(i);
			this.findSubTree(list, category);
		}
		return list;
	}
	
	public ArrayList<Category>  findSubTree(ArrayList<Category> list, Category category) {
		int lg = category.getNodepath().split(">").length - 1;
		//System.out.println(lg);
		String nodestr = "├";
		for (int j=0; j<lg; j++) {
			nodestr += "─";
			if (j==lg-1)
				nodestr += "┼";
		}
		//System.out.println(nodestr);
		category.setNodestr(nodestr);
		list.add(category);
		if (category.getNodetype().equals("D")) {
			DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
			dc.addOrder(Order.asc(CSORT));
			dc.add(Property.forName("category").eq(category));
			List cl = categorydao.findAllByCriteria(dc);
			for (int i=0; i<cl.size(); i++) {
				Category cg = (Category)cl.get(i);
				list = this.findSubTree(list, cg);
			}
		}
		return list;
	}

	public void delete(Category persistentInstance) {
		Category pcate = persistentInstance.getCategory();
		categorydao.delete(persistentInstance);
		if (null != pcate) {
			pcate.getCategories().remove(persistentInstance);
			if (pcate.getCategories().size() <= 0) {
				pcate.setNodetype("F");
				categorydao.attachDirty(pcate);
			}
		}
	}

	public List findAll() {
		List list = categorydao.findAll();
		return list;
	}
	
	public List findAllRoot() {
		DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
		dc.add(Property.forName("category").isNull());
		dc.addOrder(Order.asc(CSORT));
		List categorys = categorydao.findAllByCriteria(dc);
		return categorys;
	}
	
	public List findAllRoot(Locale locale) {
		DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
		dc.add(Property.forName("category").isNull());
		dc.add(Property.forName("locale").eq(locale));
		dc.addOrder(Order.asc(CSORT));
		List categorys = categorydao.findAllByCriteria(dc);
		return categorys;
	}

	public Category findById(String id) {
		Category category = categorydao.findById(id);
		return category;
	}

	public Category merge(Category detachedInstance) {
		Category category = categorydao.merge(detachedInstance);
		return category;
	}
	
	public void save(Category transientInstance) {
		categorydao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = categorydao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = categorydao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int startIndex) {
		PaginationSupport ps = categorydao.findPageByCriteria(detachedCriteria, startIndex);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex) {
		PaginationSupport ps = categorydao.findPageByCriteria(detachedCriteria, pageSize, startIndex);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = categorydao.getCountByCriteria(detachedCriteria);
		return count;
	}
}
