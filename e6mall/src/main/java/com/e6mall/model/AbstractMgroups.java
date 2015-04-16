package com.e6mall.model;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractMgroups entity provides the base persistence definition of the
 * Mgroups entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractMgroups implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String remarks;
	private Set permissions = new HashSet(0);
	private Set managers = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractMgroups() {
	}

	/** minimal constructor */
	public AbstractMgroups(String id, String name, String remarks) {
		this.id = id;
		this.name = name;
		this.remarks = remarks;
	}

	/** full constructor */
	public AbstractMgroups(String id, String name, String remarks,
			Set permissions, Set managers) {
		this.id = id;
		this.name = name;
		this.remarks = remarks;
		this.permissions = permissions;
		this.managers = managers;
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

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Set getPermissions() {
		return permissions;
	}

	public void setPermissions(Set permissions) {
		this.permissions = permissions;
	}

	public Set getManagers() {
		return this.managers;
	}

	public void setManagers(Set managers) {
		this.managers = managers;
	}

}