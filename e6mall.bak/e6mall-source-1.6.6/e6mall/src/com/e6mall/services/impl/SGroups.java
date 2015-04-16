package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.IGroupsDAO;
import com.e6mall.model.Groups;
import com.e6mall.services.ISGroups;
import com.e6mall.utils.PaginationSupport;

public class SGroups extends BaseServices implements ISGroups {
	private IGroupsDAO groupsdao;

	public IGroupsDAO getGroupsdao() {
		return groupsdao;
	}

	public void setGroupsdao(IGroupsDAO groupsdao) {
		this.groupsdao = groupsdao;
	}

	public void attachClean(Groups instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Groups instance) {
		// TODO Auto-generated method stub

	}

	public void delete(String id) {
		Groups groups = groupsdao.findById(id);
		if (null != groups)
			groupsdao.delete(groups);
	}

	public List findAll() {
		List list = groupsdao.findAll();
		return list;
	}

	public Groups findById(String id) {
		Groups groups = groupsdao.findById(id);
		return groups;
	}

	public Groups merge(Groups detachedInstance) {
		Groups groups = groupsdao.merge(detachedInstance);
		return groups;
	}

	public void save(Groups transientInstance) {
		groupsdao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = groupsdao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = groupsdao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int startIndex) {
		PaginationSupport ps = groupsdao.findPageByCriteria(detachedCriteria, startIndex);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex) {
		PaginationSupport ps = groupsdao.findPageByCriteria(detachedCriteria, pageSize, startIndex);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = groupsdao.getCountByCriteria(detachedCriteria);
		return count;
	}

	public void delete(Groups persistentInstance) {
		// TODO Auto-generated method stub
		
	}
}
