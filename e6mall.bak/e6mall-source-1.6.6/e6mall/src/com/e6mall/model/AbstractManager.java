package com.e6mall.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.e6mall.utils.PasswordUtil;

/**
 * AbstractManager entity provides the base persistence definition of the
 * Manager entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractManager implements java.io.Serializable {

	// Fields

	private String id;
	private Mgroups mgroups;
	private Attachment image;
	private Attachment vimage;//页面显示
	private String account;
	private String password;
	private String status;
	private String email;
	private String name;
	private String ctype;
	private String nickname;
	private String idcard;
	private Timestamp lastlogin;
	private Integer logincount;
	private Timestamp ctime;
	private Set prunaccs = new HashSet(0);
	private Set attachments = new HashSet(0);
	private Set brunaccs = new HashSet(0);
	private Set permissions = new HashSet(0);
	private Set goodses = new HashSet(0);
	private Set documents = new HashSet(0);
	private Set channels = new HashSet(0);
	private Set chcontents = new HashSet(0);
	
	//非数据库字段
	private String cpassword;	//明文密码

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
		this.password = PasswordUtil.createPassword(cpassword);
	}
	
	// Constructors
	/** default constructor */
	public AbstractManager() {
	}

	/** minimal constructor */
	public AbstractManager(String id, String account, String password,
			String status, String email, String name, String ctype,
			Integer logincount, Timestamp ctime) {
		this.id = id;
		this.account = account;
		this.password = password;
		this.status = status;
		this.email = email;
		this.name = name;
		this.ctype = ctype;
		this.logincount = logincount;
		this.ctime = ctime;
	}

	/** full constructor */
	public AbstractManager(String id, Mgroups mgroups, Attachment image,
			String account, String password, String status, String email,
			String name, String ctype, String nickname, String idcard,
			Timestamp lastlogin, Integer logincount, Timestamp ctime,
			Set prunaccs, Set attachments, Set brunaccs, Set permissions,
			Set goodses, Set documents, Set channels, Set chcontents) {
		this.id = id;
		this.mgroups = mgroups;
		this.image = image;
		this.account = account;
		this.password = password;
		this.status = status;
		this.email = email;
		this.name = name;
		this.ctype = ctype;
		this.nickname = nickname;
		this.idcard = idcard;
		this.lastlogin = lastlogin;
		this.logincount = logincount;
		this.ctime = ctime;
		this.prunaccs = prunaccs;
		this.attachments = attachments;
		this.brunaccs = brunaccs;
		this.permissions = permissions;
		this.goodses = goodses;
		this.documents = documents;
		this.channels = channels;
		this.chcontents = chcontents;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Mgroups getMgroups() {
		return this.mgroups;
	}

	public void setMgroups(Mgroups mgroups) {
		this.mgroups = mgroups;
	}

	public Attachment getImage() {
		return image;
	}

	public void setImage(Attachment image) {
		this.image = image;
	}
	
	public Attachment getVimage() {
		if (null != image) {
			return image;
		} else {
			Attachment i = new Attachment();
			i.setPath("/images/sys");
			i.setName("nopic.jpg");
			return i;
		}
	}

	public void setVimage(Attachment vimage) {
		this.vimage = vimage;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCtype() {
		return this.ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public Timestamp getLastlogin() {
		return this.lastlogin;
	}

	public void setLastlogin(Timestamp lastlogin) {
		this.lastlogin = lastlogin;
	}

	public Integer getLogincount() {
		return this.logincount;
	}

	public void setLogincount(Integer logincount) {
		this.logincount = logincount;
	}

	public Timestamp getCtime() {
		return this.ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

	public Set getPrunaccs() {
		return this.prunaccs;
	}

	public void setPrunaccs(Set prunaccs) {
		this.prunaccs = prunaccs;
	}

	public Set getAttachments() {
		return this.attachments;
	}

	public void setAttachments(Set attachments) {
		this.attachments = attachments;
	}

	public Set getBrunaccs() {
		return this.brunaccs;
	}

	public void setBrunaccs(Set brunaccs) {
		this.brunaccs = brunaccs;
	}

	public Set getPermissions() {
		return permissions;
	}

	public void setPermissions(Set permissions) {
		this.permissions = permissions;
	}

	public Set getGoodses() {
		return this.goodses;
	}

	public void setGoodses(Set goodses) {
		this.goodses = goodses;
	}

	public Set getDocuments() {
		return documents;
	}

	public void setDocuments(Set documents) {
		this.documents = documents;
	}

	public Set getChannels() {
		return channels;
	}

	public void setChannels(Set channels) {
		this.channels = channels;
	}

	public Set getChcontents() {
		return chcontents;
	}

	public void setChcontents(Set chcontents) {
		this.chcontents = chcontents;
	}

}