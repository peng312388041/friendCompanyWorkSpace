package com.e6mall.model;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Comments entity. @author MyEclipse Persistence Tools
 */
public class Comments extends AbstractComments implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Comments() {
	}

	/** minimal constructor */
	public Comments(String id, Goods goods, String content, String status,
			Timestamp cdate) {
		super(id, goods, content, status, cdate);
	}

	/** full constructor */
	public Comments(String id, Member member, Goods goods, Comments comments,
			String title, String content, String status, Timestamp cdate,
			Set commentses) {
		super(id, member, goods, comments, title, content, status, cdate,
				commentses);
	}

}
