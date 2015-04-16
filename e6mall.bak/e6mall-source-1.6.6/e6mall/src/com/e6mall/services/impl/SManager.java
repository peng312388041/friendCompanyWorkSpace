package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.IManagerDAO;
import com.e6mall.model.Manager;
import com.e6mall.services.ISManager;
import com.e6mall.utils.Notice;
import com.e6mall.utils.PaginationSupport;
import com.e6mall.utils.PasswordUtil;
import com.opensymphony.xwork2.ActionContext;

public class SManager extends BaseServices implements ISManager {
	private IManagerDAO managerdao;

	public IManagerDAO getManagerdao() {
		return managerdao;
	}

	public void setManagerdao(IManagerDAO managerdao) {
		this.managerdao = managerdao;
	}
	
	public Notice login(String account, String password, String validateCode) {
		Notice notice = new Notice();
		String verifyCode = (String) ActionContext.getContext().getSession().get("VerifyCode");
		if (null != verifyCode && verifyCode.equals(validateCode)) {
			Manager manager = managerdao.findByAccount(account);
			if (null != manager) {
				//if (password.equals(manager.getPassword())) {
				if (PasswordUtil.authenticatePassword(manager.getPassword(), password)) {
					if (!manager.getStatus().equals("noactived")) {
						session.put("manager", manager);
						notice.setStatus(true);
						notice.setCode("login success");
						notice.setTitle("提示");
						notice.setBody("登陆成功");
						
						//更新登录次数及最后登录时间
						manager.setLogincount(manager.getLogincount()+1);
						manager.setLastlogin(getTimestamp());
						managerdao.merge(manager);
					} else {
						notice.setStatus(false);
						notice.setCode("account not actived");
						notice.setTitle("错误");
						notice.setBody("该账号未激活");
					}
				} else {
					notice.setStatus(false);
					notice.setCode("account or password error");
					notice.setTitle("错误");
					notice.setBody("您的用户名或者密码输入错误，请重试");
				}
			} else {
				notice.setStatus(false);
				notice.setCode("account not exist");
				notice.setTitle("错误");
				notice.setBody("该账号不存在");
			}
		} else {
			notice.setStatus(false);
			notice.setCode("verifyCode error");
			notice.setTitle("错误");
			notice.setBody("验证码错误");
		}
		return notice;
	}

	public void attachClean(Manager instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Manager instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Manager persistentInstance) {
		managerdao.delete(persistentInstance);
	}

	public List findAll() {
		List list = managerdao.findAll();
		return list;
	}

	public Manager findById(String id) {
		Manager manager = managerdao.findById(id);
		return manager;
	}
	
	public Manager findByAccount(String account) {
		Manager manager = managerdao.findByAccount(account);
		return manager;
	}

	public Manager merge(Manager detachedInstance) {
		Manager manager = managerdao.merge(detachedInstance);
		return manager;
	}

	public void save(Manager manager) {
		Manager m = managerdao.findByAccount(manager.getAccount());
		if (null != m) {
		} else {
			managerdao.save(manager);
		}
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = managerdao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = managerdao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int startIndex) {
		PaginationSupport ps = managerdao.findPageByCriteria(detachedCriteria, startIndex);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex) {
		PaginationSupport ps = managerdao.findPageByCriteria(detachedCriteria, pageSize, startIndex);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = managerdao.getCountByCriteria(detachedCriteria);
		return count;
	}

}
