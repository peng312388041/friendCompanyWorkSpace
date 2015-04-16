package com.e6mall.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.e6mall.dao.IBrandDAO;
import com.e6mall.model.Brand;

/**
 * A data access object (DAO) providing persistence and search support for Brand
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.e6mall.model.Brand
 * @author bingzhou6@gmail.com
 */

public class BrandDAO extends BaseDAO implements IBrandDAO {
	private static final Logger log = LoggerFactory.getLogger(BrandDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Brand transientInstance) {
		log.debug("saving Brand instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Brand persistentInstance) {
		log.debug("deleting Brand instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Brand findById(java.lang.String id) {
		log.debug("getting Brand instance with id: " + id);
		try {
			Brand instance = (Brand) getHibernateTemplate().get(
					"com.e6mall.model.Brand", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Brand instance) {
		log.debug("finding Brand instance by example");
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
		log.debug("finding Brand instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Brand as model where model."
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

	public List findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List findByCsort(Object csort) {
		return findByProperty(CSORT, csort);
	}

	public List findAll() {
		log.debug("finding all Brand instances");
		try {
			String queryString = "from Brand";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Brand merge(Brand detachedInstance) {
		log.debug("merging Brand instance");
		try {
			Brand result = (Brand) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Brand instance) {
		log.debug("attaching dirty Brand instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Brand instance) {
		log.debug("attaching clean Brand instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IBrandDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IBrandDAO) ctx.getBean("BrandDAO");
	}
}