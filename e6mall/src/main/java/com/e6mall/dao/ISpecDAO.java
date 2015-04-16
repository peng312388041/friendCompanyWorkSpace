package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Spec;

public interface ISpecDAO extends IBaseDAO {

	// property constants
	public static final String GSCODE = "gscode";
	public static final String INVENTORY = "inventory";
	public static final String PRICE = "price";
	public static final String CPRICE = "cprice";

	public abstract void save(Spec transientInstance);

	public abstract void delete(Spec persistentInstance);

	public abstract Spec findById(java.lang.String id);

	public abstract List findByExample(Spec instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByGscode(Object gscode);

	public abstract List findByInventory(Object inventory);

	public abstract List findByPrice(Object price);

	public abstract List findByCprice(Object cprice);

	public abstract List findAll();

	public abstract Spec merge(Spec detachedInstance);

	public abstract void attachDirty(Spec instance);

	public abstract void attachClean(Spec instance);

}