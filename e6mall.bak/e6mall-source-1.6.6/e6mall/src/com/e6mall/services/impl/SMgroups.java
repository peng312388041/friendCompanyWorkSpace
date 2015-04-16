package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.IMgroupsDAO;
import com.e6mall.model.Mgroups;
import com.e6mall.services.ISMgroups;
import com.e6mall.utils.PaginationSupport;

public class SMgroups extends BaseServices implements ISMgroups {
	private IMgroupsDAO mgroupsdao;

	public IMgroupsDAO getMgroupsdao() {
		return mgroupsdao;
	}

	public void setMgroupsdao(IMgroupsDAO mgroupsdao) {
		this.mgroupsdao = mgroupsdao;
	}

	public void attachClean(Mgroups instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Mgroups instance) {
		// TODO Auto-generated method stub

	}

	public void delete(String id) {
		if (null != id && !id.equals("")) {
			Mgroups mgs = mgroupsdao.findById(id);
			if (null != mgs)
				mgroupsdao.delete(mgs);
		}
	}

	public List findAll() {
		List list = mgroupsdao.findAll();
		return list;
	}

	public Mgroups findById(String id) {
		Mgroups mgroups = mgroupsdao.findById(id);
		return mgroups;
	}

	public Mgroups merge(Mgroups detachedInstance) {
		Mgroups mgroups = mgroupsdao.merge(detachedInstance);
		return mgroups;
	}

	public void save(Mgroups transientInstance) {
		mgroupsdao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = mgroupsdao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = mgroupsdao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int startIndex) {
		PaginationSupport ps = mgroupsdao.findPageByCriteria(detachedCriteria, startIndex);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex) {
		PaginationSupport ps = mgroupsdao.findPageByCriteria(detachedCriteria, pageSize, startIndex);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = mgroupsdao.getCountByCriteria(detachedCriteria);
		return count;
	}

}
