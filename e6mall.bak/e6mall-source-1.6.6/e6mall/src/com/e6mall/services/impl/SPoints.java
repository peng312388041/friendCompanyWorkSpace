package com.e6mall.services.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.IPointsDAO;
import com.e6mall.model.Points;
import com.e6mall.services.ISPoints;
import com.e6mall.utils.CMember;
import com.e6mall.utils.PaginationSupport;

public class SPoints extends BaseServices implements ISPoints {
	private IPointsDAO pointsdao;

	public IPointsDAO getPointsdao() {
		return pointsdao;
	}

	public void setPointsdao(IPointsDAO pointsdao) {
		this.pointsdao = pointsdao;
	}

	public void attachClean(Points instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Points instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Points persistentInstance) {
		pointsdao.delete(persistentInstance);
	}
	
	/**  
     * 积分账户开户：为客户的会员账号开通积分管理账户，该账户记录消费历史及积分余额管理。  
     */
	public Points openaccount() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String randint = RandomStringUtils.randomNumeric(8);
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		Points points = new Points();
		points.setId(uuid);
		points.setAccount("88888888" + randint);//TODO 前8位是商家随机码，后8位是用户随机码
		points.setStatus(CMember.NORMAL);
		points.setBalance(0);
		points.setRemarks(CMember.NOTICE_BANK_ACC_OPEN);
		points.setCtime(ts);
		pointsdao.merge(points);
		return points;
	}

	public List findAll() {
		List list = pointsdao.findAll();
		return list;
	}

	public Points findById(String id) {
		Points points = pointsdao.findById(id);
		return points;
	}

	public Points merge(Points detachedInstance) {
		Points points = pointsdao.merge(detachedInstance);
		return points;
	}

	public void save(Points transientInstance) {
		pointsdao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = pointsdao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = pointsdao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int startIndex) {
		PaginationSupport ps = pointsdao.findPageByCriteria(detachedCriteria, startIndex);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex) {
		PaginationSupport ps = pointsdao.findPageByCriteria(detachedCriteria, pageSize, startIndex);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = pointsdao.getCountByCriteria(detachedCriteria);
		return count;
	}

}
