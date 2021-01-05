package com.space.service;

import com.space.controller.Order;
import com.space.controller.Page;
import com.space.model.Ship;
import com.space.repository.ShipsRepository;
import com.space.util.UtilForShips;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
@Transactional(readOnly = true)
public class ShipsServiceImpl implements ShipsService {

    private final ShipsRepository shipsRepository;

    public ShipsServiceImpl(ShipsRepository shipsRepository) {
        this.shipsRepository = shipsRepository;
    }

    @Override
    public List<Ship> index() {
        return shipsRepository.findAll();
    }

    @Override
    public Ship show(Long id) {
        return shipsRepository.findById(id).orElse(null);
    }

    @Override
    public Ship update(Ship ship, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        shipsRepository.deleteById(id);
    }

    @Override
    public Integer count(Order order) {
        Date after = (order.getAfter() == null) ? null : UtilForShips.dateRound(order.getAfter());
        Date before = (order.getBefore() == null) ? null : UtilForShips.dateRound(order.getBefore());

        return shipsRepository.countByOrder(order.getName(),
                order.getPlanet(),
                after,
                before,
                order.getMinCrewSize(),
                order.getMaxCrewSize(),
                order.getShipType(),
                order.getUsed(),
                order.getMaxSpeed(),
                order.getMinSpeed(),
                order.getMaxRating(),
                order.getMinRating()).size();
    }

    @Override
    public List<Ship> findByName(Order order, Page page) {
        Date after = (order.getAfter() == null) ? null : UtilForShips.dateRound(order.getAfter());
        Date before = (order.getBefore() == null) ? null : UtilForShips.dateRound(order.getBefore());
        Pageable pageCount = PageRequest.of(page.getPageNumber(), page.getPageSize(), Sort.by(page.getOrder().getFieldName()));

        return shipsRepository.findByOrder(order.getName(),
                order.getPlanet(),
                after,
                before,
                order.getMinCrewSize(),
                order.getMaxCrewSize(),
                order.getShipType(),
                order.getUsed(),
                order.getMaxSpeed(),
                order.getMinSpeed(),
                order.getMaxRating(),
                order.getMinRating(),
                pageCount);
    }


}
