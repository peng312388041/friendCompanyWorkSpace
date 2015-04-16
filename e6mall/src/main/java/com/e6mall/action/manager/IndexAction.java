package com.e6mall.action.manager;

import java.util.Properties;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Property;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Goods;

public class IndexAction extends BaseAction {
	private static final long serialVersionUID = 2941587175713261188L;
	private int goods_count = 0;	//商品总数
	private int inventory_count = 0;//库存警告商品数
	private int new_count = 0;		//新品推荐数
	private int hot_count = 0;		//热销商品数
	private int btq_count = 0;		//精品推荐数
	private int promote_count = 0;	//促销商品数
	private Properties props; 		//系统属性
	private Runtime runtime;

	public String execute() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
		goods_count = sgoods.getCountByCriteria(dc);
		
		dc.add(Property.forName("promote").eq("yes"));
		promote_count = sgoods.getCountByCriteria(dc);

		new_count = findByKey("new");
		hot_count = findByKey("hot");
		btq_count = findByKey("btq");

		props=System.getProperties();
		runtime = Runtime.getRuntime();//.freeMemory();
		Runtime.getRuntime().maxMemory();
		Runtime.getRuntime().totalMemory();
		Runtime.getRuntime().availableProcessors();
		
		return SUCCESS;
	}
	
	private int findByKey(String key) {
		int count = 0;
		DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
		dc.add(Property.forName("keywords").like(key, MatchMode.ANYWHERE));
		count = sgoods.getCountByCriteria(dc);
		return count;
	}

	public int getGoods_count() {
		return goods_count;
	}

	public void setGoods_count(int goodsCount) {
		goods_count = goodsCount;
	}

	public int getInventory_count() {
		return inventory_count;
	}

	public void setInventory_count(int inventoryCount) {
		inventory_count = inventoryCount;
	}

	public int getNew_count() {
		return new_count;
	}

	public void setNew_count(int newCount) {
		new_count = newCount;
	}

	public int getHot_count() {
		return hot_count;
	}

	public void setHot_count(int hotCount) {
		hot_count = hotCount;
	}

	public int getBtq_count() {
		return btq_count;
	}

	public void setBtq_count(int btqCount) {
		btq_count = btqCount;
	}

	public int getPromote_count() {
		return promote_count;
	}

	public void setPromote_count(int promoteCount) {
		promote_count = promoteCount;
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	public Runtime getRuntime() {
		return runtime;
	}

	public void setRuntime(Runtime runtime) {
		this.runtime = runtime;
	}
}
