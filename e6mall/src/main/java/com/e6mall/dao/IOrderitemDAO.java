package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Orderitem;

public interface IOrderitemDAO extends IBaseDAO {

	// property constants
	public static final String SPECREMARK = "specremark";
	public static final String UNITPRICE = "unitprice";
	public static final String AMOUNT = "amount";
	public static final String LUMPSUM = "lumpsum";
	public static final String ACTSUM = "actsum";
	public static final String DISCOUNT = "discount";
	public static final String ISPAY = "ispay";
	public static final String STATUS = "status";

	public abstract void save(Orderitem transientInstance);

	public abstract void delete(Orderitem persistentInstance);

	public abstract Orderitem findById(java.lang.String id);

	public abstract List findByExample(Orderitem instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findBySpecremark(Object specremark);

	public abstract List findByUnitprice(Object unitprice);

	public abstract List findByAmount(Object amount);

	public abstract List findByLumpsum(Object lumpsum);

	public abstract List findByActsum(Object actsum);

	public abstract List findByDiscount(Object discount);

	public abstract List findByIspay(Object ispay);

	public abstract List findByStatus(Object status);

	public abstract List findAll();

	public abstract Orderitem merge(Orderitem detachedInstance);

	public abstract void attachDirty(Orderitem instance);

	public abstract void attachClean(Orderitem instance);

}