package com.e6mall.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.e6mall.dao.ISettingDAO;
import com.e6mall.model.Setting;

/**
 * A data access object (DAO) providing persistence and search support for
 * Setting entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.e6mall.model.Setting
 * @author bingzhou6@gmail.com
 */

public class SettingDAO extends BaseDAO implements ISettingDAO {
	private static final Logger log = LoggerFactory.getLogger(SettingDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Setting transientInstance) {
		log.debug("saving Setting instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Setting persistentInstance) {
		log.debug("deleting Setting instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Setting findById(java.lang.String id) {
		log.debug("getting Setting instance with id: " + id);
		try {
			Setting instance = (Setting) getHibernateTemplate().get(
					"com.e6mall.model.Setting", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Setting instance) {
		log.debug("finding Setting instance by example");
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
		log.debug("finding Setting instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Setting as model where model."
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

	public List findByProperty(Object property) {
		return findByProperty(PROPERTY, property);
	}

	public List findByValue(Object value) {
		return findByProperty(VALUE, value);
	}

	public List findByPerss(Object perss) {
		return findByProperty(PERSS, perss);
	}

	public List findAll() {
		log.debug("finding all Setting instances");
		try {
			String queryString = "from Setting";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Setting merge(Setting detachedInstance) {
		log.debug("merging Setting instance");
		try {
			Setting result = (Setting) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Setting instance) {
		log.debug("attaching dirty Setting instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Setting instance) {
		log.debug("attaching clean Setting instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ISettingDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ISettingDAO) ctx.getBean("SettingDAO");
	}
}