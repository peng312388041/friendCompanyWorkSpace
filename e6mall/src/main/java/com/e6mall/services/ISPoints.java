package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Points;

public interface ISPoints extends IBaseServices {
	// property constants
	public static final String ACCOUNT = "account";
	public static final String STATUS = "status";
	public static final String BALANCE = "balance";
	public static final String REMARKS = "remarks";

	public abstract void save(Points transientInstance);

	public abstract void delete(Points persistentInstance);
	
	public abstract Points openaccount();

	public abstract Points findById(java.lang.String id);

	public abstract List findAll();

	public abstract Points merge(Points detachedInstance);

	public abstract void attachDirty(Points instance);

	public abstract void attachClean(Points instance);
}
