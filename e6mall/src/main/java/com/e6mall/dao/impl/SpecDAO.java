package com.e6mall.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.e6mall.dao.ISpecDAO;
import com.e6mall.model.Spec;

/**
 * A data access object (DAO) providing persistence and search support for Spec
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.e6mall.model.Spec
 * @author bingzhou6@gmail.com
 */

public class SpecDAO extends BaseDAO implements ISpecDAO {
	private static final Logger log = LoggerFactory.getLogger(SpecDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Spec transientInstance) {
		log.debug("saving Spec instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Spec persistentInstance) {
		log.debug("deleting Spec instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Spec findById(java.lang.String id) {
		log.debug("getting Spec instance with id: " + id);
		try {
			Spec instance = (Spec) getHibernateTemplate().get(
					"com.e6mall.model.Spec", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Spec instance) {
		log.debug("finding Spec instance by example");
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
		log.debug("finding Spec instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Spec as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGscode(Object gscode) {
		return findByProperty(GSCODE, gscode);
	}

	public List findByInventory(Object inventory) {
		return findByProperty(INVENTORY, inventory);
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findByCprice(Object cprice) {
		return findByProperty(CPRICE, cprice);
	}

	public List findAll() {
		log.debug("finding all Spec instances");
		try {
			String queryString = "from Spec";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Spec merge(Spec detachedInstance) {
		log.debug("merging Spec instance");
		try {
			Spec result = (Spec) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Spec instance) {
		log.debug("attaching dirty Spec instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Spec instance) {
		log.debug("attaching clean Spec instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ISpecDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ISpecDAO) ctx.getBean("SpecDAO");
	}
}