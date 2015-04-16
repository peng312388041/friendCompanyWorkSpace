package com.e6mall.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.utils.PaginationSupport;

public interface IBaseDAO {

	public abstract PaginationSupport findPageByCriteria(
			final DetachedCriteria detachedCriteria);

	public abstract PaginationSupport findPageByCriteria(
			final DetachedCriteria detachedCriteria, int page);

	public abstract PaginationSupport findPageByCriteria(
			final DetachedCriteria detachedCriteria, final int pageSize,
			int page);

	public PaginationSupport findPageByIndex(
			final DetachedCriteria detachedCriteria, final int pageSize,
			final int startIndex);
	
	public abstract List findAllByCriteria(
			final DetachedCriteria detachedCriteria);

	public abstract int getCountByCriteria(
			final DetachedCriteria detachedCriteria);

}