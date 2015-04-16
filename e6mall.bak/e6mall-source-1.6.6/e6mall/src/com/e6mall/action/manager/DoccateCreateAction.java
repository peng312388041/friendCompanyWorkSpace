package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.model.Attachment;
import com.e6mall.model.Doccate;

public class DoccateCreateAction extends BaseUploadAction {
	private static final long serialVersionUID = -8321016605858525987L;
	private List localelist;
	private Doccate doccate = new Doccate();
	private String pc;
	private Doccate pdoccate;

	public String execute() throws Exception {
		localelist = slocale.findAll();
		if (null != pc && !pc.equals(""))
			pdoccate = sdoccate.findById(pc);
		return SUCCESS;
	}
	
	public String create() throws Exception {
		Attachment attachment = upload();
		doccate.setImage(attachment);
		doccate.setId(getUuid());
		if(null!=pc && !pc.equals(""))
			pdoccate = sdoccate.findById(pc);
		String nodepath = "0>";
		if (null != pdoccate && pdoccate.getId() != null) {
			nodepath = pdoccate.getNodepath() + pdoccate.getId() + ">";
		}
		doccate.setNodepath(nodepath);
		doccate.setNodetype("F");
		doccate.setDoccate(pdoccate);
		sdoccate.save(doccate);
		if (null != pdoccate && pdoccate.getId() != null) {
			pdoccate.setNodetype("D");
			sdoccate.merge(pdoccate);
		}
		return SUCCESS;
	}

	public List getLocalelist() {
		return localelist;
	}

	public void setLocalelist(List localelist) {
		this.localelist = localelist;
	}

	public Doccate getDoccate() {
		return doccate;
	}

	public void setDoccate(Doccate doccate) {
		this.doccate = doccate;
	}

	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	public Doccate getPdoccate() {
		return pdoccate;
	}

	public void setPdoccate(Doccate pdoccate) {
		this.pdoccate = pdoccate;
	}
}
