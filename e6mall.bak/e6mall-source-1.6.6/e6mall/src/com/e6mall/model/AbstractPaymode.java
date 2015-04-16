package com.e6mall.model;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractPaymode entity provides the base persistence definition of the
 * Paymode entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractPaymode implements java.io.Serializable {

	// Fields

	private String id;
	private Attachment image;
	private Attachment vimage;//页面显示
	private String pmtype;
	private String name;
	private String intro;
	private Double rate;
	private Double focrating;
	private Integer csort;
	private Set orderses = new HashSet(0);
	private Set settings = new HashSet(0);
	private Set brunaccs = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractPaymode() {
	}

	/** minimal constructor */
	public AbstractPaymode(String id, String name, Double rate, Integer csort) {
		this.id = id;
		this.name = name;
		this.rate = rate;
		this.csort = csort;
	}

	/** full constructor */
	public AbstractPaymode(String id, Attachment image, String pmtype, String name, String intro, Double rate, Double focrating,
			Integer csort, Set orderses, Set settings, Set brunaccs) {
		this.id = id;
		this.image = image;
		this.pmtype = pmtype;
		this.name = name;
		this.intro = intro;
		this.rate = rate;
		this.focrating = focrating;
		this.csort = csort;
		this.orderses = orderses;
		this.settings = settings;
		this.brunaccs = brunaccs;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Attachment getImage() {
		return image;
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

	public String getPmtype() {
		return pmtype;
	}

	public void setPmtype(String pmtype) {
		this.pmtype = pmtype;
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

	public Double getRate() {
		return this.rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Double getFocrating() {
		return focrating;
	}

	public void setFocrating(Double focrating) {
		this.focrating = focrating;
	}

	public Integer getCsort() {
		return this.csort;
	}

	public void setCsort(Integer csort) {
		this.csort = csort;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

	public Set getSettings() {
		return settings;
	}

	public void setSettings(Set settings) {
		this.settings = settings;
	}

	public Set getBrunaccs() {
		return brunaccs;
	}

	public void setBrunaccs(Set brunaccs) {
		this.brunaccs = brunaccs;
	}
}