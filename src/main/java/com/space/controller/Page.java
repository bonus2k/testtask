package com.space.controller;

public class Page {
    private ShipOrder order;
    private Integer pageNumber;
    private Integer pageSize;

    public Page() {
        this.order=ShipOrder.ID;
        this.pageNumber=0;
        this.pageSize=3;
    }

    public ShipOrder getOrder() {
        return order;
    }


    public Integer getPageNumber() {
        return pageNumber;
    }


    public Integer getPageSize() {
        return pageSize;
    }

    public void setOrder(ShipOrder order) {
        this.order = order;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Page{" +
                "order=" + order +
                ", pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                '}';
    }
}
