package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Brand;

public interface IBrandDAO extends IBaseDAO {

	// property constants
	public static final String NAME = "name";
	public static final String URL = "url";
	public static final String CSORT = "csort";

	public abstract void save(Brand transientInstance);

	public abstract void delete(Brand persistentInstance);

	public abstract Brand findById(java.lang.String id);

	public abstract List findByExample(Brand instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByUrl(Object url);

	public abstract List findByCsort(Object csort);

	public abstract List findAll();

	public abstract Brand merge(Brand detachedInstance);

	public abstract void attachDirty(Brand instance);

	public abstract void attachClean(Brand instance);

}