package com.e6mall.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.e6mall.dao.IGstypeDAO;
import com.e6mall.model.Gstype;

/**
 * A data access object (DAO) providing persistence and search support for
 * Gstype entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.e6mall.model.Gstype
 * @author bingzhou6@gmail.com
 */

public class GstypeDAO extends BaseDAO implements IGstypeDAO {
	private static final Logger log = LoggerFactory.getLogger(GstypeDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Gstype transientInstance) {
		log.debug("saving Gstype instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Gstype persistentInstance) {
		log.debug("deleting Gstype instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Gstype findById(java.lang.String id) {
		log.debug("getting Gstype instance with id: " + id);
		try {
			Gstype instance = (Gstype) getHibernateTemplate().get(
					"com.e6mall.model.Gstype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Gstype instance) {
		log.debug("finding Gstype instance by example");
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
		log.debug("finding Gstype instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Gstype as model where model."
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

	public List findByAlias(Object alias) {
		return findByProperty(ALIAS, alias);
	}

	public List findAll() {
		log.debug("finding all Gstype instances");
		try {
			String queryString = "from Gstype";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Gstype merge(Gstype detachedInstance) {
		log.debug("merging Gstype instance");
		try {
			Gstype result = (Gstype) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Gstype instance) {
		log.debug("attaching dirty Gstype instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Gstype instance) {
		log.debug("attaching clean Gstype instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IGstypeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IGstypeDAO) ctx.getBean("GstypeDAO");
	}
}