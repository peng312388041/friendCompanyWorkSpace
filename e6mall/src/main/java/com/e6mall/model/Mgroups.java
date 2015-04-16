package com.e6mall.model;

import java.util.Set;

/**
 * Mgroups entity. @author bingzhou6@gmail.com
 */
public class Mgroups extends AbstractMgroups implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Mgroups() {
	}

	/** minimal constructor */
	public Mgroups(String id, String name, String remarks) {
		super(id, name, remarks);
	}

	/** full constructor */
	public Mgroups(String id, String name, String remarks, Set permissions,
			Set managers) {
		super(id, name, remarks, permissions, managers);
	}

}
