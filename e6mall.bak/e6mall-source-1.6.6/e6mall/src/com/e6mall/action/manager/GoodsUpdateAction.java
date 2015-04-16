package com.e6mall.action.manager;

import java.util.HashSet;
import java.util.List;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Category;
import com.e6mall.model.Eavalue;
import com.e6mall.model.Goods;
import com.e6mall.model.Gstype;

public class GoodsUpdateAction extends BaseAction {
	private static final long serialVersionUID = -416415424928530659L;
	private List localelist;
	private List catelist;
	private String cg;
	private Category ccategory;
	private List gstypelist;
	private String ge;
	private Gstype gstype;
	private String gs;
	private Goods goods;
	private List<Eavalue> eavalues;
	private String[] keywords;

	public String execute() throws Exception {
		localelist = slocale.findAll();
		catelist = scategory.findAllTree();
		gstypelist = sgstype.findAll();
		goods = sgoods.findById(gs);
		if (null != cg && !cg.equals("")) {
			ccategory = scategory.findById(cg);
			if (null != ge && !ge.equals(""))
				gstype = sgstype.findById(ge);
			else
				gstype = ccategory.getGstype();
		} else {
			ccategory = goods.getCategory();
			gstype = goods.getGstype();
		}
		return SUCCESS;
	}
	
	public String update() throws Exception {
		Goods ug = sgoods.findById(goods.getId());
		ug.setBrand(goods.getBrand());
		ug.setCategory(goods.getCategory());
		ug.setCsort(goods.getCsort());
		ug.setDetails(goods.getDetails());
		ug.setGstype(goods.getGstype());
		ug.setIntro(goods.getIntro());
		ug.setInventory(goods.getInventory());
		ug.setKeywords(goods.getKeywords());
		ug.setLocale(goods.getLocale());
		ug.setManager(getAsession());
		ug.setMkeywords(goods.getMkeywords());
		ug.setMdescription(goods.getMdescription());
		ug.setName(goods.getName());
		ug.setSn(goods.getSn());
		ug.setStatus(goods.getStatus());
		ug.setPoints(goods.getPoints());
		ug.setPrice(goods.getPrice());
		ug.setMprice(goods.getMprice());
		ug.setPromote(goods.getPromote());
		ug.setUtime(getTimestamp());
		ug.setWeight(goods.getWeight());
		ug.setEavalues(new HashSet());
		if (null != eavalues && eavalues.size() > 0) {
			for (int i=0; i<eavalues.size(); i++) {
				Eavalue evae = (Eavalue)eavalues.get(i);
				if (null != evae && null != evae.getId() && !evae.getId().equals(""))
					ug.getEavalues().add(evae);
			}
		}
		
		if (null != keywords) {
			String keyword = "";
			for (int i=0; i<keywords.length; i++) {
				keyword += keywords[i]+",";
			}
			ug.setKeywords(keyword);
		}
		
		sgoods.merge(ug);
		setGs(goods.getId());//转向
		return SUCCESS;
	}

	public List getLocalelist() {
		return localelist;
	}

	public void setLocalelist(List localelist) {
		this.localelist = localelist;
	}

	public List getCatelist() {
		return catelist;
	}

	public void setCatelist(List catelist) {
		this.catelist = catelist;
	}

	public String getCg() {
		return cg;
	}

	public void setCg(String cg) {
		this.cg = cg;
	}

	public Category getCcategory() {
		return ccategory;
	}

	public void setCcategory(Category ccategory) {
		this.ccategory = ccategory;
	}

	public List getGstypelist() {
		return gstypelist;
	}

	public void setGstypelist(List gstypelist) {
		this.gstypelist = gstypelist;
	}

	public String getGe() {
		return ge;
	}

	public void setGe(String ge) {
		this.ge = ge;
	}

	public Gstype getGstype() {
		return gstype;
	}

	public void setGstype(Gstype gstype) {
		this.gstype = gstype;
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

	public List<Eavalue> getEavalues() {
		return eavalues;
	}

	public void setEavalues(List<Eavalue> eavalues) {
		this.eavalues = eavalues;
	}

	public String[] getKeywords() {
		return keywords;
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}
}
