package com.e6mall.model;

import java.util.Set;

/**
 * Paymode entity. @author bingzhou6@gmail.com
 */
public class Paymode extends AbstractPaymode implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Paymode() {
	}

	/** minimal constructor */
	public Paymode(String id, String name, Double rate, Integer csort) {
		super(id, name, rate, csort);
	}

	/** full constructor */
	public Paymode(String id, Attachment image, String pmtype, String name, String intro, Double rate, Double focrating,
			Integer csort, Set orderses, Set settings, Set brunaccs) {
		super(id, image, pmtype, name, intro, rate, focrating, csort, orderses, settings, brunaccs);
	}

}
