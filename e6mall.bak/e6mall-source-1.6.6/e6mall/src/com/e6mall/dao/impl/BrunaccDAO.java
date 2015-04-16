package com.e6mall.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.e6mall.dao.IBrunaccDAO;
import com.e6mall.model.Brunacc;

/**
 * A data access object (DAO) providing persistence and search support for
 * Brunacc entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.e6mall.model.Brunacc
 * @author bingzhou6@gmail.com
 */

public class BrunaccDAO extends BaseDAO implements IBrunaccDAO {
	private static final Logger log = LoggerFactory.getLogger(BrunaccDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Brunacc transientInstance) {
		log.debug("saving Brunacc instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Brunacc persistentInstance) {
		log.debug("deleting Brunacc instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Brunacc findById(java.lang.String id) {
		log.debug("getting Brunacc instance with id: " + id);
		try {
			Brunacc instance = (Brunacc) getHibernateTemplate().get(
					"com.e6mall.model.Brunacc", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Brunacc instance) {
		log.debug("finding Brunacc instance by example");
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
		log.debug("finding Brunacc instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Brunacc as model where model."
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
		log.debug("finding all Brunacc instances");
		try {
			String queryString = "from Brunacc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Brunacc merge(Brunacc detachedInstance) {
		log.debug("merging Brunacc instance");
		try {
			Brunacc result = (Brunacc) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Brunacc instance) {
		log.debug("attaching dirty Brunacc instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Brunacc instance) {
		log.debug("attaching clean Brunacc instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IBrunaccDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IBrunaccDAO) ctx.getBean("BrunaccDAO");
	}
}