package com.think.common.views;

/**
 * @author Administrator
 */
public class ResultPage<T> extends Result<T> {
    private int page;
    private int size;
    private long total;


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}

