package com.e6mall.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.e6mall.dao.IConfigDAO;
import com.e6mall.model.Config;

/**
 * A data access object (DAO) providing persistence and search support for
 * Config entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.e6mall.model.Config
 * @author bingzhou6@gmail.com
 */

public class ConfigDAO extends BaseDAO implements IConfigDAO {
	private static final Logger log = LoggerFactory.getLogger(ConfigDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Config transientInstance) {
		log.debug("saving Config instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Config persistentInstance) {
		log.debug("deleting Config instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Config findById(java.lang.String id) {
		log.debug("getting Config instance with id: " + id);
		try {
			Config instance = (Config) getHibernateTemplate().get(
					"com.e6mall.model.Config", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Config instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Config as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByProperty(Object property) {
		return findByProperty(PROPERTY, property);
	}

	public List findAll() {
		log.debug("finding all Config instances");
		try {
			String queryString = "from Config";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Config merge(Config detachedInstance) {
		log.debug("merging Config instance");
		try {
			Config result = (Config) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Config instance) {
		log.debug("attaching dirty Config instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Config instance) {
		log.debug("attaching clean Config instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IConfigDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IConfigDAO) ctx.getBean("ConfigDAO");
	}
}