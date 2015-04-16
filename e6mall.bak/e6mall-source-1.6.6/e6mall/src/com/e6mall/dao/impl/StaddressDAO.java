package com.e6mall.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.e6mall.dao.IStaddressDAO;
import com.e6mall.model.Staddress;

/**
 * A data access object (DAO) providing persistence and search support for
 * Staddress entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.e6mall.model.Staddress
 * @author bingzhou6@gmail.com
 */

public class StaddressDAO extends BaseDAO implements IStaddressDAO {
	private static final Logger log = LoggerFactory
			.getLogger(StaddressDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Staddress transientInstance) {
		log.debug("saving Staddress instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Staddress persistentInstance) {
		log.debug("deleting Staddress instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Staddress findById(java.lang.String id) {
		log.debug("getting Staddress instance with id: " + id);
		try {
			Staddress instance = (Staddress) getHibernateTemplate().get(
					"com.e6mall.model.Staddress", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Staddress instance) {
		log.debug("finding Staddress instance by example");
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
		log.debug("finding Staddress instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Staddress as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByPostcode(Object postcode) {
		return findByProperty(POSTCODE, postcode);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByTelephone(Object telephone) {
		return findByProperty(TELEPHONE, telephone);
	}

	public List findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all Staddress instances");
		try {
			String queryString = "from Staddress";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Staddress merge(Staddress detachedInstance) {
		log.debug("merging Staddress instance");
		try {
			Staddress result = (Staddress) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Staddress instance) {
		log.debug("attaching dirty Staddress instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Staddress instance) {
		log.debug("attaching clean Staddress instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IStaddressDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IStaddressDAO) ctx.getBean("StaddressDAO");
	}
}