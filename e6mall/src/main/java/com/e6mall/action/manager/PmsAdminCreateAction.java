package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.model.Groups;
import com.e6mall.model.Manager;
import com.e6mall.model.Member;
import com.e6mall.model.Mgroups;
import com.e6mall.model.Permission;

public class PmsAdminCreateAction extends BaseAction {
	private static final long serialVersionUID = 8717094043387251158L;
	private String gs;//会员组
	private Groups groups;
	private String mb;//会员
	private Member member;
	private String ms;//管理员组
	private Mgroups mgroups;
	private String mg;//管理员
	private Manager manager;
	private Permission permission = new Permission();
	private List permissionroot;

	public String execute() throws Exception {
		permissionroot = spermission.findAllRoot();
		if (null != gs && !gs.equals("")) {
			groups = sgroups.findById(gs);
		}
		if (null != mb && !mb.equals("")) {
			member = smember.findById(mb);
		}
		if (null != ms && !ms.equals("")) {
			mgroups = smgroups.findById(ms);
		}
		if (null != mg && !mg.equals("")) {
			manager = smanager.findById(mg);
		}
		return SUCCESS;
	}
	
	public String create() throws Exception {
		permission.setId(getUuid());
		if (null != gs && !gs.equals("")) {
			groups = sgroups.findById(gs);
			permission.setGroups(groups);
		} else if (null != mb && !mb.equals("")) {
			member = smember.findById(mb);
			permission.setMember(member);
		} else if (null != ms && !ms.equals("")) {
			mgroups = smgroups.findById(ms);
			permission.setMgroups(mgroups);
		} else if (null != mg && !mg.equals("")) {
			manager = smanager.findById(mg);
			permission.setManager(manager);
		}
		if (null != permission.getPermission() && !permission.getPermission().getId().equals("")) {
		} else {
			permission.setPermission(null);
		}
		spermission.save(permission);
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

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public List getPermissionroot() {
		return permissionroot;
	}

	public void setPermissionroot(List permissionroot) {
		this.permissionroot = permissionroot;
	}
}
