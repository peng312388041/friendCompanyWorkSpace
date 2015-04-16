package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.IDocumentDAO;
import com.e6mall.model.Document;
import com.e6mall.services.ISDocument;
import com.e6mall.utils.PaginationSupport;

public class SDocument extends BaseServices implements ISDocument {
	private IDocumentDAO documentdao;

	public IDocumentDAO getDocumentdao() {
		return documentdao;
	}

	public void setDocumentdao(IDocumentDAO documentdao) {
		this.documentdao = documentdao;
	}

	public void attachClean(Document instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Document instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Document persistentInstance) {
		documentdao.delete(persistentInstance);
	}

	public List findAll() {
		List list = documentdao.findAll();
		return list;
	}

	public Document findById(String id) {
		Document document = documentdao.findById(id);
		return document;
	}

	public Document merge(Document detachedInstance) {
		Document document = documentdao.merge(detachedInstance);
		return document;
	}

	public void save(Document transientInstance) {
		documentdao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = documentdao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = documentdao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int startIndex) {
		PaginationSupport ps = documentdao.findPageByCriteria(detachedCriteria, startIndex);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex) {
		PaginationSupport ps = documentdao.findPageByCriteria(detachedCriteria, pageSize, startIndex);
		return ps;
	}
	
	public PaginationSupport findPageByIndex(DetachedCriteria detachedCriteria,
			int pageSize, int startIndex) {
		PaginationSupport ps = documentdao.findPageByIndex(detachedCriteria, pageSize, startIndex);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = documentdao.getCountByCriteria(detachedCriteria);
		return count;
	}
}
