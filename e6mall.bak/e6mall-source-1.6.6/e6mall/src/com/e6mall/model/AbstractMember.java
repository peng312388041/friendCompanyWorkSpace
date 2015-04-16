package com.e6mall.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.e6mall.utils.PasswordUtil;

/**
 * AbstractMember entity provides the base persistence definition of the Member
 * entity. @author bingzhou6@gmail.com
 */

public abstract class AbstractMember implements java.io.Serializable {

	// Fields

	private String id;
	private Bank bank;
	private Groups groups;
	private Attachment image;
	private Attachment vimage;//页面显示
	private Points points;
	private String account;
	private String password;
	private String activation;
	private String status;
	private String email;
	private String name;
	private String ctype;
	private String nickname;
	private String idcard;
	private Timestamp lastlogin;
	private Integer logincount;
	private Timestamp ctime;
	private District district;
	private String address;
	private String postcode;
	private String telephone;
	private String mobile;
	private String qq;
	private String msn;
	private Set prunaccs = new HashSet(0);
	private Set orderses = new HashSet(0);
	private Set orderitems = new HashSet(0);
	private Set commentses = new HashSet(0);
	private Set brunaccs = new HashSet(0);
	private Set evaluates = new HashSet(0);
	private Set permissions = new HashSet(0);
	private Set staddresses = new HashSet(0);
	
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
	public AbstractMember() {
	}

	/** minimal constructor */
	public AbstractMember(String id, String account, String password,
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
	public AbstractMember(String id, Bank bank, Groups groups,
			Attachment image, Points points, String account,
			String password, String activation, String status, String email,
			String name, String ctype, String nickname, String idcard,
			Timestamp lastlogin, Integer logincount, Timestamp ctime,
			District district, String address, String postcode, 
			String telephone, String mobile, String qq, String msn,
			Set prunaccs, Set orderses, Set orderitems, Set commentses, Set brunaccs,
			Set evaluates, Set permissions, Set staddresses) {
		this.id = id;
		this.bank = bank;
		this.groups = groups;
		this.image = image;
		this.points = points;
		this.account = account;
		this.password = password;
		this.activation = activation;
		this.status = status;
		this.email = email;
		this.name = name;
		this.ctype = ctype;
		this.nickname = nickname;
		this.idcard = idcard;
		this.lastlogin = lastlogin;
		this.logincount = logincount;
		this.ctime = ctime;
		this.district = district;
		this.address = address;
		this.postcode = postcode;
		this.telephone = telephone;
		this.mobile = mobile;
		this.qq = qq;
		this.msn = msn;
		this.prunaccs = prunaccs;
		this.orderses = orderses;
		this.orderitems = orderitems;
		this.commentses = commentses;
		this.brunaccs = brunaccs;
		this.evaluates = evaluates;
		this.permissions = permissions;
		this.staddresses = staddresses;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Bank getBank() {
		return this.bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Groups getGroups() {
		return this.groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
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

	public Points getPoints() {
		return this.points;
	}

	public void setPoints(Points points) {
		this.points = points;
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

	public String getActivation() {
		return this.activation;
	}

	public void setActivation(String activation) {
		this.activation = activation;
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

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public Set getPrunaccs() {
		return this.prunaccs;
	}

	public void setPrunaccs(Set prunaccs) {
		this.prunaccs = prunaccs;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

	public Set getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(Set orderitems) {
		this.orderitems = orderitems;
	}

	public Set getCommentses() {
		return commentses;
	}

	public void setCommentses(Set commentses) {
		this.commentses = commentses;
	}

	public Set getBrunaccs() {
		return this.brunaccs;
	}

	public void setBrunaccs(Set brunaccs) {
		this.brunaccs = brunaccs;
	}

	public Set getEvaluates() {
		return this.evaluates;
	}

	public void setEvaluates(Set evaluates) {
		this.evaluates = evaluates;
	}

	public Set getPermissions() {
		return permissions;
	}

	public void setPermissions(Set permissions) {
		this.permissions = permissions;
	}

	public Set getStaddresses() {
		return staddresses;
	}

	public void setStaddresses(Set staddresses) {
		this.staddresses = staddresses;
	}

}