package com.e6mall.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;

import com.e6mall.dao.IDoccateDAO;
import com.e6mall.model.Category;
import com.e6mall.model.Doccate;
import com.e6mall.model.Locale;
import com.e6mall.services.ISDoccate;
import com.e6mall.utils.PaginationSupport;

public class SDoccate extends BaseServices implements ISDoccate {
	private IDoccateDAO doccatedao;

	public IDoccateDAO getDoccatedao() {
		return doccatedao;
	}

	public void setDoccatedao(IDoccateDAO doccatedao) {
		this.doccatedao = doccatedao;
	}

	public void attachClean(Doccate instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Doccate instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Doccate persistentInstance) {
		doccatedao.delete(persistentInstance);
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List findAllRoot() {
		DetachedCriteria dc = DetachedCriteria.forClass(Doccate.class);
		dc.add(Property.forName("doccate").isNull());
		dc.addOrder(Order.asc(CSORT));
		List list = doccatedao.findAllByCriteria(dc);
		return list;
	}
	
	public List findAllRoot(Locale locale) {
		DetachedCriteria dc = DetachedCriteria.forClass(Doccate.class);
		dc.add(Property.forName("doccate").isNull());
		dc.add(Property.forName("locale").eq(locale));
		dc.addOrder(Order.asc(CSORT));
		List list = doccatedao.findAllByCriteria(dc);
		return list;
	}
	
	public ArrayList<Doccate> findAllTree() {
		ArrayList<Doccate> list = new ArrayList<Doccate>();
		DetachedCriteria dc = DetachedCriteria.forClass(Doccate.class);
		dc.add(Property.forName("doccate").isNull());
		List categorys = doccatedao.findAllByCriteria(dc);
		for (int i=0; i<categorys.size(); i++) {
			Doccate category = (Doccate)categorys.get(i);
			this.findSubTree(list, category);
		}
		return list;
	}
	
	public ArrayList<Doccate>  findSubTree(ArrayList<Doccate> list, Doccate doccate) {
		int lg = doccate.getNodepath().split(">").length - 1;
		//System.out.println(lg);
		String nodestr = "├";
		for (int j=0; j<lg; j++) {
			nodestr += "─";
			if (j==lg-1)
				nodestr += "┼";
		}
		//System.out.println(nodestr);
		doccate.setNodestr(nodestr);
		list.add(doccate);
		if (doccate.getNodetype().equals("D")) {
			DetachedCriteria dc = DetachedCriteria.forClass(Doccate.class);
			dc.addOrder(Order.asc(CSORT));
			dc.add(Property.forName("doccate").eq(doccate));
			List cl = doccatedao.findAllByCriteria(dc);
			for (int i=0; i<cl.size(); i++) {
				Doccate cg = (Doccate)cl.get(i);
				list = this.findSubTree(list, cg);
			}
		}
		return list;
	}

	public Doccate findById(String id) {
		Doccate doccate = doccatedao.findById(id);
		return doccate;
	}

	public List findByProperty(String propertyName, Object value) {
		List list = doccatedao.findByProperty(propertyName, value);
		return list;
	}

	public Doccate merge(Doccate detachedInstance) {
		Doccate doccate = doccatedao.merge(detachedInstance);
		return doccate;
	}

	public void save(Doccate transientInstance) {
		doccatedao.save(transientInstance);
	}
	
	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = doccatedao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = doccatedao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int startIndex) {
		PaginationSupport ps = doccatedao.findPageByCriteria(detachedCriteria, startIndex);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex) {
		PaginationSupport ps = doccatedao.findPageByCriteria(detachedCriteria, pageSize, startIndex);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = doccatedao.getCountByCriteria(detachedCriteria);
		return count;
	}

}
