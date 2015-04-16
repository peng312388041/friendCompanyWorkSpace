package com.e6mall.model;

import java.util.Set;

/**
 * Groups entity. @author bingzhou6@gmail.com
 */
public class Groups extends AbstractGroups implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Groups() {
	}

	/** minimal constructor */
	public Groups(String id, String name, String remarks) {
		super(id, name, remarks);
	}

	/** full constructor */
	public Groups(String id, String name, String remarks, Double discount,
			String isdefault, Integer requirepoints, Set members,
			Set permissions) {
		super(id, name, remarks, discount, isdefault, requirepoints, members, permissions);
	}

}
