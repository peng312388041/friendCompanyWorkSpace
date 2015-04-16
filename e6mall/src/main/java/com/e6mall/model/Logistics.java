package com.e6mall.model;

import java.util.Set;

/**
 * Logistics entity. @author bingzhou6@gmail.com
 */
public class Logistics extends AbstractLogistics implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Logistics() {
	}

	/** minimal constructor */
	public Logistics(String id, String name, Integer csort) {
		super(id, name, csort);
	}

	/** full constructor */
	public Logistics(String id, Attachment image, String name,
			String intro, String url, String pourl, Integer csort,
			Set lsareas) {
		super(id, image, name, intro, url, pourl, csort, lsareas);
	}

}
