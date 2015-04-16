package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Mgroups;

public interface ISMgroups extends IBaseServices {
	// property constants
	public static final String NAME = "name";
	public static final String REMARKS = "remarks";

	public abstract void save(Mgroups transientInstance);

	public abstract void delete(String id);

	public abstract Mgroups findById(java.lang.String id);

	public abstract List findAll();

	public abstract Mgroups merge(Mgroups detachedInstance);

	public abstract void attachDirty(Mgroups instance);

	public abstract void attachClean(Mgroups instance);
}
