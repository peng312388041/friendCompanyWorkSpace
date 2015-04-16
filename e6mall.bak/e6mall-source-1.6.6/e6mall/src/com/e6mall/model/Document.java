package com.e6mall.model;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Document entity. @author bingzhou6@gmail.com
 */
public class Document extends AbstractDocument implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Document() {
	}

	/** minimal constructor */
	public Document(String id, String title, String content, String marker,
			Integer vistor, Timestamp cdate) {
		super(id, title, content, marker, vistor, cdate);
	}

	/** full constructor */
	public Document(String id, Manager manager, Attachment image,
			Locale locale, Doccate doccate, String title, String brief,
			String content, String marker, Integer vistor, Integer csort, Timestamp cdate,
			Set chcontents, Set attachments) {
		super(id, manager, image, locale, doccate, title, brief, content,
				marker, vistor, csort, cdate, chcontents, attachments);
	}

}
