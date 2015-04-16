package com.e6mall.services.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.services.IBaseServices;
import com.e6mall.utils.PaginationSupport;

public class BaseServices implements IBaseServices {
	protected Map session;
	
	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public Timestamp getTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	public PaginationSupport findPageByIndex(DetachedCriteria detachedCriteria,
			int pageSize, int startIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return 0;
	}
}
