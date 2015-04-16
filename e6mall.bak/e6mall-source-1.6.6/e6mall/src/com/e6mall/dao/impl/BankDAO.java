package com.e6mall.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.e6mall.dao.IBankDAO;
import com.e6mall.model.Bank;

/**
 * A data access object (DAO) providing persistence and search support for Bank
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.e6mall.model.Bank
 * @author bingzhou6@gmail.com
 */

public class BankDAO extends BaseDAO implements IBankDAO {
	private static final Logger log = LoggerFactory.getLogger(BankDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Bank transientInstance) {
		log.debug("saving Bank instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Bank persistentInstance) {
		log.debug("deleting Bank instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Bank findById(java.lang.String id) {
		log.debug("getting Bank instance with id: " + id);
		try {
			Bank instance = (Bank) getHibernateTemplate().get(
					"com.e6mall.model.Bank", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Bank instance) {
		log.debug("finding Bank instance by example");
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
		log.debug("finding Bank instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Bank as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAccount(Object account) {
		return findByProperty(ACCOUNT, account);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByBalance(Object balance) {
		return findByProperty(BALANCE, balance);
	}

	public List findByRemarks(Object remarks) {
		return findByProperty(REMARKS, remarks);
	}

	public List findAll() {
		log.debug("finding all Bank instances");
		try {
			String queryString = "from Bank";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Bank merge(Bank detachedInstance) {
		log.debug("merging Bank instance");
		try {
			Bank result = (Bank) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Bank instance) {
		log.debug("attaching dirty Bank instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Bank instance) {
		log.debug("attaching clean Bank instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IBankDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IBankDAO) ctx.getBean("BankDAO");
	}
}