package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.ILocaleDAO;
import com.e6mall.model.Locale;
import com.e6mall.services.ISLocale;
import com.e6mall.utils.PaginationSupport;

public class SLocale extends BaseServices implements ISLocale {
	private ILocaleDAO localedao;

	public ILocaleDAO getLocaledao() {
		return localedao;
	}

	public void setLocaledao(ILocaleDAO localedao) {
		this.localedao = localedao;
	}

	public void attachClean(Locale instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Locale instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Locale persistentInstance) {
		localedao.delete(persistentInstance);
	}

	public List findAll() {
		List list = localedao.findAll();
		return list;
	}

	public Locale findById(String id) {
		Locale locale = localedao.findById(id);
		return locale;
	}

	public Locale merge(Locale detachedInstance) {
		Locale locale = localedao.merge(detachedInstance);
		return locale;
	}

	public void save(Locale transientInstance) {
		localedao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = localedao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = localedao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int startIndex) {
		PaginationSupport ps = localedao.findPageByCriteria(detachedCriteria, startIndex);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex) {
		PaginationSupport ps = localedao.findPageByCriteria(detachedCriteria, pageSize, startIndex);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = localedao.getCountByCriteria(detachedCriteria);
		return count;
	}

}
