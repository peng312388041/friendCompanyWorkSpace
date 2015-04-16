package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Category;
import com.e6mall.model.Eavalue;
import com.e6mall.model.Goods;
import com.e6mall.model.Gstype;
import com.e6mall.utils.Constants;

public class GoodsCreateAction extends BaseAction {
	private static final long serialVersionUID = -1790111470325582697L;
	private List localelist;
	private List catelist;
	private String cg;
	private Category ccategory;
	private List gstypelist;
	private String ge;
	private Gstype gstype;
	private Goods goods = new Goods();
	private List<Eavalue> eavalues;
	
	public String execute() throws Exception {
		localelist = slocale.findAll();
		catelist = scategory.findAllTree();
		gstypelist = sgstype.findAll();
		if (null != cg && !cg.equals("")) {
			ccategory = scategory.findById(cg);
			if (null != ge && !ge.equals(""))
				gstype = sgstype.findById(ge);
			else
				gstype = ccategory.getGstype();
		}
		return SUCCESS;
	}
	
	public String create() throws Exception {
		goods.setId(getUuid());
		goods.setCtime(getTimestamp());
		goods.setVistor(0);
		goods.setStatus(Constants.NORMAL);
		goods.setManager(getAsession());
		
		if (null != goods.getGstype() && null != goods.getGstype().getId() && !goods.getGstype().getId().equals("")) {
		} else {
			goods.setGstype(null);
		}
		
		if (null != eavalues && eavalues.size() > 0) {
			for (int i=0; i<eavalues.size(); i++) {
				Eavalue evae = (Eavalue)eavalues.get(i);
				if (null != evae && null != evae.getId() && !evae.getId().equals(""))
					goods.getEavalues().add(evae);
			}
		}
		
		sgoods.save(goods);
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
}
