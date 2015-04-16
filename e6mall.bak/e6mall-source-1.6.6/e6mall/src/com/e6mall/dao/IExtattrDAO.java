package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Extattr;

public interface IExtattrDAO extends IBaseDAO {

	// property constants
	public static final String NAME = "name";
	public static final String ALIAS = "alias";
	public static final String VIEWTYPE = "viewtype";
	public static final String DISPLAY = "display";
	public static final String CSORT = "csort";

	public abstract void save(Extattr transientInstance);

	public abstract void delete(Extattr persistentInstance);

	public abstract Extattr findById(java.lang.String id);

	public abstract List findByExample(Extattr instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByAlias(Object alias);

	public abstract List findByViewtype(Object viewtype);

	public abstract List findByDisplay(Object display);

	public abstract List findByCsort(Object csort);

	public abstract List findAll();

	public abstract Extattr merge(Extattr detachedInstance);

	public abstract void attachDirty(Extattr instance);

	public abstract void attachClean(Extattr instance);

}