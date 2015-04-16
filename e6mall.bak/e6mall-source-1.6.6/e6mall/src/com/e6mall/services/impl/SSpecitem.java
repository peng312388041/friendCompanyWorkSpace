package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.ISpecitemDAO;
import com.e6mall.model.Specitem;
import com.e6mall.services.ISSpecitem;
import com.e6mall.utils.PaginationSupport;

public class SSpecitem extends BaseServices implements ISSpecitem {
	private ISpecitemDAO specitemdao;

	public ISpecitemDAO getSpecitemdao() {
		return specitemdao;
	}

	public void setSpecitemdao(ISpecitemDAO specitemdao) {
		this.specitemdao = specitemdao;
	}

	public void attachClean(Specitem instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Specitem instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Specitem persistentInstance) {
		specitemdao.delete(persistentInstance);
	}

	public List findAll() {
		List list = specitemdao.findAll();
		return list;
	}

	public Specitem findById(String id) {
		Specitem specitem = specitemdao.findById(id);
		return specitem;
	}

	public Specitem merge(Specitem detachedInstance) {
		Specitem specitem = specitemdao.merge(detachedInstance);
		return specitem;
	}

	public void save(Specitem transientInstance) {
		specitemdao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = specitemdao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = specitemdao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int page) {
		PaginationSupport ps = specitemdao.findPageByCriteria(detachedCriteria, page);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int page) {
		PaginationSupport ps = specitemdao.findPageByCriteria(detachedCriteria, pageSize, page);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = specitemdao.getCountByCriteria(detachedCriteria);
		return count;
	}

}
