package com.e6mall.model;

import java.util.Set;

/**
 * Brand entity. @author bingzhou6@gmail.com
 */
public class Brand extends AbstractBrand implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Brand() {
	}

	/** minimal constructor */
	public Brand(String id, String name, Integer csort) {
		super(id, name, csort);
	}

	/** full constructor */
	public Brand(String id, String name, String alias, Attachment logo, String url, Integer csort, String intro,
			Set gstypes, Set goodses) {
		super(id, name, alias, logo, url, csort, intro, gstypes, goodses);
	}

}
