package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Evaluate;

public interface IEvaluateDAO extends IBaseDAO {

	// property constants
	public static final String ETYPE = "etype";
	public static final String POSITIVE = "positive";
	public static final String NEUTRAL = "neutral";
	public static final String NEGATIVE = "negative";

	public abstract void save(Evaluate transientInstance);

	public abstract void delete(Evaluate persistentInstance);

	public abstract Evaluate findById(java.lang.String id);

	public abstract List findByExample(Evaluate instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByEtype(Object etype);

	public abstract List findByPositive(Object positive);

	public abstract List findByNeutral(Object neutral);

	public abstract List findByNegative(Object negative);

	public abstract List findAll();

	public abstract Evaluate merge(Evaluate detachedInstance);

	public abstract void attachDirty(Evaluate instance);

	public abstract void attachClean(Evaluate instance);

}