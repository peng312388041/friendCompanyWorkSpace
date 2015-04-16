package com.e6mall.action.manager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.e6mall.model.Groups;
import com.e6mall.model.Manager;
import com.e6mall.model.Member;
import com.e6mall.model.Mgroups;
import com.e6mall.model.Permission;

public class PermissionsAction extends BaseAction {
	private static final long serialVersionUID = 3927937906744681656L;
	private String gs;//会员组
	private Groups groups;
	private String mb;//会员
	private Member member;
	private String ms;//管理员组
	private Mgroups mgroups;
	private String mg;//管理员
	private Manager manager;
	private List list;

	public String execute() throws Exception {
		list = spermission.findAllRoot();
		return SUCCESS;
	}
	
	public String member() throws Exception {
		member = smember.findById(mb);
		DetachedCriteria dc = DetachedCriteria.forClass(Permission.class);
		dc.createCriteria("member").add(Restrictions.eq("id", mb));
		list = spermission.findAllByCriteria(dc);
		return SUCCESS;
	}
	
	public String manager() throws Exception {
		manager = smanager.findById(mg);
		DetachedCriteria dc = DetachedCriteria.forClass(Permission.class);
		dc.add(Property.forName("manager").eq(manager));
		dc.addOrder(Order.asc("code"));
		List plist = spermission.findAllByCriteria(dc);	//用户配置
		
		list = spermission.findAllRoot();		//所有权限目录，默认配置
		for (int k=0; k<list.size(); k++) {
			Permission root = (Permission)list.get(k);	//权限目录
			Set set = root.getPermissions();		//权限目录下的所有权限
			Set tempset = new HashSet();		//建立临时的存储Set
			if (!set.isEmpty()) {
				Iterator it = set.iterator();
				while (it.hasNext()) {	//循环当前权限目录下的所有权限
					Permission itpms = (Permission)it.next();	//当前权限
					if (plist.size() > 0) {	//账户已经有的权限
						boolean flag = true;	//设置初始比较标志
						for (int j=0; j<plist.size(); j++) {
							Permission pj = (Permission)plist.get(j);
							if (pj.getCode().equals(itpms.getCode()) && pj.getPermission().equals(itpms.getPermission())) {	//比较
								tempset.add(pj);	//加入临时存储Set
								flag = false;	//如果用户有相同配置，关闭标志。
							}
						}
						if (flag) {	//如果用户没有相同配置，加入默认项。
							tempset.add(itpms);
						}
					} else {	//如果账户没有任何权限设置
						tempset.addAll(set);	//加入所有
					}
				}
			}
			root.setPermissions(tempset);	//重置当前权限目录下的所有权限
			//TODO set排序
		}
		
		return SUCCESS;
	}
	
	public String mgroups() throws Exception {
		mgroups = smgroups.findById(ms);
		DetachedCriteria dc = DetachedCriteria.forClass(Permission.class);
		dc.createCriteria("mgroups").add(Restrictions.eq("id", ms));
		list = spermission.findAllByCriteria(dc);
		return SUCCESS;
	}
	
	public String groups() throws Exception {
		groups = sgroups.findById(gs);
		DetachedCriteria dc = DetachedCriteria.forClass(Permission.class);
		dc.createCriteria("groups").add(Restrictions.eq("id", gs));
		list = spermission.findAllByCriteria(dc);
		return SUCCESS;
	}

	public String getGs() {
		return gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
	}

	public Groups getGroups() {
		return groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}

	public String getMb() {
		return mb;
	}

	public void setMb(String mb) {
		this.mb = mb;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public Mgroups getMgroups() {
		return mgroups;
	}

	public void setMgroups(Mgroups mgroups) {
		this.mgroups = mgroups;
	}

	public String getMg() {
		return mg;
	}

	public void setMg(String mg) {
		this.mg = mg;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
}
