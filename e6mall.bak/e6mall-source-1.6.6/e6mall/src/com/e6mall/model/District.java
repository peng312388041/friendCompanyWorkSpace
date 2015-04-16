package com.e6mall.model;

import java.util.Set;

/**
 * District entity. @author MyEclipse Persistence Tools
 */
public class District extends AbstractDistrict implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public District() {
	}

	/** minimal constructor */
	public District(Integer id, String name) {
		super(id, name);
	}

	/** full constructor */
	public District(Integer id, District district, String name, Set lsareas,
			Set districts, Set staddresses) {
		super(id, district, name, lsareas, districts, staddresses);
	}

}
