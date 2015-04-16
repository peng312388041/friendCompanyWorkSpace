package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.IBrandDAO;
import com.e6mall.model.Brand;
import com.e6mall.services.ISBrand;
import com.e6mall.utils.PaginationSupport;

public class SBrand extends BaseServices implements ISBrand {
	private IBrandDAO branddao;

	public IBrandDAO getBranddao() {
		return branddao;
	}

	public void setBranddao(IBrandDAO branddao) {
		this.branddao = branddao;
	}

	public void attachClean(Brand instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Brand instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Brand persistentInstance) {
		branddao.delete(persistentInstance);
	}

	public List findAll() {
		List list = branddao.findAll();
		return list;
	}

	public Brand findById(String id) {
		Brand brand = branddao.findById(id);
		return brand;
	}
	
	public Brand findByName(String name) {
		List list = branddao.findByName(name);
		if (null != list && list.size()>0) {
			Brand brand = (Brand)list.get(0);
			return brand;
		} else {
			return null;
		}
	}

	public Brand merge(Brand detachedInstance) {
		Brand brand = branddao.merge(detachedInstance);
		return brand;
	}

	public void save(Brand transientInstance) {
		branddao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = branddao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = branddao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int page) {
		PaginationSupport ps = branddao.findPageByCriteria(detachedCriteria, page);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int page) {
		PaginationSupport ps = branddao.findPageByCriteria(detachedCriteria, pageSize, page);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = branddao.getCountByCriteria(detachedCriteria);
		return count;
	}

}
