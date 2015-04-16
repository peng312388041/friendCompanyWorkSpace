package com.e6mall.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.e6mall.dao.IAttachmentDAO;
import com.e6mall.model.Attachment;

/**
 * A data access object (DAO) providing persistence and search support for
 * Attachment entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.e6mall.model.Attachment
 * @author bingzhou6@gmail.com
 */

public class AttachmentDAO extends BaseDAO implements IAttachmentDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AttachmentDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Attachment transientInstance) {
		log.debug("saving Attachment instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Attachment persistentInstance) {
		log.debug("deleting Attachment instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Attachment findById(java.lang.String id) {
		log.debug("getting Attachment instance with id: " + id);
		try {
			Attachment instance = (Attachment) getHibernateTemplate().get(
					"com.e6mall.model.Attachment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Attachment instance) {
		log.debug("finding Attachment instance by example");
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
		log.debug("finding Attachment instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Attachment as model where model."
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

	public List findByFtype(Object ftype) {
		return findByProperty(FTYPE, ftype);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findBySort(Object sort) {
		return findByProperty(SORT, sort);
	}

	public List findByPath(Object path) {
		return findByProperty(PATH, path);
	}

	public List findByOname(Object oname) {
		return findByProperty(ONAME, oname);
	}

	public List findByDetails(Object details) {
		return findByProperty(DETAILS, details);
	}

	public List findAll() {
		log.debug("finding all Attachment instances");
		try {
			String queryString = "from Attachment";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Attachment merge(Attachment detachedInstance) {
		log.debug("merging Attachment instance");
		try {
			Attachment result = (Attachment) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Attachment instance) {
		log.debug("attaching dirty Attachment instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Attachment instance) {
		log.debug("attaching clean Attachment instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IAttachmentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IAttachmentDAO) ctx.getBean("AttachmentDAO");
	}
}