package com.e6mall.model;

import java.sql.Timestamp;

/**
 * AbstractChcontent entity provides the base persistence definition of the
 * Chcontent entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractChcontent implements java.io.Serializable {

	// Fields

	private String id;
	private Document document;
	private Manager manager;
	private Channel channel;
	private Locale locale;
	private Doccate doccate;
	private Category category;
	private Goods goods;
	private Integer number;
	private Integer offset;
	private String marker;
	private String global;
	private String type;
	private String keywords;
	private String detail;
	private Timestamp cdate;
	
	private String typetext;	//类型说明文字
	private String[] keys;		//页面存入

	// Constructors

	/** default constructor */
	public AbstractChcontent() {
	}

	/** minimal constructor */
	public AbstractChcontent(String id, Channel channel, Integer number,
			Integer offset, String marker, String type, String detail,
			Timestamp cdate) {
		this.id = id;
		this.channel = channel;
		this.number = number;
		this.offset = offset;
		this.marker = marker;
		this.type = type;
		this.detail = detail;
		this.cdate = cdate;
	}

	/** full constructor */
	public AbstractChcontent(String id, Document document, Manager manager,
			Channel channel, Locale locale, Doccate doccate, Category category, Goods goods, Integer number,
			Integer offset, String marker, String global, String type, String keywords, String detail,
			Timestamp cdate, String typetext) {
		this.id = id;
		this.document = document;
		this.manager = manager;
		this.channel = channel;
		this.locale = locale;
		this.doccate = doccate;
		this.category = category;
		this.goods = goods;
		this.number = number;
		this.offset = offset;
		this.marker = marker;
		this.global = global;
		this.type = type;
		this.keywords = keywords;
		this.detail = detail;
		this.cdate = cdate;
		this.typetext = typetext;
	}

	public String getTypetext() {
		return typetext;
	}

	public void setTypetext(String typetext) {
		this.typetext = typetext;
	}
	
	public String[] getKeys() {
		return keys;
	}

	public void setKeys(String[] keys) {
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
	
	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Channel getChannel() {
		return this.channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public Locale getLocale() {
		return this.locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public Doccate getDoccate() {
		return this.doccate;
	}

	public void setDoccate(Doccate doccate) {
		this.doccate = doccate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getOffset() {
		return this.offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public String getMarker() {
		return this.marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}

	public String getGlobal() {
		return global;
	}

	public void setGlobal(String global) {
		if (null != global && !global.equals("") && (global.equals("yes") || global.equals("no"))){
		} else {
			global = "no";
		}
		this.global = global;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
		if (type.equals("dmenu")) {
			this.typetext = "文章分类";
		} else if (type.equals("dlist")) {
			this.typetext = "文章列表";
		} else if (type.equals("drclist")) {
			this.typetext = "推荐文章列表";
		} else if (type.equals("dpagelist")) {
			this.typetext = "分页文章列表";
		} else if (type.equals("gmenu")) {
			this.typetext = "商品分类";
		} else if (type.equals("glist")) {
			this.typetext = "商品列表";
		} else if (type.equals("grclist")) {
			this.typetext = "推荐商品列表";
		} else if (type.equals("gpagelist")) {
			this.typetext = "分页商品列表";
		} else if (type.equals("dsingle")) {
			this.typetext = "单条信息";
		}
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
		if (null != keywords) {
			keys = keywords.split(",");
		}
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Timestamp getCdate() {
		return this.cdate;
	}

	public void setCdate(Timestamp cdate) {
		this.cdate = cdate;
	}

}