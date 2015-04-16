package com.e6mall.model;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Bank entity. @author bingzhou6@gmail.com
 */
public class Bank extends AbstractBank implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Bank() {
	}

	/** minimal constructor */
	public Bank(String id, String account, String status, Double balance,
			Timestamp ctime) {
		super(id, account, status, balance, ctime);
	}

	/** full constructor */
	public Bank(String id, String account, String status, Double balance,
			String remarks, Timestamp ctime, Set brunaccs, Set members) {
		super(id, account, status, balance, remarks, ctime, brunaccs, members);
	}

}
