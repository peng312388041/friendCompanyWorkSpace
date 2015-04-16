package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Bank;

public interface ISBank extends IBaseServices {
	// property constants
	public static final String ACCOUNT = "account";
	public static final String STATUS = "status";
	public static final String BALANCE = "balance";
	public static final String REMARKS = "remarks";
	
	public abstract Bank openaccount();

	public abstract void save(Bank transientInstance);

	public abstract void delete(Bank persistentInstance);

	public abstract Bank findById(java.lang.String id);

	public abstract List findAll();

	public abstract Bank merge(Bank detachedInstance);

	public abstract void attachDirty(Bank instance);

	public abstract void attachClean(Bank instance);
}
