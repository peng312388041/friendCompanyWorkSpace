package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Attachment;

public interface ISAttachment extends IBaseServices {
	// property constants
	public static final String NAME = "name";
	public static final String FTYPE = "ftype";
	public static final String STATUS = "status";
	public static final String SORT = "sort";
	public static final String PATH = "path";
	public static final String ONAME = "oname";
	public static final String DETAILS = "details";
	
	public abstract List findAllTemplate();

	public abstract void save(Attachment transientInstance);
	
	public abstract void deleteNotFile(Attachment persistentInstance);

	public abstract void delete(Attachment persistentInstance);

	public abstract Attachment findById(java.lang.String id);

	public abstract List findAll();

	public abstract Attachment merge(Attachment detachedInstance);

	public abstract void attachDirty(Attachment instance);

	public abstract void attachClean(Attachment instance);
}
