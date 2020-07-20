package com.github.sulne.xmsd.pojo;

import java.util.List;

public class Limit {
	protected int total;
	protected List<?> rows;
	protected int limit;
	protected int offset;
	protected String search;
	protected String sort;
	protected String order;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[limit = %d, offset = %d, search = %s, sort = %s, order = %s]",limit,offset,search,sort,order);
	}
	
	public int getStart() {
		return 0;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
}
