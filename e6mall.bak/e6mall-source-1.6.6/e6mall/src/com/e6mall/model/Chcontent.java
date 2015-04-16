package com.e6mall.model;

import java.sql.Timestamp;

/**
 * Chcontent entity. @author bingzhou6@gmail.com
 */
public class Chcontent extends AbstractChcontent implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Chcontent() {
	}

	/** minimal constructor */
	public Chcontent(String id, Channel channel, Integer number,
			Integer offset, String marker, String type, String detail,
			Timestamp cdate) {
		super(id, channel, number, offset, marker, type, detail, cdate);
	}

	/** full constructor */
	public Chcontent(String id, Document document, Manager manager,
			Channel channel, Locale locale, Doccate doccate, Category category, Goods goods, Integer number,
			Integer offset, String marker, String global, String type, String keywords, String detail,
			Timestamp cdate, String typetext) {
		super(id, document, manager, channel, locale, doccate, category, goods, number, offset,
				marker, global, type, keywords, detail, cdate, typetext);
	}

}
