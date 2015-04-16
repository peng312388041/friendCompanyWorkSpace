package com.e6mall.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

/**
 * AbstractConfig entity provides the base persistence definition of the Config
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractConfig implements java.io.Serializable {

	// Fields

	private String id;
	private Config config;
	private String name;
	private String property;
	private String value;
	private String vtype;
	private String defaultvalue;
	private String optional;
	private String content;
	private Timestamp utime;
	private Set configs = new HashSet(0);
	
	private String[] optionals;

	// Constructors

	/** default constructor */
	public AbstractConfig() {
	}

	/** minimal constructor */
	public AbstractConfig(String id, Config config, String name,
			String property, String value, String content, Timestamp utime) {
		this.id = id;
		this.config = config;
		this.name = name;
		this.property = property;
		this.value = value;
		this.content = content;
		this.utime = utime;
	}

	/** full constructor */
	public AbstractConfig(String id, Config config, String name,
			String property, String value, String vtype, String defaultvalue, String optional, String content, Timestamp utime,
			Set configs) {
		this.id = id;
		this.config = config;
		this.name = name;
		this.property = property;
		this.value = value;
		this.vtype = vtype;
		this.defaultvalue = defaultvalue;
		this.optional = optional;
		this.content = content;
		this.utime = utime;
		this.configs = configs;
	}

	// Property accessors

	public String[] getOptionals() {
		if (StringUtils.isNotEmpty(optional))
			optionals = optional.split("[|]");
		return optionals;
	}

	public void setOptionals(String[] optionals) {
		this.optionals = optionals;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Config getConfig() {
		return this.config;
	}

	public void setConfig(Config config) {
		this.config = config;
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

	public String getVtype() {
		return vtype;
	}

	public void setVtype(String vtype) {
		this.vtype = vtype;
	}

	public String getDefaultvalue() {
		return defaultvalue;
	}

	public void setDefaultvalue(String defaultvalue) {
		this.defaultvalue = defaultvalue;
	}

	public String getOptional() {
		return optional;
	}

	public void setOptional(String optional) {
		this.optional = optional;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getUtime() {
		return this.utime;
	}

	public void setUtime(Timestamp utime) {
		this.utime = utime;
	}

	public Set getConfigs() {
		return this.configs;
	}

	public void setConfigs(Set configs) {
		this.configs = configs;
	}

}