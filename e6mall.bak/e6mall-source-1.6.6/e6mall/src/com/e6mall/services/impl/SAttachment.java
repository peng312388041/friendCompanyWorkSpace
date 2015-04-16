package com.e6mall.services.impl;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Property;

import com.e6mall.dao.IAttachmentDAO;
import com.e6mall.model.Attachment;
import com.e6mall.services.ISAttachment;
import com.e6mall.utils.PaginationSupport;

public class SAttachment extends BaseServices implements ISAttachment {
	private IAttachmentDAO attachmentdao;

	public IAttachmentDAO getAttachmentdao() {
		return attachmentdao;
	}

	public void setAttachmentdao(IAttachmentDAO attachmentdao) {
		this.attachmentdao = attachmentdao;
	}

	public void attachClean(Attachment instance) {
		attachmentdao.attachClean(instance);
	}

	public void attachDirty(Attachment instance) {
		attachmentdao.attachDirty(instance);
	}

	public void delete(Attachment persistentInstance) {
		attachmentdao.delete(persistentInstance);
		String dfilepath = ServletActionContext.getServletContext().getRealPath(persistentInstance.getPath()+"/"+persistentInstance.getName());
		File dfile = new File(dfilepath);
		//缩略图
		String dtfilepath = ServletActionContext.getServletContext().getRealPath(persistentInstance.getPath()+"/s_"+persistentInstance.getName());
		File dtfile = new File(dtfilepath);
		if (dfile.exists()) {
			dfile.delete();
		}
		//删除缩略图
		if (dtfile.exists()) {
			dtfile.delete();
		}
	}
	
	public void deleteNotFile(Attachment persistentInstance) {
		attachmentdao.delete(persistentInstance);
	}

	public List findAll() {
		List list = attachmentdao.findAll();
		return list;
	}
	
	public List findAllTemplate() {
		DetachedCriteria dc = DetachedCriteria.forClass(Attachment.class);
		dc.add(Property.forName("path").like("/template", MatchMode.START));
		List list = attachmentdao.findAllByCriteria(dc);
		return list;
	}

	public Attachment findById(String id) {
		Attachment attachment = attachmentdao.findById(id);
		return attachment;
	}

	public Attachment merge(Attachment detachedInstance) {
		Attachment attachment = attachmentdao.merge(detachedInstance);
		return attachment;
	}

	public void save(Attachment transientInstance) {
		attachmentdao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = attachmentdao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = attachmentdao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int startIndex) {
		PaginationSupport ps = attachmentdao.findPageByCriteria(detachedCriteria, startIndex);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex) {
		PaginationSupport ps = attachmentdao.findPageByCriteria(detachedCriteria, pageSize, startIndex);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = attachmentdao.getCountByCriteria(detachedCriteria);
		return count;
	}

}
