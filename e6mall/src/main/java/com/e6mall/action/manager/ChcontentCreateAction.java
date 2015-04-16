package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Channel;
import com.e6mall.model.Chcontent;
import com.e6mall.model.Document;

public class ChcontentCreateAction extends BaseAction {
	private static final long serialVersionUID = 3399977905649826918L;
	private String ca;
	private Channel channel;
	private List doccates;
	private List categorys;
	private List localelist;
	private List channels;
	private String d;
	private Document document;
	private Chcontent chcontent = new Chcontent();

	public String execute() throws Exception {
		channel = schannel.findById(ca);
		doccates = sdoccate.findAllTree();
		categorys = scategory.findAllTree();
		localelist = slocale.findAll();
		return SUCCESS;
	}
	
	public String doc_input() throws Exception {	//单条信息
		channels = schannel.findAll();
		document = sdocument.findById(d);
		localelist = slocale.findAll();
		return SUCCESS;
	}
	
	public String global_input() throws Exception {	//全局频道内容
		doccates = sdoccate.findAllTree();
		categorys = scategory.findAllTree();
		localelist = slocale.findAll();
		return SUCCESS;
	}
	
	public String create() throws Exception {
		String returnstr = "success";
		if (null != ca && !ca.equals("")) {
			channel = schannel.findById(ca);
			if (null != channel) {
				chcontent.setChannel(channel);
			} else if (chcontent.getGlobal().equals("no")) {	//既不属于任何频道，又不是全局频道内容，返回错误。
				notice.setStatus(false);
				notice.setCode("Chcontent Set Error");
				notice.setTitle("错误");
				notice.setBody("该频道内容既不属于任何频道，也不是全局频道内容，请检查后重新操作。");
				return ERROR;
			}
		} else {	//创建全局频道内容
			chcontent.setChannel(null);
			returnstr = "channels";
		}
		
		chcontent.setId(getUuid());
		chcontent.setCdate(getTimestamp());
		chcontent.setManager(getAsession());
		if (null != chcontent.getCategory().getId() && !chcontent.getCategory().getId().equals("")) {
		} else {
			chcontent.setCategory(null);
		}
		if (null != chcontent.getDoccate().getId() && !chcontent.getDoccate().getId().equals("")) {
		} else {
			chcontent.setDoccate(null);
		}
		if (null != chcontent.getDocument().getId() && !chcontent.getDocument().getId().equals("")) {
		} else {
			chcontent.setDocument(null);
		}
		schcontent.save(chcontent);
		
		return returnstr;
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

	public Chcontent getChcontent() {
		return chcontent;
	}

	public void setChcontent(Chcontent chcontent) {
		this.chcontent = chcontent;
	}

	public List getDoccates() {
		return doccates;
	}

	public void setDoccates(List doccates) {
		this.doccates = doccates;
	}

	public List getCategorys() {
		return categorys;
	}

	public void setCategorys(List categorys) {
		this.categorys = categorys;
	}

	public List getLocalelist() {
		return localelist;
	}

	public void setLocalelist(List localelist) {
		this.localelist = localelist;
	}

	public List getChannels() {
		return channels;
	}

	public void setChannels(List channels) {
		this.channels = channels;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
}
