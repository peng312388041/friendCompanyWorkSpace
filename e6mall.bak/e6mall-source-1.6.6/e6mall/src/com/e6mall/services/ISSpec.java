package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Spec;

public interface ISSpec extends IBaseServices {
	// property constants
	public static final String GSCODE = "gscode";
	public static final String INVENTORY = "inventory";
	public static final String PRICE = "price";
	public static final String CPRICE = "cprice";

	public abstract void save(Spec transientInstance);

	public abstract void delete(Spec persistentInstance);

	public abstract Spec findById(java.lang.String id);

	public abstract List findAll();

	public abstract Spec merge(Spec detachedInstance);

	public abstract void attachDirty(Spec instance);

	public abstract void attachClean(Spec instance);
}
