package com.e6mall.model;

import java.sql.Timestamp;

/**
 * Prunacc entity. @author bingzhou6@gmail.com
 */
public class Prunacc extends AbstractPrunacc implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Prunacc() {
	}

	/** minimal constructor */
	public Prunacc(String id, Points points, String status, Integer balance,
			String tabloid, Timestamp ctime) {
		super(id, points, status, balance, tabloid, ctime);
	}

	/** full constructor */
	public Prunacc(String id, Member member, Manager manager, Points points,
			String status, Integer balance, Integer getout, Integer payin,
			String tabloid, String remarks, Timestamp ctime) {
		super(id, member, manager, points, status, balance, getout, payin,
				tabloid, remarks, ctime);
	}

}
