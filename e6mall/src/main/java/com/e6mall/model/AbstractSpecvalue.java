package com.e6mall.model;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractSpecvalue entity provides the base persistence definition of the
 * Specvalue entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractSpecvalue implements java.io.Serializable {

	// Fields

	private String id;
	private Specitem specitem;
	private Attachment image;
	private Attachment vimage;//页面显示
	private String name;
	private Set specs = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractSpecvalue() {
	}

	/** minimal constructor */
	public AbstractSpecvalue(String id, Specitem specitem, String name) {
		this.id = id;
		this.specitem = specitem;
		this.name = name;
	}

	/** full constructor */
	public AbstractSpecvalue(String id, Specitem specitem,
			Attachment image, String name, Set specs) {
		this.id = id;
		this.specitem = specitem;
		this.image = image;
		this.name = name;
		this.specs = specs;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Specitem getSpecitem() {
		return this.specitem;
	}

	public void setSpecitem(Specitem specitem) {
		this.specitem = specitem;
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

	public Set getSpecs() {
		return this.specs;
	}

	public void setSpecs(Set specs) {
		this.specs = specs;
	}

}