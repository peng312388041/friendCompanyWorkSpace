package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.model.Attachment;
import com.e6mall.model.Category;

public class CategoryCreateAction extends BaseUploadAction {
	private static final long serialVersionUID = 185449411565655042L;
	private List localelist;
	private List gstypelist;
	private Category category = new Category();
	private String pc;
	private Category pcategory;

	public String execute() throws Exception {
		localelist = slocale.findAll();
		gstypelist = sgstype.findAll();
		if (null != pc && !pc.equals(""))
			pcategory = scategory.findById(pc);
		return SUCCESS;
	}
	
	public String create() throws Exception {
		Attachment attachment = upload();
		category.setImage(attachment);
		category.setId(getUuid());
		if(null!=pc && !pc.equals(""))
			pcategory = scategory.findById(pc);
		String nodepath = "0>";
		if (null != pcategory && pcategory.getId() != null) {
			nodepath = pcategory.getNodepath() + pcategory.getId() + ">";
		}
		category.setNodepath(nodepath);
		category.setNodetype("F");
		category.setCategory(pcategory);
		if (null != category.getGstype() && null != category.getGstype().getId() && !category.getGstype().getId().equals("")) {
		} else {
			category.setGstype(null);
		}
		scategory.save(category);
		if (null != pcategory && pcategory.getId() != null) {
			pcategory.setNodetype("D");
			scategory.merge(pcategory);
		}
		return SUCCESS;
	}
	
	public List getLocalelist() {
		return localelist;
	}

	public void setLocalelist(List localelist) {
		this.localelist = localelist;
	}

	public List getGstypelist() {
		return gstypelist;
	}

	public void setGstypelist(List gstypelist) {
		this.gstypelist = gstypelist;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	public Category getPcategory() {
		return pcategory;
	}

	public void setPcategory(Category pcategory) {
		this.pcategory = pcategory;
	}
}
