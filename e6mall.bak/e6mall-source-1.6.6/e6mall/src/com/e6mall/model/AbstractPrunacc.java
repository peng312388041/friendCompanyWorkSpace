package com.e6mall.model;

import java.sql.Timestamp;

/**
 * AbstractPrunacc entity provides the base persistence definition of the
 * Prunacc entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractPrunacc implements java.io.Serializable {

	// Fields

	private String id;
	private Member member;
	private Manager manager;
	private Points points;
	private String status;
	private Integer balance;
	private Integer getout;
	private Integer payin;
	private String tabloid;
	private String remarks;
	private Timestamp ctime;

	// Constructors

	/** default constructor */
	public AbstractPrunacc() {
	}

	/** minimal constructor */
	public AbstractPrunacc(String id, Points points, String status,
			Integer balance, String tabloid, Timestamp ctime) {
		this.id = id;
		this.points = points;
		this.status = status;
		this.balance = balance;
		this.tabloid = tabloid;
		this.ctime = ctime;
	}

	/** full constructor */
	public AbstractPrunacc(String id, Member member, Manager manager,
			Points points, String status, Integer balance, Integer getout,
			Integer payin, String tabloid, String remarks, Timestamp ctime) {
		this.id = id;
		this.member = member;
		this.manager = manager;
		this.points = points;
		this.status = status;
		this.balance = balance;
		this.getout = getout;
		this.payin = payin;
		this.tabloid = tabloid;
		this.remarks = remarks;
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

	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Points getPoints() {
		return this.points;
	}

	public void setPoints(Points points) {
		this.points = points;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getBalance() {
		return this.balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getGetout() {
		return this.getout;
	}

	public void setGetout(Integer getout) {
		this.getout = getout;
	}

	public Integer getPayin() {
		return this.payin;
	}

	public void setPayin(Integer payin) {
		this.payin = payin;
	}

	public String getTabloid() {
		return this.tabloid;
	}

	public void setTabloid(String tabloid) {
		this.tabloid = tabloid;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Timestamp getCtime() {
		return this.ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

}