package com.e6mall.model;

/**
 * AbstractSetting entity provides the base persistence definition of the
 * Setting entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractSetting implements java.io.Serializable {

	// Fields

	private String id;
	private Paymode paymode;
	private String name;
	private String property;
	private String value;
	private String pmtype;

	// Constructors

	/** default constructor */
	public AbstractSetting() {
	}

	/** full constructor */
	public AbstractSetting(String id, Paymode paymode, String name, String property,
			String value, String pmtype) {
		this.id = id;
		this.paymode = paymode;
		this.name = name;
		this.property = property;
		this.value = value;
		this.pmtype = pmtype;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Paymode getPaymode() {
		return paymode;
	}

	public void setPaymode(Paymode paymode) {
		this.paymode = paymode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPmtype() {
		return pmtype;
	}

	public void setPmtype(String pmtype) {
		this.pmtype = pmtype;
	}
}