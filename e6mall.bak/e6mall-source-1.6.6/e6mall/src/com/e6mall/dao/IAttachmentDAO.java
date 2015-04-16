package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Attachment;

public interface IAttachmentDAO extends IBaseDAO {

	// property constants
	public static final String NAME = "name";
	public static final String FTYPE = "ftype";
	public static final String STATUS = "status";
	public static final String SORT = "sort";
	public static final String PATH = "path";
	public static final String ONAME = "oname";
	public static final String DETAILS = "details";

	public abstract void save(Attachment transientInstance);

	public abstract void delete(Attachment persistentInstance);

	public abstract Attachment findById(java.lang.String id);

	public abstract List findByExample(Attachment instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByFtype(Object ftype);

	public abstract List findByStatus(Object status);

	public abstract List findBySort(Object sort);

	public abstract List findByPath(Object path);

	public abstract List findByOname(Object oname);

	public abstract List findByDetails(Object details);

	public abstract List findAll();

	public abstract Attachment merge(Attachment detachedInstance);

	public abstract void attachDirty(Attachment instance);

	public abstract void attachClean(Attachment instance);

}