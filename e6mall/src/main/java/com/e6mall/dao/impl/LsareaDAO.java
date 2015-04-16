package com.e6mall.dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.e6mall.dao.ILsareaDAO;
import com.e6mall.model.Lsarea;

/**
 * A data access object (DAO) providing persistence and search support for
 * Lsarea entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.e6mall.model.Lsarea
 * @author MyEclipse Persistence Tools
 */

public class LsareaDAO extends BaseDAO implements ILsareaDAO {
	private static final Logger log = LoggerFactory.getLogger(LsareaDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Lsarea transientInstance) {
		log.debug("saving Lsarea instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Lsarea persistentInstance) {
		log.debug("deleting Lsarea instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Lsarea findById(java.lang.String id) {
		log.debug("getting Lsarea instance with id: " + id);
		try {
			Lsarea instance = (Lsarea) getHibernateTemplate().get(
					"com.e6mall.model.Lsarea", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Lsarea instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Lsarea as model where model."
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

	public List findByWfirst(Object wfirst) {
		return findByProperty(WFIRST, wfirst);
	}

	public List findByWfcost(Object wfcost) {
		return findByProperty(WFCOST, wfcost);
	}

	public List findByWappend(Object wappend) {
		return findByProperty(WAPPEND, wappend);
	}

	public List findByWacost(Object wacost) {
		return findByProperty(WACOST, wacost);
	}

	public List findByCod(Object cod) {
		return findByProperty(COD, cod);
	}

	public List findByPremiumrate(Object premiumrate) {
		return findByProperty(PREMIUMRATE, premiumrate);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all Lsarea instances");
		try {
			String queryString = "from Lsarea";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Lsarea merge(Lsarea detachedInstance) {
		log.debug("merging Lsarea instance");
		try {
			Lsarea result = (Lsarea) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Lsarea instance) {
		log.debug("attaching dirty Lsarea instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Lsarea instance) {
		log.debug("attaching clean Lsarea instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ILsareaDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ILsareaDAO) ctx.getBean("LsareaDAO");
	}
}