package com.e6mall.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.e6mall.dao.IPrunaccDAO;
import com.e6mall.model.Prunacc;

/**
 * A data access object (DAO) providing persistence and search support for
 * Prunacc entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.e6mall.model.Prunacc
 * @author bingzhou6@gmail.com
 */

public class PrunaccDAO extends BaseDAO implements IPrunaccDAO {
	private static final Logger log = LoggerFactory.getLogger(PrunaccDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Prunacc transientInstance) {
		log.debug("saving Prunacc instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Prunacc persistentInstance) {
		log.debug("deleting Prunacc instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Prunacc findById(java.lang.String id) {
		log.debug("getting Prunacc instance with id: " + id);
		try {
			Prunacc instance = (Prunacc) getHibernateTemplate().get(
					"com.e6mall.model.Prunacc", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Prunacc instance) {
		log.debug("finding Prunacc instance by example");
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
		log.debug("finding Prunacc instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Prunacc as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByBalance(Object balance) {
		return findByProperty(BALANCE, balance);
	}

	public List findByGetout(Object getout) {
		return findByProperty(GETOUT, getout);
	}

	public List findByPayin(Object payin) {
		return findByProperty(PAYIN, payin);
	}

	public List findByTabloid(Object tabloid) {
		return findByProperty(TABLOID, tabloid);
	}

	public List findByRemarks(Object remarks) {
		return findByProperty(REMARKS, remarks);
	}

	public List findAll() {
		log.debug("finding all Prunacc instances");
		try {
			String queryString = "from Prunacc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Prunacc merge(Prunacc detachedInstance) {
		log.debug("merging Prunacc instance");
		try {
			Prunacc result = (Prunacc) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Prunacc instance) {
		log.debug("attaching dirty Prunacc instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Prunacc instance) {
		log.debug("attaching clean Prunacc instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IPrunaccDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IPrunaccDAO) ctx.getBean("PrunaccDAO");
	}
}