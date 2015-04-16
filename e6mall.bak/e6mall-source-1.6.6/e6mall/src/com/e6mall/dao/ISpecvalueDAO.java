package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Specvalue;

public interface ISpecvalueDAO extends IBaseDAO {

	// property constants
	public static final String NAME = "name";

	public abstract void save(Specvalue transientInstance);

	public abstract void delete(Specvalue persistentInstance);

	public abstract Specvalue findById(java.lang.String id);

	public abstract List findByExample(Specvalue instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findAll();

	public abstract Specvalue merge(Specvalue detachedInstance);

	public abstract void attachDirty(Specvalue instance);

	public abstract void attachClean(Specvalue instance);

}