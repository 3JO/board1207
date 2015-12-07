package org.sean.domain;

public class Criteria {

	private int page;
	private String type;
	private String keyword;
	private String SearchType;
	private int perPage;
	
	
	
	public Criteria() {
		this.page=1;
		this.perPage = 10;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		
		this.page = page;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getSearchType() {
		return SearchType;
	}

	public void setSearchType(String searchType) {
		SearchType = searchType;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		
		if (perPage <= 0 || perPage > 100) {
			this.perPage = 10;
			return;
		}
		
		this.perPage = perPage;
	}
	public int getPageStart(){
		
		return (this.page - 1) * perPage;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", type=" + type + ", keyword=" + keyword + ", SearchType=" + SearchType
				+ ", perPage=" + perPage + "]";
	}

}
