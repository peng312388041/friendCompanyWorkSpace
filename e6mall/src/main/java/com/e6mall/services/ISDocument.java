package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Document;

public interface ISDocument extends IBaseServices {
	// property constants
	public static final String TITLE = "title";
	public static final String BRIEF = "brief";
	public static final String CONTENT = "content";
	public static final String MARKER = "marker";
	public static final String VISTOR = "vistor";

	public abstract void save(Document transientInstance);

	public abstract void delete(Document persistentInstance);

	public abstract Document findById(java.lang.String id);

	public abstract List findAll();

	public abstract Document merge(Document detachedInstance);

	public abstract void attachDirty(Document instance);

	public abstract void attachClean(Document instance);
}
