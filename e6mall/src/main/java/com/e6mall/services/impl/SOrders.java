package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.IOrdersDAO;
import com.e6mall.model.Orders;
import com.e6mall.services.ISOrders;
import com.e6mall.utils.PaginationSupport;

public class SOrders extends BaseServices implements ISOrders {
	private IOrdersDAO ordersdao;

	public IOrdersDAO getOrdersdao() {
		return ordersdao;
	}

	public void setOrdersdao(IOrdersDAO ordersdao) {
		this.ordersdao = ordersdao;
	}

	public void attachClean(Orders instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Orders instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Orders persistentInstance) {
		ordersdao.delete(persistentInstance);
	}

	public List findAll() {
		List list = ordersdao.findAll();
		return list;
	}

	public Orders findByCode(Object code) {
		List list = ordersdao.findByCode(code);
		if (list.size() > 0)
			return (Orders)list.get(0);
		else
			return null;
	}

	public Orders findById(String id) {
		Orders orders = ordersdao.findById(id);
		return orders;
	}

	public Orders merge(Orders detachedInstance) {
		Orders orders = ordersdao.merge(detachedInstance);
		return orders;
	}

	public void save(Orders transientInstance) {
		ordersdao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = ordersdao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = ordersdao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int startIndex) {
		PaginationSupport ps = ordersdao.findPageByCriteria(detachedCriteria, startIndex);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex) {
		PaginationSupport ps = ordersdao.findPageByCriteria(detachedCriteria, pageSize, startIndex);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = ordersdao.getCountByCriteria(detachedCriteria);
		return count;
	}
}
