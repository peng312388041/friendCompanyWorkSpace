package com.e6mall.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.e6mall.dao.ISpecvalueDAO;
import com.e6mall.model.Specvalue;

/**
 * A data access object (DAO) providing persistence and search support for
 * Specvalue entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.e6mall.model.Specvalue
 * @author bingzhou6@gmail.com
 */

public class SpecvalueDAO extends BaseDAO implements ISpecvalueDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SpecvalueDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Specvalue transientInstance) {
		log.debug("saving Specvalue instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Specvalue persistentInstance) {
		log.debug("deleting Specvalue instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Specvalue findById(java.lang.String id) {
		log.debug("getting Specvalue instance with id: " + id);
		try {
			Specvalue instance = (Specvalue) getHibernateTemplate().get(
					"com.e6mall.model.Specvalue", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Specvalue instance) {
		log.debug("finding Specvalue instance by example");
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
		log.debug("finding Specvalue instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Specvalue as model where model."
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

	public List findAll() {
		log.debug("finding all Specvalue instances");
		try {
			String queryString = "from Specvalue";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Specvalue merge(Specvalue detachedInstance) {
		log.debug("merging Specvalue instance");
		try {
			Specvalue result = (Specvalue) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Specvalue instance) {
		log.debug("attaching dirty Specvalue instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Specvalue instance) {
		log.debug("attaching clean Specvalue instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ISpecvalueDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ISpecvalueDAO) ctx.getBean("SpecvalueDAO");
	}
}