package com.e6mall.model;

import java.sql.Timestamp;

/**
 * AbstractOrderitem entity provides the base persistence definition of the
 * Orderitem entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractOrderitem implements java.io.Serializable {

	// Fields

	private String id;
	private Member member;
	private Orders orders;
	private Goods goods;
	private Spec spec;
	private Double unitprice;
	private Integer number;
	private Double subtotal;
	private Double actsum;
	private Double discount;
	private String ispay;
	private String status;
	private Timestamp paytime;
	private Timestamp exptime;
	private Timestamp utime;
	private Timestamp ctime;

	// Constructors

	/** default constructor */
	public AbstractOrderitem() {
	}

	/** minimal constructor */
	public AbstractOrderitem(String id, Member member, Goods goods,
			Double unitprice, Integer number, Double subtotal, String ispay,
			String status, Timestamp ctime) {
		this.id = id;
		this.member = member;
		this.goods = goods;
		this.unitprice = unitprice;
		this.number = number;
		this.subtotal = subtotal;
		this.ispay = ispay;
		this.status = status;
		this.ctime = ctime;
	}

	/** full constructor */
	public AbstractOrderitem(String id, Member member, Orders orders,
			Goods goods, Spec spec, Double unitprice, Integer number,
			Double subtotal, Double actsum, Double discount, String ispay,
			String status, Timestamp paytime, Timestamp exptime,
			Timestamp utime, Timestamp ctime) {
		this.id = id;
		this.member = member;
		this.orders = orders;
		this.goods = goods;
		this.spec = spec;
		this.unitprice = unitprice;
		this.number = number;
		this.subtotal = subtotal;
		this.actsum = actsum;
		this.discount = discount;
		this.ispay = ispay;
		this.status = status;
		this.paytime = paytime;
		this.exptime = exptime;
		this.utime = utime;
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

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Spec getSpec() {
		return spec;
	}

	public void setSpec(Spec spec) {
		this.spec = spec;
	}

	public Double getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getActsum() {
		return this.actsum;
	}

	public void setActsum(Double actsum) {
		this.actsum = actsum;
	}

	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getIspay() {
		return this.ispay;
	}

	public void setIspay(String ispay) {
		this.ispay = ispay;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getPaytime() {
		return this.paytime;
	}

	public void setPaytime(Timestamp paytime) {
		this.paytime = paytime;
	}

	public Timestamp getExptime() {
		return this.exptime;
	}

	public void setExptime(Timestamp exptime) {
		this.exptime = exptime;
	}

	public Timestamp getUtime() {
		return this.utime;
	}

	public void setUtime(Timestamp utime) {
		this.utime = utime;
	}

	public Timestamp getCtime() {
		return this.ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

}