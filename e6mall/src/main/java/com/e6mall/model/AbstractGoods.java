package com.e6mall.model;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.e6mall.utils.SubString;

/**
 * AbstractGoods entity provides the base persistence definition of the Goods
 * entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractGoods implements java.io.Serializable {

	// Fields

	private String id;
	private Manager manager;
	private Gstype gstype;
	private Locale locale;
	private Category category;
	private Brand brand;
	private String name;
	private String sn;
	private String barcode;
	private String keywords;
	private String intro;
	private String details;
	private Double price;
	private Double mprice;
	private Double cprice;
	private Double weight;
	private Integer wgunit;	//重量单位倍数
	private String freeshipping;
	private Integer points;
	private Integer inventory;
	private String promote;
	private Timestamp ctime;
	private Timestamp utime;
	private String status;
	private Integer csort;
	private String mkeywords;
	private String mdescription;
	private Integer vistor;
	private Set specs = new HashSet(0);
	private Set attachments = new HashSet(0);
	private Set commentses = new HashSet(0);
	private Set eavalues = new HashSet(0);
	private Set orderitems = new HashSet(0);
	private Set chcontents = new HashSet(0);
	
	private String subname;//截取部分字符
	private String subintro;//截取部分字符
	private Integer trans;//成交数量
	
	private Attachment defaultImage;//图库默认图
	private String priceScope;	//价格范围
	
	private String[] keys;		//页面存入关键词标签转换
	
	private String vdate;
	private String vtime;
	
	public String getVdate() {
		SimpleDateFormat sdf = (SimpleDateFormat)DateFormat.getDateInstance();
		sdf.applyPattern("yyyy-MM-dd");
		vdate = sdf.format(ctime);
		return vdate;
	}
	
	public String getVdate(String format) {
		SimpleDateFormat sdf = (SimpleDateFormat)DateFormat.getDateInstance();
		try {
			sdf.applyPattern(format);
			vdate = sdf.format(ctime);
		} catch (Exception e) {
			sdf.applyPattern("yyyy-MM-dd");
			vdate = sdf.format(ctime);
		}
		return vdate;
	}

	public void setVdate(String vdate) {
		this.vdate = vdate;
	}

	public String getVtime() {
		SimpleDateFormat sdf = (SimpleDateFormat)DateFormat.getTimeInstance();
		sdf.applyPattern("HH:mm:ss");
		vtime = sdf.format(ctime);
		return vtime;
	}
	
	public String getVtime(String format) {
		SimpleDateFormat sdf = (SimpleDateFormat)DateFormat.getTimeInstance();
		try {
			sdf.applyPattern(format);
			vtime = sdf.format(ctime);
		} catch (Exception e) {
			sdf.applyPattern("HH:mm:ss");
			vtime = sdf.format(ctime);
		}
		return vtime;
	}

	public void setVtime(String vtime) {
		this.vtime = vtime;
	}

	// Constructors

	/** default constructor */
	public AbstractGoods() {
	}

	/** minimal constructor */
	public AbstractGoods(String id, Manager manager, Gstype gstype,
			String name, String details, String promote, Timestamp ctime,
			String status, Integer csort) {
		this.id = id;
		this.manager = manager;
		this.gstype = gstype;
		this.name = name;
		this.details = details;
		this.promote = promote;
		this.ctime = ctime;
		this.status = status;
		this.csort = csort;
	}

	/** full constructor */
	public AbstractGoods(String id, Manager manager, Gstype gstype,
			Locale locale, Category category, Brand brand, String name,
			String sn, String barcode, String keywords, String intro,
			String details, Double price, Double mprice, Double cprice, Double weight, String freeshipping,
			Integer points, Integer inventory, String promote, Timestamp ctime,
			Timestamp utime, String status, Integer csort, String mkeywords,
			String mdescription, Integer vistor, Set specs, Set attachments, Set commentses, Set eavalues,
			Set orderitems, Set chcontents) {
		this.id = id;
		this.manager = manager;
		this.gstype = gstype;
		this.locale = locale;
		this.category = category;
		this.brand = brand;
		this.name = name;
		this.sn = sn;
		this.barcode = barcode;
		this.keywords = keywords;
		this.intro = intro;
		this.details = details;
		this.price = price;
		this.mprice = mprice;
		this.cprice = cprice;
		this.weight = weight;
		this.freeshipping = freeshipping;
		this.points = points;
		this.inventory = inventory;
		this.promote = promote;
		this.ctime = ctime;
		this.utime = utime;
		this.status = status;
		this.csort = csort;
		this.mkeywords = mkeywords;
		this.mdescription = mdescription;
		this.vistor = vistor;
		this.specs = specs;
		this.attachments = attachments;
		this.commentses = commentses;
		this.eavalues = eavalues;
		this.orderitems = orderitems;
		this.chcontents = chcontents;
	}
	
	public Attachment getDefaultImage() {
		if (null != defaultImage) {
			return defaultImage;
		} else {
			Attachment image = new Attachment();
			image.setPath("/images");
			image.setName("nopic.jpg");
			return image;
		}
	}

	public void setDefaultImage(Attachment defaultImage) {
		this.defaultImage = defaultImage;
	}
	
	public String getPriceScope() {
		return priceScope;
	}

	public void setPriceScope(String priceScope) {
		this.priceScope = priceScope;
	}
	
	public Integer getTrans() {
		return trans;
	}

	public void setTrans(Integer trans) {
		this.trans = trans;
	}
	
	public String getSubname() {
		return subname;
	}
	
	/**
	 * 截取部分简述内容,不区分中英文,如果数字非偶数,则少取一个字符位
	 * 
	 * @param n 截取长度(一个汉字长度按2算的)
	 * @param ext 后缀
	 * @return 返回的字符串
	 */
	public String getSubname(int n, String ext) {
		this.subname = SubString.substring(this.name, n, ext);
		return this.subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public String getSubintro() {
		return subintro;
	}
	
	/**
	 * 截取部分简述内容,不区分中英文,如果数字非偶数,则少取一个字符位
	 * 
	 * @param n 截取长度(一个汉字长度按2算的)
	 * @param ext 后缀
	 * @return 返回的字符串
	 */
	public String getSubintro(int n, String ext) {
		this.subintro = SubString.substring(this.intro, n, ext);
		return this.subintro;
	}

	public void setSubintro(String subintro) {
		this.subintro = subintro;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Gstype getGstype() {
		return this.gstype;
	}

	public void setGstype(Gstype gstype) {
		this.gstype = gstype;
	}

	public Locale getLocale() {
		return this.locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSn() {
		return this.sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
		if (null != keywords) {
			keys = keywords.split(",");
		}
	}
	
	public boolean hasKeyword(String keyword) {
		if (null != keywords) {
			String[] list = keywords.split(",");
			if (null != list) {
				for (int i=0; i<list.length; i++) {
					String key = list[i];
					if (keyword.equals(key)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getMprice() {
		return this.mprice;
	}

	public void setMprice(Double mprice) {
		this.mprice = mprice;
	}

	public Double getCprice() {
		return this.cprice;
	}

	public void setCprice(Double cprice) {
		this.cprice = cprice;
	}

	public Double getWeight() {
		return weight;
	}

	/**
	 * 
	 * @author bingzhou6@gmail.com 
	 * 功能：重量单位默认为克，wgunit为重量单位倍数，如KG为1000，最终重量由weight * wgunit得出。
	 * @param weight
	 */
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

	public String getFreeshipping() {
		return freeshipping;
	}

	public void setFreeshipping(String freeshipping) {
		this.freeshipping = freeshipping;
	}

	public Integer getPoints() {
		return this.points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getInventory() {
		return this.inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public String getPromote() {
		return this.promote;
	}

	public void setPromote(String promote) {
		this.promote = promote;
	}

	public Timestamp getCtime() {
		return this.ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

	public Timestamp getUtime() {
		return this.utime;
	}

	public void setUtime(Timestamp utime) {
		this.utime = utime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCsort() {
		return this.csort;
	}

	public void setCsort(Integer csort) {
		this.csort = csort;
	}

	public String getMkeywords() {
		return this.mkeywords;
	}

	public void setMkeywords(String mkeywords) {
		this.mkeywords = mkeywords;
	}

	public String getMdescription() {
		return this.mdescription;
	}

	public void setMdescription(String mdescription) {
		this.mdescription = mdescription;
	}

	public Integer getVistor() {
		return vistor;
	}

	public void setVistor(Integer vistor) {
		this.vistor = vistor;
	}

	public Set getSpecs() {
		return this.specs;
	}

	public void setSpecs(Set specs) {
		this.specs = specs;
		//价格范围
		Iterator it = specs.iterator();
		List<Double> al = new ArrayList<Double>();
		while(it.hasNext()) {
			Spec spec = (Spec)it.next();
			al.add(spec.getPrice());
		}
		DecimalFormat format = (DecimalFormat) NumberFormat.getInstance();
		format.applyPattern("0.00");
		if (al.size() > 0) {
			this.priceScope = format.format(Collections.min(al)) + "-" + format.format(Collections.max(al));
		} else {
			try {
				this.priceScope = this.price.toString();
			} catch (NullPointerException e) {
				this.priceScope = null;
			}
		}
	}

	public Set getAttachments() {
		return this.attachments;
	}

	public void setAttachments(Set attachments) {
		this.attachments = attachments;
		//默认图片
		Iterator it = attachments.iterator();
		while(it.hasNext()) {
			Attachment attach = (Attachment)it.next();
			if (attach.getStatus().equals("default")) {
				this.defaultImage = attach;
				break;
			}
		}
	}

	public Set getCommentses() {
		return commentses;
	}

	public void setCommentses(Set commentses) {
		this.commentses = commentses;
	}

	public Set getEavalues() {
		return this.eavalues;
	}

	public void setEavalues(Set eavalues) {
		this.eavalues = eavalues;
	}

	public Set getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(Set orderitems) {
		this.orderitems = orderitems;
		//计算成交数量
		Integer number = 0;
		Iterator it = orderitems.iterator();
		while(it.hasNext()) {
			Orderitem oi = (Orderitem)it.next();
			number += oi.getNumber();
		}
		this.trans = number;
	}

	public Set getChcontents() {
		return chcontents;
	}

	public void setChcontents(Set chcontents) {
		this.chcontents = chcontents;
	}

	public String[] getKeys() {
		return keys;
	}

	public void setKeys(String[] keys) {
		this.keys = keys;
		this.keys = keys;
		if (null != keys) {
			String kws = "";
			for (int i=0; i<keys.length; i++) {
				kws += keys[i] + ",";
			}
			this.keywords = kws;
		} else {
			this.keywords = null;
		}
	}
}