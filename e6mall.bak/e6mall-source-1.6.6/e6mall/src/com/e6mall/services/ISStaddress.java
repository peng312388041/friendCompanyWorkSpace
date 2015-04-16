package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Staddress;

public interface ISStaddress extends IBaseServices {
	// property constants
	public static final String ADDRESS = "address";
	public static final String POSTCODE = "postcode";
	public static final String NAME = "name";
	public static final String TELEPHONE = "telephone";
	public static final String MOBILE = "mobile";
	public static final String STATUS = "status";

	public abstract void save(Staddress transientInstance);

	public abstract void delete(Staddress persistentInstance);

	public abstract Staddress findById(java.lang.String id);

	public abstract List findAll();

	public abstract Staddress merge(Staddress detachedInstance);

	public abstract void attachDirty(Staddress instance);

	public abstract void attachClean(Staddress instance);
}
