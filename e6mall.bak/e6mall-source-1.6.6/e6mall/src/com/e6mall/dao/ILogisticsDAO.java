package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Logistics;

public interface ILogisticsDAO extends IBaseDAO {

	// property constants
	public static final String NAME = "name";
	public static final String INTRO = "intro";
	public static final String URL = "url";
	public static final String POURL = "pourl";
	public static final String CSORT = "csort";

	public abstract void save(Logistics transientInstance);

	public abstract void delete(Logistics persistentInstance);

	public abstract Logistics findById(java.lang.String id);

	public abstract List findByExample(Logistics instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByIntro(Object intro);

	public abstract List findByUrl(Object url);

	public abstract List findByPourl(Object pourl);

	public abstract List findByCsort(Object csort);

	public abstract List findAll();

	public abstract Logistics merge(Logistics detachedInstance);

	public abstract void attachDirty(Logistics instance);

	public abstract void attachClean(Logistics instance);

}