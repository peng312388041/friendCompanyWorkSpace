package com.e6mall.services;

import java.util.List;

import com.e6mall.model.District;

public interface ISDistrict extends IBaseServices {
	// property constants
	public static final String NAME = "name";

	public abstract void save(District transientInstance);

	public abstract void delete(District persistentInstance);

	public abstract District findById(java.lang.Integer id);

	public abstract List findAll();
	
	public abstract List findAllRoot();

	public abstract District merge(District detachedInstance);

	public abstract void attachDirty(District instance);

	public abstract void attachClean(District instance);
}
