package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Specitem;

public interface ISSpecitem extends IBaseServices {
	// property constants
	public static final String NAME = "name";
	public static final String REMARK = "remark";
	public static final String DTYPE = "dtype";
	public static final String DSTYLE = "dstyle";

	public abstract void save(Specitem transientInstance);

	public abstract void delete(Specitem persistentInstance);

	public abstract Specitem findById(java.lang.String id);

	public abstract List findAll();

	public abstract Specitem merge(Specitem detachedInstance);

	public abstract void attachDirty(Specitem instance);

	public abstract void attachClean(Specitem instance);
}
