package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Gstype;

public interface ISGstype extends IBaseServices {
	// property constants
	public static final String NAME = "name";
	public static final String ALIAS = "alias";

	public abstract void save(Gstype transientInstance);

	public abstract void delete(Gstype persistentInstance);

	public abstract Gstype findById(java.lang.String id);

	public abstract List findAll();

	public abstract Gstype merge(Gstype detachedInstance);

	public abstract void attachDirty(Gstype instance);

	public abstract void attachClean(Gstype instance);
}
