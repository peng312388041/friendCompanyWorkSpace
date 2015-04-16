package com.e6mall.utils;

import java.util.List;

public class PaginationSupport {
	public final static int PAGESIZE = 30;

	private int pageSize = PAGESIZE;

	private List items;

	private int totalCount;

	private int[] indexes = new int[0];

	private int startIndex = 0;
	
	private int pageCount;
	private int currentPage = 0;
	private int pageNumber;
	private int[] pages = new int[0];

	public PaginationSupport(List items, int totalCount) {
		setPageSize(PAGESIZE);
		setTotalCount(totalCount);
		setItems(items);
		setStartIndex(0);
		//setPageNumber(1);
	}

	public PaginationSupport(List items, int totalCount, int startIndex) {
		setPageSize(PAGESIZE);
		setTotalCount(totalCount);
		setItems(items);
		setStartIndex(startIndex);
		//setPageNumber(pageNumber);
	}

	public PaginationSupport(List items, int totalCount, int pageSize, int startIndex) {
		setPageSize(pageSize);
		setTotalCount(totalCount);
		setItems(items);
		setStartIndex(startIndex);
		//setPageNumber(pageNumber);
	}

	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		this.items = items;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		if (totalCount > 0) {
			this.totalCount = totalCount;
			int count = totalCount / pageSize;
			if (totalCount % pageSize > 0)
				count++;
			indexes = new int[count];
			for (int i = 0; i < count; i++) {
				indexes[i] = pageSize * i;
			}
		} else {
			this.totalCount = 0;
		}
	}

	public int[] getIndexes() {
		return indexes;
	}

	public void setIndexes(int[] indexes) {
		this.indexes = indexes;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.pageNumber = (startIndex/pageSize)+1;
		if (totalCount <= 0)
			this.startIndex = 0;
		else if (startIndex >= totalCount)
			this.startIndex = indexes[indexes.length - 1];
		else if (startIndex < 0)
			this.startIndex = 0;
		else {
			this.startIndex = indexes[startIndex / pageSize];
			this.currentPage = startIndex / pageSize + 1;
		}
	}

	public int getNextIndex() {
		int nextIndex = getStartIndex() + pageSize;
		if (nextIndex >= totalCount)
			return getStartIndex();
		else
			return nextIndex;
	}

	public int getPreviousIndex() {
		int previousIndex = getStartIndex() - pageSize;
		if (previousIndex < 0)
			return 0;
		else
			return previousIndex;
	}
	
	public int getPageCount() {
		return indexes.length;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {//暂时无用处
		this.pageNumber = pageNumber;
	}
	
	public int getNextPage() {
		int nextPage = pageNumber+1;
		if (nextPage > getPageCount())
			nextPage = getPageCount();
		return nextPage;
	}
	
	public int getPreviousPage() {
		int prePage = pageNumber-1;
		if (prePage < 1)
			prePage = 1;
		return prePage;
	}
	
	public int getNextTenPage() {
		int nextPage = pageNumber+10;
		if (nextPage > getPageCount())
			nextPage = getPageCount();
		return nextPage;
	}
	
	public int getPreviousTenPage() {
		int prePage = pageNumber-10;
		if (prePage < 1)
			prePage = 1;
		return prePage;
	}

	public int[] getPages() {//显示五个页码
		int first = 1;
		int end = pageNumber+2;
		if (pageNumber-2 > 0) {
			first = pageNumber-2;
		}
		if (end > getPageCount()) {
			end = getPageCount();
		}
		if ((end-first) < 4 && (first+4) <= getPageCount()) {//后不足五个页码的补齐
			end = first + 4;
		}
		if ((end-first) < 4 && (end-4) >= 1) {//前不足五个页码的补齐
			first = end - 4;
		}
		
		int fornum = end-first+1;
		pages = new int[fornum];//容器
		for (int i=0; i<fornum; i++) {
			pages[i] = first;//存入页码
			first++;
		}
		
		return pages;
	}
}
