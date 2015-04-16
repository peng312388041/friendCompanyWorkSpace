package com.e6mall.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.e6mall.dao.IDoccateDAO;
import com.e6mall.model.Doccate;

/**
 * A data access object (DAO) providing persistence and search support for
 * Doccate entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.e6mall.model.Doccate
 * @author bingzhou6@gmail.com
 */

public class DoccateDAO extends BaseDAO implements IDoccateDAO {
	private static final Logger log = LoggerFactory.getLogger(DoccateDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Doccate transientInstance) {
		log.debug("saving Doccate instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Doccate persistentInstance) {
		log.debug("deleting Doccate instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Doccate findById(java.lang.String id) {
		log.debug("getting Doccate instance with id: " + id);
		try {
			Doccate instance = (Doccate) getHibernateTemplate().get(
					"com.e6mall.model.Doccate", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Doccate instance) {
		log.debug("finding Doccate instance by example");
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
		log.debug("finding Doccate instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Doccate as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNodepath(Object nodepath) {
		return findByProperty(NODEPATH, nodepath);
	}

	public List findByNodetype(Object nodetype) {
		return findByProperty(NODETYPE, nodetype);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByDetails(Object details) {
		return findByProperty(DETAILS, details);
	}

	public List findByCsort(Object csort) {
		return findByProperty(CSORT, csort);
	}

	public List findByMkeywords(Object mkeywords) {
		return findByProperty(MKEYWORDS, mkeywords);
	}

	public List findByMdescription(Object mdescription) {
		return findByProperty(MDESCRIPTION, mdescription);
	}

	public List findAll() {
		log.debug("finding all Doccate instances");
		try {
			String queryString = "from Doccate";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Doccate merge(Doccate detachedInstance) {
		log.debug("merging Doccate instance");
		try {
			Doccate result = (Doccate) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Doccate instance) {
		log.debug("attaching dirty Doccate instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Doccate instance) {
		log.debug("attaching clean Doccate instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IDoccateDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IDoccateDAO) ctx.getBean("DoccateDAO");
	}
}