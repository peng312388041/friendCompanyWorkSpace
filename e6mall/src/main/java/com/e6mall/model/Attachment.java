package com.e6mall.model;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Attachment entity. @author bingzhou6@gmail.com
 */
public class Attachment extends AbstractAttachment implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Attachment() {
	}

	/** minimal constructor */
	public Attachment(String id, String name, String ftype, String status,
			Integer sort, String path, String oname) {
		super(id, name, ftype, status, sort, path, oname);
	}

	/** full constructor */
	public Attachment(String id, Manager manager, Document document, Goods goods, String name,
			String ftype, String status, Integer sort, String path,
			String oname, String details, String url, Timestamp ctime, Set members, Set managers,
			Set categories, Set specvalues, Set logisticses, Set channels, Set documents, Set doccates, Set paymodes) {
		super(id, manager, document, goods, name, ftype, status, sort, path, oname,
				details, url, ctime, members, managers, categories, specvalues, logisticses, channels, documents, doccates, paymodes);
	}

}
