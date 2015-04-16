package com.e6mall.model;

import java.sql.Timestamp;

/**
 * AbstractBrunacc entity provides the base persistence definition of the
 * Brunacc entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractBrunacc implements java.io.Serializable {

	// Fields

	private String id;
	private Bank bank;
	private Member member;
	private Manager manager;
	private Paymode paymode;
	private String status;
	private Double balance;
	private Double getout;
	private Double payin;
	private String tabloid;
	private String remarks;
	private String mremarks;
	private Timestamp ctime;

	// Constructors

	/** default constructor */
	public AbstractBrunacc() {
	}

	/** minimal constructor */
	public AbstractBrunacc(String id, Bank bank, String status, Double balance,
			String tabloid, Timestamp ctime) {
		this.id = id;
		this.bank = bank;
		this.status = status;
		this.balance = balance;
		this.tabloid = tabloid;
		this.ctime = ctime;
	}

	/** full constructor */
	public AbstractBrunacc(String id, Bank bank, Member member,
			Manager manager, Paymode paymode, String status, Double balance, Double getout,
			Double payin, String tabloid, String remarks, String mremarks, Timestamp ctime) {
		this.id = id;
		this.bank = bank;
		this.member = member;
		this.manager = manager;
		this.paymode = paymode;
		this.status = status;
		this.balance = balance;
		this.getout = getout;
		this.payin = payin;
		this.tabloid = tabloid;
		this.remarks = remarks;
		this.mremarks = mremarks;
		this.ctime = ctime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Bank getBank() {
		return this.bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
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

	public Paymode getPaymode() {
		return paymode;
	}

	public void setPaymode(Paymode paymode) {
		this.paymode = paymode;
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

	public Double getGetout() {
		return this.getout;
	}

	public void setGetout(Double getout) {
		this.getout = getout;
	}

	public Double getPayin() {
		return this.payin;
	}

	public void setPayin(Double payin) {
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

	public String getMremarks() {
		return mremarks;
	}

	public void setMremarks(String mremarks) {
		this.mremarks = mremarks;
	}

	public Timestamp getCtime() {
		return this.ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

}