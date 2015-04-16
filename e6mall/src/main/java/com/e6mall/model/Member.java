package com.e6mall.model;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Member entity. @author bingzhou6@gmail.com
 */
public class Member extends AbstractMember implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Member() {
	}

	/** minimal constructor */
	public Member(String id, String account, String password, String status,
			String email, String name, String ctype, Integer logincount,
			Timestamp ctime) {
		super(id, account, password, status, email, name, ctype, logincount,
				ctime);
	}

	/** full constructor */
	public Member(String id, Bank bank, Groups groups, Attachment image,
			Points points, String account, String password, String activation,
			String status, String email, String name, String ctype,
			String nickname, String idcard, Timestamp lastlogin,
			Integer logincount, Timestamp ctime, District district, 
			String address, String postcode, String telephone, 
			String mobile, String qq, String msn, Set prunaccs, Set orderses,
			Set orderitems, Set commentses, Set brunaccs, Set evaluates, Set permissions, Set staddresses) {
		super(id, bank, groups, image, points, account, password,
				activation, status, email, name, ctype, nickname, idcard,
				lastlogin, logincount, ctime, district, address, postcode, 
				telephone, mobile, qq, msn, prunaccs, orderses, orderitems, commentses,
				brunaccs, evaluates, permissions, staddresses);
	}

}
