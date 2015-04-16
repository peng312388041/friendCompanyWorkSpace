package com.e6mall.model;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Manager entity. @author bingzhou6@gmail.com
 */
public class Manager extends AbstractManager implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Manager() {
	}

	/** minimal constructor */
	public Manager(String id, String account, String password, String status,
			String email, String name, String ctype, Integer logincount,
			Timestamp ctime) {
		super(id, account, password, status, email, name, ctype, logincount,
				ctime);
	}

	/** full constructor */
	public Manager(String id, Mgroups mgroups, Attachment image,
			String account, String password, String status, String email,
			String name, String ctype, String nickname, String idcard,
			Timestamp lastlogin, Integer logincount, Timestamp ctime,
			Set prunaccs, Set attachments, Set brunaccs, Set permissions,
			Set goodses, Set documents, Set channels, Set chcontents) {
		super(id, mgroups, image, account, password, status, email, name,
				ctype, nickname, idcard, lastlogin, logincount, ctime,
				prunaccs, attachments, brunaccs, permissions, goodses, documents, channels, chcontents);
	}

}
