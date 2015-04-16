package com.e6mall.action.manager;

import com.e6mall.model.District;
import com.e6mall.model.Logistics;
import com.e6mall.model.Lsarea;

public class LsareaCreateAction extends BaseAction {
	private static final long serialVersionUID = 4323991936932121939L;
	private String ls;
	private Logistics logistics;
	private Lsarea lsarea = new Lsarea();
	private int[] district;

	public String execute() throws Exception {
		logistics = slogistics.findById(ls);
		if (null != logistics) {
			lsarea.setId(getUuid());
			lsarea.setLogistics(logistics);
			if (null != district) {//如果物流分区没有选择任何地区，就是默认物流
				for (int i=0; i<district.length; i++) {
					District dis = sdistrict.findById(district[i]);
					lsarea.getDistricts().add(dis);
				}
			}
			
			slsarea.save(lsarea);
		}
		return SUCCESS;
	}

	public String getLs() {
		return ls;
	}

	public void setLs(String ls) {
		this.ls = ls;
	}

	public Logistics getLogistics() {
		return logistics;
	}

	public void setLogistics(Logistics logistics) {
		this.logistics = logistics;
	}

	public Lsarea getLsarea() {
		return lsarea;
	}

	public void setLsarea(Lsarea lsarea) {
		this.lsarea = lsarea;
	}

	public int[] getDistrict() {
		return district;
	}

	public void setDistrict(int[] district) {
		this.district = district;
	}
}
