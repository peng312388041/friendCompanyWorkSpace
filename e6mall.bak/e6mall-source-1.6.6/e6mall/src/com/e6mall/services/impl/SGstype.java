package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.IGstypeDAO;
import com.e6mall.model.Gstype;
import com.e6mall.services.ISGstype;
import com.e6mall.utils.PaginationSupport;

public class SGstype extends BaseServices implements ISGstype {
	private IGstypeDAO gstypedao;

	public IGstypeDAO getGstypedao() {
		return gstypedao;
	}

	public void setGstypedao(IGstypeDAO gstypedao) {
		this.gstypedao = gstypedao;
	}

	public void attachClean(Gstype instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Gstype instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Gstype persistentInstance) {
		gstypedao.delete(persistentInstance);
	}

	public List findAll() {
		List list = gstypedao.findAll();
		return list;
	}

	public Gstype findById(String id) {
		Gstype gstype = gstypedao.findById(id);
		return gstype;
	}

	public Gstype merge(Gstype detachedInstance) {
		Gstype gstype = gstypedao.merge(detachedInstance);
		return gstype;
	}

	public void save(Gstype transientInstance) {
		gstypedao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = gstypedao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = gstypedao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int page) {
		PaginationSupport ps = gstypedao.findPageByCriteria(detachedCriteria, page);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int page) {
		PaginationSupport ps = gstypedao.findPageByCriteria(detachedCriteria, pageSize, page);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = gstypedao.getCountByCriteria(detachedCriteria);
		return count;
	}

}
