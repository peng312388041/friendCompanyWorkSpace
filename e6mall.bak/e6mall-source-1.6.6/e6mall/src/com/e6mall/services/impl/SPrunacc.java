package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.IPrunaccDAO;
import com.e6mall.model.Prunacc;
import com.e6mall.services.ISPrunacc;
import com.e6mall.utils.PaginationSupport;

public class SPrunacc extends BaseServices implements ISPrunacc {
	private IPrunaccDAO prunaccdao;

	public IPrunaccDAO getPrunaccdao() {
		return prunaccdao;
	}

	public void setPrunaccdao(IPrunaccDAO prunaccdao) {
		this.prunaccdao = prunaccdao;
	}

	public void attachClean(Prunacc instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Prunacc instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Prunacc persistentInstance) {
		prunaccdao.delete(persistentInstance);
	}

	public List findAll() {
		List list = prunaccdao.findAll();
		return list;
	}

	public Prunacc findById(String id) {
		Prunacc prunacc = prunaccdao.findById(id);
		return prunacc;
	}

	public Prunacc merge(Prunacc detachedInstance) {
		Prunacc prunacc = prunaccdao.merge(detachedInstance);
		return prunacc;
	}

	public void save(Prunacc transientInstance) {
		prunaccdao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = prunaccdao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = prunaccdao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int startIndex) {
		PaginationSupport ps = prunaccdao.findPageByCriteria(detachedCriteria, startIndex);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex) {
		PaginationSupport ps = prunaccdao.findPageByCriteria(detachedCriteria, pageSize, startIndex);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = prunaccdao.getCountByCriteria(detachedCriteria);
		return count;
	}

}
