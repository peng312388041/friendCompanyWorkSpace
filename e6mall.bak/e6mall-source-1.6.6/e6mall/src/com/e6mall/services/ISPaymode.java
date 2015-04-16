package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Paymode;

public interface ISPaymode extends IBaseServices {
	// property constants
	public static final String NAME = "name";
	public static final String INTRO = "intro";
	public static final String RATE = "rate";
	public static final String CSORT = "csort";

	public abstract void save(Paymode transientInstance);

	public abstract void delete(Paymode persistentInstance);

	public abstract Paymode findById(java.lang.String id);

	public abstract List findAll();

	public abstract Paymode merge(Paymode detachedInstance);

	public abstract void attachDirty(Paymode instance);

	public abstract void attachClean(Paymode instance);
}
