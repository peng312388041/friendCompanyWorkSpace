package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Manager;

public interface IManagerDAO extends IBaseDAO {

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

	public abstract void save(Manager transientInstance);

	public abstract void delete(Manager persistentInstance);

	public abstract Manager findById(java.lang.String id);

	public abstract List findByExample(Manager instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract Manager findByAccount(Object account);

	public abstract List findByPassword(Object password);

	public abstract List findByStatus(Object status);

	public abstract List findByEmail(Object email);

	public abstract List findByName(Object name);

	public abstract List findByCtype(Object ctype);

	public abstract List findByNickname(Object nickname);

	public abstract List findByIdcard(Object idcard);

	public abstract List findByLogincount(Object logincount);

	public abstract List findAll();

	public abstract Manager merge(Manager detachedInstance);

	public abstract void attachDirty(Manager instance);

	public abstract void attachClean(Manager instance);

}