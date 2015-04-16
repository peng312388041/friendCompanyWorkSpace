package com.e6mall.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractChannel entity provides the base persistence definition of the
 * Channel entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractChannel implements java.io.Serializable {

	// Fields

	private String id;
	private Manager manager;
	private Attachment template;
	private Attachment vtemplate;
	private String title;
	private String intro;
	private Timestamp cdate;
	private Set chcontents = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractChannel() {
	}

	/** minimal constructor */
	public AbstractChannel(String id, Timestamp cdate) {
		this.id = id;
		this.cdate = cdate;
	}

	/** full constructor */
	public AbstractChannel(String id, Manager manager, Attachment template, Attachment vtemplate,
			String title, String intro, Timestamp cdate, Set chcontents) {
		this.id = id;
		this.manager = manager;
		this.template = template;
		this.vtemplate = vtemplate;
		this.title = title;
		this.intro = intro;
		this.cdate = cdate;
		this.chcontents = chcontents;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Attachment getTemplate() {
		return template;
	}

	public void setTemplate(Attachment template) {
		this.template = template;
	}

	public Attachment getVtemplate() {
		return vtemplate;
	}

	public void setVtemplate(Attachment vtemplate) {
		this.vtemplate = vtemplate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Timestamp getCdate() {
		return this.cdate;
	}

	public void setCdate(Timestamp cdate) {
		this.cdate = cdate;
	}

	public Set getChcontents() {
		return this.chcontents;
	}

	public void setChcontents(Set chcontents) {
		this.chcontents = chcontents;
	}

}