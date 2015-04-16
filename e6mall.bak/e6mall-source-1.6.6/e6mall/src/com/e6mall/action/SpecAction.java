package com.e6mall.action;

import java.util.Iterator;

import com.e6mall.model.Goods;
import com.e6mall.model.Spec;
import com.e6mall.model.Specvalue;

/*
 * 商品详细页AJAX请求商品规格
 */
public class SpecAction extends BaseAction {
	private static final long serialVersionUID = 8354856290348140348L;
	private String gid;
	private String svid;

	public String execute() throws Exception {
		Goods goods = sgoods.findById(gid);
		Specvalue specvalue = sspecvalue.findById(svid);
		Iterator it = goods.getSpecs().iterator();
		while(it.hasNext()) {
			Spec spec = (Spec)it.next();
			System.out.println("此价格："+spec.getPrice());
			Iterator it2 = spec.getSpecvalues().iterator();
			while (it2.hasNext()) {
				Specvalue sv = (Specvalue)it2.next();
				System.out.println("规格值："+sv.getName());
				if (sv.equals(specvalue)) {
					System.out.println("找到相同的规格值："+specvalue.getName());
					
				}
			}
		}
		return SUCCESS;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getSvid() {
		return svid;
	}

	public void setSvid(String svid) {
		this.svid = svid;
	}
}
