package com.e6mall.model;

/**
 * Setting entity. @author bingzhou6@gmail.com
 */
public class Setting extends AbstractSetting implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Setting() {
	}

	/** full constructor */
	public Setting(String id, Paymode paymode, String name, String property, String value, String pmtype) {
		super(id, paymode, name, property, value, pmtype);
	}

}
