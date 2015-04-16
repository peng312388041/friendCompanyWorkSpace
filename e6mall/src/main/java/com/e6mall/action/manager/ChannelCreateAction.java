package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.model.Attachment;
import com.e6mall.model.Channel;
import com.e6mall.utils.FileExt;

public class ChannelCreateAction extends BaseUploadAction {
	private static final long serialVersionUID = -4504233842844019399L;
	private List tplist;
	private List localelist;
	private Channel channel = new Channel();
	private String localeid = "zh_CN";

	public String execute() throws Exception {
		localelist = slocale.findAll();
		tplist = sattachment.findAllTemplate();
		return SUCCESS;
	}
	
	public String create() throws Exception {
		channel.setCdate(getTimestamp());
		channel.setManager(getAsession());
		Attachment attachment = upload();
		if (null != attachment)
			channel.setTemplate(attachment);
		schannel.save(channel);
		return SUCCESS;
	}
	
	@Override
	public void setUploadFileName(String uploadFileName) {
		this.oldFileName = uploadFileName;
		setFextname(FileExt.getExtension(uploadFileName));
		this.langFileName = channel.getId() + "." + FileExt.getExtension(uploadFileName);//存入数据库的名称
		this.uploadFileName = localeid + "_" + channel.getId() + "." + FileExt.getExtension(uploadFileName);//上传到文件夹的名称
	}
	
	@Override
	public void setSavePath(String savePath) {
		this.savePath = savePath+"/custom";
	}

	public List getTplist() {
		return tplist;
	}

	public void setTplist(List tplist) {
		this.tplist = tplist;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
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
}
