package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Logistics;

public interface ISLogistics extends IBaseServices {
	// property constants
	public static final String NAME = "name";
	public static final String INTRO = "intro";
	public static final String URL = "url";
	public static final String POURL = "pourl";
	public static final String CSORT = "csort";

	public abstract void save(Logistics transientInstance);

	public abstract void delete(Logistics persistentInstance);

	public abstract Logistics findById(java.lang.String id);

	public abstract List findAll();

	public abstract Logistics merge(Logistics detachedInstance);

	public abstract void attachDirty(Logistics instance);

	public abstract void attachClean(Logistics instance);
}
