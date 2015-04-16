package com.e6mall.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * AbstractSpec entity provides the base persistence definition of the Spec
 * entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractSpec implements java.io.Serializable {

	// Fields

	private String id;
	private Goods goods;
	private String gscode;
	private Integer inventory;
	private Double price;
	private Double cprice;
	private Double weight;
	private Integer wgunit;	//重量单位倍数
	private Set specvalues = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractSpec() {
	}

	/** minimal constructor */
	public AbstractSpec(String id, Goods goods, String gscode,
			Integer inventory, Double price) {
		this.id = id;
		this.goods = goods;
		this.gscode = gscode;
		this.inventory = inventory;
		this.price = price;
	}

	/** full constructor */
	public AbstractSpec(String id, Goods goods, String gscode,
			Integer inventory, Double price, Double cprice, Double weight, Set specvalues) {
		this.id = id;
		this.goods = goods;
		this.gscode = gscode;
		this.inventory = inventory;
		this.price = price;
		this.cprice = cprice;
		this.weight = weight;
		this.specvalues = specvalues;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getGscode() {
		return this.gscode;
	}

	public void setGscode(String gscode) {
		this.gscode = gscode;
	}

	public Integer getInventory() {
		return this.inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public Double getPrice() {
		DecimalFormat format = (DecimalFormat) NumberFormat.getInstance();
		format.applyPattern("0.00");
		String sprice = format.format(this.price);
		return Double.parseDouble(sprice);
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getCprice() {
		DecimalFormat format = (DecimalFormat) NumberFormat.getInstance();
		format.applyPattern("0.00");
		try {
			String scprice = format.format(this.cprice);
			return Double.parseDouble(scprice);
		} catch (Exception e) {
			return new Double(0);
		}
	}

	public void setCprice(Double cprice) {
		if (null != cprice)
			this.cprice = cprice;
		else
			this.cprice = new Double(0);
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		if (null != weight)
			this.weight = weight;
		else
			this.weight = new Double(0);
		
		Double w = weight;
		if (null != wgunit && wgunit > 0)
			w = weight * wgunit;
		this.weight = w;
	}

	public Integer getWgunit() {
		return wgunit;
	}

	public void setWgunit(Integer wgunit) {
		this.wgunit = wgunit;
	}

	public Set getSpecvalues() {
		return this.specvalues;
	}
	
	//不影响上面的默认方法，在这里加个参数成另一个方法，重载
	public Set getSpecvalues(boolean sort) {
		//按specvalue的specitem对象的name属性排序
		TreeSet<Specvalue> set = new TreeSet<Specvalue>(new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				// 在这里来比较o1和o2
				Specvalue u1 = (Specvalue) o1;
				Specvalue u2 = (Specvalue) o2;
				return u2.getSpecitem().getName().compareTo(u1.getSpecitem().getName());
			}
		});
		set.addAll(this.specvalues);
		/*Iterator it = set.iterator();
		System.out.println("-------------------------------------");
		while(it.hasNext()){
			Specvalue specvalue = (Specvalue)it.next();
			System.out.println(specvalue.getName()+":"+specvalue.getSpecitem().getName());
		}*/
		return set;
	}

	public void setSpecvalues(Set specvalues) {
		this.specvalues = specvalues;
	}

}