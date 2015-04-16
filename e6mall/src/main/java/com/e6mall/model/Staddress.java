package com.e6mall.model;

import java.util.Set;

/**
 * Staddress entity. @author bingzhou6@gmail.com
 */
public class Staddress extends AbstractStaddress implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Staddress() {
	}

	/** minimal constructor */
	public Staddress(String id, String address, String postcode, String name,
			String status) {
		super(id, address, postcode, name, status);
	}

	/** full constructor */
	public Staddress(String id, Member member, District district, String address, String postcode, String name,
			String telephone, String mobile, String status, Set orderses) {
		super(id, member, district, address, postcode, name, telephone, mobile, status, orderses);
	}

}
