package com.e6mall.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.e6mall.model.Category;
import com.e6mall.model.Chcontent;
import com.e6mall.model.Config;
import com.e6mall.model.Doccate;
import com.e6mall.model.Document;
import com.e6mall.model.Goods;
import com.e6mall.model.Locale;
import com.e6mall.model.Manager;
import com.e6mall.model.Member;
import com.e6mall.model.Orders;
import com.e6mall.services.ISAttachment;
import com.e6mall.services.ISBank;
import com.e6mall.services.ISBrand;
import com.e6mall.services.ISBrunacc;
import com.e6mall.services.ISCategory;
import com.e6mall.services.ISChannel;
import com.e6mall.services.ISChcontent;
import com.e6mall.services.ISComments;
import com.e6mall.services.ISConfig;
import com.e6mall.services.ISDistrict;
import com.e6mall.services.ISDoccate;
import com.e6mall.services.ISDocument;
import com.e6mall.services.ISEavalue;
import com.e6mall.services.ISEvaluate;
import com.e6mall.services.ISExtattr;
import com.e6mall.services.ISGoods;
import com.e6mall.services.ISGroups;
import com.e6mall.services.ISGstype;
import com.e6mall.services.ISLocale;
import com.e6mall.services.ISLogistics;
import com.e6mall.services.ISLsarea;
import com.e6mall.services.ISManager;
import com.e6mall.services.ISMember;
import com.e6mall.services.ISMgroups;
import com.e6mall.services.ISOrderitem;
import com.e6mall.services.ISOrders;
import com.e6mall.services.ISPaymode;
import com.e6mall.services.ISPermission;
import com.e6mall.services.ISPoints;
import com.e6mall.services.ISPrunacc;
import com.e6mall.services.ISSetting;
import com.e6mall.services.ISSpec;
import com.e6mall.services.ISSpecitem;
import com.e6mall.services.ISSpecvalue;
import com.e6mall.services.ISStaddress;
import com.e6mall.utils.Notice;
import com.e6mall.utils.PaginationSupport;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware, SessionAware {
	private static final long serialVersionUID = -1170067112876395839L;
	
	protected Logger logger = Logger.getLogger(this.getClass());
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	protected Notice notice = new Notice();//返回提示，权限拦截器
	protected String funccode;//功能代码，权限拦截器
	protected String funcaction;//功能操作类型，权限拦截器
	protected String funcname;//功能名称，权限拦截器
	
	protected ISAttachment sattachment;
	protected ISBank sbank;
	protected ISBrand sbrand;
	protected ISBrunacc sbrunacc;
	protected ISCategory scategory;
	protected ISChannel schannel;
	protected ISChcontent schcontent;
	protected ISComments scomments;
	protected ISConfig sconfig;
	protected ISDistrict sdistrict;
	protected ISDoccate sdoccate;
	protected ISDocument sdocument;
	protected ISEavalue seavalue;
	protected ISEvaluate sevaluate;
	protected ISExtattr sextattr;
	protected ISGoods sgoods;
	protected ISGroups sgroups;
	protected ISGstype sgstype;
	protected ISLocale slocale;
	protected ISLogistics slogistics;
	protected ISLsarea slsarea;
	protected ISManager smanager;
	protected ISMember smember;
	protected ISMgroups smgroups;
	protected ISPermission spermission;
	protected ISOrderitem sorderitem;
	protected ISOrders sorders;
	protected ISPaymode spaymode;
	protected ISPoints spoints;
	protected ISPrunacc sprunacc;
	protected ISSetting ssetting;
	protected ISSpec sspec;
	protected ISSpecitem sspecitem;
	protected ISSpecvalue sspecvalue;
	protected ISStaddress sstaddress;
	
	protected Map session = ActionContext.getContext().getSession();

	//前台
	protected String l;	//语言
	protected Locale defLocale = null;
	protected String template;
	protected List caterootlist;//商品类别根目录
	
	public String getL() {
		return l;
	}

	public void setL(String l) {
		this.l = l;
	}
	
	public Locale getDefLocale() {
		if (null != l && !l.equals("")) {
			defLocale = getSlocale().findById(l);
			if (null != defLocale) {//如果当前设置的语言正确
				session.put("locale", defLocale);
			}
		}
		
		defLocale = (Locale)session.get("locale");
		
		if (null != defLocale) {//如果当前设置的语言正确
			
		} else {//否则用默认语言
			Config config = sconfig.findByProperty("defaultLocale");
			if (null != config) {
				String defaultLocale = config.getValue();
				defLocale = slocale.findById(defaultLocale);
			}
			if (null != defLocale) {//如果默认语言设置被删除
				
			} else {//默认使用简体中文
				defLocale = new Locale();
				defLocale.setId("zh_CN");
				defLocale.setName("简体中文");
			}
		}
		//System.out.println(defLocale.getName());
		return defLocale;
	}

	public void setDefLocale(Locale defLocale) {
		this.defLocale = defLocale;
	}

	public String getTemplate() {
		return template;
	}

	public List getCaterootlist() {
		caterootlist = scategory.findAllRoot(getDefLocale());
		return caterootlist;
	}

	public void setCaterootlist(List caterootlist) {
		this.caterootlist = caterootlist;
	}

	/*
	 * 通用属性
	 */
	protected String siteName = "";
	protected String siteTitle = "";
	protected String siteCopyright = "";
	
	public String getSiteName() {
		Config config = sconfig.findByProperty("siteName");
		siteName = config.getValue();
		return siteName;
	}

	public String getSiteTitle() {
		Config config = sconfig.findByProperty("siteTitle");
		try {
			siteTitle = config.getValue() + " - Powered by E6Mall";
		} catch (Exception e) {
			
		}
		return siteTitle;
	}
	
	public String getSiteCopyright() {
		Config config = sconfig.findByProperty("siteCopyright");
		try {
			siteCopyright = config.getValue() + " - Powered by <a href='http://www.e6mall.com' target='_blank'>E6Mall</a>";
		} catch (Exception e) {
			
		}
		return siteCopyright;
	}

	/*
	 * 显示购物车的临时订单和商品内容
	 */
	protected Orders cart = new Orders();
	
	public Orders getCart() {
		cart = (Orders)ActionContext.getContext().getSession().get("orders");
		if (cart != null) {
			return cart;
		} else {
			Orders os = new Orders();
			session.put("orders", os);
			return os;
		}
	}

	public void setCart(Orders cart) {
		this.cart = cart;
	}
	
	/*
	 * 显示热门搜索关键词
	 */
	protected List<String> searchKeyList;
	
	public List<String> getSearchKeyList() {
		Config config = sconfig.findByProperty("searchKeyList");
		String[] c = config.getValue().split(",");
		searchKeyList = Arrays.asList(c);
		return searchKeyList;
	}
	
	//全局频道内容
	protected Map map = new HashMap();
	
	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	protected Map GlobalChcontent(Map map) {
		List gclist = schcontent.findAllGlobal(getDefLocale());	//全局频道内容
		for (int j=0; j<gclist.size(); j++) {
			Chcontent chcontent = (Chcontent)gclist.get(j);
			if (chcontent.getType().equals("dmenu")) {				//文章分类
				List<Doccate> list = new ArrayList<Doccate>();
				if (null != chcontent.getDoccate()) {//显示指定分类的子分类
					//因排序问题改为直接查询
					DetachedCriteria dc = DetachedCriteria.forClass(Doccate.class);
					dc.add(Property.forName("doccate").eq(chcontent.getDoccate()));
					dc.add(Property.forName("locale").eq(getDefLocale()));
					dc.addOrder(Order.asc("csort"));
					list = sdoccate.findAllByCriteria(dc);
					//System.out.println(((Doccate)list.get(0)).getName());
				} else {//显示所有根分类
					list = sdoccate.findAllRoot(getDefLocale());
				}
				map.put(chcontent.getMarker(), list);
				map.put(chcontent.getMarker()+"_CurDoccate", chcontent.getDoccate());
			} else if (chcontent.getType().equals("dlist")) {		//文章列表
				DetachedCriteria dc = DetachedCriteria.forClass(Document.class);
				Doccate doccate = chcontent.getDoccate();
				Disjunction dis = Restrictions.disjunction();
				dis.add(Property.forName("doccate").eq(doccate));
				dc.createAlias("doccate", "c");
				dis.add(Restrictions.like("c.nodepath", doccate.getId(), MatchMode.ANYWHERE));
				dc.add(dis);
				dc.add(Property.forName("locale").eq(getDefLocale()));
				dc.addOrder(Order.desc("cdate"));
				PaginationSupport ps = sdocument.findPageByIndex(dc, chcontent.getNumber(), chcontent.getOffset());
				map.put(chcontent.getMarker(), ps);
			} else if (chcontent.getType().equals("drclist")) {		//推荐文章列表
				DetachedCriteria dc = DetachedCriteria.forClass(Document.class);
				Doccate doccate = chcontent.getDoccate();
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
			} else if (chcontent.getType().equals("dpagelist")) {	//分页文章列表
				DetachedCriteria dc = DetachedCriteria.forClass(Document.class);
				Doccate doccate = chcontent.getDoccate();
				Disjunction dis = Restrictions.disjunction();
				dis.add(Property.forName("doccate").eq(doccate));
				dc.createAlias("doccate", "c");
				dis.add(Restrictions.like("c.nodepath", doccate.getId(), MatchMode.ANYWHERE));
				dc.add(dis);
				dc.add(Property.forName("locale").eq(getDefLocale()));
				dc.addOrder(Order.desc("cdate"));
				int page = 1;
				PaginationSupport ps = sdocument.findPageByCriteria(dc, chcontent.getNumber(), page);
				map.put(chcontent.getMarker(), ps);
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
			} else if (chcontent.getType().equals("glist")) {		//商品列表
				DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
				if (null != chcontent.getCategory()) {
					Category category = chcontent.getCategory();
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
				dc.add(Property.forName("locale").eq(getDefLocale()));
				dc.addOrder(Order.desc("ctime"));
				dc.addOrder(Order.desc("utime"));
				dc.addOrder(Order.asc("csort"));
				PaginationSupport ps = sgoods.findPageByIndex(dc, chcontent.getNumber(), chcontent.getOffset());
				map.put(chcontent.getMarker(), ps);
			} else if (chcontent.getType().equals("grclist")) {		//推荐商品列表
				DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
				if (null != chcontent.getCategory()) {
					Category category = chcontent.getCategory();
					Disjunction dis = Restrictions.disjunction();
					dis.add(Property.forName("category").eq(category));
					dc.createAlias("category", "c");
					dis.add(Restrictions.like("c.nodepath", category.getId(), MatchMode.ANYWHERE));
					dc.add(dis);
				}
				dc.add(Property.forName("status").eq("recommand"));
				dc.add(Property.forName("locale").eq(getDefLocale()));
				dc.addOrder(Order.desc("ctime"));
				dc.addOrder(Order.desc("utime"));
				dc.addOrder(Order.asc("csort"));
				PaginationSupport ps = sgoods.findPageByIndex(dc, chcontent.getNumber(), chcontent.getOffset());
				map.put(chcontent.getMarker(), ps);
			} else if (chcontent.getType().equals("gpagelist")) {		//分页商品列表
				DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
				if (null != chcontent.getCategory()) {
					Category category = chcontent.getCategory();
					Disjunction dis = Restrictions.disjunction();
					dis.add(Property.forName("category").eq(category));
					dc.createAlias("category", "c");
					dis.add(Restrictions.like("c.nodepath", category.getId(), MatchMode.ANYWHERE));
					dc.add(dis);
				}
				dc.add(Property.forName("locale").eq(getDefLocale()));
				dc.addOrder(Order.desc("ctime"));
				dc.addOrder(Order.desc("utime"));
				dc.addOrder(Order.asc("csort"));
				int page = 1;
				PaginationSupport ps = sgoods.findPageByCriteria(dc, chcontent.getNumber(), page);
				map.put(chcontent.getMarker(), ps);
			} else if (chcontent.getType().equals("dsingle")) {		//单条信息
				Document document = chcontent.getDocument();
				map.put(chcontent.getMarker(), document);
			}
		}
		return map;
	}

	//辅助
	public String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public Timestamp getTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}
	
	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public String getFunccode() {
		return funccode;
	}

	public void setFunccode(String funccode) {
		this.funccode = funccode;
	}

	public String getFuncaction() {
		return funcaction;
	}

	public void setFuncaction(String funcaction) {
		this.funcaction = funcaction;
	}

	public String getFuncname() {
		return funcname;
	}

	public void setFuncname(String funcname) {
		this.funcname = funcname;
	}

	/*
	 * 会员Session
	 */
	public Member getMsession() {
		return (Member)ActionContext.getContext().getSession().get("member");
	}
	
	/*
	 * 管理员Session
	 */
	public Manager getAsession() {
		return (Manager)ActionContext.getContext().getSession().get("manager");
	}
	
	//业务

	public ISAttachment getSattachment() {
		return sattachment;
	}

	public void setSattachment(ISAttachment sattachment) {
		this.sattachment = sattachment;
	}

	public ISBank getSbank() {
		return sbank;
	}

	public void setSbank(ISBank sbank) {
		this.sbank = sbank;
	}

	public ISBrunacc getSbrunacc() {
		return sbrunacc;
	}

	public void setSbrunacc(ISBrunacc sbrunacc) {
		this.sbrunacc = sbrunacc;
	}

	public ISCategory getScategory() {
		return scategory;
	}

	public void setScategory(ISCategory scategory) {
		this.scategory = scategory;
	}

	public ISChannel getSchannel() {
		return schannel;
	}

	public void setSchannel(ISChannel schannel) {
		this.schannel = schannel;
	}

	public ISChcontent getSchcontent() {
		return schcontent;
	}

	public void setSchcontent(ISChcontent schcontent) {
		this.schcontent = schcontent;
	}

	public ISComments getScomments() {
		return scomments;
	}

	public void setScomments(ISComments scomments) {
		this.scomments = scomments;
	}

	public ISConfig getSconfig() {
		return sconfig;
	}

	public void setSconfig(ISConfig sconfig) {
		this.sconfig = sconfig;
	}

	public ISDistrict getSdistrict() {
		return sdistrict;
	}

	public void setSdistrict(ISDistrict sdistrict) {
		this.sdistrict = sdistrict;
	}

	public ISDoccate getSdoccate() {
		return sdoccate;
	}

	public void setSdoccate(ISDoccate sdoccate) {
		this.sdoccate = sdoccate;
	}

	public ISDocument getSdocument() {
		return sdocument;
	}

	public void setSdocument(ISDocument sdocument) {
		this.sdocument = sdocument;
	}

	public ISEvaluate getSevaluate() {
		return sevaluate;
	}

	public void setSevaluate(ISEvaluate sevaluate) {
		this.sevaluate = sevaluate;
	}

	public ISGoods getSgoods() {
		return sgoods;
	}

	public void setSgoods(ISGoods sgoods) {
		this.sgoods = sgoods;
	}

	public ISGroups getSgroups() {
		return sgroups;
	}

	public void setSgroups(ISGroups sgroups) {
		this.sgroups = sgroups;
	}

	public ISLocale getSlocale() {
		return slocale;
	}

	public void setSlocale(ISLocale slocale) {
		this.slocale = slocale;
	}

	public ISManager getSmanager() {
		return smanager;
	}

	public void setSmanager(ISManager smanager) {
		smanager.setSession(session);
		this.smanager = smanager;
	}

	public ISMember getSmember() {
		return smember;
	}

	public void setSmember(ISMember smember) {
		smember.setSession(session);
		this.smember = smember;
	}

	public ISMgroups getSmgroups() {
		return smgroups;
	}

	public void setSmgroups(ISMgroups smgroups) {
		this.smgroups = smgroups;
	}

	public ISPermission getSpermission() {
		return spermission;
	}

	public void setSpermission(ISPermission spermission) {
		this.spermission = spermission;
	}

	public ISOrderitem getSorderitem() {
		return sorderitem;
	}

	public void setSorderitem(ISOrderitem sorderitem) {
		this.sorderitem = sorderitem;
	}

	public ISOrders getSorders() {
		return sorders;
	}

	public void setSorders(ISOrders sorders) {
		this.sorders = sorders;
	}

	public ISPoints getSpoints() {
		return spoints;
	}

	public void setSpoints(ISPoints spoints) {
		this.spoints = spoints;
	}

	public ISPrunacc getSprunacc() {
		return sprunacc;
	}

	public void setSprunacc(ISPrunacc sprunacc) {
		this.sprunacc = sprunacc;
	}

	public ISSetting getSsetting() {
		return ssetting;
	}

	public void setSsetting(ISSetting ssetting) {
		this.ssetting = ssetting;
	}

	public ISBrand getSbrand() {
		return sbrand;
	}

	public void setSbrand(ISBrand sbrand) {
		this.sbrand = sbrand;
	}

	public ISEavalue getSeavalue() {
		return seavalue;
	}

	public void setSeavalue(ISEavalue seavalue) {
		this.seavalue = seavalue;
	}

	public ISExtattr getSextattr() {
		return sextattr;
	}

	public void setSextattr(ISExtattr sextattr) {
		this.sextattr = sextattr;
	}

	public ISGstype getSgstype() {
		return sgstype;
	}

	public void setSgstype(ISGstype sgstype) {
		this.sgstype = sgstype;
	}

	public ISLogistics getSlogistics() {
		return slogistics;
	}

	public void setSlogistics(ISLogistics slogistics) {
		this.slogistics = slogistics;
	}

	public ISLsarea getSlsarea() {
		return slsarea;
	}

	public void setSlsarea(ISLsarea slsarea) {
		this.slsarea = slsarea;
	}

	public ISPaymode getSpaymode() {
		return spaymode;
	}

	public void setSpaymode(ISPaymode spaymode) {
		this.spaymode = spaymode;
	}

	public ISSpec getSspec() {
		return sspec;
	}

	public void setSspec(ISSpec sspec) {
		this.sspec = sspec;
	}

	public ISSpecitem getSspecitem() {
		return sspecitem;
	}

	public void setSspecitem(ISSpecitem sspecitem) {
		this.sspecitem = sspecitem;
	}

	public ISSpecvalue getSspecvalue() {
		return sspecvalue;
	}

	public void setSspecvalue(ISSpecvalue sspecvalue) {
		this.sspecvalue = sspecvalue;
	}

	public ISStaddress getSstaddress() {
		return sstaddress;
	}

	public void setSstaddress(ISStaddress sstaddress) {
		this.sstaddress = sstaddress;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setSession(Map<String, Object> arg0) {
	}

}
