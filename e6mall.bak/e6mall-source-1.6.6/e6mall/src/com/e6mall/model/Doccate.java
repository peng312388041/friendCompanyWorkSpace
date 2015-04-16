package com.e6mall.model;

import java.util.Set;

/**
 * Doccate entity. @author bingzhou6@gmail.com
 */
public class Doccate extends AbstractDoccate implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Doccate() {
	}

	/** minimal constructor */
	public Doccate(String id, String nodepath, String nodetype, String name,
			Integer csort) {
		super(id, nodepath, nodetype, name, csort);
	}

	/** full constructor */
	public Doccate(String id, Attachment image, Locale locale,
			Doccate doccate, String nodepath, String nodetype, String name,
			String details, Integer csort, String mkeywords,
			String mdescription, Set documents, Set doccates, Set chcontents, String nodestr) {
		super(id, image, locale, doccate, nodepath, nodetype, name,
				details, csort, mkeywords, mdescription, documents, doccates,
				chcontents, nodestr);
	}

}
