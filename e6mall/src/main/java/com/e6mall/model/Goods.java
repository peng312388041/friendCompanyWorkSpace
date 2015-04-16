package com.e6mall.model;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Goods entity. @author bingzhou6@gmail.com
 */
public class Goods extends AbstractGoods implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** minimal constructor */
	public Goods(String id, Manager manager, Gstype gstype, String name,
			String details, String promote, Timestamp ctime, String status,
			Integer csort) {
		super(id, manager, gstype, name, details, promote, ctime, status, csort);
	}

	/** full constructor */
	public Goods(String id, Manager manager, Gstype gstype, Locale locale,
			Category category, Brand brand, String name, String sn,
			String barcode, String keywords, String intro, String details,
			Double price, Double mprice, Double cprice, Double weight, String freeshipping, Integer points,
			Integer inventory, String promote, Timestamp ctime,
			Timestamp utime, String status, Integer csort, String mkeywords, Integer vistor,
			String mdescription, Set specs, Set attachments, Set commentses, Set eavalues,
			Set orderitems, Set chcontents) {
		super(id, manager, gstype, locale, category, brand, name, sn, barcode,
				keywords, intro, details, price, mprice, cprice, weight, freeshipping, points,
				inventory, promote, ctime, utime, status, csort, mkeywords,
				mdescription, vistor, specs, attachments, commentses, eavalues, orderitems, chcontents);
	}

}
