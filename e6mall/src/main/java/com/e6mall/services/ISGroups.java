package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Groups;

public interface ISGroups extends IBaseServices {
	// property constants
	public static final String NAME = "name";
	public static final String REMARKS = "remarks";

	public abstract void save(Groups transientInstance);

	public abstract void delete(String id);

	public abstract Groups findById(java.lang.String id);

	public abstract List findAll();

	public abstract Groups merge(Groups detachedInstance);

	public abstract void attachDirty(Groups instance);

	public abstract void attachClean(Groups instance);
}
