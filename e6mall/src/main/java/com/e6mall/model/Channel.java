package com.e6mall.model;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Channel entity. @author bingzhou6@gmail.com
 */
public class Channel extends AbstractChannel implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Channel() {
	}

	/** minimal constructor */
	public Channel(String id, Timestamp cdate) {
		super(id, cdate);
	}

	/** full constructor */
	public Channel(String id, Manager manager, Attachment template, Attachment vtemplate, 
			String title, String intro, Timestamp cdate, Set chcontents) {
		super(id, manager, template, vtemplate, title, intro, cdate, chcontents);
	}

}
