package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.e6mall.dao.IChcontentDAO;
import com.e6mall.model.Chcontent;
import com.e6mall.model.Locale;
import com.e6mall.services.ISChcontent;

public class SChcontent extends BaseServices implements ISChcontent {
	private IChcontentDAO chcontentdao;

	public IChcontentDAO getChcontentdao() {
		return chcontentdao;
	}

	public void setChcontentdao(IChcontentDAO chcontentdao) {
		this.chcontentdao = chcontentdao;
	}

	public void attachClean(Chcontent instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Chcontent instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Chcontent persistentInstance) {
		chcontentdao.delete(persistentInstance);
	}

	public List findAll() {
		List list = chcontentdao.findAll();
		return list;
	}
	
	public List findAllGlobal() {
		DetachedCriteria dc = DetachedCriteria.forClass(Chcontent.class);
		dc.add(Property.forName("global").eq("yes"));
		List list = chcontentdao.findAllByCriteria(dc);
		return list;
	}
	
	public List findAllGlobal(Locale locale) {
		DetachedCriteria dc = DetachedCriteria.forClass(Chcontent.class);
		dc.add(Property.forName("locale").eq(locale));
		dc.add(Property.forName("global").eq("yes"));
		List list = chcontentdao.findAllByCriteria(dc);
		return list;
	}

	public Chcontent findById(String id) {
		Chcontent chcontent = chcontentdao.findById(id);
		return chcontent;
	}

	public Chcontent merge(Chcontent detachedInstance) {
		Chcontent chcontent = chcontentdao.merge(detachedInstance);
		return chcontent;
	}

	public void save(Chcontent transientInstance) {
		chcontentdao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = chcontentdao.findAllByCriteria(detachedCriteria);
		return list;
	}
}
