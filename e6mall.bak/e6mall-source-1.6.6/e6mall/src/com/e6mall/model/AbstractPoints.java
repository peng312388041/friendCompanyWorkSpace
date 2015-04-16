package com.e6mall.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractPoints entity provides the base persistence definition of the Points
 * entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractPoints implements java.io.Serializable {

	// Fields

	private String id;
	private String account;
	private String status;
	private Integer balance;
	private String remarks;
	private Timestamp ctime;
	private Set prunaccs = new HashSet(0);
	private Set members = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractPoints() {
	}

	/** minimal constructor */
	public AbstractPoints(String id, String account, String status,
			Integer balance, Timestamp ctime) {
		this.id = id;
		this.account = account;
		this.status = status;
		this.balance = balance;
		this.ctime = ctime;
	}

	/** full constructor */
	public AbstractPoints(String id, String account, String status,
			Integer balance, String remarks, Timestamp ctime, Set prunaccs,
			Set members) {
		this.id = id;
		this.account = account;
		this.status = status;
		this.balance = balance;
		this.remarks = remarks;
		this.ctime = ctime;
		this.prunaccs = prunaccs;
		this.members = members;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
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

	public Set getPrunaccs() {
		return this.prunaccs;
	}

	public void setPrunaccs(Set prunaccs) {
		this.prunaccs = prunaccs;
	}

	public Set getMembers() {
		return this.members;
	}

	public void setMembers(Set members) {
		this.members = members;
	}

}