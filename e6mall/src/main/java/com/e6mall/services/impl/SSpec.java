package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.ISpecDAO;
import com.e6mall.model.Spec;
import com.e6mall.services.ISSpec;
import com.e6mall.utils.PaginationSupport;

public class SSpec extends BaseServices implements ISSpec {
	private ISpecDAO specdao;

	public ISpecDAO getSpecdao() {
		return specdao;
	}

	public void setSpecdao(ISpecDAO specdao) {
		this.specdao = specdao;
	}

	public void attachClean(Spec instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Spec instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Spec persistentInstance) {
		specdao.delete(persistentInstance);
	}

	public List findAll() {
		List list = specdao.findAll();
		return list;
	}

	public Spec findById(String id) {
		Spec spec = specdao.findById(id);
		return spec;
	}

	public Spec merge(Spec detachedInstance) {
		Spec spec = specdao.merge(detachedInstance);
		return spec;
	}

	public void save(Spec transientInstance) {
		specdao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = specdao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = specdao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int page) {
		PaginationSupport ps = specdao.findPageByCriteria(detachedCriteria, page);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int page) {
		PaginationSupport ps = specdao.findPageByCriteria(detachedCriteria, pageSize, page);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = specdao.getCountByCriteria(detachedCriteria);
		return count;
	}

}
