package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Bank;

public interface IBankDAO extends IBaseDAO {

	// property constants
	public static final String ACCOUNT = "account";
	public static final String STATUS = "status";
	public static final String BALANCE = "balance";
	public static final String REMARKS = "remarks";

	public abstract void save(Bank transientInstance);

	public abstract void delete(Bank persistentInstance);

	public abstract Bank findById(java.lang.String id);

	public abstract List findByExample(Bank instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByAccount(Object account);

	public abstract List findByStatus(Object status);

	public abstract List findByBalance(Object balance);

	public abstract List findByRemarks(Object remarks);

	public abstract List findAll();

	public abstract Bank merge(Bank detachedInstance);

	public abstract void attachDirty(Bank instance);

	public abstract void attachClean(Bank instance);

}