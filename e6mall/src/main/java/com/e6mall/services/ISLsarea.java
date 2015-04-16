package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Lsarea;

public interface ISLsarea extends IBaseServices {
	// property constants
	public static final String NAME = "name";
	public static final String INTRO = "intro";
	public static final String WFIRST = "wfirst";
	public static final String WFCOST = "wfcost";
	public static final String WAPPEND = "wappend";
	public static final String WACOST = "wacost";
	public static final String COD = "cod";
	public static final String PREMIUMRATE = "premiumrate";
	public static final String STATUS = "status";

	public abstract void save(Lsarea transientInstance);

	public abstract void delete(Lsarea persistentInstance);

	public abstract Lsarea findById(java.lang.String id);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByWfirst(Object wfirst);

	public abstract List findByWfcost(Object wfcost);

	public abstract List findByWappend(Object wappend);

	public abstract List findByWacost(Object wacost);

	public abstract List findByCod(Object cod);

	public abstract List findByPremiumrate(Object premiumrate);

	public abstract List findByStatus(Object status);

	public abstract List findAll();

	public abstract Lsarea merge(Lsarea detachedInstance);

	public abstract void attachDirty(Lsarea instance);

	public abstract void attachClean(Lsarea instance);
}
