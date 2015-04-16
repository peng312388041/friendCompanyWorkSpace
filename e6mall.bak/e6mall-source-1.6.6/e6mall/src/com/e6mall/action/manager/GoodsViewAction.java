package com.e6mall.action.manager;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Goods;

public class GoodsViewAction extends BaseAction {
	private static final long serialVersionUID = 7186536916339681963L;
	private String gs;
	private Goods goods;

	public String execute() throws Exception {
		goods = sgoods.findById(gs);
		return SUCCESS;
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
}
