package com.nsdl.entity;

public class Search {

	private String searchText;

	public Search(String searchText) {
		super();
		this.searchText = searchText;
	}

	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	@Override
	public String toString() {
		return "Search [searchText=" + searchText + "]";
	}

}
