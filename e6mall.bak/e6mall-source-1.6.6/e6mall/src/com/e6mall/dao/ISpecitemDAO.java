package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Specitem;

public interface ISpecitemDAO extends IBaseDAO {

	// property constants
	public static final String NAME = "name";
	public static final String REMARK = "remark";
	public static final String DTYPE = "dtype";
	public static final String DSTYLE = "dstyle";

	public abstract void save(Specitem transientInstance);

	public abstract void delete(Specitem persistentInstance);

	public abstract Specitem findById(java.lang.String id);

	public abstract List findByExample(Specitem instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByRemark(Object remark);

	public abstract List findByDtype(Object dtype);

	public abstract List findByDstyle(Object dstyle);

	public abstract List findAll();

	public abstract Specitem merge(Specitem detachedInstance);

	public abstract void attachDirty(Specitem instance);

	public abstract void attachClean(Specitem instance);

}