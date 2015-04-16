package com.e6mall.action.manager;

import net.sf.json.JSONArray;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Orders;
import com.e6mall.model.Paymode;

public class ChangePaymodeAction extends BaseAction {
	private static final long serialVersionUID = 4121866294663339423L;
	private String pm;
	private String os;
	private String result;

	public String execute() throws Exception {
		if (null != pm && !pm.equals("") && null != os && !os.equals("")) {
			Paymode paymode = spaymode.findById(pm);
			Orders orders = sorders.findById(os);
			if (null != paymode && null != orders) {
				Double cost = (paymode.getRate() /100) * orders.getAmount();
				JSONArray jo = JSONArray.fromObject(cost);
				result = jo.toString();
			}
		}
		return SUCCESS;
	}

	public String getPm() {
		return pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
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
