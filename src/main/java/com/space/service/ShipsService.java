package com.space.service;

import com.space.controller.ShipOrder;
import com.space.model.Ship;

import java.util.List;

public interface ShipsService {
    List<Ship> index();
    Ship show(Long id);
    Ship update(Ship ship, Long id);
    void delete(Long id);
    List<Ship> paging(ShipOrder shipOrder, Integer pageNumber, Integer pageSize);
    Integer count();
}
