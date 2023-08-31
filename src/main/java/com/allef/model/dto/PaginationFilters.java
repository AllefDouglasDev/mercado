package com.allef.model.dto;

public class PaginationFilters {
    private int page;
    private int size;

    public PaginationFilters() {
        this.page = 1;
        this.size = 20;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        if (page < 1)
            return;
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size < 1)
            return;
        this.size = size;
    }
}
