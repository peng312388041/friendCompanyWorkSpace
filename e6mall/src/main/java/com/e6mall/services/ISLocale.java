package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Locale;

public interface ISLocale extends IBaseServices {
	// property constants
	public static final String NAME = "name";

	public abstract void save(Locale transientInstance);

	public abstract void delete(Locale persistentInstance);

	public abstract Locale findById(java.lang.String id);

	public abstract List findAll();

	public abstract Locale merge(Locale detachedInstance);

	public abstract void attachDirty(Locale instance);

	public abstract void attachClean(Locale instance);
}
