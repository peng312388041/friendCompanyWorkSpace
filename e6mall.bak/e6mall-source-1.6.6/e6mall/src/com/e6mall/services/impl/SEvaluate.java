package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.IEvaluateDAO;
import com.e6mall.model.Evaluate;
import com.e6mall.services.ISEvaluate;
import com.e6mall.utils.PaginationSupport;

public class SEvaluate extends BaseServices implements ISEvaluate {
	private IEvaluateDAO evaluatedao;

	public IEvaluateDAO getEvaluatedao() {
		return evaluatedao;
	}

	public void setEvaluatedao(IEvaluateDAO evaluatedao) {
		this.evaluatedao = evaluatedao;
	}

	public void attachClean(Evaluate instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Evaluate instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Evaluate persistentInstance) {
		evaluatedao.delete(persistentInstance);
	}

	public List findAll() {
		List list = evaluatedao.findAll();
		return list;
	}

	public Evaluate findById(String id) {
		Evaluate evaluate = evaluatedao.findById(id);
		return evaluate;
	}

	public Evaluate merge(Evaluate detachedInstance) {
		Evaluate evaluate = evaluatedao.merge(detachedInstance);
		return evaluate;
	}

	public void save(Evaluate transientInstance) {
		evaluatedao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = evaluatedao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = evaluatedao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int startIndex) {
		PaginationSupport ps = evaluatedao.findPageByCriteria(detachedCriteria, startIndex);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex) {
		PaginationSupport ps = evaluatedao.findPageByCriteria(detachedCriteria, pageSize, startIndex);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = evaluatedao.getCountByCriteria(detachedCriteria);
		return count;
	}

}
