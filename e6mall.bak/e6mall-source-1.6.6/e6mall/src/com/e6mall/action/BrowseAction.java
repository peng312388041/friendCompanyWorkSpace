package com.e6mall.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.e6mall.model.Brand;
import com.e6mall.model.Category;
import com.e6mall.model.Eavalue;
import com.e6mall.model.Extattr;
import com.e6mall.model.Goods;
import com.e6mall.utils.PaginationSupport;

public class BrowseAction extends BaseAction {
	private static final long serialVersionUID = -7140811732302806602L;
	private String c = "";	//加默认值，修正搜索商品时没有选择类别属性异常
	private Category category;
	private String keyword;
	private String[] ev;
	private Eavalue eavalue;
	private String bd;
	private Brand brand;
	private PaginationSupport ps;
	private int pagesize = 12;
	private int page = 1;
	
	//private Set<Extattr> extattrSet = new HashSet<Extattr>();//所有商品扩展属性
	private ArrayList<Extattr> extattrSet = new ArrayList<Extattr>();
	private Set<Brand> brandSet = new HashSet<Brand>();//所有商品品牌

	public String execute() throws Exception {
		GlobalChcontent(map);
		if (!c.equals("")) {	//修正商品列表页没有类别ID异常
			category = scategory.findById(c);
		}
		DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
		
		//商品状态，不包含下架商品
		Disjunction defaultDis = Restrictions.disjunction();
		defaultDis.add(Property.forName("status").eq("normal"));
		defaultDis.add(Property.forName("status").eq("recommend"));
		dc.add(defaultDis);
		
		//商品类别及所有子类别
		if (null != category) {
			Disjunction dis = Restrictions.disjunction();
			dis.add(Property.forName("category").eq(category));
			dc.createAlias("category", "c");
			dis.add(Restrictions.like("c.nodepath", category.getId(), MatchMode.ANYWHERE));
			dc.add(dis);
		}
		
		//商品关键词
		if(null != keyword)
			dc.add(Property.forName("name").like(keyword, MatchMode.ANYWHERE));
		
		//商品扩展属性值
		/*if (null != ev && !ev.equals("") && ev.length>0) {
			dc.createAlias("eavalues", "eavalues");
			for (int i=0; i<ev.length; i++) {
				eavalue = seavalue.findById(ev[i]);
				if (null != eavalue) {
					dc.add(Restrictions.eq("eavalues.id", ev[i]));
				}
			}
		}*/
		
		if (null != ev && !ev.equals("") && ev.length>0) {
			/*ArrayList list = new ArrayList();
			for (int i=0; i<ev.length; i++) {
				System.out.println("第"+i+"次");
				eavalue = seavalue.findById(ev[i]);
				if (null != eavalue) {
					Extattr extattr = eavalue.getExtattr();//当前的属性值的组
					Iterator it = extattr.getEavalues().iterator();
					while (it.hasNext()) {
						Eavalue ea = (Eavalue)it.next();
						System.out.println("Value:"+ea.getValue());
					}
					System.out.println();
					if (!list.contains(extattr)) {
						System.out.println("不包含");
						extattr.setEavalues(new HashSet());//相当于清空
						extattr.getEavalues().add(eavalue);//重新加入当前的属性值
						list.add(extattr);
					} else {
						System.out.println("包含");
						extattr.getEavalues().add(eavalue);
					}
				}
			}
			System.out.println("-------------");
			
			dc.createAlias("eavalues", "eavalues");
			Disjunction eadis = Restrictions.disjunction();//暂时全部用或者,后面再改进
			for (int j=0; j<list.size(); j++) {
				Extattr exttest = (Extattr)list.get(j);
				Iterator ittest = exttest.getEavalues().iterator();
				System.out.println("并且:"+exttest.getName());
				//Disjunction eadis = Restrictions.disjunction();//或者
				while (ittest.hasNext()) {
					Eavalue eatest = (Eavalue)ittest.next();
					System.out.println("或者:"+eatest.getValue()+" "+eatest.getId());
					eadis.add(Restrictions.eq("eavalues.id", eatest.getId()));
				}
				//dc.add(eadis);//并且
			}
			dc.add(eadis);//暂时全部用或者,后面再改进
			System.out.println("-------------");*/
			if (null != ev[0] && !ev[0].equals("")) {
				dc.createAlias("eavalues", "eavalues");
				Disjunction eadis = Restrictions.disjunction();//暂时全部用或者,后面再改进
				for (int i=0; i<ev.length; i++) {
					System.out.println("第"+i+"次");
					if (null != ev[i] && !ev[i].equals("")) {
						eavalue = seavalue.findById(ev[i]);
						if (null != eavalue) {
							eadis.add(Restrictions.eq("eavalues.id", eavalue.getId()));
						}
					}
				}
				dc.add(eadis);
			}
		}
		
		/*
		 * 查询第一个值的组,将组保存在数组
		 * 查询第二个值的组,如果这个组不在上面已查询出的数组里,将组存入上面的数组
		 * 如果这个组在上面的数组里,将这个值存入相应的组
		 * 如果和上一个不相同,另增一个数组
		 * 
		 * 查找所有扩展属性值
		 * 循环
		 * 循环所有参数ev
		 * 对比,
		 * 把在一个扩展属性里的值取出存放数组
		 */
		
		//商品品牌
		if (null != bd && !bd.equals("")) {
			brand = sbrand.findById(bd);
			if (null != brand) {
				dc.add(Property.forName("brand").eq(brand));
			}
		}
		
		dc.add(Property.forName("locale").eq(getDefLocale()));//语言
		dc.addOrder(Order.asc("csort"));
		
		ps = sgoods.findPageByCriteria(dc, pagesize, page);
		//System.out.println("fffffffffff");
		
		//设置显示的当前目录
		if (null != category && null != category.getCategory() && null != category.getCategories() && category.getCategories().size() <= 0)
			category = category.getCategory();
		
		//显示所有相关扩展属性及品牌
		if (null != category) {
			DetachedCriteria cdc = DetachedCriteria.forClass(Category.class);
			Disjunction cdis = Restrictions.disjunction();
			cdis.add(Property.forName("category").eq(category));
			cdc.createAlias("category", "c");
			cdis.add(Restrictions.like("c.nodepath", category.getId(), MatchMode.ANYWHERE));
			cdc.add(cdis);
			//所有商品类别
			List list = scategory.findAllByCriteria(cdc);
			for (int i=0; i<list.size(); i++) {
				Category cate = (Category)list.get(i);
				if (null != cate.getGstype()) {
					//extattrSet.addAll(cate.getGstype().getExtattrs());
					brandSet.addAll(cate.getGstype().getBrands());
					DetachedCriteria edc = DetachedCriteria.forClass(Extattr.class);
					edc.createCriteria("gstypes").add(Restrictions.eq("id", cate.getGstype().getId()));
					edc.addOrder(Order.asc("csort"));
					List elist = sextattr.findAllByCriteria(edc);
					extattrSet.addAll(elist);
				}
			}
		}
		return SUCCESS;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String[] getEv() {
		return ev;
	}

	public void setEv(String[] ev) {
		this.ev = ev;
	}

	public Eavalue getEavalue() {
		return eavalue;
	}

	public void setEavalue(Eavalue eavalue) {
		this.eavalue = eavalue;
	}

	public String getBd() {
		return bd;
	}

	public void setBd(String bd) {
		this.bd = bd;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
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

	public ArrayList<Extattr> getExtattrSet() {
		return extattrSet;
	}

	public void setExtattrSet(ArrayList<Extattr> extattrSet) {
		this.extattrSet = extattrSet;
	}

	public Set<Brand> getBrandSet() {
		return brandSet;
	}

	public void setBrandSet(Set<Brand> brandSet) {
		this.brandSet = brandSet;
	}
}
