package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Mgroups;

public interface IMgroupsDAO extends IBaseDAO {

	// property constants
	public static final String NAME = "name";
	public static final String REMARKS = "remarks";

	public abstract void save(Mgroups transientInstance);

	public abstract void delete(Mgroups persistentInstance);

	public abstract Mgroups findById(java.lang.String id);

	public abstract List findByExample(Mgroups instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByRemarks(Object remarks);

	public abstract List findAll();

	public abstract Mgroups merge(Mgroups detachedInstance);

	public abstract void attachDirty(Mgroups instance);

	public abstract void attachClean(Mgroups instance);

}