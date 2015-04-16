package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Config;

public interface IConfigDAO extends IBaseDAO {

	// property constants
	public static final String NAME = "name";
	public static final String PROPERTY = "property";
	public static final String VALUE = "value";
	public static final String CONTENT = "content";

	public abstract void save(Config transientInstance);

	public abstract void delete(Config persistentInstance);

	public abstract Config findById(java.lang.String id);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByProperty(Object property);

	public abstract List findAll();

	public abstract Config merge(Config detachedInstance);

	public abstract void attachDirty(Config instance);

	public abstract void attachClean(Config instance);

}