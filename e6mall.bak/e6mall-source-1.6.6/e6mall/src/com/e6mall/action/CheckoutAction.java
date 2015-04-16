package com.e6mall.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.e6mall.model.Goods;
import com.e6mall.model.Lsarea;
import com.e6mall.model.Member;
import com.e6mall.model.Orderitem;
import com.e6mall.model.Orders;
import com.e6mall.model.Paymode;
import com.e6mall.model.Spec;
import com.e6mall.model.Staddress;
import com.e6mall.utils.COrders;
import com.e6mall.utils.Constants;
import com.e6mall.utils.Notice;

public class CheckoutAction extends BaseAction {
	private static final long serialVersionUID = -7022458098977117098L;
	private Notice notice = new Notice();
	private String str;
	private Staddress staddress = new Staddress();
	private String pm;
	private Orders orders = new Orders();
	private String os;//转向
	
	public String execute() throws Exception {
		//收货地址
		if (null != str && !str.equals("")) {
			staddress = sstaddress.findById(str);
		} else {
			staddress.setId(getUuid());
			staddress.setMember(getMsession());
			staddress.setStatus(Constants.NORMAL);
			sstaddress.save(staddress);
		}
		
		Lsarea lsarea = null;
		if (null != staddress.getDistrict()) {
			DetachedCriteria dc = DetachedCriteria.forClass(Lsarea.class);
			dc.createCriteria("districts").add(Restrictions.eq("id", staddress.getDistrict().getId()));
			List list = slsarea.findAllByCriteria(dc);
			if (null != list && list.size()>0) {
				lsarea = (Lsarea)list.get(0);
			}
		}
		
		Paymode paymode = spaymode.findById(pm);
		Orders ods = (Orders)session.get("orders");
		if (null == lsarea) {
			DetachedCriteria dc2 = DetachedCriteria.forClass(Lsarea.class);
			dc2.add(Property.forName("status").eq("default"));//如果客户不在可选择的区域内，对应的物流区域为NULL，就查找系统内的默认物流区域
			List list2 = slsarea.findAllByCriteria(dc2);
			if (null != list2 && list2.size()>0) {
				lsarea = (Lsarea)list2.get(0);
			}
		}
		//if (null != staddress && null != lsarea && null != paymode && null != ods) {
		if (null != staddress && null != paymode && null != ods) {
			orders.setId(getUuid());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");//年月日小时分秒毫秒
			String code = sdf.format(new Date()) + RandomStringUtils.random(3, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
			System.out.println(code);
			orders.setCode(code);
			orders.setSubject("");
			orders.setBody("");
			orders.setStatus(COrders.WAIT_BUYER_PAY);
			orders.setMember(getMsession());
			orders.setCtime(getTimestamp());
			orders.setAmount(new Double(0));
			orders.setStaddress(staddress);
			orders.setLsarea(lsarea);
			orders.setPaymode(paymode);
			orders.setBaojia(new Double(0));
			orders.setInvoicetitle("");
			orders.setDuty(new Double(0));
			orders.setDiscount(new Double(0));
			orders.setActamount(orders.getAmount());
			orders.setLogicost(new Double(0));
			orders.setWeight(new Double(0));
			orders.setPaycost(new Double(0));
			orders = sorders.merge(orders);
			
			Iterator it = ods.getOrderitems().iterator();
			
			Double weight = new Double(0);
			Double amount = new Double(0);
			while (it.hasNext()) {
				Orderitem oi = (Orderitem)it.next();
				oi.setMember(getMsession());
				oi.setOrders(orders);
				sorderitem.merge(oi);
				if (null != oi.getSpec() && null != oi.getSpec().getWeight())
					weight += oi.getSpec().getWeight() * oi.getNumber();
				else if (null != oi.getGoods().getWeight())
					weight += oi.getGoods().getWeight() * oi.getNumber();
					
				amount += oi.getSubtotal();
				orders.setSubject(oi.getGoods().getName()+"...");	//设置订单主题
				orders.setBody(oi.getGoods().getName()+"...");		//设置订单描述
				
				//减库存
				Integer number = oi.getNumber();
				Spec spec = oi.getSpec();
				if (null != spec) {
					spec.setInventory(spec.getInventory() - number);
					sspec.merge(spec);
				} else {
					Goods goods = oi.getGoods();
					if ((goods.getInventory() - number) >= 0) {
						goods.setInventory(goods.getInventory() - number);
						sgoods.merge(goods);
					}
				}
			}
			//更新商品总重量
			orders.setLogicost(lsarea.getLogicost(weight));
			//orders.setLogicost(new Double(0));
			orders.setWeight(weight);
			orders.setAmount(amount);
			orders.setActamount(amount);	//支付宝会加上运货，不需在这里加，这里只需要处理折扣
			orders.setPaycost((paymode.getRate() / 100) * amount);	//TODO 还是要在模型里处理，要减去免费额度
			sorders.merge(orders);
			
			setOs(orders.getId());
			session.remove("orders");
			return SUCCESS;
		} else {
			notice.setStatus(false);
			notice.setCode("cart is null");
			notice.setTitle("提示");
			notice.setBody("无法完成订单，原因可能是：1、购物车是空的；2、填写的信息有误；3、物流暂时无法配送到您所填写的区域。请联系管理员，感谢您的支持！");
			return ERROR;
		}
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Staddress getStaddress() {
		return staddress;
	}

	public void setStaddress(Staddress staddress) {
		this.staddress = staddress;
	}

	public String getPm() {
		return pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}
}
