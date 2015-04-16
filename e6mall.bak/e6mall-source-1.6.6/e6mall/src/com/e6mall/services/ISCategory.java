package com.e6mall.services;

import java.util.ArrayList;
import java.util.List;

import com.e6mall.model.Category;
import com.e6mall.model.Locale;

public interface ISCategory extends IBaseServices {
	// property constants
	public static final String NODEPATH = "nodepath";
	public static final String NODETYPE = "nodetype";
	public static final String NAME = "name";
	public static final String DETAILS = "details";
	public static final String CSORT = "csort";
	public static final String MKEYWORDS = "mkeywords";
	public static final String MDESCRIPTION = "mdescription";
	
	public abstract ArrayList<Category> findAllTree();
	
	public abstract ArrayList<Category> findAllTree(Locale locale);

	public abstract void save(Category transientInstance);

	public abstract void delete(Category persistentInstance);

	public abstract Category findById(java.lang.String id);

	public abstract List findAll();
	
	public abstract List findAllRoot();
	
	public abstract List findAllRoot(Locale locale);

	public abstract Category merge(Category detachedInstance);
	
	public abstract void attachDirty(Category instance);

	public abstract void attachClean(Category instance);
}
