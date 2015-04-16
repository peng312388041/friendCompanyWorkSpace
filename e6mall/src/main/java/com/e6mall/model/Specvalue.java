package com.e6mall.model;

import java.util.Set;

/**
 * Specvalue entity. @author bingzhou6@gmail.com
 */
public class Specvalue extends AbstractSpecvalue implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Specvalue() {
	}

	/** minimal constructor */
	public Specvalue(String id, Specitem specitem, String name) {
		super(id, specitem, name);
	}

	/** full constructor */
	public Specvalue(String id, Specitem specitem, Attachment image,
			String name, Set specs) {
		super(id, specitem, image, name, specs);
	}

}
