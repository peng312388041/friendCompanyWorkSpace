package com.e6mall.model;

import java.util.Set;

/**
 * Lsarea entity. @author MyEclipse Persistence Tools
 */
public class Lsarea extends AbstractLsarea implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Lsarea() {
	}

	/** minimal constructor */
	public Lsarea(String id, Logistics logistics, String name, Integer wfirst,
			Double wfcost, Integer wappend, Double wacost, String cod,
			Double premiumrate) {
		super(id, logistics, name, wfirst, wfcost, wappend, wacost, cod,
				premiumrate);
	}

	/** full constructor */
	public Lsarea(String id, Logistics logistics, String name, String intro,
			Integer wfirst, Double wfcost, Integer wappend, Double wacost,
			String cod, Double premiumrate, String status, Set districts,
			Set orderses) {
		super(id, logistics, name, intro, wfirst, wfcost, wappend, wacost, cod,
				premiumrate, status, districts, orderses);
	}

}
