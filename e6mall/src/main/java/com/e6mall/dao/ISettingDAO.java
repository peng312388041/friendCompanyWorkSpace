package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Setting;

public interface ISettingDAO extends IBaseDAO {

	// property constants
	public static final String NAME = "name";
	public static final String PROPERTY = "property";
	public static final String VALUE = "value";
	public static final String PERSS = "perss";

	public abstract void save(Setting transientInstance);

	public abstract void delete(Setting persistentInstance);

	public abstract Setting findById(java.lang.String id);

	public abstract List findByExample(Setting instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByProperty(Object property);

	public abstract List findByValue(Object value);

	public abstract List findByPerss(Object perss);

	public abstract List findAll();

	public abstract Setting merge(Setting detachedInstance);

	public abstract void attachDirty(Setting instance);

	public abstract void attachClean(Setting instance);

}