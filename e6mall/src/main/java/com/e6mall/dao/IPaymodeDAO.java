package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Paymode;

public interface IPaymodeDAO extends IBaseDAO {

	// property constants
	public static final String NAME = "name";
	public static final String INTRO = "intro";
	public static final String RATE = "rate";
	public static final String CSORT = "csort";

	public abstract void save(Paymode transientInstance);

	public abstract void delete(Paymode persistentInstance);

	public abstract Paymode findById(java.lang.String id);

	public abstract List findByExample(Paymode instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByIntro(Object intro);

	public abstract List findByRate(Object rate);

	public abstract List findByCsort(Object csort);

	public abstract List findAll();

	public abstract Paymode merge(Paymode detachedInstance);

	public abstract void attachDirty(Paymode instance);

	public abstract void attachClean(Paymode instance);

}