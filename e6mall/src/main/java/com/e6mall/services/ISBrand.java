package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Brand;

public interface ISBrand extends IBaseServices {
	// property constants
	public static final String NAME = "name";
	public static final String URL = "url";
	public static final String CSORT = "csort";

	public abstract void save(Brand transientInstance);

	public abstract void delete(Brand persistentInstance);

	public abstract Brand findById(java.lang.String id);
	
	public abstract Brand findByName(java.lang.String name);

	public abstract List findAll();

	public abstract Brand merge(Brand detachedInstance);

	public abstract void attachDirty(Brand instance);

	public abstract void attachClean(Brand instance);
}
