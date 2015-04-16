package com.e6mall.model;

import java.util.Set;

/**
 * Msetting entity. @author bingzhou6@gmail.com
 */
public class Permission extends AbstractPermission implements java.io.Serializable {
	private static final long serialVersionUID = -6462895411885202075L;
	
	// Constructors
	
	/** default constructor */
	public Permission() {
	}

	/** minimal constructor */
	public Permission(String id, String name, String code, Integer read,
			Integer write, Integer delete) {
		super(id, name, code, read, write, delete);
	}

	/** full constructor */
	public Permission(String id, Permission permission, Mgroups mgroups, Member member, Manager manager,
			Groups groups, String name, String code, Integer read,
			Integer write, Integer delete, Set permissions) {
		super(id, permission, mgroups, member, manager, groups, name, code, read,
				write, delete, permissions);
	}
}
