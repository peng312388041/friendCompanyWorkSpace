package com.e6mall.action.manager;

import net.sf.json.JSONArray;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Lsarea;
import com.e6mall.model.Orders;

public class ChangeLsareaAction extends BaseAction {
	private static final long serialVersionUID = 1476249402403773341L;
	private String ft;
	private String os;
	private String result;

	public String execute() throws Exception {
		if (null != ft && !ft.equals("") && null != os && !os.equals("")) {
			Lsarea lsarea = slsarea.findById(ft);
			Orders orders = sorders.findById(os);
			if (null != lsarea && null != orders) {
				Double cost = lsarea.getLogicost(orders.getWeight());
				JSONArray jo = JSONArray.fromObject(cost);
				result = jo.toString();
			}
		}
		return SUCCESS;
	}

	public String getFt() {
		return ft;
	}

	public void setFt(String ft) {
		this.ft = ft;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
