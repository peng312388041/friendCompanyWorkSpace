package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Goods;

public interface ISGoods extends IBaseServices {
	// property constants
	public static final String NAME = "name";
	public static final String SN = "sn";
	public static final String BARCODE = "barcode";
	public static final String KEYWORDS = "keywords";
	public static final String INTRO = "intro";
	public static final String DETAILS = "details";
	public static final String PRICE = "price";
	public static final String MPRICE = "mprice";
	public static final String CPRICE = "cprice";
	public static final String POINTS = "points";
	public static final String INVENTORY = "inventory";
	public static final String PROMOTE = "promote";
	public static final String STATUS = "status";
	public static final String CSORT = "csort";
	public static final String MKEYWORDS = "mkeywords";
	public static final String MDESCRIPTION = "mdescription";

	public abstract void save(Goods transientInstance);

	public abstract void delete(Goods persistentInstance);

	public abstract Goods findById(java.lang.String id);

	public abstract List findAll();

	public abstract Goods merge(Goods detachedInstance);

	public abstract void attachDirty(Goods instance);

	public abstract void attachClean(Goods instance);
}
