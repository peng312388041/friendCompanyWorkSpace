package com.e6mall.dao;

import java.util.List;

import com.e6mall.model.Channel;

public interface IChannelDAO extends IBaseDAO {

	// property constants
	public static final String TITLE = "title";
	public static final String INTRO = "intro";

	public abstract void save(Channel transientInstance);

	public abstract void delete(Channel persistentInstance);

	public abstract Channel findById(java.lang.String id);

	public abstract List findByExample(Channel instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByTitle(Object title);

	public abstract List findByIntro(Object intro);

	public abstract List findAll();

	public abstract Channel merge(Channel detachedInstance);

	public abstract void attachDirty(Channel instance);

	public abstract void attachClean(Channel instance);

}