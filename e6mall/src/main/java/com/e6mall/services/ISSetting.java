package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Setting;

public interface ISSetting extends IBaseServices {
	// property constants
	public static final String NAME = "name";
	public static final String PROPERTY = "property";
	public static final String VALUE = "value";
	public static final String PERSS = "perss";

	public abstract void save(Setting transientInstance);

	public abstract void delete(Setting persistentInstance);

	public abstract Setting findById(java.lang.String id);
	
	public abstract Setting findByProperty(Object property);

	public abstract List findAll();
	
	public abstract List findAllRoot(String pmtype);

	public abstract Setting merge(Setting detachedInstance);

	public abstract void attachDirty(Setting instance);

	public abstract void attachClean(Setting instance);
}
