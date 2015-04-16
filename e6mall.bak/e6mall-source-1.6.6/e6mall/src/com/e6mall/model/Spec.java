package com.e6mall.model;

import java.util.Set;

/**
 * Spec entity. @author bingzhou6@gmail.com
 */
public class Spec extends AbstractSpec implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Spec() {
	}

	/** minimal constructor */
	public Spec(String id, Goods goods, String gscode, Integer inventory,
			Double price) {
		super(id, goods, gscode, inventory, price);
	}

	/** full constructor */
	public Spec(String id, Goods goods, String gscode, Integer inventory,
			Double price, Double cprice, Double weight, Set specvalues) {
		super(id, goods, gscode, inventory, price, cprice, weight, specvalues);
	}

}
