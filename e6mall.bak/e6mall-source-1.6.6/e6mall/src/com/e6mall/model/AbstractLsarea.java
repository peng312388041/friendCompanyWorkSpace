package com.e6mall.model;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractLsarea entity provides the base persistence definition of the Lsarea
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractLsarea implements java.io.Serializable {

	// Fields

	private String id;
	private Logistics logistics;
	private String name;
	private String intro;
	private Integer wfirst;
	private Double wfcost;
	private Integer wappend;
	private Double wacost;
	private String cod;
	private Double premiumrate;
	private String status;
	private Set districts = new HashSet(0);
	private Set orderses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractLsarea() {
	}

	/** minimal constructor */
	public AbstractLsarea(String id, Logistics logistics, String name,
			Integer wfirst, Double wfcost, Integer wappend, Double wacost,
			String cod, Double premiumrate) {
		this.id = id;
		this.logistics = logistics;
		this.name = name;
		this.wfirst = wfirst;
		this.wfcost = wfcost;
		this.wappend = wappend;
		this.wacost = wacost;
		this.cod = cod;
		this.premiumrate = premiumrate;
	}

	/** full constructor */
	public AbstractLsarea(String id, Logistics logistics, String name,
			String intro, Integer wfirst, Double wfcost, Integer wappend,
			Double wacost, String cod, Double premiumrate, String status,
			Set districts, Set orderses) {
		this.id = id;
		this.logistics = logistics;
		this.name = name;
		this.intro = intro;
		this.wfirst = wfirst;
		this.wfcost = wfcost;
		this.wappend = wappend;
		this.wacost = wacost;
		this.cod = cod;
		this.premiumrate = premiumrate;
		this.status = status;
		this.districts = districts;
		this.orderses = orderses;
	}
	
	//计算订单物流配送费用
	public Double getLogicost(Double weight) {
		System.out.println("总重："+weight);
		System.out.println("首重："+wfirst);
		System.out.println("续重："+wappend);
		//总重减首重 ，如果小于等于0， 费用等于首重费用
		Double a = weight - wfirst;
		System.out.println("总重减首重："+a);
		if (a <= 0) {
			System.out.println("小于等于0："+wfcost);
			return wfcost;
		} else {
			//否则，费用= 凑整（（总重－首重）／续重）＊　续重费用  +  首重费用
			Double b = a / wappend;
			System.out.println("总重－首重）／续重："+b);
			int c = (int)Math.ceil(b);
			System.out.println("凑整："+c);
			Double d = c * wacost + wfcost;
			System.out.println("＊　续重费用 "+wacost+" +  首重费用"+wfcost+"："+d);
			return d;
		}
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Logistics getLogistics() {
		return this.logistics;
	}

	public void setLogistics(Logistics logistics) {
		this.logistics = logistics;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Integer getWfirst() {
		return this.wfirst;
	}

	public void setWfirst(Integer wfirst) {
		this.wfirst = wfirst;
	}

	public Double getWfcost() {
		return this.wfcost;
	}

	public void setWfcost(Double wfcost) {
		this.wfcost = wfcost;
	}

	public Integer getWappend() {
		return this.wappend;
	}

	public void setWappend(Integer wappend) {
		this.wappend = wappend;
	}

	public Double getWacost() {
		return this.wacost;
	}

	public void setWacost(Double wacost) {
		this.wacost = wacost;
	}

	public String getCod() {
		return this.cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public Double getPremiumrate() {
		return this.premiumrate;
	}

	public void setPremiumrate(Double premiumrate) {
		this.premiumrate = premiumrate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set getDistricts() {
		return this.districts;
	}

	public void setDistricts(Set districts) {
		this.districts = districts;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

}