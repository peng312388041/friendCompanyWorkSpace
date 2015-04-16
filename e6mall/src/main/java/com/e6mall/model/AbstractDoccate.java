package com.e6mall.model;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractDoccate entity provides the base persistence definition of the
 * Doccate entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractDoccate implements java.io.Serializable {

	// Fields

	private String id;
	private Attachment image;
	private Attachment vimage;//页面显示
	private Locale locale;
	private Doccate doccate;
	private String nodepath;
	private String nodetype;
	private String name;
	private String details;
	private Integer csort;
	private String mkeywords;
	private String mdescription;
	private Set documents = new HashSet(0);
	private Set doccates = new HashSet(0);
	private Set chcontents = new HashSet(0);
	
	private String nodestr;//非数据库字段

	// Constructors

	/** default constructor */
	public AbstractDoccate() {
	}

	/** minimal constructor */
	public AbstractDoccate(String id, String nodepath, String nodetype,
			String name, Integer csort) {
		this.id = id;
		this.nodepath = nodepath;
		this.nodetype = nodetype;
		this.name = name;
		this.csort = csort;
	}

	/** full constructor */
	public AbstractDoccate(String id, Attachment image, Locale locale,
			Doccate doccate, String nodepath, String nodetype, String name,
			String details, Integer csort, String mkeywords,
			String mdescription, Set documents, Set doccates, Set chcontents, String nodestr) {
		this.id = id;
		this.image = image;
		this.locale = locale;
		this.doccate = doccate;
		this.nodepath = nodepath;
		this.nodetype = nodetype;
		this.name = name;
		this.details = details;
		this.csort = csort;
		this.mkeywords = mkeywords;
		this.mdescription = mdescription;
		this.documents = documents;
		this.doccates = doccates;
		this.chcontents = chcontents;
		this.nodestr = nodestr;
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

	public Locale getLocale() {
		return this.locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public Doccate getDoccate() {
		return this.doccate;
	}

	public void setDoccate(Doccate doccate) {
		this.doccate = doccate;
	}

	public String getNodepath() {
		return this.nodepath;
	}

	public void setNodepath(String nodepath) {
		this.nodepath = nodepath;
	}

	public String getNodetype() {
		return this.nodetype;
	}

	public void setNodetype(String nodetype) {
		this.nodetype = nodetype;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getCsort() {
		return this.csort;
	}

	public void setCsort(Integer csort) {
		this.csort = csort;
	}

	public String getMkeywords() {
		return this.mkeywords;
	}

	public void setMkeywords(String mkeywords) {
		this.mkeywords = mkeywords;
	}

	public String getMdescription() {
		return this.mdescription;
	}

	public void setMdescription(String mdescription) {
		this.mdescription = mdescription;
	}

	public Set getDocuments() {
		return this.documents;
	}

	public void setDocuments(Set documents) {
		this.documents = documents;
	}

	public Set getDoccates() {
		return this.doccates;
	}

	public void setDoccates(Set doccates) {
		this.doccates = doccates;
	}

	public Set getChcontents() {
		return this.chcontents;
	}

	public void setChcontents(Set chcontents) {
		this.chcontents = chcontents;
	}

	public String getNodestr() {
		return nodestr;
	}

	public void setNodestr(String nodestr) {
		this.nodestr = nodestr;
	}

}