package com.e6mall.model;

import java.sql.Timestamp;

/**
 * AbstractEvaluate entity provides the base persistence definition of the
 * Evaluate entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractEvaluate implements java.io.Serializable {

	// Fields

	private String id;
	private Member member;
	private Orders orders;
	private String etype;
	private Integer positive;
	private Integer neutral;
	private Integer negative;
	private Timestamp ctime;

	// Constructors

	/** default constructor */
	public AbstractEvaluate() {
	}

	/** full constructor */
	public AbstractEvaluate(String id, Member member, Orders orders,
			String etype, Integer positive, Integer neutral, Integer negative,
			Timestamp ctime) {
		this.id = id;
		this.member = member;
		this.orders = orders;
		this.etype = etype;
		this.positive = positive;
		this.neutral = neutral;
		this.negative = negative;
		this.ctime = ctime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public String getEtype() {
		return this.etype;
	}

	public void setEtype(String etype) {
		this.etype = etype;
	}

	public Integer getPositive() {
		return this.positive;
	}

	public void setPositive(Integer positive) {
		this.positive = positive;
	}

	public Integer getNeutral() {
		return this.neutral;
	}

	public void setNeutral(Integer neutral) {
		this.neutral = neutral;
	}

	public Integer getNegative() {
		return this.negative;
	}

	public void setNegative(Integer negative) {
		this.negative = negative;
	}

	public Timestamp getCtime() {
		return this.ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

}