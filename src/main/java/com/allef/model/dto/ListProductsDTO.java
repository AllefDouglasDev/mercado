package com.allef.model.dto;

public class ListProductsDTO extends PaginationFilters {
    private String search;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
