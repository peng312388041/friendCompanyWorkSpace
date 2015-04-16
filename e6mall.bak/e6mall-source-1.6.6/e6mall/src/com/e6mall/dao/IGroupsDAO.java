package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Groups;

public interface IGroupsDAO extends IBaseDAO {

	// property constants
	public static final String NAME = "name";
	public static final String REMARKS = "remarks";

	public abstract void save(Groups transientInstance);

	public abstract void delete(Groups persistentInstance);

	public abstract Groups findById(java.lang.String id);

	public abstract List findByExample(Groups instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByRemarks(Object remarks);

	public abstract List findAll();

	public abstract Groups merge(Groups detachedInstance);

	public abstract void attachDirty(Groups instance);

	public abstract void attachClean(Groups instance);

}