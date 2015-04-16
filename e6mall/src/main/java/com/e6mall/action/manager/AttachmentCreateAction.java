package com.e6mall.action.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.e6mall.model.Attachment;
import com.e6mall.model.Config;
import com.e6mall.model.Goods;
import com.e6mall.utils.FileExt;
import com.e6mall.utils.ImageUtil;

public class AttachmentCreateAction extends BaseAction {
	private static final long serialVersionUID = 9006663776805551309L;
	private String gs;
	private String d;	//文章
	private Goods goods;
	private Attachment attachment = new Attachment();
	
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String oldFileName;
	private String savePath;
	private String fextname;

	public String execute() throws Exception {
		goods = sgoods.findById(gs);
		return SUCCESS;
	}
	
	public String create() throws Exception {
		upload();
		if (null != attachment.getGoods()) {
			setGs(attachment.getGoods().getId());//转向
			return SUCCESS;
		} else {
			setD(attachment.getDocument().getId());
			return "document";
		}
	}
	
	private Attachment upload() throws Exception {
		if (upload != null) {
			System.out.println(this.getUploadContentType());
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
			
			//System.out.println(test.getPath());
			//Linux出现异常
			//File savedFile = new File(tfilepath, getUploadFileName());
			//upload.renameTo(savedFile);
			attachment.setOname(getOldFileName());
			attachment.setId(getUuid());
			attachment.setName(getUploadFileName());
			attachment.setFtype(fextname);
			attachment.setPath(getSavePath());
			attachment.setManager(getAsession());
			attachment.setCtime(getTimestamp());
			sattachment.save(attachment);
			
			//如果目前这张图是默认图，那么设置其他图为正常 - 商品
			if (null != attachment.getGoods() && attachment.getStatus().equals("default")) {
				DetachedCriteria dc = DetachedCriteria.forClass(Attachment.class);
				dc.add(Property.forName("goods").eq(attachment.getGoods()));
				dc.add(Property.forName("status").eq("default"));
				List list = sattachment.findAllByCriteria(dc);
				for (int i=0; i<list.size(); i++) {
					Attachment am = (Attachment)list.get(i);
					if (!am.equals(attachment)) {
						am.setStatus("normal");
						sattachment.merge(am);
					}
				}
			}
			
			//如果目前这张图是默认图，那么设置其他图为正常 - 文章
			if (null != attachment.getDocument() && attachment.getStatus().equals("default")) {
				DetachedCriteria dc = DetachedCriteria.forClass(Attachment.class);
				dc.add(Property.forName("document").eq(attachment.getDocument()));
				dc.add(Property.forName("status").eq("default"));
				List list = sattachment.findAllByCriteria(dc);
				for (int i=0; i<list.size(); i++) {
					Attachment am = (Attachment)list.get(i);
					if (!am.equals(attachment)) {
						am.setStatus("normal");
						sattachment.merge(am);
					}
				}
			}
			
			//如果目前这张图是默认图，生成缩略图
			if (attachment.getStatus().equals("default")) {
				File imageFile = new File(tfilepath + "/" + getUploadFileName());
				File thumbnailFile = new File(tfilepath + "/s_" + getUploadFileName());	//生成同名文件名前面加字符s_
				
				Config cmaxWidth = sconfig.findByProperty("goods_thumbnail_maxWidth");
				Config cmaxHeight = sconfig.findByProperty("goods_thumbnail_maxHeight");
				
				if (null != attachment.getDocument()) {
					cmaxWidth = sconfig.findByProperty("doc_thumbnail_maxWidth");
					cmaxHeight = sconfig.findByProperty("doc_thumbnail_maxHeight");
				}
				
				int maxWidth = Integer.valueOf(cmaxWidth.getValue());
				int maxHeight = Integer.valueOf(cmaxHeight.getValue());
				ImageUtil.createThumbnail(imageFile, thumbnailFile, maxWidth, maxHeight);
			}
		}
		return attachment;
	}
	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		System.out.println(upload);
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
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

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
}
