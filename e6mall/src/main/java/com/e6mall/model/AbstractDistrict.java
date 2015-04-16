package com.e6mall.model;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * AbstractDistrict entity provides the base persistence definition of the
 * District entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractDistrict implements java.io.Serializable {

	// Fields

	private Integer id;
	private District district;
	private String name;
	private Set lsareas = new HashSet(0);
	private Set districts = new HashSet(0);
	private Set staddresses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractDistrict() {
	}

	/** minimal constructor */
	public AbstractDistrict(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public AbstractDistrict(Integer id, District district, String name,
			Set lsareas, Set districts, Set staddresses) {
		this.id = id;
		this.district = district;
		this.name = name;
		this.lsareas = lsareas;
		this.districts = districts;
		this.staddresses = staddresses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JSON(serialize=false)
	public District getDistrict() {
		return this.district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JSON(serialize=false)
	public Set getLsareas() {
		return this.lsareas;
	}

	public void setLsareas(Set lsareas) {
		this.lsareas = lsareas;
	}

	@JSON(serialize=false)
	public Set getDistricts() {
		return this.districts;
	}

	public void setDistricts(Set districts) {
		this.districts = districts;
	}

	@JSON(serialize=false)
	public Set getStaddresses() {
		return this.staddresses;
	}

	public void setStaddresses(Set staddresses) {
		this.staddresses = staddresses;
	}
}