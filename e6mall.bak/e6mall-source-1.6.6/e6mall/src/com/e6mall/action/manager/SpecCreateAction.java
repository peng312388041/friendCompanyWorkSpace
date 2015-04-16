package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Goods;
import com.e6mall.model.Spec;
import com.e6mall.model.Specvalue;

public class SpecCreateAction extends BaseAction {
	private static final long serialVersionUID = -8324470651719718547L;
	private String gs;
	private Goods goods;
	private Spec spec = new Spec();
	private List<Specvalue> specvalues;

	public String execute() throws Exception {
		spec.setId(getUuid());
		goods = sgoods.findById(gs);
		spec.setGoods(goods);
		for (int i=0; i<specvalues.size(); i++) {
			Specvalue sc = specvalues.get(i);
			if (null != sc)
				spec.getSpecvalues().add(sc);
		}
		sspec.save(spec);
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

	public Spec getSpec() {
		return spec;
	}

	public void setSpec(Spec spec) {
		this.spec = spec;
	}

	public List<Specvalue> getSpecvalues() {
		return specvalues;
	}

	public void setSpecvalues(List<Specvalue> specvalues) {
		this.specvalues = specvalues;
	}
}
