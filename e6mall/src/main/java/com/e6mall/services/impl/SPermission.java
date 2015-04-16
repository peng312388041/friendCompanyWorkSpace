package com.e6mall.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.e6mall.dao.IPermissionDAO;
import com.e6mall.model.Permission;
import com.e6mall.services.ISPermission;
import com.e6mall.utils.PaginationSupport;

public class SPermission extends BaseServices implements ISPermission {
	private IPermissionDAO permissiondao;

	public IPermissionDAO getPermissiondao() {
		return permissiondao;
	}

	public void setPermissiondao(IPermissionDAO permissiondao) {
		this.permissiondao = permissiondao;
	}

	public void attachClean(Permission instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Permission instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Permission persistentInstance) {
		permissiondao.delete(persistentInstance);
	}

	public List findAll() {
		List list = permissiondao.findAll();
		return list;
	}
	
	public List findAllRoot() {
		DetachedCriteria dc = DetachedCriteria.forClass(Permission.class);
		dc.add(Property.forName("member").isNull());
		dc.add(Property.forName("manager").isNull());
		dc.add(Property.forName("mgroups").isNull());
		dc.add(Property.forName("groups").isNull());
		dc.add(Property.forName("permission").isNull());
		List temp = permissiondao.findAllByCriteria(dc);
		
		List list = new ArrayList();
		for (int k=0; k<temp.size(); k++) {
			Permission root = (Permission)temp.get(k);
			Set set = new HashSet();
			Iterator it = root.getPermissions().iterator();
			while (it.hasNext()) {
				Permission p = (Permission)it.next();
				if (p.getManager()==null && p.getMember()==null && p.getMgroups()==null && p.getGroups()==null) {
					set.add(p);
				}
			}
			root.setPermissions(set);
			list.add(root);
		}
		return list;
	}

	public Permission findById(String id) {
		Permission permission = permissiondao.findById(id);
		return permission;
	}

	public List findByCode(Object code) {
		List list = permissiondao.findByCode(code);
		return list;
	}

	public Permission merge(Permission detachedInstance) {
		Permission msetting = permissiondao.merge(detachedInstance);
		return msetting;
	}

	public void save(Permission transientInstance) {
		permissiondao.save(transientInstance);
	}

	public List findAllByCriteria(DetachedCriteria detachedCriteria) {
		List list = permissiondao.findAllByCriteria(detachedCriteria);
		return list;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		PaginationSupport ps = permissiondao.findPageByCriteria(detachedCriteria);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int startIndex) {
		PaginationSupport ps = permissiondao.findPageByCriteria(detachedCriteria, startIndex);
		return ps;
	}

	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex) {
		PaginationSupport ps = permissiondao.findPageByCriteria(detachedCriteria, pageSize, startIndex);
		return ps;
	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		int count = permissiondao.getCountByCriteria(detachedCriteria);
		return count;
	}
}
