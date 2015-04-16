package com.e6mall.model;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Points entity. @author bingzhou6@gmail.com
 */
public class Points extends AbstractPoints implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Points() {
	}

	/** minimal constructor */
	public Points(String id, String account, String status, Integer balance,
			Timestamp ctime) {
		super(id, account, status, balance, ctime);
	}

	/** full constructor */
	public Points(String id, String account, String status, Integer balance,
			String remarks, Timestamp ctime, Set prunaccs, Set members) {
		super(id, account, status, balance, remarks, ctime, prunaccs, members);
	}

}
