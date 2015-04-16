package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Document;

public interface IDocumentDAO extends IBaseDAO {

	// property constants
	public static final String TITLE = "title";
	public static final String BRIEF = "brief";
	public static final String CONTENT = "content";
	public static final String MARKER = "marker";
	public static final String VISTOR = "vistor";

	public abstract void save(Document transientInstance);

	public abstract void delete(Document persistentInstance);

	public abstract Document findById(java.lang.String id);

	public abstract List findByExample(Document instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByTitle(Object title);

	public abstract List findByBrief(Object brief);

	public abstract List findByContent(Object content);

	public abstract List findByMarker(Object marker);

	public abstract List findByVistor(Object vistor);

	public abstract List findAll();

	public abstract Document merge(Document detachedInstance);

	public abstract void attachDirty(Document instance);

	public abstract void attachClean(Document instance);

}