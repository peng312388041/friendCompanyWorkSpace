package com.e6mall.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * AbstractSpecitem entity provides the base persistence definition of the
 * Specitem entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractSpecitem implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String remark;
	private String dtype;
	private String dstyle;
	private Set specvalues = new HashSet(0);
	private Set gstypes = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractSpecitem() {
	}

	/** minimal constructor */
	public AbstractSpecitem(String id, String name, String dtype, String dstyle) {
		this.id = id;
		this.name = name;
		this.dtype = dtype;
		this.dstyle = dstyle;
	}

	/** full constructor */
	public AbstractSpecitem(String id, String name, String remark,
			String dtype, String dstyle, Set specvalues, Set gstypes) {
		this.id = id;
		this.name = name;
		this.remark = remark;
		this.dtype = dtype;
		this.dstyle = dstyle;
		this.specvalues = specvalues;
		this.gstypes = gstypes;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDtype() {
		return this.dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getDstyle() {
		return this.dstyle;
	}

	public void setDstyle(String dstyle) {
		this.dstyle = dstyle;
	}

	public Set getSpecvalues() {
		return this.specvalues;
	}
	
	//不影响上面的默认方法，在这里加个参数成另一个方法，重载
	public Set getSpecvalues(boolean sort) {
		TreeSet<Specvalue> treeset = new TreeSet<Specvalue>(new Comparator(){
			public int compare(Object a, Object b) {
				return -((Specvalue)a).getName().compareTo(((Specvalue)b).getName());  
			}}
		);
		treeset.addAll(this.specvalues);
		return treeset;
	}

	public void setSpecvalues(Set specvalues) {
		this.specvalues = specvalues;
	}

	public Set getGstypes() {
		return this.gstypes;
	}

	public void setGstypes(Set gstypes) {
		this.gstypes = gstypes;
	}

}