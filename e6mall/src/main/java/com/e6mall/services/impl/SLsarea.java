package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.ILsareaDAO;
import com.e6mall.model.Lsarea;
import com.e6mall.services.ISLsarea;
import com.e6mall.utils.PaginationSupport;

public class SLsarea extends BaseServices implements ISLsarea {
	private ILsareaDAO lsareadao;

	public ILsareaDAO getLsareadao() {
		return lsareadao;
	}

	public void setLsareadao(ILsareaDAO lsareadao) {
		this.lsareadao = lsareadao;
	}

	public void attachClean(Lsarea instance) {
		lsareadao.attachClean(instance);
	}

	public void attachDirty(Lsarea instance) {
		lsareadao.attachDirty(instance);
	}

	public void delete(Lsarea persistentInstance) {
		lsareadao.delete(persistentInstance);
	}

	public List findAll() {
		List list = lsareadao.findAll();
		return list;
	}

	public List findByCod(Object cod) {
		List list = lsareadao.findByCod(cod);
		return list;
	}

	public Lsarea findById(String id) {
		Lsarea lsarea = lsareadao.findById(id);
		return lsarea;
	}

	public List findByName(Object name) {
		List list = lsareadao.findByName(name);
		return list;
	}

	public List findByPremiumrate(Object premiumrate) {
		List list = lsareadao.findByPremiumrate(premiumrate);
		return list;
	}

	public List findByProperty(String propertyName, Object value) {
		List list = lsareadao.findByProperty(propertyName, value);
		return list;
	}

	public List findByStatus(Object status) {
		List list = lsareadao.findByStatus(status);
		return list;
	}

	public List findByWacost(Object wacost) {
		List list = lsareadao.findByWacost(wacost);
		return list;
	}

	public List findByWappend(Object wappend) {
		List list = lsareadao.findByWappend(wappend);
		return list;
	}

	public List findByWfcost(Object wfcost) {
		List list = lsareadao.findByWfcost(wfcost);
		return list;
	}

	public List findByWfirst(Object wfirst) {
		List list = lsareadao.findByWfirst(wfirst);
		return list;
	}

	public Lsarea merge(Lsarea detachedInstance) {
		Lsarea lsarea = lsareadao.merge(detachedInstance);
		return lsarea;
	}

	public void save(Lsarea transientInstance) {
		lsareadao.save(transientInstance);
	}
	
	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = lsareadao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = lsareadao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int startIndex) {
		PaginationSupport ps = lsareadao.findPageByCriteria(detachedCriteria, startIndex);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex) {
		PaginationSupport ps = lsareadao.findPageByCriteria(detachedCriteria, pageSize, startIndex);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = lsareadao.getCountByCriteria(detachedCriteria);
		return count;
	}
}
