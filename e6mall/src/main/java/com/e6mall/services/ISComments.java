package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Comments;

public interface ISComments extends IBaseServices {
	// property constants
	public static final String TITLE = "title";
	public static final String CONTENT = "content";
	public static final String STATUS = "status";

	public abstract void save(Comments transientInstance);

	public abstract void delete(Comments persistentInstance);

	public abstract Comments findById(java.lang.String id);

	public abstract List findByStatus(Object status);

	public abstract List findAll();

	public abstract Comments merge(Comments detachedInstance);

	public abstract void attachDirty(Comments instance);

	public abstract void attachClean(Comments instance);
}
