package com.e6mall.model;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractGstype entity provides the base persistence definition of the Gstype
 * entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractGstype implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String alias;
	private Set brands = new HashSet(0);
	private Set specitems = new HashSet(0);
	private Set categories = new HashSet(0);
	private Set goodses = new HashSet(0);
	private Set extattrs = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractGstype() {
	}

	/** minimal constructor */
	public AbstractGstype(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public AbstractGstype(String id, String name, String alias, Set brands,
			Set specitems, Set categories, Set goodses, Set extattrs) {
		this.id = id;
		this.name = name;
		this.alias = alias;
		this.brands = brands;
		this.specitems = specitems;
		this.categories = categories;
		this.goodses = goodses;
		this.extattrs = extattrs;
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

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Set getBrands() {
		return this.brands;
	}

	public void setBrands(Set brands) {
		this.brands = brands;
	}

	public Set getSpecitems() {
		return this.specitems;
	}

	public void setSpecitems(Set specitems) {
		this.specitems = specitems;
	}

	public Set getCategories() {
		return this.categories;
	}

	public void setCategories(Set categories) {
		this.categories = categories;
	}

	public Set getGoodses() {
		return this.goodses;
	}

	public void setGoodses(Set goodses) {
		this.goodses = goodses;
	}

	public Set getExtattrs() {
		return this.extattrs;
	}

	public void setExtattrs(Set extattrs) {
		this.extattrs = extattrs;
	}

}