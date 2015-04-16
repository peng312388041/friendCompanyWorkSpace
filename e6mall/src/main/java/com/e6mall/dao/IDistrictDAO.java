package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.District;

public interface IDistrictDAO extends IBaseDAO {

	// property constants
	public static final String NAME = "name";

	public abstract void save(District transientInstance);

	public abstract void delete(District persistentInstance);

	public abstract District findById(java.lang.Integer id);

	public abstract List findByExample(District instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findAll();

	public abstract District merge(District detachedInstance);

	public abstract void attachDirty(District instance);

	public abstract void attachClean(District instance);

}