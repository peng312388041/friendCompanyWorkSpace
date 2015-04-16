package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Orders;

public interface ISOrders extends IBaseServices {
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
	
	public abstract Orders findByCode(Object code);

	public abstract List findAll();

	public abstract Orders merge(Orders detachedInstance);

	public abstract void attachDirty(Orders instance);

	public abstract void attachClean(Orders instance);
}
