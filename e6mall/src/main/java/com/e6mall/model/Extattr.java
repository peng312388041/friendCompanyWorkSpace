package com.e6mall.model;

import java.util.Set;

/**
 * Extattr entity. @author bingzhou6@gmail.com
 */
public class Extattr extends AbstractExtattr implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Extattr() {
	}

	/** minimal constructor */
	public Extattr(String id, String name, String viewtype,
			String display, Integer csort) {
		super(id, name, viewtype, display, csort);
	}

	/** full constructor */
	public Extattr(String id, String name, String alias,
			String viewtype, String display, Integer csort, Set eavalues, Set gstypes) {
		super(id, name, alias, viewtype, display, csort, eavalues, gstypes);
	}

}
