package com.e6mall.action.manager;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.e6mall.model.Attachment;
import com.e6mall.model.Config;
import com.e6mall.model.Goods;
import com.e6mall.utils.ImageUtil;

public class GoodsThumbnailAction extends BaseAction {
	private static final long serialVersionUID = 7389024432374165780L;
	private String gs;
	private Goods goods;
	private int total = 0;		//商品总数
	private int complete = 0;	//当前完成数

	public String execute() throws Exception {
		goods = sgoods.findById(gs);
		generateDefault(goods);
		return SUCCESS;
	}
	
	public String createAll() throws Exception {
		return SUCCESS;
	}
	
	public String createAllDo() throws Exception {
		List list = sgoods.findAll();
		for (int i=0; i<list.size(); i++) {
			Goods goods = (Goods)list.get(i);
			Iterator it = goods.getAttachments().iterator();
			generate(goods);
			setComplete(i);		//记数
		}
		return SUCCESS;
	}
	
	/*
	 * 生成商品缩略图 - 仅生成默认图
	 */
	private void generateDefault(Goods goods) {
		DetachedCriteria dc = DetachedCriteria.forClass(Attachment.class);
		dc.add(Property.forName("goods").eq(goods));
		dc.add(Property.forName("status").eq("default"));
		List list = sattachment.findAllByCriteria(dc);
		for (int i=0; i<list.size(); i++) {
			Attachment am = (Attachment)list.get(i);
			String ipath = ServletActionContext.getServletContext().getRealPath(am.getPath()+"/"+am.getName());
			File imageFile = new File(ipath);
			String tpath = ServletActionContext.getServletContext().getRealPath(am.getPath()+"/s_"+am.getName());
			File thumbnailFile = new File(tpath);
			Config cmaxWidth = sconfig.findByProperty("goods_thumbnail_maxWidth");
			Config cmaxHeight = sconfig.findByProperty("goods_thumbnail_maxHeight");
			int maxWidth = Integer.valueOf(cmaxWidth.getValue());
			int maxHeight = Integer.valueOf(cmaxHeight.getValue());
			if (imageFile.exists()) {
				try {
					ImageUtil.createThumbnail(imageFile, thumbnailFile, maxWidth, maxHeight);
					logger.debug(goods.getName() + ":" + am.getName() + "：生成缩略图。");
				} catch (IOException e) {
					System.out.println("找不到文件路径："+imageFile.getAbsolutePath());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/*
	 * 生成商品缩略图 - 生成所有图片附件
	 */
	private void generate(Goods goods) {
		Iterator it = goods.getAttachments().iterator();
		while (it.hasNext()) {
			Attachment am = (Attachment)it.next();
			String ipath = ServletActionContext.getServletContext().getRealPath(am.getPath()+"/"+am.getName());
			File imageFile = new File(ipath);
			String tpath = ServletActionContext.getServletContext().getRealPath(am.getPath()+"/s_"+am.getName());
			File thumbnailFile = new File(tpath);
			Config cmaxWidth = sconfig.findByProperty("goods_thumbnail_maxWidth");
			Config cmaxHeight = sconfig.findByProperty("goods_thumbnail_maxHeight");
			int maxWidth = Integer.valueOf(cmaxWidth.getValue());
			int maxHeight = Integer.valueOf(cmaxHeight.getValue());
			if (imageFile.exists()) {
				try {
					ImageUtil.createThumbnail(imageFile, thumbnailFile, maxWidth, maxHeight);
					logger.debug(goods.getName() + ":" + am.getName() + "：生成缩略图。");
				} catch (IOException e) {
					System.out.println("找不到文件路径："+imageFile.getAbsolutePath());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String getGs() {
		return gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getComplete() {
		return complete;
	}

	public void setComplete(int complete) {
		this.complete = complete;
	}
}
