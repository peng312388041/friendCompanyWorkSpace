package com.e6mall.action.member;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Brunacc;
import com.e6mall.model.Member;
import com.e6mall.model.Orders;
import com.e6mall.model.Paymode;
import com.e6mall.utils.Notice;
import com.e6mall.utils.PaginationSupport;
import com.e6mall.utils.alipay.PaymentUrl;

public class BankPayinAction extends BaseAction {
	private static final long serialVersionUID = 1285390137487002958L;
	private Notice notice = new Notice();
	private Member member;
	private List paymode_list;
	
	private Double payin = new Double(0);
	private String remarks;
	private String pm = "";//支付方式
	private String bra = "";
	private String urlparam;
	
	private PaginationSupport ps;
	private int pagesize = 12;
	private int page = 1;

	public String execute() throws Exception {
		member = smember.findById(getMsession().getId());
		paymode_list = spaymode.findAll();
		
		member = smember.findById(getMsession().getId());
		int startIndex = 0;
		startIndex = (page-1)*pagesize;
		DetachedCriteria dc = DetachedCriteria.forClass(Brunacc.class);
		dc.add(Property.forName("bank").eq(member.getBank()));
		dc.addOrder(Order.desc("ctime"));
		ps = sbrunacc.findPageByCriteria(dc, pagesize, startIndex);
		return SUCCESS;
	}
	
	public String payin() throws Exception {
		Paymode paymode = spaymode.findById(pm);
		member = smember.findById(getMsession().getId());
		Brunacc brunacc = new Brunacc();
		brunacc.setPaymode(paymode);
		brunacc.setId(getUuid());
		brunacc.setPayin(payin);
		brunacc.setRemarks(remarks);
		brunacc.setStatus("waitpay");	//等待付款
		
		Double ob = member.getBank().getBalance();
		Double balance = payin + ob;
		
		brunacc.setBalance(balance);
		brunacc.setTabloid("充值");
		brunacc.setCtime(getTimestamp());
		brunacc.setBank(member.getBank());
		brunacc.setMember(member);
		brunacc = sbrunacc.merge(brunacc);
		setBra(brunacc.getId());

		return SUCCESS;
	}
	
	public String alipay() throws Exception {
		Brunacc brunacc = sbrunacc.findById(bra);
		Paymode paymode = brunacc.getPaymode();
		
		if (null != paymode && (paymode.getPmtype().equals("alipay"))) {
			Orders orders = new Orders();
			orders.setPaymode(paymode);
			
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");//年月日小时分秒毫秒
			//String code = sdf.format(new Date()) + RandomStringUtils.random(3, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
			orders.setCode(brunacc.getId());//用流水记录ID作为订单号，返回时处理这个ID  TODO
			orders.setSubject("充值");
			orders.setActamount(brunacc.getPayin());
			orders.setLogicost(new Double(0));	//没有物流费用
			orders.setBody(brunacc.getRemarks());
			
			PaymentUrl payment = new PaymentUrl();
			String preUrl = "http://" + request.getHeader("host") + request.getContextPath();
			urlparam = payment.getUrlparam(orders, preUrl);
			if (!urlparam.equals(""))
				return SUCCESS;
		}
		return ERROR;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Double getPayin() {
		return payin;
	}

	public void setPayin(Double payin) {
		this.payin = payin;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPm() {
		return pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}

	public String getBra() {
		return bra;
	}

	public void setBra(String bra) {
		this.bra = bra;
	}

	public String getUrlparam() {
		return urlparam;
	}

	public void setUrlparam(String urlparam) {
		this.urlparam = urlparam;
	}

	public List getPaymode_list() {
		return paymode_list;
	}

	public void setPaymode_list(List paymodeList) {
		paymode_list = paymodeList;
	}

	public PaginationSupport getPs() {
		return ps;
	}

	public void setPs(PaginationSupport ps) {
		this.ps = ps;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
