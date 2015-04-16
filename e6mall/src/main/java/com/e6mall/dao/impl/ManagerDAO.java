package com.e6mall.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.e6mall.dao.IManagerDAO;
import com.e6mall.model.Manager;

/**
 * A data access object (DAO) providing persistence and search support for
 * Manager entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.e6mall.model.Manager
 * @author bingzhou6@gmail.com
 */

public class ManagerDAO extends BaseDAO implements IManagerDAO {
	private static final Logger log = LoggerFactory.getLogger(ManagerDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Manager transientInstance) {
		log.debug("saving Manager instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Manager persistentInstance) {
		log.debug("deleting Manager instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Manager findById(java.lang.String id) {
		log.debug("getting Manager instance with id: " + id);
		try {
			Manager instance = (Manager) getHibernateTemplate().get(
					"com.e6mall.model.Manager", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Manager instance) {
		log.debug("finding Manager instance by example");
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
		log.debug("finding Manager instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Manager as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public Manager findByAccount(Object account) {
		List list = findByProperty(ACCOUNT, account);
		if(0 == list.size()){
			return null;
		}
		return (Manager)list.get(0);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByCtype(Object ctype) {
		return findByProperty(CTYPE, ctype);
	}

	public List findByNickname(Object nickname) {
		return findByProperty(NICKNAME, nickname);
	}

	public List findByIdcard(Object idcard) {
		return findByProperty(IDCARD, idcard);
	}

	public List findByLogincount(Object logincount) {
		return findByProperty(LOGINCOUNT, logincount);
	}

	public List findAll() {
		log.debug("finding all Manager instances");
		try {
			String queryString = "from Manager";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Manager merge(Manager detachedInstance) {
		log.debug("merging Manager instance");
		try {
			Manager result = (Manager) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Manager instance) {
		log.debug("attaching dirty Manager instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Manager instance) {
		log.debug("attaching clean Manager instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IManagerDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IManagerDAO) ctx.getBean("ManagerDAO");
	}
}