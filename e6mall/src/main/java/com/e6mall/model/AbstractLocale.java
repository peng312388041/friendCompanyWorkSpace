package com.e6mall.model;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractLocale entity provides the base persistence definition of the Locale
 * entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractLocale implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private Set goodses = new HashSet(0);
	private Set categories = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractLocale() {
	}

	/** minimal constructor */
	public AbstractLocale(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public AbstractLocale(String id, String name, Set goodses, Set categories) {
		this.id = id;
		this.name = name;
		this.goodses = goodses;
		this.categories = categories;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getGoodses() {
		return this.goodses;
	}

	public void setGoodses(Set goodses) {
		this.goodses = goodses;
	}

	public Set getCategories() {
		return this.categories;
	}

	public void setCategories(Set categories) {
		this.categories = categories;
	}

}