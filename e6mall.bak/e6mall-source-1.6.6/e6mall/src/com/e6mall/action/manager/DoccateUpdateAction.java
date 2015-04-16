package com.e6mall.action.manager;

import java.util.ArrayList;
import java.util.List;

import com.e6mall.model.Attachment;
import com.e6mall.model.Doccate;

public class DoccateUpdateAction extends BaseUploadAction {
	private static final long serialVersionUID = 5328087418201741594L;
	private String c;
	private Doccate doccate;
	private List localelist;
	private ArrayList listtree;

	public String execute() throws Exception {
		doccate = sdoccate.findById(c);
		localelist = slocale.findAll();
		listtree = sdoccate.findAllTree();
		return SUCCESS;
	}
	
	public String update() throws Exception {
		if (!doccate.getId().equals("")) {
			Doccate uc = sdoccate.findById(doccate.getId());
			uc.setCsort(doccate.getCsort());
			uc.setDetails(doccate.getDetails());
			uc.setName(doccate.getName());
			Attachment attachment = upload();
			Attachment oimage = uc.getImage();
			if (null != attachment)
				uc.setImage(attachment);
			sdoccate.merge(uc);
			if (null != attachment && null != oimage)
				sattachment.delete(oimage);
		}
		return SUCCESS;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public Doccate getDoccate() {
		return doccate;
	}

	public void setDoccate(Doccate doccate) {
		this.doccate = doccate;
	}

	public List getLocalelist() {
		return localelist;
	}

	public void setLocalelist(List localelist) {
		this.localelist = localelist;
	}

	public ArrayList getListtree() {
		return listtree;
	}

	public void setListtree(ArrayList listtree) {
		this.listtree = listtree;
	}
}
