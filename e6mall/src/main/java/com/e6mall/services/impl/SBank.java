package com.e6mall.services.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.IBankDAO;
import com.e6mall.model.Bank;
import com.e6mall.services.ISBank;
import com.e6mall.utils.CMember;
import com.e6mall.utils.PaginationSupport;

public class SBank extends BaseServices implements ISBank {
	private IBankDAO bankdao;

	public IBankDAO getBankdao() {
		return bankdao;
	}

	public void setBankdao(IBankDAO bankdao) {
		this.bankdao = bankdao;
	}

	public void attachClean(Bank instance) {
		bankdao.attachClean(instance);
	}

	public void attachDirty(Bank instance) {
		bankdao.attachDirty(instance);
	}

	public void delete(Bank persistentInstance) {
		bankdao.delete(persistentInstance);
	}
	
	/**  
     * 资金账户开户：为客户的会员账号开通资金管理账户，该账户记录消费历史及资金余额管理。 
     */
	public Bank openaccount() {
		Bank bank = new Bank();
		bank.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		String randint = RandomStringUtils.randomNumeric(8);
		bank.setAccount("88888888" + randint);//TODO 前8位是商家随机码，后8位是用户随机码
		bank.setStatus(CMember.NORMAL);
		bank.setBalance(new Double(0));
		bank.setRemarks(CMember.NOTICE_BANK_ACC_OPEN);
		bank.setCtime(new Timestamp(System.currentTimeMillis()));
		bank = bankdao.merge(bank);
		return bank;
	}

	public List findAll() {
		List list = bankdao.findAll();
		return list;
	}

	public Bank findById(String id) {
		Bank bank = bankdao.findById(id);
		return bank;
	}

	public Bank merge(Bank detachedInstance) {
		Bank bank = bankdao.merge(detachedInstance);
		return bank;
	}

	public void save(Bank transientInstance) {
		bankdao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = bankdao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = bankdao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int startIndex) {
		PaginationSupport ps = bankdao.findPageByCriteria(detachedCriteria, startIndex);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex) {
		PaginationSupport ps = bankdao.findPageByCriteria(detachedCriteria, pageSize, startIndex);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = bankdao.getCountByCriteria(detachedCriteria);
		return count;
	}

}
