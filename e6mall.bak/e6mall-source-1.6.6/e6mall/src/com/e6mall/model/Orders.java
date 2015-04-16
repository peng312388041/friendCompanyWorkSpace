package com.e6mall.model;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Orders entity. @author bingzhou6@gmail.com
 */
public class Orders extends AbstractOrders implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(String id, Member member, Paymode paymode,
			Staddress staddress, Lsarea lsarea, String code, String subject, String body, String status,
			Timestamp ctime, Double amount, Double logicost, Double paycost, Double baojia, Double weight,
			String invoicetitle, Double duty, Double discount, Double actamount) {
		super(id, member, paymode, staddress, lsarea, code, subject, body, status, ctime, amount, 
				logicost, paycost, baojia, weight, invoicetitle, duty, discount, actamount);
	}

	/** full constructor */
	public Orders(String id, Member member, Paymode paymode,
			Staddress staddress, Lsarea lsarea, String code, String subject, String body, String status, String status_brief,
			Timestamp ctime, Double amount, Double logicost, Double paycost, Double baojia, Double weight,
			String invoicetitle, Double duty, Double discount, Double actamount, Set evaluates,
			Set orderitems) {
		super(id, member, paymode, staddress, lsarea, code, subject, body, status, status_brief, ctime, amount, 
				logicost, paycost, baojia, weight, invoicetitle, duty, discount, actamount, 
				evaluates, orderitems);
	}

}
