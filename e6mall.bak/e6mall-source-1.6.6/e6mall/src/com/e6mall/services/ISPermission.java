package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Permission;

public interface ISPermission extends IBaseServices {
	// property constants
	public static final String NAME = "name";
	public static final String CODE = "code";
	public static final String READ = "read";
	public static final String WRITE = "write";
	public static final String DELETE = "delete";

	public abstract void save(Permission transientInstance);

	public abstract void delete(Permission persistentInstance);

	public abstract Permission findById(java.lang.String id);

	public abstract List findByCode(Object code);

	public abstract List findAll();
	
	public abstract List findAllRoot();

	public abstract Permission merge(Permission detachedInstance);

	public abstract void attachDirty(Permission instance);

	public abstract void attachClean(Permission instance);
}
