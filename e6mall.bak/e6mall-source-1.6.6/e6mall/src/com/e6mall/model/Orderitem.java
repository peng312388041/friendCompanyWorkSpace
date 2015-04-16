package com.e6mall.model;

import java.sql.Timestamp;

/**
 * Orderitem entity. @author bingzhou6@gmail.com
 */
public class Orderitem extends AbstractOrderitem implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Orderitem() {
	}

	/** minimal constructor */
	public Orderitem(String id, Member member, Goods goods, Double unitprice,
			Integer number, Double subtotal, String ispay, String status,
			Timestamp ctime) {
		super(id, member, goods, unitprice, number, subtotal, ispay, status,
				ctime);
	}

	/** full constructor */
	public Orderitem(String id, Member member, Orders orders, Goods goods,
			Spec spec, Double unitprice, Integer number,
			Double subtotal, Double actsum, Double discount, String ispay,
			String status, Timestamp paytime, Timestamp exptime,
			Timestamp utime, Timestamp ctime) {
		super(id, member, orders, goods, spec, unitprice, number,
				subtotal, actsum, discount, ispay, status, paytime, exptime,
				utime, ctime);
	}

}
