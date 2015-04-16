package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.e6mall.dao.IDistrictDAO;
import com.e6mall.model.District;
import com.e6mall.services.ISDistrict;
import com.e6mall.utils.PaginationSupport;

public class SDistrict extends BaseServices implements ISDistrict {
	private IDistrictDAO districtdao;

	public IDistrictDAO getDistrictdao() {
		return districtdao;
	}

	public void setDistrictdao(IDistrictDAO districtdao) {
		this.districtdao = districtdao;
	}

	public void attachClean(District instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(District instance) {
		// TODO Auto-generated method stub

	}

	public void delete(District persistentInstance) {
		districtdao.delete(persistentInstance);
	}

	public List findAll() {
		List list = districtdao.findAll();
		return list;
	}
	
	public List findAllRoot() {
		DetachedCriteria dc = DetachedCriteria.forClass(District.class);
		dc.add(Property.forName("district").isNull());
		List districts = districtdao.findAllByCriteria(dc);
		return districts;
	}

	public District findById(Integer id) {
		District district = districtdao.findById(id);
		return district;
	}

	public District merge(District detachedInstance) {
		District district = districtdao.merge(detachedInstance);
		return district;
	}

	public void save(District transientInstance) {
		districtdao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = districtdao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = districtdao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int startIndex) {
		PaginationSupport ps = districtdao.findPageByCriteria(detachedCriteria, startIndex);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex) {
		PaginationSupport ps = districtdao.findPageByCriteria(detachedCriteria, pageSize, startIndex);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = districtdao.getCountByCriteria(detachedCriteria);
		return count;
	}

}
