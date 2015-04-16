package com.e6mall.services.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;

import com.e6mall.dao.IBrunaccDAO;
import com.e6mall.model.Brunacc;
import com.e6mall.services.ISBrunacc;
import com.e6mall.utils.PaginationSupport;

public class SBrunacc extends BaseServices implements ISBrunacc {
	private IBrunaccDAO brunaccdao;
	
	public Double getTotalBalance(Date min, Date max) {
		Double total = new Double(0);
		DetachedCriteria dc = DetachedCriteria.forClass(Brunacc.class);

		if (null != min && null != max)
			dc.add(Property.forName("ctime").between(min, max));
		
		dc.setProjection(Projections.sum(BALANCE));
		dc.add(Property.forName("status").eq("ok"));
		List list = brunaccdao.findAllByCriteria(dc);
		if (list.size() > 0)
			total = (Double)list.get(0);
		if (total == null)
			total = new Double(0);
		return total;
	}

	public IBrunaccDAO getBrunaccdao() {
		return brunaccdao;
	}

	public void setBrunaccdao(IBrunaccDAO brunaccdao) {
		this.brunaccdao = brunaccdao;
	}

	public void attachClean(Brunacc instance) {
		brunaccdao.attachClean(instance);
	}

	public void attachDirty(Brunacc instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Brunacc persistentInstance) {
		brunaccdao.delete(persistentInstance);
	}

	public List findAll() {
		List list = brunaccdao.findAll();
		return list;
	}

	public Brunacc findById(String id) {
		Brunacc brunacc = brunaccdao.findById(id);
		return brunacc;
	}

	public Brunacc merge(Brunacc detachedInstance) {
		Brunacc brunacc = brunaccdao.merge(detachedInstance);
		return brunacc;
	}

	public void save(Brunacc transientInstance) {
		brunaccdao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = brunaccdao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int startIndex) {
		PaginationSupport ps = brunaccdao.findPageByCriteria(detachedCriteria, startIndex);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex) {
		PaginationSupport ps = brunaccdao.findPageByCriteria(detachedCriteria, pageSize, startIndex);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = brunaccdao.getCountByCriteria(detachedCriteria);
		return count;
	}

}
