package com.e6mall.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.e6mall.dao.IDocumentDAO;
import com.e6mall.model.Document;

/**
 * A data access object (DAO) providing persistence and search support for
 * Document entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.e6mall.model.Document
 * @author bingzhou6@gmail.com
 */

public class DocumentDAO extends BaseDAO implements IDocumentDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DocumentDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Document transientInstance) {
		log.debug("saving Document instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Document persistentInstance) {
		log.debug("deleting Document instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Document findById(java.lang.String id) {
		log.debug("getting Document instance with id: " + id);
		try {
			Document instance = (Document) getHibernateTemplate().get(
					"com.e6mall.model.Document", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Document instance) {
		log.debug("finding Document instance by example");
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
		log.debug("finding Document instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Document as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByBrief(Object brief) {
		return findByProperty(BRIEF, brief);
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByMarker(Object marker) {
		return findByProperty(MARKER, marker);
	}

	public List findByVistor(Object vistor) {
		return findByProperty(VISTOR, vistor);
	}

	public List findAll() {
		log.debug("finding all Document instances");
		try {
			String queryString = "from Document";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Document merge(Document detachedInstance) {
		log.debug("merging Document instance");
		try {
			Document result = (Document) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Document instance) {
		log.debug("attaching dirty Document instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Document instance) {
		log.debug("attaching clean Document instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IDocumentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IDocumentDAO) ctx.getBean("DocumentDAO");
	}
}