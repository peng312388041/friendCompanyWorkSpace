package com.e6mall.action.manager;

import java.io.PrintWriter;

import com.e6mall.model.Spec;

public class SpecitemUpdateAjax extends BaseAction {
	private static final long serialVersionUID = -2676830283353906961L;
	private String id;
	private String value;
	private String utype = "";//更新某个属性

	public String execute() throws Exception {
		Spec spec = sspec.findById(id);
		PrintWriter out = response.getWriter();
		if (utype.equals("gscode")) {
			spec.setGscode(value);
		} else if (utype.equals("inventory")) {
			Integer pinteger = spec.getInventory();
			try {
				pinteger = Integer.parseInt(value);
			} catch (Exception e) {
			}
			spec.setInventory(pinteger);
		} else if (utype.equals("price")) {
			Double pdouble = spec.getPrice();
			try {
				pdouble = Double.parseDouble(value);
			} catch (Exception e) {
			}
			spec.setPrice(pdouble);
		} else if (utype.equals("cprice")) {
			Double pdouble = spec.getCprice();
			try {
				pdouble = Double.parseDouble(value);
			} catch (Exception e) {
			}
			spec.setCprice(pdouble);
		} else if (utype.equals("weight")) {
			Double pdouble = new Double(0);
			try {
				pdouble = Double.parseDouble(value);
			} catch (Exception e) {
			}
			spec.setWeight(pdouble);
		}
		
		sspec.merge(spec);
		out.print(value);
		return null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUtype() {
		return utype;
	}

	public void setUtype(String utype) {
		this.utype = utype;
	}
}