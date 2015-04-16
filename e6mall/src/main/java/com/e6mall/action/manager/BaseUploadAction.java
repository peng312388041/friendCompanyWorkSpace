package com.e6mall.action.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.e6mall.model.Attachment;
import com.e6mall.utils.FileExt;

public class BaseUploadAction extends BaseAction {
	private static final long serialVersionUID = 8496793296177118669L;

	protected File upload;
	protected String uploadContentType;
	protected String uploadFileName;
	protected String oldFileName;
	protected String savePath;
	protected String fextname;
	protected String attdetails = "";
	protected String attstatus = "";
	protected Integer attsort = 10;
	
	protected String langFileName;//上传语言网页模板转换属性
	
	protected Attachment upload() {
		Attachment attachment = null;
		if (upload != null) {
			attachment = new Attachment();
			String tfilepath = ServletActionContext.getServletContext().getRealPath(getSavePath());
			File test = new File(tfilepath);
			if (!test.exists())
				test.mkdirs();
			
			try {
				FileOutputStream fos = new FileOutputStream(tfilepath + "/" + getUploadFileName());
				FileInputStream fis = new FileInputStream(getUpload());
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = fis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
				fis.close();
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			}
			
			//File savedFile = new File(tfilepath, getUploadFileName());	//Linux上运行无效
			//upload.renameTo(savedFile);
			attachment.setOname(getOldFileName());
			
			attachment.setId(getUuid());
			attachment.setName(getLangFileName());
			attachment.setFtype(fextname);
			attachment.setPath(getSavePath());
			attachment.setManager(getAsession());
			attachment.setDetails(attdetails);
			attachment.setCtime(getTimestamp());
			attachment.setStatus(attstatus);
			attachment.setSort(attsort);
			sattachment.save(attachment);
		}
		return attachment;
	}
	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
		System.out.println("文件类型:"+uploadContentType);
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.oldFileName = uploadFileName;
		String id = getUuid().substring(1, 5);//5位随机字母数字
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");//年月日小时分秒毫秒
		String date = sdf.format(new Date());
		setFextname(FileExt.getExtension(uploadFileName));
		this.uploadFileName = date + id + "." + FileExt.getExtension(uploadFileName);
		this.langFileName = this.uploadFileName;//默认一样
	}

	public String getLangFileName() {
		return langFileName;
	}

	public void setLangFileName(String langFileName) {
		this.langFileName = langFileName;
	}

	public String getOldFileName() {
		return oldFileName;
	}

	public void setOldFileName(String oldFileName) {
		this.oldFileName = oldFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String date = sdf.format(new Date());
		this.savePath = savePath+"/"+date;
	}

	public String getFextname() {
		return fextname;
	}

	public void setFextname(String fextname) {
		this.fextname = fextname;
	}

	public String getAttdetails() {
		return attdetails;
	}

	public void setAttdetails(String attdetails) {
		this.attdetails = attdetails;
	}

	public String getAttstatus() {
		return attstatus;
	}

	public void setAttstatus(String attstatus) {
		this.attstatus = attstatus;
	}

	public Integer getAttsort() {
		return attsort;
	}

	public void setAttsort(Integer attsort) {
		this.attsort = attsort;
	}
}
