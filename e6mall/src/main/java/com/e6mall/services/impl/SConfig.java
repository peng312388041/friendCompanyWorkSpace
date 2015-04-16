package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;

import com.e6mall.dao.IConfigDAO;
import com.e6mall.model.Config;
import com.e6mall.services.ISConfig;
import com.e6mall.utils.PaginationSupport;

public class SConfig extends BaseServices implements ISConfig {
	private IConfigDAO configdao;

	public IConfigDAO getConfigdao() {
		return configdao;
	}

	public void setConfigdao(IConfigDAO configdao) {
		this.configdao = configdao;
	}

	public void attachClean(Config instance) {
		configdao.attachClean(instance);
	}

	public void attachDirty(Config instance) {
		configdao.attachDirty(instance);
	}

	public void delete(Config persistentInstance) {
		configdao.delete(persistentInstance);
	}

	public List findAll() {
		List list = configdao.findAll();
		return list;
	}
	
	public List findAllRoot() {
		DetachedCriteria dc = DetachedCriteria.forClass(Config.class);
		dc.add(Property.forName("config").isNull());
		dc.addOrder(Order.asc("config"));
		List list = configdao.findAllByCriteria(dc);
		return list;
	}

	public Config findById(String id) {
		Config config = configdao.findById(id);
		return config;
	}

	public Config findByProperty(Object property) {
		List list = configdao.findByProperty(property);
		Config config = null;
		if (list.size() > 0)
			config = (Config)list.get(0);
		return config;
	}

	public Config merge(Config detachedInstance) {
		Config config = configdao.merge(detachedInstance);
		return config;
	}

	public void save(Config transientInstance) {
		configdao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = configdao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = configdao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int page) {
		PaginationSupport ps = configdao.findPageByCriteria(detachedCriteria, page);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int page) {
		PaginationSupport ps = configdao.findPageByCriteria(detachedCriteria, pageSize, page);
		return ps;
	}

	public PaginationSupport findPageByIndex(DetachedCriteria detachedCriteria,
			int pageSize, int startIndex) {
		PaginationSupport ps = configdao.findPageByIndex(detachedCriteria, pageSize, startIndex);
		return ps;
	}
	
	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = configdao.getCountByCriteria(detachedCriteria);
		return count;
	}
}
