package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.e6mall.dao.ISettingDAO;
import com.e6mall.model.Setting;
import com.e6mall.services.ISSetting;
import com.e6mall.utils.PaginationSupport;

public class SSetting extends BaseServices implements ISSetting {
	private ISettingDAO settingdao;

	public ISettingDAO getSettingdao() {
		return settingdao;
	}

	public void setSettingdao(ISettingDAO settingdao) {
		this.settingdao = settingdao;
	}

	public void attachClean(Setting instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Setting instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Setting persistentInstance) {
		settingdao.delete(persistentInstance);
	}

	public List findAll() {
		List list = settingdao.findAll();
		return list;
	}
	
	public List findAllRoot(String pmtype) {
		DetachedCriteria dc = DetachedCriteria.forClass(Setting.class);
		dc.add(Property.forName("paymode").isNull());
		dc.add(Property.forName("pmtype").eq(pmtype));
		List list = settingdao.findAllByCriteria(dc);
		return list;
	}

	public Setting findById(String id) {
		Setting setting = settingdao.findById(id);
		return setting;
	}

	public Setting findByProperty(Object property) {
		List list = settingdao.findByProperty(property);
		if (list.size() > 0)
			return (Setting)list.get(0);
		else
			return null;
	}

	public Setting merge(Setting detachedInstance) {
		Setting setting = settingdao.merge(detachedInstance);
		return setting;
	}

	public void save(Setting transientInstance) {
		settingdao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = settingdao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = settingdao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int startIndex) {
		PaginationSupport ps = settingdao.findPageByCriteria(detachedCriteria, startIndex);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex) {
		PaginationSupport ps = settingdao.findPageByCriteria(detachedCriteria, pageSize, startIndex);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = settingdao.getCountByCriteria(detachedCriteria);
		return count;
	}

}
