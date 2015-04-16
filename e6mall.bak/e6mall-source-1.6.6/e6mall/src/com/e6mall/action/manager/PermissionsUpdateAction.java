package com.e6mall.action.manager;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Manager;
import com.e6mall.model.Permission;

public class PermissionsUpdateAction extends BaseAction {
	private static final long serialVersionUID = 3331154383139135062L;
	private String mg;
	private List<Permission> permission;

	public String execute() throws Exception {
		Manager manager = smanager.findById(mg);
		for (int i=0; i<permission.size(); i++) {
			Permission perm = (Permission)permission.get(i);
			String id = existId(manager, perm.getCode());
			if (!id.equals("")) {
				perm.setId(id);
			} else {
				perm.setId(getUuid());
			}
			perm.setManager(manager);
			spermission.merge(perm);
		}
		return SUCCESS;
	}
	
	private String existId(Manager manager, String code) throws Exception {
		String id = "";
		DetachedCriteria dc = DetachedCriteria.forClass(Permission.class);
		dc.add(Property.forName("code").eq(code));
		dc.add(Property.forName("manager").eq(manager));
		List list = spermission.findAllByCriteria(dc);
		if (list.size() > 0) {
			Permission perm = (Permission)list.get(0);
			id = perm.getId();
		}
		return id;
	}

	public String getMg() {
		return mg;
	}

	public void setMg(String mg) {
		this.mg = mg;
	}

	public List<Permission> getPermission() {
		return permission;
	}

	public void setPermission(List<Permission> permission) {
		this.permission = permission;
	}
}
