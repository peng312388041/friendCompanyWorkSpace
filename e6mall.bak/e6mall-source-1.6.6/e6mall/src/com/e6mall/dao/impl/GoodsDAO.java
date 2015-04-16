package com.e6mall.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.e6mall.dao.IGoodsDAO;
import com.e6mall.model.Goods;

/**
 * A data access object (DAO) providing persistence and search support for Goods
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.e6mall.model.Goods
 * @author bingzhou6@gmail.com
 */

public class GoodsDAO extends BaseDAO implements IGoodsDAO {
	private static final Logger log = LoggerFactory.getLogger(GoodsDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Goods transientInstance) {
		log.debug("saving Goods instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Goods persistentInstance) {
		log.debug("deleting Goods instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Goods findById(java.lang.String id) {
		log.debug("getting Goods instance with id: " + id);
		try {
			Goods instance = (Goods) getHibernateTemplate().get(
					"com.e6mall.model.Goods", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Goods instance) {
		log.debug("finding Goods instance by example");
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
		log.debug("finding Goods instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Goods as model where model."
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

	public List findBySn(Object sn) {
		return findByProperty(SN, sn);
	}

	public List findByBarcode(Object barcode) {
		return findByProperty(BARCODE, barcode);
	}

	public List findByKeywords(Object keywords) {
		return findByProperty(KEYWORDS, keywords);
	}

	public List findByIntro(Object intro) {
		return findByProperty(INTRO, intro);
	}

	public List findByDetails(Object details) {
		return findByProperty(DETAILS, details);
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findByMprice(Object mprice) {
		return findByProperty(MPRICE, mprice);
	}

	public List findByCprice(Object cprice) {
		return findByProperty(CPRICE, cprice);
	}

	public List findByPoints(Object points) {
		return findByProperty(POINTS, points);
	}

	public List findByInventory(Object inventory) {
		return findByProperty(INVENTORY, inventory);
	}

	public List findByPromote(Object promote) {
		return findByProperty(PROMOTE, promote);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
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
		log.debug("finding all Goods instances");
		try {
			String queryString = "from Goods";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Goods merge(Goods detachedInstance) {
		log.debug("merging Goods instance");
		try {
			Goods result = (Goods) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Goods instance) {
		log.debug("attaching dirty Goods instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Goods instance) {
		log.debug("attaching clean Goods instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IGoodsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IGoodsDAO) ctx.getBean("GoodsDAO");
	}
}