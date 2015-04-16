package com.e6mall.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * AbstractOrders entity provides the base persistence definition of the Orders
 * entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractOrders implements java.io.Serializable {

	// Fields

	private String id;
	private Member member;
	private Paymode paymode;
	private Staddress staddress;
	private Lsarea lsarea;
	private String code;
	private String subject;
	private String body;
	private String status;
	private String status_brief;
	private Timestamp ctime;
	private Double amount;
	private Double logicost;
	private Double paycost;
	private Double baojia;
	private Double weight;
	private String invoicetitle;
	private Double duty;
	private Double discount;
	private Double actamount;
	private Set evaluates = new HashSet(0);
	private Set orderitems = new HashSet(0);
	
	private Integer cartNumber;	//商品数量
	private Double cartAmount;	//订单金额

	// Constructors

	/** default constructor */
	public AbstractOrders() {
	}

	/** minimal constructor */
	public AbstractOrders(String id, Member member, Paymode paymode,
			Staddress staddress, Lsarea lsarea, String code, String subject, String body, String status,
			Timestamp ctime, Double amount, Double logicost, Double paycost, Double baojia, Double weight,
			String invoicetitle, Double duty, Double discount, Double actamount) {
		this.id = id;
		this.member = member;
		this.paymode = paymode;
		this.staddress = staddress;
		this.lsarea = lsarea;
		this.code = code;
		this.subject = subject;
		this.body = body;
		this.status = status;
		this.ctime = ctime;
		this.amount = amount;
		this.logicost = logicost;
		this.paycost = paycost;
		this.baojia = baojia;
		this.weight = weight;
		this.invoicetitle = invoicetitle;
		this.duty = duty;
		this.discount = discount;
		this.actamount = actamount;
	}

	/** full constructor */
	public AbstractOrders(String id, Member member, Paymode paymode,
			Staddress staddress, Lsarea lsarea, String code, String subject, String body, String status, String status_brief,
			Timestamp ctime, Double amount, Double logicost, Double paycost, Double baojia, Double weight,
			String invoicetitle, Double duty, Double discount, Double actamount, Set evaluates,
			Set orderitems) {
		this.id = id;
		this.member = member;
		this.paymode = paymode;
		this.staddress = staddress;
		this.lsarea = lsarea;
		this.code = code;
		this.subject = subject;
		this.body = body;
		this.status = status;
		this.status_brief = status_brief;
		this.ctime = ctime;
		this.amount = amount;
		this.logicost = logicost;
		this.paycost = paycost;
		this.baojia = baojia;
		this.weight = weight;
		this.invoicetitle = invoicetitle;
		this.duty = duty;
		this.discount = discount;
		this.actamount = actamount;
		this.evaluates = evaluates;
		this.orderitems = orderitems;
	}

	// Property accessors

	public Integer getCartNumber() {
		cartNumber = 0;
		Iterator it = this.getOrderitems().iterator();
		while(it.hasNext()) {
			Orderitem oi = (Orderitem)it.next();
			cartNumber++;
		}
		return cartNumber;
	}

	public void setCartNumber(Integer cartNumber) {
		this.cartNumber = cartNumber;
	}

	public Double getCartAmount() {
		cartAmount = new Double(0);
		Iterator it = this.getOrderitems().iterator();
		while(it.hasNext()) {
			Orderitem oi = (Orderitem)it.next();
			cartAmount += oi.getSubtotal();
		}
		return cartAmount;
	}

	public void setCartAmount(Double cartAmount) {
		this.cartAmount = cartAmount;
	}

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

	public Paymode getPaymode() {
		return this.paymode;
	}

	public void setPaymode(Paymode paymode) {
		this.paymode = paymode;
	}

	public Staddress getStaddress() {
		return this.staddress;
	}

	public void setStaddress(Staddress staddress) {
		this.staddress = staddress;
	}

	public Lsarea getLsarea() {
		return lsarea;
	}

	public void setLsarea(Lsarea lsarea) {
		this.lsarea = lsarea;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		if (status.equals("WAIT_BUYER_PAY"))
			this.status_brief = "等待买家付款";
		if (status.equals("WAIT_SELLER_SEND_GOODS"))
			this.status_brief = "买家已付款";
		if (status.equals("WAIT_BUYER_CONFIRM_GOODS"))
			this.status_brief = "卖家已发货";
		if (status.equals("TRADE_FINISHED"))
			this.status_brief = "交易完成";
		if (status.equals("TRADE_CLOSED"))
			this.status_brief = "交易关闭";
		this.status = status;
	}

	public String getStatus_brief() {
		return status_brief;
	}

	public void setStatus_brief(String statusBrief) {
		status_brief = statusBrief;
	}

	public Timestamp getCtime() {
		return this.ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getLogicost() {
		return this.logicost;
	}

	public void setLogicost(Double logicost) {
		this.logicost = logicost;
	}

	public Double getPaycost() {
		return paycost;
	}

	public void setPaycost(Double paycost) {
		this.paycost = paycost;
	}

	public Double getBaojia() {
		return this.baojia;
	}

	public void setBaojia(Double baojia) {
		this.baojia = baojia;
	}

	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getInvoicetitle() {
		return this.invoicetitle;
	}

	public void setInvoicetitle(String invoicetitle) {
		this.invoicetitle = invoicetitle;
	}

	public Double getDuty() {
		return this.duty;
	}

	public void setDuty(Double duty) {
		this.duty = duty;
	}

	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getActamount() {
		return actamount;
	}

	public void setActamount(Double actamount) {
		this.actamount = actamount;
	}

	public Set getEvaluates() {
		return this.evaluates;
	}

	public void setEvaluates(Set evaluates) {
		this.evaluates = evaluates;
	}

	public Set getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(Set orderitems) {
		this.orderitems = orderitems;
	}
}