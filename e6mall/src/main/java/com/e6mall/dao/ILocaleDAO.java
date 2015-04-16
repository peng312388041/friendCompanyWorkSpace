package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Locale;

public interface ILocaleDAO extends IBaseDAO {

	// property constants
	public static final String NAME = "name";

	public abstract void save(Locale transientInstance);

	public abstract void delete(Locale persistentInstance);

	public abstract Locale findById(java.lang.String id);

	public abstract List findByExample(Locale instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findAll();

	public abstract Locale merge(Locale detachedInstance);

	public abstract void attachDirty(Locale instance);

	public abstract void attachClean(Locale instance);

}