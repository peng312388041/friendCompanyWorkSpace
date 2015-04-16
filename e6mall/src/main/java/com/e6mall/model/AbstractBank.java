package com.e6mall.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractBank entity provides the base persistence definition of the Bank
 * entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractBank implements java.io.Serializable {

	// Fields

	private String id;
	private String account;
	private String status;
	private Double balance;
	private String remarks;
	private Timestamp ctime;
	private Set brunaccs = new HashSet(0);
	private Set members = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractBank() {
	}

	/** minimal constructor */
	public AbstractBank(String id, String account, String status,
			Double balance, Timestamp ctime) {
		this.id = id;
		this.account = account;
		this.status = status;
		this.balance = balance;
		this.ctime = ctime;
	}

	/** full constructor */
	public AbstractBank(String id, String account, String status,
			Double balance, String remarks, Timestamp ctime, Set brunaccs,
			Set members) {
		this.id = id;
		this.account = account;
		this.status = status;
		this.balance = balance;
		this.remarks = remarks;
		this.ctime = ctime;
		this.brunaccs = brunaccs;
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

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
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

	public Set getBrunaccs() {
		return this.brunaccs;
	}

	public void setBrunaccs(Set brunaccs) {
		this.brunaccs = brunaccs;
	}

	public Set getMembers() {
		return this.members;
	}

	public void setMembers(Set members) {
		this.members = members;
	}

}