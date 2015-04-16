package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.IPaymodeDAO;
import com.e6mall.model.Paymode;
import com.e6mall.services.ISPaymode;
import com.e6mall.utils.PaginationSupport;

public class SPaymode extends BaseServices implements ISPaymode {
	private IPaymodeDAO paymodedao;

	public IPaymodeDAO getPaymodedao() {
		return paymodedao;
	}

	public void setPaymodedao(IPaymodeDAO paymodedao) {
		this.paymodedao = paymodedao;
	}

	public void attachClean(Paymode instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Paymode instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Paymode persistentInstance) {
		paymodedao.delete(persistentInstance);
	}

	public List findAll() {
		List list = paymodedao.findAll();
		return list;
	}

	public Paymode findById(String id) {
		Paymode paymode = paymodedao.findById(id);
		return paymode;
	}

	public Paymode merge(Paymode detachedInstance) {
		Paymode paymode = paymodedao.merge(detachedInstance);
		return paymode;
	}

	public void save(Paymode transientInstance) {
		paymodedao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = paymodedao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = paymodedao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int page) {
		PaginationSupport ps = paymodedao.findPageByCriteria(detachedCriteria, page);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int page) {
		PaginationSupport ps = paymodedao.findPageByCriteria(detachedCriteria, pageSize, page);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = paymodedao.getCountByCriteria(detachedCriteria);
		return count;
	}

}
