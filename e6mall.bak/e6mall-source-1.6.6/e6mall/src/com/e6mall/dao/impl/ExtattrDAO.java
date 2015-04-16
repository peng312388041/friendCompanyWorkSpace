package com.e6mall.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.e6mall.dao.IExtattrDAO;
import com.e6mall.model.Extattr;

/**
 * A data access object (DAO) providing persistence and search support for
 * Extattr entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.e6mall.model.Extattr
 * @author bingzhou6@gmail.com
 */

public class ExtattrDAO extends BaseDAO implements IExtattrDAO {
	private static final Logger log = LoggerFactory.getLogger(ExtattrDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Extattr transientInstance) {
		log.debug("saving Extattr instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Extattr persistentInstance) {
		log.debug("deleting Extattr instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Extattr findById(java.lang.String id) {
		log.debug("getting Extattr instance with id: " + id);
		try {
			Extattr instance = (Extattr) getHibernateTemplate().get(
					"com.e6mall.model.Extattr", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Extattr instance) {
		log.debug("finding Extattr instance by example");
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
		log.debug("finding Extattr instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Extattr as model where model."
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

	public List findByViewtype(Object viewtype) {
		return findByProperty(VIEWTYPE, viewtype);
	}

	public List findByDisplay(Object display) {
		return findByProperty(DISPLAY, display);
	}

	public List findByCsort(Object csort) {
		return findByProperty(CSORT, csort);
	}

	public List findAll() {
		log.debug("finding all Extattr instances");
		try {
			String queryString = "from Extattr";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Extattr merge(Extattr detachedInstance) {
		log.debug("merging Extattr instance");
		try {
			Extattr result = (Extattr) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Extattr instance) {
		log.debug("attaching dirty Extattr instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Extattr instance) {
		log.debug("attaching clean Extattr instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IExtattrDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IExtattrDAO) ctx.getBean("ExtattrDAO");
	}
}