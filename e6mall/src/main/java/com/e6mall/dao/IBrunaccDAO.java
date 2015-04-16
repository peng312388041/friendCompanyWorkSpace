package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Brunacc;

public interface IBrunaccDAO extends IBaseDAO {

	// property constants
	public static final String STATUS = "status";
	public static final String BALANCE = "balance";
	public static final String GETOUT = "getout";
	public static final String PAYIN = "payin";
	public static final String TABLOID = "tabloid";
	public static final String REMARKS = "remarks";

	public abstract void save(Brunacc transientInstance);

	public abstract void delete(Brunacc persistentInstance);

	public abstract Brunacc findById(java.lang.String id);

	public abstract List findByExample(Brunacc instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByStatus(Object status);

	public abstract List findByBalance(Object balance);

	public abstract List findByGetout(Object getout);

	public abstract List findByPayin(Object payin);

	public abstract List findByTabloid(Object tabloid);

	public abstract List findByRemarks(Object remarks);

	public abstract List findAll();

	public abstract Brunacc merge(Brunacc detachedInstance);

	public abstract void attachDirty(Brunacc instance);

	public abstract void attachClean(Brunacc instance);

}