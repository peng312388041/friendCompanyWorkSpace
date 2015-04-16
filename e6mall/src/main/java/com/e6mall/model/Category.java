package com.e6mall.model;

import java.util.Set;

/**
 * Category entity. @author bingzhou6@gmail.com
 */
public class Category extends AbstractCategory implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** minimal constructor */
	public Category(String id, Gstype gstype, String nodepath, String nodetype,
			String name, Integer csort) {
		super(id, gstype, nodepath, nodetype, name, csort);
	}

	/** full constructor */
	public Category(String id, Attachment image, Gstype gstype,
			Locale locale, Category category, String nodepath, String nodetype,
			String name, String details, Integer csort, String mkeywords,
			String mdescription, Set goodses, Set categories, Set chcontents, String nodestr) {
		super(id, image, gstype, locale, category, nodepath, nodetype,
				name, details, csort, mkeywords, mdescription, goodses,
				categories, chcontents, nodestr);
	}

}
