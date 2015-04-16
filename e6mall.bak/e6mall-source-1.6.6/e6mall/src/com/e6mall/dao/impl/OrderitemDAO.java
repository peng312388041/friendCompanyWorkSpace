package com.e6mall.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.e6mall.dao.IOrderitemDAO;
import com.e6mall.model.Orderitem;

/**
 * A data access object (DAO) providing persistence and search support for
 * Orderitem entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.e6mall.model.Orderitem
 * @author bingzhou6@gmail.com
 */

public class OrderitemDAO extends BaseDAO implements IOrderitemDAO {
	private static final Logger log = LoggerFactory
			.getLogger(OrderitemDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Orderitem transientInstance) {
		log.debug("saving Orderitem instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Orderitem persistentInstance) {
		log.debug("deleting Orderitem instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Orderitem findById(java.lang.String id) {
		log.debug("getting Orderitem instance with id: " + id);
		try {
			Orderitem instance = (Orderitem) getHibernateTemplate().get(
					"com.e6mall.model.Orderitem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Orderitem instance) {
		log.debug("finding Orderitem instance by example");
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
		log.debug("finding Orderitem instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Orderitem as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySpecremark(Object specremark) {
		return findByProperty(SPECREMARK, specremark);
	}

	public List findByUnitprice(Object unitprice) {
		return findByProperty(UNITPRICE, unitprice);
	}

	public List findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List findByLumpsum(Object lumpsum) {
		return findByProperty(LUMPSUM, lumpsum);
	}

	public List findByActsum(Object actsum) {
		return findByProperty(ACTSUM, actsum);
	}

	public List findByDiscount(Object discount) {
		return findByProperty(DISCOUNT, discount);
	}

	public List findByIspay(Object ispay) {
		return findByProperty(ISPAY, ispay);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all Orderitem instances");
		try {
			String queryString = "from Orderitem";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Orderitem merge(Orderitem detachedInstance) {
		log.debug("merging Orderitem instance");
		try {
			Orderitem result = (Orderitem) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Orderitem instance) {
		log.debug("attaching dirty Orderitem instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Orderitem instance) {
		log.debug("attaching clean Orderitem instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IOrderitemDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IOrderitemDAO) ctx.getBean("OrderitemDAO");
	}
}