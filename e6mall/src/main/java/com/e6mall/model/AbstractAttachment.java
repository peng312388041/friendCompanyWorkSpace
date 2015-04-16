package com.e6mall.model;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractAttachment entity provides the base persistence definition of the
 * Attachment entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractAttachment implements java.io.Serializable {

	// Fields

	private String id;
	private Manager manager;
	private Document document;
	private Goods goods;
	private String name;
	private String ftype;
	private String status;
	private Integer sort;
	private String path;
	private String oname;
	private String details;
	private String url;
	private Timestamp ctime;
	private Set members = new HashSet(0);
	private Set managers = new HashSet(0);
	private Set categories = new HashSet(0);
	private Set specvalues = new HashSet(0);
	private Set logisticses = new HashSet(0);
	private Set channels = new HashSet(0);
	private Set documents = new HashSet(0);
	private Set doccates = new HashSet(0);
	private Set paymodes = new HashSet(0);
	
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
	public AbstractAttachment() {
	}

	/** minimal constructor */
	public AbstractAttachment(String id, String name, String ftype,
			String status, Integer sort, String path, String oname) {
		this.id = id;
		this.name = name;
		this.ftype = ftype;
		this.status = status;
		this.sort = sort;
		this.path = path;
		this.oname = oname;
	}

	/** full constructor */
	public AbstractAttachment(String id, Manager manager, Document document, Goods goods,
			String name, String ftype, String status, Integer sort,
			String path, String oname, String details, String url, Timestamp ctime, Set members,
			Set managers, Set categories, Set specvalues, Set logisticses,
			Set channels, Set documents, Set doccates, Set paymodes) {
		this.id = id;
		this.manager = manager;
		this.document = document;
		this.goods = goods;
		this.name = name;
		this.ftype = ftype;
		this.status = status;
		this.sort = sort;
		this.path = path;
		this.oname = oname;
		this.details = details;
		this.url = url;
		this.ctime = ctime;
		this.members = members;
		this.managers = managers;
		this.categories = categories;
		this.specvalues = specvalues;
		this.logisticses = logisticses;
		this.channels = channels;
		this.documents = documents;
		this.doccates = doccates;
		this.paymodes = paymodes;
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

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFtype() {
		return this.ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getOname() {
		return this.oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Timestamp getCtime() {
		return ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

	public Set getMembers() {
		return this.members;
	}

	public void setMembers(Set members) {
		this.members = members;
	}

	public Set getManagers() {
		return this.managers;
	}

	public void setManagers(Set managers) {
		this.managers = managers;
	}

	public Set getCategories() {
		return this.categories;
	}

	public void setCategories(Set categories) {
		this.categories = categories;
	}

	public Set getSpecvalues() {
		return this.specvalues;
	}

	public void setSpecvalues(Set specvalues) {
		this.specvalues = specvalues;
	}

	public Set getLogisticses() {
		return this.logisticses;
	}

	public void setLogisticses(Set logisticses) {
		this.logisticses = logisticses;
	}

	public Set getChannels() {
		return channels;
	}

	public void setChannels(Set channels) {
		this.channels = channels;
	}

	public Set getDocuments() {
		return documents;
	}

	public void setDocuments(Set documents) {
		this.documents = documents;
	}

	public Set getDoccates() {
		return doccates;
	}

	public void setDoccates(Set doccates) {
		this.doccates = doccates;
	}

	public Set getPaymodes() {
		return paymodes;
	}

	public void setPaymodes(Set paymodes) {
		this.paymodes = paymodes;
	}
}