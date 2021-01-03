package com.space.service;

import com.space.model.Ship;
import com.space.repository.ShipsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
//@Transactional(readOnly = true)
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
}
