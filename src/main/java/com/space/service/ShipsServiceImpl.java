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

    @Transactional
    @Override
    public Ship update(Ship src, Long id) {
        Ship target = shipsRepository.findById(id).orElse(null);

        UtilForShips.copyNonNullProperties(src, target);
        target.setRating(target.countRating());
        shipsRepository.update(target.getName(), target.getPlanet(), target.getShipType(), target.getProdDate(),
                target.getUsed(), target.getSpeed(), target.getCrewSize(), target.getRating(), id);

        return target;

    }

    public Boolean isExist(Long id) {
        return shipsRepository.existsById(id);
    }

    @Override
    public Ship save(Ship ship) {
        boolean isUsed = (ship.getUsed()==null)?false:ship.getUsed();
        ship.setUsed(isUsed);
        ship.setRating(ship.countRating());
        shipsRepository.save(ship);
        return ship;
    }

    @Transactional
    @Override
    public void delete(Long id) {
        shipsRepository.deleteById(id);
    }

    @Override
    public Integer count(Order order) {
        Date after = (order.getAfter() == null) ? null : UtilForShips.getDateForYear(UtilForShips.getYearFromDate(new Date(order.getAfter())));
        Date before = (order.getBefore() == null) ? null : UtilForShips.getDateForYear(UtilForShips.getYearFromDate(new Date(order.getBefore())));

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
        Date after = (order.getAfter() == null) ? null : UtilForShips.getDateForYear(UtilForShips.getYearFromDate(new Date(order.getAfter())));
        Date before = (order.getBefore() == null) ? null : UtilForShips.getDateForYear(UtilForShips.getYearFromDate(new Date(order.getBefore())));
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
