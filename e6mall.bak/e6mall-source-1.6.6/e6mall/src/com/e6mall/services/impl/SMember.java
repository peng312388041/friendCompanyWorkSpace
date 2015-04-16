package com.e6mall.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.dao.IMemberDAO;
import com.e6mall.model.Bank;
import com.e6mall.model.Member;
import com.e6mall.model.Points;
import com.e6mall.services.ISAttachment;
import com.e6mall.services.ISBank;
import com.e6mall.services.ISMember;
import com.e6mall.services.ISOrderitem;
import com.e6mall.services.ISPoints;
import com.e6mall.utils.CMember;
import com.e6mall.utils.Notice;
import com.e6mall.utils.PaginationSupport;
import com.e6mall.utils.PasswordUtil;
import com.opensymphony.xwork2.ActionContext;

public class SMember extends BaseServices implements ISMember {
	private IMemberDAO memberdao;
	private ISOrderitem sorderitem;
	private ISBank sbank;
	private ISPoints spoints;
	private ISAttachment sattachment;

	public IMemberDAO getMemberdao() {
		return memberdao;
	}

	public void setMemberdao(IMemberDAO memberdao) {
		this.memberdao = memberdao;
	}
	
	public ISOrderitem getSorderitem() {
		return sorderitem;
	}

	public void setSorderitem(ISOrderitem sorderitem) {
		this.sorderitem = sorderitem;
	}

	public ISBank getSbank() {
		return sbank;
	}

	public void setSbank(ISBank sbank) {
		this.sbank = sbank;
	}

	public ISPoints getSpoints() {
		return spoints;
	}

	public void setSpoints(ISPoints spoints) {
		this.spoints = spoints;
	}

	public ISAttachment getSattachment() {
		return sattachment;
	}

	public void setSattachment(ISAttachment sattachment) {
		this.sattachment = sattachment;
	}

	public Notice register(Member member, String validateCode) {
		Notice notice = new Notice();
		String verifyCode = (String) ActionContext.getContext().getSession().get("VerifyCode");
		if (null != verifyCode && verifyCode.equals(validateCode)) {
			String account = member.getAccount();
			Member m = memberdao.findByAccount(account);
			if (null != m && !m.getAccount().equals("")) {
				notice.setStatus(false);
				notice.setCode("user exist");
				notice.setTitle("提示");
				notice.setBody("该账号已被使用");
				return notice;
			}
			member.setId(getUuid());
			member.setActivation(member.getId());
			member.setStatus(CMember.NORMAL);
			member.setCtype(CMember.NORMAL);
			member.setLogincount(0);
			member.setCtime(getTimestamp());
			memberdao.save(member);
			
			//直接开通资金和积分账户
			Bank bank = sbank.openaccount();
			member.setBank(bank);
			Points points = spoints.openaccount();
			member.setPoints(points);
			member = memberdao.merge(member);
			
			notice.setStatus(true);
			notice.setCode("register success");
			notice.setTitle("提示");
			notice.setBody("注册成功");
		} else {
			notice.setStatus(false);
			notice.setCode("validateCode error");
			notice.setTitle("错误");
			notice.setBody("验证码错误");
			return notice;
		}
		return notice;
	}
	
	public Notice login(String account, String password, String validateCode) {
		Notice notice = new Notice();
		String verifyCode = (String) ActionContext.getContext().getSession().get("VerifyCode");
		if (null != verifyCode && verifyCode.equals(validateCode)) {
			Member member = memberdao.findByAccount(account);
			if (null != member) {
				//if (password.equals(member.getPassword())) {
				if (PasswordUtil.authenticatePassword(member.getPassword(), password)) {
					if (!member.getStatus().equals("notactived")) {
						session.put("member", member);
						notice.setStatus(true);
						notice.setCode("login success");
						notice.setTitle("提示");
						notice.setBody("登陆成功");
						
						//更新登录次数及最后登录时间
						member.setLogincount(member.getLogincount()+1);
						member.setLastlogin(getTimestamp());
						memberdao.merge(member);
						
						//转移session购物车中的商品到持久购物车中
						/*Orders orders = (Orders)session.get("orders");
						if (null != orders) {
							Iterator itr = orders.getOrderitems().iterator();
							while(itr.hasNext()){
								Orderitem oi = (Orderitem)itr.next();
								oi.setOrders(null);
								oi.setMember(member);
								sorderitem.save(oi);
							}
						}*/
						
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

	public void attachClean(Member instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Member instance) {
		// TODO Auto-generated method stub

	}

	/**  
     * 删除会员，同时删除该会员的资金账户与积分账户。
     * @param member 会员实体
     */
	public void delete(Member member) {
		if (null != member.getBank())
			sbank.delete(member.getBank());
		if (null != member.getPoints())
			spoints.delete(member.getPoints());
		if (null != member.getImage())
			sattachment.delete(member.getImage());
		memberdao.delete(member);
	}

	public List findAll() {
		List list = memberdao.findAll();
		return list;
	}

	public Member findById(String id) {
		Member member = memberdao.findById(id);
		return member;
	}

	public Member merge(Member detachedInstance) {
		Member member = memberdao.merge(detachedInstance);
		return member;
	}

	public void save(Member member) {
		member.setId(getUuid());
		member.setActivation(member.getId());
		//member.setStatus(CMember.NORMAL);
		member.setCtype(CMember.NORMAL);
		member.setLogincount(0);
		member.setCtime(getTimestamp());
		memberdao.save(member);
		//直接开通资金和积分账户
		Bank bank = sbank.openaccount();
		member.setBank(bank);
		Points points = spoints.openaccount();
		member.setPoints(points);
		member = memberdao.merge(member);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = memberdao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = memberdao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int page) {
		PaginationSupport ps = memberdao.findPageByCriteria(detachedCriteria, page);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int page) {
		PaginationSupport ps = memberdao.findPageByCriteria(detachedCriteria, pageSize, page);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = memberdao.getCountByCriteria(detachedCriteria);
		return count;
	}

}
