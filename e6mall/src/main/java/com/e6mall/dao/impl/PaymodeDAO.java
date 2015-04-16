package com.e6mall.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.e6mall.dao.IPaymodeDAO;
import com.e6mall.model.Paymode;

/**
 * A data access object (DAO) providing persistence and search support for
 * Paymode entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.e6mall.model.Paymode
 * @author bingzhou6@gmail.com
 */

public class PaymodeDAO extends BaseDAO implements IPaymodeDAO {
	private static final Logger log = LoggerFactory.getLogger(PaymodeDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Paymode transientInstance) {
		log.debug("saving Paymode instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Paymode persistentInstance) {
		log.debug("deleting Paymode instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Paymode findById(java.lang.String id) {
		log.debug("getting Paymode instance with id: " + id);
		try {
			Paymode instance = (Paymode) getHibernateTemplate().get(
					"com.e6mall.model.Paymode", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Paymode instance) {
		log.debug("finding Paymode instance by example");
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
		log.debug("finding Paymode instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Paymode as model where model."
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

	public List findByIntro(Object intro) {
		return findByProperty(INTRO, intro);
	}

	public List findByRate(Object rate) {
		return findByProperty(RATE, rate);
	}

	public List findByCsort(Object csort) {
		return findByProperty(CSORT, csort);
	}

	public List findAll() {
		log.debug("finding all Paymode instances");
		try {
			String queryString = "from Paymode";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Paymode merge(Paymode detachedInstance) {
		log.debug("merging Paymode instance");
		try {
			Paymode result = (Paymode) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Paymode instance) {
		log.debug("attaching dirty Paymode instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Paymode instance) {
		log.debug("attaching clean Paymode instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IPaymodeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IPaymodeDAO) ctx.getBean("PaymodeDAO");
	}
}