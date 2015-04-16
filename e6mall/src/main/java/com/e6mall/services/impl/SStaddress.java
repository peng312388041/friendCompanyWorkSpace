package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.IStaddressDAO;
import com.e6mall.model.Staddress;
import com.e6mall.services.ISStaddress;
import com.e6mall.utils.PaginationSupport;

public class SStaddress extends BaseServices implements ISStaddress {
	private IStaddressDAO staddressdao;

	public IStaddressDAO getStaddressdao() {
		return staddressdao;
	}

	public void setStaddressdao(IStaddressDAO staddressdao) {
		this.staddressdao = staddressdao;
	}

	public void attachClean(Staddress instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Staddress instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Staddress persistentInstance) {
		staddressdao.delete(persistentInstance);
	}

	public List findAll() {
		List list = staddressdao.findAll();
		return list;
	}

	public Staddress findById(String id) {
		Staddress staddress = staddressdao.findById(id);
		return staddress;
	}

	public Staddress merge(Staddress detachedInstance) {
		Staddress staddress = staddressdao.merge(detachedInstance);
		return staddress;
	}

	public void save(Staddress staddress) {
		staddressdao.save(staddress);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = staddressdao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = staddressdao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int page) {
		PaginationSupport ps = staddressdao.findPageByCriteria(detachedCriteria, page);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int page) {
		PaginationSupport ps = staddressdao.findPageByCriteria(detachedCriteria, pageSize, page);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = staddressdao.getCountByCriteria(detachedCriteria);
		return count;
	}

}
