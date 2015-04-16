package com.e6mall.model;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractEavalue entity provides the base persistence definition of the
 * Eavalue entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractEavalue implements java.io.Serializable {

	// Fields

	private String id;
	private Extattr extattr;
	private String value;
	private Integer csort;
	private Set goodses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractEavalue() {
	}

	/** minimal constructor */
	public AbstractEavalue(String id, Extattr extattr, String value,
			Integer csort) {
		this.id = id;
		this.extattr = extattr;
		this.value = value;
		this.csort = csort;
	}

	/** full constructor */
	public AbstractEavalue(String id, Extattr extattr, String value,
			Integer csort, Set goodses) {
		this.id = id;
		this.extattr = extattr;
		this.value = value;
		this.csort = csort;
		this.goodses = goodses;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Extattr getExtattr() {
		return this.extattr;
	}

	public void setExtattr(Extattr extattr) {
		this.extattr = extattr;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getCsort() {
		return this.csort;
	}

	public void setCsort(Integer csort) {
		this.csort = csort;
	}

	public Set getGoodses() {
		return this.goodses;
	}

	public void setGoodses(Set goodses) {
		this.goodses = goodses;
	}

}