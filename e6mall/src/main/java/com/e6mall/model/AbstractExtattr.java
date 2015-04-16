package com.e6mall.model;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractExtattr entity provides the base persistence definition of the
 * Extattr entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractExtattr implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String alias;
	private String viewtype;
	private String display;
	private Integer csort;
	private Set eavalues = new HashSet(0);
	private Set gstypes = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractExtattr() {
	}

	/** minimal constructor */
	public AbstractExtattr(String id, String name,
			String viewtype, String display, Integer csort) {
		this.id = id;
		this.name = name;
		this.viewtype = viewtype;
		this.display = display;
		this.csort = csort;
	}

	/** full constructor */
	public AbstractExtattr(String id, String name, String alias,
			String viewtype, String display, Integer csort, Set eavalues, Set gstypes) {
		this.id = id;
		this.name = name;
		this.alias = alias;
		this.viewtype = viewtype;
		this.display = display;
		this.csort = csort;
		this.eavalues = eavalues;
		this.gstypes = gstypes;
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

	public String getViewtype() {
		return this.viewtype;
	}

	public void setViewtype(String viewtype) {
		this.viewtype = viewtype;
	}

	public String getDisplay() {
		return this.display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public Integer getCsort() {
		return this.csort;
	}

	public void setCsort(Integer csort) {
		this.csort = csort;
	}

	public Set getEavalues() {
		return this.eavalues;
	}

	public void setEavalues(Set eavalues) {
		this.eavalues = eavalues;
	}

	public Set getGstypes() {
		return gstypes;
	}

	public void setGstypes(Set gstypes) {
		this.gstypes = gstypes;
	}
}