package com.e6mall.model;

import java.util.Set;

/**
 * Specitem entity. @author bingzhou6@gmail.com
 */
public class Specitem extends AbstractSpecitem implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Specitem() {
	}

	/** minimal constructor */
	public Specitem(String id, String name, String dtype, String dstyle) {
		super(id, name, dtype, dstyle);
	}

	/** full constructor */
	public Specitem(String id, String name, String remark, String dtype,
			String dstyle, Set specvalues, Set gstypes) {
		super(id, name, remark, dtype, dstyle, specvalues, gstypes);
	}

}
