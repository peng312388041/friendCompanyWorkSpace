package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Eavalue;

public interface ISEavalue extends IBaseServices {
	// property constants
	public static final String VALUE = "value";
	public static final String CSORT = "csort";

	public abstract void save(Eavalue transientInstance);

	public abstract void delete(Eavalue persistentInstance);

	public abstract Eavalue findById(java.lang.String id);

	public abstract List findAll();

	public abstract Eavalue merge(Eavalue detachedInstance);

	public abstract void attachDirty(Eavalue instance);

	public abstract void attachClean(Eavalue instance);
}
