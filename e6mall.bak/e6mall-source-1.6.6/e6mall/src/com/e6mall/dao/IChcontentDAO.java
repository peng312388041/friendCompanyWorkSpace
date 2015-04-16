package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Chcontent;

public interface IChcontentDAO extends IBaseDAO {

	// property constants
	public static final String NUMBER = "number";
	public static final String OFFSET = "offset";
	public static final String MARKER = "marker";
	public static final String TYPE = "type";
	public static final String DETAIL = "detail";

	public abstract void save(Chcontent transientInstance);

	public abstract void delete(Chcontent persistentInstance);

	public abstract Chcontent findById(java.lang.String id);

	public abstract List findByExample(Chcontent instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByNumber(Object number);

	public abstract List findByOffset(Object offset);

	public abstract List findByMarker(Object marker);

	public abstract List findByType(Object type);

	public abstract List findByDetail(Object detail);

	public abstract List findAll();

	public abstract Chcontent merge(Chcontent detachedInstance);

	public abstract void attachDirty(Chcontent instance);

	public abstract void attachClean(Chcontent instance);

}