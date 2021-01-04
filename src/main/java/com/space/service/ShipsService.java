package com.space.service;

import com.space.controller.Order;
import com.space.controller.Page;
import com.space.controller.ShipOrder;
import com.space.model.Ship;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShipsService {
    List<Ship> index();

    Ship show(Long id);

    Ship update(Ship ship, Long id);

    void delete(Long id);

    List<Ship> paging(ShipOrder shipOrder, Integer pageNumber, Integer pageSize);

    Integer count(Order order);

    List<Ship> findByName(Order order, Page page);
}
