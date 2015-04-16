package com.e6mall.model;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractGroups entity provides the base persistence definition of the Groups
 * entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractGroups implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String remarks;
	private Double discount;
	private String isdefault;
	private Integer requirepoints;
	private Set members = new HashSet(0);
	private Set permissions = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractGroups() {
	}

	/** minimal constructor */
	public AbstractGroups(String id, String name, String remarks) {
		this.id = id;
		this.name = name;
		this.remarks = remarks;
	}

	/** full constructor */
	public AbstractGroups(String id, String name, String remarks, Double discount,
			String isdefault, Integer requirepoints, Set members,
			Set permissions) {
		this.id = id;
		this.name = name;
		this.remarks = remarks;
		this.discount = discount;
		this.isdefault = isdefault;
		this.requirepoints = requirepoints;
		this.members = members;
		this.permissions = permissions;
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

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}

	public Integer getRequirepoints() {
		return requirepoints;
	}

	public void setRequirepoints(Integer requirepoints) {
		this.requirepoints = requirepoints;
	}

	public Set getMembers() {
		return this.members;
	}

	public void setMembers(Set members) {
		this.members = members;
	}

	public Set getPermissions() {
		return permissions;
	}

	public void setPermissions(Set permissions) {
		this.permissions = permissions;
	}
}