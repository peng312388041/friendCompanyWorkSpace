package com.e6mall.action.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.e6mall.model.Attachment;
import com.e6mall.model.Category;

public class CategoryUpdateAction extends BaseUploadAction {
	private static final long serialVersionUID = 7358841937625567351L;
	private String c;
	private Category category;
	private List localelist;
	private List gstypelist;
	private ArrayList listtree;

	public String execute() throws Exception {
		category = scategory.findById(c);
		localelist = slocale.findAll();
		gstypelist = sgstype.findAll();
		listtree = scategory.findAllTree();
		return SUCCESS;
	}
	
	public String update() throws Exception {
		if (!category.getId().equals("")) {
			Category uc = scategory.findById(category.getId());
			uc.setCsort(category.getCsort());
			uc.setDetails(category.getDetails());
			uc.setName(category.getName());
			uc.setLocale(category.getLocale());	//修正商品类别修改语言无效
			if (null != category.getGstype() && null != category.getGstype().getId() && !category.getGstype().getId().equals("")) {
				uc.setGstype(category.getGstype());
			} else {
				uc.setGstype(null);
			}
			Attachment attachment = upload();
			Attachment oimage = uc.getImage();
			if (null != attachment)
				uc.setImage(attachment);
			
			String ucpid = "";//网页上的无父目录一定要设置""，与这里对应
			if (null != uc.getCategory())
				ucpid = uc.getCategory().getId();
			if (!category.getCategory().getId().equals(ucpid)) {
				Category sPcate = uc.getCategory();//原父目录
				Category newPcate = scategory.findById(category.getCategory().getId());//新父目录
				String nodepath = "0>";
				if (null != newPcate) {
					nodepath = newPcate.getNodepath() + newPcate.getId() + ">";
					uc.setCategory(newPcate);
				} else {
					uc.setCategory(null);
				}
				uc.setNodepath(nodepath);
				scategory.merge(uc);
				
				//修改新父目录
				if (null != newPcate && newPcate.getNodetype().equals("F")) {
					newPcate.setNodetype("D");
					scategory.merge(newPcate);
				}
				
				//修改原父目录
				if (null != sPcate) {
					sPcate.getCategories().remove(uc);
					if (sPcate.getCategories().size()<=0) {
						sPcate.setNodetype("F");
						scategory.merge(sPcate);
					}
				}
				
				//修改子目录
				Iterator it = uc.getCategories().iterator();
				while(it.hasNext()) {
					Category c = (Category)it.next();
					String np = "0>";
					np = uc.getNodepath() + uc.getId() + ">";
					c.setNodepath(np);
					scategory.merge(c);
				}
			} else {
				scategory.merge(uc);
			}
			
			scategory.merge(uc);
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public ArrayList getListtree() {
		return listtree;
	}

	public void setListtree(ArrayList listtree) {
		this.listtree = listtree;
	}
}
