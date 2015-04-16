package com.e6mall.model;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractLogistics entity provides the base persistence definition of the
 * Logistics entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractLogistics implements java.io.Serializable {

	// Fields

	private String id;
	private Attachment image;
	private Attachment vimage;//页面显示
	private String name;
	private String intro;
	private String url;
	private String pourl;
	private Integer csort;
	private Set lsareas = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractLogistics() {
	}

	/** minimal constructor */
	public AbstractLogistics(String id, String name, Integer csort) {
		this.id = id;
		this.name = name;
		this.csort = csort;
	}

	/** full constructor */
	public AbstractLogistics(String id, Attachment image, String name,
			String intro, String url, String pourl, Integer csort,
			Set lsareas) {
		this.id = id;
		this.image = image;
		this.name = name;
		this.intro = intro;
		this.url = url;
		this.pourl = pourl;
		this.csort = csort;
		this.lsareas = lsareas;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Attachment getImage() {
		return this.image;
	}

	public void setImage(Attachment image) {
		this.image = image;
	}
	
	public Attachment getVimage() {
		if (null != image) {
			return image;
		} else {
			Attachment i = new Attachment();
			i.setPath("/images/sys");
			i.setName("nopic.jpg");
			return i;
		}
	}

	public void setVimage(Attachment vimage) {
		this.vimage = vimage;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPourl() {
		return this.pourl;
	}

	public void setPourl(String pourl) {
		this.pourl = pourl;
	}

	public Integer getCsort() {
		return this.csort;
	}

	public void setCsort(Integer csort) {
		this.csort = csort;
	}

	public Set getLsareas() {
		return lsareas;
	}

	public void setLsareas(Set lsareas) {
		this.lsareas = lsareas;
	}
}