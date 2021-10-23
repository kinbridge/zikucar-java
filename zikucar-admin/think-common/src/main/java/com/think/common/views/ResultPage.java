package com.think.common.views;

/**
 * @author Administrator
 */
public class ResultPage<T> extends Result<T> {
    private int page;
    private int total;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

