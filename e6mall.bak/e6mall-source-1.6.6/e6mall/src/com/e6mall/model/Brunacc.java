package com.e6mall.model;

import java.sql.Timestamp;

/**
 * Brunacc entity. @author bingzhou6@gmail.com
 */
public class Brunacc extends AbstractBrunacc implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Brunacc() {
	}

	/** minimal constructor */
	public Brunacc(String id, Bank bank, String status, Double balance,
			String tabloid, Timestamp ctime) {
		super(id, bank, status, balance, tabloid, ctime);
	}

	/** full constructor */
	public Brunacc(String id, Bank bank, Member member, Manager manager, Paymode paymode,
			String status, Double balance, Double getout, Double payin,
			String tabloid, String remarks, String mremarks, Timestamp ctime) {
		super(id, bank, member, manager, paymode, status, balance, getout, payin,
				tabloid, remarks, mremarks, ctime);
	}

}
