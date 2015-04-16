package com.e6mall.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.e6mall.dao.IGroupsDAO;
import com.e6mall.model.Groups;

/**
 * A data access object (DAO) providing persistence and search support for
 * Groups entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.e6mall.model.Groups
 * @author bingzhou6@gmail.com
 */

public class GroupsDAO extends BaseDAO implements IGroupsDAO {
	private static final Logger log = LoggerFactory.getLogger(GroupsDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Groups transientInstance) {
		log.debug("saving Groups instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Groups persistentInstance) {
		log.debug("deleting Groups instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Groups findById(java.lang.String id) {
		log.debug("getting Groups instance with id: " + id);
		try {
			Groups instance = (Groups) getHibernateTemplate().get(
					"com.e6mall.model.Groups", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Groups instance) {
		log.debug("finding Groups instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Groups instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Groups as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByRemarks(Object remarks) {
		return findByProperty(REMARKS, remarks);
	}

	public List findAll() {
		log.debug("finding all Groups instances");
		try {
			String queryString = "from Groups";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Groups merge(Groups detachedInstance) {
		log.debug("merging Groups instance");
		try {
			Groups result = (Groups) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Groups instance) {
		log.debug("attaching dirty Groups instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Groups instance) {
		log.debug("attaching clean Groups instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IGroupsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IGroupsDAO) ctx.getBean("GroupsDAO");
	}
}