package com.e6mall.action.manager;

import java.io.File;
import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Attachment;
import com.e6mall.utils.PaginationSupport;

public class AttachmentsAction extends BaseAction {
	private static final long serialVersionUID = 926632774866018516L;
	private PaginationSupport ps;
	private int pagesize = 12;
	private int page = 1;
	private String keyword;
	private String[] checkbox;
	private String gs;//转向
	private String dm;//文章转向
	
	private String d = "";	//目录
	private ArrayList<File> dirs;
	
	private String CKEditor;
	private String CKEditorFuncNum;
	private String langCode;

	public String execute() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Attachment.class);
		String dir;
		if (!d.equals("")) {
			dir = "/upload/" + d;
		} else {
			dir = "/upload/";
		}
		dc.add(Property.forName("path").like(dir, MatchMode.START));
		if(null != keyword && !keyword.equals(""))
			dc.add(Property.forName("details").like(keyword));
		dc.addOrder(Order.desc("ctime"));
		ps = sattachment.findPageByCriteria(dc, pagesize, page);
		dirs = getDir();
		return SUCCESS;
	}
	
	private ArrayList<File> getDir() {
		ArrayList<File> dirs = new ArrayList<File>();
		String uploaddir = "upload";
		String ruploaddir = ServletActionContext.getServletContext().getRealPath(uploaddir);
		ruploaddir = ruploaddir.replace("\\", "/");
		File d = new File(ruploaddir);
		if (!d.exists() && !d.isDirectory()) {
			d.mkdir();//文件或者目录不存在
		}
		File[] files = d.listFiles();
		for (int i=0; i<files.length; i++) {
			File file = files[i];
			if (file.exists() && file.isDirectory()) {
				dirs.add(file);
			}
		}
		return dirs;
	}
	
	public String delete() throws Exception {
		String type = "goods";		//删除商品的附件或者文章的附件
		for (int i=0; i<checkbox.length; i++) {
			Attachment da = sattachment.findById(checkbox[i]);
			if (null != da.getGoods()) {
				setGs(da.getGoods().getId());
			} else {
				type = "document";
				setDm(da.getDocument().getId());
			}
			sattachment.delete(da);
		}
		if (type.equals("document"))
			return "document";
		else
			return SUCCESS;
	}
	
	public String files_delete() throws Exception {
		for (int i=0; i<checkbox.length; i++) {
			Attachment da = sattachment.findById(checkbox[i]);
			if (null != da) {
				sattachment.delete(da);
			}
		}
		return SUCCESS;
	}

	public PaginationSupport getPs() {
		return ps;
	}

	public void setPs(PaginationSupport ps) {
		this.ps = ps;
	}

	public String getDm() {
		return dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
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

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String[] getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}

	public String getGs() {
		return gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public ArrayList<File> getDirs() {
		return dirs;
	}

	public void setDirs(ArrayList<File> dirs) {
		this.dirs = dirs;
	}

	public String getCKEditor() {
		return CKEditor;
	}

	public void setCKEditor(String cKEditor) {
		CKEditor = cKEditor;
	}

	public String getCKEditorFuncNum() {
		return CKEditorFuncNum;
	}

	public void setCKEditorFuncNum(String cKEditorFuncNum) {
		CKEditorFuncNum = cKEditorFuncNum;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}
}
