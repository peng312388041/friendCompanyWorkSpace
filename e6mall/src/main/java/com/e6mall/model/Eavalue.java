package com.e6mall.model;

import java.util.Set;

/**
 * Eavalue entity. @author bingzhou6@gmail.com
 */
public class Eavalue extends AbstractEavalue implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Eavalue() {
	}

	/** minimal constructor */
	public Eavalue(String id, Extattr extattr, String value, Integer csort) {
		super(id, extattr, value, csort);
	}

	/** full constructor */
	public Eavalue(String id, Extattr extattr, String value, Integer csort,
			Set goodses) {
		super(id, extattr, value, csort, goodses);
	}

}
