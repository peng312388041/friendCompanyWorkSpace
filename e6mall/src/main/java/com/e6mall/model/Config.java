package com.e6mall.model;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Config entity. @author MyEclipse Persistence Tools
 */
public class Config extends AbstractConfig implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Config() {
	}

	/** minimal constructor */
	public Config(String id, Config config, String name, String property,
			String value, String content, Timestamp utime) {
		super(id, config, name, property, value, content, utime);
	}

	/** full constructor */
	public Config(String id, Config config, String name, String property,
			String value, String vtype, String defaultvalue, String optional, String content, Timestamp utime, Set configs) {
		super(id, config, name, property, value, vtype, defaultvalue, optional, content, utime, configs);
	}

}
