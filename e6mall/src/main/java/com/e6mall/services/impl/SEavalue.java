package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.IEavalueDAO;
import com.e6mall.model.Eavalue;
import com.e6mall.services.ISEavalue;
import com.e6mall.utils.PaginationSupport;

public class SEavalue extends BaseServices implements ISEavalue {
	private IEavalueDAO eavaluedao;

	public IEavalueDAO getEavaluedao() {
		return eavaluedao;
	}

	public void setEavaluedao(IEavalueDAO eavaluedao) {
		this.eavaluedao = eavaluedao;
	}

	public void attachClean(Eavalue instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Eavalue instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Eavalue persistentInstance) {
		eavaluedao.delete(persistentInstance);
	}

	public List findAll() {
		List list = eavaluedao.findAll();
		return list;
	}

	public Eavalue findById(String id) {
		Eavalue eavalue = eavaluedao.findById(id);
		return eavalue;
	}

	public Eavalue merge(Eavalue detachedInstance) {
		Eavalue eavalue = eavaluedao.merge(detachedInstance);
		return eavalue;
	}

	public void save(Eavalue transientInstance) {
		eavaluedao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = eavaluedao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = eavaluedao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int page) {
		PaginationSupport ps = eavaluedao.findPageByCriteria(detachedCriteria, page);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int page) {
		PaginationSupport ps = eavaluedao.findPageByCriteria(detachedCriteria, pageSize, page);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = eavaluedao.getCountByCriteria(detachedCriteria);
		return count;
	}

}
