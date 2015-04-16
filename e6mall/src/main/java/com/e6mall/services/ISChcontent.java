package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Chcontent;
import com.e6mall.model.Locale;

public interface ISChcontent extends IBaseServices {
	// property constants
	public static final String NUMBER = "number";
	public static final String OFFSET = "offset";
	public static final String MARKER = "marker";
	public static final String TYPE = "type";
	public static final String DETAIL = "detail";

	public abstract void save(Chcontent transientInstance);

	public abstract void delete(Chcontent persistentInstance);

	public abstract Chcontent findById(java.lang.String id);

	public abstract List findAll();
	
	public abstract List findAllGlobal();
	
	public abstract List findAllGlobal(Locale locale);

	public abstract Chcontent merge(Chcontent detachedInstance);

	public abstract void attachDirty(Chcontent instance);

	public abstract void attachClean(Chcontent instance);
}
