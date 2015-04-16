package com.e6mall.model;

import java.sql.Timestamp;

/**
 * Evaluate entity. @author bingzhou6@gmail.com
 */
public class Evaluate extends AbstractEvaluate implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Evaluate() {
	}

	/** full constructor */
	public Evaluate(String id, Member member, Orders orders, String etype,
			Integer positive, Integer neutral, Integer negative, Timestamp ctime) {
		super(id, member, orders, etype, positive, neutral, negative, ctime);
	}

}
