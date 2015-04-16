package com.e6mall.model;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractStaddress entity provides the base persistence definition of the
 * Staddress entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractStaddress implements java.io.Serializable {

	// Fields

	private String id;
	private Member member;
	private District district;
	private String address;
	private String postcode;
	private String name;
	private String telephone;
	private String mobile;
	private String status;
	private Set orderses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractStaddress() {
	}

	/** minimal constructor */
	public AbstractStaddress(String id, String address, String postcode,
			String name, String status) {
		this.id = id;
		this.address = address;
		this.postcode = postcode;
		this.name = name;
		this.status = status;
	}

	/** full constructor */
	public AbstractStaddress(String id, Member member, District district, String address, String postcode,
			String name, String telephone, String mobile, String status,
			Set orderses) {
		this.id = id;
		this.member = member;
		this.district = district;
		this.address = address;
		this.postcode = postcode;
		this.name = name;
		this.telephone = telephone;
		this.mobile = mobile;
		this.status = status;
		this.orderses = orderses;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		if (null != status) {
			this.status = status;
		} else {
			this.status = "normal";
		}
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

}