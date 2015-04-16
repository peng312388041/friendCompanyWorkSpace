package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.IOrderitemDAO;
import com.e6mall.model.Orderitem;
import com.e6mall.services.ISOrderitem;
import com.e6mall.utils.PaginationSupport;

public class SOrderitem extends BaseServices implements ISOrderitem {
	private IOrderitemDAO orderitemdao;

	public IOrderitemDAO getOrderitemdao() {
		return orderitemdao;
	}

	public void setOrderitemdao(IOrderitemDAO orderitemdao) {
		this.orderitemdao = orderitemdao;
	}

	public void attachClean(Orderitem instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Orderitem instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Orderitem persistentInstance) {
		orderitemdao.delete(persistentInstance);
	}

	public List findAll() {
		List list = orderitemdao.findAll();
		return list;
	}

	public Orderitem findById(String id) {
		Orderitem orderitem = orderitemdao.findById(id);
		return orderitem;
	}

	public Orderitem merge(Orderitem detachedInstance) {
		Orderitem orderitem = orderitemdao.merge(detachedInstance);
		return orderitem;
	}

	public void save(Orderitem transientInstance) {
		orderitemdao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = orderitemdao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = orderitemdao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int page) {
		PaginationSupport ps = orderitemdao.findPageByCriteria(detachedCriteria, page);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int page) {
		PaginationSupport ps = orderitemdao.findPageByCriteria(detachedCriteria, pageSize, page);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = orderitemdao.getCountByCriteria(detachedCriteria);
		return count;
	}
}
