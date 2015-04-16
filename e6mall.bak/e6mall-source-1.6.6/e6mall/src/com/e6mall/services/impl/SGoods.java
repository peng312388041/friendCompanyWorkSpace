package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.IGoodsDAO;
import com.e6mall.model.Goods;
import com.e6mall.services.ISGoods;
import com.e6mall.utils.PaginationSupport;

public class SGoods extends BaseServices implements ISGoods {
	private IGoodsDAO goodsdao;

	public IGoodsDAO getGoodsdao() {
		return goodsdao;
	}

	public void setGoodsdao(IGoodsDAO goodsdao) {
		this.goodsdao = goodsdao;
	}

	public void attachClean(Goods instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Goods instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Goods persistentInstance) {
		goodsdao.delete(persistentInstance);
	}

	public List findAll() {
		List list = goodsdao.findAll();
		return list;
	}

	public Goods findById(String id) {
		Goods goods = goodsdao.findById(id);
		return goods;
	}

	public Goods merge(Goods detachedInstance) {
		Goods goods = goodsdao.merge(detachedInstance);
		return goods;
	}

	public void save(Goods transientInstance) {
		goodsdao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = goodsdao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = goodsdao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int startIndex) {
		PaginationSupport ps = goodsdao.findPageByCriteria(detachedCriteria, startIndex);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex) {
		PaginationSupport ps = goodsdao.findPageByCriteria(detachedCriteria, pageSize, startIndex);
		return ps;
	}
	
	public PaginationSupport findPageByIndex(DetachedCriteria detachedCriteria,
			int pageSize, int startIndex) {
		PaginationSupport ps = goodsdao.findPageByIndex(detachedCriteria, pageSize, startIndex);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = goodsdao.getCountByCriteria(detachedCriteria);
		return count;
	}
}
