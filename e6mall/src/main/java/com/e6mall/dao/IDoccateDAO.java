package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Doccate;

public interface IDoccateDAO extends IBaseDAO {

	// property constants
	public static final String NODEPATH = "nodepath";
	public static final String NODETYPE = "nodetype";
	public static final String NAME = "name";
	public static final String DETAILS = "details";
	public static final String CSORT = "csort";
	public static final String MKEYWORDS = "mkeywords";
	public static final String MDESCRIPTION = "mdescription";

	public abstract void save(Doccate transientInstance);

	public abstract void delete(Doccate persistentInstance);

	public abstract Doccate findById(java.lang.String id);

	public abstract List findByExample(Doccate instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByNodepath(Object nodepath);

	public abstract List findByNodetype(Object nodetype);

	public abstract List findByName(Object name);

	public abstract List findByDetails(Object details);

	public abstract List findByCsort(Object csort);

	public abstract List findByMkeywords(Object mkeywords);

	public abstract List findByMdescription(Object mdescription);

	public abstract List findAll();

	public abstract Doccate merge(Doccate detachedInstance);

	public abstract void attachDirty(Doccate instance);

	public abstract void attachClean(Doccate instance);

}