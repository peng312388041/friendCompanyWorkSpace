package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Orders;

public interface IOrdersDAO extends IBaseDAO {

	// property constants
	public static final String CODE = "code";
	public static final String STATUS = "status";
	public static final String LOGICOST = "logicost";
	public static final String BAOJIA = "baojia";
	public static final String WEIGHT = "weight";
	public static final String INVOICETITLE = "invoicetitle";
	public static final String DUTY = "duty";
	public static final String DISCOUNT = "discount";

	public abstract void save(Orders transientInstance);

	public abstract void delete(Orders persistentInstance);

	public abstract Orders findById(java.lang.String id);

	public abstract List findByExample(Orders instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCode(Object code);

	public abstract List findByStatus(Object status);

	public abstract List findByLogicost(Object logicost);

	public abstract List findByBaojia(Object baojia);

	public abstract List findByWeight(Object weight);

	public abstract List findByInvoicetitle(Object invoicetitle);

	public abstract List findByDuty(Object duty);

	public abstract List findByDiscount(Object discount);

	public abstract List findAll();

	public abstract Orders merge(Orders detachedInstance);

	public abstract void attachDirty(Orders instance);

	public abstract void attachClean(Orders instance);

}