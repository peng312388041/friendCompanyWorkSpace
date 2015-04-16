package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Chcontent;

public class ChcontentUpdateAction extends BaseAction {
	private static final long serialVersionUID = 694098815459907123L;
	private String ct;
	private Chcontent chcontent;
	private List doccates;
	private List categorys;
	private List localelist;
	private String ca;

	public String execute() throws Exception {
		chcontent = schcontent.findById(ct);
		doccates = sdoccate.findAllTree();
		categorys = scategory.findAllTree();
		localelist = slocale.findAll();
		if (null != chcontent.getGlobal() && chcontent.getGlobal().equals("yes"))
			return "global";
		else
			return SUCCESS;
	}
	
	public String update() throws Exception {
		Chcontent uct = schcontent.findById(chcontent.getId());
		uct.setDetail(chcontent.getDetail());

		if (null != chcontent.getCategory().getId() && !chcontent.getCategory().getId().equals("")) {
			uct.setCategory(chcontent.getCategory());
		} else {
			uct.setCategory(null);
		}
		if (null != chcontent.getDoccate().getId() && !chcontent.getDoccate().getId().equals("")) {
			uct.setDoccate(chcontent.getDoccate());
		} else {
			uct.setDoccate(null);
		}
		if (null != chcontent.getDocument() && null != chcontent.getDocument().getId() && !chcontent.getDocument().getId().equals("")) {
			uct.setDocument(chcontent.getDocument());
		} else {
			uct.setDocument(null);
		}
		
		uct.setLocale(chcontent.getLocale());
		uct.setManager(getAsession());
		uct.setMarker(chcontent.getMarker());
		uct.setNumber(chcontent.getNumber());
		uct.setOffset(chcontent.getOffset());
		uct.setType(chcontent.getType());
		uct.setKeys(chcontent.getKeys());
		schcontent.merge(uct);
		if (null != uct.getGlobal() && uct.getGlobal().equals("yes")) {
			return "global";
		} else {
			setCa(uct.getChannel().getId());
			return SUCCESS;
		}
	}

	public String getCt() {
		return ct;
	}

	public void setCt(String ct) {
		this.ct = ct;
	}

	public Chcontent getChcontent() {
		return chcontent;
	}

	public void setChcontent(Chcontent chcontent) {
		this.chcontent = chcontent;
	}

	public List getDoccates() {
		return doccates;
	}

	public void setDoccates(List doccates) {
		this.doccates = doccates;
	}

	public List getCategorys() {
		return categorys;
	}

	public void setCategorys(List categorys) {
		this.categorys = categorys;
	}

	public List getLocalelist() {
		return localelist;
	}

	public void setLocalelist(List localelist) {
		this.localelist = localelist;
	}

	public String getCa() {
		return ca;
	}

	public void setCa(String ca) {
		this.ca = ca;
	}
}
