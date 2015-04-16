package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.ICommentsDAO;
import com.e6mall.model.Comments;
import com.e6mall.services.ISComments;
import com.e6mall.utils.PaginationSupport;

public class SComments extends BaseServices implements ISComments {
	private ICommentsDAO commentsdao;

	public ICommentsDAO getCommentsdao() {
		return commentsdao;
	}

	public void setCommentsdao(ICommentsDAO commentsdao) {
		this.commentsdao = commentsdao;
	}

	public void attachClean(Comments instance) {
		commentsdao.attachClean(instance);
	}

	public void attachDirty(Comments instance) {
		commentsdao.attachDirty(instance);
	}

	public void delete(Comments persistentInstance) {
		commentsdao.delete(persistentInstance);
	}

	public List findAll() {
		List list = commentsdao.findAll();
		return list;
	}

	public Comments findById(String id) {
		Comments comments = commentsdao.findById(id);
		return comments;
	}

	public List findByStatus(Object status) {
		List list = commentsdao.findByStatus(status);
		return list;
	}

	public Comments merge(Comments detachedInstance) {
		Comments comments = commentsdao.merge(detachedInstance);
		return comments;
	}

	public void save(Comments transientInstance) {
		commentsdao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = commentsdao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = commentsdao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int page) {
		PaginationSupport ps = commentsdao.findPageByCriteria(detachedCriteria, page);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int page) {
		PaginationSupport ps = commentsdao.findPageByCriteria(detachedCriteria, pageSize, page);
		return ps;
	}

	public PaginationSupport findPageByIndex(DetachedCriteria detachedCriteria,
			int pageSize, int startIndex) {
		PaginationSupport ps = commentsdao.findPageByIndex(detachedCriteria, pageSize, startIndex);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = commentsdao.getCountByCriteria(detachedCriteria);
		return count;
	}
}
