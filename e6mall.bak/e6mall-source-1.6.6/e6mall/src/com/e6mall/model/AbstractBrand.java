package com.e6mall.model;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractBrand entity provides the base persistence definition of the Brand
 * entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractBrand implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String alias;
	private Attachment logo;
	private Attachment vlogo;//页面显示
	private String url;
	private Integer csort;
	private String intro;
	private Set gstypes = new HashSet(0);
	private Set goodses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractBrand() {
	}

	/** minimal constructor */
	public AbstractBrand(String id, String name, Integer csort) {
		this.id = id;
		this.name = name;
		this.csort = csort;
	}

	/** full constructor */
	public AbstractBrand(String id, String name, String alias, Attachment logo, String url, Integer csort, String intro,
			Set gstypes, Set goodses) {
		this.id = id;
		this.name = name;
		this.alias = alias;
		this.logo = logo;
		this.url = url;
		this.csort = csort;
		this.intro = intro;
		this.gstypes = gstypes;
		this.goodses = goodses;
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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Attachment getLogo() {
		return this.logo;
	}

	public void setLogo(Attachment logo) {
		this.logo = logo;
	}

	public Attachment getVlogo() {
		if (null != logo) {
			return logo;
		} else {
			Attachment i = new Attachment();
			i.setPath("/images/sys");
			i.setName("nopic.jpg");
			return i;
		}
	}

	public void setVlogo(Attachment vlogo) {
		this.vlogo = vlogo;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getCsort() {
		return this.csort;
	}

	public void setCsort(Integer csort) {
		this.csort = csort;
	}
	
	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Set getGstypes() {
		return this.gstypes;
	}

	public void setGstypes(Set gstypes) {
		this.gstypes = gstypes;
	}

	public Set getGoodses() {
		return this.goodses;
	}

	public void setGoodses(Set goodses) {
		this.goodses = goodses;
	}
}