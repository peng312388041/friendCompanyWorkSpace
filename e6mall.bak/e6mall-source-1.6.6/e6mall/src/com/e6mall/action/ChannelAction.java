package com.e6mall.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.e6mall.model.Category;
import com.e6mall.model.Channel;
import com.e6mall.model.Chcontent;
import com.e6mall.model.Config;
import com.e6mall.model.Doccate;
import com.e6mall.model.Document;
import com.e6mall.model.Goods;
import com.e6mall.utils.PaginationSupport;

public class ChannelAction extends BaseAction {
	private static final long serialVersionUID = -8818779998128517195L;
	private String c = "home";		//默认
	private Channel channel;
	private int page = 1;
	//private Map map = new HashMap();
	private String t = "";	//t=v显示详细页
	private String d;		//文档ID
	private Document document;
	private List brandlist;
	
	private String cg;
	private Category category;
	
	private String dg;
	private Doccate doccate;
	
	private String keyword; //关键词标签

	public String execute() throws Exception {
		GlobalChcontent(map);
		//关闭网站
		Config siteClose = sconfig.findByProperty("siteClose");
		if (null != siteClose && null != siteClose.getValue() && siteClose.getValue().equals("enable")) {
			return "siteclose";
		}
		
		System.out.println(getDefLocale().getName());
		
		brandlist = sbrand.findAll();
		channel = schannel.findById(c);
		if (null != channel) {
			GlobalChcontent(map);
			template = channel.getTemplate().getPath() + "/" + getDefLocale().getId() + "_" + channel.getTemplate().getName();
			//Iterator it = channel.getChcontents().iterator();
			DetachedCriteria dcc = DetachedCriteria.forClass(Chcontent.class);
			dcc.add(Property.forName("channel").eq(channel));
			dcc.add(Property.forName("locale").eq(getDefLocale()));
			List listc = schcontent.findAllByCriteria(dcc);
			Iterator it = listc.iterator();
			while (it.hasNext()) {
				Chcontent chcontent = (Chcontent)it.next();
				if (t.equals("v") && !chcontent.getDetail().equals("yes")) {
					logger.debug("t=v，chcontent.getDetail()!=yes，显示详细页，不包括类型为no的频道内容。");
				} else {
					if (chcontent.getType().equals("dmenu")) {				//文章分类
						List<Doccate> list = new ArrayList<Doccate>();
						if (null != chcontent.getDoccate()) {//显示指定分类的子分类
							//因排序问题改为直接查询
							DetachedCriteria dc = DetachedCriteria.forClass(Doccate.class);
							dc.add(Property.forName("doccate").eq(chcontent.getDoccate()));
							dc.add(Property.forName("locale").eq(getDefLocale()));
							dc.addOrder(Order.asc("csort"));
							list = sdoccate.findAllByCriteria(dc);
						} else {//显示所有根分类
							list = sdoccate.findAllRoot(getDefLocale());
						}
						map.put(chcontent.getMarker(), list);
						map.put(chcontent.getMarker()+"_CurDoccate", chcontent.getDoccate());
					} else if (chcontent.getType().equals("dlist")) {		//文章列表
						DetachedCriteria dc = DetachedCriteria.forClass(Document.class);
						if (null != dg && !dg.equals("")) {
							doccate = sdoccate.findById(dg);
							logger.debug("dg is not NULL, Doccate is "+doccate.getName());
						} else {
							doccate = chcontent.getDoccate();
							logger.debug("dg is NULL, Doccate is "+doccate.getName());
						}
						
						Disjunction dis = Restrictions.disjunction();
						dis.add(Property.forName("doccate").eq(doccate));
						dc.createAlias("doccate", "c");
						dis.add(Restrictions.like("c.nodepath", doccate.getId(), MatchMode.ANYWHERE));
						dc.add(dis);
						
						dc.add(Property.forName("locale").eq(getDefLocale()));
						dc.addOrder(Order.desc("cdate"));
						PaginationSupport ps = sdocument.findPageByIndex(dc, chcontent.getNumber(), chcontent.getOffset());
						map.put(chcontent.getMarker(), ps);
						map.put("CurDoccate", doccate);
					} else if (chcontent.getType().equals("drclist")) {		//推荐文章列表
						DetachedCriteria dc = DetachedCriteria.forClass(Document.class);
						if (null != dg && !dg.equals("")) {
							doccate = sdoccate.findById(dg);
							logger.debug("dg is not NULL, Doccate is "+doccate.getName());
						} else {
							doccate = chcontent.getDoccate();
							logger.debug("dg is NULL, Doccate is "+doccate.getName());
						}
						
						Disjunction dis = Restrictions.disjunction();
						dis.add(Property.forName("doccate").eq(doccate));
						dc.createAlias("doccate", "c");
						dis.add(Restrictions.like("c.nodepath", doccate.getId(), MatchMode.ANYWHERE));
						dc.add(dis);
						dc.add(Property.forName("marker").eq("recommand"));
						
						dc.add(Property.forName("locale").eq(getDefLocale()));
						dc.addOrder(Order.desc("cdate"));
						PaginationSupport ps = sdocument.findPageByIndex(dc, chcontent.getNumber(), chcontent.getOffset());
						map.put(chcontent.getMarker(), ps);
						map.put("CurDoccate", doccate);
					} else if (chcontent.getType().equals("dpagelist")) {	//分页文章列表
						DetachedCriteria dc = DetachedCriteria.forClass(Document.class);
						if (null != dg && !dg.equals("")) {
							doccate = sdoccate.findById(dg);
							logger.debug("dg is not NULL, Doccate is "+doccate.getName());
						} else {
							doccate = chcontent.getDoccate();
							logger.debug("dg is NULL, Doccate is "+doccate.getName());
						}
						
						Disjunction dis = Restrictions.disjunction();
						dis.add(Property.forName("doccate").eq(doccate));
						dc.createAlias("doccate", "c");
						dis.add(Restrictions.like("c.nodepath", doccate.getId(), MatchMode.ANYWHERE));
						dc.add(dis);
						
						dc.add(Property.forName("locale").eq(getDefLocale()));
						dc.addOrder(Order.desc("cdate"));
						PaginationSupport ps = sdocument.findPageByCriteria(dc, chcontent.getNumber(), page);
						map.put(chcontent.getMarker(), ps);
						map.put("CurDoccate", doccate);
					} else if (chcontent.getType().equals("gmenu")) {		//商品分类
						List<Category> list = new ArrayList<Category>();
						if (null != chcontent.getCategory()) {//显示指定分类的子分类
							//因排序问题改为直接查询
							DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
							dc.add(Property.forName("category").eq(chcontent.getCategory()));
							dc.add(Property.forName("locale").eq(getDefLocale()));
							dc.addOrder(Order.asc("csort"));
							list = scategory.findAllByCriteria(dc);
						} else {//显示所有根分类
							list = scategory.findAllRoot(getDefLocale());
						}
						map.put(chcontent.getMarker(), list);
						map.put(chcontent.getMarker()+"_CurCategory", chcontent.getCategory());
					} else if (chcontent.getType().equals("glist")) {		//商品列表
						DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
						if (null != cg && !cg.equals("")) {
							category = scategory.findById(cg);
							logger.debug("cg is not NULL, Category is "+category.getName());
							
							Disjunction dis = Restrictions.disjunction();
							dis.add(Property.forName("category").eq(category));
							dc.createAlias("category", "c");
							dis.add(Restrictions.like("c.nodepath", category.getId(), MatchMode.ANYWHERE));
							dc.add(dis);
						} else if (null != chcontent.getCategory()) {
							category = chcontent.getCategory();
							logger.debug("cg is NULL, Category is "+category.getName());
							
							Disjunction dis = Restrictions.disjunction();
							dis.add(Property.forName("category").eq(category));
							dc.createAlias("category", "c");
							dis.add(Restrictions.like("c.nodepath", category.getId(), MatchMode.ANYWHERE));
							dc.add(dis);
						}
						
						Disjunction kdis = Restrictions.disjunction();
						String[] keys= chcontent.getKeys();
						if (null != keys && keys.length > 0) {
							for (int i=0; i<keys.length; i++) {
								String key = keys[i];
								kdis.add(Property.forName("keywords").like(key, MatchMode.ANYWHERE));
							}
							dc.add(kdis);
						}
						
						//商品关键词标签
						if(null != keyword) {
							dc.add(Property.forName("keywords").like(keyword, MatchMode.ANYWHERE));
						}
						
						dc.add(Property.forName("locale").eq(getDefLocale()));
						dc.addOrder(Order.desc("ctime"));
						dc.addOrder(Order.desc("utime"));
						dc.addOrder(Order.asc("csort"));
						PaginationSupport ps = sgoods.findPageByIndex(dc, chcontent.getNumber(), chcontent.getOffset());
						map.put(chcontent.getMarker(), ps);
						map.put(chcontent.getMarker()+"_CurCategory", category);
					} else if (chcontent.getType().equals("grclist")) {		//推荐商品列表
						DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
						if (null != cg && !cg.equals("")) {
							category = scategory.findById(cg);
							logger.debug("cg is not NULL, Category is "+category.getName());
							
							Disjunction dis = Restrictions.disjunction();
							dis.add(Property.forName("category").eq(category));
							dc.createAlias("category", "c");
							dis.add(Restrictions.like("c.nodepath", category.getId(), MatchMode.ANYWHERE));
							dc.add(dis);
						} else if (null != chcontent.getCategory()) {
							category = chcontent.getCategory();
							logger.debug("cg is NULL, Category is "+category.getName());
							
							Disjunction dis = Restrictions.disjunction();
							dis.add(Property.forName("category").eq(category));
							dc.createAlias("category", "c");
							dis.add(Restrictions.like("c.nodepath", category.getId(), MatchMode.ANYWHERE));
							dc.add(dis);
						}
						
						Disjunction kdis = Restrictions.disjunction();
						String[] keys= chcontent.getKeys();
						if (null != keys && keys.length > 0) {
							for (int i=0; i<keys.length; i++) {
								String key = keys[i];
								kdis.add(Property.forName("keywords").like(key, MatchMode.ANYWHERE));
							}
							dc.add(kdis);
						}
						
						//商品关键词标签
						if(null != keyword) {
							dc.add(Property.forName("keywords").like(keyword, MatchMode.ANYWHERE));
						}
						
						dc.add(Property.forName("status").eq("recommend"));
						dc.add(Property.forName("locale").eq(getDefLocale()));
						dc.addOrder(Order.desc("ctime"));
						dc.addOrder(Order.desc("utime"));
						dc.addOrder(Order.asc("csort"));
						PaginationSupport ps = sgoods.findPageByIndex(dc, chcontent.getNumber(), chcontent.getOffset());
						map.put(chcontent.getMarker(), ps);
						map.put("CurCategory", category);
					} else if (chcontent.getType().equals("gpagelist")) {		//分页商品列表
						DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
						if (null != cg && !cg.equals("")) {
							category = scategory.findById(cg);
							logger.debug("cg is not NULL, Category is "+category.getName());
							
							Disjunction dis = Restrictions.disjunction();
							dis.add(Property.forName("category").eq(category));
							dc.createAlias("category", "c");
							dis.add(Restrictions.like("c.nodepath", category.getId(), MatchMode.ANYWHERE));
							dc.add(dis);
						} else if (null != chcontent.getCategory()) {
							category = chcontent.getCategory();
							logger.debug("cg is NULL, Category is "+category.getName());
							
							Disjunction dis = Restrictions.disjunction();
							dis.add(Property.forName("category").eq(category));
							dc.createAlias("category", "c");
							dis.add(Restrictions.like("c.nodepath", category.getId(), MatchMode.ANYWHERE));
							dc.add(dis);
						}
						
						Disjunction kdis = Restrictions.disjunction();
						String[] keys= chcontent.getKeys();
						if (null != keys && keys.length > 0) {
							for (int i=0; i<keys.length; i++) {
								String key = keys[i];
								kdis.add(Property.forName("keywords").like(key, MatchMode.ANYWHERE));
							}
							dc.add(kdis);
						}
						
						//商品关键词标签
						if(null != keyword) {
							dc.add(Property.forName("keywords").like(keyword, MatchMode.ANYWHERE));
						}
						
						dc.add(Property.forName("locale").eq(getDefLocale()));
						dc.addOrder(Order.desc("ctime"));
						dc.addOrder(Order.desc("utime"));
						dc.addOrder(Order.asc("csort"));
						PaginationSupport ps = sgoods.findPageByCriteria(dc, chcontent.getNumber(), page);
						map.put(chcontent.getMarker(), ps);
						map.put("CurCategory", category);
					} else if (chcontent.getType().equals("dsingle")) {		//单条信息
						Document document = chcontent.getDocument();
						map.put(chcontent.getMarker(), document);
					}
				}
			}
			
			if (null != d && !d.equals("")) {
				if (null != channel.getVtemplate()) {
					template = channel.getVtemplate().getPath() + "/" + getDefLocale().getId() + "_" + channel.getVtemplate().getName();
					document = sdocument.findById(d);
				} else {
					notice.setStatus(false);
					notice.setCode("channel vtemplate not exist");
					notice.setTitle("错误：");
					notice.setBody("找不到频道详细页模板。");
					return ERROR;
				}
			}
			return SUCCESS;
		} else {
			notice.setStatus(false);
			notice.setCode("channel not exist");
			notice.setTitle("错误：");
			notice.setBody("找不到频道。");
			return ERROR;
		}
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public String getCg() {
		return cg;
	}

	public void setCg(String cg) {
		this.cg = cg;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDg() {
		return dg;
	}

	public void setDg(String dg) {
		this.dg = dg;
	}

	public Doccate getDoccate() {
		return doccate;
	}

	public void setDoccate(Doccate doccate) {
		this.doccate = doccate;
	}

	public List getBrandlist() {
		return brandlist;
	}

	public void setBrandlist(List brandlist) {
		this.brandlist = brandlist;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
