package com.e6mall.services;

import java.util.Date;
import java.util.List;

import com.e6mall.model.Brunacc;

public interface ISBrunacc extends IBaseServices {
	// property constants
	public static final String STATUS = "status";
	public static final String BALANCE = "balance";
	public static final String GETOUT = "getout";
	public static final String PAYIN = "payin";
	public static final String TABLOID = "tabloid";
	public static final String REMARKS = "remarks";
	
	public abstract Double getTotalBalance(Date min, Date max);

	public abstract void save(Brunacc transientInstance);

	public abstract void delete(Brunacc persistentInstance);

	public abstract Brunacc findById(java.lang.String id);

	public abstract List findAll();

	public abstract Brunacc merge(Brunacc detachedInstance);

	public abstract void attachDirty(Brunacc instance);

	public abstract void attachClean(Brunacc instance);
}
