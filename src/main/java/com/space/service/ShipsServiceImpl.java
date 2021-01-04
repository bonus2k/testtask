package com.space.service;

import com.space.controller.Order;
import com.space.controller.Page;
import com.space.controller.ShipOrder;
import com.space.model.Ship;
import com.space.model.ShipType;
import com.space.repository.ShipsRepository;
import com.space.util.UtilForShips;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
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
        shipsRepository.delete(shipsRepository.findById(id).orElse(null));
    }

    @Override
    public List<Ship> paging(ShipOrder shipOrder, Integer pageNumber, Integer pageSize) {
        Pageable page;
        if (shipOrder == ShipOrder.ID) {
            page = PageRequest.of(pageNumber, pageSize, Sort.by(shipOrder.getFieldName()));
        } else {
            page = PageRequest.of(pageNumber, pageSize, Sort.by(shipOrder.getFieldName()).descending());
        }
        return shipsRepository.findAll(page).getContent();
    }

    @Override
    public Integer count() {
        return Math.toIntExact(shipsRepository.count());
    }

    @Override
    public List<Ship> findByName(Order order, Page page) {
        Date after = (order.getAfter()==null)?null:UtilForShips.dateRound(order.getAfter());
        Date before = (order.getBefore()==null)?null:UtilForShips.dateRound(order.getBefore());

        Pageable pageCount;
        if (page.getOrder() == ShipOrder.ID) {
            pageCount = PageRequest.of(page.getPageNumber(), page.getPageSize(), Sort.by(page.getOrder().getFieldName()));
        } else {
            pageCount = PageRequest.of(page.getPageNumber(), page.getPageSize(), Sort.by(page.getOrder().getFieldName()).descending());
        }

        return shipsRepository.findByOrder(order.getName(),
                order.getPlanet(),
                after,
                before,
                order.getMinCrewSize(),
                order.getMaxCrewSize(),
                order.getShipType(),
                order.getUsed(), pageCount);
//                .forEach(System.out::println);
//
//        System.out.println(after);
//        System.out.println(before);
//        System.out.println("---------------------------------------------------------------------");
//        return null;
    }


}
