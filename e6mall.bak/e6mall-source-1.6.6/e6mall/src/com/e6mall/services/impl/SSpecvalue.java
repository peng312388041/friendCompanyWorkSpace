package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.ISpecvalueDAO;
import com.e6mall.model.Specvalue;
import com.e6mall.services.ISAttachment;
import com.e6mall.services.ISSpecvalue;
import com.e6mall.utils.PaginationSupport;

public class SSpecvalue extends BaseServices implements ISSpecvalue {
	private ISpecvalueDAO specvaluedao;
	private ISAttachment sattachment;

	public ISpecvalueDAO getSpecvaluedao() {
		return specvaluedao;
	}

	public void setSpecvaluedao(ISpecvalueDAO specvaluedao) {
		this.specvaluedao = specvaluedao;
	}

	public ISAttachment getSattachment() {
		return sattachment;
	}

	public void setSattachment(ISAttachment sattachment) {
		this.sattachment = sattachment;
	}

	public void attachClean(Specvalue instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Specvalue instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Specvalue specvalue) {
		if (null != specvalue.getImage())
			sattachment.delete(specvalue.getImage());
		specvaluedao.delete(specvalue);
	}

	public List findAll() {
		List list = specvaluedao.findAll();
		return list;
	}

	public Specvalue findById(String id) {
		Specvalue specvalue = specvaluedao.findById(id);
		return specvalue;
	}

	public Specvalue merge(Specvalue detachedInstance) {
		Specvalue specvalue = specvaluedao.merge(detachedInstance);
		return specvalue;
	}

	public void save(Specvalue transientInstance) {
		specvaluedao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = specvaluedao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = specvaluedao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int page) {
		PaginationSupport ps = specvaluedao.findPageByCriteria(detachedCriteria, page);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int page) {
		PaginationSupport ps = specvaluedao.findPageByCriteria(detachedCriteria, pageSize, page);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = specvaluedao.getCountByCriteria(detachedCriteria);
		return count;
	}
}
