package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Manager;
import com.e6mall.utils.Notice;

public interface ISManager extends IBaseServices {
	// property constants
	public static final String ACCOUNT = "account";
	public static final String PASSWORD = "password";
	public static final String STATUS = "status";
	public static final String EMAIL = "email";
	public static final String NAME = "name";
	public static final String CTYPE = "ctype";
	public static final String NICKNAME = "nickname";
	public static final String IDCARD = "idcard";
	public static final String LOGINCOUNT = "logincount";

	public abstract Notice login(String account, String password, String validateCode);
	
	public abstract void save(Manager transientInstance);

	public abstract void delete(Manager persistentInstance);

	public abstract Manager findById(java.lang.String id);
	
	public abstract Manager findByAccount(java.lang.String account);

	public abstract List findAll();

	public abstract Manager merge(Manager detachedInstance);

	public abstract void attachDirty(Manager instance);

	public abstract void attachClean(Manager instance);
}
