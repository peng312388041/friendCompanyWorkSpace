package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.ILogisticsDAO;
import com.e6mall.model.Logistics;
import com.e6mall.services.ISLogistics;
import com.e6mall.utils.PaginationSupport;

public class SLogistics extends BaseServices implements ISLogistics {
	private ILogisticsDAO logisticsdao;

	public ILogisticsDAO getLogisticsdao() {
		return logisticsdao;
	}

	public void setLogisticsdao(ILogisticsDAO logisticsdao) {
		this.logisticsdao = logisticsdao;
	}

	public void attachClean(Logistics instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Logistics instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Logistics persistentInstance) {
		logisticsdao.delete(persistentInstance);
	}

	public List findAll() {
		List list = logisticsdao.findAll();
		return list;
	}

	public Logistics findById(String id) {
		Logistics logistics = logisticsdao.findById(id);
		return logistics;
	}

	public Logistics merge(Logistics detachedInstance) {
		Logistics logistics = logisticsdao.merge(detachedInstance);
		return logistics;
	}

	public void save(Logistics transientInstance) {
		logisticsdao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = logisticsdao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = logisticsdao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int page) {
		PaginationSupport ps = logisticsdao.findPageByCriteria(detachedCriteria, page);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int page) {
		PaginationSupport ps = logisticsdao.findPageByCriteria(detachedCriteria, pageSize, page);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = logisticsdao.getCountByCriteria(detachedCriteria);
		return count;
	}

}
