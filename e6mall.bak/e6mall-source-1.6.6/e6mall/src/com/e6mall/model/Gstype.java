package com.e6mall.model;

import java.util.Set;

/**
 * Gstype entity. @author bingzhou6@gmail.com
 */
public class Gstype extends AbstractGstype implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Gstype() {
	}

	/** minimal constructor */
	public Gstype(String id, String name) {
		super(id, name);
	}

	/** full constructor */
	public Gstype(String id, String name, String alias, Set brands,
			Set specitems, Set categories, Set goodses, Set extattrs) {
		super(id, name, alias, brands, specitems, categories, goodses, extattrs);
	}

}
