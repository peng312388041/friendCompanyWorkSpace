package com.e6mall.action;

import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.Cookie;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;

import com.e6mall.model.Brand;
import com.e6mall.model.Goods;
import com.e6mall.model.Spec;
import com.e6mall.model.Specitem;
import com.e6mall.model.Specvalue;
import com.e6mall.utils.PaginationSupport;

public class GoodsAction extends BaseAction {
	private static final long serialVersionUID = -7057490756530517233L;
	private String gs;
	private Goods goods;
	private Set<Specitem> specitems = new HashSet<Specitem>();//该商品的所有规格顶
	private PaginationSupport brandPs;		//所有品牌
	private PaginationSupport reGoodsPs;	//推荐商品

	public String execute() throws Exception {
		GlobalChcontent(map);
		goods = sgoods.findById(gs);
		//Map specitems = new HashMap();
		Iterator it = goods.getSpecs().iterator();//商品的所有规格
		
		int i=0;
		while (it.hasNext()) {
			Spec spec = (Spec)it.next();
			Iterator it2 = spec.getSpecvalues().iterator();//某规格的所有规格值
			
			while (it2.hasNext()) {
				Specvalue specvalue = (Specvalue)it2.next();
				Specitem specitem = specvalue.getSpecitem();//取得这个规格值的规格项
				
				if (specitems.contains(specitem)) {//如果总集合中包含这个规格项
					//System.out.println("已有"+specitem.getName());
					Iterator it3 = specitems.iterator();
					while (it3.hasNext()) {//循环总集合中的所有规格项
						Specitem si = (Specitem)it3.next();
						if (specitem.equals(si)) {//与当前的规格项比较
							//System.out.println("找到"+specitem.getName());
							si.getSpecvalues().add(specvalue);//如果相等就加入当前的规格值
							//System.out.println("加入值"+specvalue.getName());
						}
					}
				} else {//否则就加入这个规格项
					System.out.println("新加入"+specitem.getName());
					specitem.setSpecvalues(new HashSet());//清空
					specitem.getSpecvalues().add(specvalue);//加入当前规格值
					specitems.add(specitem);
				}
				i++;
			}
		}
		
		Iterator it2 = specitems.iterator();
		while (it2.hasNext()) {
			Specitem si = (Specitem)it2.next();
			System.out.println(si.getName()+si.getSpecvalues().size());
			Iterator it4 = si.getSpecvalues().iterator();
			while (it4.hasNext()) {
				Specvalue sp = (Specvalue)it4.next();
				System.out.println(sp.getName());
			}
		}
		String name = URLEncoder.encode(goods.getName(),"UTF-8");
		Cookie cookie = new Cookie(goods.getId(), name);
		cookie.setPath("/");
	    cookie.setMaxAge(31536000);// 一年
	    response.addCookie(cookie);
		
		//所有品牌
		DetachedCriteria bdc = DetachedCriteria.forClass(Brand.class);
		bdc.addOrder(Order.asc("csort"));
		int pagesize = 12;//TODO 全局配置
		int page = 1;
		brandPs = sbrand.findPageByCriteria(bdc, pagesize, page);
		
		//推荐商品
		DetachedCriteria gdc = DetachedCriteria.forClass(Goods.class);
		gdc.add(Property.forName("status").eq("recommend"));
		gdc.add(Property.forName("locale").eq(getDefLocale()));
		gdc.addOrder(Order.asc("csort"));
		gdc.addOrder(Order.desc("ctime"));
		reGoodsPs = sgoods.findPageByCriteria(gdc, pagesize, page);
		
		return SUCCESS;
	}

	public String getGs() {
		return gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Set<Specitem> getSpecitems() {
		return specitems;
	}

	public void setSpecitems(Set<Specitem> specitems) {
		this.specitems = specitems;
	}

	public PaginationSupport getBrandPs() {
		return brandPs;
	}

	public void setBrandPs(PaginationSupport brandPs) {
		this.brandPs = brandPs;
	}

	public PaginationSupport getReGoodsPs() {
		return reGoodsPs;
	}

	public void setReGoodsPs(PaginationSupport reGoodsPs) {
		this.reGoodsPs = reGoodsPs;
	}
}
