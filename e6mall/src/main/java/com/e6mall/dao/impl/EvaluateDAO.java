package com.e6mall.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.e6mall.dao.IEvaluateDAO;
import com.e6mall.model.Evaluate;

/**
 * A data access object (DAO) providing persistence and search support for
 * Evaluate entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.e6mall.model.Evaluate
 * @author bingzhou6@gmail.com
 */

public class EvaluateDAO extends BaseDAO implements IEvaluateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(EvaluateDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Evaluate transientInstance) {
		log.debug("saving Evaluate instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Evaluate persistentInstance) {
		log.debug("deleting Evaluate instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Evaluate findById(java.lang.String id) {
		log.debug("getting Evaluate instance with id: " + id);
		try {
			Evaluate instance = (Evaluate) getHibernateTemplate().get(
					"com.e6mall.model.Evaluate", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Evaluate instance) {
		log.debug("finding Evaluate instance by example");
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
		log.debug("finding Evaluate instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Evaluate as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEtype(Object etype) {
		return findByProperty(ETYPE, etype);
	}

	public List findByPositive(Object positive) {
		return findByProperty(POSITIVE, positive);
	}

	public List findByNeutral(Object neutral) {
		return findByProperty(NEUTRAL, neutral);
	}

	public List findByNegative(Object negative) {
		return findByProperty(NEGATIVE, negative);
	}

	public List findAll() {
		log.debug("finding all Evaluate instances");
		try {
			String queryString = "from Evaluate";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Evaluate merge(Evaluate detachedInstance) {
		log.debug("merging Evaluate instance");
		try {
			Evaluate result = (Evaluate) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Evaluate instance) {
		log.debug("attaching dirty Evaluate instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Evaluate instance) {
		log.debug("attaching clean Evaluate instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IEvaluateDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IEvaluateDAO) ctx.getBean("EvaluateDAO");
	}
}