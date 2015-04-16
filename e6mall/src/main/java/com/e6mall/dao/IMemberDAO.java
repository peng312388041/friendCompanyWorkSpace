package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Member;

public interface IMemberDAO extends IBaseDAO {

	// property constants
	public static final String ACCOUNT = "account";
	public static final String PASSWORD = "password";
	public static final String ACTIVATION = "activation";
	public static final String STATUS = "status";
	public static final String EMAIL = "email";
	public static final String NAME = "name";
	public static final String CTYPE = "ctype";
	public static final String NICKNAME = "nickname";
	public static final String IDCARD = "idcard";
	public static final String LOGINCOUNT = "logincount";

	public abstract void save(Member transientInstance);

	public abstract void delete(Member persistentInstance);

	public abstract Member findById(java.lang.String id);

	public abstract List findByExample(Member instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract Member findByAccount(Object account);

	public abstract List findByPassword(Object password);

	public abstract List findByActivation(Object activation);

	public abstract List findByStatus(Object status);

	public abstract List findByEmail(Object email);

	public abstract List findByName(Object name);

	public abstract List findByCtype(Object ctype);

	public abstract List findByNickname(Object nickname);

	public abstract List findByIdcard(Object idcard);

	public abstract List findByLogincount(Object logincount);

	public abstract List findAll();

	public abstract Member merge(Member detachedInstance);

	public abstract void attachDirty(Member instance);

	public abstract void attachClean(Member instance);

}