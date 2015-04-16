package com.e6mall.model;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractMsetting entity provides the base persistence definition of the
 * Msetting entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractPermission implements java.io.Serializable {
	private static final long serialVersionUID = 820995944849846727L;
	// Fields
	private String id;
	private Permission permission;
	private Mgroups mgroups;
	private Member member;
	private Manager manager;
	private Groups groups;
	private String name;
	private String code;
	private Integer read;
	private Integer write;
	private Integer delete;
	private Set permissions = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractPermission() {
	}

	/** minimal constructor */
	public AbstractPermission(String id, String name, String code,
			Integer read, Integer write, Integer delete) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.read = read;
		this.write = write;
		this.delete = delete;
	}

	/** full constructor */
	public AbstractPermission(String id, Permission permission, Mgroups mgroups, Member member,
			Manager manager, Groups groups, String name, String code,
			Integer read, Integer write, Integer delete, Set permissions) {
		this.id = id;
		this.permission = permission;
		this.mgroups = mgroups;
		this.member = member;
		this.manager = manager;
		this.groups = groups;
		this.name = name;
		this.code = code;
		this.read = read;
		this.write = write;
		this.delete = delete;
		this.permissions = permissions;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Mgroups getMgroups() {
		return this.mgroups;
	}

	public void setMgroups(Mgroups mgroups) {
		this.mgroups = mgroups;
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

	public Groups getGroups() {
		return this.groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getRead() {
		return read;
	}

	public void setRead(Integer read) {
		if (null != read)
			this.read = read;
		else
			this.read = 0;
	}

	public Integer getWrite() {
		return write;
	}

	public void setWrite(Integer write) {
		if (null != write)
			this.write = write;
		else
			this.write = 0;
	}

	public Integer getDelete() {
		return delete;
	}

	public void setDelete(Integer delete) {
		if (null != delete)
			this.delete = delete;
		else
			this.delete = 0;
	}

	public Set getPermissions() {
		return permissions;
	}

	public void setPermissions(Set permissions) {
		this.permissions = permissions;
	}
}