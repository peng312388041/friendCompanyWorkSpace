package com.bbs.service;

import com.bbs.utils.PaginationSupport;

public interface BaseArticleService extends IBaseService {
	public abstract PaginationSupport getArticlePageByIndex(int pageIndex);
	public abstract void save(int pageIndex);
}
