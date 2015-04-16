package com.e6mall.services;

import java.util.ArrayList;
import java.util.List;

import com.e6mall.model.Doccate;
import com.e6mall.model.Locale;

public interface ISDoccate extends IBaseServices {
	// property constants
	public static final String NODEPATH = "nodepath";
	public static final String NODETYPE = "nodetype";
	public static final String NAME = "name";
	public static final String DETAILS = "details";
	public static final String CSORT = "csort";
	public static final String MKEYWORDS = "mkeywords";
	public static final String MDESCRIPTION = "mdescription";
	
	public ArrayList<Doccate> findAllTree();

	public abstract void save(Doccate transientInstance);

	public abstract void delete(Doccate persistentInstance);

	public abstract Doccate findById(java.lang.String id);

	public abstract List findAll();
	
	public abstract List findAllRoot();
	
	public abstract List findAllRoot(Locale locale);

	public abstract Doccate merge(Doccate detachedInstance);

	public abstract void attachDirty(Doccate instance);

	public abstract void attachClean(Doccate instance);
}
