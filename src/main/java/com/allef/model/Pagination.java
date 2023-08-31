package com.allef.model;

import java.util.List;

public class Pagination<T> {
    private int page;
    private int size;
    private int total;
    private List<T> data;

    public Pagination(int page, int size, int total, List<T> data) {
        this.page = page;
        this.size = size;
        this.total = total;
        this.data = data; 
    }

	public int getPage() {
		return page;
	}

	public int getSize() {
		return size;
	}

	public int getTotal() {
		return total;
	}

	public List<T> getData() {
		return data;
	}

    public String toString() {
        return "Pagination [page=" + page + ", size=" + size + ", total=" + total + ", data=" + data + "]";
    }
}
