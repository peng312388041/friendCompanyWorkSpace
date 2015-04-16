package com.e6mall.model;

import java.util.Set;

/**
 * Locale entity. @author bingzhou6@gmail.com
 */
public class Locale extends AbstractLocale implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Locale() {
	}

	/** minimal constructor */
	public Locale(String id, String name) {
		super(id, name);
	}

	/** full constructor */
	public Locale(String id, String name, Set goodses, Set categories) {
		super(id, name, goodses, categories);
	}

}
