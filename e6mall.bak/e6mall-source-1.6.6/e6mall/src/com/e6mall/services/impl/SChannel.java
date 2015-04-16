package com.e6mall.services.impl;

import java.util.List;

import com.e6mall.dao.IChannelDAO;
import com.e6mall.model.Attachment;
import com.e6mall.model.Channel;
import com.e6mall.services.ISAttachment;
import com.e6mall.services.ISChannel;

public class SChannel extends BaseServices implements ISChannel {
	private IChannelDAO channeldao;
	private ISAttachment sattachment;

	public IChannelDAO getChanneldao() {
		return channeldao;
	}

	public void setChanneldao(IChannelDAO channeldao) {
		this.channeldao = channeldao;
	}

	public ISAttachment getSattachment() {
		return sattachment;
	}

	public void setSattachment(ISAttachment sattachment) {
		this.sattachment = sattachment;
	}

	public void attachClean(Channel instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Channel instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Channel channel) {
		Attachment attachment = channel.getTemplate();
		if (null != attachment)
			sattachment.delete(attachment);
		channeldao.delete(channel);
	}

	public List findAll() {
		List list = channeldao.findAll();
		return list;
	}

	public Channel findById(String id) {
		Channel channel = channeldao.findById(id);
		return channel;
	}

	public Channel merge(Channel detachedInstance) {
		Channel channel = channeldao.merge(detachedInstance);
		return channel;
	}

	public void save(Channel transientInstance) {
		channeldao.save(transientInstance);
	}

}
