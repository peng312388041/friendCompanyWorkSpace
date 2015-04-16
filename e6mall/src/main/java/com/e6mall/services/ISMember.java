package com.e6mall.services;

import java.util.List;

import com.e6mall.model.Member;
import com.e6mall.utils.Notice;

public interface ISMember extends IBaseServices {
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
	
	public abstract Notice register(Member member, String validateCode);
	
	public abstract Notice login(String account, String password, String validateCode);

	public abstract void save(Member transientInstance);

	public abstract void delete(Member persistentInstance);

	public abstract Member findById(java.lang.String id);

	public abstract List findAll();

	public abstract Member merge(Member detachedInstance);

	public abstract void attachDirty(Member instance);

	public abstract void attachClean(Member instance);
}
