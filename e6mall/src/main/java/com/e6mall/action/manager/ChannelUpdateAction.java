package com.e6mall.action.manager;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.struts2.ServletActionContext;

import com.e6mall.model.Attachment;
import com.e6mall.model.Channel;
import com.e6mall.utils.FileExt;

public class ChannelUpdateAction extends BaseUploadAction {
	private static final long serialVersionUID = -1441686332340309751L;
	private String ca;
	private Channel channel;
	private List tplist;
	private List localelist;
	private String type = "template";
	private String localeid = "zh_CN";
	private List vfiles = new ArrayList();//显示该模板的所有语言版本
	private List viewfiles = new ArrayList();//显示该模板的所有语言版本，详细页

	public String execute() throws Exception {
		channel = schannel.findById(ca);
		localelist = slocale.findAll();
		tplist = sattachment.findAllTemplate();
		
		try {
			String path = channel.getTemplate().getPath();
			String tfilepath = ServletActionContext.getServletContext().getRealPath(path);
			File test = new File(tfilepath);
			System.out.println(test.getPath());
			if (test.exists() && test.isDirectory()) {
				//搜索本频道的所有语言文件显示出来
				FileFilter fileFilter = new RegexFileFilter(".*_"+ca+".vm");
				//System.out.println(fileFilter.toString());
				File[] files = test.listFiles(fileFilter);
				for (int i = 0; i < files.length; i++) {
				   System.out.println(files[i].getName());
				   vfiles.add(files[i].getName());
				}
				
				fileFilter = new RegexFileFilter(".*_"+ca+"_view.vm");
				//System.out.println(fileFilter.toString());
				files = test.listFiles(fileFilter);
				for (int i = 0; i < files.length; i++) {
				   System.out.println(files[i].getName());
				   viewfiles.add(files[i].getName());
				}
			}
		} catch (Exception e) {
			//没有模板文件异常
		}
		return SUCCESS;
	}
	
	public String update() throws Exception {
		Channel uca = schannel.findById(channel.getId());
		if (type.equals("vtemplate")) {
			uca.setManager(getAsession());
			Attachment attachment = upload();
			Attachment ovtemplate = uca.getVtemplate();
			if (null != attachment)
				uca.setVtemplate(attachment);
			schannel.merge(uca);
			if (null != ovtemplate)
				sattachment.deleteNotFile(ovtemplate);
		} else {
			uca.setIntro(channel.getIntro());
			uca.setTitle(channel.getTitle());
			uca.setManager(getAsession());
			Attachment attachment = upload();
			Attachment otemplate = uca.getTemplate();
			if (null != attachment)
				uca.setTemplate(attachment);
			schannel.merge(uca);
			if (null != otemplate)
				sattachment.deleteNotFile(otemplate);
		}
		
		return SUCCESS;
	}
	
	@Override
	public void setUploadFileName(String uploadFileName) {
		this.oldFileName = uploadFileName;
		setFextname(FileExt.getExtension(uploadFileName));
		if (type.equals("vtemplate")) {
			this.langFileName = channel.getId() + "_view." + FileExt.getExtension(uploadFileName);
			this.uploadFileName =  localeid + "_" + channel.getId() + "_view." + FileExt.getExtension(uploadFileName);
		} else {
			this.langFileName = channel.getId() + "." + FileExt.getExtension(uploadFileName);//存入数据库的名称
			this.uploadFileName = localeid + "_" + channel.getId() + "." + FileExt.getExtension(uploadFileName);//上传到文件夹的名称
		}
	}
	
	@Override
	public void setSavePath(String savePath) {
		this.savePath = savePath+"/custom";
	}

	public String getCa() {
		return ca;
	}

	public void setCa(String ca) {
		this.ca = ca;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public List getTplist() {
		return tplist;
	}

	public void setTplist(List tplist) {
		this.tplist = tplist;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List getLocalelist() {
		return localelist;
	}

	public void setLocalelist(List localelist) {
		this.localelist = localelist;
	}

	public String getLocaleid() {
		return localeid;
	}

	public void setLocaleid(String localeid) {
		this.localeid = localeid;
	}

	public List getVfiles() {
		return vfiles;
	}

	public void setVfiles(List vfiles) {
		this.vfiles = vfiles;
	}

	public List getViewfiles() {
		return viewfiles;
	}

	public void setViewfiles(List viewfiles) {
		this.viewfiles = viewfiles;
	}
}
