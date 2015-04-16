package com.e6mall.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractComments entity provides the base persistence definition of the
 * Comments entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractComments implements java.io.Serializable {

	// Fields

	private String id;
	private Member member;
	private Goods goods;
	private Comments comments;
	private String title;
	private String content;
	private String status;
	private Timestamp cdate;
	private Set commentses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractComments() {
	}

	/** minimal constructor */
	public AbstractComments(String id, Goods goods, String content,
			String status, Timestamp cdate) {
		this.id = id;
		this.goods = goods;
		this.content = content;
		this.status = status;
		this.cdate = cdate;
	}

	/** full constructor */
	public AbstractComments(String id, Member member, Goods goods,
			Comments comments, String title, String content, String status,
			Timestamp cdate, Set commentses) {
		this.id = id;
		this.member = member;
		this.goods = goods;
		this.comments = comments;
		this.title = title;
		this.content = content;
		this.status = status;
		this.cdate = cdate;
		this.commentses = commentses;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Comments getComments() {
		return this.comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCdate() {
		return this.cdate;
	}

	public void setCdate(Timestamp cdate) {
		this.cdate = cdate;
	}

	public Set getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set commentses) {
		this.commentses = commentses;
	}

}