package com.space.controller;

import com.space.model.ShipType;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;


public class Order {
    private String name;
    private String planet;
    private ShipType shipType;
    private Long after;
    private Long before;
    private Boolean isUsed;
    private Double minSpeed;
    private Double maxSpeed;
    private Integer minCrewSize;
    private Integer maxCrewSize;
    private Double minRating;
    private Double maxRating;
//    private ShipOrder order;
//    private Integer pageNumber;
//    private Integer pageSize;

    public Order() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    public Long getAfter() {
        return after;
    }

    public void setAfter(Long after) {
        this.after = after;
    }

    public Long getBefore() {
        return before;
    }

    public void setBefore(Long before) {
        this.before = before;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }

    public Double getMinSpeed() {
        return minSpeed;
    }

    public void setMinSpeed(Double minSpeed) {
        this.minSpeed = minSpeed;
    }

    public Double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Integer getMinCrewSize() {
        return minCrewSize;
    }

    public void setMinCrewSize(Integer minCrewSize) {
        this.minCrewSize = minCrewSize;
    }

    public Integer getMaxCrewSize() {
        return maxCrewSize;
    }

    public void setMaxCrewSize(Integer maxCrewSize) {
        this.maxCrewSize = maxCrewSize;
    }

    public Double getMinRating() {
        return minRating;
    }

    public void setMinRating(Double minRating) {
        this.minRating = minRating;
    }

    public Double getMaxRating() {
        return maxRating;
    }

    public void setMaxRating(Double maxRating) {
        this.maxRating = maxRating;
    }

//    public ShipOrder getOrder() {
//        return order;
//    }
//
//    public void setOrder(ShipOrder order) {
//        this.order = order;
//    }
//
//    public Integer getPageNumber() {
//        return pageNumber;
//    }
//
//    public void setPageNumber(Integer pageNumber) {
//        this.pageNumber = pageNumber;
//    }
//
//    public Integer getPageSize() {
//        return pageSize;
//    }
//
//    public void setPageSize(Integer pageSize) {
//        this.pageSize = pageSize;
//    }


    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", planet='" + planet + '\'' +
                ", shipType=" + shipType +
                ", after=" + after +
                ", before=" + before +
                ", isUsed=" + isUsed +
                ", minSpeed=" + minSpeed +
                ", maxSpeed=" + maxSpeed +
                ", minCrewSize=" + minCrewSize +
                ", maxCrewSize=" + maxCrewSize +
                ", minRating=" + minRating +
                ", maxRating=" + maxRating +
                '}';
    }
}
