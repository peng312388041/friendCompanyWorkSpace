package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.IExtattrDAO;
import com.e6mall.model.Extattr;
import com.e6mall.services.ISExtattr;
import com.e6mall.utils.PaginationSupport;

public class SExtattr extends BaseServices implements ISExtattr {
	private IExtattrDAO extattrdao;

	public IExtattrDAO getExtattrdao() {
		return extattrdao;
	}

	public void setExtattrdao(IExtattrDAO extattrdao) {
		this.extattrdao = extattrdao;
	}

	public void attachClean(Extattr instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Extattr instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Extattr persistentInstance) {
		extattrdao.delete(persistentInstance);
	}

	public List findAll() {
		List list = extattrdao.findAll();
		return list;
	}

	public Extattr findById(String id) {
		Extattr extattr = extattrdao.findById(id);
		return extattr;
	}

	public Extattr merge(Extattr detachedInstance) {
		Extattr extattr = extattrdao.merge(detachedInstance);
		return extattr;
	}

	public void save(Extattr transientInstance) {
		extattrdao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = extattrdao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = extattrdao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int page) {
		PaginationSupport ps = extattrdao.findPageByCriteria(detachedCriteria, page);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int page) {
		PaginationSupport ps = extattrdao.findPageByCriteria(detachedCriteria, pageSize, page);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = extattrdao.getCountByCriteria(detachedCriteria);
		return count;
	}

}
